package com.spring.example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.example.domain.ExampleVO;

import lombok.extern.log4j.Log4j;

@RestController // @Controller + @ResponseBody : ������ ���۸��� �������� ��. view ��ȯ X
@RequestMapping("/example/*")
@Log4j
public class ExampleController {
	
	// ��û�ּ� : http://localhost:8080/example/getText
	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "�ȳ��ϼ���";
	}
	
	// ��û�ּ� : http://localhost:8080/example/getExample
	@GetMapping(value="/getExample", produces=MediaType.APPLICATION_XML_VALUE)
	public ExampleVO getSample() {
		return new ExampleVO(1,"ȫ�浿","010-123-4567");
	}
	
	// ��û�ּ� : http://localhost:8080/example/getExample2
	@GetMapping(value="/getExample2", produces=MediaType.APPLICATION_JSON_VALUE)
	public ExampleVO getSample2() {
		return new ExampleVO(2,"��ö��","010-123-4567");
	}
}
