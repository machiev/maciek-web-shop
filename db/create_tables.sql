
create table customer ( 
id INT NOT NULL AUTO_INCREMENT, 
name VARCHAR(20) NOT NULL, 
surname VARCHAR(20) default NULL, 
PRIMARY KEY (id) 
);

create table product ( 
id INT NOT NULL AUTO_INCREMENT, 
name VARCHAR(32) NOT NULL, 
description VARCHAR(64) default NULL, 
PRIMARY KEY (id) 
);

create table cust_order ( 
id INT NOT NULL AUTO_INCREMENT, 
cust_id INT NOT NULL,
FOREIGN KEY (cust_id)
    REFERENCES customer(id)
    ON DELETE NO ACTION,
PRIMARY KEY (id) 
);

create table order_item ( 
id INT NOT NULL AUTO_INCREMENT, 
ord_id INT NOT NULL,
name VARCHAR(32) default NULL, 
description VARCHAR(64) default NULL,
count INT NOT NULL,
FOREIGN KEY (ord_id)
    REFERENCES cust_order(id)
    ON DELETE CASCADE,
PRIMARY KEY (id)
);


insert into product (name, description) values ('Samsung TV', 'Samsung TV 54"');
insert into product (name, description) values ('Sony PlayStation 4', 'Sony PlayStation 4 Console');
insert into product (name, description) values ('Garmin Smartwatch', 'Garmin Forerunner');
insert into product (name, description) values ('Laptop Lenovo', 'IdeaPad 110 15 N3060');


insert into customer (name, surname) values ('Alan', 'Moore');
insert into customer (name, surname) values ('Lucy', 'Long');
insert into customer (name, surname) values ('Kevin', 'Black');
