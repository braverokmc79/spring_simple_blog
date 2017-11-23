/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE users(
		username                      		VARCHAR(20)		 NOT NULL COMMENT '아이디' ,
		password                      		VARCHAR(100)		 NULL COMMENT '비밀번호',
		enabled                       		INTEGER		 NULL COMMENT '계정사용여부'
);



ALTER TABLE users ADD CONSTRAINT IDX_users_PK PRIMARY KEY (username);

/**********************************/
/* Table Name: 권한 */
/**********************************/
CREATE TABLE authorities(
		username                      		VARCHAR(20)		 NOT NULL COMMENT '회원아이디',
		authority                     		VARCHAR(20)		 NOT NULL COMMENT '권한'
);



ALTER TABLE authorities ADD CONSTRAINT IDX_authorities_PK PRIMARY KEY (username, authority);
ALTER TABLE authorities ADD CONSTRAINT IDX_authorities_FK0 FOREIGN KEY (username) REFERENCES users (username);

/**********************************/
/* Table Name: 그룹 */
/**********************************/
CREATE TABLE groups(
		id                            		VARCHAR(20)		 NOT NULL COMMENT '그룹 아이디',
		group_name                    		VARCHAR(20)		 NULL COMMENT '그룹 명'
);


ALTER TABLE groups ADD CONSTRAINT IDX_groups_PK PRIMARY KEY (id);

/**********************************/
/* Table Name: 그룹 권한 관계 */
/**********************************/
CREATE TABLE group_authorities(
		group_id                      		VARCHAR(20)		 NOT NULL COMMENT '그룹 아이디',
		authority                     		VARCHAR(20)		 NOT NULL COMMENT '권한'
);



ALTER TABLE group_authorities ADD CONSTRAINT IDX_group_authorities_PK PRIMARY KEY (group_id, authority);
ALTER TABLE group_authorities ADD CONSTRAINT IDX_group_authorities_FK0 FOREIGN KEY (group_id) REFERENCES groups (id);

/**********************************/
/* Table Name: 그룹 회원 관계 */
/**********************************/
CREATE TABLE group_members(
		group_id                      		VARCHAR(20)		 NOT NULL COMMENT '그룹 아이디',
		username                      		VARCHAR(20)		 NOT NULL COMMENT '회원 아이디'
);



ALTER TABLE group_members ADD CONSTRAINT IDX_group_members_PK PRIMARY KEY (group_id, username);
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
