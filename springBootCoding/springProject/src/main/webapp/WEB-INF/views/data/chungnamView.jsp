<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>

	<link rel="stylesheet" type="text/css" href="/resources/include/css/chungnam.css"/>
	<link rel="stylesheet" type="text/css" href="/resources/include/css/lightbox.css"/>
	<style>
		#item-template{display:none;}
	</style>
	<script type="text/javascript" src="/resources/include/js/lightbox.min.js"></script>
	<script type="text/javascript" src="/resources/include/js/cookie.js"></script>
	
	<script type="text/javascript">
	function template(mng_no, local_nm, type, nm, nm_sub, desc, list_img){
		let $ul = $("#list");
		
		let $element = $("#item-template").clone().removeAttr('id');
		$element.attr("data-mngno", mng_no);
		
		$element.find('.item-light > a').attr({"href":list_img, "title":nm_sub});
		$element.find('.item-light > a > img').attr("src", list_img);
		
		$element.find('.item-type').html(type);
		$element.find('.item-title').html(nm);
		$element.find('.item-sub').html(nm_sub);
		$element.find('.item-content').html(desc);
		
		$ul.append($element);
	}	
	
	$(function(){
		$(".contentLayout .page-header h1").html("충남관광 - 관광명소"); // contentLayout.jsp -> tiles 설정 파일에서 준 제목이 들어가는 부분
		
		$.ajax({
			// 오픈api: "https://tour.chungnam.go.kr/_prog/openapi/?func=tour&start=1&end=5",
			url : "/data/chungnamList",
			type : "get",
			dataType : "xml",
			success : function(data){
				$(data).find('item').each(function(){
					let mng_no = $(this).find("mng_no").text();
					let local_nm = $(this).find("local_nm").text();
					let type = $(this).find("type").text();
					let nm = $(this).find("nm").text();
					let nm_sub = $(this).find("nm_sub").text();
					let desc = $(this).find("desc").text();
					let list_img = $(this).find("list_img").text();
					
					template(mng_no, local_nm, type, nm, nm_sub, desc, list_img);
				});
			}, 
			error : function(xhr, textStatus, errorThrown){
				alert(textStatus + " (HTTP-" + xhr.status + " / " + errorThrown + ")");
			}
		});
		
		/* span 태그 안 text 클래스 클릭했을 때 상세 페이지로 이동
		$(document).on("click", "span.text", function(){
			let mng_no = $(this).parents("li.item").attr("data-mngno");
			//console.log("mng_no"+mng_no);
			location.href="/data/chungnamDetailView?mng_no="+mng_no;
		}); */
		
		// 버튼 클릭했을 때 상세 페이지로 이동
		$(document).on("click", ".caption > .item-btn > .detailBtn", function(){
			//console.log("mng_no"+mng_no);
			location.href="/data/chungnamDetailView?mng_no="+mng_no;
		});
	});
	</script>
</head>
<body>
	<div class="contentContainer container">
		
		<!-- UI 화면 1 
		<ul id="list">
			<li id="item-template" class="item">
				<span class="item-light item-thumb">
					<a href="#" data-lightbox="roadtrip">
						<img />
					</a>
				</span>
				<span class="text">
					<span class="item-type"></span>
					<span class="item-title"></span>
					<span class="item-sub"></span>
					<span class="item-content"></span>
				</span>
			</li>
		</ul> -->
		
		<!-- UI 화면 2 (부트스트랩 제공 ui) -->
		<div class="row" id="list">
			<div id="item-template" class="col-sm-6 col-md-4 item">
				<div class="thumbnail">
					<span class="item-light">
						<a href="#" data-lightbox="roadtrip">
							<img />
						</a>
					</span>
					<div class="caption">
						<h3 class="item-title"></h3>
						<p class="item-sub"></p>
						<p class="item-btn">
							<a class="btn btn-primary detailBtn" role="button">상세정보</a>
						</p>
					</div>
				</div>
			</div>
		</div> 
		
	</div>
</body>
</html>
