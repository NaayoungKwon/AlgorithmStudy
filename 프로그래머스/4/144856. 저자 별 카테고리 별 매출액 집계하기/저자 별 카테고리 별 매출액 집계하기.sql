-- 코드를 입력하세요
SELECT  BOOK.author_id as AUTHOR_ID , author.author_name as AUTHOR_NAME, book.category as CATEGORY, sum(BOOK.price * BOOK_SALES.sales) as TOTAL_SALES
FROM BOOK
JOIN BOOK_SALES
JOIN AUTHOR
on book.book_id = BOOK_SALES.book_id and book.author_id = AUTHOR.author_id
where DATEDIFF(BOOK_SALES.sales_date ,'2022-01-01') >= 0 and DATEDIFF('2022-02-01', BOOK_SALES.sales_date) > 0
group by  BOOK.author_id, book.category
order by book.author_id asc, category desc