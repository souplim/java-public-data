package com.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* ServletContext 자원 바인딩 기능 예제(시작 페이지 개념)
 * SetServletContext 실행 -> GetServletContext 실행 */
@WebServlet("/setContext")
public class SetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ServletContext의 인스턴스를 얻는다.
		ServletContext context = getServletContext();
		
		List<String> member = new ArrayList<String>();
		member.add("홍길동");
		member.add("한늘봄");
		member.add("김영희");
		
		// 한 프로젝트 안의 모든 서블릿이 공유
		// forward 개념이 아님에도 다른 서블릿에서 정보 사용할 수 있음
		context.setAttribute("member", member); 
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>ServletContext 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body>");
		out.println("<div>ServletContext 속성 설정</div>");
		out.println("</body></html>");
	}
}
