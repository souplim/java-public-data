<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>
	
	<style>
		#item-template {display:none;}
		.inline {display:inline-block;}
	</style>
	
	<script type="text/javascript">
		$(function(){
			/* 기본 덧글 목록 불러오기 */
			let b_num = ${boardDetail.b_num};
			listAll(b_num);
		});
		
		/* 댓글 목록 보여주는 함수 - 서버로부터 리스트 받아오기 위한 요청 함수 */
		function listAll(b_num){
			$(".reply").detach(); // detach(): 선택한 요소를 DOM 트리에서 삭제(불러올 때마다 클래스 추가하므로 중복 출력 방지)
			
			let url = "/replies/all/"+b_num; // 요청 uri: 단 게시글번호(b_num)이 1번이라면 => /replies/all/1
			
			$.getJSON(url, function(data){ // data = [{r_num:1, r_name:"홍길동"...},{...}]
				$(data).each(function(){
					let r_num = this.r_num;
					let r_name = this.r_name;
					let r_content = this.r_content;
					let r_date = this.r_date;
					r_content = r_content.replace(/(\r\n|\r|\n)/g, "<br />"); 
					// 댓글내용에서 enter를 입력하면 \n\r or \r or \n으로 처리
					template(r_num, r_name, r_content, r_date);
				});
			}).fail(function(){
				alert("덧글 목록을 불러오는 데 실패하였습니다. 잠시 후에 다시 시도해주세요.");
			});
		}
		
		/* 새로운 글을 화면에 보여주기(추가하기) 위한 함수 */
		function template(r_num, r_name, r_content, r_date){
			let $div = $("#reviewList"); // => <div id="reviewList">
			
			let $element = $("#item-template").clone().removeAttr('id'); // id 속성 중복될 수 없기 때문에 삭제 => <div> 
			$element.attr("data-num", r_num); // <div data-num="1" class="panel panel-success reply">
			$element.addClass("reply");
			$element.find('.panel-heading > .panel-title > .name').html(r_name);
			$element.find(".panel-heading > .panel-title > .date").html(" / " + r_date);
			$element.find('.panel-body').html(r_content);
			
			$div.append($element);
		}
	</script>
	</head>
	<body>
		<div class="contentTB text-center">
			<table class="table table-bordered">
				<tr>
					<td class="col-md-3">작성자</td>
					<td class="col-md-3 text-left">${boardDetail.b_name}</td>
					<td class="col-md-3">작성일</td>
					<td class="col-md-3 text-left">${boardDetail.b_date}</td>
				</tr>
				<tr>
					<td class="col-md-4">글제목</td>
					<td colspan="3" class="col-md-8 text-left">${boardDetail.b_title}</td>
				</tr>
				<tr class="table-tr-height">
					<td class="col-md-4">글내용</td>
					<td colspan="3" class="col-md-8 text-left">${boardDetail.b_content}</td>
				</tr>
				
				<c:if test="${not empty boardDetail.b_file}">
					<tr>
						<td class="col-md-4">이미지</td>
						<td colspan="3" class="col-md-8 text-left">
							<img src="/uploadStorage/board/${boardDetail.b_file}" />
						</td>
					</tr>
				</c:if>
			</table>
		</div>
		
		<!-- 댓글 리스트 영역 -->
		<div id="reviewList">
			<div id="item-template" class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span class="name"></span>
						<span class="date"></span>
						<button type="button" data-btn="delBtn" class="btn btn-default gap">삭제하기</button><!-- 식별하기 위한 data- -->
					</h3>
				</div>
				<div class="panel-body"></div>
			</div>
		</div>
		
	</body>
</html>