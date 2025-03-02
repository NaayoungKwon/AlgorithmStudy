-- 코드를 작성해주세요
select  e.year as YEAR, (g.max_colony - e.SIZE_OF_COLONY) as YEAR_DEV, e.id as ID
from
(
    select id, SIZE_OF_COLONY, YEAR(DIFFERENTIATION_DATE) as year
    from ECOLI_DATA
)  as e
 join
(
    select YEAR(DIFFERENTIATION_DATE) as year, max(SIZE_OF_COLONY) as max_colony
    from ECOLI_DATA
    group by YEAR(DIFFERENTIATION_DATE)
)  g
on e.year = g.year
order by YEAR, YEAR_DEV