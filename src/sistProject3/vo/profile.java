package sistProject3.vo;

public class profile {
	/*
CREATE TABLE members (
 MEM_ID VARCHAR2(100) CONSTRAINT PK_MEMBERS_MEM_ID PRIMARY KEY,
 MEM_PASS VARCHAR2(50) NOT NULL,
 MEM_NAME VARCHAR2(50) NOT NULL,
 MEM_BIRTH DATE,
 MEM_PNUMBER VARCHAR2(50) NOT NULL,
 MEM_EMAIL VARCHAR2(100) NOT NULL,
 MEM_ADDRESS VARCHAR2(100) ,
 MEM_SIGN_UP DATE,
 GENDER VARCHAR2(10),
 MEM_AUTH VARCHAR(10)
);
	 */
	private String mem_id;
	private int home_no;
	private String mem_name;
	private String mem_pnumber;
	private String mem_email;
	public profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public profile(String mem_name, String mem_pnumber, String mem_email) {
		super();
		this.mem_name = mem_name;
		this.mem_pnumber = mem_pnumber;
		this.mem_email = mem_email;
	}


	public profile(String mem_id, int home_no, String mem_name, String mem_pnumber, String mem_email) {
		super();
		this.mem_id = mem_id;
		this.home_no = home_no;
		this.mem_name = mem_name;
		this.mem_pnumber = mem_pnumber;
		this.mem_email = mem_email;
	}


	public String getMem_id() {
		return mem_id;
	}


	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	public int getHome_no() {
		return home_no;
	}


	public void setHome_no(int home_no) {
		this.home_no = home_no;
	}


	public String getMem_name() {
		return mem_name;
	}


	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}


	public String getMem_pnumber() {
		return mem_pnumber;
	}


	public void setMem_pnumber(String mem_pnumber) {
		this.mem_pnumber = mem_pnumber;
	}


	public String getMem_email() {
		return mem_email;
	}


	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}


	
}
