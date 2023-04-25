-- 코드를 입력하세요
# set hour = -1
# (select hour, count(*) as count
# from (SELECT DATE_FORMAT(datetime, "%H") as hour
#         from animal_outs) as h
# group by hour)
# order by hour

SET @HOUR = -1;
SELECT (@HOUR := @HOUR +1) AS HOUR, (select count(*)
        from animal_outs where  DATE_FORMAT(datetime, "%H") = @HOUR) as count
FROM ANIMAL_OUTS
WHERE @HOUR < 23;