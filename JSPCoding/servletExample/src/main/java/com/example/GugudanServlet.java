package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudanServlet")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int dan = Integer.parseInt(request.getParameter("dan"));
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>간단한 연산 결과</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("<style type='text/css'>");
		out.println("table{border-collapse: collapse; width:500px; text-align: center;}");
		out.println("tr{background-color:#FFFF66; text-align: center; }");
		out.println("td{width: 250px; border:1px solid black;}");
		out.println("</style></head>");
		
		out.println("<body>");
		out.print("<table><tr><td colspan='2'>"+dan+" 단 출력</td></tr>");
		
		for(int i=1; i<10; i++) {
			if(i%2==0) 
				out.print("<tr style='background-color:#ACFA58'>");
			else 
				out.print("<tr style='background-color:#81BEF7'>");
			
			out.print("<td>"+dan+" * "+i+"</td>");
			out.print("<td>"+dan*i+"</td></tr>");
		}
		
		out.print("</table>");
		out.println("</body></html>");
		out.close();
	}
}
