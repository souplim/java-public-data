
-- hr 사용자의 전체 테이블 목록 확인
SELECT * FROM tab;
SELECT * FROM departments;
SELECT * FROM employees;

-- desc 테이블 : 테이블의 구조를 확인
DESC employees;
DESC departments;

-- 칼럼 이름 명시해서 특정 칼럼만 보기
SELECT department_id, department_name FROM departments;
-- <문제> 사원의 이름과 급여와 입사일자만을 출력하는 SQL문을 작성해보자
SELECT first_name, last_name, salary, hire_date FROM employees;

-- 칼럼이름에 별칭 지정하기 : 컬럼 AS 별칭  
SELECT department_id AS departmentNo, department_name AS departmentName FROM departments;
-- 한글 별칭도 사용 가능 : 컬럼 AS 별칭 (AS 생략 가능)
SELECT department_id 부서번호, department_name 부서명 FROM departments;
-- 별칭에 공백문자, 특수문자, 대소문자 구별을 표현하기 위해서는 AS를 생략하고 ""을 사용
SELECT department_id "department No", department_name "department Name" FROM departments;

-- Concatenation(연결) 연산자의 사용
-- 여러 컬럼을 하나의 문자열로 출력하기
SELECT first_name||'의 직급은 '||job_id||'입니다' AS 직급 FROM employees;
SELECT first_name ||' '||last_name 이름, salary 급여, hire_date 입사일 FROM employees;

-- 중복된 데이터를 한번만 출력하게 하기 : DISTINCT
SELECT job_id FROM employees;
SELECT DISTINCT job_id FROM employees;
-- 컬럼 두 개 왔을 때는 중복값이 달라질 수 있다 -> 이름은 중복제거, 직무는 중복
SELECT DISTINCT first_name, job_id FROM employees;
-- <문제> 직원들이 어떤 부서에 소속되어 있는지 소속 부서번호(department_id) 출력하되 중복제거하는 쿼리문 작성하자
SELECT department_id FROM employees;
SELECT DISTINCT department_id FROM employees;

-- Where 조건과 비교 연산자
-- 전체 직원 대상으로 조회
SELECT employee_id, first_name, salary FROM employees;
-- 급여를 3000 이상 받는 직원을 대상
SELECT employee_id, first_name, salary FROM employees WHERE salary>=3000;
-- 급여 3000 미만 받는 직원 대상
SELECT employee_id, first_name, salary FROM employees WHERE salary<3000;
-- 사원에 급여를 1000 인상하여 사원번호, 사원명, 급여, 인상급여, 입사일을 출력하시오.
SELECT employee_id 사원번호, first_name 사원명, salary 급여, salary+1000 인상급여, hire_date 입사일 FROM employees;
-- <문제> employees 테이블에서 부서번호가 110번인 직원의 모든 정보 출력
SELECT * FROM employees WHERE employee_id = 110;
-- <문제> employees 테이블에서 급여가 5000미만이 되는 직원의 정보 중 사번, 이름, 급여 출력
SELECT employee_id, first_name, last_name, salary FROM employees WHERE salary<5000;

-- 문자 데이터 조회
-- 먼저 데이터가 어떤 형태로 저장되어있는지 확인 후 조회
SELECT employee_id, first_name, last_name, salary FROM employees WHERE first_name='Lex';
-- <문제> 이름이 John인 사람의 사원번호, 직원명, 업무id 조회하라
SELECT employee_id, first_name, last_name, job_id FROM employees WHERE first_name='John';

-- 날짜 데이터 조회
-- 2008년 이후에 입사한 직원 조회
SELECT first_name, last_name, hire_date FROM employees WHERE hire_date>='2008/01/01';
SELECT first_name, last_name, hire_date FROM employees WHERE hire_date>='2008'; -- 에러. ORA-01861: 리터럴이 형식 문자열과 일치하지 않음

-- 논리연산자
-- 1. AND 연산자
SELECT employee_id, first_name, phone_number, department_id, job_id FROM employees
WHERE department_id=100 AND job_id='FI_MGR';
-- <문자> 급여가 5000에서 10000이하 직원 정보 출력
SELECT employee_id, first_name, salary FROM employees
WHERE salary >= 5000 AND salary <= 10000;

-- 2. OR 연산자
SELECT employee_id, first_name, phone_number, department_id, job_id FROM employees
WHERE department_id=100 OR job_id='FI_MGR';
-- <문제> 사원번호가 134이거나 201이거나 107인 직원 정보 출력
SELECT * FROM employees WHERE employee_id=134 OR employee_id=201 OR employee_id=107
WHERE department_id=100 OR job_id='FI_MGR';

-- 3. NOT 연산자
-- 부서번호가 100번이 아닌 직원
SELECT * FROM employees;
SELECT employee_id, first_name, phone_number, department_id, job_id FROM employees
WHERE NOT department_id=100;
-- <문제> 업무 id가 FI_MGR가 아닌 직원
SELECT employee_id, first_name, phone_number, department_id, job_id FROM employees
WHERE NOT job_id='FI_MGR'; 

-- 4. BETWEEN AND 연산자
-- 특정 범위 내에 속하는 데이터
-- 급여가 2000에서부터 3000까지의 범위에 속한 사원
SELECT employee_id, first_name, last_name, salary FROM employees
WHERE salary BETWEEN 2000 AND 3000;
-- <문제> 급여가 2500에서 4500까지의 범위에 속한 직원의 직원번호, 이름, 급여를 출력하라
-- 1. AND 연산자, 2. BETWEEN AND 연산자 사용
SELECT employee_id, first_name, last_name, salary FROM employees
WHERE salary>=2500 AND salary<=4500; 
SELECT employee_id, first_name, last_name, salary FROM employees
WHERE salary BETWEEN 2500 AND 4500;

-- 5. IN 연산자
-- 동일한 칼럼이 여러개의 값 중 하나인지 살펴보기
-- 직원번호가 177이거나 101이거나 184인 사원
SELECT employee_id, first_name, last_name, salary FROM employees
WHERE employee_id IN (177, 101, 184);
-- <문제> 부서번호가 10, 20, 30 중 하나에 소속된 직원의 직원번호, 이름, 급여를 출력하라
-- 1. OR 연산자, 2. IN 연산자 사용
SELECT employee_id, first_name, salary FROM employees
WHERE department_id=10 OR department_id=20 OR department_id=30;
SELECT employee_id, first_name, salary FROM employees
WHERE department_id IN (10, 20, 30);

-- LIKE 연산자
-- 검색하고자 하는 값을 정확히 모를 경우 와일드 카드와 함께 사용
-- 와일드 카드 -> %, _
-- % : 문자가 없거나, 하나 이상의 어떤 값이 오든 상관없다
-- _ : 하나의 문자가 어떤 값이 오든 상관 없다.
-- 1. 와일드카드(%) 사용하기
-- K로 시작하는 사원
SELECT employee_id, first_name FROM employees
WHERE first_name LIKE 'K%';
-- 이름 중에 k를 포함하는 사람
SELECT employee_id, first_name FROM employees
WHERE LOWER(first_name) LIKE '%k%';
-- 이름이 k로 끝나는 사람
SELECT employee_id, first_name FROM employees
WHERE first_name LIKE '%k';

-- 2. 와일드카드(_) 사용하기
-- 이름의 두 번째 글자가 d인 사원
SELECT employee_id, first_name FROM employees
WHERE first_name LIKE '_d%';
-- ESCAPE
-- LIKE 연산으로 '%'나 '_'가 포함된 문자를 검색하고자 할 때 사용된다.
-- '%'나 '_' 앞에 ESCAPE로 특수문자를 지정하면 검색할 수 있다.
-- 특수문자는 아무거나 상관없이 사용 가능하다.
-- 구문 마지막에 ESCAPE 에 사용할 문자열만 지정해주면 '_'나 '%'를 검색에 사용할 수 있게 도와준다.
-- 사원테이블(EMPLOYEES)에서 직무ID에 3번째 _를 포함하고 4번째 자리의 값이 P인 레코드를 조회하고자 한다.
SELECT * FROM employees
WHERE job_id LIKE '__\_P%' ESCAPE '\';
SELECT * FROM employees
WHERE job_id LIKE '__@_P%' ESCAPE '@';
-- NULL을 위한 연산자
-- NULL은 연산, 할당, 비교가 불가능하고, = 연산자로 판단할 수 없다.
SELECT employee_id, first_name, commision_pct, job_id FROM employees
WHERE commision_pct=NULL; // 에러
-- IS NULL과 IS NOT NULL 
-- 커미션을 받지 않는 사원
SELECT employee_id, first_name, commission_pct, job_id FROM employees
WHERE commission_pct IS NULL;
-- 커미션을 받는 사원
SELECT employee_id, first_name, commission_pct, job_id FROM employees
WHERE commission_pct IS NOT NULL;
-- <문제> 자신의 직속상관이 없는 직원의 전체 이름과 직원번호, 업무ID를 출력하라
SELECT * FROM employees;
SELECT employee_id, first_name, last_name, job_id FROM employees
WHERE manager_id IS NULL;
-- <문제> 커미션을 받는 사원만 출력하되 사원번호, 이름, 급여, 수당율, 수당금액(계산식-급여*수당율)을 출력하라.
SELECT employee_id, first_name, salary, commission_pct, salary*commission_pct FROM employees
WHERE commission_pct IS NOT NULL;
-- ORDER BY 정렬하기
-- 쿼리문 맨 뒤에 기술 : SELECT 컬럼 FROM 테이블 WHERE 조건 ORDER BY 컬럼 ASC/DESC;
-- 1. 오름차순 정렬을 위한 ASC : 생략 가능
-- 사번을 기준으로 오름차순 정렬 - NULL 레코드를 제일 마지막에
SELECT employee_id, first_name FROM employees ORDER BY employee_id ASC;
-- 2. 내림차순 정렬을 위한 DESC
-- 사번을 기준으로 내림차순 정렬 - NULL 레코드를 제일 먼저
SELECT employee_id, first_name FROM employees ORDER BY employee_id DESC;
SELECT employee_id, first_name FROM employees ORDER BY 1 DESC; -- 정렬할 컬럼의 순번으로도 가능
-- <문제> 직원번호, 이름, 급여, 부서번호를 급여가 높은 순으로 출력하라
SELECT employee_id, first_name, salary, job_id FROM employees ORDER BY salary DESC;
-- 정렬기준 여러개 올 수 있음 - 첫 번째 기준에서 동일한 데이터 있으면 그 다음으로는 두 번째 기준으로 정렬
SELECT employee_id, first_name, salary, job_id FROM employees ORDER BY salary DESC, employee_id DESC;
SELECT employee_id, first_name, salary, job_id FROM employees ORDER BY 3 DESC, 1 DESC; -- 정렬할 컬럼의 순번으로도 가능
-- <문제> 입사일이 가장 최근인 직원 순으로 직원번호, 이름, 입사일을 출력하라
SELECT employee_id, first_name, hire_date FROM employees ORDER BY hire_date DESC;
-- <문제> 부서번호가 20, 50번 부서에서 근무하는 모든 사원의 이름, 부서 번호, 급여를 알파벳순으로 출력하라
SELECT first_name, department_id, salary FROM employees
WHERE department_id = 20 OR department_id = 50
ORDER BY first_name;
SELECT first_name, department_id, salary FROM employees
WHERE department_id IN(20, 50)
ORDER BY first_name;
-- 기본 SELECT문 연습 예제
--[문제 1] EMPLOYEES 테이블에서 급여가 3000이상인 사원의 정보를 사원번호, 이름, 담당업무, 급여를 출력하라.
SELECT employee_id, first_name, job_id, salary FROM employees
WHERE salary>=3000;
--[문제 2] EMPLOYEES 테이블에서 담당 업무가 ST_MAN인 사원의 정보를 사원번호, 이름, 담당업무, 급여, 부서번호를 출력하라.
SELECT employee_id, first_name, job_id, salary, department_id FROM employees
WHERE job_id='ST_MAN';
--[문제 3] EMPLOYEES 테이블에서 입사일자가 2006년 1월 1일 이후에 입사한 사원의 정보를 사원번호, 이름, 담당업무, 급여, 입사일자, 부서번호를 출력하라.
SELECT employee_id, first_name, job_id, salary, hire_date, department_id FROM employees
WHERE hire_date>='2006/01/01';
--[문제 4] EMPLOYEES 테이블에서 급여가 3000에서 5000사이의 정보를 이름, 담당업무, 급여, 부서번호를 출력하라.
SELECT first_name, job_id, salary, department_id FROM employees
WHERE salary>=3000 AND salary<=5000;
SELECT first_name, job_id, salary, department_id FROM employees
WHERE salary BETWEEN 3000 AND 5000;
--[문제 5] EMPLOYEES 테이블에서 입사일자가 05년도에 입사한 사원의 정보를 사원번호, 이름, 담당업무, 급여, 입사일자, 부서번호를 출력하라.
SELECT employee_id, first_name, job_id, salary, hire_date, department_id FROM employees
WHERE hire_date>='2005/01/01' AND hire_date<='2005/12/31';
--[문제 6] 사원정보(EMPLOYEES) 테이블에서 사원번호, 이름, 급여, 업무번호, 입사일, 상사의 사원번호를 출력하시오. 이때 이름은 성과 이름을 연결하여 Name이라는 별칭으로 출력하시오
SELECT employee_id, first_name ||' '||last_name AS Name, salary, job_id, hire_date, manager_id FROM employees;
--[문제 7] 사원정보(EMPLOYEES) 테이블에서 사원의 성과 이름은 Name, 업무번호는 Job, 급여는 Salary, 연봉에 $100 보너스를 추가하여 계산한 값은 Increased Ann_Salary,
--급여에 $100 보너스를 추가하여 계산한 연봉은 Increased Salary라는 별칭으로 출력하시오.
SELECT first_name ||' '||last_name AS Name, job_id AS Job, salary AS Salary, salary+100 "Increased Ann_Salary", (salary/12+100)*12 "Increased Salary" FROM employees;
-- 소수점?
--[문제 8] 사원정보(EMPLOYEES) 테이블에서 모든 사원의 이름(FIRST_NAME)과 연봉을 “이름: 1 Year Salary = $연봉” 형식으로 출력하고, 1 Year Salary라는 별칭을 붙여 출력하시오.
--(예시) King: 1 Year Salary = $288000
SELECT first_name||': 1 Year Salary = $'||salary "1 Year Salary" FROM employees;
--[문제 9] 부서별로 담당하는 업무ID를 한 번씩만 출력하시오
SELECT DISTINCT job_id FROM employees;
--[문제 10] 부서에서 예산 편성 문제로 급여 정보 보고서를 작성하려고 한다. 
--사원정보(EMPLOYEES) 테이블에서 급여가 $7,000~$10,000 범위 이외인 사람의 성과 이름(Name으로 별칭) 및 급여를 급여가 작은 순서로 출력하시오
SELECT last_name||' '||first_name AS Name, salary FROM employees
WHERE salary BETWEEN 7000 AND 10000 
ORDER BY salary ASC;
-- 테이블 생성하기
CREATE TABLE EMP01(
    EMPNO NUMBER(4) NOT NULL,
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(7,2)
);
SELECT * FROM TAB;
SELECT * FROM EMP01; 
-- 테이블 구조확인 (주석문 DESC 명령어 옆에 주면 에러 발생. 라인 단위로 읽는 명령어)
DESC EMP01; 
-- 테이블 복사하기
CREATE TABLE EMPOYEES02
AS SELECT * FROM employees;
SELECT * FROM TAB;
SELECT * FROM EMPOYEES02;
DESC EMPOYEES02;
-- 테이블 구조 변경 : ALTER TABLE
-- 1. ADD 새로운 칼럼 추가
ALTER TABLE EMP01
ADD(job varchar2(9));
-- 변경 확인
DESC EMP01; 
-- <문제> 이미 존재하는 EMP01 테이블에 입사일 칼럼(CREDATE)을 날짜형으로 추가하라
ALTER TABLE EMP01
ADD(credate DATE);
-- 2. MODIFY 기존 칼럼 수정
-- 직급을 최대 30자까지 입력할 수 있도록 크기 수정
ALTER TABLE EMP01
MODIFY(job varchar2(30));
DESC EMP01; -- 변경 확인
-- 3. MODIFY 기존 칼럼명 변경
ALTER TABLE EMP01
RENAME COLUMN CREDATE TO REGDATE;
DESC EMP01; -- 변경 확인
-- 4. DROP 기존 칼럼 삭제
ALTER TABLE EMP01
DROP COLUMN job;
-- 테이블 구조 삭제 : DROP TABLE
DROP TABLE EMP01;
SELECT * FROM TAB; -- 삭제 확인
-- 휴지통
SELECT * FROM RECYCLEBIN; 
-- 휴지통 비우기
PURGE RECYCLEBIN; 
-- 삭제 테이블 복원
FLASHBACK TABLE EMP01 TO BEFORE DROP; 
-- 새로운 이름으로 복원
FLASHBACK TABLE EMP01 TO BEFORE DROP
RENAME TO EMP02;
-- 테이블 이름 변경 : RENAME
RENAME EMPLOYEES02 TO EMPLOYEES01;
-- 테이블이 갖고 있는 모든 레코드 삭제 : TRUNCATE -> DDL 자동커밋. 복원 불가 
-- EMPLOYEES01테이블의 모든 로우를 제거
SELECT * FROM employees01;
TRUNCATE TABLE employees01;
SELECT * FROM employees01;
CREATE TABLE EMP01(
    EMPNO NUMBER(4) NOT NULL,
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(7,2)
);
-- 고객 테이블 생성
CREATE TABLE TB_CUSTOMER(
    CUSTOMER_CD CHAR(7)     NOT NULL PRIMARY KEY,
    CUSTOMER_NM VARCHAR(15) NOT NULL,
    MW_FLG CHAR(1)          NOT NULL CHECK(MW_FLG IN('M','W')),
    BIRTH_DAY CHAR(8)       NOT NULL,
    PHONE_NUMBER VARCHAR2(16),
    EMAIL VARCHAR2(50),
    TOTAL_POINT NUMBER(10),
    REG_DTTM CHAR(14)
);
-- <문제 1> MEMBER 테이블 생성
CREATE TABLE MEMBER(
    ID VARCHAR2(20) NOT NULL PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    REGNO VARCHAR2(8) NOT NULL,
    HP VARCHAR2(13),
    ADDRESS VARCHAR2(100)
);
-- <문제 2> BOOK 테이블 생성
CREATE TABLE BOOK(
    CODE NUMBER(4) NOT NULL PRIMARY KEY,
    TITLE VARCHAR2(50) NOT NULL,
    COUNT NUMBER(6),
    PRICE NUMBER(10),
    PUBLISH VARCHAR2(50)
);
-- <문제 3> BOOK_ORDER 테이블 생성
CREATE TABLE BOOK_ORDER(
    NO VARCHAR2(10) NOT NULL PRIMARY KEY,
    ID VARCHAR2(20) NOT NULL,
    CODE NUMBER(4) NOT NULL,
    COUNT NUMBER(6),
    OR_DATE DATE
);
-- SELECT문 함수
-- 1. DUAL 테이블과 SQL 함수 분류
-- (1) DUAL 테이블 : 산술 연산이나 가상 칼럼 등의 값을 한 번만 출력하고 싶을 때 사용하는 테이블
DESC departments;
SELECT 24*60*60 FROM departments;
SELECT 24*60*60 FROM DUAL;
-- DUAL 테이블은 DUMMY라는 한 개의 칼럼으로 구성되어 있음 
DESC DUAL;
-- DUAL 테이블은 X라는 한 개의 문자만을 값으로 가진 단 하나의 로우만을 저장하고 있음
-- 그래서 함수를 사용하여 결과를 확인하고 싶을 때 : SELECT 컬럼 FROM DUAL;
SELECT * FROM DUAL;
-- (2) 단일 행 함수와 그룹함수로 SQL 함수 분류
-- (단일 행 함수) 30번 부서 소속 사원의 급여를 출력하는 쿼리문
SELECT department_id, salary FROM employees
WHERE department_id = 30;
-- (그룹함수) 30번 부서 소속 사원의 총 급여를 구하는 쿼리문. 30번 부서 소속 사원이 6명임에도 결과는 하나의 행으로 나옴
SELECT department_id, SUM(salary) FROM employees
GROUP BY department_id
HAVING department_id = 30;
-- 2. 문자함수
-- (1) 소문자로 변환하는 LOWER 함수
-- 사원 테이블에서 부서번호가 20번인 사원명을 모두 소문자로 변환
SELECT first_name, LOWER(first_name)
FROM employees
WHERE department_id = 20;
-- (2) 대문자로 변환하는 UPPER 함수
SELECT 'DataBase', UPPER('DataBase')
FROM DUAL;
-- job_id가 'it_prog'인 사원을 검색
SELECT employee_id, first_name, job_id FROM employees
WHERE job_id = 'IT_PROG';
SELECT employee_id, first_name, job_id FROM employees
WHERE job_id = UPPER('it_prog');
SELECT employee_id, first_name, job_id FROM employees
WHERE LOWER(job_id) = 'it_prog';
-- (3) 첫 글자만 대문자로 나머지는 소문자로 변환하는 INITCAP 함수
SELECT INITCAP('DATA BASE PROGRAM') FROM DUAL;
-- 사원 테이블의 30번 부서에 소속된 이메일의 첫 글자만 대문자로
DESC employees;
SELECT email FROM employees;
SELECT employee_id, first_name, INITCAP(email) FROM employees
WHERE department_id = 30;
-- <문제> 'jking'이란 이메일을 가진 직원의 이름과 커미션을 출력하라(INITCAP, UPPER 사용)
SELECT first_name, commission_pct FROM employees
WHERE INITCAP(email) = 'Jking';
SELECT first_name, commission_pct FROM employees
WHERE email = UPPER('jking');
-- (4) 두 문자를 연결하는 CONCAT 함수
SELECT CONCAT('Data','Base')
FROM DUAL;
SELECT CONCAT(first_name, '($'||salary||')') AS "사원 정보" FROM employees
WHERE department_id = 30;
-- (5) 문자 길이를 구하는 LENGTH/LENGTHB 함수
-- LENGTH : 글자의 개수를 구한다
SELECT LENGTH('DataBase'), LENGTH('데이터베이스')
FROM DUAL;
-- LENGTHB : 메모리에 차지하는 바이트 수를 구한다
SELECT LENGTHB('DataBase'), LENGTHB('데이터베이스') -- 한글 : 3byte
FROM DUAL;
-- 20번 부서 소속 사원들의 이름의 길이를 출력하기
SELECT department_id, employee_id, first_name, LENGTH(first_name) FROM employees
WHERE department_id = 20;
-- 직원 중 이름이 4글자인 직원의 이름을 소문자로 출력
SELECT department_id, employee_id, LOWER(first_name) FROM employees
WHERE LENGTH(first_name) = 4;
-- <문제> 이름이 6글자 이상인 직원의 직원번호와 이름과 급여를 출력하라
SELECT employee_id, first_name, salary FROM employees
WHERE LENGTH(first_name)>=6;
-- (6) 문자열 일부만 추출하는 SUBSTR/SUBSTRB 함수
SELECT SUBSTR('DataBase', 1, 3)
FROM DUAL;
-- 20번 부서 사원들 입사년도 알아내기
SELECT hire_date FROM employees;
SELECT first_name, hire_date, SUBSTR(hire_date, 1, 2) FROM employees
WHERE department_id=20;
-- <문제> 03년도에 입사한 사원 알아내기(비교연산자, AND연산자, BETWEEN AND 연산자, SUBSTR 함수)
DESC employees;
SELECT hire_date FROM employees;
SELECT first_name, hire_date FROM employees
WHERE hire_date>='03/01/01' AND hire_date<='03/12/31';
SELECT first_name, hire_date FROM employees
WHERE hire_date BETWEEN '03/01/01' AND '03/12/31';
SELECT first_name, hire_date FROM employees
WHERE SUBSTR(hire_date, 1, 2) = '03';
-- <문제> 이름이 k로 끝나는 직원을 검색(LIKE 연산자의 와일드 카드(%), SUBSTR 함수)
SELECT first_name FROM employees
WHERE first_name LIKE '%k';
SELECT first_name FROM employees 
WHERE SUBSTR(first_name, -1, 1)='k';
-- (7) 특정 문자의 위치를 구하는 INSTR/INSTRB 함수
SELECT INSTR('DataBase', 'B')
FROM DUAL;
-- 30번 부서 소속 사원이름에 e자가 어디에 위치하는지 알려주는 쿼리문
SELECT department_id, first_name, INSTR(first_name, 'e') FROM employees
WHERE department_id = 30;
-- (8) 특정 기호로 채우는 LPAD/RPAD 함수
SELECT LPAD('DataBase', 20, '$') FROM DUAL;
SELECT RPAD('DataBase', 20, '$') FROM DUAL;
SELECT RPAD('123-4535', 12, '(02)') FROM DUAL;
-- (9) 특정 문자를 잘라내는 TRIM 함수
SELECT TRIM('a' FROM 'aaaaDataBase programingaaaa') FROM DUAL;
-- Lisa란 사람의 이름에서 L와 a를 잘라내자
SELECT first_name, TRIM('L' FROM first_name), TRIM('a' FROM first_name) FROM employees
WHERE first_name = 'Lisa';
SELECT TRIM(LEADING FROM '  ABCD  ') LT, LENGTH(TRIM(LEADING FROM '  ABCD  ')) LT_LEN, TRIM(TRAILING FROM '  ABCD  ') RT, 
LENGTH(TRIM(TRAILING FROM '  ABCD  ')) RT_LEN, TRIM(BOTH FROM '  ABCD  ') BOTH1, LENGTH(TRIM(BOTH FROM '  ABCD  ')) BOTH1_LEN, 
TRIM('  ABCD  ') BOTH2, LENGTH(TRIM ('  ABCD  ')) BOTH2_LEN
FROM DUAL;
-- 3. 숫자함수
-- (1) ABS 함수 - 절대값 / CEIL 함수 - 올림 / FLOOR 함수 - 내림
SELECT ABS(-15) FROM DUAL;
SELECT CEIL(10.123), FLOOR(34.5678) FROM DUAL;
-- (2) 특정 자릿수에서 반올림하는 ROUND 함수
SELECT ROUND(12.345, 2), ROUND(34.567, 0), ROUND(56.789), ROUND(78.901,-1) FROM DUAL;
-- (3) 특정 자릿수에서 잘라내는 TRUNC 함수
SELECT TRUNC(12.345, 2), TRUNC(34.567, 0), TRUNC(56.789), TRUNC(78.901,-1) FROM DUAL;
-- (4) 나머지 값을 반환하는 MOD함수
SELECT MOD(34, 2), MOD(34, 5), MOD(34, 7) FROM DUAL;
-- <문제> 직원번호가 짝수인 직원들의 직원번호와 이름과 직급을 출력하라.
SELECT * FROM employees;
SELECT employee_id, first_name, job_id FROM employees
WHERE MOD(employee_id, 2)=0;
-- 4. 날짜 함수
-- (1) 현재 날짜를 반환하는 SYSDATE
SELECT SYSDATE FROM DUAL;
-- 날짜형 데이터는 더하기나 빼기와 같은 연산이 가능함
SELECT SYSDATE-1 어제, SYSDATE 오늘, SYSDATE+1 내일 FROM DUAL;
-- (2) 두 날짜 사이 간격을 계산하는 MONTHS_BETWEEN 함수
SELECT first_name, SYSDATE 오늘, TO_CHAR(hire_date, 'YYYY/MM/DD') 입사일, TRUNC(MONTHS_BETWEEN(SYSDATE, hire_date)) 근무달수 FROM employees
WHERE department_id = 30;
-- (3) 개월 수를 더하는 ADD_MONTHS 함수
-- 입사일에서 3개월이 지난 날짜를 구하라
SELECT first_name, hire_date, ADD_MONTHS(hire_date, 3) FROM employees
WHERE department_id = 30;
-- (4) 해당 요일의 가장 가까운 날짜를 반환하는 NEXT_DAY 함수
-- 오늘을 기준으로 최초로 다가오는 수요일
SELECT SYSDATE, NEXT_DAY(SYSDATE, '수'), NEXT_DAY(SYSDATE, 4) FROM DUAL;
-- 요일 영어로
Alter SESSION SET NLS_LANGUAGE=AMERICAN;
SELECT SYSDATE, NEXT_DAY(SYSDATE,'WEDNESDAY') FROM DUAL;
-- 요일 한국어로
Alter SESSION SET NLS_LANGUAGE=KOREAN;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '수') FROM DUAL;
-- ( 5) 해당 달의 마지막 날짜를 반환하는 LAST_DAY 함수
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL;
-- (6) ROUND 함수의 다양한 적용 : 함수에 포맷 모델(FORMAT)을 지정하면 숫자 이외의 날짜에 대해서도 반올림을 할 수 있음
-- 입사일을 달 기준으로 반올림한 예
SELECT hire_date, ROUND(hire_date,'MONTH') FROM employees
WHERE department_id = 30;
-- (7) TRUNC 함수의 다양한 적용
-- 입사일을 월 기준으로 잘라내기
SELECT hire_date, TRUNC(hire_date, 'MONTH') FROM employees
WHERE department_id = 30;
-- 5. 변환 함수
-- (1) 문자형으로 변환하는 TO_CHAR 함수
-- 날짜형 -> 문자형
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'DL') FROM DUAL;
-- 직원들의 입사일을 출력하되 요일까지 함께 출력하기
SELECT TO_CHAR(hire_date, 'YYYY-MM-DD DAY') FROM employees
WHERE department_id = 30;
SELECT TO_CHAR(hire_date, 'YYYY"년" MM"월" DD"일" DAY') FROM employees
WHERE department_id = 30;
SELECT TO_CHAR(hire_date, 'YYYY/MON/DD DY') FROM employees
WHERE department_id = 30;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD, HH24:MI:SS') FROM DUAL;
-- 숫자형 -> 문자형
-- 숫자출력
SELECT first_name, salary, TO_CHAR(salary, '$999,999') salarytformat FROM employees
WHERE department_id = 30;
SELECT first_name, salary, TO_CHAR(123456, '999,999,999') FROM employees
WHERE department_id = 30;
-- (2) 날짜형으로 변환하는 TO_DATE 함수
-- 2005년 12월 24일에 입사한 직원을 검색
SELECT first_name, hire_date FROM employees
WHERE hire_date = TO_DATE(20051224, 'YYYYMMDD');
-- 문자열 데이터 '210505'를 '2021년 05월 05일'로 표현
SELECT TO_CHAR('210505', 'YYYY"년" MM"월" DD"일"') FROM DUAL; -- 오류
SELECT TO_CHAR(TO_DATE('210505','YYMMDD'), 'YYYY"년" MM"월" DD"일"') FROM DUAL;
SELECT TO_CHAR(TO_DATE('210505','YYMMDD'), 'YYYY"년" fmMM"월" DD"일"') FROM DUAL; -- 0을 제외한 날짜 2021년5월5일
-- 올해 며칠이 지났는지 날짜 계산
SELECT SYSDATE-'2015/12/24' FROM DUAL; -- 날짜 뺄셈 오류. 뒤->날짜가 아니라 문자
SELECT TRUNC(SYSDATE-TO_DATE('2015/12/24','YYYY/MM/DD')) FROM DUAL; 
-- (3) 숫자형으로 변환하는 TO-NUMBER 함수
-- 수치 형태의 문자값의 차 구하기 -- 오류
SELECT '10,000'+'20,000' FROM DUAL; -- 오류
SELECT TO_NUMBER('10,000','999,999')+TO_NUMBER('20,000','999,999') FROM DUAL;
-- 6. 일반 함수
-- (1) NULL을 다른 값으로 변환하는 NVL 함수
SELECT first_name, salary, commission_pct, job_id FROM employees
ORDER BY job_id;
SELECT first_name, salary, NVL(commission_pct, 0), job_id FROM employees
ORDER BY job_id;
-- 급여에 커미션을 더한 금액 구하기
SELECT first_name, salary, commission_pct, salary*commission_pct AS commission, salary+(salary*commission_pct) AS total, job_id
FROM employees
ORDER BY job_id;
SELECT first_name, salary, commission_pct, salary*NVL(commission_pct, 0) commission, salary+(salary*NVL(commission_pct, 0)) total, job_id
FROM employees
ORDER BY job_id;
-- NVL2 함수
-- 커미션이 NULL이 아니면 급여+커미션을, NULL이면 급여만 출력
SELECT first_name, salary, commission_pct, NVL2(commission_pct, salary+(salary*commission_pct), salary) TOTAL_SAL FROM employees;
-- <문제> 모든 직원은 자신의 상관(manager_id)이 있다. 하지만 employees 테이블에 유일하게 상관이 없는 로우가 있는데 그 사원의 manager_id 칼럼값이 NULL이다.
-- 상관이 없는 대표이사만 출력하되 manager_id 칼럼 값 NULL 대신 CEO로 출력한다.
SELECT manager_id FROM employees; -- 자료형 확인하니 숫자형. 'CEO'로 변환하려면 문자형으로 변환해야함
SELECT employee_id, first_name, NVL(TO_CHAR(manager_id), 'CEO') AS manager_id FROM employees
WHERE manager_id IS NULL;
-- <문제> 커미션 정보가 없는 직원들도 있는데 커미션이 없는 직원 그룹은 '<커미션 없음>'이 출력되게 한다.
SELECT NVL(TO_CHAR(commission_pct), '<커미션 없음>') AS COMMISSION FROM employees;
--(2) 선택을 위한 DECODE 함수 (if문이랑 비슷)
-- 부서명 구하기
SELECT * FROM departments;
SELECT department_id, DECODE(department_id, 10, 'Administration', 
                                            20, 'Marketing', 
                                            30, 'Purchasing', 
                                            40, 'Human Resources', 
                                            50, 'Shipping', 
                                            60, 'IT') AS departments 
FROM employees
ORDER BY department_id;
-- (3) 조건에 따라 서로 다른 처리가 가능한 CASE 함수 : switch문이랑 비슷
-- 부서명 구하기
SELECT first_name, department_id,
    CASE WHEN department_id=10 THEN 'admministration'
         WHEN department_id=20 THEN 'Marketing'
         WHEN department_id=30 THEN 'Purchasing'
         WHEN department_id=40 THEN 'Human Resources'
         WHEN department_id=50 THEN 'Shipping'
         WHEN department_id=60 THEN 'IT'
         END DEPAPRTEMENT_NAME -- 별칭
FROM employees
ORDER BY department_id;
-- 같은 식 다른 표현(대부분은 위 코드처럼 명시)
SELECT first_name, department_id,
    CASE department_id WHEN 10 THEN 'admministration'
                       WHEN 20 THEN 'Marketing'
                       WHEN 30 THEN 'Purchasing'
                       WHEN 40 THEN 'Human Resources'
                       WHEN 50 THEN 'Shipping'
                       WHEN 60 THEN 'IT'
    END DEPAPRTEMENT_NAME -- 별칭
FROM employees
ORDER BY department_id;
-- <문제> 부서별에 따라 급여를 인상(직원번호, 직원명, 직급, 급여)
-- 부서명이 'Marketing'인 직원은 5%, 'Purchasing'인 직원은 10%, 'Human Resources'인 직원 15%, 'IT'인 직원은 20% 인상한다.
-- DECODE 사용
SELECT employee_id, first_name, job_id, salary,
       DECODE(department_id, 20, salary*1.05,
                             30, salary*1.1
                             40, salary*1.15,
                             60, salary*1.2, salary) UPSAL
FROM employees;
-- CASE 사용
SELECT employee_id, first_name, job_id, salary,
    CASE WHEN department_id=10 THEN salary
         WHEN department_id=20 THEN salary*1.05
         WHEN department_id=30 THEN salary*1.1
         WHEN department_id=40 THEN salary*1.15
         WHEN department_id=50 THEN salary
         WHEN department_id=60 THEN salary*1.2
         END UPSAL
FROM employees
ORDER BY department_id;
-- 부서명으로 조건 부여
SELECT employee_id, first_name, e.department_id, job_id, salary,
        CASE WHEN department_name = 'Marketing' THEN salary*1.05
             WHEN department_name = 'Marketing' THEN salary*1.05
             WHEN department_name = 'Marketing' THEN salary*1.05
             WHEN department_name = 'Marketing' THEN salary*1.05
             ELSE salary
        END UPSAL
FROM employees E INNER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
ORDER BY employee_id;
             
-- (4) GREATEST(exp1, exp2...) 가장 큰 값, LEAST(exp1, exp2...) 가장 작은 값
SELECT GREATEST(1,4,2,5,3,9), LEAST(1,4,2,5,3,9) FROM DUAL;
SELECT GREATEST('김희수','조현수','홍길동'), LEAST('김희수','조현수','홍길동') FROM DUAL;
-- 무결성 제약조건
-- 1. 무결성 제약조건 종류
-- (1) NOT NULL
DROP TABLE EMP01;
CREATE TABLE emp01(
    empno NUMBER(4),
    ename VARCHAR2(10),
    job VARCHAR(9),
    deptno NUMBER(4)
);
INSERT INTO emp01
VALUES(NULL, NULL, 'salesman', 30);
SELECT * FROM emp01;
-- 필수항목에 NULL값 들어갈 수 있으므로 테이블 삭제후 제약조건 부여하여 다시 만들기
DROP TABLE emp01 PURGE;
CREATE TABLE emp01(
    empno NUMBER(4) NOT NULL,
    ename VARCHAR2(10) NOT NULL,
    job VARCHAR(9),
    deptno NUMBER(4)
);
INSERT INTO emp01
VALUES(NULL, NULL, 'salesman', 30); -- 오류
INSERT INTO emp01
VALUES(7499, 'ALLEN', 'salesman', 30);
SELECT * FROM emp01;
-- (2) UNIQUE 유일키
DROP TABLE emp02;
CREATE TABLE emp02(
    empno NUMBER(4) UNIQUE,
    ename VARCHAR2(10) NOT NULL,
    job VARCHAR(9),
    deptno NUMBER(4)
);
INSERT INTO emp02
VALUES(7499, 'ALLEN', 'salesman', 30);
INSERT INTO emp02(empno, ename, job, deptno)
VALUES(7499, 'ALLEN', 'salesman', 30); -- 동일한 사원번호로 입력해봄 -> 에러
-- null은 값에서 제외되므로 유일한지 체크하는 값에서 제외됨
INSERT INTO emp02(empno, ename, job, deptno)
VALUES(NULL, 'JONES', 'manager', 20);
INSERT INTO emp02(empno, ename, job, deptno)
VALUES(NULL, 'JONES', 'salesman', 10); -- 에러아님. NULL값도 입력되지 않게 하려면 empno NUMBER(4) NOT NULL UNIQUE처럼 두 가지 제약조건 기술해야
SELECT * FROM emp02;
-- (3) 데이터 딕셔너리 : 데이터베이스 효율적으로 관리하기 위한 시스템 테이블 - DBA_XXXX, ALL_XXXX, USER_XXXX
-- HR 사용자가 생성한 테이블의 이름을 조회
SELECT TABLE_NAME FROM USER_TABLES
ORDER BY TABLE_NAME DESC;
-- (4) 제약조건 확인하기 : 에러메시지의 정확한 원인을 알기 위한 USER_CONSTRAINTS 데이터 딕셔너리
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMP02';
-- 어느 컬럼에 제약조건 지정되어있는지도 확인 가능 : COLUMN_NAME
SELECT OWNER, CONSTRAINT_NAME, TABLE_NAME, COLUMN_NAME FROM USER_CONS_COLUMNS
WHERE TABLE_NAME = 'EMP02';
-- (5) 데이터의 구분을 위한 PRIMARY KEY  제약조건 : 식별 기능을 갖는 칼럼 -> 유일 & 널값 허용 X
DROP TABLE emp03;
CREATE TABLE emp03(
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10) NOT NULL,
    job VARCHAR(9),
    deptno NUMBER(4)
);
INSERT INTO emp03 VALUES(7499, 'ALLEN', 'salesman', 30);
INSERT INTO emp03 VALUES(7499, 'JONES', 'manager', 20); -- 동일한 사원번호 입력하면 에러 발생
INSERT INTO emp03 VALUES(NULL, 'JONES', 'manager', 20); -- 에러. NULL값도 허용 X
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMP03'; -- 제약조건 확인하기
-- (6) FOREIGN KEY
-- 부서(부모) 테이블 생성
CREATE TABLE DEPT01(
    deptno NUMBER(2) PRIMARY KEY,
    dname VARCHAR2(14) NOT NULL,
    loc VARCHAR2(13)
);
INSERT INTO dept01(deptno, dname, loc) VALUES(10,'Accounting','NEW YORK');
INSERT INTO dept01(deptno, dname, loc) VALUES(20,'Research','DALLAS');
INSERT INTO dept01(deptno, dname, loc) VALUES(30,'Sales','CHICAGO');
INSERT INTO dept01(deptno, dname, loc) VALUES(40,'Operations','BOSTON');
-- 외래키 제약 조건 지정하지 않은 emp03 테이블에 존재하지 않는 50번 부서번호 지정해보기
INSERT INTO emp03 VALUES(7566,'JONES','MANAGER',50);
SELECT * FROM emp03; -- 부서번호 없는데도 데이터가 저장됨
SELECT * FROM dept01;
-- 사원(자식) 테이블 생성
CREATE TABLE emp04(
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10) NOT NULL,
    job VARCHAR2(9),
    depno NUMBER(2) REFERENCES dept01(deptno)
);
INSERT INTO emp04
VALUES(7499,'ALLEN','SALESMAN',30);
SELECT * FROM emp04;
INSERT INTO emp04
VALUES(7566,'JONES','SALESMAN',50); -- 에러
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMP04';
-- (7) CHECK 제약 조건 : 입력되는 값 체크하여 설정된 값 이외의 값이 들어오면 수행되지 못하게 함
CREATE TABLE emp05(
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10) NOT NULL,
    gender VARCHAR2(1) CHECK(GENDER IN('M','F'))
);
INSERT INTO emp05(empno, ename, gender) VALUES(7566,'JONES','M');
SELECT * FROM emp05;
INSERT INTO emp05(empno, ename, gender) VALUES(7566,'JONES','A'); - 오류 : 체크제약조건 발생
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION
FROM USER_CONSTRAINTS
WHERE TABLE_NAME='EMP05';
-- (8) DEFAULT : 값 설정 안 할시 기본값으로 입력
CREATE TABLE emp05_2(
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10) NOT NULL,
    gender VARCHAR2(1) CHECK(GENDER IN('M','F')),
    regdate DATE DEFAULT SYSDATE,
    hit NUMBER(6) DEFAULT 0
);
INSERT INTO emp05_2(empno, ename, gender) VALUES(7566,'JONES','M');
SELECT * FROM emp05_2;
-- 2. 제약 조건명 지정하기
CREATE TABLE emp06(
    empno NUMBER(4) CONSTRAINT emp06_empno_pk PRIMARY KEY,
    ename VARCHAR2(10) NOT NULL,
    job VARCHAR2(9) CONSTRAINT emp06_job_uk UNIQUE,
    depno NUMBER(2) CONSTRAINT emp06_depno_fk REFERENCES dept01(deptno)
);
INSERT INTO emp06 VALUES(7499,'ALLEN','SALESMAN',30);
SELECT * FROM emp06;
-- 지정된 사용자 제약조건명 확인하기
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME
FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP06';
INSERT INTO emp06 VALUES(7499,'ALLEN','SALESMAN', 30); -- 무결성 제약 조건(HR.EMP06_EMPNO_PK)에 위배됩니다
INSERT INTO emp06 VALUES(7499, NULL, 'SALESMAN', 30); -- NULL을 ("HR"."EMP06"."ENAME") 안에 삽입할 수 없습니다
INSERT INTO emp06 VALUES(7499, 'ALLEN', 'SALESMAN', 50); -- 무결성 제약 조건(HR.EMP06_EMPNO_PK)에 위배됩니다
INSERT INTO emp06 VALUES(7500, 'ALLEN', 'SALESMAN', 50); -- 무결성 제약 조건(HR.EMP06_JOB_UK)에 위배됩니다
INSERT INTO emp06 VALUES(7500, 'ALLEN', 'MANAGER', 50); -- 무결성 제약조건(HR.EMP06_DEPNO_FK)이 위배되었습니다- 부모 키가 없습니다
-- 3. 테이블 레벨 방식으로 제약조건 지정하기
-- 복합키로 기본키를 지정할 경우 : 반드시 테이블 레벨 방식 사용해야
-- ALTER TABLE로 제약조건 추가하는 경우 : 테이블 구조 결정된 후에 제약 조건 추가 -> 테이블 레벨 방식으로
-- (1) 칼럼 레벨로 제약조건을 지정하는 방식
CREATE TABLE emp07(
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10) NOT NULL,
    job VARCHAR2(9) UNIQUE,
    deptno NUMBER(2) REFERENCES DEPT01(deptno)
);
-- (2) 테이블 레벨로 제약조건을 지정하는 방식 + 제약조건명 지정
CREATE TABLE emp08(
    empno NUMBER(4),
    ename VARCHAR2(10) NOT NULL,
    job VARCHAR2(9),
    deptno NUMBER(2),
    PRIMARY KEY(empno),
    UNIQUE(job),
    FOREIGN KEY(deptno) REFERENCES DEPT01(deptno) 
);
-- (2) 테이블 레벨로 제약조건을 지정하는 방식 + 제약조건명 지정
CREATE TABLE emp08_2(
    empno NUMBER(4),
    ename VARCHAR2(10) NOT NULL,
    job VARCHAR2(9),
    deptno NUMBER(2),
    CONSTRAINT emp08_2_empno_pk PRIMARY KEY(empno),
    CONSTRAINT emp08_2_job_uk UNIQUE(job),
    CONSTRAINT emp08_2_deptno_fk FOREIGN KEY(deptno) REFERENCES DEPT01(deptno) 
);
-- 제약조건 확인
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME
FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP08_2';
-- 4. 제약 조건 변경하기
-- (1) 제약조건 추가하기
CREATE TABLE emp09(
    empno NUMBER(4),
    ename VARCHAR2(10),
    job VARCHAR2(9),
    deptno NUMBER(4)
); -- 아무 제약 조건 지정하지 않고 테이블 생성
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME
FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP09'; -- 제약조건 지정 안 하고 제약조건 확인해보기
-- 제약조건 추가하기
ALTER TABLE emp09
ADD PRIMARY KEY(empno);
ALTER TABLE emp09
ADD CONSTRAINT EMP09_deptno_fk FOREIGN KEY(deptno) REFERENCES dept01(deptno);
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME
FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP09';
-- (2) 제약 조건 제거하기
-- EMP06 테이블 제약조건 확인
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME
FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP06';
SELECT * FROM EMP06;
INSERT INTO EMP06
VALUES(7499, 'ALLEN', 'MANAGER', 50); -- 동일한 사원번호 7499 추가 안 됨. 기본키 제약조건 제거
ALTER TABLE EMP06
DROP CONSTRAINT EMP06_EMPNO_PK;
ALTER TABLE EMP06
DROP CONSTRAINT EMP06_DEPNO_FK;
-- 5. 외래키가 설정된 데이터 삭제
CREATE TABLE DEPT02(
    deptno NUMBER(2),
    dname VARCHAR2(14) NOT NULL,
    loc VARCHAR2(13),
    CONSTRAINT DEPT02_DEPTNO_PK PRIMARY KEY(deptno)
);
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME
FROM USER_CONSTRAINTS WHERE TABLE_NAME='DEPT02';
-- 샘플데이터를 추가
INSERT INTO DEPT02 VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT02 VALUES(20, 'RESEARCH', 'DALLAS');
SELECT * FROM DEPT02;
-- 사원테이블의 부서 번호가 부서 테이블의 부서 번호를 참조할 수 있도록 외래키 설정
DROP TABLE EMP02;
CREATE TABLE EMP02(
    empno NUMBER(4),
    ename VARCHAR2(10) NOT NULL,
    job VARCHAR2(9),
    deptno NUMBER(2),
    CONSTRAINT EMP02_EMPNO_PK PRIMARY KEY(EMPNO),
    CONSTRAINT EMP02_DEPTNO_FK FOREIGN KEY(DEPTNO) REFERENCES DEPT02(DEPTNO)
);
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME
FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP02';
-- 샘플데이터 추가
INSERT INTO EMP02 VALUES(7499,'ALLEN','SALESMAN',10);
INSERT INTO EMP02 VALUES(7369,'SMITH','CLERK',20);
-- 부모테이블에서 부서번호가 10인 부서데이터 삭제
DELETE FROM DEPT02 WHERE DEPTNO=10; -- 무결성 제약조건(HR.EMP02_DEPTNO_FK)이 위배되었습니다- 자식 레코드가 발견되었습니다
-- 부서번호가 10번인 자료 삭제하기 위해서는
-- (1)부서테이블의 10번 부어세어 근무하는 사원 삭제 후 부서테이블에서 10번 부서 삭제
-- (2)EMP02테이블의 외래키 제약 조건을 제거한 후에 10번 부서를 삭제
-- (3)ON DELETE CASCADE와 ON DELETE SET NULL 옵션으로 삭제
-- 진료과목 테이블 
CREATE TABLE TREATMENT(
    T_NO NUMBER(4) NOT NULL,
    T_COURSE_ABBR VARCHAR2(3) NOT NULL,
    T_COURSE VARCHAR2(30) NOT NULL,
    T_TEL VARCHAR2(15),
    CONSTRAINT TREATMENT_NO_PK PRIMARY KEY(T_NO),
    CONSTRAINT TREATMENT_COURSE_ABBR_UK UNIQUE(T_COURSE_ABBR)
);
INSERT INTO TREATMENT VALUES(1001,'NS','신경외과','02-3452-1009');
INSERT INTO TREATMENT VALUES(1002,'OS','정형외과','02-3452-2009');
INSERT INTO TREATMENT VALUES(1003,'C','순환기내과','02-3452-3009');
SELECT * FROM TREATMENT;
DESC TREATMENT;
COMMIT;
-- 의사 테이블
CREATE TABLE DOCTOR(
    D_NO NUMBER(4) NOT NULL,
    D_NAME VARCHAR2(20) NOT NULL,
    D_SSN CHAR(14) NOT NULL,
    D_EMAIL VARCHAR2(80) NOT NULL,
    D_MAJOR VARCHAR(50) NOT NULL,
    T_NO NUMBER(4),
    CONSTRAINT DOCTOR_D_NO_PK PRIMARY KEY(D_NO)
);
-- ON DELETE CASCADE 옵션
ALTER TABLE DOCTOR
ADD CONSTRAINT DOCTOR_T_NO_FK FOREIGN KEY(T_NO) REFERENCES TREATMENT(T_NO)
ON DELETE CASCADE; -- 부모테이블의 데이터가 삭제되면 자식테이블의 데이터도 함께 삭제된다.
INSERT INTO DOCTOR VALUES(1,'홍길동','660606-1234561','javauser@naver.com','척추신경외과','1001');
INSERT INTO DOCTOR VALUES(2,'이재환','690724-1674536','jaehwan@naver.com','뇌졸중,뇌혈관외과','1003');
INSERT INTO DOCTOR VALUES(3,'양익환','700129-1328962','sheep@naver.com','인공관절,관절염','1002');
INSERT INTO DOCTOR VALUES(4,'김승현','720901-1348940','seunghyeon@naver.com','종양외과,외상전문','1002');
SELECT * FROM DOCTOR;
COMMIT;
DELETE FROM TREATMENT WHERE T_NO=1002;
SELECT * FROM TREATMENT;
SELECT * FROM DOCTOR;
-- DELETE SET NULL 옵션
ROLLBACK;
ALTER TABLE DOCTOR
DROP CONSTRAINT DOCTOR_T_NO_FK; -- 제약조건 삭제
ALTER TABLE DOCTOR
ADD CONSTRAINT DOCTOR_T_NO_FK FOREIGN KEY(T_NO) REFERENCES TREATMENT(T_NO)
ON DELETE SET NULL;
DELETE FROM TREATMENT WHERE T_NO = 1002;
SELECT * FROM TREATMENT;
SELECT * FROM DOCTOR;

-- 테이블에 내용울 추가, 수정, 삭제하기 위한 DML
-- 1. 테이블에 새로운 행을 추가하는 INSERT문
CREATE TABLE DEPT(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13)
);
DESC DEPT;
-- 레코드 1개 추가하기
INSERT INTO DEPT(DEPTNO, DNAME, LOC) VALUES(10,'ACCOUNTING','NEWYORK');
SELECT * FROM DEPT;
-- 모든 칼럼에 자료를 순서대로 입력하는 경우 칼럼명을 생략해도 됨
INSERT INTO DEPT VALUES(20,'RESEARCH','DALLAS');
SELECT * FROM DEPT;
-- 암시적으로 NULL값 삽입 : 결정되지 않은 칼럼을 생략하면 암시적으로 NULL값이 할당됨
INSERT INTO DEPT(DEPTNO, DNAME) VALUES(30,'SALES');
-- 명시적으로 NULL값 삽입. NULL 대신 ''도 사용 가능
INSERT INTO DEPT VALUES(40,'OPERATIONS',NULL);
INSERT INTO DEPT VALUES(50,'','CHICAGO');
SELECT * FROM DEPT;
-- 기존 데이터 삭제하고 다시 입력작업하기
DELETE FROM DEPT;
-- 기존 테이블에 존재하는 데이터를 다른 테이블에 입력할 때 삽입 명령문
-- DEPT 테이블과 DEPARTMENTS 테이블의 컬럼 자릿수 일치하도록 테이블 수정
ALTER TABLE DEPT MODIFY(DEPTNO NUMBER(4), DNAME VARCHAR2(30));
INSERT INTO DEPT
SELECT DEPARTMENT_ID, DEPARTMENT_NAME, LOCATION_ID FROM DEPARTMENTS;
SELECT * FROM DEPT;
COMMIT;
-- <문제> TB_CUSTOMER 테이블에 아래 데이터를 추가하라
SELECT * FROM TB_CUSTOMER;
INSERT INTO TB_CUSTOMER(CUSTOMER_CD, CUSTOMER_NM, MW_FLG, BIRTH_DAY, PHONE_NUMBER, EMAIL, TOTAL_POINT, REG_DTTM)
VALUES('2017042','강원진','M','19810603','010-8202-8790','wjgang@navi.com',280300,'20170123132432');
INSERT INTO TB_CUSTOMER(CUSTOMER_CD, CUSTOMER_NM, MW_FLG, BIRTH_DAY, PHONE_NUMBER, EMAIL, TOTAL_POINT, REG_DTTM)
VALUES('2017053','나경숙','W','19891225','010-4509-0043','ksna#boram.co.kr',4500,'20170210180930');
INSERT INTO TB_CUSTOMER(CUSTOMER_CD, CUSTOMER_NM, MW_FLG, BIRTH_DAY, PHONE_NUMBER, EMAIL, TOTAL_POINT, REG_DTTM)
VALUES('2017108','박승대','M','19711430',NULL,'sdpark@haso.com',2345,'20170508203450');
SELECT * FROM TB_CUSTOMER;
COMMIT;
-- 2. 테이블의 내용을 수정하기 위한 UPDATE문
-- (1) 테이블의 모든 행 변경 : WHERE절을 추가하지 않으면 테이블의 모든 행이 변경된다
CREATE TABLE EMP
AS
SELECT * FROM EMPLOYEES;
SELECT * FROM EMP;
-- 모든 사원의 부서번호를 30번으로 수정
UPDATE EMP
SET DEPARTMENT_ID = 30;
-- 모든 사원의 급여를 10% 인상한다.
UPDATE EMP
SET SALARY = SALARY*1.1;
SELECT * FROM EMP;
-- 입사일을 오늘로 수정한다.
UPDATE EMP SET HIRE_DATE = SYSDATE;
--(2) 테이블의 특정 행만 변경
DROP TABLE EMP;
CREATE TABLE EMP
AS
SELECT * FROM EMPLOYEES;
-- 부서번호가 10번인 사원의 부서번호를 30번으로 수정
UPDATE EMP
SET DEPARTMENT_ID = 30
WHERE DEPARTMENT_ID = 10;
-- 급여가 3000 이상인 사원의 급여를 10% 인상
UPDATE EMP
SET SALARY = SALARY*1.1
WHERE SALARY>=3000;
SELECT * FROM EMP;
-- 2007년에 입사한 사원의 입사일을 오늘로 수정
UPDATE EMP
SET HIRE_DATE = SYSDATE
WHERE SUBSTR(HIRE_DATE, 1, 2) = '07';
-- (3) 테이블에서 2개 이상의 칼럼 값 변경
DROP TABLE EMP;
CREATE TABLE EMP
AS
SELECT * FROM EMPLOYEES;
-- Susan의 부서번호는 20번으로, 직급은 FI_MGR
SELECT * FROM EMP WHERE FIRST_NAME = 'Susan';
UPDATE EMP
SET DEPARTMENT_ID = 20, JOB_ID = 'FI_MGR'
WHERE FIRST_NAME = 'Susan';
SELECT * FROM EMP WHERE FIRST_NAME = 'Susan';
-- LAST_NAME이 Russell인 사원의 급여를 17000으로, 커미션 비율이 0.45로 인상된다.
SELECT * FROM EMP WHERE LAST_NAME='Russell';
UPDATE EMP
SET SALARY = 17000, COMMISSION_PCT = 0.45 WHERE LAST_NAME='Russell';
SELECT * FROM EMP WHERE LAST_NAME='Russell';
COMMIT;
-- <문제> TB_CUSTOMER 테이블에서 박승대 고객의 생년월일 19711230을 잘못하여 19711430으로 입력하였다. 생년월일을 수정하라.
SELECT * FROM TB_CUSTOMER WHERE CUSTOMER_NM = '박승대';
UPDATE TB_CUSTOMER
SET BIRTH_DAY='19711230' WHERE CUSTOMER_NM = '박승대';
SELECT * FROM TB_CUSTOMER WHERE CUSTOMER_NM = '박승대';

-- 3. 테이블에 불필요한 행(레코드)을 삭제하기 위한 DELETE문
SELECT * FROM DEPT;
DELETE FROM DEPT;
ROLLBACK;
DELETE FROM DEPT WHERE DEPTNO=30;
SELECT * FROM DEPT;

-- <예제> EMP01 테이블을 삭제한 후 다음과 같은 구조로 EMP01 테이블을 생성하라
DROP TABLE EMP01;
CREATE TABLE EMP01(
    EMPNO NUMBER(4) NOT NULL,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE NOT NULL,
    SAL NUMBER(7,2) NOT NULL,
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) NOT NULL
);
INSERT INTO EMP01 VALUES(7369,'SMITH','CLERK',7836,'80/12/17',800,NULL,20);
INSERT INTO EMP01 VALUES(7499,'ALLEN','SALESMAN',7369,'87/12/20',1600,300,30);
INSERT INTO EMP01 VALUES(7839,'KING','PRESIDENT',NULL,'81/02/08',5000,NULL,10);

-- 4. MERGE문 : 조건 비교하여 테이블에 해당 조건에 맍는 데이터 없으면 INSERT문, 있으면 UPDATE 수행
SELECT * FROM TB_CUSTOMER;
-- 실습위해 테이블 생성
CREATE TABLE TB_ADD_CUSTOMER(
    CUSTOMER_CD CHAR(7) NOT NULL,           -- 고객 코드
    CUSTOMER_NM VARCHAR2(10) NOT NULL,      -- 고객명
    MW_FLG CHAR(1) NOT NULL,                -- 성별구분
    BIRTH_DAY CHAR(8) NOT NULL,             -- 생일
    PHONE_NUMBER VARCHAR2(16),              -- 전화번호
    CONSTRAINT TB_ADD_CUSTOMER_CUSTOMER_CD_PK PRIMARY KEY(CUSTOMER_CD)
);
INSERT INTO TB_ADD_CUSTOMER(CUSTOMER_CD, CUSTOMER_NM, MW_FLG, BIRTH_DAY, PHONE_NUMBER)
VALUES('2017108','박승대','M','19711230','010-2580-9919');
INSERT INTO TB_ADD_CUSTOMER(CUSTOMER_CD, CUSTOMER_NM, MW_FLG, BIRTH_DAY, PHONE_NUMBER)
VALUES('2019302','전미래','W','19740812','010-8864-0232');
SELECT * FROM TB_ADD_CUSTOMER; -- TB_CUSTOMER에는 NULL값인 박승대씨 PHONE_NUMBER가 TB_ADD_CUSTOMER에는 있음. 전미래씨 데이터도 있음
SELECT * FROM TB_CUSTOMER;
-- TB_ADD_CUSTOMER 테이블의 내용을 TB_CUSTOMER와 비교하여 데이터가 있을 경우 업데이트 하고 없을 경우 추가하도록 쿼리문 작성
MERGE INTO TB_CUSTOMER CU USING TB_ADD_CUSTOMER NC ON (CU.CUSTOMER_CD = NC.CUSTOMER_CD)
    WHEN MATCHED THEN -- CU와 NC의 CUSTOMER_CD 매치
        UPDATE SET CU.CUSTOMER_NM = NC.CUSTOMER_NM,
                CU.MW_FLG = NC.MW_FLG,
                CU.BIRTH_DAY = NC.BIRTH_DAY,
                CU.PHONE_NUMBER = NC.PHONE_NUMBER
    WHEN NOT MATCHED THEN
        INSERT (CU.CUSTOMER_CD,CU.CUSTOMER_NM,CU.MW_FLG,CU.BIRTH_DAY,CU.PHONE_NUMBER,CU.EMAIL,CU.TOTAL_POINT,CU.REG_DTTM)
        VALUES(NC.CUSTOMER_CD,NC.CUSTOMER_NM,NC.MW_FLG,NC.BIRTH_DAY,NC.PHONE_NUMBER,'',0,TO_CHAR(SYSDATE,'YYYYMMDDHHMISS'));
SELECT * FROM TB_CUSTOMER;    

-- 단일행 함수 예제
-- 문제1) 각 사원의 성(last_name)이 ‘s’로 끝나는 사원의 이름(이름 성순으로)과 업무를 아래의 예와 같이 출력하고자 한다.
-- 출력 시 성과 이름은 첫 글자가 대문자, 업무는 모두 소문자로 출력하고 머리글은 Employee JOBs로 표시하시오.
-- [출력형식] Shelley Higgins is a ac_mgr
SELECT INITCAP(FIRST_NAME)||' '||INITCAP(LAST_NAME)||' is a '||LOWER(JOB_ID) "Empoyee JOBs"
FROM EMPLOYEES;

-- 문제2) EMPLOYEES Table에서 이름, 급여, 커미션 금액, 총액(급여 + 커미션)을 구하여 총액이 많은 순서로 출력하라.
-- 단, 커미션이 NULL인 사람은 제외한다.
SELECT FIRST_NAME, SALARY, NVL2(COMMISSION_PCT, SALARY*COMMISSION_PCT, 0) COMMISSION, NVL2(COMMISSION_PCT, SALARY+SALARY*COMMISSION_PCT, SALARY) TOTAL
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL
ORDER BY NVL2(COMMISSION_PCT, SALARY+SALARY*COMMISSION_PCT, SALARY);

-- 문제3) 이번 분기에 60번 IT 부서에서는 신규 프로그램을 개발하고 보급하여 회사에 공헌하였다. 
-- 이에 해당 부서의 사원 급여를 12.3% 인상하기로 하였다. 
-- 60번 IT 부서 사원의 급여를 12.3% 인상하여 정수만(반올림) 표시하는 보고서를 작성하시오. 
-- 출력 형식은 사번, 이름과 성(Name으로 별칭), 급여, 인상된 급여(Increased Salary로 별칭)순으로 출력한다 
SELECT EMPLOYEE_ID, FIRST_NAME||' '||LAST_NAME "Name", SALARY, SALARY*1.123 "Increased Salary"
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;

-- 문제4) 급여가 $1,500부터 $3,000 사이의 사람은 급여의 15%를 회비로 지불하기로 하였다. 
-- 이를 이름, 급여, 회비(소수점이하 반올림)를 출력하라.
SELECT FIRST_NAME, SALARY, ROUND(SALARY*0.15)
FROM EMPLOYEES
WHERE SALARY BETWEEN 1500 AND 3000;

-- 문제5) 모든 사원의 실수령액을 계산하여 출력하라. 단, 급여가 많은 순으로 이름, 급여, 실수령액을 출력하라. 
-- (실수령액은 금여에 대해 10%의 세금을 뺀 금액)
SELECT FIRST_NAME, SALARY, (SALARY-SALARY*0.1) "After-tax Salary"
FROM EMPLOYEES
ORDER BY SALARY DESC;

-- 문제6) 모든 사원의 연봉을 표시하는 보고서를 작성하려고 한다. 
-- 보고서에 사원의 성과 이름(Name으로 별칭), 급여, 수당여부에 따른 연봉을 포함하여 출력하시오.
-- 수당여부는 수당이 있으면 “Salary + Commission”, 수당이 없으면 “Salary only”라고 표시하고, 별칭은 적절히 붙인다. 
-- 또한 출력 시 연봉이 높은 순으로 정렬한다.
SELECT FIRST_NAME||' '||LAST_NAME "Name", SALARY, NVL2(TO_CHAR(COMMISSION_PCT), 'Salary + Commission', 'Salary only') Commission, NVL2(COMMISSION_PCT, SALARY+SALARY*COMMISSION_PCT, SALARY) "ANNUAL SALARY"
FROM EMPLOYEES
ORDER BY NVL2(COMMISSION_PCT, SALARY+SALARY*COMMISSION_PCT, SALARY);

-- 그룹함수
-- 1. 그룹함수의 종류
-- (1) SUM 함수
-- 직원의 총급여 구하기
SELECT SUM(SALARY) FROM EMPLOYEES;
SELECT TO_CHAR(SUM(SALARY), '$999,999') AS TOTAL FROM EMPLOYEES;
-- (2) AVG 함수
-- 직원의 평균 급여 구하기
SELECT AVG(SALARY) FROM EMPLOYEES;
SELECT ROUND(AVG(SALARY),1) FROM EMPLOYEES;
-- (3) MAX/MIN 함수
-- 최근에 입사한 사원과 가장 오래 전에 입사한 사원의 입사일 출력하기
SELECT TO_CHAR(MAX(HIRE_DATE),'YYYY-MM-DD'), TO_CHAR(MIN(HIRE_DATE),'YYYY-MM-DD')
FROM EMPLOYEES;
-- (4) COUNT 함수
-- 전체 사원의 수와 커미션 받는 사원의 수
SELECT COUNT(*), COUNT(EMPLOYEE_ID), COUNT(COMMISSION_PCT) FROM EMPLOYEES;
-- <문제> JOB의 종류가 몇 개인지 즉, 중복되지 않은 직업의 개수를 구해보자.
SELECT COUNT(DISTINCT JOB_ID) FROM EMPLOYEES;
-- 컬럼과 그룹함수 같이 사용할 때 유의할 점
SELECT FIRST_NAME, MIN(SALARY) FROM EMPLOYEES; -- 오류 : 단일 그룹의 그룹 함수가 아닙니다

-- 2. GROUP BY 절을 사용해 특정 조건으로 세부적인 그룹화하기
-- 사원들을 부서번호를 기준으로
SELECT DEPARTMENT_ID FROM EMPLOYEES
ORDER BY DEPARTMENT_ID;
SELECT DEPARTMENT_ID FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;
-- 부서별 최대 급여와 최소 급여 구하기
SELECT DEPARTMENT_ID, MAX(SALARY) "최대 급여", MIN(SALARY) "최소 급여" FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;
-- 소속 부서별 급여의 합과 급여의 평균 구하기
SELECT DEPARTMENT_ID, SUM(SALARY), FLOOR(AVG(SALARY)),ROUND(AVG(SALARY)), ROUND(AVG(SALARY),1) FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;
-- <문제> 부서별로 직원의 수와 커미션을 받는 직원의 수를 카운트해보자.
SELECT DEPARTMENT_ID, COUNT(EMPLOYEE_ID), COUNT(COMMISSION_PCT)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;
-- <추가 질문> 급여가 8000이상인 사원들만 카운트 해보자
SELECT DEPARTMENT_ID, COUNT(EMPLOYEE_ID) FROM EMPLOYEES
WHERE SALARY>=8000
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;
-- <문제> 30번 부서에 가장 오랜기간 근무한 사원의 입사일을 출력하라.
SELECT DEPARTMENT_ID, MAX(HIRE_DATE) FROM EMPLOYEES
WHERE DEPARTMENT_ID = 30
GROUP BY DEPARTMENT_ID;
-- <문제> 부서별 같은 업무를 담당하는 사원 수를 구하라.
SELECT DEPARTMENT_ID, JOB_ID FROM EMPLOYEES
ORDER BY DEPARTMENT_ID;                         -- 먼저 부서, 업무를 조회해보기
SELECT DEPARTMENT_ID, JOB_ID FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID                  -- 부서와 업무로 묶어보기
ORDER BY DEPARTMENT_ID;
-- 그룹함수와 일반칼럼 같이 사용할 경우 일반칼럼 모두 GROUP BY에 와야함
SELECT DEPARTMENT_ID, JOB_ID, COUNT(EMPLOYEE_ID) FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID                  -- 부서별 업무별 사원수 구하기 
ORDER BY DEPARTMENT_ID;

-- 3. HAVING 조건
SELECT DEPARTMENT_ID, ROUND(AVG(SALARY),1)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;
-- 구한 평균값이 5000 이상인 부서 조회
SELECT DEPARTMENT_ID, ROUND(AVG(SALARY),1)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY)>=5000
ORDER BY DEPARTMENT_ID;
-- 부서별로 임금의 최대값, 최소값을 구하고 이 중 최대값이 5000을 넘는 부서만 조회
SELECT DEPARTMENT_ID, MAX(SALARY), MIN(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING MAX(SALARY) > 5000
ORDER BY DEPARTMENT_ID;
-- 부서별 인원수를 구하여 그 인원수가 4명 초과하는 부서를 조회하는 쿼리문을 작성하시오
SELECT DEPARTMENT_ID, COUNT(EMPLOYEE_ID)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING COUNT(EMPLOYEE_ID) > 4
ORDER BY DEPARTMENT_ID;

-- 4. 각 기준별 소계를 요약해서 보여주는 ROLLUP 함수
-- 부서와 직무별 급여의 합 및 사원수와
-- 부서별 급여의 합과 사원수,
-- 전체 사원의 급여의 합과 사원수를 구하세요.
-- (1) 따로 따로 구하기
SELECT DEPARTMENT_ID, JOB_ID, SUM(SALARY), COUNT(EMPLOYEE_ID)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID
ORDER BY DEPARTMENT_ID;

SELECT DEPARTMENT_ID, NULL JOB_ID, SUM(SALARY), COUNT(EMPLOYEE_ID)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;

SELECT NULL DEPARTMENT_ID, NULL JOB_ID, SUM(SALARY), COUNT(EMPLOYEE_ID)
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID;
-- (2) 집합 연산자 UNION ALL 이용
SELECT DEPARTMENT_ID, JOB_ID, SUM(SALARY), COUNT(EMPLOYEE_ID)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID
UNION ALL
SELECT DEPARTMENT_ID, NULL JOB_ID, SUM(SALARY), COUNT(EMPLOYEE_ID)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
UNION ALL
SELECT NULL DEPARTMENT_ID, NULL JOB_ID, SUM(SALARY), COUNT(EMPLOYEE_ID)
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID;
-- (3) ROLLUP 함수로 한 번에 구하기
SELECT DEPARTMENT_ID, JOB_ID, COUNT(EMPLOYEE_ID), SUM(SALARY)
FROM EMPLOYEES
GROUP BY ROLLUP(DEPARTMENT_ID, JOB_ID)
ORDER BY DEPARTMENT_ID;
-- 직무별 부서별 급여의 합과 사원수, 직무별 급여의 합과 사원수, 전체 사원의 급여와 사원수
SELECT JOB_ID, DEPARTMENT_ID, COUNT(EMPLOYEE_ID), SUM(SALARY)
FROM EMPLOYEES
GROUP BY ROLLUP(JOB_ID, DEPARTMENT_ID)
ORDER BY JOB_ID;

-- 5. CUBE(exp1, exp2, ...) : 소계와 전체 합계까지 출력하는 함수
SELECT DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
FROM EMPLOYEES
GROUP BY CUBE(DEPARTMENT_ID, JOB_ID)
ORDER BY DEPARTMENT_ID;

-- 6. 집합연산자 : 여러개의 SELECT 문을 연결해 또 다른 하나의 쿼리를 만드는 역할
CREATE TABLE exp_goods_asia ( -- 한국과 일본의 10대 수출품 테이블 
       country VARCHAR2(10),     -- 나라명
       seq     NUMBER,           -- 번호
       goods   VARCHAR2(80)     -- 상품명 
);

INSERT INTO exp_goods_asia VALUES ('한국', 1, '원유제외 석유류');
INSERT INTO exp_goods_asia VALUES ('한국', 2, '자동차');
INSERT INTO exp_goods_asia VALUES ('한국', 3, '전자집적회로');
INSERT INTO exp_goods_asia VALUES ('한국', 4, '선박');
INSERT INTO exp_goods_asia VALUES ('한국', 5,  'LCD');
INSERT INTO exp_goods_asia VALUES ('한국', 6,  '자동차부품');
INSERT INTO exp_goods_asia VALUES ('한국', 7,  '휴대전화');
INSERT INTO exp_goods_asia VALUES ('한국', 8,  '환식탄화수소');
INSERT INTO exp_goods_asia VALUES ('한국', 9,  '무선송신기 디스플레이 부속품');
INSERT INTO exp_goods_asia VALUES ('한국', 10,  '철 또는 비합금강');

INSERT INTO exp_goods_asia VALUES ('일본', 1, '자동차');
INSERT INTO exp_goods_asia VALUES ('일본', 2, '자동차부품');
INSERT INTO exp_goods_asia VALUES ('일본', 3, '전자집적회로');
INSERT INTO exp_goods_asia VALUES ('일본', 4, '선박');
INSERT INTO exp_goods_asia VALUES ('일본', 5, '반도체웨이퍼');
INSERT INTO exp_goods_asia VALUES ('일본', 6, '화물차');
INSERT INTO exp_goods_asia VALUES ('일본', 7, '원유제외 석유류');
INSERT INTO exp_goods_asia VALUES ('일본', 8, '건설기계');
INSERT INTO exp_goods_asia VALUES ('일본', 9, '다이오드, 트랜지스터');
INSERT INTO exp_goods_asia VALUES ('일본', 10, '기계류');

SELECT * FROM EXP_GOODS_ASIA; 
COMMIT;

-- (1) UNION 합집합 : 중복 레코드 한 번만 출력
SELECT * FROM EXP_GOODS_ASIA
WHERE COUNTRY = '한국';
SELECT * FROM EXP_GOODS_ASIA
WHERE COUNTRY = '일본';
-- 두 국가가 겹치는 수출품목 한 번만 조회
SELECT GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY = '한국'
UNION
SELECT GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY = '일본';
-- hr스키마에 있는 job_history은 사원들의 업무 변경 이력 나타내는 테이블
-- 이 정보 이용하여 모든 사원의 현재 및 이전의 업무 이력 정보를 출력하고자 함. 중복된 사원정보는 한 번만 표시하시오
SELECT * FROM JOB_HISTORY;
SELECT EMPLOYEE_ID, JOB_ID
FROM EMPLOYEES
UNION
SELECT EMPLOYEE_ID, JOB_ID
FROM JOB_HISTORY;
-- 위 결과를 이용하여 출력된 176번 사원의 업무 이력의 변경 날짜 이력을 조회하시오
SELECT EMPLOYEE_ID, JOB_ID, NULL "Start Date", NULL "End Date"
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 176
UNION
SELECT EMPLOYEE_ID, JOB_ID, START_DATE, END_DATE
FROM JOB_HISTORY
WHERE EMPLOYEE_ID = 176;
-- (2) UNION ALL : 중복된 항목도 모두 조회
SELECT GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY = '한국'
UNION ALL
SELECT GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY = '일본';
-- <문제> 위 예제에서 각 사원의 업무 이력 정보를 확인하였다. 하지만 모든 사원의 업무 이력 전체를 보지는 못했다.
-- 여기에서는 모든 사원의 업무 이력 변경 정보 및 업무 변경에 따른 부서정보를 사번이 빠른 순서대로 출력하시오
SELECT * FROM JOB_HISTORY;
SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID
FROM EMPLOYEES
UNION ALL
SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID
FROM JOB_HISTORY
ORDER BY EMPLOYEE_ID; -- 정렬문장은 맨 마지막 문장에서만 사용할 수 있음!
-- (3) INTERSECT : 교집합. 공통된 항목만 추출
SELECT GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY = '한국'
INTERSECT
SELECT GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY = '일본';
-- <문제> 사원정보 테이블에 JOB_ID는 사원의 현재 업무를 뜻하고, JOB_HISTORY에 있는 JOB_ID는 사원의 이전 업무를 뜻한다.
-- 이 두 테이블을 교차해보면 업무가 변경된 사원의 정보도 볼 수 있지만 이전에 한 번 했던 같은 업무를 그대로 하고 있는 사원의 정보도 볼 수 있다.
-- 이전에 한 번 했던 같은 업무를 보고 있는 사원의 사번과 업무를 출력하시오.
SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID
FROM EMPLOYEES
INTERSECT
SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID
FROM JOB_HISTORY
ORDER BY EMPLOYEE_ID;
-- (4) MINUS : 차집합. 공통된 항목을 제외한 결과만 추출
SELECT GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY = '한국'
MINUS
SELECT GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY = '일본';
-- <문제> 우리 회사는 1년에 한 번 업무를 변경하여 전체적인 회사 업무를 사워늘이 익히도록 하는 ROLE CHANGE
-- 정책을 시해하고 있다. 이번 인사이동 때 아직 업무가 변경된 적이 없는 사원들을 적합한 업무로 이동시키려고 한다.
-- HR부서의 사원정보 테이블과 업무이력정보 테이블을 이용하여 한 번도 업무가 변경되지 않은 사원의 사번을 출력하시오.
SELECT * FROM JOB_HISTORY;
SELECT EMPLOYEE_ID
FROM EMPLOYEES
MINUS
SELECT EMPLOYEE_ID
FROM JOB_HISTORY;
        
--(5) 집합 연산자의 제한 사항
-- 집합 연산자로 연결되는 각 SELECT문의 컬럼 개수와 데이터 타입은 일치해야 함
SELECT GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY='한국'
UNION
SELECT SEQ, GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY='일본'; -- 오류 : 질의 블록은 부정확한 수의 결과 열을 가지고 있습니다.
SELECT SEQ
FROM EXP_GOODS_ASIA
WHERE COUNTRY='한국'
UNION
SELECT GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY='일본'; -- 오류 : 대응하는 식과 같은 데이터 유형이어야 합니다.
-- 집합 연산자로 SELECT문을 연결할 때 ORDER BY 절은 맨 마지막 문장에서만 사용할 수 있다.
SELECT SEQ
FROM EXP_GOODS_ASIA
WHERE COUNTRY='한국'
ORDER BY GOODS
UNION
SELECT GOODS
FROM EXP_GOODS_ASIA
WHERE COUNTRY='일본';  -- 오류 : SQL 명령어가 올바르게 종료되지 않았습니다
-- (6) GROUPING SETS절
SELECT DEPARTMENT_ID, JOB_ID
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID;

SELECT DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID
ORDER BY DEPARTMENT_ID;

SELECT DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
FROM EMPLOYEES
GROUP BY ROLLUP(DEPARTMENT_ID, JOB_ID)
ORDER BY DEPARTMENT_ID;

SELECT DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
FROM EMPLOYEES
GROUP BY CUBE(DEPARTMENT_ID, JOB_ID)
ORDER BY DEPARTMENT_ID;

SELECT DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
FROM EMPLOYEES
GROUP BY GROUPING SETS(DEPARTMENT_ID, JOB_ID)
ORDER BY DEPARTMENT_ID;

-- <그룹함수 예제>
-- 1. EMPLOYEES 테이블에서 부서 인원이 5명보다 많은 부서의 부서번호, 인원수, 급여의 합을 출력하라.
SELECT DEPARTMENT_ID, COUNT(EMPLOYEE_ID), SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;

-- 2. EMPLOYEES 테이블을 사용하여 사원 중에서 급여(SALARY)와 보너스를 합친 금액이 가장 많은 경우와 가장 적은 경우, 평균 금액을 구하세요.
-- 단 보너스가 없을 경우는 보너스를 0으로, 출력 금액은 모두 소수점 첫째 자리까지만 나오게 하세요.
SELECT MAX(SALARY + SALARY*NVL(COMMISSION_PCT,0)), MIN(SALARY + SALARY*NVL(COMMISSION_PCT,0)), ROUND(AVG(SALARY + SALARY*NVL(COMMISSION_PCT,0)),1)
FROM EMPLOYEES;

-- 3. EMPLOYEES 테이블에서 부서번호가 10인 사원수부터 부서번호가 50인 사원수까지를 각각 출력하라.
SELECT DEPARTMENT_ID FROM EMPLOYEES;
SELECT COUNT(DECODE(DEPARTMENT_ID, 10, 1)) "10번부서인원수", COUNT(DECODE(DEPARTMENT_ID, 20, 1)) "20번부서인원수",
       COUNT(DECODE(DEPARTMENT_ID, 30, 1)) "30번부서인원수", COUNT(DECODE(DEPARTMENT_ID, 40, 1)) "40번부서인원수",
       COUNT(DECODE(DEPARTMENT_ID, 50, 1)) "50번부서인원수"
FROM EMPLOYEES;

-- 4. 사원들의 업무별 전체 급여 평균이 $10,000보다 큰 경우를 조회하여 업무, 급여 평균을 출력하시오.
-- 단 업무에 CLERK이 포함된 경우는 제외하고 전체 급여 평균이 높은 순서대로 출력하시오.
SELECT JOB_ID, ROUND(AVG(SALARY))
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING ROUND(AVG(SALARY)) > 10000
ORDER BY ROUND(AVG(SALARY)) DESC;

-- 5. EMPLOYEES 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.
SELECT * FROM EMPLOYEES;
SELECT SUBSTR(TO_CHAR(HIRE_DATE,'YYYY-MM-DD'),1,4) H_YEAR, COUNT(EMPLOYEE_ID) 사원수, MIN(SALARY) 최소급여, MAX(SALARY) 최대급여, ROUND(AVG(SALARY),2) "급여의 평균", SUM(SALARY) "급여의 합"
FROM EMPLOYEES
WHERE SUBSTR(TO_CHAR(HIRE_DATE,'YYYY-MM-DD'),1,4) BETWEEN 2001 AND 2008
GROUP BY SUBSTR(TO_CHAR(HIRE_DATE,'YYYY-MM-DD'),1,4)
ORDER BY H_YEAR;

-- 6. 각 부서 별 평균 급여가 10000 이상이면 초과, 그렇지 않으면 미만을 출력하라. 단 부서번호가 없는 사원은 제외한다.
SELECT DEPARTMENT_ID 부서번호, ROUND(AVG(SALARY)) 부서별평균급여, CASE WHEN ROUND(AVG(SALARY))>=10000 THEN '초과'
                                                                   WHEN ROUND(AVG(SALARY))<10000 THEN '미만' END 평균급여        
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;

-- 7. EMPLOYEES 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.
SELECT HIRE_DATE FROM EMPLOYEES;
SELECT SUBSTR(TO_CHAR(HIRE_DATE),1,2) FROM EMPLOYEES;
SELECT COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE),1,2),'01',1,'02',1,'03',1,'04',1,'05',1,'06',1,'07',1,'08',1)) TOTAL, 
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE),1,2),'01',1)) "2001년도", 
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE),1,2),'02',1)) "2002년도", 
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE),1,2),'03',1)) "2003년도", 
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE),1,2),'04',1)) "2004년도", 
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE),1,2),'05',1)) "2005년도", 
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE),1,2),'06',1)) "2006년도", 
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE),1,2),'07',1)) "2007년도", 
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE),1,2),'08',1)) "2008년도"                         
FROM EMPLOYEES;
                         
-- 8. EMPLOYEES 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.
SELECT JOB_ID, NVL(SUM(DECODE(DEPARTMENT_ID, 10, SALARY)),0) "DEPTNO 10", NVL(SUM(DECODE(DEPARTMENT_ID, 10, SALARY)),0) "DEPTNO 20",
               NVL(SUM(DECODE(DEPARTMENT_ID, 30, SALARY)),0) "DEPTNO 30", NVL(SUM(DECODE(DEPARTMENT_ID, 40, SALARY)),0) "DEPTNO 40",
               NVL(SUM(DECODE(DEPARTMENT_ID, 50, SALARY)),0) "DEPTNO 50", NVL(SUM(DECODE(DEPARTMENT_ID, 60, SALARY)),0) "DEPTNO 60",
               NVL(SUM(DECODE(DEPARTMENT_ID, 70, SALARY)),0) "DEPTNO 70", NVL(SUM(DECODE(DEPARTMENT_ID, 80, SALARY)),0) "DEPTNO 80",
               NVL(SUM(DECODE(DEPARTMENT_ID, 90, SALARY)),0) "DEPTNO 90", NVL(SUM(DECODE(DEPARTMENT_ID, 100, SALARY)),0) "DEPTNO 100",
               NVL(SUM(DECODE(DEPARTMENT_ID, 110, SALARY)),0) "DEPTNO 110",
               NVL(SUM(DECODE(DEPARTMENT_ID, 10, SALARY, 20, SALARY, 30, SALARY, 40, SALARY, 50, SALARY, 60, SALARY, 70, SALARY, 80, SALARY, 90, SALARY, 100, SALARY, 110, SALARY)),0) "TOTAL"
FROM EMPLOYEES
GROUP BY JOB_ID;


-- 조인(JOIN)
-- 1. CARTESIAN PRODUCT(카티션 곱) 또는 CROSS JOIN
-- WHERE절에 의해 공통되는 칼럼에 의한 결합이 발생되지 않는 경우. 해당 조인에 참여하는 모든 대상 행 다 출력. 사용 거의 안 함
SELECT * FROM EMPLOYEES, DEPARTMENTS;

-- 2. EQUI JOIN(INNER JOIN)
-- 두 테이블에서 공통적으로 존재하는 칼럼의 값이 일치되는 행 연결하여 결과 생성
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID
FROM EMPLOYEES;
SELECT DEPARTMENT_ID, DEPARTMENT_NAME
FROM DEPARTMENTS;

SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES, DEPARTMENTS
WHERE EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;
-- 테이블 명 너무 긴 경우 별칭 부여해서 문장 간단히 기술 가능
SELECT E.FIRST_NAME, D.DEPARTMENT_NAME, E.DEPARTMENT_ID
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID;

-- EQUI JOIN에 AND 연산하기
-- Susan인 직원의 정보만을 출력
SELECT E.FIRST_NAME, D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND E.FIRST_NAME='Susan';

-- 3. NON-EQUI JOIN : 조인할 테이블 사이 칼럼값이 직접적으로 일치하지 않을 때
CREATE TABLE SALARYGRADE(
    GRADE NUMBER,
    MINSALARY NUMBER,
    MAXSALARY NUMBER
);

INSERT INTO SALARYGRADE(GRADE, MINSALARY, MAXSALARY) VALUES(1, 2000, 3000);
INSERT INTO SALARYGRADE(GRADE, MINSALARY, MAXSALARY) VALUES(2, 3001, 4500);
INSERT INTO SALARYGRADE(GRADE, MINSALARY, MAXSALARY) VALUES(3, 4501, 6000);
INSERT INTO SALARYGRADE(GRADE, MINSALARY, MAXSALARY) VALUES(4, 6001, 8000);
INSERT INTO SALARYGRADE(GRADE, MINSALARY, MAXSALARY) VALUES(5, 8001, 10000);
INSERT INTO SALARYGRADE(GRADE, MINSALARY, MAXSALARY) VALUES(6, 10001, 13000);
INSERT INTO SALARYGRADE(GRADE, MINSALARY, MAXSALARY) VALUES(7, 130001, 20000);
INSERT INTO SALARYGRADE(GRADE, MINSALARY, MAXSALARY) VALUES(8, 20001, 30000);

SELECT * FROM SALARYGRADE;
COMMIT;

SELECT E.FIRST_NAME, E.SALARY, S.GRADE
FROM EMPLOYEES E, SALARYGRADE S
WHERE E.SALARY BETWEEN S.MINSALARY AND S.MAXSALARY;
SELECT E.FIRST_NAME, E.SALARY, S.GRADE
FROM EMPLOYEES E, SALARYGRADE S
WHERE (E.SALARY >= S.MINSALARY) AND (E.SALARY <= S.MAXSALARY);

-- 4. OUTER JOIN : 조인 조건에 만족하지 않는 행들도 모두 조회
-- 부서테이블 조회하면 번호가 110번 이상인 부서 존재하지만 조인 결과 110번까지만 출력됨
-- 직원테이블의 부서번호에는 110번 보다 큰 번호 존재하지 않기 때문임
SELECT E.FIRST_NAME, D.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
ORDER BY E.DEPARTMENT_ID;

SELECT E.FIRST_NAME, D.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID(+) = D.DEPARTMENT_ID
ORDER BY E.DEPARTMENT_ID;
-- 2007년도 상반기 입사사원 구하기
SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, DEPARTMENT_ID
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN '2007/01/01' AND '2007/06/30';
-- 2007년도 상반기에 입사한 사원번호, 사원명, 입사일, 부서명 구하기
SELECT E.EMPLOYEE_ID, E.HIRE_DATE, D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID 
AND HIRE_DATE BETWEEN '2007/01/01' AND '2007/06/30'; -- 1명 사라짐? -> 부서배치 받지 않은 사람 누락
SELECT E.EMPLOYEE_ID, E.HIRE_DATE, D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+) 
AND HIRE_DATE BETWEEN '2007/01/01' AND '2007/06/30';

-- 5. SELF JOIN : 자기 자신과 조인 맺을 때 서로 다른 테이블인 것처럼 인식할 수 있도록 별칭 부여
-- 특정 사원을 담당하는 매니저 사원의 이름 추력
SELECT * FROM EMPLOYEES;
SELECT EMPLOYEE_ID, FIRST_NAME, MANAGER_ID
FROM EMPLOYEES;
-- EMPLOYEES 테이블에 WORK, MANAGER로 별칭 부여
SELECT WORK.FIRST_NAME 사원명, MANAGER.FIRST_NAME 매니저명
FROM EMPLOYEES WORK, EMPLOYEES MANAGER
WHERE WORK.MANAGER_ID = MANAGER.EMPLOYEE_ID;

SELECT RPAD(WORK.FIRST_NAME,11,' ')||'의 매니저는 '||MANAGER.FIRST_NAME||'이다.' AS "그 사원의 매니저"
FROM EMPLOYEES WORK, EMPLOYEES MANAGER
WHERE WORK.MANAGER_ID = MANAGER.EMPLOYEE_ID;

-- 6. ANSI JOIN
-- (1) ANSI CROSS JOIN
SELECT * FROM EMPLOYEES CROSS JOIN DEPARTMENTS;
-- (2) ANSI INNER JOIN
SELECT FIRST_NAME, DEPARTMENT_NAME 
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;
SELECT FIRST_NAME, DEPARTMENT_NAME 
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE FIRST_NAME='Susan';
-- USING을 이용한 조인 조건 지정
SELECT FIRST_NAME, DEPARTMENT_NAME 
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
USING(DEPARTMENT_ID)
WHERE FIRST_NAME='Susan';
-- (3) ANSI OUTER JOIN
SELECT E.FIRST_NAME, E.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES E RIGHT OUTER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;
SELECT E.FIRST_NAME, E.HIRE_DATE, D.DEPARTMENT_NAME
FROM EMPLOYEES E LEFT OUTER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE HIRE_DATE>='2007/01/01' AND HIRE_DATE<='2007/06/30';

-- <조인 예제>
-- 1. Sales 부서 소속 사원의 이름과 입사일을 출력하라.
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE DEPARTMENT_NAME = 'Sales';

SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
USING(DEPARTMENT_ID)
WHERE DEPARTMENT_NAME = 'Sales';

-- 2. 커미션을 받는 사원의 이름, 커미션 비율과 그가 속한 부서명을 출력하라.
SELECT FIRST_NAME, COMMISSION_PCT, DEPARTMENT_NAME
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
USING(DEPARTMENT_ID)
WHERE COMMISSION_PCT IS NOT NULL;

-- 3. IT부서에서 근무하고 있는 사원번호, 이름, 업무, 부서명을 출력하라. 
SELECT FIRST_NAME, JOB_ID, DEPARTMENT_NAME
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
USING(DEPARTMENT_ID)
WHERE DEPARTMENT_NAME = 'IT';

-- 4. EMPLOYEES, DEPARTMENTS 테이블의 구조를 파악한 후 사원수가 5명 이상인 부서의 부서명과 사원수를 출력하시오. 
-- 이때 사원수가 많은 순으로 정렬하시오.
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT D.DEPARTMENT_NAME 부서명, COUNT(E.EMPLOYEE_ID) 사원수
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
USING(DEPARTMENT_ID)
GROUP BY D.DEPARTMENT_NAME
HAVING COUNT(E.EMPLOYEE_ID) >= 5
ORDER BY COUNT(E.EMPLOYEE_ID) DESC;

-- 5. Guy과 동일한 부서에서 근무하는 동료들의 이름과 부서번호를 출력하라.
SELECT * FROM EMPLOYEES WHERE FIRST_NAME='Guy';
SELECT FIRST_NAME, DEPARTMENT_ID
FROM EMPLOYEES
--FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
--USING(DEPARTMENT_ID)
WHERE DEPARTMENT_ID = 30;

-- 6. EMPLOYEES, DEPARTMENTS, LOCATIONS 테이블의 구조를 파악한 후 
-- Oxford에 근무하는 사원의 성과 이름(Name으로 별칭), 업무, 부서명, 도시명을 출력하시오.
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM LOCATIONS;

SELECT E.FIRST_NAME||' '||E.LAST_NAME "Name", E.JOB_ID, D.DEPARTMENT_NAME, L.CITY
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
                 INNER JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID
WHERE L.CITY = 'Oxford';

-- 7. 각 사원과 직속 상사와의 관계를 이용하여 다음과 같은 형식의 보고서를 작성하고자 한다. 
-- 홍길동은 허균에게 보고한다 → Eleni Zlotkey report to Steven King
-- 어떤 사원이 어떤 사원에서 보고하는지를 위 예를 참고하여 출력하시오. 
-- 단, 보고할 상사가 없는 사원이 있다면 그 정보도 포함하여 출력하고, 상사의 이름은 대문자로 출력하시오
SELECT * FROM EMPLOYEES;
SELECT *  FROM EMPLOYEES WHERE FIRST_NAME='Ellen';

SELECT E.FIRST_NAME||' report to '||NVL(UPPER(M.FIRST_NAME), 'NOBODY')
FROM EMPLOYEES E LEFT OUTER JOIN EMPLOYEES M
ON E.MANAGER_ID = M.EMPLOYEE_ID;

-- 서브쿼리
-- 1. 서브쿼리의 기본 개념
-- 직원의 이름이 Susan인 직원이 어떤 부서 소속인지 소속 부서명 알아내려면? (조인이 아닌 서브쿼리문을 이용해서)
SELECT DEPARTMENT_ID FROM EMPLOYEES
WHERE FIRST_NAME = 'Susan'; -- 40
SELECT DEPARTMENT_NAME FROM DEPARTMENTS
WHERE DEPARTMENT_ID = 40; -- HUMAN RESOURCE
-- 이를 서브쿼리문으로 작성
SELECT DEPARTMENT_NAME FROM DEPARTMENTS
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM EMPLOYEES
                       WHERE FIRST_NAME = 'Susan');
-- EMPLOYEES 테이블에서 Lex와 같은 부서에 있는 모든 사원의 이름과 입사일자(형식:2003-01-13)을 출력
SELECT DEPARTMENT_ID FROM EMPLOYEES
WHERE FIRST_NAME = 'Lex'; -- 90
SELECT FIRST_NAME 이름, TO_CHAR(HIRE_DATE,'YYYY-MM-DD') 입사일자
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 90;
-- 서브쿼리문으로 작성
SELECT FIRST_NAME 이름, TO_CHAR(HIRE_DATE,'YYYY-MM-DD') 입사일자
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM EMPLOYEES
                       WHERE FIRST_NAME = 'Lex');

-- 2. 단일행 서브쿼리
-- Guy와 같은 부서에서 근무하는 사원의 정보를 출력
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, NVL(COMMISSION_PCT, 0) COMMISSION_PCT, TO_CHAR(HIRE_DATE,'YYYY.MM.DD') HIRE_DATE
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM EMPLOYEES
                       WHERE FIRST_NAME = 'Guy');
-- 서브 쿼리를 이용하여 평균 급여보다 더 많은 급여를 받는 사원을 검색하는 쿼리
SELECT  FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES);
-- <문제1> EMPLOYEES 테이블에서 LAST_NAME이 Kochhar의 급여보다 많은 사원의 정보 가운데 사원번호,이름,담당업무,급여를 출력하라
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT SALARY FROM EMPLOYEES
                WHERE LAST_NAME = 'Kochhar');
-- <문제2> 가장 적은 급여를 받는 사원의 사번, 이름, 급여를 출력하라
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEES);                
-- <문제2_1> 가장 많은 급여를 받는 사원의 이름, 사원의 핸드폰번호를 출력하라
SELECT EMPLOYEE_ID, FIRST_NAME, PHONE_NUMBER 
FROM EMPLOYEES
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEES);
-- <문제3> 가장 오랜 기간 근무한 사원의 이름과 이메일, 담당업무, 입사일을 출력하라
SELECT * FROM EMPLOYEES;
SELECT FIRST_NAME, EMAIL, JOB_ID, HIRE_DATE FROM EMPLOYEES
WHERE HIRE_DATE = (SELECT MIN(HIRE_DATE) FROM EMPLOYEES);

-- 3. 다중 행 서브 쿼리
-- 1) IN 연산자
--급여를 15000 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원을 출력하라
--서브쿼리의 결과 중에서 하나라도 일치하면 참인 결과를 구하는 IN연산자와 함께 사용하라
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID FROM EMPLOYEES
                        WHERE SALARY >= 15000 );
-- EMPLOYEES 테이블에서 이름에 'Z'가 포함되어있는 직원이 근무하는 부서에서 근무하는 모든 직원에 대한
-- 직원번호, 이름, 급여를 부서번호순으로 출력하라(정렬은 메인쿼리에 쓴다)
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES
                        WHERE FIRST_NAME LIKE '%z%')
ORDER BY DEPARTMENT_ID;
-- EMPLOYEES 테이블에서 Susan 또는 Lex와 월급이 같은 직원의 이름, 업무, 급여를 출력하는 SELECT 문을 작성하라(Susan, Lex는 제외)
SELECT FIRST_NAME, JOB_ID, SALARY FROM EMPLOYEES
WHERE SALARY IN (SELECT SALARY FROM EMPLOYEES
                 WHERE FIRST_NAME IN ('Susan','Lex')) AND (FIRST_NAME <> 'Susan' AND FIRST_NAME <> 'Lex'); -- <>, !=, ^= 같지 않다는 비교연산자
-- EMPLOYEES 테이블에서 적어도 한 명 이상으로부터 보고를 받을 수 있는 직원의 직원번호, 이름, 업무, 부서번호를 출력하라
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN (SELECT DISTINCT MANAGER_ID FROM EMPLOYEES);
-- <문제> EMPLOYEES 테이블에서 Accounting 부서에서 근무하는 직원과 같은 업무를 하는 직원의 이름, 업무명을 출력하라
SELECT * FROM DEPARTMENTS;
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID IN (SELECT JOB_ID FROM EMPLOYEES
                 WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM DEPARTMENTS
                                        WHERE DEPARTMENT_NAME = 'Accounting'));
-- 2) All 연산자
-- 30번 소속 직원들 중에서 급여를 가장 많이 받는 직원보다 더 많은 급여를 받는 사람의 이름, 급여를 출력하라
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > ALL(SELECT SALARY FROM EMPLOYEES
                   WHERE DEPARTMENT_ID = 30);
-- 3) ANY 연산자
-- 부서번호가 110번인 사원들의 급여 중 가장 작은 값보다 많은 급여를 받는 사원의 이름, 급여를 출력하라
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > ANY(SELECT SALARY FROM EMPLOYEES
                   WHERE DEPARTMENT_ID = 110);
-- 4) EXISTS 연산자
-- 오는 위치에 따라 이름 달라지는 서브 쿼리
-- 사원명과 그 사원이 소속된 부서명을 조회 - JOIN 방법으로 명시
SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;
-- 스칼라 서브 쿼리 : SELECT절에 오는 서브쿼리로 한번에 결과를 1행씩 반환
-- 사원명과 그 사원이 소속된 부서명을 조회 - 스칼라 서브 쿼리 방법으로 명시
SELECT FIRST_NAME, (SELECT DEPARTMENT_NAME FROM DEPARTMENTS D
                    WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID) DEPARTMENT_NAME
FROM EMPLOYEES E;
-- 모든 사원의 사원번호, 이름, 관리자번호, 관리자명을 조회
SELECT EMPLOYEE_ID, FIRST_NAME, MANAGER_ID, NVL((SELECT M.FIRST_NAME FROM EMPLOYEES M
                                             WHERE M.EMPLOYEE_ID = E.MANAGER_ID), '없음') 관리자명
FROM EMPLOYEES E
ORDER BY 1;

-- 4. 서브쿼리로 테이블 작성하기
-- 1) 서브쿼리로 테이블 복사하기
-- 테이블의 모든 칼럼 복사
DROP TABLE EMP01;
CREATE TABLE EMP01
AS 
SELECT * FROM EMPLOYEES;
-- 특정 칼럼만 복사
DROP TABLE EMP02;
CREATE TABLE EMP02
AS 
SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES;
-- 2) 테이블의 구조만 복사하기
DROP TABLE EMP03;
CREATE TABLE EMP03
AS 
SELECT * FROM EMPLOYEES
WHERE 0=1;
SELECT * FROM EMP03;

-- 5. 서브쿼리를 이용한 데이터 추가
DROP TABLE DEPT01; -- DEPT01은 너무 많은 외래키 지정되어있음
CREATE TABLE DEPT10
AS
SELECT * FROM DEPARTMENTS
WHERE 1=0;

INSERT INTO DEPT10
SELECT * FROM DEPARTMENTS;

-- 6. 서브 쿼리를 이용한 데이터 수정
-- 10번 부서의 지역번호를 40번 부서의 지역번호로 변경하기 위해서 서브쿼리를 사용한 예
UPDATE DEPT10
SET LOCATION_ID = (SELECT LOCATION_ID FROM DEPARTMENTS
                   WHERE DEPARTMENT_ID = 40)
WHERE DEPARTMENT_ID = 10;                   
SELECT * FROM DEPT10;

-- 7. 서브쿼리를 이용한 두 개 이상의 칼럼에 대한 값 변경
-- 20번 부서의 부서명과 지역명을 30번 부서의 부서명과 지역명으로 수정
-- 1) 서브쿼리 이용한 UPDATE 형식 1
UPDATE DEPT10
SET DEPARTMENT_NAME = (SELECT DEPARTMENT_NAME FROM DEPT10
                       WHERE DEPARTMENT_ID = 30),
    LOCATION_ID = (SELECT LOCATION_ID FROM DEPT10
                   WHERE DEPARTMENT_ID = 30)
WHERE DEPARTMENT_ID = 20;
-- 2) 서브쿼리 이용한 UPDATE 형식 2
UPDATE DEPT10
SET (DEPARTMENT_NAME, LOCATION_ID) = (SELECT DEPARTMENT_NAME, LOCATION_ID FROM DEPT10
                                      WHERE DEPARTMENT_ID = 30)
WHERE DEPARTMENT_ID = 20;
SELECT * FROM DEPT10;

-- 8. 서브쿼리 이용한 데이터 삭제
DROP TABLE EMP01;
CREATE TABLE EMP01
AS
SELECT * FROM EMPLOYEES;

DELETE FROM EMP01
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM DEPARTMENTS
                       WHERE DEPARTMENT_NAME = 'Sales');
SELECT * FROM EMP01;    

-- 서브쿼리 예제
-- 1. 직급이 'ST_MAN'인 직원이 받는 급여들의 최소 급여보다 많이 받는 직원들의 이름과 급여를 출력하되 부서번호가 20번인 직원은 제외
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > ANY(SELECT SALARY FROM EMPLOYEES
                   WHERE JOB_ID = 'ST_MAN') AND DEPARTMENT_ID != 20;

-- 2. EMPLOYEES 테이블에서 Valli라는 이름을 가진 직원과 업무명 및 월급이 같은 사원의 모든 정보를 출력하는 SELECT문을 작성하시오. 
-- (결과에서 Valli는 제외)
SELECT * FROM EMPLOYEES
WHERE JOB_ID = (SELECT JOB_ID FROM EMPLOYEES WHERE FIRST_NAME = 'Valli') 
      AND SALARY = (SELECT SALARY FROM EMPLOYEES WHERE FIRST_NAME = 'Valli') 
      AND FIRST_NAME != 'Valli';
          
-- 3. EMPLOYEES 테이블에서 가장 많은 사원이 속해있는 부서번호와 사원수를 출력하라.
SELECT DEPARTMENT_ID, COUNT(EMPLOYEE_ID) FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING COUNT(EMPLOYEE_ID) = (SELECT MAX(COUNT(EMPLOYEE_ID)) FROM EMPLOYEES
                          GROUP BY DEPARTMENT_ID);
                          
-- 4. EMPLOYEES 테이블에서 월급이 자신이 속한 부서의 평균 월급보다 높은 사원의 부서번호, 이름, 급여를 출력하는 SELECT문을 작성하시오.
SELECT DEPARTMENT_ID, FIRST_NAME, SALARY FROM EMPLOYEES;
SELECT DEPARTMENT_ID, ROUND(AVG(SALARY)) FROM EMPLOYEES
GROUP BY DEPARTMENT_ID;

SELECT E.DEPARTMENT_ID, FIRST_NAME, SALARY
FROM (SELECT DEPARTMENT_ID, AVG(SALARY) 부서평균급여 FROM EMPLOYEES
      GROUP BY DEPARTMENT_ID) D, EMPLOYEES E
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+) AND SALARY > 부서평균급여;

-- 5. 2001년~2005년 사이에 입사한 사원들에 대해 부서번호, 부서명, 
-- 각 부서별 사원수를 2001년입사인원수, 2002년입사인원수, 2003년입사인원수, 2004년입사인원수, 2005년입사인원수로 출력하라.
SELECT E.DEPARTMENT_ID 부서번호, (SELECT D.DEPARTMENT_NAME FROM DEPARTMENTS D WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID) 부서명,
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE,'YYYY-MM-DD'),1,4),'2001',0)) "2001년입사인원수",
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE,'YYYY-MM-DD'),1,4),'2002',0)) "2002년입사인원수",
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE,'YYYY-MM-DD'),1,4),'2003',0)) "2003년입사인원수",
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE,'YYYY-MM-DD'),1,4),'2004',0)) "2004년입사인원수",
       COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE,'YYYY-MM-DD'),1,4),'2005',0)) "2005년입사인원수"
FROM EMPLOYEES E
WHERE E.DEPARTMENT_ID IS NOT NULL
GROUP BY E.DEPARTMENT_ID
ORDER BY E.DEPARTMENT_ID;

-- 6. 부서별 급여 합계를 구하고, 그 결과를 가지고 다음과 같이 표현하시오.
-- Sum Salary > 100000 이면, "Excellent"
-- Sum Salary > 50000 이면, "Good"
-- Sum Salary > 10000 이면, "Medium"
-- Sum Salary <= 10000 이면, "Well" 
-- <Hint> CASE 문을 사용하는 보통 방법을 사용할 수도 있고, 
-- 인라인 뷰(INLINE VIEW)를 이용하여 우선 부서별 급여 합계를 구하고, 상위 쿼리에서 CASE 구문을 이용하여 위의 조건 비교를 통해 급여 합계에 따른 표현을 할 수 있다.
-- 서브쿼리가 FROM 절 안에서 사용되는 경우, 해당 서브쿼리를 '인라인뷰'라고 한다. FROM 절에서 사용된 서브쿼리의 결과가 하나의 테이블에 대한 뷰(View)처럼 사용된다. 
SELECT DEPARTMENT_ID, SUM(SALARY) SUM_SAL, CASE WHEN SUM(SALARY)>100000 THEN 'Excellent'
                                                WHEN SUM(SALARY)>50000 THEN 'Good'
                                                WHEN SUM(SALARY)>10000 THEN 'Medium'
                                                WHEN SUM(SALARY)<=10000 THEN 'Well'
                                           END "Department Grade Salary"  
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;

-- ?
SELECT DISTINCT DEPARTMENT_ID, SUM(SALARY) "SUM_SAL", CASE WHEN S.SUM_SAL>100000 THEN 'Excellent'
                                                           WHEN S.SUM_SAL>50000 THEN 'Good'
                                                           WHEN S.SUM_SAL>10000 THEN 'Medium'
                                                           WHEN S.SUM_SAL<=10000 THEN 'Well'
                                                      END "Department Grade Salary" 
FROM (SELECT SUM(E.SALARY) "SUM_SAL" FROM EMPLOYEES E
      GROUP BY DEPARTMENT_ID) S, EMPLOYEES E
GROUP BY DEPARTMENT_ID      
ORDER BY E.DEPARTMENT_ID;

SELECT DISTINCT E.DEPARTMENT_ID, SUM(E.SALARY) SUM_SAL, CASE WHEN S.SUM_SAL>100000 THEN 'Excellent'
                                                             WHEN S.SUM_SAL>50000 THEN 'Good'
                                                             WHEN S.SUM_SAL>10000 THEN 'Medium'
                                                             WHEN S.SUM_SAL<=10000 THEN 'Well'
                                                        END "Department Grade Salary" 
FROM (SELECT SUM(E.SALARY) SUM_SAL 
      FROM EMPLOYEES E
      GROUP BY DEPARTMENT_ID) S, EMPLOYEES E
GROUP BY E.DEPARTMENT_ID  
ORDER BY E.DEPARTMENT_ID;
                
-- 뷰
-- 1. 뷰의 개념
CREATE VIEW VIEW_EMP01
AS 
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 10;
SELECT * FROM VIEW_EMP01;

-- 2. 뷰 생성과 조회
DROP TABLE EMP01;
CREATE TABLE EMP01
AS
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES;
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMP01
WHERE DEPARTMENT_ID = 30;

-- 3. 뷰 생성
CREATE OR REPLACE VIEW VIEW_EMP01
AS
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMP01
WHERE DEPARTMENT_ID = 30;
-- 1) 뷰에 관련된 데이터 딕셔너리
SELECT VIEW_NAME, TEXT
FROM USER_VIEWS;
SELECT * FROM VIEW_EMP01;
-- 2) 뷰의 동작 원리

-- 4. 뷰의 종류
-- 1) 단순 뷰에 대한 데이터 조작
SELECT * FROM VIEW_EMP01;
-- 단순 뷰에서는 INSERT/UPDATE/DELETE문을 사용할 수 있음
INSERT INTO VIEW_EMP01
VALUES(250,'ANGEL',7000,30);
SELECT * FROM VIEW_EMP01;
SELECT * FROM EMP01; -- 이는 기본 테이블에도 반영됨
-- 2) 단순 뷰의 칼럼에 별칭 부여하기
CREATE OR REPLACE VIEW VIEW_EMP02
AS
SELECT EMPLOYEE_ID 사원번호, FIRST_NAME 사원명, SALARY 급여, DEPARTMENT_ID 부서번호
FROM EMP01;
CREATE OR REPLACE VIEW VIEW_EMP02(사원번호,사원명,급여,부서번호)
AS
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID 
FROM EMP01;
DESC VIEW_EMP02;
SELECT * FROM VIEW_EMP02;
SELECT * FROM VIEW_EMP02
WHERE 부서번호 = 10; -- 이제 컬럼명이 부서번호임
SELECT * FROM VIEW_EMP02
WHERE EMPLOYEE_ID = 10; -- DEPARTMENT_ID로 하면 오류남(기본 테이블의 컬럼명은 영향 안 받음)
-- 3) 그룹 함수를 사용한 단순 뷰
CREATE OR REPLACE VIEW VIEW_SALARY
AS
SELECT DEPARTMENT_ID, SUM(SALARY) AS "SalarySum", TRUNC(AVG(SALARY)) AS "SalaryAvg"
FROM EMP01
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;
SELECT * FROM VIEW_SALARY;
-- 사원번호, 사원이름, 급여, 부서번호, 부서명 조회할 수 있는 VIEW_EMP_DEPT 생성하라
CREATE OR REPLACE VIEW VIEW_EMP_DEPT
AS
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, (SELECT DEPARTMENT_NAME FROM DEPARTMENTS D
                                         WHERE D.DEPARTMENTS = E.EMPLOYEES) 부서명
FROM EMPLOYEES E
ORDER BY 1;  

-- 4) 복합 뷰
