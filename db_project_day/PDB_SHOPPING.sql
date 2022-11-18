DROP TABLE address;
DROP TABLE customer;
DROP TABLE item;
DROP TABLE reservation;
DROP TABLE order_info;

CREATE TABLE address(
    zip_code VARCHAR2(5),                   -- 우편번호
    address_detail VARCHAR2(50) NOT NULL    -- 상세주소
);

ALTER TABLE address
ADD CONSTRAINT pk_zip_code PRIMARY KEY(zip_code);


CREATE TABLE customer(
    customer_id VARCHAR2(10),               -- 고객번호
    customer_name VARCHAR2(20) NOT NULL,    -- 고객명
    phone_number VARCHAR2(15) NOT NULL,     -- 전화번호
    email VARCHAR2(50) NOT NULL,            -- 이메일
    first_reg_date DATE,                    -- 등록일
    sex_code VARCHAR2(2),                   -- 성별
    birth VARCHAR2(8),                      -- 생년월일
    job VARCHAR2(50),                       -- 직업
    zip_code VARCHAR2(5)                    -- 우편번호, address에 외래키
);

ALTER TABLE customer
ADD CONSTRAINT pk_cusomer_id PRIMARY KEY(customer_id);
ALTER TABLE customer
ADD CONSTRAINT kf_customer_zip_code FOREIGN KEY(zip_code) REFERENCES address(zip_code);

CREATE TABLE item(
    item_id VARCHAR2(10),                       -- 상품번호
    product_name VARCHAR2(50) NOT NULL,         -- 상품명
    product_desc VARCHAR2(100) NOT NULL,        -- 상품상세
    category_id VARCHAR2(10) NOT NULL,          -- 카테고리번호
    price NUMBER(10,0) NOT NULL                       -- 상품가격
);

ALTER TABLE item
ADD CONSTRAINT pk_item_id PRIMARY KEY(item_id);

CREATE TABLE reservation(
    reserv_no VARCHAR2(30),                     -- 예약번호
    reserv_date VARCHAR2(8) NOT NULL,           -- 예약날짜
    reserv_time VARCHAR2(4) NOT NULL,           -- 예약시간
    customer_id VARCHAR2(10) NOT NULL,          -- 고객번호, customer에 외래키
    branch VARCHAR2(20),                        -- 지점명
    visitor_cnt NUMBER(3,0),                      -- 방문인원
    cancel VARCHAR2(1)                          -- 취소여부
);

ALTER TABLE reservation
ADD CONSTRAINT pk_reserv_no PRIMARY KEY(reserv_no);
ALTER TABLE reservation
ADD CONSTRAINT fk_reservation_customer_id FOREIGN KEY(customer_id) REFERENCES customer(customer_id);

CREATE TABLE order_info(
    order_no VARCHAR2(30),                      -- 주문번호
    item_id VARCHAR2(10) NOT NULL,              -- 상품번호
    reserv_no VARCHAR2(30) NOT NULL,            -- 예약번호
    quantity NUMBER(3,0),                         -- 수량
    sales NUMBER(10,0)                            -- 매출액
);

ALTER TABLE order_info
ADD CONSTRAINT pk_order_no PRIMARY KEY(order_no, item_id);
ALTER TABLE order_info
ADD CONSTRAINT fk_order_info_item_id FOREIGN KEY(item_id) REFERENCES item(item_id);
ALTER TABLE order_info
ADD CONSTRAINT fk_order_info_reserv_no FOREIGN KEY(reserv_no) REFERENCES reservation(reserv_no);

-- <통계 예제>
-- 1. 매출 분석
-- 전체 매출에 대한 특정 통계 값을 확인한다.
-- 기본적으로 전체 상품의 주문 완료 건, 총 매출, 평균 매출, 최고 매출, 최저매출의 결과값을 확인한다.

-- 1) 특정 통계값 계산
-- 전체 상품의 주문 완료 건, 총 매출, 평균 매출, 최고 매출, 최저 매출을 출력한다.
SELECT COUNT(order_no) 전체주문건, SUM(sales) 총매출, ROUND(AVG(sales)) 평균매출, MAX(sales) 최고매출, MIN(sales) 최저매출
FROM order_info O INNER JOIN reservation R ON O.reserv_no = R.reserv_no
WHERE R.cancel = 'N';

-- 2) 비교 분석(판매량과 매출액 비교)
-- 전체 상품의 총 판매량과 총 매출액, 온라인 전용 상품의 판매량과 매출액을 출력한다.
SELECT COUNT(quantity) 총판매량, SUM(sales) 총매출, 
        COUNT(DECODE(item_id, 'M0001', quantity)) 전용상품판매량, 
        SUM(DECODE(item_id, 'M0001', sales)) 전용상품매출
FROM order_info
WHERE R.cancel = 'N';

SELECT COUNT(O.quantity), SUM(O.sales), 
        COUNT(DECODE(I.product_desc, '온라인_전용상품', O.quantity)) 전용상품판매량, 
        SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales)) 전용상품매출
FROM order_info O INNER JOIN item I ON O.item_id = I.item_id
WHERE R.cancel = 'N';

-- 3) 그룹화 분석(상품별 매출 계산 및 정렬)
-- 각 상품별 전체 매출액을 내림차순으로 출력한다.
SELECT I.product_name, SUM(O.sales) sales
FROM order_info O INNER JOIN item I ON O.item_id = I.item_id
GROUP BY I.product_name
ORDER BY SUM(O.sales) DESC;

-- 4) 시계열 분석(월별 상품 매출 분석)
-- 모든 상품의 월별 매출액을 출력한다.
SELECT SUBSTR(R.reserv_date,5,2) month, SUM(O.sales) sales
FROM order_info O INNER JOIN reservation R ON O.reserv_no = R.reserv_no
GROUP BY SUBSTR(R.reserv_date,5,2)
ORDER BY SUBSTR(R.reserv_date,5,2);

-- 5) 시계열 분석(월별 매출 분석)
-- 월별 총 매출액과 온라인 전용 상품 매출액을 출력한다.
SELECT SUBSTR(R.reserv_date,5,2) month, SUM(O.sales) sales, SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales)) online_sales
FROM order_info O INNER JOIN reservation R ON O.reserv_no = R.reserv_no
                  INNER JOIN item I ON O.item_id = I.item_id                
GROUP BY SUBSTR(R.reserv_date,5,2)
ORDER BY SUBSTR(R.reserv_date,5,2);

-- 6) 산술 계산(매출 기여율)
-- 분석5에 매출 기여율을 추가한다. 기여율은 Round 명령어로 소수점 두 번째 자리에서 반올림한다.
-- 전체 상품 매출에서 온라인 전용 상품 매출을 빼면 전용 상품 외 매출이다. 
SELECT SUBSTR(R.reserv_date,5,2) month, SUM(O.sales) sales, SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales)) online_sales,
        ROUND((SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales))/SUM(O.sales)*100),1) "전용상품 매출 기여율"
FROM order_info O INNER JOIN reservation R ON O.reserv_no = R.reserv_no
                  INNER JOIN item I ON O.item_id = I.item_id                
GROUP BY SUBSTR(R.reserv_date,5,2)
ORDER BY SUBSTR(R.reserv_date,5,2);

-- 7) 외부 조인(부족한 데이터 처리)
-- 분석6에 총 예약 건수와 예약 취소 건수를 추가한다.
SELECT SUBSTR(R.reserv_date,5,2) month, SUM(O.sales) sales, SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales)) online_sales,
        ROUND((SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales))/SUM(O.sales)*100),1) "전용상품 매출 기여율",
        COUNT(R.reserv_no) "총 예약 건수", COUNT(DECODE(R.cancel, 'Y', R.cancel)) "예약 취소 건수"
FROM order_info O RIGHT OUTER JOIN reservation R ON O.reserv_no = R.reserv_no
                  LEFT OUTER JOIN item I ON O.item_id = I.item_id                
GROUP BY SUBSTR(R.reserv_date,5,2)
ORDER BY SUBSTR(R.reserv_date,5,2);
