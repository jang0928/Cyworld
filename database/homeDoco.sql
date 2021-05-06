--배경 테이블
DROP TABLE BG; --배경 테이블 삭제

CREATE TABLE BG(
BG_NO NUMBER CONSTRAINT PK_BG_BG_NO PRIMARY KEY,
BG_NAME VARCHAR2(100),
BG_URL VARCHAR2(1000)
);

SELECT * FROM BG;

CREATE SEQUENCE BG_NO_SEQ START WITH 1
MINVALUE 1 MAXVALUE 9999 CYCLE;

DROP SEQUENCE BG_NO_SEQ; --시퀀스 삭제

INSERT INTO BG VALUES (
BG_NO_SEQ.NEXTVAL,
'따뜻한 하양(단색)',
'https://wallpaperaccess.com/full/1556608.jpg'
);

INSERT INTO BG VALUES (
BG_NO_SEQ.NEXTVAL,
'라일락(단색)',
'https://www.publicdomainpictures.net/pictures/200000/velka/plain-lilac-background.jpg'
);

INSERT INTO BG VALUES (
BG_NO_SEQ.NEXTVAL,
'청록 바다',
'https://wallpapercave.com/wp/wp4732652.jpg'
);

INSERT INTO BG VALUES (
BG_NO_SEQ.NEXTVAL,
'민트(단색)',
'https://cdn.hipwallpaper.com/m/10/24/brvL8i.jpg'
);

INSERT INTO BG VALUES (
BG_NO_SEQ.NEXTVAL,
'인디고(단색)',
'https://wallpapercave.com/wp/wp1960352.jpg'
);

INSERT INTO BG VALUES (
BG_NO_SEQ.NEXTVAL,
'보라에서 하늘',
'https://wallpapercave.com/wp/wp4732652.jpg'
);



--폰트 테이블
DROP TABLE FONT;

CREATE TABLE FONT(
FONT_NO NUMBER CONSTRAINT PK_FONT_FONT_NO PRIMARY KEY,
FONT_NAME VARCHAR2(50),
FONT_URL VARCHAR2(2000),
FONT_FAMILY VARCHAR2(1000)
);

SELECT * FROM FONT;

CREATE SEQUENCE FONT_NO_SEQ START WITH 1
MINVALUE 1 MAXVALUE 9999 CYCLE;

DROP SEQUENCE FONT_NO_SEQ; --시퀀스 삭제

INSERT INTO FONT VALUES(
FONT_NO_SEQ.NEXTVAL,
'나눔 손글씨 펜',
'https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap',
CHR(39)||'Nanum Pen Script'||CHR(39)||', cursive'
);

INSERT INTO FONT VALUES(
FONT_NO_SEQ.NEXTVAL,
'개구쟁이',
'https://fonts.googleapis.com/css2?family=Gaegu&display=swap',
CHR(39)||'Gaegu'||CHR(39)||', cursive'
);

INSERT INTO FONT VALUES(
FONT_NO_SEQ.NEXTVAL,
'나눔 명조',
'https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap',
CHR(39)||'Nanum Myeongjo'||CHR(39)||', serif'
);



--홈피 테이블
CREATE TABLE MYHOME(
HOME_NO NUMBER CONSTRAINT PK_MYHOME_HOME_NO PRIMARY KEY,
MEM_ID VARCHAR2(100),
CONSTRAINT FK_MYHOME_MEM_ID FOREIGN KEY (MEM_ID)
REFERENCES MEMBERS(MEM_ID) ON DELETE CASCADE,	
STATUS_MESSAGE VARCHAR2(500),
PROFILE_PHOTO VARCHAR2(1000),
INTORODUCE VARCHAR2(1000),
BG_NO NUMBER,
 CONSTRAINT FK_MYHOME_BG_NO FOREIGN KEY (BG_NO)
REFERENCES BG(BG_NO) ON DELETE CASCADE,
FONT_NO NUMBER,
 CONSTRAINT FK_MYHOME_FONT_NO FOREIGN KEY (FONT_NO)
REFERENCES FONT(FONT_NO) ON DELETE CASCADE,		
TODAY NUMBER,
TOTAL NUMBER,
HOME_CONSTRAINTS VARCHAR2(10) NOT NULL
);
--질문)TODAT? TODAY 오타 수정 ==> TODAY 


create sequence MYHOME_NO_SEQ start with 1
minvalue 1 maxvalue 1000000 CYCLE;  

DROP SEQUENCE MYHOME_NO_SEQ; --시퀀스 삭제

SELECT * FROM MYHOME;

INSERT INTO  MYHOME values(MYHOME_NO_SEQ.nextval,'HIMAN','나는 오늘 눈물을 흘린다','KAKAO.FFACE','저는 개를 좋아해요',1,1,1,10,'Y');

INSERT INTO  MYHOME values(MYHOME_NO_SEQ.nextval,'HIGIRL','여행가고싶다','UR.0205650.JAG','저는 20대입니당 ',2,2,10,100,'Y');

INSERT INTO  MYHOME values(MYHOME_NO_SEQ.nextval,'SIST01','울 수 있다는건 행복한거야','AKSJD_0202.PNG','연락안해요',3,3,2000,50000,'Y');

INSERT INTO  MYHOME values(MYHOME_NO_SEQ.nextval,'STAFF','배고프다','KAKAO.FFACE','밥사줄사람 선착순 1명',4,1,500,2300,'Y');

INSERT INTO  MYHOME values(MYHOME_NO_SEQ.nextval,'DOOBOO','강아지..좋아하세요 ?','DOG_FACE.JPG','알알알알',5,3,3020,9000,'Y');

INSERT INTO  MYHOME values(MYHOME_NO_SEQ.nextval,'GOODMAN','나는 오늘 눈물을 흘린다','KAKAO.FFACE','저는 개를 좋아해요',6,2,1,10,'Y');