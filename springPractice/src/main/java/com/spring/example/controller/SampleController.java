package com.spring.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.example.domain.ExampleVO;
import com.spring.example.domain.SampleDTO;
import com.spring.example.domain.SampleDTOList;
import com.spring.example.domain.Ticket;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*") // mapping ����� �� �ڵ����� �߰�
@Log4j
public class SampleController {
	
	// http://localhost:8080/sample/start�� ��û (root�� /example -> /�� �������� ��)
	@RequestMapping(value="/start", method= {RequestMethod.GET, RequestMethod.POST}) // /sample/start��� �� �ʿ� ����
	public void basicGet() {
		log.info("/sample/start get...................");
		// ��ȯ�� void -> ������ /sample/start -> /WEB-INF/views/sample/start.jsp
		// �׷��� �򰥸��Ƿ� �Ȱ����� �ַ� String�� ��ȯ������ �ؼ� �޼��� ������
	}
	
	// ������ ��û�� �ּ� : requestMapping -> http://localhost:8080/sample/basic���� ��û
	@RequestMapping(value="/basic", method= RequestMethod.GET) 
	public String basicGet1() {
		log.info("basic get...................");
		return "basic"; // /WEB-INF/views/basic.jsp (������ views �ȿ� �־�� ��)
	}
	
	// ��ư Ŭ���ؼ� �̵�
	
	/* 1. ���� ���� ��Ƽ� ���� */
	// ������ ��û�� �ּ� : http://localhost:8080/sample/exam01?name=ȫ�浿&age=25
	// @RequestMapping(value="/exam01", method= RequestMethod.GET) 
	@GetMapping("/exam01")
//	public String exam01(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
	public String exam01(@RequestParam("name") String name, int age, Model model) {
		// @RequestParam("age") �����ϴ��� form�� name��� ������ �� �޾ƿ�
		
		log.info("name: " + name);
		log.info("age: " + age);
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "exam01"; // -> /WEB-INF/views/exam01.jsp 	
	}
	
	/* 2. ������ Ŭ����(VO,DTO)�� ��Ƽ� ��ü ���� */
	// ��û��� : http://localhost:8080/sample/exam02?name=ȫ�浿&age=25
	/* @GetMapping("/exam02")
	public String exam02(@ModelAttribute SampleDTO dto, Model model) { 
		log.info("" + dto); // ��������.toString() ȣ��
		
		model.addAttribute("dto", dto);
		return "exam02"; // /WEB-INF/views/exam02.jsp�� �ǹ�
	} */
	
	/* 2. ������ Ŭ����(VO,DTO)�� ��Ƽ� ��ü ���� */
	// VO�� ���� ���� model�� ���� �ʾƵ� ���� �Ѱ���
	@GetMapping("/exam02")
	public String exam02(@ModelAttribute SampleDTO dto) { 
//	public String exam02(@ModelAttribute("sDto") SampleDTO dto) { // ��ȣ���� �̸����� SampleDTO �Ѱ���
		log.info("" + dto); // ��������.toString() ȣ��
		
		// VO�� ���� ���� model�� ���� �ʾƵ� sampleDTO��� �̸����� ��ü�� �ʵ� ��� ����
//		model.addAttribute("dto", dto);
		
		return "exam02"; // /WEB-INF/views/exam02.jsp�� �ǹ�
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test"; // /WEB-INF/views/test.jsp�� �ǹ�
		// return "sample/test"; // /WEB-INF/views/sample/test.jsp�� �ǹ�
	}
	
	/* checkbox - ArrayList�� ��������(List X) */
	// ��û��� : http://localhost:8080/sample/exam02List
	@GetMapping("/exam02List")
	// List�� �������̽��� ��ü �� ����Ƿ� ArrayList<String> Ÿ������ �Ű����� �޾ƾ� ��
	public String exam02List(@RequestParam("language") ArrayList<String> language, Model model) {
		log.info("language : " + language.toString());
		
		// Ȯ���� ������ for�� -> jsp�� �־�� ��
		for(String lang : language) {
			log.info("language values : " + lang);
		}
		
		// vo�� �ƴ� parameter ���̹Ƿ� model�� ��Ƽ� ���� ��(jstl�� <c:forEach> �±� ���)
		model.addAttribute("language", language);
		return "exam02List"; // /WEB-INF/views/exam02List.jsp�� �ǹ�
	}
	
	/* checkbox - �迭�� �������� */
	@GetMapping("/exam02Array")
	public String exam02Array(@RequestParam("hobby") String[] hobby, Model model) {
		log.info("array hobby : " + Arrays.toString(hobby));
		model.addAttribute("hobby", hobby);
		return "exam02Array"; // /WEB-INF/views/exam02Array.jsp�� �ǹ�
	}
	
	/* ������ ���Ұ� SampleDTO�� ArrayList�� �������� 
	 * ��û���: http://localhost:8080/sample/exam02Bean?list[0].name=ȫ�浿&list[0].age=25&list[1].name=scott&list[1].age=30
	 * '[]'���ڸ� Ư�����ڷ� ������� �ʾ� ������ �߻���
	 * �ذ���: http://localhost:8080/sample/exam02Bean?list%5B0%5D.name=ȫ�浿&list%5B0%5D.age=25&list%5B1%5D.name=scott&list%5B1%5D.age=30 */
	@GetMapping("/exam02Bean")
	public String exam02Bean(SampleDTOList list) {
		log.info("list dtoList: " + list);
		
		return "exam02Bean";
	}
										// @ModelAttribute("number") int number -> �𵨿� ���� �ʾƵ� jsp ������ �Ѱ���
	@GetMapping("/exam03")				// @RequestParam("number") int number -> model.addAttribute("number", number)
	public String exam03(SampleDTO dto, @ModelAttribute("number") int number) {
		log.info("dta : " + dto);
		log.info("number : " + number);
		
		return "sample/exam03"; // /WEB-INF/views/sample/exam03.jsp�� �ǹ�
	}
	
	/* @ResponseBody : �Ϲ����� JSP�� ���� ��� ���޵Ǵ� �� �ƴ϶� ������ ��ü�� �����ϱ� ���� �뵵
	 * ���� ���� Ÿ���� xml�̳� json���� ��ȯ�� ���� produces �Ӽ��� ����Ѵ�.
	 * ���� : @RestController (@Controller + @ResponseBody) Ŭ���� ���� Controller ����ؼ� ���
	 * 		 -> data ��ü�� �����ϱ� ���� ���� Controller */
	@GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String getText() {
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "�ȳ��ϼ���";
	}
												// ������ ���� Ÿ�� -> MediaType
	@GetMapping(value="/getExample", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public SampleDTO getExample(){
		log.info("/getExample.............");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("ȫ�浿");
		dto.setAge(20);
		
		return dto;
	}
	
	@GetMapping(value="/getExample2", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ExampleVO getExample2(){

		// ExampleVO Ŭ������ �ʵ�� no, name, phone�� ����
		return new ExampleVO(1, "��ö��", "010-123-4567");
	}
	
	/* ResponseEntity : �����ڰ� ��� �����Ϳ� HTTP ���� �ڵ带 ���� ������ �� �ִ� Ŭ���� 
	 * - �������� 200�� �� �� ����*/
	/* @GetMapping(value="/getExample3")
	public ResponseEntity<String> getExample3(){ 
		log.info("/getExample3................");
		
		// {"name":"ȫ�浿","email":"javauser@naver.com"}
		String msg = "{\"name\":\"ȫ�浿\",\"email\":\"javauser@naver.com\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK); // (������ ��, ���, �����ڰ� �����ڵ� ���� OK)
	} */
	@GetMapping(value="/getExample3")
	public ResponseEntity<ExampleVO> getExample3(){ 
		log.info("/getExample3................");
		
		ExampleVO exampleVO = new ExampleVO(2, "ȫ�浿", "010-123-4567");
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(exampleVO, header, HttpStatus.OK); // (������ ��, ���, �����ڰ� �����ڵ� ���� OK)
	}
	
	
	
	@GetMapping(value="/getList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ExampleVO> getList(){

		List<ExampleVO> list = new ArrayList<>();
		
		// ExampleVO �� �ϳ��� JSON ��
		list.add(new ExampleVO(1, "ȫ�浿", "010-6703-1209"));
		list.add(new ExampleVO(2, "�Ѵú�", "010-6703-1209"));
		list.add(new ExampleVO(3, "������", "010-6703-1209"));
		list.add(new ExampleVO(4, "��ö��", "010-6703-1209"));

		return list;
	}
	
	@GetMapping("/examMethod") // ȸ������ ȭ��
	public String examMethod() {
		log.info("/examMethod Get............");
		
		return "sample/examMethod"; // /WEB-INF/views/sample/examMethod.jsp�� �ǹ�
	}
	
	// Method ����� �ٸ��� Mapping�� ���� �� ����
	@PostMapping(value="/examMethod", produces="text/plain;charset=UTF-8") // ȸ������ ó��
	@ResponseBody
	public String examMethod(ExampleVO evo, Ticket tvo) {
		log.info("/examMethod Post.............");
		log.info("/ExampleVO : " + evo + "Ticket : " + tvo);
		
		return "���� ����";
	}
}
