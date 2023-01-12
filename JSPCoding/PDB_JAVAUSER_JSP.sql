-- jdbc Ȯ���� ���� ����
create table chungnam(
    mng_no number(5) not null,          -- ��ȣ    
    local_nm varchar2(90) not null,     -- ������
    type varchar2(90) not null,         -- Ÿ��
    nm varchar2(120) not null,          -- ����
    nm_sub varchar2(270) not null,     -- ������
    addr varchar2(500) not null,        -- �ּ�
    lat number(8, 5) not null,          -- lat ��ǥ(�浵)
    lng number(8, 5) not null,          -- lng ��ǥ(����)
    description clob not null,          -- �󼼼���
    list_img varchar2(500) not null,    -- ����Ʈ ����� �̹���       
    regDate date default sysdate,
    constraint chungnam_pk primary key(mng_no)
);

-- �ּ��� �ǹ� ���� �̷��� ���� ����ؾ���
comment on table chungnam is '�泲 ����';
comment on column chungnam.mng_no is '��ȣ';
comment on column chungnam.local_nm is '������';
comment on column chungnam.type is 'Ÿ��';
comment on column chungnam.nm is '����';
comment on column chungnam.nm_sub is '������';
comment on column chungnam.addr is '�ּ�';
comment on column chungnam.lat is 'lat ��ǥ(�浵)';
comment on column chungnam.lng is 'lng ��ǥ(����)';
comment on column chungnam.description is '�󼼼���';
comment on column chungnam.list_img is '����Ʈ ����� �̹���';
comment on column chungnam.regDate is '�����';

select * from chungnam; 

select mng_no, local_nm, type, nm, nm_sub, description, list_img from chungnam
order by mng_no desc;

delete from chungnam where mng_no = ?;

insert into chungnam(mng_no,local_nm,type,nm,nm_sub,addr,lat,lng,description,list_img,regDate) 
values(?,?,?,?,?,?,?,?,?,?,sysdate);