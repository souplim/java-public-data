<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.mvc.user.controller.SessionListener"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<style type="text/css">
</style>
<script type="text/javascript">
			$(function(){
				$("#returnBtn").click(function(){
					location.href="/board/getBoardList.do";
				});
			})
		</script>
</head>
<body>
	<!-- 관리자가 아닐 경우 로그인 페이지로 보내기 -->
	<c:if test="${sessionScope.loginfo.u_st!=9}">
		<jsp:forward page="/user/loginForm.do" />
	</c:if>
	<div class="container">
		<c:import url="/WEB-INF/user/mypage.jsp" />
		<div class="text-center">
			<h3>유저 리스트</h3>
		</div>
		<!--			
			<form name="detailForm" id="detailForm">
				<input type="hidden" name="num" id="num" />
			</form>
 		 -->
		<c:set var="count" value="${SessionListener.getCount()}" />
		<c:set var="loginCount" value="${SessionListener.getLoginCount()}" />
		<c:set var="normalCount" value="${SessionListener.getNormalCount()}" />
		<div class="row">
			<div class="pull-right">
				접속 중인 총 유저 수 : ${count}<br /> 
				로그인 중인 회원 수 : ${loginCount}<br />
				로그인하지 않은 유저 수 : ${normalCount}<br />
			</div>
		</div>
		<%-- =================== 리스트 시작  ================== --%>
		<div id="boardList">
			<table summary="유저 리스트" class="table">
				<thead>
					<tr>
						<th class="col-md-1 text-center">아이디</th>
						<th class="col-md-1 text-center">비밀번호</th>
						<th class="col-md-1 text-center">상태</th>
						<th class="col-md-1 text-center">이름</th>
						<th class="col-md-1 text-center">이메일</th>
						<th class="col-md-1 text-center">전화번호</th>
						<th class="col-md-1 text-center">성별</th>
						<th class="col-md-1 text-center">가입일</th>
						<th class="col-md-1 text-center">접속여부</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list}">
							<c:forEach var="vo" items="${list}">
								<tr class="text-center" data-id="${vo.u_id}">
									<td>${vo.u_id}</td>
									<td>${vo.u_pw}</td>
									<td>
										<c:if test="${vo.u_st==0}">일반회원</c:if> 
										<c:if test="${vo.u_st==1}">탈퇴회원</c:if> 
										<c:if test="${vo.u_st==9}">관리자</c:if>
									</td>
									<td>${vo.u_name}</td>
									<td>${vo.u_email}</td>
									<td>${vo.u_phone}</td>
									<td>
										<c:if test="${vo.u_gender=='male'}">남자</c:if> 
										<c:if test="${vo.u_gender=='female'}">여자</c:if>
									</td>
									<td>${vo.u_regday}</td>

									<td>
										<c:set var="isConnected" value="${SessionListener.isConnected(vo.u_id)}" /> 
										<c:if test="${isConnected}">접속중</c:if> 
										<c:if test="${!isConnected}">미접속</c:if>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5" class="text-center">등록된 회원이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>

		<div class="contentBtn text-right">
			<button type="button" id="returnBtn" class="btn btn-default btn-sm">돌아가기</button>
		</div>

	</div>
</body>
</html>