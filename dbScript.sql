create database sitesacamain;

create table user(
	login varchar(255) primary key,
	password varchar(255) not null,
	email varchar(255) unique,
	streetname varchar(255) not null,
	streetnumber varchar(255) not null,
	gender varchar(255),
	firstname varchar(255) not null,
	lastname varchar(255) not null,
	localityname varchar(255) not null,
	postalcode varchar(255) not null,
	username varchar(255) not null,
	authorities varchar(255) not null,
	non_expired
	non_locked
	credentials_non_expired 
	enabled tinyint(1) not null
)

create table order(
	id bigint identity(1,1) primary key,
	creationdate datetime not null,
	userlogin varchar(255) not null foreign key references user(login)
)

create table category (
	id int identity(1,1) primary key,
	name varchar(255) not null
)

create table language (
	language varchar(255) primary key
)

create table traduction (
	id int identity(1,1) primary key,
	categoryname varchar(255) not null,
	language varchar(255) not null foreign key references language(language),
	categoryid int not null foreign key references category(id)
)

create table product (
	id int identity(1,1) primary key,
	name varchar(255) not null,
	description varchar(1000),
	price double not null,
	categoryid int not null foreign key references category(id)
)

create table image (
	id bigint identity(1,1) primary key,
	image varbinary not null unique,
	categoryid int not null foreign key references category(id),
	productid int not null foreign key references product(id)
)

create table orderline (
	id bigint identity(1,1) primary key,
	quantity int not null,
	price double not null,
	orderid bigint not null foreign key references order(id),
	productid int not null foreign key references product(id)
)

create table promotion (
	id int identity(1,1) primary key,
	eventname varchar(255) not null,
	eventstartdate datetime not null,
	eventenddate datetime not null,
	minorderpriceforapplication double
)
	
	
	
	
	