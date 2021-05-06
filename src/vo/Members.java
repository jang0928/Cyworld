package vo;

import java.util.Date;

public class Members {
	private String MEM_ID;
	private String MEM_PASS;
	private String MEM_NAME;
	private Date MEM_BIRTH;
	private String MEM_PNUMBER;
	private String MEM_EMAIL;
	private String MEM_ADDRESS;
	private Date MEM_SIGN_UP;
	private String GENDER;
	private String MEM_AUTH;
	
	public Members() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Members(String mEM_ID, String mEM_PASS, String mEM_NAME, Date mEM_BIRTH, String mEM_PNUMBER,
			String mEM_EMAIL, String mEM_ADDRESS, Date mEM_SIGN_UP, String gENDER, String mEM_AUTH) {
		super();
		MEM_ID = mEM_ID;
		MEM_PASS = mEM_PASS;
		MEM_NAME = mEM_NAME;
		MEM_BIRTH = mEM_BIRTH;
		MEM_PNUMBER = mEM_PNUMBER;
		MEM_EMAIL = mEM_EMAIL;
		MEM_ADDRESS = mEM_ADDRESS;
		MEM_SIGN_UP = mEM_SIGN_UP;
		GENDER = gENDER;
		MEM_AUTH = mEM_AUTH;
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
