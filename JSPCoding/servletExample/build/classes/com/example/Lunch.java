package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lunch
 */
@WebServlet("/todayMenu")
public class Lunch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		out.println("<div style='text-align: center'>오늘 점심은 <strong>");
		
		String[] values = request.getParameterValues("lunch"); // 요청받은 파라미터값 중에서 이름이 menu인 값 배열로 반환
		for(int i=0; i<values.length; i++) {
			out.print(values[i]);
			if(i<values.length-1) out.print(", ");
		}
		
		out.println("</strong>이나 먹어야겠다.</div>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close(); // 출력 스트림 해제
	}

}
