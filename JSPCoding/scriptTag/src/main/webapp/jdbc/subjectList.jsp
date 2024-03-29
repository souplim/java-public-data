<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.subject.SubjectDAO, com.subject.SubjectVO" %>
<%
	ArrayList<SubjectVO> list = (ArrayList<SubjectVO>)request.getAttribute("list"); // 전체 조회하기 위해 인자로 null값 주기
	int counter = list.size();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>자바 빈즈를 이용한 subject테이블 조회 예제 : subjectList.jsp</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		<style type="text/css">
			body { font:12px/2em "돋움"; }
			
			div#subjectList{width:600px; float: left;}
			div#subjectList table{border-collapse:collapse; width:600px; margin:0 auto; margin-top:8px;}
			div#subjectList thead > div#subjectList tr{background-color:#ececec}
			div#subjectList th, div#subjectList td{border:1px solid black;}
			
			.tc{text-align:center;}
			.tl{text-align:left;}
			.tr{text-align:right;}
		</style>
		
		<!-- jQuery Framework 참조하기 -->
		<script type="text/javascript" src="/scriptTag/js/jquery-3.6.2.min.js"></script>
		<script type="text/javascript">
			$(function(){
				// 학과 정보 등록 버튼 제어
				$("#subjectInsert").click(function(){
					location.href="<%=request.getContextPath()%>/jdbc/subjectForm.jsp";
				});
			});
		</script>
	</head>
	<body>
		<h3>자바 빈즈 SubjectDAO를 통해 subject 테이블 조회 프로그램</h3>
		<hr/>
		<div id="subjectList">
			<div class="tr"><input type="button" value="학과정보등록" id="subjectInsert" /></div>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>학과번호</th>
						<th>학과명</th>
					</tr>
				</thead>
				
				<tbody>
					<%
						if(counter >0){
							for(SubjectVO sub : list){
					%>
							<tr class="tc" data-no="<%= sub.getNo() %>"> <!-- 삭제하거나 상세페이지 갈 때 용이 -->
								<td><%= sub.getNo() %></td>
								<td><%= sub.getS_num() %></td>
								<td><%= sub.getS_name() %></td>
							</tr>
					<%
							}
						} else {
					%>	
							<tr>
								<td colspan="3" class="tc">조회된 학과 정보가 존재하지 않습니다.</td>
							</tr>
					<% } %>		
				</tbody>
			</table>
			<div class="tr">조회된 학과 수는 <span id="counter"><%=counter%></span>입니다.</div>
		</div>
	</body>
</html>
