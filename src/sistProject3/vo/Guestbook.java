package sistProject3.vo;

import java.util.Date;

public class Guestbook {
/*
 CREATE TABLE GUESTBOOK(
GBOOK_NO NUMBER CONSTRAINT PK_GUESTBOOK_GBOOK_NO PRIMARY KEY, -- pk
HOME_NO NUMBER,
CONSTRAINT FK_GUESTBOOK_HOME_NO FOREIGN KEY (HOME_NO) 
	REFERENCES MYHOME(HOME_NO) ON DELETE CASCADE, --fk
MEM_ID VARCHAR2(100),
CONSTRAINT FK_GUESTBOOK_MEM_ID FOREIGN KEY (MEM_ID) --fk
REFERENCES MEMBERS(MEM_ID ) ON DELETE CASCADE,
GB_CONTENT VARCHAR2(2000) NOT NULL,
GB_DATE DATE,
GB_CONSTRAINT VARCHAR2(10)NOT NULL
);


 */
	private int gbook_no;
	private int home_no;
	private String mem_id;
	private String gb_content;
	private Date gb_date;
	private String gb_constraint;
	public Guestbook() {
		super();
		// TODO Auto-generated constructor stub
	}
	//SELECT gbook_no,mem_id,gb_date,gb_content\r\n"
	public Guestbook(int gbook_no, String mem_id,  Date gb_date, String gb_content ,int home_no) {
		super();
		this.gbook_no = gbook_no;
		this.mem_id = mem_id;
		this.gb_date = gb_date;
		this.gb_content = gb_content;
		this.home_no = home_no;
	}
	public Guestbook(int gbook_no, int home_no, String mem_id, String gb_content, Date gb_date, String gb_constraint) {
		super();
		this.gbook_no = gbook_no;
		this.home_no = home_no;
		this.mem_id = mem_id;
		this.gb_content = gb_content;
		this.gb_date = gb_date;
		this.gb_constraint = gb_constraint;
	}
	
	public Guestbook(String mem_id, Date gb_date, String gb_content) {
		super();
		this.mem_id = mem_id;
		this.gb_content = gb_content;
		this.gb_date = gb_date;
	}
	public int getGbook_no() {
		return gbook_no;
	}
	public void setGbook_no(int gbook_no) {
		this.gbook_no = gbook_no;
	}
	public int getHome_no() {
		return home_no;
	}
	public void setHome_no(int home_no) {
		this.home_no = home_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getGb_content() {
		return gb_content;
	}
	public void setGb_content(String gb_content) {
		this.gb_content = gb_content;
	}
	public Date getGb_date() {
		return gb_date;
	}
	public void setGb_date(Date gb_date) {
		this.gb_date = gb_date;
	}
	public String getGb_constraint() {
		return gb_constraint;
	}
	public void setGb_constraint(String gb_constraint) {
		this.gb_constraint = gb_constraint;
	}
	
}
