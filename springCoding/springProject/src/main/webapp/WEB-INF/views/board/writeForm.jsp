<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>
	<script type="text/javascript">
		$(function(){
			/* 저장 버튼 클릭 시 이벤트 */
			$("#insertBtn").click(function(){
				if(!checkForm("#b_title","글제목을")) return;
				else if(!checkForm("#b_name","작성자를")) return;
				else if(!checkForm("#b_content","글내용을")) return;
				else if(!checkForm("#b_pwd","비밀번호를")) return;
				else {
					if($("#file").val()!=""){ // 이미지 파일만 업로드 가능. 확장자가 png, jpg, gif 외 파일을 업로드 없습니다 -> 유효성 체크
						if(!chkFile($("#file"))) return;
					}
					
					$("#insertForm").attr({
						"method" : "post",
						"enctype" : "multipart/form-data", 
						// enctype 속성의 기본값은 "application/x-www-form-urlcencoded". POST방식 폼 전송에 기본값으로 사용
						// 파일 받으려면 "multipart/form-data"로 설정해줘야 함
						"action" : "/board/boardInsert"
					});
					$("#insertForm").submit();
				}
			});
			
			/* 취소 버튼 클릭 시 이벤트 */
			$("#cancelBtn").click(function(){
				$("#insertForm").each(function(){
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
				<form class="form-horizontal" id="insertForm">
					<table class="table table-striped">
						<tr>
							<td>제목</td>
							<td><input type="text" id="b_title" name="b_title" class="form-control" /></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input type="text" id="b_name" name="b_name" class="form-control" /></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea id="b_content" name="b_content" class="form-control" ></textarea></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" id="b_pwd" name="b_pwd" class="form-control" /></td>
						</tr>
						<tr>
							<td>이미지파일첨부</td>
							<td class="text-left"><input type="file" name="file" id="file"/></td> 
							<!-- BoardVO의 MultipartFile의 참조변수명은 file. b_file로 name 주면 받을 수 없음! -->
						</tr>
					</table>
					<div class="text-right">
						<button type="button" class="btn btn-default" id="insertBtn">저장</button>
						<button type="button" class="btn btn-default" id="cancelBtn">취소</button>
						<button type="button" class="btn btn-default" id="listBtn">목록</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>