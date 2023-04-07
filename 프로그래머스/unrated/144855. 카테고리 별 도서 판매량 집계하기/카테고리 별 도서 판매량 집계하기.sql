-- 코드를 입력하세요
SELECT category, sum(book_sales.sales) as total_sales
from book
left join book_sales
on book.book_id = book_sales.book_id
where DATE_FORMAT(book_sales.sales_date, '%Y-%m') = '2022-01'
group by category
order by category