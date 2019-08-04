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
	name varchar2(20),
	phone_num varvhar(20),
	address1 varchar(50),
	address2 varchar(50),
	signdate date default sysdate
	);
	
create sequence kimino_recipe_user_seq start with 1 increment by 1;	

create table kimino_recipe_admin(
	admin_num number(30) primary key,
	admin_id varchar2(100) unique not null,
	admin_pass varchar2(100) not null,
	admin_name varchar2(100) not null,
	admin_email varchar2(100) not null,
	signdate date default sysdate
	);
	
create sequence kimino_recipe_admin_seq start with 1 increment by 1;

insert into KIMINO_RECIPE_admin(admin_num, admin_id, admin_pass, admin_name, admin_email) 
values(kimino_recipe_admin_seq.nextval, 'admin1234', 'admin1234','admin','aaa@aaa.com');	

create table kimino_recipe_product(
	product_num number(10) primary key,
	product_id varchar2(30) not null,
	product_name varchar2(30) not null,   //상품 이름
	price number(30) default 0,  // 상품 가격
	content varchar2(1000) not null, //상품 설명
	image varchar2(500), //상품 이미지
	writedate date default sysdate,
	board_id varchar2(100)
);
alter table kimino_recipe_product add (writedate date default sysdate);
alter table kimino_recipe_product add (board_id varchar2(100));
//개선 사항 , 상품번호(product_id)를 만들어서 수동으로 입력하게 해야함

create sequence kimino_recipe_product_seq start with 1 increment by 1;
//상품관리는 관리자만 가능하므로 따로 작성자 필드를 만들 필요 없음, 조회수 댓글도 필요 없음


create table kimino_recipe_cart(
	cart_num number(10) primary key, 
	user_id varchar2(100) not null, //유저 아이디
	product_id varchar2(30) not null,
	product_name varchar2(30) not null, // 상품 이름
	price number(30) default 0, //가격
	content varchar2(1000) not null, //내용
	image varchar2(500),  //이미지
	amount number(30) default 0 // 수량
);

create sequence kimino_recipe_cart_seq start with 1 increment by 1;

create table kimino_recipe_orderlist(
	order_num number(10) primary key, 
	user_id varchar2(50) not null, 
	product_id varchar2(30) not null, 
	product_name varchar2(30) not null, 
	price number(30) default 0, 
	amount number(30) default 0, 
	name varchar2(20) not null,
	phone_num varchar2(20) not null,
	address1 varchar2(50) not null,
	address2 varchar2(50) not null,
	bank_account varchar2(50) not null,
	orderdate date default sysdate	
);

create sequence kimino_recipe_orderlist_seq start with 1 increment by 1;
