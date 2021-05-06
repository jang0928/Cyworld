package vo;

import java.util.Date;

public class BoardAndMembers {
	public int BOARD_NO;
	public String BOARD_TITLE;
	private int BOARD_LIKE;
	public String BOARD_CONTENT;
	public Date BOARD_DATE;
	private String BOARD_PICTURE;
	
	public String MEM_ID;
	private String MEM_PASS;
	public String MEM_NAME;
	private Date MEM_BIRTH;
	private String MEM_PNUMBER;
	private String MEM_EMAIL;
	private String MEM_ADDRESS;
	private Date MEM_SIGN_UP;
	private String GENDER;
	private String MEM_AUTH;
	
	
	public BoardAndMembers() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BoardAndMembers(int bOARD_NO, String mEM_ID, String mEM_NAME, String bOARD_TITLE, String bOARD_CONTENT, Date bOARD_DATE) {
		super();
		BOARD_NO = bOARD_NO;
		BOARD_TITLE = bOARD_TITLE;
		BOARD_CONTENT = bOARD_CONTENT;
		BOARD_DATE = bOARD_DATE;
		MEM_ID = mEM_ID;
		MEM_NAME = mEM_NAME;
	}


	public int getBOARD_NO() {
		return BOARD_NO;
	}


	public void setBOARD_NO(int bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}


	public String getBOARD_TITLE() {
		return BOARD_TITLE;
	}


	public void setBOARD_TITLE(String bOARD_TITLE) {
		BOARD_TITLE = bOARD_TITLE;
	}


	public int getBOARD_LIKE() {
		return BOARD_LIKE;
	}


	public void setBOARD_LIKE(int bOARD_LIKE) {
		BOARD_LIKE = bOARD_LIKE;
	}


	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}


	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}


	public Date getBOARD_DATE() {
		return BOARD_DATE;
	}


	public void setBOARD_DATE(Date bOARD_DATE) {
		BOARD_DATE = bOARD_DATE;
	}


	public String getBOARD_PICTURE() {
		return BOARD_PICTURE;
	}


	public void setBOARD_PICTURE(String bOARD_PICTURE) {
		BOARD_PICTURE = bOARD_PICTURE;
	}


	public String getMEM_ID() {
		return MEM_ID;
	}


	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}


	public String getMEM_PASS() {
		return MEM_PASS;
	}


	public void setMEM_PASS(String mEM_PASS) {
		MEM_PASS = mEM_PASS;
	}


	public String getMEM_NAME() {
		return MEM_NAME;
	}


	public void setMEM_NAME(String mEM_NAME) {
		MEM_NAME = mEM_NAME;
	}


	public Date getMEM_BIRTH() {
		return MEM_BIRTH;
	}


	public void setMEM_BIRTH(Date mEM_BIRTH) {
		MEM_BIRTH = mEM_BIRTH;
	}


	public String getMEM_PNUMBER() {
		return MEM_PNUMBER;
	}


	public void setMEM_PNUMBER(String mEM_PNUMBER) {
		MEM_PNUMBER = mEM_PNUMBER;
	}


	public String getMEM_EMAIL() {
		return MEM_EMAIL;
	}


	public void setMEM_EMAIL(String mEM_EMAIL) {
		MEM_EMAIL = mEM_EMAIL;
	}


	public String getMEM_ADDRESS() {
		return MEM_ADDRESS;
	}


	public void setMEM_ADDRESS(String mEM_ADDRESS) {
		MEM_ADDRESS = mEM_ADDRESS;
	}


	public Date getMEM_SIGN_UP() {
		return MEM_SIGN_UP;
	}


	public void setMEM_SIGN_UP(Date mEM_SIGN_UP) {
		MEM_SIGN_UP = mEM_SIGN_UP;
	}


	public String getGENDER() {
		return GENDER;
	}


	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}


	public String getMEM_AUTH() {
		return MEM_AUTH;
	}


	public void setMEM_AUTH(String mEM_AUTH) {
		MEM_AUTH = mEM_AUTH;
	}	
	
	
	
}
