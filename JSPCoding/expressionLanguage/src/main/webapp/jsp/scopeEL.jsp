<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>EL 예제 - scopeEL.jsp</title>
		
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
		<h2>저장된 객체 추출</h2>
		<hr/>
		<%
			pageContext.setAttribute("message1","PageContext 객체에 저장된 문자열 객체");
			request.setAttribute("message","HttpServletRequest 객체에 저장된 문자열 객체");
			session.setAttribute("message3","HttpSession 객체에 저장된 문자열 객체");
			application.setAttribute("message","ServletContext 객체에 저장된 문자열 객체");
		%>
		pageScope 객체에서 추출 : ${ pageScope.message1 }<br/>
		requestScope 객체에서 추출 : ${ requestScope.message }<br/>
		sessionScope 객체에서 추출 : ${ sessionScope.message3 }<br/>
		applicationScope 객체에서 추출 : ${ applicationScope.message }<br/>
		<hr/>
		message 추출 : ${ message }
	</body>
</html>