<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/common/common.jsp" %>	
		<style type="text/css">
			/* .container{
				width : 1000px;
				display: flex;
				justify-content: center;
			} */
			.gender {margin: 0 10px;}
		</style>
			
		<script type="text/javascript">
			$(function(){	
				let regMsg = "${regMsg}";
				if(regMsg!="")
					alert(regMsg);
				
				/* 아이디 입력시 중복 처리 이벤트 */
				$("#u_id").on("change", function(){
					userIdConfirm();
				});
				
				/* 저장 버튼 클릭시 처리 이벤트 */
				$("#userRegBtn").on("click", function(){
					if(!chkData("#u_id","아이디를")) return;
					else if(!chkData("#u_pw","비밀번호를")) return;
					//else if(!chkData("#u_pwConfirm","비밀번호 확인을")) return;
					else if($("#u_pw").val() != $("#u_pwConfirm").val()) {
						alert("비밀번호와 비밀번호 확인은 일치해야 합니다.\n 다시 입력해 주세요.");
						$("#u_pwConfirm").val("");
						$("#u_pwConfirm").focus();
						return;
					}
					else if(!chkData("#u_name","이름을")) return;
					else if(!chkData("#u_phone","전화번호를")) return;
					else if(!$("input[name='u_gender']").is(":checked")) {
						alert("성별을 선택해 주세요.");
						$("input[name='u_gender']:eq(0)").focus();
						return;
					}
					else {
						$("#f_writeForm").attr({
							"method" : "post",
							"action" : "/user/registerUser.do"
						});
						$("#f_writeForm").submit();
					}
				});
				
				/* 목록버튼 클릭시 처리 이벤트 */
				$("#boardListBtn").on("click", function(){
					//location.href = "/user/loginForm.do";
					location.href = "/board/getBoardList.do";
				});
			});
			
			/* 아이디 입력시 실질적인 처리 함수 */
			function userIdConfirm(){
				if(!chkData('#u_id','아이디를')) return; // 경고창 뜨는 것 대신 span 태그 사용
				// if(!dataCheck('#passwd','#msg','비밀번호를')) return; // common.js에 함수 생성
				else {
					$.ajax({
						url : "/user/idCheck.do", // 전송 url
						type : "post",					// 전송시 method 방식
						data : $("#u_id").serialize(), // 데이터 전송
						dataType : "text",
						error : function(){				// 실행시 오류가 발생했을 때
							alert("시스템 오류입니다. 관리자에게 문의하세요.");
						},
						success : function(resultData){	// 정상적으로 실행됐을 때 url에서 읽어온 결과값 매개변수로
							let goUrl = "";				// 이동할 경로를 저장할 변수
							if(resultData==0){			// 중복이 아닌 경우
								$("#msg").text("사용할 수 있는 아이디입니다.").css("color","green");
								$("#u_pw").select();
							} else if(resultData==1){	// 중복일 경우
								$("#msg").text("사용할 수 없는 아이디입니다.").css("color","red");
							}
						}
					});
				}
			}
		</script>
	</head>
	<body>
		
		<div class="container">
			<div class="text-center"><h3>회원가입 화면</h3></div>
			<form class="form-horizontal" id="f_writeForm">
				<div class="form-group">
					<label for="u_id" class="col-sm-2 control-label">아이디</label>
					<span id="msg"></span>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="u_id" name="u_id" placeholder="아이디 입력">
					</div>
				</div>
				<div class="form-group">
					<label for="u_pw" class="col-sm-2 control-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="u_pw" name="u_pw" placeholder="비밀번호 입력">
					</div>
				</div>
				<div class="form-group">
					<label for="u_pwConfirm" class="col-sm-2 control-label">비밀번호 확인</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="u_pwConfirm" name="u_pwConfirm" placeholder="비밀번호 확인">
					</div>
				</div>
				<div class="form-group">
					<label for="u_name" class="col-sm-2 control-label">이름</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="u_name" name="u_name" placeholder="이름 입력"/>
					</div>
				</div>
				<div class="form-group">
					<label for="u_email" class="col-sm-2 control-label">이메일</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="u_email" name="u_email" placeholder="이메일 입력"/>
					</div>
				</div>
				<div class="form-group">
					<label for="u_phone" class="col-sm-2 control-label">전화번호</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="u_phone" name="u_phone" placeholder="전화번호 입력"/>
					</div>
				</div>
				<div class="form-group">
					<strong class="col-sm-2 control-label">성별</strong>
					<div class="text-center">
						<label for="u_gender" class="gender" >남
							<input type="radio" name="u_gender" value="male"/>
						</label>
						<label for="u_gender" class="gender" >여
							<input type="radio" name="u_gender" value="female"/>
						</label>
					</div>
				</div>
	
				<%-- ==================== 버튼 출력 시작 ==================== --%>
	
				<div class="contentBtn text-center">
					<button type="button" id="userRegBtn" class="btn btn-primary">가입</button>
					<button type="button" id="boardListBtn" class="btn btn-primary">목록</button>
				</div>
	
			</form>
		</div>
	</body>
</html>