<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/common/common.jsp" %>
		<style type="text/css">
		
		</style>
		<script type="text/javascript">
			$(function(){
				let regMsg = "${regMsg}";
				if(regMsg!="")
					alert(regMsg);
				
				let msg = "${errorMsg}";
				if(msg!=""){
					alert(msg);
				}
			
				/* 로그인 버튼 클릭 시 처리 이벤트 */
				$("#loginBtn").click(function(){
					//입력값 체크
					if (!chkData("#u_id","아이디를"))	return;
					else if (!chkData("#u_pw","비밀번호를"))	return;
					else {
						$("#f_loginForm").attr({
							"method":"post",
							"action":"/user/loginSession.do"
						});
						$("#f_loginForm").submit();
					}
				});
				
				/*회원가입 버튼 클릭 시 처리 이벤트*/
				$("#regiBtn").click(function(){
					location.href="/user/registerForm.do";
				});
				/* 돌아가기 버튼 클릭 시 처리 이벤트 */
				$("#returnBtn").click(function(){
					location.href="/board/getBoardList.do";
				});
				
				/* 뒤로 가기 방지 */
				history.forward(); // 브라우저가 세션 기록의 바로 앞 페이지로 이동하도록 지시
			});
		</script>
	</head>
	<body>
		<div class="text-center"><h3>로그인 화면</h3></div>
		<br/>
		<div class="container">
			<div class="text-center">
			<form class="form-horizontal" id="f_loginForm">
			<div class="form-group">
				<label class="control-label col-sm-2" for="u_id">아&nbsp;이&nbsp;디</label>
				<div class="col-sm-8 has-success has-feedback">
					<input type="text" class="form-control" name="u_id" id="u_id">
					<span id="u_idSuccess" aria-hidden="true"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="passwd">비밀번호</label>
				<div class="col-sm-8 has-success has-feedback">
					<input type="password" class="form-control" name="u_pw" id="u_pw">
					<span id="u_pwSuccess" aria-hidden="true"></span>
				</div>
			</div>
			<div class="text-center">
				<button type="button" class="btn btn-primary" id="returnBtn">돌아가기</button>
				<button type="button" class="btn btn-primary" id="loginBtn">로그인</button>
				<button type="button" class="btn btn-primary" id="regiBtn">회원가입</button>
			</div>
			</form>
			</div>
		</div>
	</body>
</html>