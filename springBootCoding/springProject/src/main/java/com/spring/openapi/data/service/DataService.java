package com.spring.openapi.data.service;

public interface DataService {
	public StringBuffer chungnamList() throws Exception; // 네트워크 -> 입출력 -> 예외처리 필요. 상위로 위임

	public StringBuffer chungnamDetail(String mgn_no) throws Exception;

	public StringBuffer animalDaejeonList() throws Exception;
}
