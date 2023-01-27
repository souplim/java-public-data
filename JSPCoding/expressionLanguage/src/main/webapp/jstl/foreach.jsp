<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.user.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSTL Core: forEach(foreach.jsp)</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		<style type="text/css">
			table{border-collapse:collapse}
			td{background-color:#F7F7F7; border: 1px solid #000000; padding:6px;} 
		</style>
	</head>
	<body>
		<h2>JSTL Core Tag: forEach</h2>
		<h3>배열 처리</h3>
		<c:set var="score" value="<%= new int[]{95,88,77,45,99} %>" />
		
		<c:set var="sum" value="0" />
		점수 :
		<c:forEach var="point" items="${ score }" >
			${ point }
			<c:set var="sum" value="${ sum + point }" />
		</c:forEach>
		<br/> 합 = ${ sum } <br/>
		
		<h3>1부터 100까지 합</h3>
		<c:set var="sum" value="0" />
		<c:forEach var="i" begin="1" end="100" >
			<c:set var="sum" value="${ sum + i }" />
		</c:forEach>
		결과 = ${ sum } <br/>
		
		<h3>Map인 sessionScope 처리</h3>
		<c:set target="${ sessionScope }" property="name" value="홍길동" />
		<c:set target="${ sessionScope }" property="id" value="dong" />
		<c:set target="${ sessionScope }" property="passwd" value="1234" />
		
		<c:forEach var="i" items="${ sessionScope }" >
			${i.key} = ${i.value}<br/>
		</c:forEach>
		<!-- delim=" ,.은로서된다" -> 명사만 남기고 구분하기 -->
	</body>
</html>