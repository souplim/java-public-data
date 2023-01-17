<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>에러 페이지 - error500.jsp</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		<style type="text/css">
			#wrappper{ width: 680px; }
			#imgView { width: 100%; }
			#msgView { clear: both; float: none; }
			#msgView ul { padding-top: 5px; }
		</style>
	</head>
	<body>
		<div id="wrapper">
			<p>
				요청 처리 과정에서 예외가 발생하였습니다.<br/>
				빠른 시간 내에 문제를 해결하도록 하겠습니다.
			</p>
			<div id="imgView">
				<img src="../image/error.png"/>
			</div>
			<div id="msgView">
				<label>에러 타입:</label>
				<%=exception.getClass().getName() %><br/>
				<label>에러 메시지:</label><br/>
				<strong><%=exception.getMessage() %></strong>
			</div>
		</div>
	</body>
</html>