<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSTL Core: if(if.jsp)</title>
		
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
		<h3>JSTL Core Tag: if</h3>
		
		<c:set var="num" value="95" />
		점수 ${ num }은
		<c:if test="${ num > 60 }" var="result">
			합격입니다.<br/>
		</c:if>
		if문의 결과 : ${ result }<br/>
		
		<c:set var="number" value="4" />
		숫자 ${ number }은
		<c:if test="${ number mod 2 == 0 }">
			짝수
		</c:if>
		<c:if test="${ number mod 2 != 0 }">
			홀수
		</c:if>
		입니다. <br/>
		
		<h3>JSTL Core Tag: choose</h3>
		<%-- <c:set var="today" value="<%= new java.util.Date() %> --%>
		<jsp:useBean id="today" class="java.util.Date" />
		<c:choose>
			<c:when test="${ today.hours <12 }">
				Good morning!
			</c:when>
			<c:when test="${ today.hours <18 }">
				Good afternoon!
			</c:when>
			<c:otherwise>
				Good evening!
			</c:otherwise>
		</c:choose>
		<hr />
		
		<c:set var="jumsu" value="${ param.jumsu }" />
		점수 : <c:out value="${ jumsu }" default="0" />점 / 학점 : 
		<c:choose>
			<c:when test="${ jumsu >= 90 }">
				A
			</c:when>
			<c:when test="${ jumsu >= 80 }">
				B
			</c:when>
			<c:when test="${ jumsu >= 70 }">
				C
			</c:when>
			<c:when test="${ jumsu >= 60 }">
				D
			</c:when>
			<c:otherwise>
				F
			</c:otherwise>		
		</c:choose>
		학점.
		
		<h3>JSTL Core Tag: if와 choose</h3>
		<!-- 
			get방식으로 parameter 주고난 다음 확인 
			if.jsp?jumsu=90&name=java&age=30
		 -->
		<c:if test="${ empty param.name and empty param.age }" >
		 	<h3>name=xxx&amp;age=xxx 의 형식으로 Query 문자열을 전달하세요.</h3>
		</c:if>
		
		<c:if test="${ not empty param.name and not empty param.age }">
			<c:if test="${ param.name == 'java' }">
				name 파라미터의 값이 ${ param.name } 입니다.<br/>
			</c:if>
			
			<c:if test="${ param.age >= 30 }">
				당신의 나이는 30세 이상입니다.
			</c:if>
			<c:if test="${ param.age < 30 }">
				당신의 나이는 30세 미만입니다.
			</c:if>
			<hr/>
			
			<ul>
			<c:choose>
				<c:when test="${ param.name == 'java' }">
					<li>당신의 이름은 ${ param.name }입니다.</li>
				</c:when>
				<c:when test="${ param.age >= 30 }">
					<li>당신의 나이는 30세 이상입니다.</li>
				</c:when>
				<c:otherwise>
					<li>당신은 'java'도 아니고 30세 이상도 아닙니다.</li>
				</c:otherwise>
			</c:choose>
			</ul>
		</c:if>
	</body>
</html>