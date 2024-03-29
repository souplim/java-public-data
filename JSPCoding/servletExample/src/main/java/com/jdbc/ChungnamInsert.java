package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chungnam.ChungnamDAO;
import com.chungnam.ChungnamVO;

@WebServlet("/insert")
public class ChungnamInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int mng_no = Integer.parseInt(request.getParameter("mng_no"));
		String local_nm = request.getParameter("local_nm");
		String type = request.getParameter("type");
		String nm = request.getParameter("nm");
		String nm_sub = request.getParameter("nm_sub");
		String addr = request.getParameter("addr");
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		String description = request.getParameter("description");
		String list_img = request.getParameter("list_img");
		
		ChungnamVO vo = new ChungnamVO(mng_no, local_nm, type, nm, nm_sub, addr, lat, lng, description, list_img, null);
		
		ChungnamDAO dao = ChungnamDAO.getInstance();
		int insertCount = dao.chungnamInsert(vo);
		
		if(insertCount == 1) {
			// 입력 성공하면 db받아와 select화면에 입력한 항목 띄우기
//			RequestDispatcher dispatch = request.getRequestDispatcher("select");
//			dispatch.forward(request, response);
			
			// dispatch는 url이 안 바뀌기 때문에 여기서는 select의 화면으로 이동하며 select 주소가 보여지기 위해
			// dispatch가 아닌 redirect 방법을 사용한다!
			response.sendRedirect("/servletExample/select"); 
		}
		else {
			 try {
			        out.write("<script>alert('입력에 실패하였습니다.<br/>다시 입력해주세요');history.back();</script>");
			        out.flush();
			        out.close();
			    } catch(Exception e) {
			        e.printStackTrace();
			    }
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
