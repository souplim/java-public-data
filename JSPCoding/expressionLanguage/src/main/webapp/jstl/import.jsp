<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSTL Core: import(import.jsp)</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		<style type="text/css">
			div.target{margin:5px;}
		</style>
	</head>
	<body>
		<!-- import할 때 css, js 파일 때문에 깨질 수 있음 -->
		<h2>JSTL Core: import(현재 페이지 제목)</h2>
		<div class="target">
			<c:import url="./foreach.jsp" />
			<hr/>
		</div>
		<c:import url="settarget.jsp" var="target" />
		
		<div class="target">
			<c:import url="/jstl/if.jsp" context="${pageContext.request.contextPath}">
				<c:param name="jumsu" value="88"/>
				<c:param name="name" value="java"/>
				<c:param name="age" value="30"/>
			</c:import>
			<hr/>
		</div>
		<div class="target">
			${target}
		</div>
		<hr/>
		
		<div class="target">
			<c:import url="http://localhost:8080/servletExample/select" />
			<hr/>
		</div>
		
		<c:import url="https://www.naver.com" var="naver" />
		<p>${naver}</p>
		
		<c:url var="urlheader" value="header.jsp">
			<c:param name="id" value="javauser" />
		</c:url>
		
		<h3>&lt;c:url&gt; 과 &lt;c:param&gt; 태그의 처리 결과 : ${urlheader}</h3>
		<%-- <a href="${urlheader}">클릭</a><br/> --%>
		<c:import url="${urlheader}" var="head" />
		<c:import url="https://tomcat.apache.org/" var="tomcat" />
	
		<div id="one">
			${head}
		</div>
		
		${tomcat}
	</body>
</html>
