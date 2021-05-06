package sistProject3.vo;

import java.util.Date;

public class Myhome {
 private int home_no;
 private String mem_id;
 private String status_message;
 private String profile_photo;
 private String introduce;
 private int bg_no;
 private int font_no;
 public Myhome(String status_message, String profile_photo) {
	super();
	this.status_message = status_message;
	this.profile_photo = profile_photo;
}
 public Myhome(int home_no, String status_message, String profile_photo, int today, int total) {
	super();
	this.home_no = home_no;
	this.status_message = status_message;
	this.profile_photo = profile_photo;
	this.today = today;
	this.total = total;
}
public Myhome(String status_message, String profile_photo, int today, int total) {
	super();
	this.status_message = status_message;
	this.profile_photo = profile_photo;
	this.today = today;
	this.total = total;
}
public Myhome() {
	super();
	
	// TODO Auto-generated constructor stub
}
public Myhome(int home_no, String mem_id, String status_message, String profile_photo, String introduce, int bg_no,
		int font_no, int today, int total, String home_constraints) {
	super();
	this.home_no = home_no;
	this.mem_id = mem_id;
	this.status_message = status_message;
	this.profile_photo = profile_photo;
	this.introduce = introduce;
	this.bg_no = bg_no;
	this.font_no = font_no;
	this.today = today;
	this.total = total;
	this.home_constraints = home_constraints;
}
private int today;
 private int total;
 private String home_constraints ;
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
public String getStatus_message() {
	return status_message;
}
public void setStatus_message(String status_message) {
	this.status_message = status_message;
}
public String getProfile_photo() {
	return profile_photo;
}
public void setProfile_photo(String profile_photo) {
	this.profile_photo = profile_photo;
}
public String getIntroduce() {
	return introduce;
}
public void setIntroduce(String introduce) {
	this.introduce = introduce;
}
public int getBg_no() {
	return bg_no;
}
public void setBg_no(int bg_no) {
	this.bg_no = bg_no;
}
public int getFont_no() {
	return font_no;
}
public void setFont_no(int font_no) {
	this.font_no = font_no;
}
public int getToday() {
	return today;
}
public void setToday(int today) {
	this.today = today;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public String getHome_constraints() {
	return home_constraints;
}
public void setHome_constraints(String home_constraints) {
	this.home_constraints = home_constraints;
}
}
