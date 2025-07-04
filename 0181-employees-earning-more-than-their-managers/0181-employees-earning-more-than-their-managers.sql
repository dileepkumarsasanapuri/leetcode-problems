# Write your MySQL query statement below
select E.name as Employee from Employee E where E.salary>(Select salary from Employee where id=E.managerId);