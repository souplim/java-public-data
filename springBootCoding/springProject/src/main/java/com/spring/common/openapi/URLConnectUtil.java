package com.spring.common.openapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.spring.openapi.data.vo.OpenApiDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class URLConnectUtil {
	public static StringBuffer openAPIData(OpenApiDTO api) throws Exception {
		// URL 클래스 -> 참조된 자원에 대해 입출력 스트림을 형성할 수 있음
		URL url = new URL(api.getSiteName());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		// 요청방식 선택(GET, POST)
		conn.setRequestMethod(api.getMethod());
		String accept = api.getAccept();
		// 서버 Response Data를 xml(application/xml), json(application/json) 형식의 타입으로 요청
		if(accept != null) 
			conn.setRequestProperty("Accept", accept);
		
		
		String contentType = api.getContentType();
		// 타입설정(application/xml) 형식으로 전송(RequestBody 전달시 application/xml로 서버에 전달)
		if(contentType != null)
			conn.setRequestProperty("Content-type", contentType);
		
		// 확인을 위한 응답코드 출력
		int resCode = conn.getResponseCode();
		log.info("응답코드 : " + resCode);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); // 읽어오기
		String inputLine;
		StringBuffer output = new StringBuffer();
		while((inputLine = in.readLine()) != null) // 한줄씩 읽어서
			output.append(inputLine); // 출력스트림에 추가
		
		return output;
	}
}
