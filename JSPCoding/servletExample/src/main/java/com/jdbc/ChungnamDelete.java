package com.jdbc;

import java.io.IOException;
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
		request.setCharacterEncoding("UTF-8");
		
		int mng_no = Integer.parseInt(request.getParameter("mng_no"));
		
		ChungnamVO vo = new ChungnamVO();
		vo.setMng_no(mng_no);
		ChungnamDAO dao = ChungnamDAO.getInstance();
		int deleteCount = dao.chungnamDelete(vo);
		
		if(deleteCount > 0) { // 삭제 성공
			
		} else { // 삭제 실패
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
