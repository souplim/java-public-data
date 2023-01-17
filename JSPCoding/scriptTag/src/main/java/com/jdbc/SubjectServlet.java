package com.jdbc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.SubjectVO;

@WebServlet("/list")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubjectService subjectService = SubjectService.getInstance(); // 싱글톤 객체 생성
		ArrayList<SubjectVO> list = subjectService.subjectList(null); // 전체 조회하기 위해 인자로 null값 주기
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jdbc/subjectList.jsp");
		dispatcher.forward(request, response);
	}
}
