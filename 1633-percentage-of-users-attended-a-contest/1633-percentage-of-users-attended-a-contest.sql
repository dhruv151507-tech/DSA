# Write your MySQL query statement below
select r.contest_id, round((count(r.user_id)*100.0/(SELECT COUNT(*) FROM Users)),2) as percentage
from users u
right join register r
on u.user_id=r.user_id
group by r.contest_id
order by percentage desc, r.contest_id asc;