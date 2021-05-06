CREATE TABLE GUESTBOOK(
GBOOK_NO NUMBER CONSTRAINT PK_GUESTBOOK_GBOOK_NO PRIMARY KEY,
HOME_NO NUMBER,
CONSTRAINT FK_GUESTBOOK_HOME_NO FOREIGN KEY (HOME_NO)
	REFERENCES MYHOME(HOME_NO) ON DELETE CASCADE,
MEM_ID VARCHAR2(100),
CONSTRAINT FK_GUESTBOOK_MEM_ID FOREIGN KEY (MEM_ID)
REFERENCES MEMBERS(MEM_ID ) ON DELETE CASCADE,
GB_CONTENT VARCHAR2(2000) NOT NULL,
GB_DATE DATE,
GB_CONSTRAINT VARCHAR2(10)NOT NULL
);


--시퀀스 생성
create sequence GUESTBOOK_NO_SEQ start with 1
minvalue 1 maxvalue 1000000 CYCLE; 

drop sequence GUESTBOOK_NO_SEQ ;--- 시퀀스 삭제

-- 방명록 정렬 조회 
SELECT gbook_no,mem_id,gb_date,gb_content,home_no,GB_CONSTRAINT
						FROM guestbook
						WHERE home_no =1
					 ORDER BY GBOOK_NO DESC;

-- 그냥 조회
SELECT * FROM GUESTBOOK ;					
					
-- 방명록 등록 					
INSERT INTO GUESTBOOK select
	GUESTBOOK_NO_SEQ.NEXTVAL,h.home_no,m.mem_id,'오랜만에 들렸어~',
	 sysdate,'Y' 
	 FROM MYHOME h, members m
	 WHERE h.HOME_NO =1 AND m.MEM_ID ='HIGIRL';			

INSERT INTO GUESTBOOK select
	GUESTBOOK_NO_SEQ.NEXTVAL,h.home_no,m.mem_id,'방명록 남기고 갑니다.',
	 sysdate,'N' 
	 FROM MYHOME h, members m
	 WHERE h.HOME_NO =1 AND m.MEM_ID ='DOOBOO';		

INSERT INTO GUESTBOOK select
	GUESTBOOK_NO_SEQ.NEXTVAL,h.home_no,m.mem_id,'일주일 뒤에 강남에서 만나자! 연락할게~!!ㅎㅎ',
	 sysdate,'Y' 
	 FROM MYHOME h, members m
	 WHERE h.HOME_NO =1 AND m.MEM_ID ='STAFF';		

INSERT INTO GUESTBOOK select
	GUESTBOOK_NO_SEQ.NEXTVAL,h.home_no,m.mem_id,'공부한다며? 할만해?? 생각나서 홈피들렸어',
	 sysdate,'Y' 
	 FROM MYHOME h, members m
	 WHERE h.HOME_NO =1 AND m.MEM_ID ='MASTER';		
	
	
