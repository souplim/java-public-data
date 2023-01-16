<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<% 
	// 웹 브라우저에서 서버로 넘어오는 파라미터 값에 한글이 있는 경우(POST) 한글 처리
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String scholarship = request.getParameter("scholarship");
	String major = request.getParameter("major");
	String[] platforms = request.getParameterValues("platform");
	String[] languages = request.getParameterValues("language");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>예제 request.jsp</title>
		
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
				display: flex;
				justify-content: center;
				align-items: center;
			}
			fieldset { width: 600px; }
			table {
				border: 1px solid black;
				width: 100%;
				border-spacing :0px; 
				border-collapse: collapse;
				background-color: #F7F7F7;
			}
			th, td {
				border-bottom: 1px solid black;
				padding: 6px;
			}
			th, .buttons {
				text-align: center;
			}
			td:nth-child(1) {
				text-align: center;
				border-right: 1px solid black;
			}
			.border-none { border-bottom: none; } 
		</style>
		
		<script type="text/javascript">
			$(function(){
				// post 방식 데이터 전송
				$("#btnInfo").click(function(){
					$("#dataForm").attr({
						"method" : "post",
						"action" : "request1.jsp"
					});
					$("#dataForm").submit();
				});
				
				// get방식 데이터 전송
				$("#btnInfo").click(function(){
					location.href="request1.jsp?name=<%=name%>&birth=<%=birth%>";
				});
			});
		</script>
	</head>
	<body>
		<form id="dataForm">
			<input type="hidden" name="name" value="<%=name%>" />
			<input type="hidden" name="birth" value="<%=birth%>" />
		</form>
		<!-- input값 출력 -->
		<div class="container">
			<fieldset>
				<legend>
					<strong>기술정보 이력서</strong>
					<button type="button" id="btnInfo">개인정보</button>				
				</legend>
				<table id="table1">
					<%-- <tr>
						<td>이름</td>
						<td><%= name %></td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td><%= birth %></td>
					</tr> --%>
					<tr>
						<td>학력</td>
						<td><%= scholarship %></td>
					</tr>
					<tr>
						<td>학과</td>
						<td><%= major %></td>
					</tr>
					<tr>
						<td>사용가능 플랫폼</td>
						<td>
						<% 
							for(String platform : platforms){
						%>
						
							<%= platform %>
						<%
							}
						%>
						</td>
					</tr>
					<tr>
						<td class="border-none">사용가능 언어</td>
						<td class="border-none">
							<%= Arrays.toString(languages) %>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
		<br/>
		<div class="container">
			<fieldset>
				<legend><strong>요청 정보</strong></legend>
				<table>
					<tr>
						<td>요청 방식</td>
						<td><%= request.getMethod() %></td>
					</tr>
					<tr>
						<td>요청 URL</td>
						<td><%= request.getRequestURL() %></td>
					</tr>
					<tr>
						<td>요청 URI</td>
						<td><%= request.getRequestURI() %></td>
					</tr>
					<tr>
						<td>클라이언트 주소</td>
						<td><%= request.getRemoteAddr() %></td>
					</tr>
					<tr>
						<td>프로토콜 방식</td>
						<td><%= request.getProtocol() %></td>
					</tr>
					<tr>
						<td>서버 이름</td>
						<td><%= request.getServerName() %></td>
					</tr>
					<tr>
						<td class="border-none">서버 포트 번호</td>
						<td class="border-none"><%= request.getServerPort() %></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</body>
</html>
