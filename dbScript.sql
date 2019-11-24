CREATE TABLE IF NOT EXISTS user(
	login varchar(100) primary key,
	password varchar(70) not null,
	email varchar(100) unique not null,
	streetname varchar(255) not null,
	streetnumber varchar(255) not null,
	gender varchar(20),
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	locality varchar(255) not null,
	postal_code varchar(20) not null,
	username varchar(120) not null,
	authorities varchar(150) not null,
	non_expired tinyint(1) not null,
	non_locked tinyint(1) not null,
	credentials_non_expired tinyint(1) not null,
	enabled tinyint(1) not null
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS clientorder
(
	id int auto_increment primary key,
	creation_date datetime not null,
	user_login varchar(100) not null,
	FOREIGN KEY (user_login) REFERENCES user(login)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS category (
	id int auto_increment primary key,
	name varchar(255) not null
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS language (
	language varchar(50) primary key
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS traduction (
	id int auto_increment primary key,
	category_name varchar(255) not null,
	language varchar(50) not null,
	category_id int not null,
    foreign key(language) references language(language),
    foreign key(category_id) references category(id)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS product (
	id int auto_increment primary key,
	name varchar(255) not null,
	description varchar(1000),
	price double not null,
	category_id int not null,
    foreign key(category_id) references category(id)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS image (
	id int auto_increment primary key,
	image blob not null,
	category_id int,
	product_id int,
    foreign key(category_id) references category(id),
	foreign key(product_id) references product(id)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS orderline (
	id bigint auto_increment primary key,
	quantity int not null,
	price double not null,
	order_id int not null,
	product_id int not null,
    foreign key(order_id) references clientorder(id),
    foreign key(product_id) references product(id)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS promotion (
	id int auto_increment primary key,
	eventname varchar(150) not null,
	event_start_date datetime not null,
	event_end_date datetime not null,
	min_order_price_for_application double
)engine=InnoDB;

create user 'user1'@'127.0.0.1' identified by 'yourStrong(!)Password';
grant all on shopping_website_db.* to 'user1'@'127.0.0.1';