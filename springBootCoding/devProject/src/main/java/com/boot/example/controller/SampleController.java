package com.boot.example.controller;

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
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.example.domain.ExampleVO;
import com.boot.example.domain.SampleDTO;
import com.boot.example.domain.SampleDTOList;
import com.boot.example.domain.Ticket;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample/*")
@Slf4j
public class SampleController {
	
	@GetMapping("/basic")
	public String basic() {
		log.info("basic get.........");
		return "example/basic";
	}
	
	// 버튼 클릭해서 이동
	
	/* 1. 변수 각각 담아서 전송 */
	// 브라우저 요청할 주소 : http://localhost:8080/sample/exam01?name=홍길동&age=25
	// @RequestMapping(value="/exam01", method= RequestMethod.GET) 
	@GetMapping("/exam01")
//	public String exam01(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
	public String exam01(@RequestParam("name") String name, int age, Model model) {
		// @RequestParam("age") 생략하더라도 form의 name명과 같으면 값 받아옴
		
		log.info("name: " + name);
		log.info("age: " + age);
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "example/exam01"; // -> /WEB-INF/views/exam01.jsp 	
	}
	
	/* 2. 변수를 클래스(VO,DTO)에 담아서 객체 전송 */
	// 요청방법 : http://localhost:8080/sample/exam02?name=홍길동&age=25
	/* @GetMapping("/exam02")
	public String exam02(@ModelAttribute SampleDTO dto, Model model) { 
		log.info("" + dto); // 참조변수.toString() 호출
		
		model.addAttribute("dto", dto);
		return "exam02"; // /WEB-INF/views/exam02.jsp를 의미
	} */
	
	/* 2. 변수를 클래스(VO,DTO)에 담아서 객체 전송 */
	// VO에 담은 값은 model에 담지 않아도 같이 넘겨짐
	@GetMapping("/exam02")
	public String exam02(@ModelAttribute SampleDTO dto) { 
//	public String exam02(@ModelAttribute("sDto") SampleDTO dto) { // 괄호안의 이름으로 SampleDTO 넘겨줌
		log.info("" + dto); // 참조변수.toString() 호출
		
		// VO에 담은 값은 model에 담지 않아도 sampleDTO라는 이름으로 객체의 필드 사용 가능
//		model.addAttribute("dto", dto);
		
		return "example/exam02"; // /WEB-INF/views/exam02.jsp를 의미
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test"; // /WEB-INF/views/test.jsp를 의미
		// return "sample/test"; // /WEB-INF/views/sample/test.jsp를 의미
	}
	
	/* checkbox - ArrayList로 가져오기(List X) */
	// 요청방법 : http://localhost:8080/sample/exam02List
	@GetMapping("/exam02List")
	// List는 인터페이스라 객체 못 만들므로 ArrayList<String> 타입으로 매개변수 받아야 함
	public String exam02List(@RequestParam("language") ArrayList<String> language, Model model) {
		log.info("language : " + language.toString());
		
		// 확인차 돌리는 for문 -> jsp에 있어야 함
		for(String lang : language) {
			log.info("language values : " + lang);
		}
		
		// vo가 아닌 parameter 값이므로 model에 담아서 가야 함(jstl의 <c:forEach> 태그 사용)
		model.addAttribute("language", language);
		return "example/exam02List"; // /WEB-INF/views/exam02List.jsp를 의미
	}
	
	/* checkbox - 배열로 가져오기 */
	@GetMapping("/exam02Array")
	public String exam02Array(@RequestParam("hobby") String[] hobby, Model model) {
		log.info("array hobby : " + Arrays.toString(hobby));
		model.addAttribute("hobby", hobby);
		return "example/exam02Array"; // /WEB-INF/views/exam02Array.jsp를 의미
	}
	
	/* 각각의 원소가 SampleDTO인 ArrayList로 가져오기 
	 * 요청방법: http://localhost:8080/sample/exam02Bean?list[0].name=홍길동&list[0].age=25&list[1].name=scott&list[1].age=30
	 * '[]'문자를 특수문자로 허용하지 않아 오류가 발생함
	 * 해결방법: http://localhost:8080/sample/exam02Bean?list%5B0%5D.name=홍길동&list%5B0%5D.age=25&list%5B1%5D.name=scott&list%5B1%5D.age=30 */
	@GetMapping("/exam02Bean")
	public String exam02Bean(SampleDTOList list) {
		log.info("list dtoList: " + list);
		
		return "example/exam02Bean";
	}
										// @ModelAttribute("number") int number -> 모델에 담지 않아도 jsp 문서에 넘겨짐
	@GetMapping("/exam03")				// @RequestParam("number") int number -> model.addAttribute("number", number)
	public String exam03(SampleDTO dto, @ModelAttribute("number") int number) {
		log.info("dta : " + dto);
		log.info("number : " + number);
		
		return "sample/exam03"; // /WEB-INF/views/sample/exam03.jsp를 의미
	}
	
	/* @ResponseBody : 일반적인 JSP와 같은 뷰로 전달되는 게 아니라 데이터 자체를 전달하기 위한 용도
	 * 응답 문서 타입을 xml이나 json으로 반환할 때는 produces 속성을 사용한다.
	 * 참고 : @RestController (@Controller + @ResponseBody) 클래스 위에 Controller 대신해서 사용
	 * 		 -> data 자체를 전달하기 위해 만든 Controller */
	@GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String getText() {
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
												// 응답할 문서 타입 -> MediaType
	@GetMapping(value="/getExample", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public SampleDTO getExample(){
		log.info("/getExample.............");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("홍길동");
		dto.setAge(20);
		
		return dto;
	}
	
	@GetMapping(value="/getExample2", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ExampleVO getExample2(){

		// ExampleVO 클래스의 필드는 no, name, phone이 존재
		return new ExampleVO(1, "김철수", "010-123-4567");
	}
	
	/* ResponseEntity : 개발자가 결과 데이터와 HTTP 상태 코드를 직접 제어할 수 있는 클래스 
	 * - 에러나도 200번 줄 수 있음*/
	/* @GetMapping(value="/getExample3")
	public ResponseEntity<String> getExample3(){ 
		log.info("/getExample3................");
		
		// {"name":"홍길동","email":"javauser@naver.com"}
		String msg = "{\"name\":\"홍길동\",\"email\":\"javauser@naver.com\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK); // (전달할 값, 헤더, 개발자가 응답코드 결정 OK)
	} */
	@GetMapping(value="/getExample3")
	public ResponseEntity<ExampleVO> getExample3(){ 
		log.info("/getExample3................");
		
		ExampleVO exampleVO = new ExampleVO(2, "홍길동", "010-123-4567");
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(exampleVO, header, HttpStatus.OK); // (전달할 값, 헤더, 개발자가 응답코드 결정 OK)
	}
	
	@GetMapping(value="/getList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ExampleVO> getList(){

		List<ExampleVO> list = new ArrayList<>();
		
		// ExampleVO 가 하나의 JSON 됨
		list.add(new ExampleVO(1, "홍길동", "010-6703-1209"));
		list.add(new ExampleVO(2, "한늘봄", "010-6703-1209"));
		list.add(new ExampleVO(3, "이진희", "010-6703-1209"));
		list.add(new ExampleVO(4, "박철희", "010-6703-1209"));

		return list;
	}
	
	@GetMapping("/examMethod") // 회원가입 화면
	public String examMethod() {
		log.info("/examMethod Get............");
		
		return "sample/examMethod"; // /WEB-INF/views/sample/examMethod.jsp를 의미
	}
	
	// Method 방식이 다르면 Mapping이 같을 수 있음
	@PostMapping(value="/examMethod", produces="text/plain;charset=UTF-8") // 회원가입 처리
	@ResponseBody
	public String examMethod(ExampleVO evo, Ticket tvo) {
		log.info("/examMethod Post.............");
		log.info("/ExampleVO : " + evo + "Ticket : " + tvo);
		
		return "전송 선공";
	}
}
