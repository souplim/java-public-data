<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<% // 웹 브라우저에서 서버로 넘어오는 파라미터 값에 한글이 있는 경우(POST) 한글 처리
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>Insert title here</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		
		<!-- jQuery Framework 참조하기 -->
		<script src="../js/jquery-3.6.2.min.js"></script>
		<script src="../js/common.js"></script>
		
		<style type="text/css">
			#container {
				/* display: flex; */
				width: 500px;
				margin: 0 auto;
				justify-content: center;
				align-items: center;
			}
			table {
				border: 1px solid black;
				width: 400px;
				border-spacing :0px; 
			}
			td {
				border-bottom: 1px solid black;
			}
			tr:nth-child(1), tr:nth-child(8){
				text-align: center;
			}
			td:nth-child(1) {
				text-align: center;
				border-right: 1px solid black;
			}
			.border-none { border-bottom: none; } 
		</style>
	</head>
	<body>
		<!-- input값 출력 -->
		<div id="container">
			<fieldset>
				<legend>
					<strong>개인정보</strong>				
				</legend>
				<table id="table1">
					<tr>
						<td>이름</td>
						<td><%= name %></td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td><%= birth %></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</body>
</html>