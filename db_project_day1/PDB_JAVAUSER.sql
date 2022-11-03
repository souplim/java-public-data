--DROP TABLE SUBJECT;
--DROP TABLE STUDENT;
--DROP TABLE LESSON;

-- 학과테이블 생성
CREATE TABLE SUBJECT(
    NO NUMBER(4) NOT NULL,                       -- 일련번호. 자리수 생각하면 NUMBER가 가지고 있는 자리수 만큼 다 사용 가능
    S_NUM VARCHAR(2) NOT NULL,                   -- 학과번호
    S_NAME VARCHAR2(30) NOT NULL,                -- 학과명
    
    CONSTRAINT SUBJECT_NO_PK PRIMARY KEY(NO),
    CONSTRAINT SUBJECT_S_NUM_UK UNIQUE(S_NUM)    -- 학과번호는 유일해야 함(유일키)
);

-- 학과테이블 데이터 입력
INSERT INTO SUBJECT VALUES(1, '01', '컴퓨터학과');
INSERT INTO SUBJECT VALUES(2, '02', '교육학과');
INSERT INTO SUBJECT VALUES(3, '03', '신문방송학과');
INSERT INTO SUBJECT VALUES(4, '04', '인터넷비즈니스과');
INSERT INTO SUBJECT VALUES(5, '05', '기술경영과');

SELECT * FROM SUBJECT;

-- 학생테이블 생성
CREATE TABLE STUDENT(
    NO NUMBER(4) NOT NULL,                  -- 일련번호
    SD_NUM VARCHAR(8) NOT NULL,             -- 학번
    SD_NAME VARCHAR2(12) NOT NULL,          -- 이름
    SD_ID VARCHAR2(10) NOT NULL,            -- 아이디
    SD_PASSWD VARCHAR2(20) NOT NULL,        -- 비밀번호
    S_NUM CHAR(2) NOT NULL,                 -- 학과번호
    SD_BIRTH CHAR(8) NOT NULL,              -- 생년월일
    SD_PHONE CHAR(13) NOT NULL,             -- 핸드폰
    SD_ADDRESS VARCHAR2(20 CHAR) NOT NULL,  -- 주소
    SD_EMAIL VARCHAR2(30) NOT NULL,         -- 이메일
    SD_DATE DATE DEFAULT SYSDATE,           -- 등록일자
   
    CONSTRAINT STUDENT_NO_PK PRIMARY KEY(NO),
    CONSTRAINT STUDENT_SD_NUM_UK UNIQUE(SD_NUM),
    CONSTRAINT STUDENT_SD_ID_UK UNIQUE(SD_ID), -- 상식적으로 ID도 중복되면 안 됨
    CONSTRAINT STUDENT_S_NUM_FK FOREIGN KEY(S_NUM) REFERENCES SUBJECT(S_NUM) -- 학과테이블과 연결
);

-- 학생테이블 데이터 입력
INSERT INTO STUDENT
VALUES(1,06010001,'김정수','javajsp','1234','01','19920514','010-1234-1234','서울시 서대문구 창전동','kjs@gmail.com',SYSDATE);
INSERT INTO STUDENT
VALUES(2,95010002,'김수현','jdbcmania','4321','01','19840403','010-1234-1234','서울시 서초구 양재동','ksh@gmail.com',SYSDATE);
INSERT INTO STUDENT
VALUES(3,98040001,'공지영','gonji','1111','04','19870506','010-1234-1234','부산광역시 해운대구 반송동','kjy@gmail.com',SYSDATE);
INSERT INTO STUDENT
VALUES(4,02050001,'조수영','water','9987','05','19801213','010-1234-1234','대전광역시 중구 은행동','jsy@gmail.com',SYSDATE);
INSERT INTO STUDENT
VALUES(5,94040002,'최경란','novel','8765','04','19760708','010-1234-1234','경기도 수원시 장안구 이목동','ckr@gmail.com',SYSDATE);
INSERT INTO STUDENT
VALUES(6,08020001,'안익태','korea','4565','02','19881104','010-1234-1234','서울시 역삼동','ait@gmail.com',SYSDATE);
SELECT * FROM STUDENT;

SELECT * FROM STUDENT;

-- 과목테이블 생성
CREATE TABLE LESSON(
    NO NUMBER(4) NOT NULL,              -- 일련번호
    L_ABBRE VARCHAR2(20) NOT NULL,      -- 과목약어
    L_NAME VARCHAR2(20) NOT NULL,       -- 과목명
    
    CONSTRAINT LESSON_NO_PK PRIMARY KEY(NO),
    CONSTRAINT LESSON_L_ABBRE_UK UNIQUE(L_ABBRE)
);

-- 과목테이블 데이터 입력
INSERT INTO LESSON VALUES(1,'K','국어');
INSERT INTO LESSON VALUES(2,'M','수학');
INSERT INTO LESSON VALUES(3,'E','영어');
INSERT INTO LESSON VALUES(4,'H','역사');
INSERT INTO LESSON VALUES(5,'P','프로그래밍');
INSERT INTO LESSON VALUES(6,'D','데이터베이스');
INSERT INTO LESSON VALUES(7,'ED','교육학이론');

SELECT * FROM LESSON;

-- 수강테이블 생성
CREATE TABLE TRAINEE(
    NO NUMBER(4) PRIMARY KEY,                                               -- 일련번호
    SD_NUM CHAR(8) NOT NULL,                                                -- 학번
    L_ABBRE VARCHAR2(20) NOT NULL,                                          -- 과목약어
    T_SECTION VARCHAR2(10) CHECK(T_SECTION IN('CULTURE','MAJOR','MINOR')),  -- 과목구분
    T_DATE DATE DEFAULT SYSDATE,                                            -- 등록일자
    
    CONSTRAINT TRAINEE_SD_NUM_FK FOREIGN KEY(SD_NUM) REFERENCES STUDENT(SD_NUM), -- 학생테이블과 연결
    CONSTRAINT TRAINEE_L_ABBRE_FK FOREIGN KEY(L_ABBRE) REFERENCES LESSON(L_ABBRE)-- 과목테이블과 연결
);

-- 수강테이블 데이터 입력
INSERT INTO TRAINEE VALUES(1, 06010001, 'K', 'CULTURE', SYSDATE);
INSERT INTO TRAINEE VALUES(2, 95010002, 'E', 'MAJOR', SYSDATE);

SELECT * FROM TRAINEE;
