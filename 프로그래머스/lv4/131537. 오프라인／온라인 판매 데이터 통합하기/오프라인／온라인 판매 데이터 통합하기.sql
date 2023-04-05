-- 코드를 입력하세요
(SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') as sales_date, product_id, user_id, sales_amount
from online_sale
where DATE_FORMAT(sales_date, '%Y-%m') = '2022-03'


union

SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') as sales_date, product_id, null as user_id, sales_amount
from offline_sale
where DATE_FORMAT(sales_date, '%Y-%m') = '2022-03'
 )
order by sales_date, product_id, user_id