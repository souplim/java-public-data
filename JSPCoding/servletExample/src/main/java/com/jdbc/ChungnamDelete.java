package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chungnam.ChungnamDAO;
import com.chungnam.ChungnamVO;

@WebServlet("/delete")
public class ChungnamDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
			
		int mng_no = Integer.parseInt(request.getParameter("result"));
		
		// javascript location.href="" 를 사용했을 경우
		// int mng_no = Integer.parseInt(request.getParameter("mng_no"));
		
		ChungnamVO vo = new ChungnamVO();
		vo.setMng_no(mng_no);
		ChungnamDAO dao = ChungnamDAO.getInstance();
		int deleteCount = dao.chungnamDelete(vo);
		
		System.out.println(mng_no);
		System.out.println(deleteCount);
		
		if(deleteCount == 1) { // 삭제 성공
			try {
		        out.write("<script>alert('삭제 완료하였습니다.');location.href='select';</script>");
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		} else { // 삭제 실패
			out.write("<script>alert('삭제 실패하였습니다.');history.back();</script>");
		}
		
		out.flush();
        out.close();
	}
}
