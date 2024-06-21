/*
	JOIN
    - 두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용하는 구문
    - 조회 결과는 하나의 결과물(RESULT SET)으로 나옴
    - 관계형 데이터베이스는 최소한의 데이터로 각각의 테이블에 담고 있음
      (중복을 최소화하기 위해 최대한 쪼개서 관리)
      부서 데이터는 부서 테이블, 사원에 대한 데이터는 사원 테이블, 직급 테이블 등...
      
      만약 어떤 사원어떤 부서에 속해있는지 부서명과 같이 조회하고 싶다면?
      만약 어떤 사원이 어떤 직급인지 직급명과 같이 조회하고 싶다면?
      
      => 즉, 관계형 데이터베이스에서 SQL 문을 이용한 테이블 간에 "관계"를 맺어 원하는 데이터만 조회하는 방법
*/
/*
	1. 내부 조인(INNER JOIN)
    - 연결시키는 컬럼의 값이 일치하는 행들만 조인되어 조회 (일치하는 값이 없는 행은 조회 X)

	1) WHERE 구문
	SELECT 컬럼, 컬럼, ...
	FROM 테이블1, 테이블2
	WHERE 테이블1.컬럼명 = 테이블2.컬럼명;
    
    - FROM 절에 조회하고자 하는 테이블들을 콤마(,)로 구분하여 나열
    - WHERE 절에 매칭시킬 컬럼명에 대한 조건 제시
    
    2) ANSI(미국국립표준협회 : 산업표준을 제정하는 단체) 표준 구문 -> 다른 DB에서도 사용 가능!
	SELECT 컬럼, 컬럼, ..
    FROM 테이블1
    [INNER] JOIN 테이블2 ON (테이블1.컬럼명 = 테이블2.컬럼명);
    
    - FROM 절에서 기준이 되는 테이블을 기술
    - JOIN 절에서 같이 조회하고자 하는 테이블을 기술 후 매칭 시킬 컬럼에 대한 조건을 기술 (ON, USING)
    - 연결에 사용하려는 컬럼명이 같은 경우 ON 구문 대신 USING(컬럼명) 구문 사용
*/
-- 1) 연결할 두 컬럼명이 다른 경우 (employee : dept_code - department : dept_id)
-- 사번ID, 사원명NAME, 부서코드DEPT, 부서명DEPT_TITLE 조회
select * FROM employee;
select * FROM department;
select emp_id, emp_name, dept_code, dept_title
from employee, department
where dept_code = dept_id;

-- >> ANSI 구문
select emp_id, emp_name, dept_code, dept_title
from employee
inner join department on (dept_code = dept_id);

-- 일치하는 값이 없는 행은 조회에서 제외된 것 확인!
-- dept_code가 null인 사원 조회x

-- 2) 연결할 두 컬럼명이 같은 경우 (employee : job_code - job : job_code)
-- 사번, 사원명, 직급코드, 직급명 조회  
select emp_id, emp_name, job_code, job_name
from employee, job
where job_code = job_code; -- amniguous : 애매한,모호한/에러!

-- 해결방법 1) 테이블명 이용
select emp_id, emp_name, job.job_code, job_name
from employee, job
where employee.job_code = job.job_code;

-- 해결방법 2) 테이블명에 별칭부여해서 이용
select emp_id, emp_name, j.job_code, job_name
from employee e, job j
where e.job_code = j.job_code;

-- >> ANSI 구문
select emp_id, emp_name, e.job_code, job_name
from employee e
JOIN job j on (e.job_code = j.job_code);

-- 두 컬럼명이 같을 때만 USING 구문 사용 가능!
select emp_id, emp_name,job_code, job_name
from employee
JOIN job USING (job_code);

-- 자연조인(NATURAL JOIN) : 각 테이블마다 동일한 컬럼이 한 개만 존재할 경우
-- 주의사항! 쓰지마세요!! @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
SELECT emp_id, emp_name, job_code, job_name
FROM employee
NATURAL JOIN job;

-- 직급이 대리인 사원의 사번(emp_id), 이름(emp_name), 직급명(job_name), 급여(salary)조회
SELECT emp_id, emp_name, salary,job_name
FROM employee
JOIN job using(job_code)
where job_name = '대리';

-- 실습문제 ---
-- 1. 부서가 인사관리부인 사원들의 사번, 이름 보너스 조회 (employee, department)
select emp_id, emp_name,bonus,dept_title
from employee
JOIN department on (dept_id = dept_code)
where dept_title = '인사관리부';

-- 2. 전체 부서의 부서코드 부서명 지역코드 지역명 조회 (department, location)
select dept_id, dept_title, local_code,local_name
from department
JOIN location on (location_id = local_code);

-- 3. 보너스를 받는 사원들의 사번 사원명 보너스 부서명 조회 (employee, department)
select emp_id, emp_name,bonus,dept_title
from employee
JOIN department on (dept_id = dept_code)
where bonus IS not null;

-- 4. 부서가 총무부가 아닌 사원들의 사원명 급여 조회 (employee, department)
select emp_name, salary
from employee
  right JOIN department on (dept_id = dept_code)
where dept_title != '총무부';

/*
	2. 외부 조인 (outer join) MySQL은 ANSI 구문만 가능
    - 두 테이블 간의 JOIN 시 일치하지 않는 행도 포함시켜서 조회가 가능하다.
    - 단, 반드시 기준이 되는 테이블(컬럼)을 지정해야 한다. (LEFT, RIGHT, FULL)
*/
-- 사원명, 부서명, 급여, 연봉(급여*12) 조회
select EMP_NAME, DEPT_TITLE, SALARY,SALARY*12
FROM employee
	JOIN DEPARTMENT ON(dept_id = dept_code);
-- > 부서 배치가 안 된 사원 2명에 대한 정보 조회 X
-- > 부서에 배정된 사원이 없는 부서도 정보 조회 X

-- 1) LEFT JOIN : 두 테이블 중 왼쪽에 기술된 테이블을 기준으로 JOIN
select EMP_NAME, DEPT_TITLE, SALARY,SALARY*12
FROM employee
	LEFT JOIN DEPARTMENT ON(dept_id = dept_code);

-- 2) LEFT JOIN : 두 테이블 중 오른쪽에 기술된 테이블을 기준으로 JOIN
select EMP_NAME, DEPT_TITLE, SALARY,SALARY*12
FROM employee
	RIGHT JOIN DEPARTMENT ON(dept_id = dept_code);

-- 3) FULL JOIN : 두 테이블이 가진 모든 행을 조회할 수 있음 - My SQL X

/*
	3. 비등가 조인 (NON EQUAL JOIN)
    - 매칭시킬 컬럼에 대한 조건 작성시 '='(등호)를 사용하지 않는 조인문
    - 값의 범위에 포함되는 행들을 연결하는 방식
    - ANSI 구문으로는 JOIN ON만 사용 가능! (USING 사용 불가)
*/
SELECT*FROM employee; -- salary
SELECT*FROM sal_grade; -- 급여 등급 테이블 : sal_level, min_sal, max_sal -> salary와 연관!

-- 사원명, 급여, 급여 레벨 조회
SELECT emp_name,salary,sal_level
FROM employee
	join sal_grade on (salary between min_sal and max_sal);

SELECT emp_name,salary,sal_level
FROM employee, sal_grade
where salary between min_sal and max_sal;

/*
	4. 자체 조인(self join)
    - 같은 테이블을 다시 한번 조인하는 경우 (자기 자신과 조인)
    
*/
select * from employee;

-- 전체 사원의 사원사번 사원명 사원부서코드 사수사번manager_id
-- 			사수사번, 사수명 사수부서코드 조회
select e.emp_id '사원사번',e.emp_name'사원명',e.dept_code'사원부서코드',e.manager_id '사수사번',
	   m.emp_name'사수명',m.dept_code'사수부서코드'
from employee e
left join employee m on (m.emp_id = e.manager_id);

/*
	5. 카테시안곱(CARTESIAN PRODUCT) / 교차 조인 (CROSS JOIN)
    - 조인되는 모든 테이블의 각 행들이 서로서로 모두 매핑된 데이터가 검색된다. (곱집합)
    - 두 테이블의 행들이 ㅣ모두 곱해진 행들의 조합이 출력 -> 방대한 데이터 출력 -> 과부하 위험
*/
-- 사원명, 부서명 조회 (EMPLOYEE - emp_name, department - dept_title)
-- >> where
select emp_name, dept_title
from employee, department;

-- >> ANSI 구문
select EMP_NAME, DEPT_TITLE
FROM employee CROSS JOIN department;

/*
	6. 다중 JOIN
    - 여러 개의 테이블을 조인하는 경우
*/
-- 사번, 사원명, 부서명, 직급명 조회
SELECT * FROM employee; -- emp_id, emp_name // dept_code, job_code
SELECT * FROM department; -- dept_title //dept id
SELECT * FROM job; -- job_name // job_code

select emp_id, emp_name, job_code,dept_title
FROM employee
	join department on (dept_code = dept_id ) 
    join job using (job_code);

-- 실습문제 ---
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select * from employee; 
select * from location;
select * fROM national;
select * from department; 
SELECT * FROM JOB;
select * fROM sal_grade;

-- 1. 직급이 대리면서 asia 지역에서 근무하는 직원들의 사번 직원명 직급명 부서명 근무지역 급여 조회
select emp_id,emp_name, job_name,dept_title,local_name,salary
from employee
	join department on (dept_code = dept_id)
    join location on (location_id = local_code)
    join JOB using (job_code)
where local_name like '%ASIA%' AND job_name = '대리';

-- 2. 70년대생 이면서 여자이고, 성이 전씨인 직원들의 직원명 주민번호 부서명 직급명 조회
select emp_name, emp_no,dept_title,job_name
from employee
	join department on (dept_code = dept_id)
    join location on (location_id = local_code)
    join JOB using (job_code)
    where emp_no like '7_____-2%'
    and emp_name like '전%';
    -- 
-- 3. 보너스를 받은 직원들의 직원명 보너스 연봉 부서명 근무지역조회
--    부서가 없는 직원들도 나타내고 싶다면 LEFT JOIN (employee 테이블이 왼쪾에 있을 때)
select emp_name,bonus,(salary*12*(bonus + 1)) 보너스포함연봉,dept_title,local_name
from employee
	left join department on (dept_code = dept_id)
    left join location on (location_id = local_code)
    where bonus is not null;
    
-- 4. 한국과 일본에서 근무하는 직원들의 직원명 부서명 근무지역 근무 국가 조회
select emp_name,dept_title,local_name,national_name
from employee
	join department on (dept_code = dept_id)
    join location on (location_id = local_code)
    JOIN national USING (national_code)
    where national_code in ('KO','JP');
    
-- 5. 각 부서별 평균 급여를 조회하여 부서명 평균급여 조회
select dept_title, FORMAT(avg(salary),0)
from employee
	join department on (dept_code = dept_id)
group by dept_title;

-- 6 각 부서별 총 급여의 합이 1000만원 이상인 부서명, 급여 합 조회
select dept_title, SUM(salary) 급여합
from employee
	join department on (dept_code = dept_id)
    group by dept_title
    HAVING 급여합 >= 10000000;
    
-- 7 사번 직원명 직급명 급여등급 구분 조회
-- 이때구분에 해당하는 값은 아래 참고
-- 급여 등급이 s1 s2인경우 고급
-- s3 s4인경우 중급
-- s5 s6인 경우 초급
SELECT emp_id,emp_name,job_name,sal_level,
IF(sal_level IN ('S1','S2'),'고급',
if(sal_level IN ('S3','S4'),'중급','초급'))
FROM employee
	join sal_grade on (salary between min_sal and max_sal)
    JOIN JOB USING (JOB_CODE);
    
-- 8. 보너스를 받지 않은 직원들 중 직급 코드가 j4 또는 j7인 직원들의 직원명 직급명 급여 조회
SELECT emp_name,job_name,salary,job_code,BONUS
FROM employee
join JOB using (job_code)
WHERE job_code IN ('J4','J7') AND BONUS IS NULL;

-- 9. 부서가 있는 직원들의 직원명 직급명 부서명 근무지역 조회
SELECT emp_name,job_name,DEPT_TITLE, local_name
FROM employee
join department ON (dept_id = dept_code)
JOIN location ON (location_id = local_code)
JOIN JOB USING (job_code);

-- 10. 해외영업팀에 근무하는 직원들의 직원명, 직급명, 부서코드, 부서명 조회
select emp_name,job_name,dept_code,DEPT_TITLE
FROM employee
JOIN department ON (dept_id = dept_code)
JOIN JOB USING (job_code)
WHERE DEPT_TITLE LIKE '해외영업%';

-- 11. 이름에 형 자가 들어있는 직원들의 사번 직원명 직급명
select emp_id,emp_name,job_name
FROM employee
JOIN JOB USING (job_code)
WHERE emp_name LIKE '%형%';

-- 12. 사번 사원명 부서명 직급명 지역명 국가명 급여등급 조회
select emp_id,emp_name,dept_title,job_name,local_name,national_name,sal_level
from employee
	join department on (dept_code = dept_id)
    join location on (location_id = local_code)
    join JOB using (job_code)
	JOIN national USING (national_code)
	join sal_grade on (salary between min_sal and max_sal);
    
select * from employee; 
select * from location;
select * fROM national;
select * from department; 
SELECT * FROM JOB;
select * fROM sal_grade;
