
-- 데이터베이스 생성
CREATE DATABASE SIMPLEBLOG2 CHARACTER SET=UTF8;

-- 유저 생성
CREATE USER `SIMPLEBLOG2`@`LOCALHOST` IDENTIFIED BY  '1111';

-- 권한 부여
GRANT ALL PRIVILEGES ON SIMPLEBLOG2.* TO `SIMPLEBLOG2`@`LOCALHOST`;




/**********************************/
/* Table Name: 회원 */
/**********************************/


CREATE TABLE users(
		idx  INT  AUTO_INCREMENT  PRIMARY KEY,		
        username   VARCHAR(45)	UNIQUE NOT NULL COMMENT '아이디' ,
        nickname    VARCHAR(30)   NULL COMMENT  ' 닉네임',
		password   VARCHAR(100)		 NULL COMMENT '비밀번호',
		email      VARCHAR(50)  NULL comment '이메일',
		enabled    INTEGER NOT NULL DEFAULT 1 COMMENT '계정사용여부', 
		upoint     INT    COMMENT '포인트',
		regdate   TIMESTAMP  DEFAULT now()
);

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username   VARCHAR(45) UNIQUE  NOT NULL COMMENT  '아이디',
  nickname   VARCHAR(30)  NULL COMMENT  ' 닉네임',
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username)
);
  
  
  
ALTER TABLE user_roles 
	ADD  FOREIGN KEY (username) REFERENCES users(username);
	  


/**********************************/
/* Table Name: 권한 */
/**********************************/
CREATE TABLE authorities(
		username   	VARCHAR(45)	NOT NULL COMMENT '회원아이디',
		authority   VARCHAR(20) NOT NULL COMMENT '권한'
);


ALTER TABLE authorities ADD CONSTRAINT IDX_authorities_FK0 FOREIGN KEY (username) REFERENCES users (username);

/**********************************/
/* Table Name: 그룹 */
/**********************************/
CREATE TABLE groups(
		id          VARCHAR(20)	PRIMARY KEY	 NOT NULL COMMENT '그룹 아이디',
		group_name  VARCHAR(20)		 NULL COMMENT '그룹 명'
);




/**********************************/
/* Table Name: 그룹 권한 관계 */
/**********************************/
CREATE TABLE group_authorities(
		group_id    VARCHAR(20)	 NOT NULL COMMENT '그룹 아이디',
		authority   VARCHAR(20)	 NOT NULL COMMENT '권한'
);


ALTER TABLE group_authorities ADD CONSTRAINT IDX_group_authorities_FK0 FOREIGN KEY (group_id) REFERENCES groups (id);

/**********************************/
/* Table Name: 그룹 회원 관계 */
/**********************************/
CREATE TABLE group_members(
		group_id   VARCHAR(20)	 NOT NULL COMMENT '그룹 아이디',
		username   VARCHAR(45)	 NOT NULL COMMENT '회원 아이디'
);



ALTER TABLE group_members ADD CONSTRAINT IDX_group_members_FK0 FOREIGN KEY (username) REFERENCES users (username);
ALTER TABLE group_members ADD CONSTRAINT IDX_group_members_FK1 FOREIGN KEY (group_id) REFERENCES groups (id);


-- 회원 데이터 입력
INSERT INTO users (username, password, enabled) VALUES ('user', '1', 1);
INSERT INTO users (username, password, enabled) VALUES ('admin', '1', 1);

-- 회원 권한 입력
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');

-- 그룹
INSERT INTO groups (id, group_name) VALUES ('G01', '관리자 그룹');
INSERT INTO groups (id, group_name) VALUES ('G02', '사용자 그룹');

-- 그룹 권한
INSERT INTO group_authorities (group_id, authority) VALUES ('G01', 'ROLE_ADMIN');
INSERT INTO group_authorities (group_id, authority) VALUES ('G01', 'ROLE_USER');
INSERT INTO group_authorities (group_id, authority) VALUES ('G02', 'ROLE_USER');

-- 그룹 회원
INSERT INTO group_members (group_id, username) VALUES ('G01', 'admin');
INSERT INTO group_members (group_id, username) VALUES ('G02', 'user');
