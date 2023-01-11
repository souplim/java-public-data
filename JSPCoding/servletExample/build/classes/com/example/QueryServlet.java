package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/queryget", "/querypost"}) // 하나의 서블릿에 여러개 매핑
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response); // 둘다 처리 내용 똑같으므로 메서드 따로 만들어 호출함
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 반드시 인코딩 처리 해야 안 깨짐
		request.setCharacterEncoding("utf-8");
		process(request, response); 
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("guestName");
		int num = Integer.parseInt(request.getParameter("num"));
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>GET 방식과 POST 방식</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body>");
		
		out.print("<h2>요청 방식 : "+ request.getMethod()+"</h2>");
		out.print("<h2>요청 URI : "+ request.getRequestURI()+"</h2>");
		
		out.print("<h2>당신의 이름은 "+userName+"이군요!</h2>");
		out.print("<h2>당신이 좋아하는 숫자는 "+num+"이군요!</h2>");
		
		out.print("<a href='#' onclick='history.back();'>입력화면으로 가기</a>");
		out.println("</body></html>");
		out.close();
	}
}
