set search_path to shop;
create extension if not exists "uuid-ossp";


alter table if exists shop.order_details drop constraint if exists FK4q98utpd73imf4yhttm3w0eax;

alter table if exists shop.order_details drop constraint if exists FKint27bl8qoql1ksaw8ik7cq95;

alter table if exists shop.order_details drop constraint if exists FKh1wp782yv6nc7q58cy4vli8kq;

alter table if exists shop.orders drop constraint if exists FKpxtb8awmi0dk6smoh2vp1litg;

alter table if exists shop.products drop constraint if exists FK6t5dtw6tyo83ywljwohuc6g7k;

alter table if exists shop.stock drop constraint if exists FKeuiihog7wq4cu7nvqu7jx57d2;

alter table if exists shop.stock drop constraint if exists FKsvpbcbknxvv1cvg9hhfyyfe4n;


drop table if exists shop.customers cascade;

drop table if exists shop.locations cascade;

drop table if exists shop.order_details cascade;

drop table if exists shop.orders cascade;

drop table if exists shop.product_categories cascade;

drop table if exists shop.products cascade;

drop table if exists shop.stock cascade;


create table customers (id uuid not null default uuid_generate_v4(), email_address varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), username varchar(255), primary key (id));

create table locations (id uuid not null default uuid_generate_v4(), city varchar(255), country varchar(255), county varchar(255), name varchar(255), street varchar(255), primary key (id));

create table order_details (quantity integer not null, orders_id uuid not null, product_id uuid not null, shipped_from_id uuid, primary key (orders_id, product_id));

create table orders (created_at timestamp(6), customer_id uuid, id uuid not null default uuid_generate_v4(), city varchar(255), country varchar(255), county varchar(255), street varchar(255), primary key (id));

create table product_categories (id uuid not null default uuid_generate_v4(), description varchar(255), name varchar(255), primary key (id));

create table products (price numeric(38,2), weight float(53) not null, category_id uuid, id uuid not null default uuid_generate_v4(), description varchar(255), imageurl varchar(255), name varchar(255), primary key (id));

create table stock (quantity integer not null, location_id uuid not null, product_id uuid not null, primary key (location_id, product_id));


alter table if exists shop.order_details add constraint FK4q98utpd73imf4yhttm3w0eax foreign key (product_id) references shop.products;

alter table if exists shop.order_details add constraint FKint27bl8qoql1ksaw8ik7cq95 foreign key (orders_id) references shop.orders;

alter table if exists shop.order_details add constraint FKh1wp782yv6nc7q58cy4vli8kq foreign key (shipped_from_id) references shop.locations;

alter table if exists shop.orders add constraint FKpxtb8awmi0dk6smoh2vp1litg foreign key (customer_id) references shop.customers;

alter table if exists shop.products add constraint FK6t5dtw6tyo83ywljwohuc6g7k foreign key (category_id) references shop.product_categories;

alter table if exists shop.stock add constraint FKeuiihog7wq4cu7nvqu7jx57d2 foreign key (product_id) references shop.products;

alter table if exists shop.stock add constraint FKsvpbcbknxvv1cvg9hhfyyfe4n foreign key (location_id) references shop.locations;