package sistProject3.vo;
//MEM_ID VARCHAR2(100) CONSTRAINT PK_MEMBERS_MEM_ID PRIMARY KEY,
//MEM_PASS VARCHAR2(50) NOT NULL,
//MEM_NAME VARCHAR2(50) NOT NULL,
//MEM_BIRTH DATE,
//MEM_PNUMBER VARCHAR2(50) NOT NULL,
//MEM_EMAIL VARCHAR2(100) NOT NULL,
//MEM_ADDRESS VARCHAR2(100) ,
//MEM_SIGN_UP DATE,
//GENDER VARCHAR2(10),
//MEM_AUTH VARCHAR(10)

import java.util.Date;

public class Members1 {
	private String mem_id;
	private String mem_pass;
	private String mem_name;
	private Date mem_birth;
	private String mem_birth2;   // 생일 입력	
	private String mem_pnumber;
	private String mem_email;
	private String mem_address;
	private Date mem_sign_up;
	private String gender;
	// erd의 친구(follow)테이블
	private String following_id;
	
	
	public Members1(String mem_id, String mem_pass, String mem_name, Date mem_birth, String mem_pnumber, String mem_email,
			String mem_address, Date mem_sign_up, String gender, String mem_auth) {
		super();
		this.mem_id = mem_id;
		this.mem_pass = mem_pass;
		this.mem_name = mem_name;
		this.mem_birth = mem_birth;
		this.mem_pnumber = mem_pnumber;
		this.mem_email = mem_email;
		this.mem_address = mem_address;
		this.mem_sign_up = mem_sign_up;
		this.gender = gender;
		this.mem_auth = mem_auth;
	}

	// 등록 처리
	public Members1(String mem_id, String mem_pass, String mem_name, String mem_birth2, String mem_pnumber,
			String mem_email, String mem_address, String gender) {
		super();
		this.mem_id = mem_id;
		this.mem_pass = mem_pass;
		this.mem_name = mem_name;
		this.mem_birth2 = mem_birth2;
		this.mem_pnumber = mem_pnumber;
		this.mem_email = mem_email;
		this.mem_address = mem_address;
		this.gender = gender;
	}	
		
	public Members1(String mem_name, String mem_id, String mem_email, String following_id) {
		super();
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_email = mem_email;
		this.following_id = following_id;
	}
	
	public Members1(String mem_name, String mem_id, String mem_email) {
		super();
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_email = mem_email;
	}	
	
	// 아이디 찾기
	public Members1(String mem_id) {
		super();
		this.mem_id = mem_id;
	}
	
	// 로그인
	public Members1(String mem_id, String mem_pass) {
		super();
		this.mem_id = mem_id;
		this.mem_pass = mem_pass;
	}	
	
	public Members1() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String mem_auth;
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}

	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}public Date getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
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
	public String getMem_address() {
		return mem_address;
	}
	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}
	public Date getMem_sign_up() {
		return mem_sign_up;
	}
	public void setMem_sign_up(Date mem_sign_up) {
		this.mem_sign_up = mem_sign_up;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMem_auth() {
		return mem_auth;
	}
	public void setMem_auth(String mem_auth) {
		this.mem_auth = mem_auth;
	}
	public String getFollowing_id() {
		return following_id;
	}
	public void setFollowing_id(String following_id) {
		this.following_id = following_id;
	}

	public String getMem_birth2() {
		return mem_birth2;
	}

	public void setMem_birth2(String mem_birth2) {
		this.mem_birth2 = mem_birth2;
	} 
	
}
