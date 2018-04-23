--1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product
where type_id = 1;

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product as p
where p.name like '%мороженое%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product
where expired_date between '2018-05-01 00:00:01' and '2018-05-31 23:59:59';

--4. Написать запрос, который вывод самый дорогой продукт.
select * from product
where price = (select max(price) from product);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select count(product_id) from product
where type_id = 2;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО".
select * from product
where type_id = 1 or type_id=2;

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select type_id from product group by product_id having count (price) < 2;

--8. Вывести все продукты и их тип.
select * from product as p
inner join type as t on p.type_id = t.type_id;


 