-- 사용자 계정 생성
-- DBA만 사용자를 생성할 수 있다. 그래서 최고권한자(SYSDBA)인 SYS로 접속
-- CREATE USER 사용자명 IDENTIFIED BY 비밀번호;
CREATE USER javauser IDENTIFIED BY java1234;

-- 사용자 권한 부여
-- 오라클은 사용자 생성시 어떠한 권한도 가지고 있지 않기에 권한 부여를 해주어야 한다.
-- GRANT 권한 TO 사용자명;
GRANT CREATE SESSION TO javauser; -- 권한 직접 줄 수도 있고
GRANT CONNECT, RESOURCE TO javauser; -- 롤로 권한 부여할 수 있음
ALTER USER javauser 
DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

-- CONNECT 롤에 포함된 권한 - CREATE SESSION 권한이 없으면 해당 유저로 접속이 되지 않음
SELECT * FROM role_sys_privs
WHERE role = 'CONNECT';

-- RESOURCE 롤에 포함된 권한
-- CREATE 트리거, 시퀀스, 타입, 프로시저, 테이블 등 8가지 권한이 부여되어 있음
SELECT * FROM role_sys_privs
WHERE role = 'RESOURCE';

-- 먼저 JAVAUSER에게 부여된 롤 확인
SELECT * FROM dba_role_privs
WHERE GRANTEE = 'JAVAUSER';

-- 혹시 계정이 잠기게 되면 확인하기 위한 쿼리문
SELECT username, account_status, lock_date FROM dba_users
WHERE username = 'JAVAUSER';

-- 잠금 해제
ALTER USER javauser
ACCOUNT UNLOCK;

-- 비밀번호 변경
ALTER USER javauser IDENTIFIED BY java1234;


-- 뷰
-- 권한 부여
GRANT CREATE VIEW TO HR;

-- PDB_SYS 계정으로 사용자 계정에 권한주기
GRANT QUERY REWRITE TO HR;
GRANT CREATE MATERIALIZED VIEW TO HR;
