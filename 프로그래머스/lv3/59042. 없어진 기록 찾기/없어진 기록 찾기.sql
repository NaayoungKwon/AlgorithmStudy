-- 코드를 입력하세요
SELECT
    outs.animal_id, outs.name
from
    animal_ins as ins right outer join animal_outs as outs
on
    ins.animal_id = outs.animal_id
where
    intake_condition is null