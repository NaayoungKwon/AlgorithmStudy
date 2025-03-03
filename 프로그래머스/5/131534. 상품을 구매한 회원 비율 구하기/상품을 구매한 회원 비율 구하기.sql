-- 코드를 입력하세요
# select YEAR(s.sales_date) as year, MONTH(s.sales_date) as month, count(distinct s.user_id) as PURCHASED_USERS
# select su.*, round(su.PURCHASED_USERS / c, 1) as PUCHASED_RATIO
# from
# (
    select YEAR(s.sales_date) as YEAR, MONTH(s.sales_date) as MONTH, count(distinct s.user_id) as PURCHASED_USERS, 
    round(count(distinct s.user_id) / (select count(user_id) from user_info where YEAR(joined) = 2021), 1 ) as PUCHASED_RATIO
from ONLINE_SALE as s
left join USER_INFO as u
on  s.user_id = u.user_id
where YEAR(u.joined) = 2021
group by year, month
order by year, month
# ) as su
# ,
# (select count(distinct user_id) as c from user_info where YEAR(joined) = 2021) as uc

