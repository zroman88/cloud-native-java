
-- Adding a few initial products 
insert into product(id, name, cat_Id) values (1, 'Apples', 1)
insert into product(id, name, cat_Id) values (2, 'Oranges', 1)
insert into product(id, name, cat_Id) values (3, 'Bananas', 1)
insert into product(id, name, cat_Id) values (4, 'Carrot', 2)
-- create table product(id serial primary key, name varchar(20), cat_id int not null);
-- begin;
-- insert into product(name, cat_id) values ('Apples', 1);
-- insert into product(name, cat_id) values ('Oranges', 1);
-- insert into product(name, cat_id) values ('Bananas', 1);
-- insert into product(name, cat_id) values ('Carrots', 2);
-- insert into product(name, cat_id) values ('Beans', 2);
-- insert into product(name, cat_id) values ('Peas', 2);
-- commit;