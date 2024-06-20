/*
	GROUP BY
    - 그룹 기준을 제시할 수 있는 구문
    - 여러 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용
*/
-- 각 부서별 조회
SELECT 
	dept_code, 
    count(*) "사원 수",
    format(sum(salary), 0) "총 급여",
    format(avg(salary), 0) "평균 급여",
    min(salary) "최저 급여",
    max(salary) "최고 급여"
FROM employee
GROUP BY dept_code;

-- 직급 코드 (job_code별 사원 수 조회
select
	job_code, count(*) '사원 수'
FROM employee
group by job_code;

-- 성별(남자/여자) 별 사원 수 조회
select if(substr(emp_no, 8,1)=1 ,'남', '여'), count(*) "사원 수"
from employee
group by if(substr(emp_no, 8,1)=1 ,'남', '여');

/*
	HAVING
    - 그룹에 대한 조건을 제시할 때 사용하는 구문
    
    select    * | 조회하고자 하는 컬럼명 AS 별칭 | 함수
    FROM	  조회하고자 하는 테이블명
    WHERE	  조건식 (연산자들 가지고 기술)
    GROUP BY  그룹 기준에 해당하는 컬럼명 | 함수
    HAVING    조건식 (그룹 함수를 가지고 기술)
    ORDER BY  컬럼명 | 컬럼순번 | 별칭 [ASC | DESC]
    LIMIT;
*/
-- 부서별 평균 급여가 300만원 이상인 부서의 평균 급여 조회
select dept_code, avg(SALARY) 평균급여
FROM employee
GROUP BY dept_code
HAVING 평균급여 >= 3000000;

-- 직급별 총 급여의 합이 1000만원 이상인 직급만 조회
select job_code, SUM(SALArY) 합급여
FROM employee
GROUP BY job_code
HAVING 합급여 >= 10000000;

-- 부서별 보너스를 받는 사원이 없는 부서만 조회
select dept_code, COUNT(BONUS) 
FROM employee
GROUP BY dept_code
HAVING COUNT(BONUS) = 0;

-- 부서별 보너스를 받는 사원들만 조회
select dept_code, count(*)
FROM employee
WHERE BONUS iS NOT NULL
GROUP BY dept_code;

/*
	rollup|cube(컬럼1,컬럼2) (cube는 mySQL X) - 보기힘든 집계 함수// 시험용 시험용 시험용
    - 그릅별 산출한 결과 값의 중간 집계를 계산 해주는 함수
    - rollup : 컬럼1을 가지고 다시 중간집계를 내는 함수
    - cube : 컬럼1을 가지고 중간집계도 내고, 컬럼2를 가지고도 중간집계를 냄
    
    MySQLd에서의 rollup
    컬럼1, 컬럼2 with rollup
    
    grouping : rollup이나 cube에 의해 산출된 값이 해당 컬럼의 집합의 산출물이면 0, 아니면 1
    -> 집계된 값인지, 아닌지 정도만 구분
    
    SQLD 자격증 시험에서 꼭 이상하게 나오기도 하지만 실제 쓰이지 않음!!
    저희 문제에서도 안 나옴! 몰라도 됩니다..
*/
-- 부서별, 직급별 급여 합 조회
SELECT dept_code, job_code, sum(salary)
FROM employee
GROUP BY dept_code , job_code with rollup;

/*
	집합 연산자 
    - 여러 개의 쿼리문을 하나의 쿼리문으로 만드는 연산자
    - 여러 개의 쿼리문에서 조회하려고 하는 컬럼의 개수와 이름이 같아야 사용할 수 있다. 
    
    주의! ORDER BY 절은 마지막에만 기술 가능
    
    UNION (합집합) : 두 쿼리문을 수행한 결과값을 하나로 합쳐서 추출 (중복되는 행 제거)== OR연산자
    UNION ALL (합집합) : 두 쿼리문을 수행한 결과값을 하나로 합쳐서 추출(중복되는 행 제거 X)
    INTERSECT (교집합) : 두 쿼리문을 수행한 결과값에 중복된 결과값만 추출 (MySQL X)== AND연산자
    MINUS (차집합) : 선행 쿼리문의 결과값에서 후행 쿼리문의 결과값을 뱬 나머지 결과값만 추출 (MySQL X)
    --> INTERSECT,MINUS : WHERE절에서 AND 연산자를 사용해서 처리 가능!
*/
-- 1. UNION
-- (1) 부서 코드가 D5인 사원들의 사번, 사원명, 부서코드, 급여 조회
select EMP_ID,EMP_NAME,dept_code,SALARY
FROM employee
WHERE dept_code= 'D5'
UNION
-- (2) 급여가 300만원 초과인 사원들의 사번 사원명 부서코드 급여조회
select EMP_ID,EMP_NAME,dept_code,SALARY
FROM employee
WHERE SALARY> 3000000
order by emp_id;

-- 1. UNION ALL

select EMP_ID,EMP_NAME,dept_code,SALARY
FROM employee
WHERE dept_code= 'D5'
UNION ALL

select EMP_ID,EMP_NAME,dept_code,SALARY
FROM employee
WHERE SALARY> 3000000;
-- 부서 코드가 D5이거나 급여가 300만원 초과인 사원들의 사번 사원명 부서코드 급여조회
-- 위 쿼리문 대신 WHERE 절에 OR 연산자를 사용해서 처리 가능
select EMP_ID,EMP_NAME,dept_code,SALARY
FROM employee
WHERE SALARY> 3000000 OR dept_code= 'D5';






