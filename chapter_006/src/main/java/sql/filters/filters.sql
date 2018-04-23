create table type (
type_id serial primary key,
name character varying(100)
);

create table product (
product_id serial primary key,
name character varying(100),
type_id integer references type(type_id),
expired_date timestamp,
price integer
);