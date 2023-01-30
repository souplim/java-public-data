<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSTL Core: remove(remove.jsp)</title>
		
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
		<h2>JSTL Core Tag: remove</h2>
		<c:set var="str" value="Hello set Tag!!!" scope="session" />
		\${str} = ${str} <br/>
		\${sessionScope.str} = ${sessionScope.str}<br/>
		
		<c:remove var="str" scope="page" />
		\${str} = ${str} <br/>
		<c:remove var="str" scope="session" />
		\${str} = ${str} <br/>
		
		<c:set var="app" value="응용프로그램변수" scope="application" />
		\${app} = ${app} <br/>
		<c:remove var="app"/>
		\${app} = ${app} <br/>
	</body>
</html>