create table kimino_recipe(
	board_num number(30) primary key,
	board_id varchar2(100) not null,
	user_id varchar2(100) not null,
	user_name varchar2(100) not null,
	title varchar2(100) not null,
	content varchar2(1000) not null,
	image varchar2(100),
	readcount number(30) default 0,
	commentcount number(30) default 0,
	up number(30) default 0,
	down number(30) default 0,
	report number(30) default 0,
	writedate date default sysdate
	);
create sequence kimino_recipe_seq start with 1 increment by 1;

create table kimino_recipe_comment(
	comment_num number(30) primary key,
	board_num number(30) not null,
	board_id varchar2(100) not null,
	user_id varchar2(100),
	user_name varchar2(100) not null,
	content varchar2(1000) not null,
	writedate date default sysdate
	);
create sequence kimino_recipe_comment_seq start with 1 increment by 1;	

create table kimino_recipe_user(
	user_num number(30) primary key,
	user_id varchar2(100) not null,
	user_pass varchar2(100) not null,
	user_name varchar2(100) not null,
	user_email varchar2(100) not null,
	signdate date default sysdate
	);
	
create sequence kimino_recipe_user_seq start with 1 increment by 1;	

create table kimino_recipe_admin(
	user_num number(30) primary key,
	user_id varchar2(100) not null,
	user_pass varchar2(100) not null,
	user_name varchar2(100) not null,
	user_email varchar2(100) not null,
	signdate date default sysdate
	);
	
create sequence kimino_recipe_admin_seq start with 1 increment by 1;	