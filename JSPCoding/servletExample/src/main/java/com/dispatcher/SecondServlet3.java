package com.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet3
 */
@WebServlet("/secondDispatcher")
public class SecondServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// setAttribute()으로 설정하면 getAttribute()로 받아야 함
		/*
		 * String language = request.getParameter("language"); String name =
		 * request.getParameter("name"); String address =
		 * request.getParameter("address");
		 */
		// getAttribute() : 반환형 object -> 형변환 필요
		String language = (String)request.getAttribute("language"); 
		String name = (String)request.getAttribute("name"); 
		String address = (String)request.getAttribute("address");
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>dispatch 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body><div>dispatch를 이용한 forward 실습입니다</div>");
		out.println("<div>언어 : "+language+"</div>");
		out.println("<div>이름 : "+name+"</div>");
		out.println("<div>주소 : "+address+"</div>");
		out.println("</body></html>");
	}
}
