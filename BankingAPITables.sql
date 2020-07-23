--drop table if exists account;
--drop table if exists user_info;
--drop table if exists user_role;
--drop table if exists account_status;
--drop table if exists account_type;

create table user_role (
	role_id SERIAL primary key,
	u_role VARCHAR(30)
);

create table user_info (
	user_id SERIAL primary key,
	username VARCHAR(30),
	user_password VARCHAR(30),
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	email VARCHAR(30),
	role_fk INTEGER references user_role(role_id)
);

create table account_status(
	status_id SERIAL primary key,
	a_status VARCHAR(30)
);

create table account_type(
	type_id SERIAL primary key,
	a_type VARCHAR(30)
);


create table account(
	account_id SERIAL primary key,
	balance MONEY,
	status_fk INTEGER references account_status(status_id),
	type_fk INTEGER references account_type(type_id),
	user_fk INTEGER references user_info(user_id)
);

insert into user_role (u_role)
	VALUES('Admin'),
	('Employee'),
	('Standard'),
	('Premium');

insert into account_status(a_status)
	VALUES('Pending'),
	('Open'),
	('Closed'),
	('Denied');

insert into account_type(a_type)
	VALUES('Checking'),
	('Savings');
	
insert into user_info (username, user_password, first_name, last_name ,	email, role_fk)
	VALUES('jbond', 'jb578', 'James', 'Bond', 'jamesbond@gmail.com', 1);

insert into account(balance, status_fk, type_fk, user_fk)
	VALUES(100, 2, 2, 1);

