package sistProject3.vo;
//vo.Comments

import java.util.Date;

public class Bcomments {
	private int com_no;
	private int gbook_no;
	private String mem_id;
	private String com_content;
	private Date com_date;
	// Memebers 테이블 컬럼
	private String mem_name;

	public Bcomments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	// 댓글 조회
	public Bcomments(String com_content, Date com_date, String mem_name) {
		super();
		this.com_content = com_content;
		this.com_date = com_date;
		this.mem_name = mem_name;
	}

	// 게시글 댓글 등록
	public Bcomments(int com_no,int gbook_no, String mem_id, String com_content, Date com_date) {
		super();
		this.com_no = com_no;
		this.gbook_no = gbook_no;
		this.mem_id = mem_id;
		this.com_content = com_content;
		this.com_date = com_date;
	}

	public int getCom_no() {
		return com_no;
	}

	public void setCom_no(int com_no) {
		this.com_no = com_no;
	}

	public int getGbook_no() {
		return gbook_no;
	}

	public void setGbook_no(int gbook_no) {
		this.gbook_no = gbook_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getCom_content() {
		return com_content;
	}

	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}

	public Date getCom_date() {
		return com_date;
	}

	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
}
