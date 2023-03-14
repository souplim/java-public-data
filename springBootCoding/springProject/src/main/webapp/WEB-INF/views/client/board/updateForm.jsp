<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>
	<script type="text/javascript">
		$(function(){
			/* 저장 버튼 클릭 시 이벤트 */
			$("#updateBtn").click(function(){
				if(!checkForm("#b_title","글제목을")) return;
				else if(!checkForm("#b_content","글내용을")) return;
				else {
					// 이미지 파일만 업로드 가능. 확장자가 png, jpg, gif 외 파일을 업로드 없습니다 -> 유효성 체크
					// else if -> 필수, else -> 선택
					if($("#file").val()!=""){ 
						if(!chkFile($("#file"))) return;
					}

					$("#updateForm").attr({
						"method" : "post",
						"enctype" : "multipart/form-data", 
						// enctype 속성의 기본값은 "application/x-www-form-urlcencoded". POST방식 폼 전송에 기본값으로 사용
						// 파일 받으려면 "multipart/form-data"로 설정해줘야 함
						"action" : "/board/boardUpdate"
					});
					$("#updateForm").submit();
				}
			});
			
			/* 취소 버튼 클릭 시 이벤트 */
			$("#cancelBtn").click(function(){
				$("#updateForm").each(function(){
					this.reset();
				});
			});
			
			/* 목록 버튼 클릭 시 이벤트 */
			$("#listBtn").click(function(){
				location.href="/board/boardList";
			});
		});
	</script>
	</head>
	<body>
		<div class="contentContainer container">
			<div class="contentTB text-center">
				<form class="form-horizontal" id="updateForm">
					<input type="hidden" id="b_num" name="b_num" value="${boardVO.b_num}" />
					<input type="hidden" id="b_file" name="b_file" value="${boardVO.b_file}" />
					<input type="hidden" id="b_thumb" name="b_thumb" value="${boardVO.b_thumb}" />
					
					<table class="table table-striped">
						<tr>
							<td class="col-md-3">글번호</td>
							<td class="text-left col-md-3">${boardVO.b_num}</td>
							<td class="col-md-3">작성일</td>
							<td class="text-left col-md-3">${boardVO.b_date}</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td colspan="3" class="text-left">${boardVO.b_name}</td>
						</tr>
						<tr>
							<td>글제목</td>
							<td colspan="3" class="text-left">
								<input type="text" id="b_title" name="b_title" class="form-control" value="${boardVO.b_title}"/>
							</td>
						</tr>
						<tr class="table-tr-height"> <!-- 일정한 높이값 주기 위한 클래스 -->
							<td>내용</td>
							<td colspan="3" class="text-left">
								<textarea id="b_content" name="b_content" rows="10" class="form-control">${boardVO.b_content}</textarea>
							</td>
						</tr>
						<tr class="form-inline">
							<td>비밀번호</td>
							<td colspan="3" class="text-left">
								<input type="password" id="b_pwd" name="b_pwd" class="form-control"/>
								<label>수정할 비밀번호를 입력해주세요.</label>
							</td>
						</tr>
						<tr>
							<td>이미지파일첨부</td>
							<td colspan="3" class="text-left">
								<input type="file" name="file" id="file" />
								<c:if test="${not empty board.b_thumb}">
									<img src="/uploadStorage/board/thumbnail/${board.b_thumb}" />
								</c:if>
							</td>
						</tr>
					</table>
					<div class="text-right">
						<button type="button" class="btn btn-default" id="updateBtn">저장</button>
						<button type="button" class="btn btn-default" id="cancelBtn">취소</button>
						<button type="button" class="btn btn-default" id="listBtn">목록</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>