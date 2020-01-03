CREATE TABLE IF NOT EXISTS user(
	username varchar(120) primary key,
	password varchar(70) not null,
	email varchar(100) unique not null,
	streetname varchar(255) not null,
	streetnumber varchar(255) not null,
	gender varchar(20),
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	locality varchar(255) not null,
	phone_number varchar(255) not null,
	postal_code varchar(20) not null,
	authorities varchar(500) not null,
	non_expired tinyint(1) not null,
	non_locked tinyint(1) not null,
	credentials_non_expired tinyint(1) not null,
	enabled tinyint(1) not null
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS clientorder
(
	id int auto_increment primary key AUTO_INCREMENT,
	creation_date datetime not null,
	user_login varchar(100) not null,
    is_payed tinyint(1) not null,
	FOREIGN KEY (user_login) REFERENCES user(username)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS category (
	name varchar(50) primary key
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS language (
	language varchar(50) primary key
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS product (
	name varchar(50) primary key,
	price double not null,
	category_name varchar(50) not null,
    foreign key(category_name) references category(name)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS translation (
	id int primary key AUTO_INCREMENT,
	language varchar(50) not null,
	product_description_translation varchar(1000) not null,
	product varchar(50) not null,
    foreign key(language) references language(language),
    foreign key(product) references product(name)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS image (
	id int primary key AUTO_INCREMENT,
	image_uri varchar(300) not null,
	category_name varchar(50),
	product_name varchar(50),
    foreign key(category_name) references category(name),
	foreign key(product_name) references product(name)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS orderline (
	id bigint primary key AUTO_INCREMENT,
	quantity int not null CHECK (quantity > 0),
	price double not null CHECK (price > 0),
	order_id int not null,
	product_name varchar(50) not null,
    foreign key(order_id) references clientorder(id),
    foreign key(product_name) references product(name)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS promotion (
	eventname varchar(150) primary key,
	event_start_date datetime not null,
	event_end_date datetime not null,
	min_order_price_for_application double CHECK (min_order_price_for_application >= 0),
    image_url varchar(300) not null
)engine=InnoDB;

insert into category(name) values("Sacs en bandoulières");
insert into category(name) values("Sacs cabas");
insert into category(name) values("Sacs à dos");
insert into category(name) values("Trousses");
insert into category(name) values("Sacs de voyage");

insert into product(name, price, category_name) values ("f", 20.2, "Sacs en bandoulières");
insert into product(name, price, category_name) values ("g", 20.2, "Sacs en bandoulières");
insert into product(name, price, category_name) values ("h", 20.2, "Sacs en bandoulières");
insert into product(name, price, category_name) values ("u", 20.2, "Sacs en bandoulières");

insert into product(name, price, category_name) values ("a", 20.2, "Sacs cabas");
insert into product(name, price, category_name) values ("b", 20.2, "Sacs cabas");
insert into product(name, price, category_name) values ("c", 20.2, "Sacs cabas");
insert into product(name, price, category_name) values ("d", 20.2, "Sacs cabas");
insert into product(name, price, category_name) values ("k", 20.2, "Sacs cabas");
insert into product(name, price, category_name) values ("s", 20.2, "Sacs cabas");
insert into product(name, price, category_name) values ("x", 20.2, "Sacs cabas");
insert into product(name, price, category_name) values ("y", 20.2, "Sacs cabas");

insert into product(name, price, category_name) values ("e", 20.2, "Sacs à dos");
insert into product(name, price, category_name) values ("r", 20.2, "Sacs à dos");
insert into product(name, price, category_name) values ("w", 20.2, "Sacs à dos");

insert into product(name, price, category_name) values ("aa", 20.2, "Trousses");
insert into product(name, price, category_name) values ("i", 20.2, "Trousses");
insert into product(name, price, category_name) values ("j", 20.2, "Trousses");
insert into product(name, price, category_name) values ("l", 20.2, "Trousses");
insert into product(name, price, category_name) values ("m", 20.2, "Trousses");
insert into product(name, price, category_name) values ("n", 20.2, "Trousses");
insert into product(name, price, category_name) values ("o", 20.2, "Trousses");
insert into product(name, price, category_name) values ("p", 20.2, "Trousses");
insert into product(name, price, category_name) values ("q", 20.2, "Trousses");
insert into product(name, price, category_name) values ("t", 20.2, "Trousses");
insert into product(name, price, category_name) values ("v", 20.2, "Trousses");

insert into product(name, price, category_name) values ("z", 20.2, "Sacs de voyage");

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

insert into language(language) values ("ENGLISH");
insert into language(language) values ("FRENCH");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "a", "english description for product a");
insert into translation(language, product, product_description_translation) values ("FRENCH", "a", "description francaise du produit a");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "b", "english description for product b");
insert into translation(language, product, product_description_translation) values ("FRENCH", "b", "description francaise du produit b");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "c", "english description for product c");
insert into translation(language, product, product_description_translation) values ("FRENCH", "c", "description francaise du produit c");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "d", "english description for product d");
insert into translation(language, product, product_description_translation) values ("FRENCH", "d", "description francaise du produit d");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "e", "english description for product e");
insert into translation(language, product, product_description_translation) values ("FRENCH", "e", "description francaise du produit e");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "f", "english description for product f");
insert into translation(language, product, product_description_translation) values ("FRENCH", "f", "description francaise du produit f");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "g", "english description for product g");
insert into translation(language, product, product_description_translation) values ("FRENCH", "g", "description francaise du produit g");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "h", "english description for product h");
insert into translation(language, product, product_description_translation) values ("FRENCH", "h", "description francaise du produit h");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "i", "english description for product i");
insert into translation(language, product, product_description_translation) values ("FRENCH", "i", "description francaise du produit i");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "j", "english description for product j");
insert into translation(language, product, product_description_translation) values ("FRENCH", "j", "description francaise du produit j");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "k", "english description for product k");
insert into translation(language, product, product_description_translation) values ("FRENCH", "k", "description francaise du produit k");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "l", "english description for product l");
insert into translation(language, product, product_description_translation) values ("FRENCH", "l", "description francaise du produit l");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "m", "english description for product m");
insert into translation(language, product, product_description_translation) values ("FRENCH", "m", "description francaise du produit m");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "n", "english description for product n");
insert into translation(language, product, product_description_translation) values ("FRENCH", "n", "description francaise du produit n");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "o", "english description for product o");
insert into translation(language, product, product_description_translation) values ("FRENCH", "o", "description francaise du produit o");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "p", "english description for product p");
insert into translation(language, product, product_description_translation) values ("FRENCH", "p", "description francaise du produit p");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "q", "english description for product q");
insert into translation(language, product, product_description_translation) values ("FRENCH", "q", "description francaise du produit q");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "r", "english description for product r");
insert into translation(language, product, product_description_translation) values ("FRENCH", "r", "description francaise du produit r");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "s", "english description for product s");
insert into translation(language, product, product_description_translation) values ("FRENCH", "s", "description francaise du produit s");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "t", "english description for product t");
insert into translation(language, product, product_description_translation) values ("FRENCH", "t", "description francaise du produit t");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "u", "english description for product u");
insert into translation(language, product, product_description_translation) values ("FRENCH", "u", "description francaise du produit u");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "v", "english description for product v");
insert into translation(language, product, product_description_translation) values ("FRENCH", "v", "description francaise du produit v");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "w", "english description for product w");
insert into translation(language, product, product_description_translation) values ("FRENCH", "w", "description francaise du produit w");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "x", "english description for product x");
insert into translation(language, product, product_description_translation) values ("FRENCH", "x", "description francaise du produit x");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "y", "english description for product y");
insert into translation(language, product, product_description_translation) values ("FRENCH", "y", "description francaise du produit y");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "z", "english description for product z");
insert into translation(language, product, product_description_translation) values ("FRENCH", "z", "description francaise du produit z");

insert into translation(language, product, product_description_translation) values ("ENGLISH", "aa", "english description for product aa");
insert into translation(language, product, product_description_translation) values ("FRENCH", "aa", "description francaise du produit aa");

insert into promotion(eventname, event_start_date, event_end_date, image_url)
	values ("reduction_noel", "2019-12-01", "2019-12-30", "https://i.ibb.co/tDdP8K4/snowman-Reduction.png");
insert into promotion(eventname, event_start_date, event_end_date, min_order_price_for_application, image_url)
	values ("reduction_janvier", "2020-01-01", "2020-01-31", 100.0, "https://i.ibb.co/SJyYQhN/reduction-Janvier.png");
    
