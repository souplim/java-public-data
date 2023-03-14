package com.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*************************************************************************
 * 리소스 등록 및 핸들러를 관리하는 객체인 ResourceHandlerRegistry를 통해 리소스의 위치와 리소스와 매칭될 url을 설정
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	private String connectPath = "/uploadStorage/**";
	/***************************************************
	 * 경로 설정시
	 * 경로의 마지막은 반드시 "/"로 끝나야 한다.
	 * 로컬 디스크 경로일 경우 file:/// 접두어를 명시해 두어야 한다.
	 */
	private String resourcePath = "file:///C:\\uploadStorage\\";
	
	/***************************************************
	 * addResourceHandler : 리소스와 연결될 URL path를 지정
	 * addResourceLocations : 실제 리소스가 존재하는 외부 경로를 지정
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(connectPath)
				.addResourceLocations(resourcePath);
	}
	
}
