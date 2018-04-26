--1
select p.name from person as p where id not in (5);

select p.name, c.name from person as p inner join company as c on c.id = p.company_id;

--2
select company.name, count(person.id) from company, person where company.id = person.company_id group by company.name limit 1;
