<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>내장객체 예제 - application.jsp</title>
		
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
		<h4>applicatoin 내장객체 예제 application.jsp</h4>
		<%
			String serverInfo = application.getServerInfo();
			String realPath = application.getRealPath("/");
		%>
		Server : <%= serverInfo %><br/>
		서블릿 버전 : <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br/>
		Path of Document : <%= realPath %><br/>
		
		<%
			Set<String> set = application.getResourcePaths("/");
		
			if(set != null){
				Object[] obj = set.toArray();
				for(Object o : obj){
					out.print(o+"<br/>");
				}
			}
		%>
	</body>
</html>