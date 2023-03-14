package com.spring.admin.login.controller;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.admin.login.service.AdminLoginService;
import com.spring.admin.login.vo.AdminLoginVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/* @SessionAttributes : 모델(Model) 정보를 HTTP 세션에 저장해주는 어노테이션
 * HttpSesson을 직접 사용할 수도 있지만 이 어노테이션에 설정한 이름이 해당하는 모델 정보를 자동으로 세션에 넣어줌 */
@Controller
/* @SessionAttributes 파라미터로 지정된 이름과 같은 이름이 @ModelAttribute에 지정되어 있을 경우
 * 메소드가 반환되는 값은 세션에 저장됨*/
@SessionAttributes("adminLogin")
@RequestMapping("/admin/*")
@Slf4j
public class AdminLoginController {
	
	@Setter(onMethod_ = @Autowired)
	private AdminLoginService adminLoginService;
	
	/* @SessionAttributes의 파라미터와 같은 이름이 @ModelAttribute에 있을 경우 세션에 있는 객체를 가져온 후,
	 * 클라이언트로 전송받은 값을 설정한다. */
	@ModelAttribute
	public AdminLoginVO adminLogin() {
		return new AdminLoginVO();
	}
	
	/***************************************************************************************
	 * 관리자 로그인 화면(관리자의 메인 페이지) 구현 메서드
	 * 요청 URL : http://localhost:8080/admin/login으로 요청
	 ***************************************************************************************/
	@GetMapping("/login")
	public String loginForm() {
		log.info("admin 로그인 화면 호출");
		
		return "admin/main"; // /WEB-INF/views/admin/main.jsp로 포워드(관리자 시작페이지 - 로그인 페이지)
	}
	
	/***************************************************************************************
	 * 관리자 로그인 처리 구현 메서드
	 * 참고 : 자바단에서 세션의 값을 사용할 경우, 다시 말해 Controller 내 메서드에서 세션의 값이 필요할 경우
	 * @SessionAttributes("adminLogin") 명시해 준 이름을
	 * public 반환형 메서드명(@SessionAttribute("adminLogin") VO 클래스명 참조변수)로 정의하고 사용하면 된다.
	 * 
	 * RedirectAttriutes 객체는 리다이렉트 시점(return "redirect:/경로")에 
	 * 한번만 사용되는 데이터를 전송할 수 있는 addFlashAttribute() 라는 기능을 지원한다.
	 * addFlashAttribute() 메서드는 브라우저까지 전송되기는 하지만, URI 상에는 보이지 않는 숨겨진 데이터의 형태로 전달된다.
	 * 
	 * redirect:/admin/login?errorMsg=error라고 전송해야 하는데
	 * 이 때 ras.addFlashAttribute("errorMsg","error"); redirect:/admin/login으로 이동
	 ***************************************************************************************/
	@PostMapping("/login")		// @ModelAttribute -> 생략. a_id를 a_id에 자동바인딩
	public String loginProcess(AdminLoginVO login, Model model, /* HttpSession session,*/ RedirectAttributes ras) {
		String url = "";
		AdminLoginVO adminLogin = adminLoginService.loginProcess(login);
		
		if(adminLogin != null) { // 아이디 비밀번호가 일치 
			// session.setAttribute("adminLogin", adminLogin); 
			// jsp 코딩의 경우 서버측 메모리에 정보 남겨두기 위해 session 사용했음
			// 세션에 저장된 아이디 얻기 -> 다른 메서드에도 session 값 있어야 함 
			// public String method(HttpSession session){
			// 	AdminLoginVO adminLoginVO = (AdminLoginVO) session.getAttribute("adminLogin");
			// 	String a_id = adminLoginVO.getA_id(); }
			
			// spring의 경우 session사용 어노테이션(@SessionAttributes) 사용
			// 세션에 저장된 값 얻을 때 -> public 반환형 메서드명(@SessionAttribute("adminLogin") VO 클래스명 참조변수)
			model.addAttribute("adminLogin", adminLogin);
			url = "/admin/board/boardList";
		} else { // 아이디 비밀번호가 불일치
			ras.addFlashAttribute("errorMsg","로그인 실패");
			url = "/admin/login";
		}
		return "redirect:"+url; // redirect -> model의 값 못 가져가므로 
	}
	
	/***************************************************************************************
	 * 로그아웃 처리 메서드
	 * setComplete() 메서드를 활용하여 세션을 할당 해지
	 ***************************************************************************************/ 
	@RequestMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		log.info("admin 로그아웃 처리");
		sessionStatus.setComplete();
		return "redirect:/admin/login";
	}
}
