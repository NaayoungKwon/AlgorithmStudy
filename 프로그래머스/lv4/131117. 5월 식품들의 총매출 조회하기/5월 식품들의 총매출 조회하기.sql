-- 코드를 입력하세요
SELECT p.product_id, p.product_name, sum(p.price * o.amount) as total_sales
from food_product as p
join food_order as o
on p.product_id = o.product_id
where DATE_FORMAT(produce_date,'%Y-%m') = '2022-05'
group by o.product_id
order by total_sales desc, p.product_id