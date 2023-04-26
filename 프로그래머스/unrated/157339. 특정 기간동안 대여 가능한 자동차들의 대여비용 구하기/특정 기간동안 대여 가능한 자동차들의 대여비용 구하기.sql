-- 코드를 입력하세요
select car_id,car.car_type, CAST(daily_fee * 30 * (100- ifnull(discount_rate,0))/100 AS signed integer)  as fee
from car_rental_company_car as car
left join car_rental_company_discount_plan as discount
on car.car_type = discount.car_type
where 
    car.car_type in ('세단', 'SUV') 
    and
    duration_type = '30일 이상'
    and
    car.car_id not in (
        select car_id
        from car_rental_company_rental_history 
        where 
            # '2022-11' BETWEEN DATE_FORMAT(START_DATE, '%Y-%m') AND DATE_FORMAT(END_DATE, '%Y-%m')
        not (DATE_FORMAT(end_date,"%Y-%m-%d") < '2022-11-01' 
                   or DATE_FORMAT(start_date,"%Y-%m-%d") > '2022-11-30'
                  )
    )
having fee between 500000 and 2000000
order by fee desc, car_type,car_id desc;
    
# select *
#         from car_rental_company_rental_history 
#         where (DATE_FORMAT(end_date,"%Y-%m-%d") <= '2022-11-01' or DATE_FORMAT(start_date,"%Y-%m-%d") >= '2022-11-30') 
#         order by car_id

# select car_type, max(discount_rate)
# from car_rental_company_discount_plan
# where duration_type != '90일 이상'
# group by car_type