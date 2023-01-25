package com.binding;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.Address;
import com.member.Member;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Address address = new Address();
		address.setCity(request.getParameter("city"));
		address.setZipcode(request.getParameter("zipcode"));
		
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setAddress(address);
		
		request.setAttribute("member", member);
		RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/memberServletResult.jsp");
		dispatch.forward(request, response);
	}
}
