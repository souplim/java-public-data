package com.spring.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.example.domain.SubjectVO;
import com.spring.example.service.SubjectService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/subject/*")
@Log4j // �α׷� �޼��� ȣ��Ǵ��� Ȯ���ϱ� ����
public class SubjectController {

	@Setter(onMethod_ = @Autowired)
	private SubjectService subjectService;
	
	// ��û�ּ� : http://localhost:8080/subject/subjectList
	@RequestMapping(value="/subjectList", method=RequestMethod.GET)
	public String subjectList(Model model) {
		log.info("subjectList() �޼��� ȣ��...."); // �޼��� ȣ�� Ȯ�ο�
		int no = 0;
		
		List<SubjectVO> subjectList = subjectService.subjectList(no);
		model.addAttribute("subjectList", subjectList);
		return "subject/subjectList"; // /WEB-INF/views/subject/subjectList.jsp
	}
	
	@GetMapping("/insertForm")
	public String insertForm() {
		log.info("insertForm() �޼��� ȣ��....");
		return "subject/insertForm"; // ���������� �Ȱ��� �ּҷ� return �ϸ� ��ȯ�� void�� ���� ok. 
	}
	
	@GetMapping("/subjectInsert")
	public String subjectInsert(SubjectVO subject) { // VO�� ��� �Ķ���Ͱ� �޾ƿ�
		log.info("subjectInsert() �޼��� ȣ��....");
		
		/* ���� �������� �������� �ʾҴٸ� �Ʒ��� ���� �ڵ� */
		/* int result = 0;
		String path = "";
		
		result = subjectService.subjectInsert(subject);
		if(result == 1)
			path = "/subject/subjectList";
		else
			path = "/subject/insertForm";
		return "redirect:"+path; */
		
		/* Form�� List�� �����ؼ� ��û */
		subjectService.subjectInsert(subject);
		return "redirect:/subject/subjectList"; // redirect:->�����尡 �ƴ� ���� ã��
	}
	
//	@GetMapping("/updateForm")
//	public String updateForm() {
//		log.info("updateForm() �޼��� ȣ��....");
//		return "subject/updateForm"; // ���������� �Ȱ��� �ּҷ� return �ϸ� ��ȯ�� void�� ���� ok. 
//	}
	
	@GetMapping("/subjectUpdate")
	public String subjectUpdate(SubjectVO subject) {
		log.info("subjectUpdate() �޼��� ȣ��....");
		subjectService.subjectUpdate(subject);
		
		return "redirect:/subject/subjectList";
	}
	
	@GetMapping("/subjectDelete")
	public String subjectDelete(int no) {
		log.info("subjectDelete() �޼��� ȣ��....");
		subjectService.subjectDelete(no);
		return "redirect:/subject/subjectList";
	}
}
