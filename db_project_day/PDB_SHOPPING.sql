CREATE TABLE address(
    zip_code VARCHAR2(5),
    address_detail VARCHAR2(50), NOT NULL
);

ALTER TABLE address
ADD CONSTRAINT pk_zip_code PRIMARY KEY(zip_code);


CREATE TABLE customer(
    customer_id VARCHAR2(10),
    customer_name VARCHAR2(20) NOT NULL,
    phone_number VARCHAR2(15) NOT NULL,
    email VARCHAR2(50) NOT NULL
    first_reg_date DATE,
    sex_code VARCHAR2(2),
    birth VARCHAR2(8),
    job VARCHAR2(50),
    zip_code VARCHAR2(5)
);

ALTER TABLE customer
ADD CONSTRAINT pk_cusomer_id PRIMARY KEY(customer_id);
ALTER TABLE customer
ADD CONSTRAINT kf_customer_zip_code FOREIGN KEY(zip_code) REFERENCES address(zip_code);

CREATE TABLE item(
    item_id VARCHAR2(10),
    product_name VARCHAR2(50) NOT NULL,
    product_desc VARCHAR2(100) NOT NULL,
    category_id VARCHAR2(10) NOT NULL,
    price NUMBER NOT NULL
);

ALTER TABLE item
ADD CONSTRAINT pk_item_id PRIMARY KEY(item_id);

CREATE TABLE reservation(
    reserv_no VARCHAR2(30),
    reserv_date VARCHAR2(8) NOT NULL,
    reserv_time VARCHAR2(4) NOT NULL,
    customer_id VARCHAR2(10) NOT NULL,
    branch VARCHAR2(20),
    visitor_cnt NUMBER(3),
    cancel VARCHAR2(1)
);

ALTER TABLE reservation
ADD CONSTRAINT pk_reserv_no PRIMARY KEY(reserv_no);
ALTER TABLE reservation
ADD CONSTRAINT fk_reservation_customer_id FOREIGN KEY(customer_id) REFERENCES customer(customer_id);

CREATE TABLE order_info(
    order_no VARCHAR2(30),
    item_id VARCHAR2(10) NOT NULL,
    reserv_no VARCHAR2(30) NOT NULL,
    quantity NUMBER(3),
    sales NUMBER(10)
);

ALTER TABLE order_info
ADD CONSTRAINT pk_order_no PRIMARY KEY(order_no);
ALTER TABLE order_info
ADD CONSTRAINT fk_order_info_item_id FOREIGN KEY(item_id) REFERENCES item(item_id);
ALTER TABLE order_info
ADD CONSTRAINT fk_order_info_reserv_no FOREIGN KEY(reserv_no) REFERENCES reservation(reserv_no);