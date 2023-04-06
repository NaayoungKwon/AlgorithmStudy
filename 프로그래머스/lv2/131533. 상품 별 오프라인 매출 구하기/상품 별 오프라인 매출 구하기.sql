-- 코드를 입력하세요
SELECT product.product_code, sum(product.price *offline_sale.sales_amount) as sales
from product
left outer join offline_sale
on product.product_id = offline_sale.product_id
where offline_sale.sales_amount is not null
group by product.product_code
order by sales desc, product.product_code asc