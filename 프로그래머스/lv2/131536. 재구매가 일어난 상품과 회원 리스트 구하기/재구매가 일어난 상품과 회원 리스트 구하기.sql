-- 코드를 입력하세요
select user_id, product_id from online_sale group by user_id, product_id  having count(sales_date) > 1 order by user_id, product_id desc
# SELECT user_id, count(product_id) from online_sale group by user_id order by user_id, product_id
# select * from online_sale where user_id = 2
# select * from online_sale order by user_id