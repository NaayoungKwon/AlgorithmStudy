-- 코드를 입력하세요
select c.car_id,
    case
        when c.car_id in (SELECT car_id
                                from car_rental_company_rental_history as ct
                                where DATE_FORMAT(ct.start_date,"%Y-%m-%d") <= "2022-10-16" 
                              and DATE_FORMAT(ct.end_date,"%Y-%m-%d") >= "2022-10-16"
                                 )
        then '대여중'
        else '대여 가능'
    end as availability
from car_rental_company_rental_history as c
group by car_id
order by car_id desc