package com.spring.myapp.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/test") // mapping 잡아줄 때 자동으로 추가
@Log4j
public class LoginController {
	
	// 브라우저 요청할 주소 : requestMapping -> http://localhost:8080/myapp/test/loginForm로 요청
	@RequestMapping(value={"/loginForm","/loginForm2"}, method= RequestMethod.GET) 
	public String basicGet1() {
		log.info("index get...................");
		return "test/loginForm"; // -> /WEB-INF/views/test/loginForm.jsp (파일은 views 안에 있어야 함)
	}
	
	// 브라우저 요청할 주소 : requestMapping -> http://localhost:8080/myapp/test/login로 요청
	@RequestMapping(value="/login", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		
		mav.addObject("userID",userID);
		mav.addObject("userName",userName);
		
		mav.setViewName("test/result");
		return mav;
	}
}
