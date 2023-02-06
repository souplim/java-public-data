<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
	.nameBox{
		padding:10px;
		margin:5px 0px;
		font-weight:bold;
	}
	.comp-box{
		border:1px solid #ccc;
	}
</style>
<script type="text/javascript">
	$(function(){
		$("#loginBtn_m").click(function(){
			location.href="/user/loginForm.do";
		});

		$("#regiBtn_m").click(function(){
			location.href="/user/registerForm.do";
		});
		
		$("#logoutBtn_m").click(function(){
			//if(confirm("정말 로그아웃 하시겠습니까?")){location.href="/user/logout.do";}
			if(confirm("정말 로그아웃 하시겠습니까?")){
				$.ajax({
					async : true, // 응답 결과와는 상관없이 동작함
					cache : false,
					url : "/user/logout.do",
					type : "post",
					error : function(){
						alert("시스템 오류입니다. 관리자에게 문의하세요.");
					},
					success : function(data){
						location.href = "/user/loginForm.do";
						history.go(); // 현재 페이지를 새로고침(초기화)
					}
				})
			}
		});
		
		$("#editInfo_m").click(function(){
			//location.href="/user/detailUser.do?u_id=${sessionScope.loginfo.u_id}";
			location.href="/user/detailUser.do";
		});
		
		$("#userList_m").click(function(){
			location.href="/user/getUserList.do";
		});
		
		/* 뒤로 가기 방지 */
		//history.forward(); // 브라우저가 세션 기록의 바로 앞 페이지로 이동하도록 지시
	});
</script>
<div class="row">
<div class="pull-right">
	<c:if test="${sessionScope.loginfo==null}">
		<div class="row text-center nameBox">
			<span>로그인해 주세요</span>
		</div>
		<div class="row text-center">
			<button type="button" class="btn btn-primary" id="loginBtn_m">로그인</button>
			<button type="button" class="btn btn-primary" id="regiBtn_m">회원가입</button>
		</div>
	</c:if>
	<c:if test="${sessionScope.loginfo!=null}">
		<div class="row text-center nameBox">
			<span>${sessionScope.loginfo.u_name}님 환영합니다.</span>
		</div>
		<div class="row text-center">
			<button type="button" class="btn btn-primary" id="logoutBtn_m">로그아웃</button>
			<button type="button" class="btn btn-primary" id="editInfo_m">회원정보</button>
			<c:if test="${sessionScope.loginfo.u_st==9}">
				<button type="button" class="btn btn-primary" id="userList_m">회원관리</button>
			</c:if>
		</div>
	</c:if>
</div>
</div>