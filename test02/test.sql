-- mysql 환경 정보 보기 : status 


--Connection id:          2
--Current database:
--Current user:           root@localhost
--SSL:                    Not in use
--Using delimiter:        ;
--Server version:         5.7.9-log MySQL Community Server (GPL)
--Protocol version:       10
--Connection:             localhost via TCP/IP
--Server characterset:    utf8
--Db     characterset:    utf8
--Client characterset:    utf8
--Conn.  characterset:    utf8
--TCP port:               3305
--Uptime:                 2 hours 24 min 19 sec
--
--Threads: 3  Questions: 134  Slow queries: 0  Opens: 127  Flush tables: 1  Open t
--ables: 120  Queries per second avg: 0.015
----------------



create user 'simpleblog'@'localhost' identified by '1111';

create database simpleblog character set=utf8;


grant all privileges on simpleblog.* to 'simpleblog'@'localhost';


-- Mysql

create table tbl_member(
	userid varchar(100) primary key ,
	userpw varchar(100) not null,
	username varchar(50) not null,
	email varchar(100),
    regdate timestamp default now(),
    updatedate timestamp default now()

);




----------------------------
----------------------------
----------------------------  오라클

--임의  폴더를 만든다. 필자는 D 드리버의 oracleDB 폴더를 생성했다.

-- 콘솔창을 연다

-- C:> cmd

-- DBA 접속

-- C:> sqlplus / as sysdba

-- 테이블 스페이스 생성

create tablespace simpleblog
datafile 'D:\oracleDB/simpleblog.dbf'
size 20m
autoextend on
next 10m
maxsize unlimited;


-- 계정 생성

create user simpleblog identified by 1111 default tablespace simpleblog;

-- 권한 설정
grant connect, resource, create view to simpleblog;



CREATE TABLE tbl_member
(
   userid       VARCHAR2 (100) PRIMARY KEY,
   userpw       VARCHAR2 (100) NOT NULL,
   username     VARCHAR2 (50) NOT NULL,
   email        VARCHAR2 (100),
   regdate      TIMESTAMP DEFAULT sysdate,
   updatedate   TIMESTAMP DEFAULT sysdate
);



-------
-----
-----  MY SQL





create table tbl_message(
	
	mid int not null auto_increment,
	targetid varchar(50) not null,
	sender varchar(50) not null,
	message text not null,
	opendate timestamp,
	senddate timestamp not null default now(),
	primary key(mid)

);


--  tbl_member 포인트 컬럼 추가
alter table tbl_member add COLUMN ( upoint int not null default 0);



alter table tbl_message add CONSTRAINT fk_usertarget
foreign key (targetid) REFERENCES  tbl_member (userid);


alter table tbl_message add constraint fk_usersender
foreign key (sender) REFERENCES  tbl_member(userid);



--  mysql 자가 복제

INSERT INTO tbl_board ( title, content, writer) ( SELECT title, content, writer FROM tbl_board ); 


-- 페이징 처리를 위해 다음과 같이 변경한다.

create table tbl_member(
	mid int  AUTO_INCREMENT primary key ,
	userid varchar(100)  ,
	userpw varchar(100) not null,
	username varchar(50) not null,
	email varchar(100)
   

);

-- 더미데이터를 삽입 한다.

-- 컬럼을 변경한다.

alter table tbl_member add COLUMN  regdate timestamp default now();

alter table tbl_member add COLUMN  updatedate timestamp default now();

--  tbl_member 포인트 컬럼 추가
alter table tbl_member add COLUMN ( upoint int not null default 0);



