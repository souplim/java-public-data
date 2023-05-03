package com.spring.client.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	// 컨트롤단 정상 처리 되는지 확인
	@ResponseBody
	@GetMapping("/home")
	public String home() {
		return "프로젝트 메인 확인";
	}
	
	// 화면에 보여지는지 확인
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("indexData","프로젝트 메인 화면 확인");
		return "index";
	}
}
