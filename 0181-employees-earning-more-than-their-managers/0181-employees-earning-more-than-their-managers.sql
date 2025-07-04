# Write your MySQL query statement below
select E.name as Employee from Employee E Join Employee F on E.managerId=F.id where E.salary>F.salary; 