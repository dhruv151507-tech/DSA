SELECT 
    w1.id
FROM Weather w1
join Weather w2
on DATE_ADD(w2.recordDate, INTERVAL 1 DAY)=w1.recordDate
where w1.temperature>w2.temperature;