-- sakila, 정렬은 결과 화면대로

-- 1. actor 테이블에서 first_name이 A로 시작하는 배우들만 조회 
select * from actor
where first_name Like 'a%';
-- 2. film_list 테이블에서 category가 Sci-Fi 또는 Family면서 
--    rating이 PG면서 영화 제목(title)에 GO가 포함되는 영화 제목 조회 
select * from film_list
where category in ('Sci-Fi' ,'Family')
AND rating ='PG'
AND title LIKE '%GO%';
select title
from film_list
WHERE TITLE like '%GO%' and rating = 'PG' and category in ('Sci-Fi', 'Family');

-- 3. film_list 테이블에서 fid가 7 이하면서 4 또는 6이 아닌 fid, title 조회
select * from film_list
where fid <= 7
AND fid NOT IN (4,6);
select title,fid
from film_list
WHERE fid <= 7 AND fid != 4 AND fid != 6;

-- 4. film_list 테이블에서 가격(price)은 2 이상 4 이하이면서 
--    category가 Documentary거나 Animation이고 배우들(actors) 중 
--    BOB가 포함되어 있는 영화 제목(title)만 조회 
select *
from film_list
where price between 2 AND 4 
AND category IN('Documentary','Animation')
AND actors LiKE '%BOB%';

-- 5. address 테이블에서 district가 비어있지 않고 앞에 숫자 제외 주소만 10개 조회 
select trim(regexp_replace(address, '[0-9]', '')) from address
WHERE district is not null;
select * from address;

SELECT REGEXP_REPLACE('Ad124 @dress 123 @5Main21 214  S12t.23', '[0-9a-z]', '')
FROM dual;

select substr(address,instr(address,' ')+1),district
from address 
WHERE district != ''
order by 2,1 desc
LIMIT 10;
 select address,  trim(regexp_replace(address, '[0-9]', ''))
from address
LIMIT 10;
 
-- 6. customer_list 테이블에서 id가 6인 사람부터 10명 조회 
select *
from customer
 WHERE customer_id >= 6 
 LIMIT 10;
-- 7. actor 테이블에서 J로 시작하는 이름과 글자수 조회 
--    (공백 X, 정렬은 글자수가 많은 사람 순으로)
select concat (first_name,' ',last_name) 이름,
(CHAR_LENGTH(last_name )+CHAR_LENGTH(first_name)) 글자수
from actor
where first_name like 'J%'
ORDER BY 글자수 desc;
-- 8. film 테이블에서 description에서 of 이전 문장만 중복 없이 10개만 추출해서 조회
select distinct SUBSTR(description,1 ,INSTR(description,'of')-2) 'of 이전 문장'
from film
order by 1 desc
LIMIT 10;
-- 9. film 테이블에서 replacement_cost 최소 비용과 최대 비용 조회
select MIN(replacement_cost)최소비용,MAX(replacement_cost)최대비용
from film;