<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException, java.io.FileReader, java.io.BufferedReader" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSTL Core: out(out.jsp)</title>
		
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
		<h2>JSTL Core Tag: out</h2>
		
		<c:out value="<hr/>" escapeXml="true"/> <!-- <hr/> 그대로 출력 -->
		<c:out value="<hr/>" escapeXml="false"/> <!-- 밑줄 출력 -->
		
		<p>
			<c:out value="${param.userid}">
				파라미터값이 존재하지 않습니다.
			</c:out>
		</p>
		
		<c:out value="${param.userid}" default="파라미터값이 존재하지 않습니다." />
		<p>\${param.userid} = ${param.userid}</p>
	</body>
</html>