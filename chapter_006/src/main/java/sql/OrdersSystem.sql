create table category (
	category_id serial primary key,
	type text
);

create table states (
	state_id serial primary key,
	description text
);

create table roles (
	role_id serial primary key,
	name character varying(100)
);

create table rules (
	rule_id serial primary key,
	description text
);

create table roles_rules (
	role_id integer references rules(rule_id),
	rule_id integer references roles(role_id)
);

create table users (
	user_id serial primary key,
	name character varying(100),
	role_id integer references roles(role_id)
);

create table items (
	item_id serial primary key,
	description text,
	user_id integer references users(user_id),
	category_id integer references category(category_id),
	state_id integer references states(state_id)
);

create table comments (
	comment_id serial primary key,
	description text,
	item_id integer references items(item_id)
);

create table attachs (
	attach_id serial primary key,
	size integer,
	item_id integer references items(item_id)
);