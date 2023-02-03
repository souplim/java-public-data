<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/common/common.jsp" %>
	<style type="text/css">
		#content{resize: none;}
	</style>
	</head>
	<body>
		<script type="text/javascript">
		$(function(){
			let msg = "${errorMsg}";
			if(msg!="")
				alert(msg);
			
			/* 라디오 버튼 가져와서 체크하기 */
			//var genderVal = $('input[name="u_gender"]:checked').val();
			//$('input[name="u_gender"]').val(['genderVal']);
			
			$("input[name='u_gender']").each(function() {
				$(this).prop("checked", $(this).val() == "${updateData.u_gender}");
			});
			
			/* 수정 버튼 클릭 시 처리 이벤트 */
			$("#userUpdateBtn").on("click", function(){
				if(!chkData("#u_pw","비밀번호를")) return;
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
					$("#f_updateForm").attr({
						"method" : "post",
						"action" : "/user/updateUser.do"
					});
					$("#f_updateForm").submit();
				}
			});
			
			/* 목록 버튼 클릭 시 처리 이벤트 */
			$("#boardListBtn").on("click", function(){
				location.href = "/board/getBoardList.do";
			});
			
		});
		
	</script>
	</head>
	<body>
		<div class="container">
			<div class="text-center"><h3>회원정보 수정</h3></div>
			<div class="text-center">
				<form name="f_updateForm" id="f_updateForm">
					<table class="table table-bordered">
						<tr>
							<td class="text-center">아이디</td>
							<td colspan="3" class="text-left">${updateData.u_id}
								<!-- id 수정 기능 -->
								<%-- <input type="text" class="form-control" name=u_id id="u_id" value="${updateData.u_id}"/>
								<span id="msg"></span> --%>
							</td>
						</tr>
						<tr>
							<td class="text-center">비밀번호</td>
							<td colspan="3">
								<input type="password" class="form-control" name=u_pw id="u_pw" value="${updateData.u_pw}"/>
							</td>
						</tr>
						<tr>
							<td class="text-center">비밀번호 확인</td>
							<td colspan="3">
								<input type="password" class="form-control" name="u_pwConfirm" id="u_pwConfirm" value="${updateData.u_pw}"/>
							</td>
						</tr>
						<tr>
							<td class="text-center">이름</td>
							<td colspan="3">
								<input type="text" class="form-control" name="u_name" id="u_name" value="${updateData.u_name}"/>
							</td>
						</tr>
						<tr>
							<td class="text-center">이메일</td>
							<td colspan="3">
								<input type="text" class="form-control" name="u_email" id="u_email" value="${updateData.u_email}"/>
							</td>
						</tr>
						<tr>
							<td class="text-center">전화번호</td>
							<td colspan="3">
								<input type="text" class="form-control" name="u_phone" id="u_phone" value="${updateData.u_phone}"/>
							</td>
						</tr>
						<tr>
							<td class="text-center">성별</td> <!-- 라디오 버튼 가져와 check 어떻게? -->
							<td colspan="3">
								<label for="u_gender">남
									<input type="radio" class="gender" name="u_gender" value="male"/>
								</label>
								<label for="u_gender">여
									<input type="radio" class="gender" name="u_gender" value="female"/>
								</label>				
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			<%-- ======== 비밀번호 확인 버튼 및 버튼 추가 시작 ======== --%>
			<div class="text-right">
				<button type="button" id="userUpdateBtn" class="btn btn-primary btn-sm">수정</button>
				<button type="button" id="boardListBtn" class="btn btn-primary btn-sm">목록</button>
			</div>
		</div>
	</body>
</html>