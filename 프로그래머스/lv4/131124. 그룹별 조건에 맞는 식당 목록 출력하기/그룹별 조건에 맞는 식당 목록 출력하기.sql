-- 코드를 입력하세요

select member_name, review_text, DATE_FORMAT(review_date, '%Y-%m-%d') as review_date
from rest_review
join
(select m.member_id, m.member_name
from member_profile as m
join (select member_id, count(review_id) as cnt 
      from rest_review as review
      group by member_id
      order by cnt desc
        limit 1 ) as review_top
on review_top.member_id = m.member_id
 ) as member
 on rest_review.member_id = member.member_id
 order by review_date, review_text