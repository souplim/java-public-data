package com.spring.openapi.data.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.spring.common.openapi.URLConnectUtil;
import com.spring.openapi.data.vo.OpenApiDTO;

@Service
public class DataServiceImpl implements DataService {
	
	@Override
	public StringBuffer chungnamList() throws Exception {
		//오픈 api : "https://tour.chungnam.go.kr/_prog/openapi/?func=tour&start=1&end=10";
		
		// 전달해주어야 하는 파라미터
		StringBuffer site = new StringBuffer("https://tour.chungnam.go.kr/_prog/openapi/");
		site.append("?"+URLEncoder.encode("func","UTF-8")+"="+URLEncoder.encode("tour","UTF-8"));
		site.append("&"+URLEncoder.encode("start","UTF-8")+"="+URLEncoder.encode("1","UTF-8"));
		site.append("&"+URLEncoder.encode("end","UTF-8")+"="+URLEncoder.encode("10","UTF-8"));
		
		// URL 클래스 -> 참조된 자원에 대해 입출력 스트림을 형성할 수 있음
		URL url = new URL(site.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		/*
		// 요청방식 선택(GET, POST)
		conn.setRequestMethod("GET");
		// 서버 Response Data를 xml(application/xml), json(application/json) 형식의 타입으로 요청
		conn.setRequestProperty("Accept","application/xml");
		// 타입설정(application/xml) 형식으로 전송(Request Body 전달시 application/xml로 서버에 전달)
		// conn.setRequestProperty("Content-type","application/xml");
		
		int resCode = conn.getResponseCode();
		System.out.println("응답코드 : " + resCode); // 콘솔에 출력해서 확인
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer output = new StringBuffer();
		while((inputLine = in.readLine()) != null) { // 한줄씩 읽어서
			output.append(inputLine); // 출력스트림에 추가
		}
		return output;
		*/
		
		// 위 코드 클래스의 메서드로 분리하기
		OpenApiDTO openApi = new OpenApiDTO(site.toString(), "GET", "application/xml", null);
		StringBuffer result = URLConnectUtil.openAPIData(openApi);
		return result;
	}

	@Override
	public StringBuffer chungnamDetail(int mng_no) throws Exception {
		// 전달해주어야 하는 파라미터
		StringBuffer site = new StringBuffer("https://tour.chungnam.go.kr/_prog/openapi/");
		site.append("?"+URLEncoder.encode("func","UTF-8")+"="+URLEncoder.encode("tour","UTF-8"));
		site.append("&"+URLEncoder.encode("mode","UTF-8")+"="+URLEncoder.encode("V","UTF-8"));
		site.append("&"+URLEncoder.encode("mng_no","UTF-8")+"="+URLEncoder.encode(mng_no+"","UTF-8"));
		
		// URL 클래스 -> 참조된 자원에 대해 입출력 스트림을 형성할 수 있음
		URL url = new URL(site.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		OpenApiDTO openApi = new OpenApiDTO(site.toString(), "GET", "application/xml", null);
		StringBuffer result = URLConnectUtil.openAPIData(openApi);
		return result;
	}
}
