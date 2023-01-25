package com.member;

import java.sql.Timestamp;

public class MemberVO {
	private String m_id;
	private String m_passwd;
	private String m_name;
	private String m_email;
	private Timestamp reg_date;
	
	public MemberVO(){}
	public MemberVO(String m_id, String m_passwd, String m_name, String m_email, Timestamp reg_date) {
		super();
		this.m_id = m_id;
		this.m_passwd = m_passwd;
		this.m_name = m_name;
		this.m_email = m_email;
		this.reg_date = reg_date;
	}
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_passwd() {
		return m_passwd;
	}
	public void setM_passwd(String m_passwd) {
		this.m_passwd = m_passwd;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "MemberVO [m_id=" + m_id + ", m_passwd=" + m_passwd + ", m_name=" + m_name + ", m_email=" + m_email
				+ ", reg_date=" + reg_date + "]";
	}
}
