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

-- ORDER BY 정렬하기
-- 쿼리문 맨 뒤에 기술 : SELECT 컬럼 FROM 테이블 WHERE 조건 ORDER BY 컬럼 ASC/DESC;
-- 1. 오름차순 정렬을 위한 ASC : 생략 가능
-- 사번을 기준으로 오름차순 정렬
SELECT employee_id, first_name FROM employees ORDER BY employee_id ASC;
-- 2. 내림차순 정렬을 위한 DESC
-- 사번을 기준으로 내림차순 정렬
SELECT employee_id, first_name FROM employees ORDER BY employee_id DESC;
-- <문제> 직원번호, 이름, 급여, 부서번호를 급여가 높은 순으로 출력하라
SELECT employee_id, first_name, salary, job_id FROM employees ORDER BY salary DESC;
-- <문제> 입사일이 가장 최근인 직원 순으로 직원번호, 이름, 입사일을 출력하라
SELECT employee_id, first_name, hire_date FROM employees ORDER BY hire_date DESC;

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
