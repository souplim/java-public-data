package com.spring.client.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.client.example.domain.ExampleDTO;
import com.spring.client.example.domain.Grade;
import com.spring.client.example.domain.StudentDTO;

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
	
	/* 학생 정보를 입력받을 form 제어 */
	@GetMapping("/studentForm")
	public String studentForm(Model model, @ModelAttribute StudentDTO student) {
		model.addAttribute("grades", Grade.values());
		
		Map<Integer, String> clubs = new LinkedHashMap<>();
		clubs.put(1, "중앙 동아리");
		clubs.put(2, "과 동아리");
		clubs.put(3, "연합 동아리");
		clubs.put(4, "과 학생회");
		clubs.put(5, "총 학생회");
		model.addAttribute("clubs", clubs);
		
		List<String> majors = new ArrayList<>();
		majors.add("컴퓨터공학부");
		majors.add("기계공학부");
		majors.add("전자전기공학부");
		model.addAttribute("majors", majors);
		
		return "client/example/studentForm";
	}
	
	/* 학생 정보를 입력받아 보여주는 부분 */
	@PostMapping("/studentView")
	public String studentView(Model model, @ModelAttribute StudentDTO student) {
		System.out.println(student);
		return "client/example/studentView";
	}
}
