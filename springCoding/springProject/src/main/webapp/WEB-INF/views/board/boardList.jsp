<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>
	
	<script type="text/javascript">
		$(function(){
			/* 검색 후 검색 대상과 검색 단어 출력 */
			let word = "<c:out value='${boardVO.keyword}' />"; // 우리가 검색하는 데이터 고대로 받아옴
			let value = "";
			if(word!=""){
				// 검색하고 왔을 때 키워드, 검색어 없어지지 않음
				$("#keyword").val("<c:out value='${boardVO.keyword}' />");
				$("#search").val("<c:out value='${boardVO.search}' />");
				
				// 키워드가 제목, 이름일 때 
				// 검색범위 좁히고 검색어 색깔 빨간색으로 변경
				if($("#search").val()!='b_content'){
					//:contains()는 특정 텍스트를 포함한 요소 반환
					if($("#search").val()=='b_title') value = "#list tr td.goDetail";
					else if($("#search").val()=='b_name') value="#list tr td.name";
					console.log($(value+":contains('"+word+"')").html()); // js에서는 문자 "", ''로 묶어야 함
					
					$(value+":contains('"+word+"')").each(function(){
						let regex = new RegExp(word,'gi'); // g : 발생할 모든 pattern에 대한 전역 검색, i : 대/소문자 구분 안함
						$(this).html($(this).html().replace(regex,"<span class='required'>"+word+"</span>"));
						//$("#list tr td.goDetail:contains('노력')").html() => <span class='required'>노력</span>에 대한 명언
					});
				}
			}
			
			/* 입력 양식 enter 제거 */
			$("#keyword").bind("keydown", function(event){
				if(event.keyCode == 13){
					event.preventDefault();
				}
			});
			
			/* 검색 대상이 변경될 때마다 처리 이벤트 */
			$("#search").change(function(){
				if($("#search").val()=="all"){
					$("#keyword").val("전체 데이터 조회합니다.");
				} else if($("#search").val()!="all"){
					$("#keyword").val("");
					$("#keyword").focus();
				}
			});
			
			/* 검색 버튼 클릭 시 처리 이벤트 */
			$("#searchData").click(function(){
				if($("#search").val()!="all") // 제목/내용/작성자 선택시 검색어 유효성 체크
					if(!chkData("#keyword","검색어를")) return;
				
				$("#pageNum").val(1); // 현재 검색된 번호 가지고 페이징 처리 다시 하기 위한 코드
				
				goPage();
			});
			
			/* 제목 마우스오버 시 밑줄 */
			$(".goDetail").hover(function(){
				$(this).css("textDecoration","underline");
			}, function(){
				$(this).css("textDecoration","none");
			});
			
			/* 제목 클릭시 상세 페이지 이동을 위한 처리 이벤트 */
			$(".goDetail").click(function(){
				let b_num = $(this).parents("tr").attr("data-num");
				$("#b_num").val(b_num);
				console.log("글번호:"+b_num);
				// 상세 페이지로 이동하기 위해 form 추가(id: dataForm)
				$("#dataForm").attr({
					"method" : "get", 
					"action" : "/board/boardDetail"
				});
				$("#dataForm").submit();
				
				/* get방식 - form hidden input 없어도 됨 */
				//location.href="/board/boardDetail?b_num="+b_num; // 수정 요함
			});
			
			/* 글쓰기 클릭시 처리 이벤트 */
			$("#insertFormBtn").click(function(){
				location.href="/board/writeForm";
			});
			
			/* 페이징 처리 이벤트 */
			$(".paginate_button a").click(function(e){
				e.preventDefault(); // a태그 -> href로 이동하는 성격 해제
				// f_search 폼 하위 pageNum을 이름으로 가지는 input의 값을 클릭한 번호
				$("#f_search").find("input[name='pageNum']").val($(this).attr("href"));
				goPage(); // pageNum을 들고 다시 페이지 list 부르기
			});
			
		});
		
		/* 검색을 위한 실질적인 처리 함수 */
		function goPage(){
			if($("#search").val()=="all"){
				$("#keyword").val("");
			}
			
			$("#f_search").attr({
				"method" : "get",
				"action" : "/board/boardList"
			});
			$("#f_search").submit();
		}
	</script>	
	</head>
	<body>
		<div class="contentContainer container">
			<!-- <div class="contentTit page-header"><h3 class="text-center">게시판 리스트</h3></div> -->
			
			<form name="dataForm" id="dataForm">
				<input type="hidden" name="b_num" id="b_num">
			</form>
			
			<%-- ================= 검색기능 시작 ================= --%>
			<div id="boardSearch" class="text-right">
				<form id="f_search" name="f_search" class="form-inline">
					<!-- 페이징 처리를 위한 파라미터 -->
					<input type="hidden" name="pageNum" id="pageNum" value="${pageMaker.cvo.pageNum}"/>
					<input type="hidden" name="amount" id="amount" value="${pageMaker.cvo.amount}"/>
					
					<div class="form-group">
						<label>검색조건</label>
						<select id="search" name="search" class="form-control">
							<option value="all">전체</option>
							<option value="b_title">제목</option>
							<option value="b_content">내용</option>
							<option value="b_name">작성자</option>
						</select>										<!-- placeholder 안 하고 value값 가지고 -> 이벤트로 제어  -->
						<input type="text" name="keyword" id="keyword" value="검색어를 입력하세요" class="form-control" />
						<button type="button" id="searchData" class="btn btn-success">검색</button>
					</div>
				</form>
			</div>
			
			<%-- ================= 리스트 시작 ================= --%>
			<div id="boardList" class="table-height">
				<table summary="게시판 리스트" class="table table-striped">
					<thead>
						<tr>
							<th data-value="b_num" class="order text-center col-md-1">글번호</th>
							<th class="text-center col-md-4">글제목</th>
							<th class="text-center col-md-2">작성자</th>
							<th data-value="b_date" class="order col-md-1">작성일</th>
							<th class="text-center col-md-1">조회수</th>
							<th class="text-center col-md-3">이미지</th>
						</tr>
					</thead>
					<tbody id="list" class="table-striped">
						<!-- 데이터 출력 -->
						<c:choose>
							<c:when test="${not empty boardList}">
								<c:forEach var="board" items="${boardList}" varStatus="status">
									<tr class="text-center" data-num="${board.b_num}">
										<td>${board.b_num}</td>
										<td class="goDetail text-left">${board.b_title}
											<c:if test="${board.r_cnt > 0}"> <!-- 댓글 수 1 초과일 때만 출력 -->
												<span class="reply_count">&nbsp;[${board.r_cnt}]</span>
											</c:if>
										</td>
										<td class="name">${board.b_name}</td>
										<td class="text-left">${board.b_date}</td>
										<td class="text-center">${board.readcnt}</td>
										<td>
											<c:if test="${not empty board.b_thumb}">
												<img src="/uploadStorage/board/thumbnail/${board.b_thumb}" />
											</c:if>
											<c:if test="${empty board.b_thumb}">
												<img src="/resources/images/common/noimage.png" />
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="6" class="tac text-center">등록된 게시글이 존재하지 않습니다.</td>
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
			
			<%-- ================= 글쓰기 버튼 시작 ================= --%>
			<div class="contentBtn text-right">
				<button type="button" id="insertFormBtn" class="btn btn-success">글쓰기</button>
			</div>
			
		</div>
	</body>
</html>