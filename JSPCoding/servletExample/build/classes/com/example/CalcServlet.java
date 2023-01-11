package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8"); // 클라이언트로부터 전송받은 파라미터의 인코딩을 설정
		response.setContentType("text/html; charset=UTF-8"); // 서버가 클라이언트 브라우저에 전송할 문서 타입 설정
		
		PrintWriter out = response.getWriter(); // 출력스트림 생성(서버에서 클라이언트로 데이터 전송)
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' /><title>SELECT & POST</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body>");
		out.println("<h1>계산결과</<h1><hr/>");
		
		String num1 = request.getParameter("num1");
		String operator = request.getParameter("operator");
		String num2 = request.getParameter("num2");
		String result = request.getParameter("result");
		
		out.println("<div>"+num1+operator+num2+"="+result+"</div>");
		out.println("</body></html>");
		out.close();
	}
}
