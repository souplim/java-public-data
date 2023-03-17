<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>
	<link href="https://fonts.gooleapis.com/css?family=Jua" rel="stylesheet">
	<style type="text/css">
		#map {height: 500px;}
		#item-template {display: none;}
		.item-img > img {margin-bottom: 5px;}
		#firstHeading {margin-bottom: 14px; font-family: 'Jua', sans-serif; font-size: 24px; }
		#bodyContent p {line-height: 1.8em; font-size: 16px; font-weight: normal; }
	</style>
	<script type="text/javascript" src="/resources/include/js/cookie.js"></script>
	<!-- 구글맵을 사용하기 위해서는 key를 인증받아야 사용할 수 있다. -->
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBJhYe6bSOgJy3_0R6wI8OAKrJa6kx6CwA" defer></script>
	
	<script type="text/javascript">
		function template(local_nm, type, nm, nm_sub, addr, tel, desc, regData, view_img){
			let $div = $("#detailData");
			
			let $element = $("#item-template").clone().removeAttr('id');
			
			$element.find('.item-title').html(nm);
			$element.find('.item-content').html(desc);
			
			$element.find('.item-type').html(type);
			$element.find('.item-namesub').html(nm_sub);
			$element.find('.item-addr').html(addr);
			$element.find('.item-tel').html(tel);
			
			for(let i=0; i<=view_img.lenght; i++){ // 이미지 여러장 있을 때 처리
				let img = $("<img />");
				img.attr("src", view_img[i]);
				img.addClass("img-rounded");
				$element.find(".item-img").append(img);
			}
			
			$div.append($element);
		}	
		
		$(function(){
			// contentLayout.jsp -> tiles 설정 파일에서 준 제목이 들어가는 부분
			$(".contentLayout .page-header h1").html("충남관광 - 관광명소 상세정보"); 
			
			let mng_no = ${param.mng_no};
			
			$.ajax({
				url : "/data/chungnamDetail",
				type : "get",
				data : "mng_no="+mng_no,
				dataType : "xml",
				success : function(data){
					let local_nm = $(data).find("local_nm").text();
					let type = $(data).find("type").text();
					let nm = $(data).find("nm").text();
					let nm_sub = $(data).find("nm_sub").text();
					
					let addr = $(data).find("addr").text();
					let lat = $(data).find("lat").text();
					let lng = $(data).find("lng").text();
					let tel = $(data).find("tel").text();

					let desc = $(data).find("desc").text();
					let regData = $(data).find("regData").text();
					
					let view_img = [];
					view_img.push($(data).find("view_img1").text());
					view_img.push($(data).find("view_img2").text());
					view_img.push($(data).find("view_img3").text());
					
					initMap(lat, lng, nm, tel, addr); /* 지도 표시 */
					template(local_nm, type, nm, nm_sub, addr, tel, desc, regData, view_img);
				}, 
				error : function(xhr, textStatus, errorThrown){
					alert(textStatus + " (HTTP-" + xhr.status + " / " + errorThrown + ")");
				}
			});
			
			$("#chungnamListBtn").click(function(){
				location.href = "/data/chungnamView";
			});
		});
	
		function initMap(latData, lngData, nm, tel, addr){
			console.log(latData+"/"+lngData+"/"+nm +"/"+ tel +"/"+ addr);
			
			let my_position = {lat: parseFloat(latData), lng: parseFloat(lngData)}; // 객체의 표시 위치를 변수로 정의한다.
			
			// 맵 객체를 생성하고 id="map"에 지도 표시
			let map = new google.maps.Map(document.getElementById('map'),{ // 인스턴스 생성. 첫번째 매개변수에는 지도가 표시된 문서 객체명을 명시
				center: my_position, // 두번째 매개변수에 해당하는 항목으로 객체가 구성된다. 지도 중앙에 표시될 위치를 위도, 경도값으로 지정, 우측의 값에서 lat는 위도, lng는 경도
				scrollwheel: false, // 마우스 휠기능을 설정하거나 해제(true or false)
				zoom: 17 // 지도의 확대/축소 스케일을 지정. zoom값이 0이면 완전히 축소된 지도이고 값이 커질수록 더 높은 해상도로 화면이 확대됨
			});
			
			let contentString = '<div id="content"><h1 id="firstHeading">' + nm + '</h1>';
			contentString += '<div id="bodyContent">';
			contentString += '<p><strong>';
			contentString += '주소 : '+ addr +'<br/>';
			contentString += 'Tel : '+ tel + '</p></div></div>';
			
			let infowindow = new google.maps.infoWindow({
				content: contentString
			});
			
			let image = {
					url: 'http://localhos:8080/resources/images/map/marker.png',
					// This marker is 20 pixels wide by 32 pixels high.
					size: new google.maps.Size(72,72),
					// The origin for this image is (0,0).
					origin: new google.maps.Point(0, 0),
					// The anchor for this image is the base of the flagpole at (0, 32).
					anchor: new google.maps.Point(0, 32)
			};
			
			// 마커 객체 생성
			let marker = new google.maps.Marker({ // 마커 객체 생성
				map: map, // 마커가 표시될 맵 객체명 지정
				position: my_position, // 마커의 위치를 지정. 현재의 위도, 경도를 기본으로 지정
				title: nm, // 마커에 표시되는 말풍선 제목을 입력
				icon: image
			});
			
			marker.addListener('mouseover', function(){
				infowindow.open(map, marker);
			});
			marker.addListener('mouseout', function(){
				infowindow.close();
			});
		}
	</script>
	</head>
	<body>
		<div class="contentContainer container">
			<div class="jumbotron" id="map"></div>
			
			<div id="detailData">
				<div class="panel panel-default" id="item-template">
					<!-- Default panel contents -->
					<div class="panel-heading item-title"></div>
					<div class="panel-body">
						<p class="item-content"></p>
					</div>
					
					<!-- Table -->
					<table class="table">
						<tbody class="detail-content">
							<tr class="item">
								<td class="detail-title col-md-2">분류</td> 
								<td class="item-type col-md-10"></td> 
							</tr>
							<tr class="item">
								<td class="detail-title">간략한 설명</td> 
								<td class="item-namesub"></td> 
							</tr>
							<tr class="item">
								<td class="detail-title">주소</td> 
								<td class="item-addr"></td> 
							</tr>
							<tr class="item">
								<td class="detail-title">전화번호</td> 
								<td class="item-tel"></td> 
							</tr>
							<tr class="item">
								<td class="detail-title">이미지</td> 
								<td class="item-img"></td> 
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
			<div class="text-right">
				<button type="button" class="btn btn-info" id="chungnamListBtn">목록</button>
			</div>
		</div>
	</body>
</html>
