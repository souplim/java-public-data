<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSP 예제 out.jsp</title>
		
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
			int bufferSize = out.getBufferSize(); // 버퍼크기 얻어냄(8KB : 8192byte)
			out.print("첫번째 텍스트입니다.");
			out.clearBuffer();
		%>
		<h3>out 객체 예제 - getBufferSize(), getRemaining(), println() 메소드 사용</h3>
		<%
			int remainSize = out.getRemaining(); // 남은 버퍼의 크기 얻어냄
			int usedSize = bufferSize - remainSize; // 사용한 버퍼 크기 얻어냄
			boolean isAuto = out.isAutoFlush();
		%>
		<p>현재 페이지의 버퍼 사용현황</p>
		<ul>
			<li>출력 버퍼의 전체 크기 : <%=bufferSize%>byte</li>
			<li>현재 사용한 버퍼의 크기 : <%=usedSize%>byte</li>
			<li>남은 버퍼의 크기 : <%=remainSize%>byte</li>
			<li>autoFlush 여부 : <%=isAuto%></li>
		</ul>
		<h3>out.print() 메서드</h3>
		<%
			out.print(100);
			out.print(true);
			out.print(3.14);
			out.print("TEST");
			out.print('가');
			out.print("<br />버퍼의 크기 : "+out.getRemaining());
		%>
	</body>
</html>