<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/common/common.jsp" %>		
		<style type="text/css">
			.goDetail{cursor:pointer;}
		</style>
		<script type="text/javascript">
			$(function(){	
				/* 검색 후 검색 대상과 검색 단어 출력 */
				if('${param.keyword}'!=""){
					$("#keyword").val('${param.keyword}');
					$("#search").val('${param.search}');
				}
				
				/* 입력 양식 enter 제거 -> form에 method, action 명시하지 않았기 때문에 기능없음*/
				$("#keyword").bind("keydown", function(){
					if(event.keyCode == 13) { // 13 : 엔터
						event.preventDefault(); // 엔터 기능 제거
						$("#searchData").click(); // 검색단어 입력 후 enter로 검색기능 가능하도록 설정
					}
				});
				
				/* 검색 버튼 클릭시 처리 이벤트 */
				$("#searchData").click(function(){
					if($("#search").val()!="all") // 검색대상(search)의 값이 all이 아니면 키워드(검색할 단어)가 반드시 필요
						if(!chkData("#keyword", "검색어를")) return;
					 else if($("#search").val()=="all")
						$("#keyword").val(""); // 검색대상(search)의 값이 all이면 모든 게시글 출력으로 키워드가 필요하지 않음
					$("#f_search").attr({
						"method" : "post",
						"action" : "/board/getBoardList.do"
					});
					$("#f_search").submit();	
				});
				
				
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
			<c:import url="/WEB-INF/user/mypage.jsp" />
			
			<div class="text-center"><h3>게시판 리스트</h3></div>
			
			<form name="detailForm" id="detailForm">
				<input type="hidden" name="num" id="num" />
			</form>
			<%-- ==================== 검색기능 시작 ==================== --%>
			<div id="boardSearch" class="text-right">
				<form id="f_search" name="f_search" class="form-inline">
					<div class="form-group">
						<label>검색조건</label>
						<select id="search" name="search" class="form-control">
							<option value="all">전체</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="author">작성자</option>
						</select>
						<input type="text" name="keyword" id="keyword" placeholder="검색어를 입력하세요" class="form-control" />
						<button type="button" id="searchData" class="btn btn-primary">검색</button>
					</div>
				</form>
			</div>
			
			
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
										<%-- <td class="text-left"><span class="goDetail">${ board.title }</span></td> --%>
										<td class="text-left">
											<c:if test="${board.repStep>0}"><%--답변글이면--%>
												<c:forEach begin="1" end="${board.repIndent}"><%--답변의 계층번호에 따라 공백설정(기본값 공백3칸)--%>
													&nbsp;&nbsp;&nbsp;
												</c:forEach>
												<img src="/image/re.gif" /><%--답변이미지 출력--%>
											</c:if>
											<span class="goDetail">${board.title}</span>
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