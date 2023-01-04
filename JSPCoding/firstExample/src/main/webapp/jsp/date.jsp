<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%@ page import="example.Clock" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSP 예제 파일 : date.jsp</title>
		
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
		Date nowDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		String formatDate = dateFormat.format(nowDate);
	%>
	<p>
		일반적인 JSP 페이지의 형태로 아래와 같이 현재 날짜를 제공합니다.<br/>
		현재 날짜는 <%=formatDate%> 입니다.
	</p>
	
	<% 
		// example 패키지의 Clock 클래스를 생성하여 오늘 날짜와 시간을 출력해주세요.
		/* SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String formatTime = timeFormat.format(nowDate); */
		
		Clock clock = new Clock();
		String data = clock.now();
		// out.print("현재 날짜는"+data+"입니다.");
	%>
	<p>
		현재 날짜 및 시간은 <%=data%> 입니다. <%-- 표현식이라고 함. 서블릿으로 변경 --%>
	</p>
	</body>
</html>