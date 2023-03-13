package com.spring.admin.login.controller;

import javax.servlet.http.HttpSession;

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
import lombok.extern.log4j.Log4j;

/* @SessionAttributes : ��(Model) ������ HTTP ���ǿ� �������ִ� ������̼�
 * HttpSesson�� ���� ����� ���� ������ �� ������̼ǿ� ������ �̸��� �ش��ϴ� �� ������ �ڵ����� ���ǿ� �־��� */
@Controller
/* @SessionAttributes �Ķ���ͷ� ������ �̸��� ���� �̸��� @ModelAttribute�� �����Ǿ� ���� ���
 * �޼ҵ尡 ��ȯ�Ǵ� ���� ���ǿ� �����*/
@SessionAttributes("adminLogin")
@RequestMapping("/admin/*")
@Log4j
public class AdminLoginController {
	
	@Setter(onMethod_ = @Autowired)
	private AdminLoginService adminLoginService;
	
	/* @SessionAttributes�� �Ķ���Ϳ� ���� �̸��� @ModelAttribute�� ���� ��� ���ǿ� �ִ� ��ü�� ������ ��,
	 * Ŭ���̾�Ʈ�� ���۹��� ���� �����Ѵ�. */
	@ModelAttribute
	public AdminLoginVO adminLogin() {
		return new AdminLoginVO();
	}
	
	/***************************************************************************************
	 * ������ �α��� ȭ��(�������� ���� ������) ���� �޼���
	 * ��û URL : http://localhost:8080/admin/login���� ��û
	 ***************************************************************************************/
	@GetMapping("/login")
	public String loginForm() {
		log.info("admin �α��� ȭ�� ȣ��");
		
		return "admin/main"; // /WEB-INF/views/admin/main.jsp�� ������(������ ���������� - �α��� ������)
	}
	
	/***************************************************************************************
	 * ������ �α��� ó�� ���� �޼���
	 * ���� : �ڹٴܿ��� ������ ���� ����� ���, �ٽ� ���� Controller �� �޼��忡�� ������ ���� �ʿ��� ���
	 * @SessionAttributes("adminLogin") ����� �� �̸���
	 * public ��ȯ�� �޼����(@SessionAttribute("adminLogin") VO Ŭ������ ��������)�� �����ϰ� ����ϸ� �ȴ�.
	 * 
	 * RedirectAttriutes ��ü�� �����̷�Ʈ ����(return "redirect:/���")�� 
	 * �ѹ��� ���Ǵ� �����͸� ������ �� �ִ� addFlashAttribute() ��� ����� �����Ѵ�.
	 * addFlashAttribute() �޼���� ���������� ���۵Ǳ�� ������, URI �󿡴� ������ �ʴ� ������ �������� ���·� ���޵ȴ�.
	 * 
	 * redirect:/admin/login?errorMsg=error��� �����ؾ� �ϴµ�
	 * �� �� ras.addFlashAttribute("errorMsg","error"); redirect:/admin/login���� �̵�
	 ***************************************************************************************/
	@PostMapping("/login")		// @ModelAttribute -> ����. a_id�� a_id�� �ڵ����ε�
	public String loginProcess(AdminLoginVO login, Model model, /* HttpSession session,*/ RedirectAttributes ras) {
		String url = "";
		AdminLoginVO adminLogin = adminLoginService.loginProcess(login);
		
		if(adminLogin != null) { // ���̵� ��й�ȣ�� ��ġ 
			// session.setAttribute("adminLogin", adminLogin); 
			// jsp �ڵ��� ��� ������ �޸𸮿� ���� ���ܵα� ���� session �������
			// ���ǿ� ����� ���̵� ��� -> �ٸ� �޼��忡�� session �� �־�� �� 
			// public String method(HttpSession session){
			// 	AdminLoginVO adminLoginVO = (AdminLoginVO) session.getAttribute("adminLogin");
			// 	String a_id = adminLoginVO.getA_id(); }
			
			// spring�� ��� session��� ������̼�(@SessionAttributes) ���
			// ���ǿ� ����� �� ���� �� -> public ��ȯ�� �޼����(@SessionAttribute("adminLogin") VO Ŭ������ ��������)
			model.addAttribute("adminLogin", adminLogin);
			url = "/admin/board/boardList";
		} else { // ���̵� ��й�ȣ�� ����ġ
			ras.addFlashAttribute("errorMsg","�α��� ����");
			url = "/admin/login";
		}
		return "redirect:"+url; // redirect -> model�� �� �� �������Ƿ� 
	}
	
	/***************************************************************************************
	 * �α׾ƿ� ó�� �޼���
	 * setComplete() �޼��带 Ȱ���Ͽ� ������ �Ҵ� ����
	 ***************************************************************************************/ 
	@RequestMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		log.info("admin �α׾ƿ� ó��");
		sessionStatus.setComplete();
		return "redirect:/admin/login";
	}
}
