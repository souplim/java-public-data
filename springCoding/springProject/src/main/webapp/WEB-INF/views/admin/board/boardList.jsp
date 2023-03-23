<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>

	<!-- 스크립트 정의 -->
	<script type="text/javascript" src="/resources/include/js/common.js"></script>
	<script type="text/javascript" src="/resources/include/js/board.js"></script>
	<script type="text/javascript"> // 값을 담는 것 JSP(코어태그와 표현언어로 해야 하기 때문에), 변수 사용하는 건 JS -> 처리 별도로 해야함
		search = "<c:out value='${data.search}' />"; 
		start_date = "<c:out value='${data.start_date}' />";
		end_date = "<c:out value='${data.end_date}' />";
		keyword = "<c:out value='${data.keyword}' />";
	</script>
	</head>
	<body>
		<h2 class="sub-header">게시판 리스트</h2>
		<!-- 검색 부분 정의  -->
		<div class="well">
			<form class="form-inline" id="f_search">
				<input type="hidden" name="pageNum" id="pageNum" value="${pageMaker.cvo.pageNum}"> <!-- 페이징을 위해 페이지 번호 가져감 -->
				<input type="hidden" name="amount" id="amount" value="${pageMaker.cvo.amount}"> <!-- 페이징을 위해 한 페이지에 보여줄 글 수 가져감 -->
				<!-- <input type="hidden" name="b_num" id="b_num" value=0> 
				상세페이지 위한 게시글 번호를 여기서 넘기면 b_num이 null인 상태로 parse 되어 int를 만들기 때문에 에러남 -> get 방식으로 가면 hidden 필요 없음! -->
				
				<h3><span class="label label-success">검색조건</span></h3>
				<div class="form-group">
					<select id="search" name="search" class="form-control">
						<option value="b_title">제목</option>
						<option value="b_name">작성자</option>
						<option value="b_content">내용</option>
						<option value="b_date">작성일자</option>
					</select>
				</div>
				<div class="form-group" id="textCheck"> <!-- 날짜 외 검색 선택 시 보이는 부분 -->
					<input type="text" name="keyword" id="keyword" class="form-control" placeholder="검색어를 입력하세요" />
				</div>
				<div class="form-group" id="dataCheck"> <!-- 날짜 검색 선택 시 보이는 부분 -->
					<input type="date" name="start_date" id="start_date" placeholder="시작일자" class="form-control">
					<input type="date" name="end_date" id="end_date" placeholder="종료일자" class="form-control">
				</div>
				<button type="button" class="btn btn-primary" id="searchBtn">Search</button>
				<button type="button" class="btn btn-primary" id="allSearchBtn">All Search</button> <!-- 전체 레코드 조회 -->
			</form>
		</div>
		
		<!-- 게시판 리스트 -->
		<div class="table-responsive table-height">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class='text-center'>글번호</th>
						<th class='text-center'>글제목</th>
						<th class='text-center'>작성일</th>
						<th class='text-center'>작성자</th>
						<th class='text-center'>삭제</th>
					</tr>
				</thead>
				<tbody>
					<!-- 데이터 출력 -->
					<c:choose>
						<c:when test="${not empty boardList}">
							<c:forEach var="board" items="${boardList}" varStatus="status">
								<tr class="text-center" data-num="${board.b_num}">
									<td>${count - status.index}</td> <!-- 새롭게 번호 부여 -->
									<%-- <td>${board.b_num}</td> --%>
									<td class="goDetail tal">${board.b_title}</td>
									<td>${board.b_date}</td>
									<td class="name">${board.b_name}</td>
									<td><button type="button" class="delBtn">삭제</button></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="4" class="text-center">등록된 게시물이 존재하지 않습니다</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		
		<%-- ================= 페이징 출력 시작 ================= --%>
		<div class="text-center">
			<ul class="pagination">
				<!-- 이전 바로가기 10개 존재 여부를 prev 필드의 값으로 확인 -->
				<c:if test="${pageMaker.prev}">
					<li class="paginate_button previous">
						<a href="${pageMaker.startPage -1}">Previous</a>
					</li>
				</c:if>
				
				<!-- 바로가기 번호 출력 -->
				<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					<!-- 현재 페이지 색깔 : 현재 보고 있는 페이지와 for문으로 돌리고 있는 페이지가 일치하면 class='active' 적용 -->
					<li class="paginate_button ${pageMaker.cvo.pageNum == num ? 'active':''}">
						<a href="${num}">${num}</a>
					</li>
				</c:forEach>
				
				<!-- 다음 바로가기 10개 존재 여부를 next 필드의 값으로 확인 -->
				<c:if test="${pageMaker.next}">
					<li class="paginate_button next">
						<a href="${pageMaker.endPage+1}">Next</a>
					</li>
				</c:if>
			</ul>
		</div>
	</body>
</html>
