<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <!-- 공백제거 -->
<% 
	// 페이지 지시자에서 contentType을 "text/text"로 설정한 JSP파일은 출력 결과물이 텍스트 파일로 인식된다.
	// 출력 결과물이 텍스트문서라는 점 외에는 JSP가 갖는 웹 프로그래밍적 부분이 그대로 유지된다.
	
	/* (1) 파라미터를 받는 것이 가능하다. */
	String keyword = request.getParameter("keyword"); /* request : 요청 객체 */
	/* (2) 결과를 출력한다. */
	out.print(keyword);
%>