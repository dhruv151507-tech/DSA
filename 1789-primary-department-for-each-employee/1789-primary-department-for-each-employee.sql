# Write your MySQL query statement below
select e.employee_id, e.department_id
from employee e
where primary_flag = 'Y'

UNION
select e.employee_id, e.department_id
from Employee e
group by e.employee_id
having count(department_id)=1;
