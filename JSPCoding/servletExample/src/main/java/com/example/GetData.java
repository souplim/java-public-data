package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetData
 */
@WebServlet("/getData")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 클라이언트로부터 전송받은 파라미터의 인코딩을 설정
		response.setContentType("text/html; charset=UTF-8"); // 서버가 클라이언트 브라우저에 전송할 문서 타입 설정
		
		String paramName = request.getParameter("name"); // 요청받은 파라미터값 중에서 이름이 name인 값 반환
		String paramAddress = request.getParameter("address"); // 요청받은 파라미터값 중에서 이름이 address인 값 반환
		
		PrintWriter out = response.getWriter(); // 출력스트림 생성(서버에서 클라이언트로 데이터 전송)
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' /><title>POST DATA</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("<script type='text/javascript'>");
		out.println("window.onload = function(){");
		out.println("let backPage = document.getElementById('subbtn')");
		out.println("backPage.onclick = function(){");
		out.println("history.back() };");
		out.println("};");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 style='text-align: center'>POST 방식 테스트입니다.</h2><ul>");
		if(!(paramName.equals("") && paramAddress.equals(""))) {
			out.println("<li>입력한 이름 : "+paramName+"</li>");
			out.println("<li>입력한 주소 : "+paramAddress+"</li>");
		}
		
		//out.println("<a href='#' id='btn' onclic='history.back()'>이전 페이지</a>"); // 직관적 명시. 위 js 코드 제외
		out.println("<a href='#' id='btn'>이전 페이지</a>");
		out.println("</ul></body>");
		out.println("</html>");
		
		out.close(); // 출력 스트림 해제
	}

}
