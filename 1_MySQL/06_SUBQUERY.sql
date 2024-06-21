/*
	서브쿼리(SUBQUERY), 중첩쿼리
    - 하나의 SQL문 안에 포함된 또 다른 SQL문
    - 서브쿼리를 수행한 결과값이 몇 행 몇 열이냐에 따라 분류
    - 서브쿼리 종류에 따라 서브쿼리와 사용하는 연산자가 달라짐
    
    1. 단일행 서브쿼리(SINGLE ROW SUBQUERY)
    - 서브쿼리의 조회 결과값의 개수가 오로지 1개일 때 (한 행 한 형)
    - 일반 비교연산자 사용 가능 : =, !=, <>, >, <, >=, <=, ...
    
*/
-- 노옹철 사원과 같은 부서원들을 조회
-- 1) 노옹철 사원의 부서코드 조회
select *
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철'; -- d9

-- 2) dept_code = 'D9' 조회
select *
FROM EMPLOYEE
WHERE dept_code = 'D9';

-- 3) 위의 2단계를 하나의 쿼리문으로!
select *
FROM EMPLOYEE
WHERE dept_code = (select dept_code
				  FROM EMPLOYEE
				  WHERE EMP_NAME = '노옹철');

-- 전 직원의 평균 급여보다 더 많은 급여를 받는 사원들의 사번 사원명 직급코드 급여
select emp_id,emp_name,job_code,salary
FROM EMPLOYEE
where salary > (select avg(salary)
				FROM EMPLOYEE);

-- 전지연 사원이 속해있는 부서원들의 사번 직원명 전화번호 직급명 부서명 입사일
-- 전지연사원은제외
select emp_id,emp_name,phone,job_name,dept_title,hire_date
FROM EMPLOYEE
join job using(job_code)
join department on (dept_id = dept_code)
where emp_name != '전지연' 
and dept_code =  (select dept_code
				from employee
				where emp_name = '전지연');

-- 부서별 급여의 합이 가장 큰 부서의 부서 코드 급여의 합 조회
select dept_code,sum(salary)
from employee
group by dept_code
order by sum(salary) desc
limit 1;

-- >> 서브쿼리 사용!
-- 부서의 합이 가장 큰 값

-- 서브쿼리 특징! 쿼리 자체는 직관적!
-- 쿼리 속도 중요시! 서브쿼리 상대적으로 느려요~~
-- 가급적으로 서브쿼리를 사용하지 않아도 되는 거면 안 쓰고 하시는 걸 추천!
select dept_code,sum(salary)
from employee
group by dept_code
having sum(salary) = (select max(sum_sal)
                     from (select dept_code,sum(salary) sum_sal
						from employee
						group by dept_code) dept_sum);

/*
	2. 다중행 서브쿼리
    - 서브쿼리의 조회 결과 값의 개수가 여러 행 일 때 (여러행 한열)
    
    IN 서브쿼리 : 여러개의 결과값 중에서 한개라도 일치하는 값이 있다면
*/
-- 각 부서별  최고 급여를 받는 직원의 이름 직급코드 부서코드 급여조회
-- 1) 각 부서별 최고급여
select max(salary)
from employee
group by dept_code; -- 얼마얼마,,얼마,얼마,...

select emp_name,job_code,salary
from employee
where salary in (select max(salary)
				from employee
				group by dept_code)  ;

-- 직원에 대한사번 이름 부서코드 구분(사수/사원) 조회
select emp_id, emp_name, dept_code,
		if(emp_id in (select distinct manager_id
					from employee
					where manager_id is not null), '사수','사원') 구분
from employee;

select manager_id
from employee
where manager_id is not null;

select emp_id
from employee;

select *
from employee;
 
/*
	컬럼 > ANY(서브쿼리) : 여러개의 결과값 중에서 "한개라도" 클 경우
    컬럼 < ANY(서브쿼리) : 여러개의 결과값 중에서 "한개라도" 작을 경우
    -- > OR
*/
-- 대리직급임에도 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름 직급 급여
select emp_id,emp_name,job_name,salary
FROM employee
JOIN job USING (job_code)
where job_name = '대리' and
		    salary  > 	any  (select min(salary) 
									FROM employee
									JOIN job USING (job_code)
									WHERE job_name = '과장') ;

/*
		컬럼 > ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 클 경우
        컬럼 < ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 작을 경우
        --> AND
*/
-- 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 사원들의 사번, 이름, 직급, 급여 조회
select emp_id,emp_name,job_name,salary
FROM employee
JOIN job USING (job_code)
where job_name = '과장' AND salary > aLL  (select (salary) 
									FROM employee
									JOIN job USING (job_code)
									WHERE job_name = '차장') ;


/*
	3. 다중열 서브쿼리
    - 서브쿼리의 조회 결과값이 한 행이지만 컬럼이 여러개일 때 (한 행 여러 열)
*/
-- 하이유 사원과 같은 부서코드, 같은 직급 코드에 해당하는 사원들의 사원명 부서코드 직급코드
select emp_name,DEPT_code,job_code
FROM employee
where DEPT_code = (select DEPT_code
							from employee
							where emp_name= '하이유') 
				and job_code = (select job_code
							from employee
							where emp_name= '하이유');

-- >> 다중열 서브쿼리
select emp_name,DEPT_code,job_code
FROM employee
where (DEPT_code,job_code) = (select DEPT_code,job_code
							 from employee
							 where emp_name= '하이유');

-- 박나라 사원과 직급 코드가 일치하면서 같은 사수를 가지고 있는 사원의 사번 이름 직급코드 사수사번

select emp_id,emp_name,job_code,manager_id
FROM employee
where (job_code,manager_id) = (select job_code,manager_id
							 from employee
							 where emp_name= '박나라');

/*
	4. 다중행 다중열 서브쿼리
    - 서브쿼리의 조회 결과값이 여러행, 여러 열일 경우
*/
-- 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급코드,급여 조회
select *
from employee;

select job_code,min(salary) -- 최소급여
from employee
group by job_code;

select emp_id,emp_name,job_code,salary
from employee
where  (job_code,salary)  in (select job_code,min(salary)
					from employee
					group by job_code);

-- 각 부서별 최대 급여를 받는 사원들의 사번, 이름, 부서코드, 급여 조회 (부서없음 명시)

select emp_id,emp_name,  ifnull(dept_code, '부서없음') 부서유무,salary
from employee
where  (ifnull(dept_code, '부서없음'),salary)
									in (select ifnull(dept_code, '부서없음'),max(salary)
									from employee
									group by dept_code);




