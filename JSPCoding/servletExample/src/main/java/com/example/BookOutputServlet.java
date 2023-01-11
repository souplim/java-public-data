package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookOutputServlet
 */
@WebServlet("/bookOutput")
public class BookOutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// getAttribute() : 반환형 object -> 형변환 필요
		BookVO book = (BookVO)request.getAttribute("book");
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>책 정보 출력</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("<style type='text/css'>");
		out.println("table{border-collapse: collapse; width: 300px}");
		out.println("td{border:1px solid black;}");
		out.println("</style></head>");
		
		out.println("<body><h1>dispatch를 이용한 forward 실습</h1>");
		out.println("<div>책정보: "+book+"</div>");
		out.print("<table><caption>[입력한 책정보]</caption>");
		out.print("<tr><td>책제목</td><td>"+book.getTitle()+"</td></tr>");
		out.print("<tr><td>저자</td><td>"+book.getAuthor()+"</td></tr>");
		out.print("<tr><td>출판사</td><td>"+book.getPublisher()+"</td></tr>");
		out.print("</table>");
		
		out.println("</body></html>");
	}
}
