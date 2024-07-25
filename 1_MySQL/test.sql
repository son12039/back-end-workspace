CREATE TABLE BigUnit(
	B_code INT primary key auto_increment,
    B_title varchar(30) not null unique
);
CREATE TABLE SmallUnit(
	S_code INT primary key auto_increment,
	S_unit varchar(30) not null ,
    S_title varchar(30) not null unique
);
CREATE TABLE tag(
	T_code INT primary key auto_increment,
    T_unit varchar(30) not null,
    T_title varchar(30) not null unique,
    T_type varchar(30) not null
);
CREATE TABLE member(
	M_id varchar(30) primary key,
	M_password varchar(30) not null,
    M_name varchar(30) not null,
	M_nickname varchar(100) not null,
    M_tag varchar(30) not null
);
CREATE TABLE Mtag(
	M_id varchar(30) not null,
    T_code varchar(30) not null
);
INSERT INTO Mtag VALUES('test1', '1');
INSERT INTO Mtag VALUES('test1', '2');
INSERT INTO Mtag VALUES('test2', '5');
INSERT INTO Mtag VALUES('test2', '6');
INSERT INTO bigunit(B_title) VALUES('운동');

INSERT INTO member VALUES('test1','test1','손정배','돌잡이때트라이캐치잡음');
INSERT INTO member VALUES('test2','test2','채승훈','바보임');
Select * from Mtag
join member using (T_code);

DELETE FROM member;
drop table member;
Select * from bigunit;
Select * from Mtag;
Select * from SmallUnit;
Select * from member;
Select * from tag;

Select * from SmallUnit
join bigunit on (S_unit=B_title);

Select * from tag;
INSERT INTO bigunit(B_title) VALUES('운동');

INSERT INTO SmallUnit(S_unit, S_title ) VALUES('게임', 'RPG');
INSERT INTO SmallUnit(S_unit, S_title ) VALUES('게임', 'RPS');
INSERT INTO SmallUnit(S_unit, S_title ) VALUES('게임', 'FPS');
INSERT INTO SmallUnit(S_unit, S_title ) VALUES('운동', '달리기');
INSERT INTO SmallUnit(S_unit, S_title ) VALUES('운동', '수영');
INSERT INTO SmallUnit(S_unit, S_title ) VALUES('운동', '헬스');


INSERT INTO tag(T_unit, T_title, T_type) VALUES('달리기', '50m달리기', '지구력보다 순간속도!');
INSERT INTO tag(T_unit, T_title, T_type) VALUES('달리기', '10km달리기', '속도보다 지구력!');

INSERT INTO tag(T_unit, T_title, T_type) VALUES('RPG', '메이플스토리', '브금좋음!');
INSERT INTO tag(T_unit, T_title, T_type) VALUES('RPG', '로스트아크', '그래픽!');








