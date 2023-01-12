package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chungnam.ChungnamDAO;
import com.chungnam.ChungnamVO;

@WebServlet("/select")
public class ChungnamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ChungnamDAO dao = ChungnamDAO.getInstance();
		ArrayList<ChungnamVO> list = dao.getChungnamList();
		int counter = list.size();
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>Chungnam 정보 리스트 예제</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("<link rel='stylesheet' type='text/css' href='/servletExample/css/chungnam.css'>");
		out.println("<script src=\"/servletExample/js/jquery-3.6.2.min.js\"></script>");
		
		out.println("<script type='text/javascript'>");
		out.println("$(document).on('click','.delBtn', function(){");
		
		out.println("if(confirm('선택하신 항목을 정말로 삭제하시겠습니까?')){");
		out.println("$('.item').remove();"); 
		
		out.println("const mng_no = $(this).data('no');");

		out.println("}});");
		out.println("</script>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1 class='title'>충남관광 - 관광명소</h1>");
		out.println("<div class='btn'><a href='/servletExample/jdbc/chungnamForm.jsp'>정보등록</a></div>");
		out.println("<ul id='list'>");
		
		if(counter>0) {
			//for(int i=0; i<counter; i++){ // 인덱스 접근 시
			// ChungnamVO cvo = list.get(i);
			for(ChungnamVO cvo : list) {
				out.println("<li class='item' data-no='"+cvo.getMng_no()+"'>");
				out.println("<span class='item-thumb'><img src='"+cvo.getList_img()+"' /></span>");
				out.println("<span class='text'>");
				out.println("<span class='item-type'>"+ cvo.getType()+"</span>");
				out.println("<span class='item-title'>"+ cvo.getNm());
				out.println("<button type='button' id='delBtn'>삭제</button></span>");
				out.println("<span class='item-sub'>"+ cvo.getNm_sub()+"</span>");
				out.println("<span class='item-content'>"+ cvo.getDescription()+"</span>");
				out.println("</span>");
				out.println("</li>");
			}
		}
		
		out.println("</ul>");
		out.println("</body></html>");
		out.close();
		
		/*
		 * RequestDispatcher dispatch = request.getRequestDispatcher("delete");
		 * dispatch.forward(request, response);
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}