package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		out.println("<link rel='stylesheet' type='text/css' href='/servletExample/css/chungnam.css'>"); // 브라우저 
		out.println("<script src=\"/servletExample/js/jquery-3.6.2.min.js\"></script>");
		
		out.println("<script type='text/javascript'>");
		out.println("$(function(){");
		out.println("	$(document).on('click','#delBtn', function(){");
		out.println("		if(confirm('선택하신 항목을 정말로 삭제하시겠습니까?')){");
		out.println("			let mng_no = $(this).parents('.item').data('no');");
		out.println("			$('#result').val(mng_no);");		
		out.println("			$('#resultForm').attr({");
		out.println("				'method' : 'post',");
		out.println("				'action' : '/servletExample/delete'");
		out.println("			});");
		out.println("		$('#resultForm').submit();");
		out.println("	}});");
		out.println("});");
		
		// out.println("		let mng_no = $(this).parents('.item').attr('data-no'); console.log(mng_no);");
		// 자바스크립트 이동 --> location.href=''
		// out.println("		location.href='/servletExample/delete?mng_no='+mng_no;");
		// out.println("	});");
		// out.println("});");	
		
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
		
		//js에서 생성한 값을 보내기 위한 태그
		out.println("<form id='resultForm'><input type='hidden' name='result' id='result' /></form>");
		
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
