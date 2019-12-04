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
	authorities varchar(500) not null,
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
	name varchar(50) primary key
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS language (
	language varchar(50) primary key
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS traduction (
	id int auto_increment primary key,
	category_name_traduction varchar(255) not null,
	language varchar(50) not null,
	category_name varchar(50) not null,
    foreign key(language) references language(language),
    foreign key(category_name) references category(name)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS product (
	name varchar(50) primary key,
	description varchar(1000),
	price double not null,
	category_name varchar(50) not null,
    foreign key(category_name) references category(name)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS image (
	id int auto_increment primary key,
	image_uri varchar(300) not null,
	category_name varchar(50),
	product_name varchar(50),
    foreign key(category_name) references category(name),
	foreign key(product_name) references product(name)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS orderline (
	id bigint auto_increment primary key,
	quantity int not null,
	price double not null,
	order_id int not null,
	product_name varchar(50) not null,
    foreign key(order_id) references clientorder(id),
    foreign key(product_name) references product(name)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS promotion (
	eventname varchar(150) primary key,
	event_start_date datetime not null,
	event_end_date datetime not null,
	min_order_price_for_application double
)engine=InnoDB;

grant all on shopping_website_db.* to 'user1'@'127.0.0.1';

insert into category(name) values("Sacs en bandoulières");
insert into category(name) values("Sacs cabas");
insert into category(name) values("Sacs à dos");
insert into category(name) values("Trousses");
insert into category(name) values("Sacs de voyage");

insert into product(name, description, price, category_name) values ("f", "desc f", 20.2, "Sacs en bandoulières");
insert into product(name, description, price, category_name) values ("g", "desc g", 20.2, "Sacs en bandoulières");
insert into product(name, description, price, category_name) values ("h", "desc h", 20.2, "Sacs en bandoulières");
insert into product(name, description, price, category_name) values ("u", "desc u", 20.2, "Sacs en bandoulières");

insert into product(name, description, price, category_name) values ("a", "desc a", 20.2, "Sacs cabas");
insert into product(name, description, price, category_name) values ("b", "desc b", 20.2, "Sacs cabas");
insert into product(name, description, price, category_name) values ("c", "desc c", 20.2, "Sacs cabas");
insert into product(name, description, price, category_name) values ("d", "desc d", 20.2, "Sacs cabas");
insert into product(name, description, price, category_name) values ("k", "desc k", 20.2, "Sacs cabas");
insert into product(name, description, price, category_name) values ("s", "desc s", 20.2, "Sacs cabas");
insert into product(name, description, price, category_name) values ("x", "desc x", 20.2, "Sacs cabas");
insert into product(name, description, price, category_name) values ("y", "desc y", 20.2, "Sacs cabas");

insert into product(name, description, price, category_name) values ("e", "desc e", 20.2, "Sacs à dos");
insert into product(name, description, price, category_name) values ("r", "desc r", 20.2, "Sacs à dos");
insert into product(name, price, category_name) values ("w", 20.2, "Sacs à dos");

insert into product(name, description, price, category_name) values ("aa", "desc aa", 20.2, "Trousses");
insert into product(name, description, price, category_name) values ("i", "desc i", 20.2, "Trousses");
insert into product(name, description, price, category_name) values ("j", "desc j", 20.2, "Trousses");
insert into product(name, description, price, category_name) values ("l", "desc l", 20.2, "Trousses");
insert into product(name, description, price, category_name) values ("m", "desc m", 20.2, "Trousses");
insert into product(name, description, price, category_name) values ("n", "desc n", 20.2, "Trousses");
insert into product(name, description, price, category_name) values ("o", "desc o", 20.2, "Trousses");
insert into product(name, description, price, category_name) values ("p", "desc p", 20.2, "Trousses");
insert into product(name, description, price, category_name) values ("q", "desc q", 20.2, "Trousses");
insert into product(name, description, price, category_name) values ("t", "desc t", 20.2, "Trousses");
insert into product(name, description, price, category_name) values ("v", "desc v", 20.2, "Trousses");

insert into product(name, description, price, category_name) values ("z", "desc z", 20.2, "Sacs de voyage");

insert into image(image_uri, product_name) values ("https://i.ibb.co/SJyYTs9/u2.jpg", "u");
insert into image(image_uri, product_name) values ("https://i.ibb.co/nbqgJsQ/u.jpg", "u");
insert into image(image_uri, product_name) values ("https://i.ibb.co/hYcWsv2/h.jpg", "h");
insert into image(image_uri, product_name) values ("https://i.ibb.co/q0FCqwN/g.jpg", "g");
insert into image(image_uri, product_name) values ("https://i.ibb.co/2nHp2B2/g2.jpg", "g");
insert into image(image_uri, product_name) values ("https://i.ibb.co/RYspwL2/f.jpg", "f");
insert into image(image_uri, product_name) values ("https://i.ibb.co/YZT5SMS/f2.jpg", "f");

insert into image(image_uri, product_name) values ("https://i.ibb.co/WHKH3JL/y.jpg", "y");
insert into image(image_uri, product_name) values ("https://i.ibb.co/gWzJFHX/x.jpg", "x");
insert into image(image_uri, product_name) values ("https://i.ibb.co/SJ0XdQF/s.jpg", "s");
insert into image(image_uri, product_name) values ("https://i.ibb.co/nmB7rdc/s2.jpg", "s");
insert into image(image_uri, product_name) values ("https://i.ibb.co/0sm3Z4T/k.jpg", "k");
insert into image(image_uri, product_name) values ("https://i.ibb.co/2PSZBW5/k2.jpg", "k");
insert into image(image_uri, product_name) values ("https://i.ibb.co/gWFsN1v/d.jpg", "d");
insert into image(image_uri, product_name) values ("https://i.ibb.co/pvTZVnm/d2.jpg", "d");
insert into image(image_uri, product_name) values ("https://i.ibb.co/LYX5Z3g/c.jpg", "c");
insert into image(image_uri, product_name) values ("https://i.ibb.co/YT5FnZ1/c2.jpg", "c");
insert into image(image_uri, product_name) values ("https://i.ibb.co/zVNYNn9/b.jpg", "b");
insert into image(image_uri, product_name) values ("https://i.ibb.co/2gmnjSj/b2.jpg", "b");
insert into image(image_uri, product_name) values ("https://i.ibb.co/zx6F2Zf/a.jpg", "a");
insert into image(image_uri, product_name) values ("https://i.ibb.co/6vJg577/a2.jpg", "a");


insert into image(image_uri, product_name) values ("https://i.ibb.co/znW1b78/w.jpg", "w");
insert into image(image_uri, product_name) values ("https://i.ibb.co/qgk0V0z/w2.jpg", "w");
insert into image(image_uri, product_name) values ("https://i.ibb.co/LZTHfRd/r.jpg", "r");
insert into image(image_uri, product_name) values ("https://i.ibb.co/7n4wGYv/r2.jpg", "r");
insert into image(image_uri, product_name) values ("https://i.ibb.co/6gGLyDc/e.jpg", "e");
insert into image(image_uri, product_name) values ("https://i.ibb.co/gFMghNS/e2.jpg", "e");

insert into image(image_uri, product_name) values ("https://i.ibb.co/nLmvj7G/v.jpg", "v");
insert into image(image_uri, product_name) values ("https://i.ibb.co/QvH7JhG/t.jpg", "t");
insert into image(image_uri, product_name) values ("https://i.ibb.co/gtJY39T/q.jpg", "q");
insert into image(image_uri, product_name) values ("https://i.ibb.co/HD0GkN7/p.jpg", "p");
insert into image(image_uri, product_name) values ("https://i.ibb.co/r7b4Z9x/o.jpg", "o");
insert into image(image_uri, product_name) values ("https://i.ibb.co/n6F33Hq/n.jpg", "n");
insert into image(image_uri, product_name) values ("https://i.ibb.co/xKbJBkm/m.jpg", "m");
insert into image(image_uri, product_name) values ("https://i.ibb.co/0r9vNrd/l.jpg", "l");
insert into image(image_uri, product_name) values ("https://i.ibb.co/5xsc7cN/j.jpg", "j");
insert into image(image_uri, product_name) values ("https://i.ibb.co/gZX4jmx/i.jpg", "i");
insert into image(image_uri, product_name) values ("https://i.ibb.co/1zVqJSy/i2.jpg", "i");
insert into image(image_uri, product_name) values ("https://i.ibb.co/8gZ34n4/aa.jpg", "aa");

insert into image(image_uri, product_name) values ("https://i.ibb.co/jJ8pkWM/z.jpg", "z");
insert into image(image_uri, product_name) values ("https://i.ibb.co/hdZQ1KX/z2.jpg", "z");