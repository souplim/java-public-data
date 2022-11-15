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
    price NUMBER NOT NULL                       -- 상품가격
);

ALTER TABLE item
ADD CONSTRAINT pk_item_id PRIMARY KEY(item_id);

CREATE TABLE reservation(
    reserv_no VARCHAR2(30),                     -- 예약번호
    reserv_date VARCHAR2(8) NOT NULL,           -- 예약날짜
    reserv_time VARCHAR2(4) NOT NULL,           -- 예약시간
    customer_id VARCHAR2(10) NOT NULL,          -- 고객번호, customer에 외래키
    branch VARCHAR2(20),                        -- 지점명
    visitor_cnt NUMBER(3),                      -- 방문인원
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
    quantity NUMBER(3),                         -- 수량
    sales NUMBER(10)                            -- 매출액
);

ALTER TABLE order_info
ADD CONSTRAINT pk_order_no PRIMARY KEY(order_no);
ALTER TABLE order_info
ADD CONSTRAINT fk_order_info_item_id FOREIGN KEY(item_id) REFERENCES item(item_id);
ALTER TABLE order_info
ADD CONSTRAINT fk_order_info_reserv_no FOREIGN KEY(reserv_no) REFERENCES reservation(reserv_no);

-- 1. 매출 분석
-- 전체 매출에 대한 특정 통계 값을 확인한다.
-- 기본적으로 전체 상품의 주문 완료 건, 총 매출, 평균 매출, 최고 매출, 최저매출의 결과값을 확인한다.

-- 1) 특정 통계값 계산
-- 전체 상품의 주문 완료 건, 총 매출, 평균 매출, 최고 매출, 최저 매출을 출력한다.
SELECT COUNT(order_no), SUM(sales), ROUND(AVG(sales)), MAX(sales), MIN(sales)
FROM order_info;

-- 2) 비교 분석(판매량과 매출액 비교)
-- 전체 상품의 총 판매량과 총 매출액, 온라인 전용 상품의 판매량과 매출액을 출력한다.
SELECT COUNT(quantity), SUM(sales), COUNT(DECODE(item_id, 'M0001', quantity)), SUM(DECODE(item_id, 'M0001', sales))
FROM order_info;

SELECT COUNT(O.quantity), SUM(O.sales), COUNT(DECODE(I.product_desc, '온라인_전용상품', O.quantity)), SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales))
FROM order_info O INNER JOIN item I ON O.item_id = I.item_id;

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
