-- 코드를 입력하세요
# SELECT
#     ingredient_type,
#     sum(total_order) as total_order
# from
#     first_half as f, icecream_info as i
# group by i.ingredient_type
# order by sum(total_order)

select
    ingredient_type,
    sum(total_order) as total_order
from first_half, icecream_info 
where first_half.flavor = icecream_info.flavor 
group by ingredient_type