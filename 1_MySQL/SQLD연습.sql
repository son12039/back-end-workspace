select * from department;
select * from location;
select * from national;
select * from employee;
select * from job;
select * from sal_grade;

select emp_name, dept_title,local_name,national_code from department
join location on location_id=local_code
join employee on dept_id = dept_code
where national_code != 'KO';

select e.emp_name,e.salary from employee e
join employee m on (m.emp_id = e.manager_id);

SELECT *
from employee
join department on (dept_code = dept_id);

SELECT count(*) as employee_count,dept_title 
from employee
join department on (dept_code = dept_id)
group by dept_title;

SELECT dept_title,FLOOR(avg(salary)) as 'average_salary'    -- FORMAT(avg(salary), 0)
from employee
join department on dept_code = dept_id
group by dept_title;

SELECT emp_name,salary,email
from job
join employee using (job_code)
where job_name = '부장';

select emp_id, emp_name, salary, sal_level
from employee
join sal_grade
on salary between min_sal AND max_sal;