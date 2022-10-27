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
-- 한글 별칭도 사용 가능 : 컬럼 별칭
SELECT department_id 부서번호, department_name 부서명 FROM departments;
-- 별칭에 공백문자, 특수문자, 대소문자 구별을 표현하기 위해서는 AS를 생략하고 ""을 사용
SELECT department_id "department No", department_name "department Name" FROM departments;

-- Concatenation(연결) 연산자의 사용
-- 여러 컬럼을 하나의 문자열로 출력하기
SELECT first_name||'의 직급은 '||job_id||'입니다' AS 직급 FROM employees;
SELECT first_name ||' '||last_name AS 이름, salary AS 급여, hire_date AS 입사일 FROM employees;

-- 중복된 데이터를 한번만 출력하게 하기 : DISTINCT
SELECT job_id FROM employees;
SELECT DISTINCT job_id FROM employees;
SELECT DISTINCT first_name, job_id FROM employees;
-- <문제> 직원들이 어떤 부서에 소속되어 있는지 소속 부서번호(department_id) 출력하되 중복제거하는 쿼리문 작성하자
SELECT DISTINCT department_id FROM employees;

