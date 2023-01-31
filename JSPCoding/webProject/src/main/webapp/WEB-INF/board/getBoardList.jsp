<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/common/common.jsp" %>		
		<script type="text/javascript">
			$(function(){	
				/* 제목 마우스오버 시 밑줄 */
				$(".goDetail").hover(function(){
					$(this).css("textDecoration","underline");
				}, function(){
					$(this).css("textDecoration","none");
				});
				
				/* 제목 클릭 시 처리 이벤트 */
				$(".goDetail").on("click", function(){
					let num = $(this).parents("tr").attr("data-num");
					//console.log("num="+num);
					
					// 1. post 방식
					$("#num").val(num);
					$("#detailForm").attr({
						"method" : "post",
						"action" : "/board/detailBoard.do"
					});
					$("#detailForm").submit();
					
					// 2. get 방식
					//location.href="/board/detailBoard.do?num="+num;
				});
				/* 글쓰기 버튼 클릭 시 처리 이벤트 */
				$("#writeForm").on("click", function(){
					location.href = "/board/insertForm.do";
				});
			});
		</script>
	</head>
	<body>
		<div class="container">
			<div class="text-center"><h3>게시판 리스트</h3></div>
			
			<form name="detailForm" id="detailForm">
				<input type="hidden" name="num" id="num" />
			</form>
			
			<%-- ==================== 리스트 시작 ==================== --%>
			<div id="boardList">
				<table summary="게시판 리스트" class="table">
					<thead>
						<tr>
							<th class="col-md-1 text-center">번호</th>
							<th class="col-md-6 text-center">제목</th>
							<th class="col-md-2 text-center">작성자</th>
							<th class="col-md-2 text-center">날짜</th>
							<th class="col-md-1 text-center">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${ not empty list }">
								<c:forEach var="board" items="${ list }"> <!-- items에는 배열이나 컬렉션 -->
									<tr class="text-center" data-num="${ board.num }">
										<td>${ board.num }</td>
										<td class="text-left">
											<span class="goDetail">${ board.title }</span>
										</td>
										<td>${ board.author }</td>
										<td>${ board.writeday }</td>
										<td>${ board.readcnt }</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="5" class="text-center">등록된 게시물이 존재하지 않습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			
			<%-- ==================== 글쓰기 버튼 출력 시작 ==================== --%>
			<div class="contentBtn text-right">
				<button type="button" id="writeForm" class="btn btn-primary btn-sm">글쓰기</button>
			</div>
		</div>
	</body>
</html>