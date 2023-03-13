<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %> <!--  boardDetail에 삽입됨 -->
	
	<style type="text/css">
		
	</style>
	<script type="text/javascript">
		let buttonCheck = 0; // 수정버튼과 삭제버튼을 구별하기 위한 변수
		
		$(function(){
			$("#pwdChk").css("visibility","hidden");
			
			/* 수정 버튼 클릭 시 처리 이벤트 */
			$("#updateFormBtn").click(function(){
				/* $("#dataForm").attr({
					"method" : "get",
					"action" : "/board/updateForm"
				});
				$("#dataForm").submit(); */
				
				$("#pwdChk").css("visibility","visible");
				$("#msg").text("작성시 입력한 비밀번호를 입력해주세요.").css("color","#000099");
				buttonCheck = 1;
			});
			
			/* 삭제 버튼 클릭 시 처리 이벤트 */
			/* $("#boardDeleteBtn").click(function(){
				//$("#dataForm").attr({
				//	"method" : "get",
				//	"action" : "/board/boardDelete"
				//});
				//$("#dataForm").submit();
				
				$("#pwdChk").css("visibility","visible");
				$("#msg").text("작성시 입력한 비밀번호를 입력해주세요.").css("color","#000099");
				buttonCheck = 2;
			}); */
			
			/* 삭제 버튼 클릭 시 댓글 확인 후 처리 이벤트 */
			$("#boardDeleteBtn").click(function(){
				$.ajax({
					url : "/board/replyCnt",
					type : "post",
					data : "b_num="+$("#b_num").val(),
					dataType : "text",
					error : function(){
						alert("시스템 오류. 관리자에게 문의하세요");
					},
					success : function(resultData){
						if(resultData==="0"){ // 댓글이 존재하지 않을 경우 "0" or 0
							$("#pwdChk").css("visibility","visible");
							$("#msg").text("작성시 입력한 비밀번호를 입력해주세요.").css("color","#000099");
							buttonCheck = 2;
						} else {
							alert("댓글 존재시 게시물을 작성할 수 없습니다.\n댓글 삭제 후 다시 확인해주세요.");
							return;
						}
					}
				});
			});
			
			/* 비밀번호 입력 양식 enter 제거 
			 * form 안에 input 1개면 enter는 submit의 기능을 가지므로 무력화 */
			$("#b_pwd").bind("keydown", function(event){
				if(event.keyCode === 13){ // 0=="0" -> 값 비교(true) / 0 === "0" -> 값과 자료형 비교(false)
					event.preventDefault();
				}
			});
			
			/* 비밀번호 확인 버튼 클릭시 처리 이벤트 */
			$("#pwdBtn").on("click", function(){
				boardPwdConfirm();
			});
			/* 비밀번호 취소 버튼 클릭시 처리 이벤트 */
			$("#pwdCancelBtn").on("click", function(){
				$(this).val("");
			});
			
			/* 글쓰기 버튼 클릭 시 처리 이벤트 */
			$("#insertFormBtn").click(function(){
				location.href="/board/writeForm";
			});
			
			/* 목록 버튼 클릭 시 처리 이벤트 */
			$("#listBtn").click(function(){
				location.href="/board/boardList";
			});

		});
		
		/* 비밀번호 클릭 시 실질적인 처리 함수 */
		function boardPwdConfirm(){
			if(!checkForm("#b_pwd","비밀번호를")) return;
			else {
				$.ajax({
					url : "/board/pwdConfirm",				// 전송 url
					type : "post",							// 전송 시 method 방식
					data : $("#f_pwd").serialize(),			// 폼 전체 데이터 전송
					dataType : "text",
					error : function(){						// 실행시 오류가 발생했을 경우
						alert('시스템 오류입니다. 관리자에게 문의하세요.');
					},
					success : function(resultData){			// 정상적으로 실행되었을 경우
						let goUrl = "";						// 이동할 경로를 저장할 변수
						if(resultData=="실패"){				// 일치하지 않는 경우
							$("#msg").text("작성시 입력한 비밀번호가 일치하지 않습니다.").css("color","red");
							$("#b_pwd").select();
						} else if(resultData=="성공")	{		//일치할 경우
							$("#msg").text("");
							if(buttonCheck==1){					// 수정버튼 클릭시
								goUrl = "/board/updateForm";
								$("#f_pwd").attr({
									"method" : "post",
									"action" : goUrl
								});
								$("#f_pwd").submit();
							} else if(buttonCheck==2) {			// 삭제버튼 클릭시
								goUrl = "/board/boardDelete";
								$("#f_data").attr({
									"method" : "post",
									"action" : goUrl
								});
								$("#f_data").submit();
							}
						}
					}
				});
			}
		}
	</script>
	</head>
	<body>
		<div class="contentContainer container">
			<%-- ================= 비밀번호 확인 버튼 및 버튼 추가 시작 ================= --%>
			<div id="boardPwdBtn" class="text-center">
				<div id="pwdChk" class="authArea col-md-8 text-left">
					<form name="f_pwd" id="f_pwd" class="form-inline">
						<input type="hidden" name="b_num" id="b_num" value="${boardVO.b_num}" />
						<label for="b_pwd" id="l_pwd">비밀번호 : </label>
						<input type="password" name="b_pwd" id="b_pwd" class="form-control"/>
						
						<button type="button" class="btn btn-default" id="pwdBtn">확인</button>
						<button type="button" class="btn btn-default" id="pwdCancelBtn">취소</button>
						<span id="msg"></span>
					</form>
				</div>
				<div class="btnArea col-md-4 text-right">
					<button type="button" class="btn btn-success" id="updateFormBtn">수정</button>
					<button type="button" class="btn btn-success" id="boardDeleteBtn">삭제</button>
					<button type="button" class="btn btn-success" id="insertFormBtn">글쓰기</button>
					<button type="button" class="btn btn-success" id="listBtn">목록</button>
				</div>				
			</div>
			
			<%-- ================= 리스트 시작 ================= --%>
			<div class="contentTB text-center">
				<table class="table table-bordered">
					<tr>
						<td class="col-md-3">작성자</td>
						<td class="col-md-3 text-left">${boardVO.b_name}</td>
						<td class="col-md-3">작성일</td>
						<td class="col-md-3 text-left">${boardVO.b_date}</td>
					</tr>
					<tr>
						<td class="col-md-4">글제목</td>
						<td colspan="3" class="col-md-8 text-left">${boardVO.b_title}</td>
					</tr>
					<tr class="table-tr-height">
						<td class="col-md-4">글내용</td>
						<td colspan="3" class="col-md-8 text-left">${boardVO.b_content}</td>
					</tr>
					
					<c:if test="${not empty boardVO.b_file}">
						<tr>
							<td class="col-md-4">이미지</td>
							<td colspan="3" class="col-md-8 text-left">
								<img src="/uploadStorage/board/${boardVO.b_file}" />
							</td>
						</tr>
					</c:if>
				</table>
			</div>
			
			<form name="f_data" id="f_data" method="post">
				<input type="hidden" name="b_num" value="${boardVO.b_num}" />
				<input type="hidden" name="b_file" value="${boardVO.b_file}" />
				<input type="hidden" name="b_thumb" value="${boardVO.b_thumb}" />
			</form>
			
			<%-- ================= 상세정보 보여주기 종료 ================= --%>
			<jsp:include page="reply.jsp" /> <!-- 별도의 서블릿이 만들어짐 -->
		</div>
	</body>
</html>