<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>
	<link rel="stylesheet" type="text/css" href="/resources/include/css/chungnam.css"/>
	<link rel="stylesheet" type="text/css" href="/resources/include/css/lightbox.css"/>
	<script type="text/javascript" src="/resources/include/js/lightbox.min.js"></script>
	<script type="text/javascript" src="/resources/include/js/cookie.js"></script>
	<style type="text/css">
		.media img {width:140px; height:140px;}
		#media-template{display:none;}
	</style>
	<script type="text/javascript">
		function template(animalSeq, age, filePath, species, hairColor, memo, foundPlace){
			let $div = $("#list");
			let $element = $("#media-template").clone().removeAttr('id');
			
			let img = ""; /* 이미지 있을 수도 없을 수도 있음 */
			if(filePath != null){
				img = "http://www.daejeon.go.kr/"+filePath;
				$element.find('.media-left > a').attr({"href":img, "title":species});
				$element.find('.media-left > a > img').attr("src", img);
			} else {
				img = "/resources/images/common/noanimal.png";
				$element.find(".media-left > a > img").attr("src", img); // 이미지 존재하지 않을 때 보여줄 이미지
			}
			
			$element.find('.media-heading').html(species+" - "+age);
			$element.find('.item-place').html(foundPlace);
			$element.find('.item-color').html(hairColor);
			$element.find('.item-memo').html(memo);
			
			$div.append($element);
		}
		
		$(function(){
			$(".contentLayout .page-header h1").html("대전 유기동물 공고"); /* contentLayout.jsp 의 title부분 */
			
			$.ajax({
				url : "/data/animalDaejeonList",
				type : "get",
				dataType : "xml",
				success : data => { // success: function(data){ 동일, 매개변수 1개일 때 괄호 생략 가능
					$(data).find('items').each(function(index){ // 데이터 객체화 하여 반복된 원소 찾기 -> xml 파일의 items 태그
						let animalSeq = $(this).find("animalSeq").text();
						let age = $(this).find("age").text();
						let filePath = $(this).find("filePath").text();
						let hairColor = $(this).find("hairColor").text();
						let memo = $(this).find("memo").text();
						let species = $(this).find("species").text();
						let foundPlace = $(this).find("foundPlace").text();
						
						template(animalSeq, age, filePath, species, hairColor, memo, foundPlace);
					});
				}, error : (xhr, textStatus, errorThrown) => {
					alert(textStatus + " (HTTP-" + xhr.status + " / " + errorThrown +")");
				}
			});
		});
	</script>
	</head>
	<body>
		<div class="contentContainer container">
			<div id="list">
				<div class="media" id="media-template">
					<div class="media-left">
						<a href="#" data-lightbox=roadtrip">
							<img class="media-object img-rounded" />
						</a>
					</div>
					<div class="media-body">
						<h4 class="media-heading"></h4>
						<table class="table table-hover">
							<tbody class="media-content">
								<tr class="item">
									<td class="item-title">발견된 장소</td>
									<td class="item-place"></td>
								</tr>
								<tr class="item">
									<td class="item-title">색상</td>
									<td class="item-color"></td>
								</tr>
								<tr class="item">
									<td class="item-title">메모</td>
									<td class="item-memo"></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>			
			</div>
		</div>
	</body>
</html>
