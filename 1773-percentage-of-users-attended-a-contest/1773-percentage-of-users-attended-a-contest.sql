# Write your MySQL query statement below
select r.contest_id,round((count(distinct(r.user_id))/t.total)*100,2) as percentage
from register r join (select count(distinct(user_id)) as total from users) t   
group by r.contest_id order by percentage desc,r.contest_id ;