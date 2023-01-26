<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); // POST 방식의 한글 처리 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>책정보 처리 페이지 예제 : bookResult.jsp</title>
		
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
		<%-- 액션태그 --%>
		<%-- com.book.BookVO book = new com.book.BookVO(); 와 같은 표현 --%>
		<jsp:useBean id="book" class="com.book.BookVO" /> 
		<%-- 
			이 작업을 아래 한 문장으로 가능
			<jsp:setProperty name="book" property="title" param="title" /> 
			<jsp:setProperty name="book" property="author" param="author" /> 
			<jsp:setProperty name="book" property="publisher" param="publisher" /> 
		--%>
		<jsp:setProperty name="book" property="*" />
		<%
			request.setAttribute("book", book); // request 객체의 속성 설정
		%>
		<jsp:forward page="bookOutput.jsp" />
		
	</body>
</html>