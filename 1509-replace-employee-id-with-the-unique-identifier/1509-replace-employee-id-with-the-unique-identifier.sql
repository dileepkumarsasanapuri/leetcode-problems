# Write your MySQL query statement belo
select unique_id,name from Employees e left join  EmployeeUNI f on e.id=f.id;