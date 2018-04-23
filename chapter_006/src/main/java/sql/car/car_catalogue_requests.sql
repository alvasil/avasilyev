create table transmission (
	id serial primary  key,
	name varchar(100)
);

create table engine (
	id serial primary  key,
	name varchar(100)
);

create table gearbox (
	id serial primary  key,
	name varchar(100)
);

create table car (
	id serial primary  key,
	name varchar(100),
	transmission_id int references transmission(id),
	engine_id int references engine(id),
	gearbox_id int references gearbox(id)
);

select * from car;

--unused transmission
select t.name from transmission as t left outer join car as c on c.id = t.id where c.id is null;

--unused engine
select e.name from engine as e left outer join car as c on c.id = e.id where c.id is null;

--unused gearbox
select g.name from car as c right outer join gearbox as g on c.id = g.id where c.id is null;