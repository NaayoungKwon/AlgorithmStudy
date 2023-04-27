-- 코드를 입력하세요
SELECT user_id, nickname, sum(price) as price
from used_goods_user as users
join used_goods_board as goods
on users.user_id = goods.writer_id
where goods.STATUS = "DONE"
group by users.user_id
having price >= 700000
order by price