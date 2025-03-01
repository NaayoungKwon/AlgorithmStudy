-- 코드를 작성해주세요
select child.id as id , child.GENOTYPE as GENOTYPE, parent.GENOTYPE as PARENT_GENOTYPE 
from ECOLI_DATA as child
join ECOLI_DATA as parent
on child.parent_id = parent.id
and child.GENOTYPE & parent.GENOTYPE = parent.GENOTYPE
order by child.id