package com.spring.client.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.client.example.domain.ExampleDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/example")
@Slf4j
public class ExampleController {

	@GetMapping("/test")
	public String test(Model model) {
		log.info("test() 메서드 확인");
		
		model.addAttribute("data1","뷰에 출력할 데이터");
		model.addAttribute("data2","뷰에 출력할 <strong>데이터</string>");
		model.addAttribute("nullData", null);
		model.addAttribute("data", "Spring!");
		
		model.addAttribute("number", 6);
		
		model.addAttribute("division","admin");
		
		ExampleDTO exampleDTO = new ExampleDTO();
		exampleDTO.setName("홍길동");
		exampleDTO.setAge(38);
		exampleDTO.setEmail("javauser@naver.com");
		model.addAttribute("exampleDTO", exampleDTO);
		
		List<ExampleDTO> list = new ArrayList<>();
		list.add(new ExampleDTO("김철수", 26, "springuser@naver.com"));
		list.add(new ExampleDTO("한늘봄", 32, "jsp1234@gmail.com"));
		model.addAttribute("list", list);
		
		Map<Integer, ExampleDTO> map = new HashMap<>();
		map.put(1, new ExampleDTO("김미숙", 30, "javauser@naver.com"));
		map.put(2, new ExampleDTO("조한미", 23, "bootuser@naver.com"));
		model.addAttribute("map", map);
		
		model.addAttribute("localDateTime", LocalDateTime.now());
		
		return "client/example/test";
	}
	
	@GetMapping("/exam01")
	public String exam01(Model model, @ModelAttribute("param1") String param1, @ModelAttribute("param1") String param2) {
		
		return "client/example/exam01";
	}
}
