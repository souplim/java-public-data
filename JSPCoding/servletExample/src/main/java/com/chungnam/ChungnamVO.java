package com.chungnam;

/* VO(Value Object)클래스는 데이터를 담는 컨테이너 역할을 하는 클래스로 데이터 전달을 목적으로 만들어진 클래스이다. 
 * VO클래스는 어플리케이션 구조에서 각 단계의 입출력 정보를 전달하는 역할을 수행하며, 
 * 속성(attribute: 필드), setter(설정자)와 getter(접근자)로 구성된다. 
 * 이때 클래스명은 보통 테이블+VO를 연결하여 명시하고, 필드는 테이블의 컬럼명과 동일하게 명시한다. */
public class ChungnamVO {
	private int mng_no;
	private String local_nm;
	private String type;
	private String nm;
	private String nm_sub;
	private String addr;
	private double lat;
	private double lng;
	private String description;
	private String list_img;
	private String regDate;
	
	public ChungnamVO() { }
	
	public ChungnamVO(int mng_no, String local_nm, String type, String nm, String nm_sub, String addr, double lat,
			double lng, String description, String list_img, String regDate) {
		super();
		this.mng_no = mng_no;
		this.local_nm = local_nm;
		this.type = type;
		this.nm = nm;
		this.nm_sub = nm_sub;
		this.addr = addr;
		this.lat = lat;
		this.lng = lng;
		this.description = description;
		this.list_img = list_img;
		this.regDate = regDate;
	}

	public int getMng_no() {return mng_no;}
	public void setMng_no(int mng_no) {this.mng_no = mng_no;}
	public String getLocal_nm() {return local_nm;}
	public void setLocal_nm(String local_nm) {this.local_nm = local_nm;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public String getNm() {return nm;}
	public void setNm(String nm) {this.nm = nm;}
	public String getNm_sub() {return nm_sub;}
	public void setNm_sub(String nm_sub) {this.nm_sub = nm_sub;}
	public String getAddr() {return addr;}
	public void setAddr(String addr) {this.addr = addr;}
	public double getLat() {return lat;}
	public void setLat(double lat) {this.lat = lat;}
	public double getLng() {return lng;}
	public void setLng(double lng) {this.lng = lng;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public String getList_img() {return list_img;}
	public void setList_img(String list_img) {this.list_img = list_img;}
	public String getRegDate() {return regDate;}
	public void setRegDate(String regDate) {this.regDate = regDate;}

	@Override
	public String toString() {
		return "ChungnamVO [mng_no=" + mng_no + ", local_nm=" + local_nm + ", type=" + type + ", nm=" + nm + ", nm_sub="
				+ nm_sub + ", addr=" + addr + ", lat=" + lat + ", lng=" + lng + ", description=" + description
				+ ", list_img=" + list_img + ", regDate=" + regDate + "]";
	}
}
