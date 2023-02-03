<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/common/common.jsp" %>
	<style type="text/css">
		#content{resize: none;}
	</style>
	
	<script type="text/javascript">
		$(function(){
			let msg = "${errorMsg}";
			if(msg!="")
				alert(msg);
			
			/* 수정 버튼 클릭 시 처리 이벤트 */
			$("#boardUpdateBtn").on("click", function(){
				// 입력값 체크
				if(!chkData("#title","제목을")) return;
				else if(!chkData("#content","작성할 내용을")) return;
				else {
					$("#f_updateForm").attr({
						"method" : "post",
						"action" : "/board/updateBoard.do"
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
			<div class="text-center"><h3>글수정</h3></div>
			<div class="text-center">
				<form name="f_updateForm" id="f_updateForm">
					<input type="hidden" name="num" id="num" value="${updateData.num}">
					
					<table class="table table-bordered">
						<tr>
							<td class="text-center">글번호</td>
							<td class="text-left">${updateData.num} <label>(조회수: ${updateData.readcnt})</label></td>
							<td class="text-center">작성일</td>
							<td class="text-left">${updateData.writeday}</td>
						</tr>
						<tr>
							<td class="text-center">작성자</td>
							<td colspan="3" class="text-left">${updateData.author}</td>
						</tr>
						<tr>
							<td class="text-center">글제목</td>
							<td colspan="3">
								<input type="text" class="form-control" name="title" id="title" value="${updateData.title}"/>
							</td>
						</tr>
						<tr>
							<td class="text-center">글내용</td>
							<td colspan="3">
								<textarea class="form-control" name="content" id="content" rows="8">
									${updateData.content}
								</textarea>
							</td>
						</tr>
						<tr>
							<td class="text-center">비밀번호</td>
							<td colspan="3">
								<input type="password" class="form-control" name="passwd" id="passwd" 
								placeholder="기존 비밀번호가 아니라 수정할 비밀번호를 입력해주세요."/>
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			<%-- ======== 비밀번호 확인 버튼 및 버튼 추가 시작 ======== --%>
			<div class="text-right">
				<button type="button" id="boardUpdateBtn" class="btn btn-primary btn-sm">수정</button>
				<button type="button" id="boardListBtn" class="btn btn-primary btn-sm">목록</button>
			</div>
		</div>
	</body>
</html>