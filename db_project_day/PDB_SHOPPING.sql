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
    visitor_cnt NUMBER(3,0),                    -- 방문인원
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
FROM order_info O INNER JOIN reservation R ON O.reserv_no = R.reserv_no
WHERE R.cancel = 'N';

-- 3) 그룹화 분석(상품별 매출 계산 및 정렬)
-- 각 상품별 전체 매출액을 내림차순으로 출력한다.
SELECT I.product_name 상품명, SUM(O.sales) 매출
FROM order_info O INNER JOIN reservation R ON O.reserv_no = R.reserv_no
                  INNER JOIN item I ON O.item_id = I.item_id 
WHERE R.cancel = 'N'
GROUP BY I.product_name
ORDER BY SUM(O.sales) DESC;

-- 4) 시계열 분석(월별 상품 매출 분석)
-- 모든 상품의 월별 매출액을 출력한다.
SELECT SUBSTR(R.reserv_date,5,2) 월, SUM(O.sales) 매출
FROM order_info O INNER JOIN reservation R ON O.reserv_no = R.reserv_no
WHERE R.cancel = 'N'
GROUP BY SUBSTR(R.reserv_date,5,2)
ORDER BY SUBSTR(R.reserv_date,5,2);

-- 5) 시계열 분석(월별 매출 분석)
-- 월별 총 매출액과 온라인 전용 상품 매출액을 출력한다.
SELECT SUBSTR(R.reserv_date,5,2) 월, SUM(O.sales) 매출, SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales)) 전용상품매출
FROM order_info O INNER JOIN reservation R ON O.reserv_no = R.reserv_no
                  INNER JOIN item I ON O.item_id = I.item_id                
WHERE R.cancel = 'N'
GROUP BY SUBSTR(R.reserv_date,5,2)
ORDER BY SUBSTR(R.reserv_date,5,2);

-- 6) 산술 계산(매출 기여율)
-- 분석5에 매출 기여율을 추가한다. 기여율은 Round 명령어로 소수점 두 번째 자리에서 반올림한다.
-- 전체 상품 매출에서 온라인 전용 상품 매출을 빼면 전용 상품 외 매출이다. 
SELECT SUBSTR(R.reserv_date,5,2) 월, SUM(O.sales) 매출, SUM(O.sales)-SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales)) 전용상품외매출,
        SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales)) 전용상품매출, 
        ROUND((SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales, 0))/SUM(O.sales)*100),1) "전용상품 매출 기여율"
FROM order_info O INNER JOIN reservation R ON O.reserv_no = R.reserv_no
                  INNER JOIN item I ON O.item_id = I.item_id                
WHERE R.cancel = 'N'
GROUP BY SUBSTR(R.reserv_date,5,2)
ORDER BY SUBSTR(R.reserv_date,5,2);

-- 7) 외부 조인(부족한 데이터 처리)
-- 분석6에 총 예약 건수와 예약 취소 건수를 추가한다.
SELECT SUBSTR(R.reserv_date,5,2) 월, SUM(O.sales) 매출, SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales)) 전용상품매출,
        ROUND((SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales))/SUM(O.sales)*100),1) "전용상품 매출 기여율",
        COUNT(R.reserv_no) 총예약건수, COUNT(DECODE(R.cancel, 'Y', R.cancel)) 예약취소건수
FROM order_info O RIGHT OUTER JOIN reservation R ON O.reserv_no = R.reserv_no
                  LEFT OUTER JOIN item I ON O.item_id = I.item_id                
GROUP BY SUBSTR(R.reserv_date,5,2)
ORDER BY SUBSTR(R.reserv_date,5,2);

-- 8)데이터 처리(날짜 가공, 문자 붙이기)
-- 분석7에 총 매출 대비 온라인 전용 상품의 판매율, 총 예약 건 대비 예약 취소율을 추가한다. 
-- 소수점이 나올 경우 소수점 두 번째에서 반올림하여 xx.x% 형식으로 출력한다.
SELECT SUBSTR(R.reserv_date,5,2) 월, SUM(O.sales) 매출, SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales)) 전용상품매출,
        ROUND((SUM(DECODE(I.product_desc, '온라인_전용상품', O.sales))/SUM(O.sales)*100),1)||'%' "전용상품 판매율",
        COUNT(R.reserv_no) 총예약건수, COUNT(DECODE(R.cancel, 'Y', R.cancel)) 예약취소건수,
        ROUND((COUNT(DECODE(R.cancel, 'Y', R.cancel))/COUNT(R.reserv_no))*100,1)||'%' 예약취소율
FROM order_info O RIGHT OUTER JOIN reservation R ON O.reserv_no = R.reserv_no
                  LEFT OUTER JOIN item I ON O.item_id = I.item_id                
GROUP BY SUBSTR(R.reserv_date,5,2)
ORDER BY SUBSTR(R.reserv_date,5,2);

-- 9) 요일별 매출 분석(날짜 처리)
-- 월별 온라인 전용 상품 매출액을 일요일부터 월요일까지 구분해서 출력한다.
SELECT TO_CHAR(TO_DATE(reserv_date), 'YYYY/MM/DD DAY') FROM reservation;
SELECT SUBSTR(TO_CHAR(TO_DATE(reserv_date), 'YYYY/MM/DD DAY'),12,1) FROM reservation;

SELECT SUBSTR(R.reserv_date,5,2) 월, SUM(DECODE(R.요일, '일', O.sales, 0)) 일요일, SUM(DECODE(R.요일, '월', O.sales, 0)) 월요일, 
        SUM(DECODE(R.요일, '화', O.sales, 0)) 화요일, SUM(DECODE(R.요일, '수', O.sales, 0)) 수요일, SUM(DECODE(R.요일, '목', O.sales, 0)) 목요일,
        SUM(DECODE(R.요일, '금', O.sales, 0)) 금요일, SUM(DECODE(R.요일, '토', O.sales, 0)) 토요일
FROM order_info O RIGHT OUTER JOIN (SELECT reserv_no, reserv_date, SUBSTR(TO_CHAR(TO_DATE(reserv_date), 'YYYY/MM/DD DAY'),12,1) 요일 FROM reservation) R
ON O.reserv_no = R.reserv_no
                  LEFT OUTER JOIN item I ON O.item_id = I.item_id  
WHERE I.product_desc = '온라인_전용상품'
GROUP BY SUBSTR(R.reserv_date,5,2)
ORDER BY SUBSTR(R.reserv_date,5,2);

-- 10) 순위 분석(월별 온라인 전용 상품 최대 실적 지점 확인) -- ?
-- 월별 온라인 전용 상품 매출 1위부터 3위까지 지점이 어딘지 출력한다.
SELECT distinct branch FROM reservation; -- 25지점
SELECT * FROM reservation;

SELECT SUBSTR(R.reserv_date,5,2) 월, R.branch 지점, SUM(O.sales) 전용상품매출, ROW_NUMBER() OVER (ORDER BY SUM(O.sales) DESC) 순위
FROM order_info O RIGHT OUTER JOIN (SELECT reserv_no, reserv_date, branch FROM reservation) R ON O.reserv_no = R.reserv_no
                  LEFT OUTER JOIN item I ON O.item_id = I.item_id  
WHERE (I.product_desc = '온라인_전용상품')
GROUP BY SUBSTR(R.reserv_date,5,2), R.branch
ORDER BY SUM(O.sales) DESC;

-- 11) 종합 리포트 작정
-- 분석8과 분석10의 결과 항목을 월별로 합쳐서 리포트를 출력한다.

-- 2. 인구 통계 분석
-- 기본적인 인구 통계 정보를 출력한다. 나이, 성별, 주거지 비율, 거래 기간을 알아본다. 
-- 대부분의 정보는 customer 테이블에 존재한다. 
-- 주거지 정보는 address 테이블과 조인하고 나이와 거래 기간은 months_between 함수를 이용해 계산한다.

-- 1) 인구 특징 통계 분석
-- 고객의 수, 남녀 숫자, 평균 나이, 평균 거래 기간을 출력한다.
SELECT TO_DATE(first_reg_date) FROM customer;
SELECT TO_DATE(SYSDATE) FROM DUAL;
SELECT ROUND(AVG(MONTHS_BETWEEN(SYSDATE, TO_DATE(birth))/12),1) FROM customer;

SELECT COUNT(*), COUNT(DECODE(SEX_CODE,'F',CUSTOMER_ID)) 여성, COUNT(DECODE(SEX_CODE,'M',CUSTOMER_ID)) 남성, 
        ROUND(AVG(MONTHS_BETWEEN(SYSDATE, TO_DATE(birth))/12),1) 나이, ROUND(AVG(MONTHS_BETWEEN(SYSDATE, TO_DATE(first_reg_date))/12),1) 평균거래기간
FROM customer;

-- 2) 개인별 매출 분석
-- 개인별 전체 주문 건수, 총 매출, 온라인 전용 상품 주문 건수, 전용 상품 매출을 출력하여 온라인 전용 상품의 매출 기준으로 내림차순 한다.
SELECT * FROM customer;
SELECT * FROM reservation;

SELECT C.customer_id, count(*), COUNT(DECODE(O.item_id, 'M0001', O.order_no)) 전용상품주문건수, SUM(DECODE(O.item_id, 'M0001', O.sales, 0)) 전용상품매출
FROM reservation R INNER JOIN customer C ON R.customer_id = C.customer_id
                   LEFT OUTER JOIN order_info O ON O.reserv_no = R.reserv_no
GROUP BY C.customer_id
ORDER BY SUM(DECODE(O.item_id, 'M0001', O.sales, 0)) DESC;

-- 3) 주거지와 직업의 비율 분석
-- 상품을 구매한 전체 고객의 주거지와 온라인 전용 상품을 구매한 고객의 주거지를 비교해 보고  
-- 상품을 구매한 전체 고객의 직업과 온라인 전용 상품으로 구매한 고객의 직업을 비교하여 출력한다
SELECT * FROM customer;
SELECT * FROM address;
-- 거주지
SELECT DISTINCT A.address_detail 주소, COUNT(C.customer_id) 전체상품구매고객, COUNT(DECODE(O.item_id, 'M0001', C.customer_id)) 온라인전용상품구매고객
FROM customer C INNER JOIN address A ON C.zip_code = A.zip_code
                INNER JOIN reservation R ON R.customer_id = C.customer_id
                LEFT OUTER JOIN order_info O ON R.reserv_no = O.reserv_no       
WHERE R.cancel = 'N'
GROUP BY A.address_detail
ORDER BY COUNT(C.customer_id) DESC, COUNT(DECODE(O.item_id, 'M0001', C.customer_id)) DESC;
-- 직업
SELECT DISTINCT C.JOB 직업, COUNT(C.customer_id) 전체상품구매고객, COUNT(DECODE(O.item_id, 'M0001', C.customer_id)) 온라인전용상품구매고객
FROM customer C INNER JOIN address A ON C.zip_code = A.zip_code
                INNER JOIN reservation R ON R.customer_id = C.customer_id
                LEFT OUTER JOIN order_info O ON R.reserv_no = O.reserv_no       
WHERE R.cancel = 'N'
GROUP BY C.JOB
ORDER BY COUNT(C.customer_id) DESC, COUNT(DECODE(O.item_id, 'M0001', C.customer_id)) DESC;
