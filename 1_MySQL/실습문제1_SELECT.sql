-- sakila, 정렬은 결과 화면대로

-- 1. actor 테이블에서 first_name이 A로 시작하는 배우들만 조회 
select *
from actor 
WHere first_name LIKE 'A%';

-- 2. film 테이블에서 rating이 PG면서 영화 제목(title)에 GO가 포함되는 영화 제목 조회
select TITLE
from film
WHERE TITLE like '%GO%' and rating = 'PG';

-- 3. film 테이블에서 film_id가 7 이하면서 4, 6은 아닌 film_id, title 조회
select title,fid
from film_list
WHERE fid BETWEEN 1 AND 7 AND fid != 4 AND fid != 6;

-- 4. film 테이블에서 가격(replacement_cost)은 10 이상 15 이하이면서 
-- special_features 중 Trailers가 포함되어 있는 영화 제목(title)만 조회 
select title
from film
WHERE replacement_cost BETWEEN 10 AND 15 AND special_features = 'Trailers';

-- 5. address 테이블에서 거리(district)가 A로 시작하는 주소(address)만 앞에 숫자 제외 주소만 10개 조회 
select substr(address,instr(address,' '))
from address 
WHERE district like 'A%'
LIMIT 10 ;

-- 6. customer 테이블에서 id가 6인 사람부터 10명 조회
select *
from customer
 WHERE customer_id >= 6 LIMIT 10;
 
-- 7. actor 테이블에서 first_name이 J로 시작하는 사람의 last_name의 글자수 조회 (공백 X, 정렬은 글자수가 많은 사람 순으로)
select CHAR_LENGTH(last_name )
from actor
where first_name like 'J%'
ORDER BY CHAR_LENGTH(last_name ) desc;

-- 8. film 테이블에서 description에서 of 이전 문장만 중복 없이 10개만 추출해서 조회
select distinct SUBSTR(description,1 ,INSTR(description,'of')-1)
from film
LIMIT 10;

-- 9. film 테이블에서 replacement_cost 최소 비용과 최대 비용 조회
select MIN(replacement_cost),MAX(replacement_cost)
from film;



