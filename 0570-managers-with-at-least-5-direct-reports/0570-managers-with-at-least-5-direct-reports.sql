# Write your MySQL query statement below
select e.name from employee e join  employee r on e.id=r.managerId group by r.managerId having count(*)>=5;