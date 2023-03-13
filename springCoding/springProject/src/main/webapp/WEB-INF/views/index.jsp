<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="intro" /> 

<!-- 
	 mainLayout.jsp를 home으로 바로 설정할 수도 있지만 
	 우리는 tiles의 설정에 따라 페이지를 불러와 삽입하므로
	 index.jsp라는 페이지를 하나 더 만들어 intro 라는 이름으로 설정되어 있는 
	 
	 <definition name="intro" template="/WEB-INF/views/template/client/mainLayout.jsp">
		<put-attribute name="title" value="나의 첫 스프링 사이트" />
		<put-attribute name="header" value="/WEB-INF/views/template/client/header.jsp" />
		<put-attribute name="footer" value="/WEB-INF/views/template/client/footer.jsp" />
	 </definition>
	 
	 페이지의 조합을 불러옴
 -->