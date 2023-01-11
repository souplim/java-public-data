package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
//@WebServlet("/calcServlet2")
public class CalcServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1, num2;
		int result;
		String op;
		
		response.setContentType("text/plain; charset=UTF-8"); // 서버가 클라이언트 브라우저에 전송할 문서 타입 설정
		
		PrintWriter out = response.getWriter(); // 출력스트림 생성(서버에서 클라이언트로 데이터 전송)
		
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("operator");
		
		Calc c = new Calc(num1, num2, op);
		result = c.getResult();
		
		out.print(result); // success의 매개변수로 가져감
		out.close();
	}
}
