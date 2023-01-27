<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSTL Core: set(setvar.jsp)</title>
		
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
		<h2>JSTL Core Tag: set</h2>
		<%-- 
			pageContext.setAttribute("setStr","set Tag 테스트입니다.");
			out.print(pageContext.getAttribute("setStr"));
		 --%>
		 <c:set var="setStr" value="set Tag 테스트입니다." scope="page" />
		 \${ pageScope.setStr } = ${ pageScope.setStr }<br/>
		 
		 <c:set var="n">
		 	24
		 </c:set>
		 \${ n } = ${ n } <br/>
		 
		 <c:set var="d">
		 	31.54
		 </c:set>
		 \${d} = ${d} <br/>
		 \${n + d} = ${n + d}<br/>
		 
		 <c:set var="b" value="true" />
		 \${!b} = ${!b} <br/> 
		 
		 <%--
		 	session.setAttribute("str","Hello set Tag!!!");
		 	out.print(session.getAttribute("str"));
		  --%>
		  <c:set var="str" value="Hello set Tag!!!" scope="session" />
		  \${str}= ${str} <br/>
		  \${sessionScope.str} = ${sessionScope.str} <br/>
		  
		  <c:remove var="str" scope="page" /> <%--영역 다르므로 제거 안 됨 --%>
		  \${str} = ${str} <br/>
		  
		  <c:remove var="str" scope="session" /> <%-- <c:remove var="str" /> --%>
		  \${str} = ${str} <br/>
	</body>
</html>