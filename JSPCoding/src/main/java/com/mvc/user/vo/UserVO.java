package com.mvc.user.vo;

public class UserVO {
	private String u_id; // 아이디
	private String u_pw; // 비밀번호
	private int u_st; // 가입상태(가입:0 미가입:1)
	private String u_name; // 이름
	private String u_email; // 이메일
	private String u_phone; // 전화번호
	private String u_gender; // 성별
	private String u_regday; // 등록일
	
	
	public UserVO() {}
	public UserVO(String u_id, String u_pw, int u_st, String u_name, String u_phone, String u_gender,
			String u_regday) {
		this(u_id, u_pw, u_st, u_name, null, u_phone, u_gender, u_regday);
	}
	public UserVO(String u_id, String u_pw, int u_st, String u_name, String u_email, String u_phone, String u_gender,
			String u_regday) {
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_st = u_st;
		this.u_name = u_name;
		this.u_email = u_email;
		this.u_phone = u_phone;
		this.u_gender = u_gender;
		this.u_regday = u_regday;
	}
	
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public int getU_st() {
		return u_st;
	}
	public void setU_st(int u_st) {
		this.u_st = u_st;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	public String getU_regday() {
		return u_regday;
	}
	public void setU_regday(String u_regday) {
		this.u_regday = u_regday;
	}

	@Override
	public String toString() {
		return "UserVO [u_id=" + u_id + ", u_pw=" + u_pw+ ", u_st=" + u_st + ", u_name=" + u_name + ", u_email=" + u_email + ", u_phone="
				+ u_phone + ", u_gender=" + u_gender + ", u_regday=" + u_regday  + "]";
	}
}
