package com.boot.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.example.domain.SubjectVO;
import com.boot.example.service.SubjectService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/subject/*")
@Slf4j
public class SubjectController {
	
	@Setter(onMethod_ = @Autowired)
	private SubjectService subjectService;
	
	// 요청주소 : http://localhost:8080/subject/subjectList
	@RequestMapping(value="/subjectList", method=RequestMethod.GET)
	public String subjectList(Model model) {
		log.info("subjectList() 메서드 호출...."); // 메서드 호출 확인용
		int no = 0;
		
		List<SubjectVO> subjectList = subjectService.subjectList(no);
		model.addAttribute("subjectList", subjectList);
		return "subject/subjectList"; // /WEB-INF/views/subject/subjectList.jsp
	}
	
	@GetMapping("/insertForm")
	public String insertForm() {
		log.info("insertForm() 메서드 호출....");
		return "subject/insertForm"; // 매핑정보와 똑같은 주소로 return 하면 반환값 void로 설정 ok. 
	}
	
	@GetMapping("/subjectInsert")
	public String subjectInsert(SubjectVO subject) { // VO의 경우 파라미터값 받아옴
		log.info("subjectInsert() 메서드 호출....");
		
		/* 같은 페이지에 존재하지 않았다면 아래와 같이 코딩 */
		/* int result = 0;
		String path = "";
		
		result = subjectService.subjectInsert(subject);
		if(result == 1)
			path = "/subject/subjectList";
		else
			path = "/subject/insertForm";
		return "redirect:"+path; */
		
		/* Form을 List에 포함해서 요청 */
		subjectService.subjectInsert(subject);
		return "redirect:/subject/subjectList"; // redirect:->포워드가 아닌 매핑 찾음
	}
	
//	@GetMapping("/updateForm")
//	public String updateForm() {
//		log.info("updateForm() 메서드 호출....");
//		return "subject/updateForm"; // 매핑정보와 똑같은 주소로 return 하면 반환값 void로 설정 ok. 
//	}
	
	@GetMapping("/subjectUpdate")
	public String subjectUpdate(SubjectVO subject) {
		log.info("subjectUpdate() 메서드 호출....");
		subjectService.subjectUpdate(subject);
		
		return "redirect:/subject/subjectList";
	}
	
	@GetMapping("/subjectDelete")
	public String subjectDelete(int no) {
		log.info("subjectDelete() 메서드 호출....");
		subjectService.subjectDelete(no);
		return "redirect:/subject/subjectList";
	}
}
