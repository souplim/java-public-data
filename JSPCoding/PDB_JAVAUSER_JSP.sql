-- jdbc 확인을 위한 예제
create table chungnam(
    mng_no number(5) not null,          -- 번호    
    local_nm varchar2(90) not null,     -- 지역명
    type varchar2(90) not null,         -- 타입
    nm varchar2(120) not null,          -- 제목
    nm_sub varchar2(270) not null,     -- 부제목
    addr varchar2(500) not null,        -- 주소
    lat number(8, 5) not null,          -- lat 좌표(경도)
    lng number(8, 5) not null,          -- lng 좌표(위도)
    description clob not null,          -- 상세설명
    list_img varchar2(500) not null,    -- 리스트 썸네일 이미지       
    regDate date default sysdate,
    constraint chungnam_pk primary key(mng_no)
);

-- 주석은 의미 없음 이렇게 설명 명시해야함
comment on table chungnam is '충남 정보';
comment on column chungnam.mng_no is '번호';
comment on column chungnam.local_nm is '지역명';
comment on column chungnam.type is '타입';
comment on column chungnam.nm is '제목';
comment on column chungnam.nm_sub is '부제목';
comment on column chungnam.addr is '주소';
comment on column chungnam.lat is 'lat 좌표(경도)';
comment on column chungnam.lng is 'lng 좌표(위도)';
comment on column chungnam.description is '상세설명';
comment on column chungnam.list_img is '리스트 썸네일 이미지';
comment on column chungnam.regDate is '등록일';

select * from chungnam; 

select mng_no, local_nm, type, nm, nm_sub, description, list_img from chungnam
order by mng_no desc;

delete from chungnam where mng_no = ?;

insert into chungnam(mng_no,local_nm,type,nm,nm_sub,addr,lat,lng,description,list_img,regDate) 
values(?,?,?,?,?,?,?,?,?,?,sysdate);