<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page errorPage="error500.jsp" %> --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>예외 처리 - readParameter.jsp</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
	</head>
	<body>
		<p>
			name 파라미터 값:
			<%= request.getParameter("name").toUpperCase() %>
		</p>
		
		<!-- 예외처리(bechecked 예외) -->
		<%-- <% try { %>
			<p>
				name 파라미터 값:
				<%=request.getParameter("name").toUpperCase() %>
			</p>
		<% } catch(NullPointerException e) {%>
			<p>
				파라미터 값을 정상적으로 받지 못했습니다.
			</p>
		<% } %> --%>
		
		<!-- if문으로 제어 -->
		<%-- <% 
			String name = request.getParameter("name"); 
			if(name != null) {
		%>
				<p>name 파라미터 값: <%=name.toUpperCase()%></p>
		<%  } else { %>
				<p> 파라미터 값을 정상적으로 받지 못했습니다. </p>
		<%  } %> --%>
		
		<!--  
			http://localhost:8080/scriptTag/error/readParameter.jsp?name=java
			이렇게 get 방식으로 값 전달하면 -> name 파라미터 값: JAVA (toUpperCase())
		-->
	</body>
</html>