package sistProject3.vo;

import java.util.Date;

public class Board {
	private int board_no;
	private String mem_id;
	private String board_title;
	private int board_like;
	private String board_content;
	private Date board_date;
	private String board_picture;
	// Memebers 테이블 컬럼
	private String mem_name;
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(String board_title, int board_like, String board_content, Date board_date, String mem_name, String board_picture) {
		super();
		this.board_title = board_title;
		this.board_like = board_like;
		this.board_content = board_content;
		this.board_date = board_date;
		this.mem_name = mem_name;
		this.board_picture = board_picture;
	}

	public Board(String mem_id) {
		super();
		this.mem_id = mem_id;
	}

	// 상세 게시글 페이징 처리 생성자
	public Board(int board_no, String board_title, Date board_date) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_date = board_date;
	}
	
	// 사진 게시글 페이징 처리
	public Board(int board_no, String board_picture) {
		super();
		this.board_no = board_no;
		this.board_picture = board_picture;
	}
	
	// 게시글 등록
	public Board(int board_no, String mem_id, String board_title, int board_like, String board_content, Date board_date,
			String board_picture) {
		super();
		this.board_no = board_no;
		this.mem_id = mem_id;
		this.board_title = board_title;
		this.board_like = board_like;
		this.board_content = board_content;
		this.board_date = board_date;
		this.board_picture = board_picture;
	}


	public int getBoard_no() {
		return board_no;
	}


	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public int getBoard_like() {
		return board_like;
	}

	public void setBoard_like(int board_like) {
		this.board_like = board_like;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}



	public String getBoard_picture() {
		return board_picture;
	}

	public void setBoard_picture(String board_picture) {
		this.board_picture = board_picture;
	}
}
