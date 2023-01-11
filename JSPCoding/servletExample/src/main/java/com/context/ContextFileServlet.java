package com.context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextFileServlet
 */
@WebServlet("/contextFile")
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // 출력해서 내보내야 됨
		
		ServletContext context = getServletContext();
		// 외부 파일 읽어올 수 있는 inputStream 형성
		InputStream is = context.getResourceAsStream("/WEB-INF/config/init.txt");
		// 한 라인씩 읽을 수 있는 BufferedReader의 readLine() 메서드 사용
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		String menu = null;
		String menu_member = null;
		String menu_order = null;
		String menu_goods = null;
		
		while((menu = buffer.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(menu,",");
			menu_member = tokens.nextToken();
			menu_order = tokens.nextToken();
			menu_goods = tokens.nextToken();
		}
		
		// 프로젝트 안에 있는 모든 서블릿이 정보 공유 가능
		List<String> member = (List<String>)context.getAttribute("member"); 
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>dispatch 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body>");
		
		out.print(menu_member + "<br />");
		out.print(menu_order + "<br />");
		out.print(menu_goods + "<br />");
		
		out.println("<div>======회원정보======</div>");
		
		for(String name : member) { 
			out.print(name); 
			out.println();
		}
		
		
		out.print("</body></html>");
		
		out.close();
	}
}
