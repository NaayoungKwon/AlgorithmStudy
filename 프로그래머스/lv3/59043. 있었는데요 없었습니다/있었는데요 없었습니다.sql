-- 코드를 입력하세요
# SELECT
#     animal_ins.animal_id, animal_outs.name
# from
#     animal_ins inner join animal_outs
# on
#     animal_ins.animal_id = animal_outs.animal_id
# where
#     animal_ins.datetime > animal_outs.datetime
# order by
#     animal_ins.datetime

SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS AS I, ANIMAL_OUTS AS O
WHERE I.ANIMAL_ID = O.ANIMAL_ID AND I.DATETIME > O.DATETIME
ORDER BY I.DATETIME