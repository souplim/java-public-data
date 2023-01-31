<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/common/common.jsp" %>		
		<script type="text/javascript">
			$(function(){		
				/* 저장 버튼 클릭시 처리 이벤트 */
				$("#boardInsertBtn").on("click", function(){
					
					if(!chkData("#author","작성자를")) return;
					else if(!chkData("#title","글제목을")) return;
					else if(!chkData("#content","작성할 내용을")) return;
					else if(!chkData("#passwd","비밀번호를")) return;
					else {
						
						$("#f_writeForm").attr({
							"method" : "post",
							"action" : "/board/insertBoard.do"
						});
						$("#f_writeForm").submit();
					}
				});
				
				/* 목록버튼 클릭시 처리 이벤트 */
				$("#boardListBtn").on("click", function(){
					location.href = "/board/getBoardList.do";
				});
			});
		</script>
	</head>
	<body>
	<div class="container">
		<div class="text-center"><h3>게시판 입력화면</h3></div>

		<form class="form-horizontal" id="f_writeForm">
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">작 성 자</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="author" name="author" placeholder="작성자 입력">
				</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">글 제 목</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title" placeholder="글제목 입력">
				</div>
			</div>
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">글 내 용</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="content" name="content" rows="5"></textarea>
				</div>
			</div>

			<div class="form-group">
				<label for="passwd" class="col-sm-2 control-label">비밀번호</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력">
				</div>
			</div>

			<%-- ==================== 버튼 출력 시작 ==================== --%>

			<div class="contentBtn text-right">
				<button type="button" id="boardInsertBtn" class="btn btn-primary">저장</button>
				<button type="button" id="boardListBtn" class="btn btn-primary">목록</button>
			</div>

		</form>
	</div>
</body>
</html>