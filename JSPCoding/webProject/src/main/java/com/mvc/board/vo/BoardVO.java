package com.mvc.board.vo;

public class BoardVO {
	private int num;
	private String author;
	private String title;
	private String content;
	private String date;
	private String passwd;
	
	public BoardVO() {}
	public BoardVO(int num, String author, String title, String content, String date, String passwd) {
		super();
		this.num = num;
		this.author = author;
		this.title = title;
		this.content = content;
		this.date = date;
		this.passwd = passwd;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", author=" + author + ", title=" + title + ", content=" + content + ", date="
				+ date + ", passwd=" + passwd + "]";
	}
}
