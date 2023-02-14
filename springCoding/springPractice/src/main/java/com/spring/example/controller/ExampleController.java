package com.spring.example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.example.domain.ExampleVO;

import lombok.extern.log4j.Log4j;

@RestController // @Controller + @ResponseBody : 데이터 전송만을 목적으로 함. view 반환 X
@RequestMapping("/example/*")
@Log4j
public class ExampleController {
	
	// 요청주소 : http://localhost:8080/example/getText
	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	// 요청주소 : http://localhost:8080/example/getExample
	@GetMapping(value="/getExample", produces=MediaType.APPLICATION_XML_VALUE)
	public ExampleVO getSample() {
		return new ExampleVO(1,"홍길동","010-123-4567");
	}
	
	// 요청주소 : http://localhost:8080/example/getExample2
	@GetMapping(value="/getExample2", produces=MediaType.APPLICATION_JSON_VALUE)
	public ExampleVO getSample2() {
		return new ExampleVO(2,"김철수","010-123-4567");
	}
}
