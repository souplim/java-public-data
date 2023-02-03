package com.mvc.board.vo;

public class BoardVO {
	private int num;			// 글 번호
	private String author;		// 글 작성자
	private String title;		// 글제목
	private String content;		// 글내용
	private int readcnt;		// 글 조회수
	private String writeday;	// 글 작성일
	private int repRoot;		// 답변글 작성 시 사용(원래글의 번호 참조)
	private int repStep;		// 답변글 작성 시 사용(답변글의 들여쓰기 지정)
	private int repIndent;		// 답변글 작성 시 사용(답변글의 순서 지정)
	private String passwd;		// 비밀번호
	private int rCount;			// 댓글 개수
	
	// 조건검색시 사용할 속성
	private String search = "";	// 기본값을 null이 아니라 ""(빈문자)로 제어. 검색 대상
	private String keyword = "";// 검색어
	
	public BoardVO() {}
	public BoardVO(int num, String author, String title, String content, int readcnt, String writeday, int repRoot,
			int repStep, int repIndent) {
		super();
		this.num = num;
		this.author = author;
		this.title = title;
		this.content = content;
		this.readcnt = readcnt;
		this.writeday = writeday;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
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
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public int getRepRoot() {
		return repRoot;
	}
	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}
	public int getRepStep() {
		return repStep;
	}
	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}
	public int getRepIndent() {
		return repIndent;
	}
	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getrCount() {
		return rCount;
	}
	public void setrCount(int rCount) {
		this.rCount = rCount;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", author=" + author + ", title=" + title + ", content=" + content + ", readcnt="
				+ readcnt + ", writeday=" + writeday + ", repRoot=" + repRoot + ", repStep=" + repStep + ", repIndent="
				+ repIndent + ", passwd=" + passwd + ", rCount=" + rCount + ", search=" + search + ", keyword="
				+ keyword + "]";
	}
}