-- 코드를 입력하세요
SELECT count(*) as 'count' from 
(select count(name) as c
from animal_ins
where name is not null
group by name) as a