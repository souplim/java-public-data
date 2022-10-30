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
    CUSTOMER_CD CHAR(7) NOT NULL PRIMARY KEY,
    CUSTOMER_NM VARCHAR(15) NOT NULL,
    MW_FLG CHAR(1) NOT NULL,
    BIRTH_DAY CHAR(8) NOT NULL,
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
SELECT INITCAP('DATA BASE PROGRAM')
FROM DUAL;
-- 사원 테이블의 30번 부서에 소속된 이메일의 첫 글자만 대문자로
DESC employees;
SELECT email FROM employees;
SELECT employee_id, first_name, INITCAP(email) FROM employees
WHERE department_id = 30;
-- 'jking'이란 이메일을 가진 직원의 이름과 커미션을 출력하라(INITCAP, UPPER 사용)
SELECT first_name, commission_pct FROM employees
WHERE email = UPPER('jking');
SELECT first_name, commission_pct, INITCAP(email) FROM employees
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
SELECT first_name FROM employees -- ?
WHERE SUBSTR(first_name, );
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
-- 올해 며칠이 지났는지 날짜 계산
SELECT SYSDATE-'2015/12/24' FROM DUAL; -- 오류
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
SELECT manager_id FROM employees;
SELECT employee_id, first_name, NVL2(manager_id, manager_id, 'CEO') manager_id FROM employees
WHERE manager_id IS NULL; -- 에러 WHY?????
--(2) 선택을 위한 DECODE 함수 (if문이랑 비슷)
-- 부서명 구하기
SELECT * FROM departments;
SELECT department_id, DECODE(department_id, 10, 'Administration', 
       20, 'Marketing', 30, 'Purchasing', 40, 'Human Resources', 
       50, 'Shipping', 60, 'IT') AS departments FROM employees
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
         END DEPAPRTEMENT_NAME
FROM employees
ORDER BY department_id;
-- <문제> 부서별에 따라 급여를 인상(직원번호, 직원명, 직급, 급여)
-- 부서명이 'Marketing'인 직원은 5%, 'Purchasing'인 직원은 10%, 'Human Resources'인 직원 15%, 'IT'인 직원은 20% 인상한다.
SELECT employee_id, first_name, job_id, salary,
    CASE WHEN department_id=10 THEN salary
         WHEN department_id=20 THEN salary*1.05
         WHEN department_id=30 THEN salary*1.1
         WHEN department_id=40 THEN salary*1.15
         WHEN department_id=50 THEN salary
         WHEN department_id=60 THEN salary*1.2
         END salary_inc
FROM employees
ORDER BY department_id;
-- (4) GREATEST(exp1, exp2...) 가장 큰 값, LEAST(exp1, exp2...) 가장 작은 값
SELECT GREATEST(1,4,2,5,3,9), LEAST(1,4,2,5,3,9) FROM DUAL;
SELECT GREATEST('김희수','조현수','홍길동'), LEAST('김희수','조현수','홍길동') FROM DUAL;
