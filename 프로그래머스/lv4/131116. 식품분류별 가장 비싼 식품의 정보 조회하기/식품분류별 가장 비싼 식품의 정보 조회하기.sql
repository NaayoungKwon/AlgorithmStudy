-- 코드를 입력하세요
select m.category, m.max_price , f.product_name
from food_product as f
inner join
    (SELECT max(price) as max_price, category
    from food_product
    where category in ('식용유', '과자', '국','김치')
    group by category) as m
on f.category = m.category and f.price = m.max_price
order by m.max_price desc