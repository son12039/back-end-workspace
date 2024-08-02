drop table comment;
drop table video_like;
drop table video;
drop table subscribe;
drop table channel;
drop table member;

-- 회원
CREATE TABLE member(
	id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    email VARCHAR(50),
    phone VARCHAR(13)
);

-- 채널
CREATE TABLE channel(
	channel_code INT PRIMARY KEY AUTO_INCREMENT,
    channel_img VARCHAR(100),
    channel_name VARCHAR(50),
    id VARCHAR(20),
    FOREIGN KEY (id) REFERENCES member(id)
);

-- 동영상
CREATE TABLE video(
	video_code INT PRIMARY KEY AUTO_INCREMENT,
    video_url VARCHAR(100),
    video_img VARCHAR(100),
    video_title VARCHAR(80),
    video_count INT DEFAULT 0,
    video_date DATE DEFAULT (current_date),
    video_desc TEXT,
    channel_code INT,
    FOREIGN KEY (channel_code) REFERENCES channel(channel_code)
);
 
-- 댓글  
CREATE TABLE comment(
	comment_code INT PRIMARY KEY AUTO_INCREMENT,
    comment_text TEXT,
    comment_date DATE DEFAULT (current_date),
    id VARCHAR(20),
    video_code INT,
    parent_code INT,
    FOREIGN KEY (id) REFERENCES member(id),
    FOREIGN KEY (video_code) REFERENCES video(video_code)
);

-- 구독 
CREATE TABLE subscribe(
	sub_code INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(20),
    channel_code INT,
    FOREIGN KEY (id) REFERENCES member(id),
    FOREIGN KEY (channel_code) REFERENCES channel(channel_code)
);

-- 좋아요
CREATE TABLE video_like(
	like_code INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(20),
    video_code INT,
    FOREIGN KEY (id) REFERENCES member(id),
    FOREIGN KEY (video_code) REFERENCES video(video_code)
);

INSERT INTO member(id,password,email,phone)
VALUES('akmu','1234','akmu@gmail.com','010-0000-0000');
INSERT INTO channel(channel_img,channel_name,id)
VALUES('http://192.168.10.51:8082/channel/akmu.jpg','AKMU','akmu');
INSERT INTO video(video_url, video_img, video_title, video_desc, channel_code)
VALUES('http://192.168.10.51:8082/video/AKMU1.mp4','http://192.168.10.51:8082/thumbnail/akmu.webp','AKMU - 후라이의 꿈 LIVE CLIP(FESTIVAL ver.)','More about AKMU' ,'1');
select * from video;
JOIN channel USING (channel_code);
desc video;
delete From member;
select * from channel;




















