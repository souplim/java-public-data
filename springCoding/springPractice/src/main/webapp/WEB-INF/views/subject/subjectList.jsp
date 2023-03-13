<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>subjectList.jsp</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="/resources/image/icon.png" />
		<link rel="apple-touch-icon" href="/resources/image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="/resources/js/html5shiv.js"></script>
		<![endif]-->
		
		<link rel="stylesheet" type="text/css" href="/resources/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/resources/dist/css/bootstrap-theme.min.css" />
	
		<script type="text/javascript" src="/resources/js/jquery-3.6.2.min.js"></script>
		<script type="text/javascript" src="/resources/dist/js/bootstrap.min.js"></script>

	</head>
	<body>
		<div class="container">
			<div class="text-center"><h2>학과 테이블 정보</h2></div>
			
			<!-- 컬럼들은 모바일과 데스크탑에서 항상 50% 너비가 됨 -->
			<div class="row">
				
				<div class="col-xs-6">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>번호</th>
								<th>학과번호</th>
								<th>학과명</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty subjectList}"> <!-- jstl Collection의 null 체크 -->
									<c:forEach var="subject" items="${subjectList}">
										<tr>
											<td>${subject.no}</td>
											<td>${subject.s_num}</td>
											<td>${subject.s_name}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="3">등록된 학과 정보가 존재하지 않습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
				<div class="col-xs-6">
					<c:import url="http://localhost:8080/subject/insertForm" />
				</div>
			</div>
		</div>
	</body>
</html>