package example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/portalSite")
public class SendRedirectTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("site");
		
		if (param.equals("naver")){
			response.sendRedirect("http://www.naver.com");
		} else if (param.equals("daum")){
			response.sendRedirect("http://www.daum.net");
		} else if (param.equals("w3schols")){
			response.sendRedirect("http://www.w3schols.com");
		} else if (param.equals("google")){
			response.sendRedirect("http://www.google.com");
		} 
	}
}
