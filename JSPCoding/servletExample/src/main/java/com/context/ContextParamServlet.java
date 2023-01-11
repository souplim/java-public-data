package com.context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* ServletContext의 매개변수 설정 가능 */
@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		
		// web.xml에서 초기값 준 것 읽음
		String menu_member = context.getInitParameter("menu_member"); 
		String menu_order = context.getInitParameter("menu_order"); 
		String menu_goods = context.getInitParameter("menu_goods"); 
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>ServletContext 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body>");
		
		out.println("<table><tr>메뉴 이름</tr>");
		out.println("<tr><td>"+menu_member+"</td></tr>");
		out.println("<tr><td>"+menu_order+"</td></tr>");
		out.println("<tr><td>"+menu_goods+"</td></tr>");
		out.println("</table>");
		
		out.println("</body></html>");
		out.close();
	}
}
