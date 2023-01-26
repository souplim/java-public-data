<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>책정보 출력 페이지 예제 : bookROutput.jsp</title>
		
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
		<%
			com.book.BookVO b = (com.book.BookVO)request.getAttribute("book");
			out.print(b.getTitle());
			out.print(b.getAuthor());
			out.print(b.getPublisher());
			out.print("<br/>");
		%>
		<label>책제목 : </label> ${ requestScope.book.title }<br/>
		<label>책저자 : </label> ${ book.author }<br/>
		<label>출판사 : </label> ${ book.publisher }<br/>
	</body>
</html>