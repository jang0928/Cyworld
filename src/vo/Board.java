package vo;

import java.util.Date;

public class Board {
	private int BOARD_NO;
	private String MEM_ID;
	private String BOARD_TITLE;
	private int BOARD_LIKE;
	private String BOARD_CONTENT;
	private Date BOARD_DATE;
	private String BOARD_PICTURE;
	
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Board(int bOARD_NO, String mEM_ID, String bOARD_TITLE, int bOARD_LIKE, String bOARD_CONTENT, Date bOARD_DATE,
			String bOARD_PICTURE) {
		super();
		BOARD_NO = bOARD_NO;
		MEM_ID = mEM_ID;
		BOARD_TITLE = bOARD_TITLE;
		BOARD_LIKE = bOARD_LIKE;
		BOARD_CONTENT = bOARD_CONTENT;
		BOARD_DATE = bOARD_DATE;
		BOARD_PICTURE = bOARD_PICTURE;
	}


	public int getBOARD_NO() {
		return BOARD_NO;
	}


	public void setBOARD_NO(int bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}


	public String getMEM_ID() {
		return MEM_ID;
	}


	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
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



}
