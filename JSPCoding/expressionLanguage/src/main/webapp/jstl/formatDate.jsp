<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>formatDate - formatDate.jsp</title>
		
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
		<%--
			formatDate
			- value : 날짜 또는 시간
			- type : date(날짜-기본값), time(시간), both(날짜와 시간)
			- dateStyle / timeStyle
		 --%>
		 
		 <h4>formatDate 태그에서 type 속성 확인</h4>
		 <p>
		 	<c:set var="now" value="<%= new java.util.Date() %>" />
		 	<fmt:formatDate type="date" value="${ now }"/><br/>
		 	<fmt:formatDate type="time" value="${ now }"/><br/>
		 	<fmt:formatDate type="both" value="${ now }"/><br/>
		 </p>
		 <h4>formatDate 태그에서 dateStyle, timeStyle 속성 확인</h4>
		 <p>
		 	<fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}"/><br/>
		 	<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now}"/><br/>
		 	<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}"/><br/>
		 </p>
		 
		 <h4>formatDate 태그에서 pattern 속성 확인</h4>
		 <p>
		 	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${now}" /><br/>
		 </p>
		 
		 <h4>parseDate 태그에서 문자열을 날짜형으로 파싱</h4>
		 <p>
		 	<fmt:parseDate value="2020-01-01 09:00:00" pattern="yyyy-MM-dd HH:mm:ss" var="date" />
			<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss" value="${ date }" />
		 </p>
	</body>
</html>