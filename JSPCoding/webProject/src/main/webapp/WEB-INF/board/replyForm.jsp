<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/common.jsp" %>
		<style type="text/css">
			#content{resize: none;}
		</style>
		
		<script type="text/javascript">
			$(function(){
				let conText = $("#content").val();
				$("#content").val("\n\n\n\n>>>>>>기존글내용>>>>>>\n\n"+conText);
				
				let msg = "${errorMsg}";
				if(msg!=""){
					alert(msg);
				}
				
				/* 답변 저장 버튼 클릭 시 처리 이벤트 */
				$("#boardInsertBtn").click(function(){
					//입력값 체크
					if(!chkData("#author","이름을")) return;
					else if(!chkData("#title","제목을")) return;
					else if(!chkData("#content","작성할 내용을")) return;
					else if(!chkData("#passwd","비밀번호를")) return;
					else {
						$("#f_replyForm").attr({
							"method" : "post",
							"action" : "/board/insertReply.do"
						});
						$("#f_replyForm").submit();
					}
				});
				
				/* 목록 버튼 클릭 시 처리 이벤트 */
				$("#boardListBtn").click(function(){
					location.href="/board/getBoardList.do";
				});
			});
		</script>	
	</head>
	<body>
		<div class="container">
			<div class="text-center"><h3>답변글 작성</h3></div>
	
			<div class="text-center">
				<form id="f_replyForm" name="f_replyForm">
					<!-- 답변글 필요 -->
					<input type="hidden" name="num" value="${reply.num}">
					<input type="hidden" name="repRoot" value="${reply.repRoot}">
					<input type="hidden" name="repStep" value="${reply.repStep}">
					<input type="hidden" name="repIndent" value="${reply.repIndent}">
					
					<table class="table table-bordered">
						<tr>
							<td colspan="2" class="text-left">게시물 글번호 ${reply.num} &nbsp;(조회수 : ${reply.readcnt})</td>
						</tr>
						<tr>
							<td class="text-center">작성자</td>
							<td><input type="text" name="author" id="author" class="form-control" ></td>
						</tr>
						<tr>
							<td class="text-center">글제목</td>
							<td><input type="text" name="title" id="title" value="[답변]${reply.title}" class="form-control" ></td>
						</tr>
						<tr>
							<td class="text-center">글내용</td>
							<td>
								<textarea name="content" id="content" maxlength="2000"
								rows="8" class="form-control">
									${reply.content}
								</textarea>
							</td>
						</tr>
						<tr>
							<td class="text-center">비밀번호</td>
							<td><input type="password" name="passwd" id="passwd" class="form-control"/></td>
						</tr>
					</table>
				</form>
			</div>
			
			<%-- ==================== 버튼 출력 시작 ==================== --%>

			<div class="text-right">
				<button type="button" class="btn btn-primary btn-sm" id="boardInsertBtn" >저장</button>
				<button type="button" class="btn btn-primary btn-sm" id="boardListBtn" >목록</button>
			</div>
		</div>
	</body>
</html>