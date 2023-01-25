<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>서브릿으로부터 전달받은 속성 출력</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		
		<style type="text/css">
		
		</style>
	</head>
	<body>
		<h3>서블릿으로부터 전달받은 속성 출력</h3>
		<table>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>회원이름</th>
				<th>이메일</th>
				<th>회원주소</th>
				<th>회원우편번호</th>
			</tr>
			<tr>
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.address.city}</td>
				<td>${member.address.zipcode}</td>
			</tr>
		</table>
	</body>
</html>