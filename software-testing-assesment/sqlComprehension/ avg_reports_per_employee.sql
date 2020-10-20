select ((select sum(reports_to) from employees) / (select count(1) from employees)) as avarage, count(1) as count
from employees
where reports_to > ((select sum(reports_to) from employees) / (select count(1) from employees));