package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.MemberDAO;
import com.member.MemberVO;

@WebServlet("/loginOut")
public class MemberLogInOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String m_id = request.getParameter("m_id");
		String m_passwd = request.getParameter("m_passwd");
		
		HttpSession session = request.getSession(); // 세션 객체 생성
		
		MemberVO vo = new MemberVO();
		vo.setM_id(m_id);
		vo.setM_passwd(m_passwd);
		
		MemberDAO dao = MemberDAO.getInstance();
		// 로그인 처리를 위한 메서드 호출
		// 아이디와 비밀번호 일치 시 MemberVO의 인스턴스값, 일치하지 않을 시 NULL값 반환
		MemberVO mVO = dao.login(vo);
		
		StringBuffer message = new StringBuffer();
		
		if(mVO != null) {
			/* session.setAttribute("m_id", mVO.getM_id()); session.setAttribute("m_name",
			 * mVO.getM_name()); */
			
			session.setAttribute("login", mVO); // 세션 객체 속성 설정
			message.append("<div><a href='/servletExample/loginInfo'>로그인 정보 확인하기</a></div>");
		} else {
			message.append("<div>아이디 또는 비밀번호가 일치하지 않습니다.</div>");
			message.append("<div><a href='#' onclick='history.back()'>이전 화면으로</a></div>");
		}
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' />");
		out.println("<title>로그인 예제</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("</head><body>");
		
		// 정상적으로 로그인 되었을 때
		if(session.getAttribute("login") != null) {
			out.print(((MemberVO)session.getAttribute("login")).getM_name()+"님 반갑습니다.");
		}
		out.print(message.toString());
		out.println("</body></html>");
		out.close();
	}

	// 로그아웃 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("login") != null) {
			// 세션 반환
			session.invalidate();
			response.sendRedirect("/servletExample/jdbc/login.html");
		} else {
			
		}
	}
}
