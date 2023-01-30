<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSTL Core: set target(settarget.jsp)</title>
		
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
		<h2>JSTL Core Tag: set target</h2>
		<jsp:useBean id="oneday" class="java.util.Date" />
		<c:set target="${oneday}" property="year" value="2022" />
		<p>\%{oneday.year} = ${oneday.year}</p>
		
		<%--
			com.user.User member = new com.user.User();
			member.setUname("홍길동");
			out.print(member.getUname());
		 --%>
		 
		<jsp:useBean id="member" class="com.user.User" /> <%-- 인스턴스 생성 --%>
		<c:set target="${ member }" property="uname" value="홍길동" /> <%-- 설정자 호출 --%>
		\${ member.uname } = ${ member.uname }							<%-- 접근자 호출 후 출력 --%>

		<c:set var="book" value="<%= new java.util.HashMap<String, String>() %>" />
		
		<c:set target="${ book }" property="java" value="자바로 배우는 프로그래밍 기초" />
		<c:set target="${ book }" property="c" value="c로 배우는 프로그래밍 기초" />
		<c:set target="${ book }" property="jsp" value="JSP로 배우는 웹프로그래밍 기초" />
		
		<p>\${book.java} = ${book.java}</p>
		<p>\${book.c} = ${book.c}</p>
		<p>\${book.jsp} = ${book.jsp}</p>
	</body>
</html>
