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








