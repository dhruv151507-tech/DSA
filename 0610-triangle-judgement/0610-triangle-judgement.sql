# Write your MySQL query statement below
select x,y,z, 
CASE
    when x+y > z 
    AND x+z>y
    AND y+z>x
    THEN 'Yes'
    Else 'No'
END AS triangle
from Triangle;