DROP TABLE SUBJECT;
DROP TABLE STUDENT;
DROP TABLE LESSON;
DROP TABLE TRAINEE;
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
    S_NUM VARCHAR(2) NOT NULL,              -- 학과번호(학과테이블)
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
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
VALUES(1,06010001,'김정수','javajsp','1234','01','19920514','010-1234-1234','서울시 서대문구 창전동','kjs@gmail.com');
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
VALUES(2,95010002,'김수현','jdbcmania','4321','01','19840403','010-1234-1234','서울시 서초구 양재동','ksh@gmail.com');
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
VALUES(3,98040001,'공지영','gonji','1111','04','19870506','010-1234-1234','부산광역시 해운대구 반송동','kjy@gmail.com');
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
VALUES(4,02050001,'조수영','water','9987','05','19801213','010-1234-1234','대전광역시 중구 은행동','jsy@gmail.com');
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
VALUES(5,94040002,'최경란','novel','8765','04','19760708','010-1234-1234','경기도 수원시 장안구 이목동','ckr@gmail.com');
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
VALUES(6,08020001,'안익태','korea','4565','02','19881104','010-1234-1234','서울시 역삼동','ait@gmail.com');

SELECT * FROM STUDENT;

-- 과목테이블 생성
CREATE TABLE LESSON(
    NO NUMBER(4) NOT NULL,              -- 일련번호
    L_ABBRE VARCHAR2(2) NOT NULL,       -- 과목약어
    L_NAME VARCHAR2(20) NOT NULL,       -- 과목명
    
    CONSTRAINT LESSON_NO_PK PRIMARY KEY(NO),
    CONSTRAINT LESSON_L_ABBRE_UK UNIQUE(L_ABBRE)
);

-- 과목테이블 데이터 입력
INSERT INTO LESSON(NO, L_ABBRE, L_NAME) VALUES(1,'K','국어');
INSERT INTO LESSON(NO, L_ABBRE, L_NAME) VALUES(2,'M','수학');
INSERT INTO LESSON(NO, L_ABBRE, L_NAME) VALUES(3,'E','영어');
INSERT INTO LESSON(NO, L_ABBRE, L_NAME) VALUES(4,'H','역사');
INSERT INTO LESSON(NO, L_ABBRE, L_NAME) VALUES(5,'P','프로그래밍');
INSERT INTO LESSON(NO, L_ABBRE, L_NAME) VALUES(6,'D','데이터베이스');
INSERT INTO LESSON(NO, L_ABBRE, L_NAME) VALUES(7,'ED','교육학이론');

SELECT * FROM LESSON;

-- 수강테이블 생성
CREATE TABLE TRAINEE(
    NO NUMBER(4) PRIMARY KEY,                                               -- 일련번호
    SD_NUM VARCHAR(8) NOT NULL,                                             -- 학번(학생테이블)
    L_ABBRE VARCHAR2(2) NOT NULL,                                           -- 과목약어(과목테이블)
    T_SECTION VARCHAR2(10) CHECK(T_SECTION IN('CULTURE','MAJOR','MINOR')),  -- 과목구분
    T_DATE DATE DEFAULT SYSDATE,                                            -- 등록일자
    
    CONSTRAINT TRAINEE_SD_NUM_FK FOREIGN KEY(SD_NUM) REFERENCES STUDENT(SD_NUM), -- 학생테이블과 연결
    CONSTRAINT TRAINEE_L_ABBRE_FK FOREIGN KEY(L_ABBRE) REFERENCES LESSON(L_ABBRE)-- 과목테이블과 연결
);

-- 수강테이블 데이터 입력
INSERT INTO TRAINEE(NO, SD_NUM, L_ABBRE, T_SECTION) VALUES(1, 06010001, 'K', 'CULTURE');
INSERT INTO TRAINEE(NO, SD_NUM, L_ABBRE, T_SECTION) VALUES(2, 95010002, 'E', 'MAJOR');

SELECT * FROM TRAINEE;

-- 1. 학번, 학생명과 학과번호, 학과명을 출력하도록 쿼리문 작성
SELECT SD_NUM 학번, SD_NAME 학생명, S.S_NUM 학과번호, S_NAME 학과명
FROM SUBJECT SB, STUDENT S
WHERE SB.S_NUM = S.S_NUM;

-- 2. 우리 학교 전체 학과명과 그 학과에 소속된 학생명, 아이디를 출력하도록 쿼리문 작성(아직 학생 안 받은 학과 있음)
SELECT * FROM SUBJECT;
SELECT * FROM STUDENT;
SELECT SB.S_NAME 학과명, S.SD_NAME 학생명, S.SD_ID 아이디
FROM SUBJECT SB, STUDENT S
WHERE SB.S_NUM = S.S_NUM(+);

-- 3. 학과에 소속된 학생 수를 출력하도록 쿼리문 작성
SELECT S.S_NUM 학과명, COUNT(S_NAME) 학생수
FROM SUBJECT SB, STUDENT S
WHERE  SB.S_NUM = S.S_NUM
GROUP BY S.S_NUM, S.SD_NAME;

SELECT S.S_NAME 학과명, COUNT(S_NUM) 학생수
FROM SUBJECT SB INNER JOIN STUDENT S
ON SB.S_NUM = S.S_NUM
GROUP BY S.SD_NAME;

-- 4. 전체 학과명에 소속된 학생 수를 출력하도록 쿼리문 작성해주세요(ANSI 조인)
SELECT S.S_NUM 학과명, COUNT(S_NAME) 학생수
FROM SUBJECT SB INNER JOIN STUDENT S
ON  SB.S_NUM = S.S_NUM
GROUP BY S.S_NUM, S.SD_NAME;

-- 5. 수강테이블(TRAINEE)에서 수강 신청한 학생명, 과목명, 등록일(2018.12.28. 형태)을 출력하도록 쿼리문 작성(테이블3개)
SELECT ST.SD_NAME 학생명, L_NAME 과목명, TO_CHAR(TR.T_DATE,'YYYY.MM.DD') 등록일
FROM TRAINEE TR INNER JOIN STUDENT ST ON TR.SD_NUM = ST.SD_NUM
                INNER JOIN LESSON LE ON TR.L_ABBRE = LE.L_ABBRE;
                
-- 5-1. 수강테이블(TRAINEE)에서 수강 신청한 학과명, 학생명, 과목명, 등록일(2018.12.28. 형태)을 출력하도록 쿼리문 작성(테이블4개)                
SELECT ST.S_NUM 학과명, ST.SD_NAME 학생명, L_NAME 과목명, TO_CHAR(TR.T_DATE,'YYYY.MM.DD') 등록일
FROM STUDENT ST INNER JOIN SUBJECT SB ON ST.S_NUM = SB.S_NUM
                INNER JOIN TRAINEE TR ON TR.SD_NUM = ST.SD_NUM
                INNER JOIN LESSON LE ON TR.L_ABBRE = LE.L_ABBRE;                
        
