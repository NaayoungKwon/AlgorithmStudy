-- 코드를 입력하세요
SELECT a.food_type, a.rest_id, a.rest_name, a.favorites
from rest_info as a, (select r.rest_id, max(r.favorites) as favorites, r.food_type from rest_info as r group by r.food_type) as r
where a.favorites = r.favorites and a.food_type = r.food_type
order by a.food_type desc

 # (select r.rest_id, max(r.views), r.food_type from rest_info as r group by r.food_type)
 # select * from rest_info order by favorites desc