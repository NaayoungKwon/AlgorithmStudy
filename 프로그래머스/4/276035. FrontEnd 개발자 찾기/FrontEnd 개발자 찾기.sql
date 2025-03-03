-- 코드를 작성해주세요
select distinct d.id, d.email, d.first_name, d.last_name
from
    DEVELOPERS as d
join
    SKILLCODES as s
on d.SKILL_CODE & s.code = s.code
where s.category = 'Front End'
order by id