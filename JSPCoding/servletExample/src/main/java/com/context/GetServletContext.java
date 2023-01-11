package com.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServletContext
 */
@WebServlet("/getContext")
public class GetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked") // List<String>에 띄워지는 경고창 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// context는 프로젝트 당 하나. set 해놓은 것을 언제든지 get 해서 쓸 수 있는 것
		ServletContext context = getServletContext();
		List<String> member = (List<String>)context.getAttribute("member");
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>ServletContext 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body>");
		
		out.print("<table><caption>[정보 출력]</caption>");
		for(String name : member) {
			out.print("<tr><td>"+name+"</td></tr>");
		}
		out.print("</table>");
		
		out.print("</body></html>");
		out.close();
	}
}
