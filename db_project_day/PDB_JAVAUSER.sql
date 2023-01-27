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

-- 학과 테이블 일련번호 자동 증가시키는 시퀀스 생성
CREATE SEQUENCE SUBJECT_SEQ
START WITH 6
INCREMENT BY 1
MINVALUE 1
MAXVALUE 100000
NOCYCLE
CACHE 2;
-- DROP SEQUENCE SUBJECT_SEQ;
-- 시작 번호 잘못 작게 주었을 때 아래 코드로 일련번호 높인 후 데이터 추가
-- SELECT SUBJECT_SEQ.NEXTVAL FROM DUAL;

INSERT INTO SUBJECT VALUES(SUBJECT_SEQ.NEXTVAL, '06', '경제학과');
INSERT INTO SUBJECT VALUES(SUBJECT_SEQ.NEXTVAL, '07', '통계학과');
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
VALUES(1,'06010001','김정수','javajsp','1234','01','19920514','010-1234-1234','서울시 서대문구 창전동','kjs@gmail.com');
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
VALUES(2,'95010002','김수현','jdbcmania','4321','01','19840403','010-1234-1234','서울시 서초구 양재동','ksh@gmail.com');
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
VALUES(3,'98040001','공지영','gonji','1111','04','19870506','010-1234-1234','부산광역시 해운대구 반송동','kjy@gmail.com');
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
VALUES(4,'02050001','조수영','water','9987','05','19801213','010-1234-1234','대전광역시 중구 은행동','jsy@gmail.com');
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
VALUES(5,'94040002','최경란','novel','8765','04','19760708','010-1234-1234','경기도 수원시 장안구 이목동','ckr@gmail.com');
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
VALUES(6,'08020001','안익태','korea','4565','02','19881104','010-1234-1234','서울시 역삼동','ait@gmail.com');

SELECT * FROM STUDENT;

-- 학생 테이블 일련번호 시퀀스 생성
CREATE SEQUENCE STUDENT_SEQ
START WITH 7
INCREMENT BY 1
MINVALUE 1
MAXVALUE 100000
NOCYCLE
CACHE 2;

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

-- 과목 테이블 일련번호 시퀀스 생성
CREATE SEQUENCE LESSON_SEQ
START WITH 8
INCREMENT BY 1
MINVALUE 1
MAXVALUE 100000
NOCYCLE
CACHE 2;

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
INSERT INTO TRAINEE(NO, SD_NUM, L_ABBRE, T_SECTION) VALUES(1, '06010001', 'K', 'CULTURE');
INSERT INTO TRAINEE(NO, SD_NUM, L_ABBRE, T_SECTION) VALUES(2, '95010002', 'E', 'MAJOR');

SELECT * FROM TRAINEE;

-- 수강 테이블 일련번호 시퀀스 생성
CREATE SEQUENCE TRAINEE_SEQ
START WITH 3
INCREMENT BY 1
MINVALUE 1
MAXVALUE 100000
NOCYCLE
CACHE 2;

-- <예제>
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
-- ANSI JOIN
SELECT ST.SD_NAME 학생명, L_NAME 과목명, TO_CHAR(TR.T_DATE,'YYYY.MM.DD') 등록일
FROM TRAINEE TR INNER JOIN STUDENT ST ON TR.SD_NUM = ST.SD_NUM
                INNER JOIN LESSON LE ON TR.L_ABBRE = LE.L_ABBRE;
-- ORACLE JOIN
SELECT ST.SD_NAME 학생명, L_NAME 과목명, TO_CHAR(TR.T_DATE,'YYYY.MM.DD') 등록일
FROM TRAINEE TR ,STUDENT ST, LESSON LE
WHERE TR.SD_NUM = ST.SD_NUM AND TR.L_ABBRE = LE.L_ABBRE;
                
-- 5-1. 수강테이블(TRAINEE)에서 수강 신청한 학과명, 학생명, 과목명, 등록일(2018.12.28.형태)을 출력하도록 쿼리문 작성(테이블4개)                
SELECT ST.S_NUM 학과명, ST.SD_NAME 학생명, L_NAME 과목명, TO_CHAR(TR.T_DATE,'YYYY.MM.DD') 등록일
FROM STUDENT ST INNER JOIN SUBJECT SB ON ST.S_NUM = SB.S_NUM
                INNER JOIN TRAINEE TR ON TR.SD_NUM = ST.SD_NUM
                INNER JOIN LESSON LE ON TR.L_ABBRE = LE.L_ABBRE;                
        
-- <뷰 예제>
-- 1. 학번, 학생명, 학과명을 출력하는 뷰(VIEW_STUDENT)를 작성하라
CREATE VIEW VIEW_STUDENT
AS
SELECT SD_NUM 학번, SD_NAME 학생명, S_NAME 학과명
FROM STUDENT S INNER JOIN SUBJECT B
ON S.S_NUM = B.S_NUM
ORDER BY SD_NUM;

SELECT * FROM VIEW_STUDENT;

-- 2. 수강신청한 학생의 학과명, 학번, 학생명, 전화번호, 이메일, 주소, 수강신청과목, 
-- 수강신청일(2021-03-01형태)을 출력하는 뷰(VIEW_TRAINEE)를 작성하라
CREATE VIEW VIEW_TRAINEE
AS
SELECT S_NAME 학과명, SD_NAME 학생명, SD_PHONE 전화번호, SD_EMAIL 이메일, SD_ADDRESS 주소, 
       L_NAME 수강신청과목, TO_CHAR(T_DATE,'YYYY-MM-DD') 수강신청일
FROM STUDENT S INNER JOIN SUBJECT B ON S.S_NUM = B.S_NUM 
               INNER JOIN TRAINEE T ON S.SD_NUM = T.SD_NUM
               INNER JOIN LESSON L ON T.L_ABBRE = L.L_ABBRE
ORDER BY SD_NAME;  
-- DROP VIEW VIEW_TRAINEE;
SELECT * FROM VIEW_TRAINEE;

-- <jdbc 예제>
commit;
SELECT * FROM SUBJECT;
-- 학과 정보 모두 조회
SELECT no, s_num, s_name FROM subject ORDER BY no;
-- 학과번호 자동 구하기
SELECT '0'||(NVL(MAX(S_NUM),'01')+1) AS subjectNum FROM SUBJECT;
-- 다른 방법
SELECT NVL(LPAD(MAX(TO_NUMBER(LTRIM(S_NUM,'0')))+1,2,'0'),'01') AS subjectNum 
FROM SUBJECT;
-- 로직 확인
SELECT NVL(LPAD(MAX(TO_NUMBER(LTRIM(NULL,'0')))+1,2,'0'),'01') FROM DUAL;
-- 학과 테이블에 데이터 입력
INSERT INTO SUBJECT(no, s_num, s_name) VALUES(?,?);
-- 학과 테이블 데이터 수정
UPDATE SUBJECT SET s_name = ? WHERE s_name = ?;
-- 학과에 소속된 학생이 있는지 확인
SELECT COUNT(*) 
FROM STUDENT ST INNER JOIN SUBJECT SB ON ST.s_num = SB.s_num
WHERE SB.no = ?;
-- 학과 테이블의 데이터 삭제
DELETE FROM SUBJECT WHERE no = ?;

-- 학번(연도2자리 학과2자리 일련번호) 자동 생성
SELECT * FROM STUDENT;
SELECT SUBSTR(TO_CHAR(sd_date,'YYYY-MM-DD'),3,2) FROM STUDENT;
SELECT NVL(LPAD(MAX(TO_NUMBER(LTRIM(s_num,'0')))+1,2,'0'),'01') FROM STUDENT;
SELECT LPAD(NVL(MAX(no),1),4,'0') FROM STUDENT;

SELECT SUBSTR(TO_CHAR(sd_date,'YYYY-MM-DD'),3,2)||NVL(LPAD(MAX(TO_NUMBER(LTRIM(s_num,'0')))+1,2,'0'),'01')||LPAD(NVL(MAX(no),1),4,'0') AS studentNum FROM student;

-- 학생 테이블에 데이터 입력
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL) 
VALUES(STUDENT_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?);
INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL) 
VALUES(STUDENT_SEQ.nextval, SUBSTR(SUBSTR(sd_birth,1,4)+19,3,2)||S_NUM||LPAD(NO,4,'0'), '임은재', 'ej0514', '1234', '01', '19920514', '010-4355-8742', '서울시 강남구', 'ej0514@hanmail.net');
-- 학생 테이블 데이터 수정
UPDATE STUDENT SET sd_passwd = ? WHERE sd_num = ?;







-- <예제> 아래의 내용으로 도서테이블(books) 및 시퀀스(books_seq)를 생성하시오(사용자: JAVAUSER)
-- BOOKS 테이블 생성
CREATE TABLE BOOKS(
    book_id NUMBER,                     -- 책번호
    title VARCHAR2(80) NOT NULL,        -- 책제목    
    publisher VARCHAR2(60) NOT NULL,    -- 출판사
    year VARCHAR2(4) NOT NULL,          -- 출간년도
    price NUMBER NOT NULL,               -- 책가격
    CONSTRAINT BOOKS_BOOK_ID_PK PRIMARY KEY(book_id)
);
-- 시퀀스 생성
CREATE SEQUENCE BOOKS_SEQ
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 100000
NOCYCLE
CACHE 2;
-- BOOKS 테이블에 데이터 입력
INSERT INTO BOOKS(book_id, title, publisher, year, price) 
VALUES(BOOKS_SEQ.NEXTVAL, 'Operating System Concepts', 'Wiley', '2003', 30700);
INSERT INTO BOOKS(book_id, title, publisher, year, price) 
VALUES(BOOKS_SEQ.NEXTVAL, 'Head First PHP and MYSQL', 'OReilly', '2009', 58000);
INSERT INTO BOOKS(book_id, title, publisher, year, price) 
VALUES(BOOKS_SEQ.NEXTVAL, 'C Programming Language', 'Prentice-Hall', '1989', 35000);
INSERT INTO BOOKS(book_id, title, publisher, year, price) 
VALUES(BOOKS_SEQ.NEXTVAL, 'Head First SQL', 'OReilly', '2007', 43000);
INSERT INTO BOOKS(book_id, title, publisher, year, price) 
VALUES(BOOKS_SEQ.NEXTVAL, '실용주의 프로그래머', '인사이트', '2022', 33000);
COMMIT;

SELECT * FROM BOOKS ORDER BY book_id;

-- 프로시저 생성 1
-- BOOKS_PROC 라는 이름으로 프로시저를 생성하라.
-- 책번호를 매개변수로 프로시저에 전달하면 책제목으로 외부로 반환하는 프로시저를 생성한다.
CREATE OR REPLACE PROCEDURE BOOKS_PROC(vbook_id IN books.book_id%TYPE, vtitle OUT books.title%TYPE)
IS
BEGIN
    SELECT title INTO vtitle FROM books
    WHERE book_id = vbook_id;    
    
    EXCEPTION 
        WHEN OTHERS THEN
            vtitle := '해당하는 책이 존재하지 않습니다.';
END BOOKS_PROC;
/

DECLARE
    vtitle books.title%TYPE;
BEGIN
    BOOKS_PROC(100, vtitle);
    DBMS_OUTPUT.PUT_LINE('책제목:'||vtitle);
END;
/

-- 프로시저 생성 2
-- BOOKS 테이블의 전체 데이터를 외부로 반환하는 프로시저를 생성하라(BOOKS_SELECT). 커서변수
CREATE OR REPLACE PROCEDURE BOOKS_SELECT(v1 OUT SYS_REFCURSOR)
IS
BEGIN
    -- 커서 변수와 커서 정의 쿼리문 연결
    OPEN v1 FOR SELECT book_id, title, publisher, year, price FROM books ORDER BY book_id;
END;
/
SHOW ERROR;

-- 프로시저 확인
DECLARE
    vbooks books%ROWTYPE;
    v1 SYS_REFCURSOR;
BEGIN
    -- 프로시저 실행
    books_select(v1); 
    -- LOOP문
    LOOP
        --커서 변수를 사용해 결과 집합을 변수에 할당
        FETCH v1 INTO vbooks.book_id, vbooks.title, vbooks.publisher, vbooks.year, vbooks.price;
        EXIT WHEN v1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(vbooks.book_id||' '||vbooks.title||' '||vbooks.publisher||' '||vbooks.year||' '||vbooks.price);
    END LOOP;    
END;
/

-- 프로시저 생성 3
-- 책테이블에 데이터 입력하는 프로시저 생성(BOOKS_INPUT)
CREATE OR REPLACE PROCEDURE BOOKS_INPUT
 (vtitle IN books.title%TYPE, vpublisher IN books.publisher%TYPE,
  vyear IN books.year%TYPE, vprice IN books.price%TYPE,
  msg OUT VARCHAR2)
IS
    NODATA EXCEPTION;
BEGIN
    INSERT INTO BOOKS(book_id, title, publisher, year, price)
    VALUES(books_seq.nextval, vtitle, vpublisher, vyear, vprice);
    
    IF SQL%NOTFOUND THEN -- 삽입 적용된 행의 수 1인데 NOTFOUND라면
        RAISE NODATA;
    ELSE
        msg := '데이터 입력이 완료되었습니다';
    END IF;
    COMMIT;
    
    EXCEPTION
        WHEN NODATA THEN
            msg := '책 정보 입력시 문제가 생겨 정상적으로 처리하지 못했습니다';
        ROLLBACK;    
END;
/
SHOW ERROR;
-- 프로시저 확인
-- OUT 매개변수 받아와야 하니 변수가 필요하여 DECLARE로 실행
DECLARE
    msg VARCHAR2(70);
BEGIN
    BOOKS_INPUT('HEAD FIRST SQL','OREILLY','2007',43000);
END;
/

-- 시험
drop table board;
drop sequence board_seq;

CREATE TABLE board (
    boardnum NUMBER,
    boardwriter VARCHAR2(20) NOT NULL,
    boardtitle VARCHAR2(50) NOT NULL,
    boardcontent VARCHAR2(2000) NOT NULL,
    boarddate DATE DEFAULT SYSDATE,
    CONSTRAINT board_pk PRIMARY KEY(boardnum)
);

COMMENT ON TABLE board IS '게시판';
COMMENT ON COLUMN board.boardnum IS '게시판 번호';
COMMENT ON COLUMN board.boardwriter IS '게시판 작성자';
COMMENT ON COLUMN board.boardtitle IS '게시판 제목';
COMMENT ON COLUMN board.boardcontent IS '게시판 내용';
COMMENT ON COLUMN board.boarddate IS '게시판 작성일';

CREATE SEQUENCE board_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 100000
NOCYCLE
CACHE 2;

INSERT INTO BOARD(boardnum, boardwriter, boardtitle, boardcontent, boarddate) VALUES(board_seq.nextval, '?', '?', '?', sysdate);
UPDATE board SET boardtitle = '와', boardwriter = '와', boardcontent = '와' WHERE boardnum = 1;
select * from board order by boardnum;

-- 저장된 정보 없으므로 0... 시퀀스 사용하지 않고 max값 가져오기
-- DECODE(비교대상, 비교조건, 조건 만족했을 때 처리값, 조건, 조건 만족했을 때 처리값, 나머지 경우 처리값)
SELECT DECODE(MAX(boardnum), NULL, 0, MAX(boardnum)) + 1 FROM board;
INSERT INTO BOARD(boardnum, boardwriter, boardtitle, boardcontent, boarddate) VALUES((SELECT DECODE(MAX(boardnum), NULL, 0, MAX(boardnum)) + 1 FROM board), '?', '?', '?', sysdate);


-- 회원가입 테이블
create table t_member(
    m_id varchar2(15) not null,
    m_passwd varchar2(15) not null,
    m_name varchar2(18) not null,
    m_email varchar2(100) not null,
    m_tel varchar2(15) not null,
    reg_date date default sysdate,
    constraint t_member_pk primary key(m_id)
);

comment on table t_member is '회원 정보';
comment on column t_member.m_id is '회원 아이디';
comment on column t_member.m_passwd is '회원 비밀번호';
comment on column t_member.m_name is '회원명';
comment on column t_member.m_email is '회원 이메일';
comment on column t_member.m_tel is '회원 전화번호';
comment on column t_member.reg_date is '회원 등록일';

INSERT INTO t_member(m_id, m_passwd, m_name, m_email, m_tel, reg_date) VALUES('ej', 'ej1234', '임은재', 'ej0514@hanmail.net', '010-123-4567', sysdate);
INSERT INTO t_member(m_id, m_passwd, m_name, m_email, m_tel, reg_date) VALUES('ae', 'ae1234', '임은재', 'ae0514@hanmail.net', '010-123-4567', sysdate);
SELECT * FROM t_member;


-- 새로운 board 테이블(기존 board 제거 후 생성)
create table board2(
    num number(4) not null,
    author varchar2(20) not null,
    title varchar2(500) not null,
    content varchar2(4000) not null,
    writeday date default sysdate,
    readcnt number(4) default 0,
    --reproot number(4),
    --repstep number(4),
    --repindent number(4),
    passwd varchar2(12) not null,
    constraint board2_pk primary key(num)
);

COMMENT ON TABLE board2 IS '게시판 테이블';
COMMENT ON COLUMN board2.num IS '게시판 번호';
COMMENT ON COLUMN board2.author IS '게시판 작성자';
COMMENT ON COLUMN board2.title IS '게시판 제목';
COMMENT ON COLUMN board2.content IS '게시판 내용';
COMMENT ON COLUMN board2.writeday IS '게시판 작성일';
COMMENT ON COLUMN board2.readcnt IS '게시판 조회수';
--COMMENT ON COLUMN board2.reproot IS '게시판 답변글(원래글의 번호 참조 - 그룹번호)';
--COMMENT ON COLUMN board2.repstep IS '게시판 답변글(답변글의 위치번호 지정)';
--COMMENT ON COLUMN board2.repindent IS '게시판 답변글(답변글의 계층번호 지정)';
COMMENT ON COLUMN board2.readcnt IS '게시판 비밀번호';

CREATE SEQUENCE board2_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 100000
NOCYCLE
CACHE 2;

drop table board2;
drop sequence board2_seq;
