<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>main.jsp - http://localhost:8080/ 로 요청</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="/resources/image/icon.png" />
		<link rel="apple-touch-icon" href="/resources/image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="/resources/js/html5shiv.js"></script>
		<![endif]-->
		
		<link rel="stylesheet" type="text/css" href="/resources/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/resources/dist/css/bootstrap-theme.min.css" />

		<style type="text/css">
			form{margin-bottom: 30px;}
			div#list{display: none;} /* 버튼 클릭 전 상단 <th> 태그 숨기기 위함 */
		</style>

		<script type="text/javascript" src="/resources/js/jquery-3.6.2.min.js"></script>
		<script type="text/javascript" src="/resources/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#exam01Btn").click(function(){
					$("#exam01Form").attr({
						method : "get",
						action : "/sample/exam01"
					});
					$("#exam01Form").submit();
				});
				
				$("#exam02Btn").click(function(){
					$("#exam01Form").attr({
						method : "get",
						action : "/sample/exam02"
					});
					$("#exam01Form").submit();
				});
				
				$("#exam02ListBtn").click(function(){
					$("#exam02ListForm").attr({
						method : "get",
						action : "/sample/exam02List"
					});
					$("#exam02ListForm").submit();
				});
				
				$("#exam02ArrayBtn").click(function(){
					$("#exam02ArrayForm").attr({
						method : "get",
						action : "/sample/exam02Array"
					});
					$("#exam02ArrayForm").submit();
				});
				
				$("#exam02BeanBtn").click(function(){
					$("#exam02BeanForm").attr({
						method : "get",
						action : "/sample/exam02Bean"
					});
					$("#exam02BeanForm").submit();
				});
				
				$("#exam03Btn").click(function(){
					$("#exam03Form").attr({
						method : "get",
						action : "/sample/exam03"
					});
					$("#exam03Form").submit();
				});
				
				$("#jsonBtn").click(function(){
					$.ajax({
						url : "/sample/getExample2", // 전송 url
						type : "get",					// 전송 시 method 방식
						dataType : "json",
						error : function(xhr, textStatus, errorThrown){
							alert(textStaus + "(HTTP-"+ xhr.status + " / " + errorThrown +")");
						},
						success : function(resultData){
							let no = resultData.no;
							let name = resultData.name;
							let phone = resultData.phone;
							
							let noLi = $("<li>").html(no);
							let nameLi = $("<li>").html(name);
							let phoneLi = $("<li>").html(phone);

							$("#dataArea").append(noLi).append(nameLi).append(phoneLi);
						}
					});
				});
				
				$("#jsonListBtn").click(function(){
					$("#list").css("display","block");
					$("#listData").html("");
					
					$.getJSON('/sample/getList', function(data){
						$(data).each(function(){
							let no = this.no;
							let name = this.name;
							let phone = this.phone;
							
							let noTd = $("<td>").html(no);
							let nameTd = $("<td>").html(name);
							let phoneTd = $("<td>").html(phone);
							
							let tr = $("<tr>").append(noTd).append(nameTd).append(phoneTd);
							$("#listData").append(tr);
						});
					}).fail(function(xhr, textStatus, errorThrown){
						alert(textStaus + "(HTTP-"+ xhr.status + " / " + errorThrown +")");
					});
				});
			});
		</script>
	</head>
	<body>
		<div class="container">
			<div class="text-center"><h3>웹 MVC 관련 예제</h3></div>
			
			<h5>매개변수 처리 예제</h5>
			<form id="exam01Form" class="form-inline">
				<div class="form-group">
					<label class="sr-only">이름</label>
					<input type="text" class="form-control" name="name" id="name" placeholder="이름 입력" />
				</div>
				<div class="form-group">
					<label class="sr-only">나이</label>
					<input type="text" class="form-control" name="age" id="age" placeholder="나이 입력" />
				</div>
				<button type="button" id="exam01Btn" class="btn btn-success">exam01 예제 확인</button>
				<button type="button" id="exam02Btn" class="btn btn-success">exam02 예제 확인</button>
			</form>
			
			<h5>매개변수 값을 List 타입에 대입 예제</h5>
			<form id="exam02ListForm">
				<label class="checkbox-inline">
					<input type="checkbox" name="language" value="java">java
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="language" value="jsp">jsp
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="language" value="oracle">oracle
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="language" value="spring">spring
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="language" value="jquery">jquery
				</label>
				<button type="button" id="exam02ListBtn" class="btn btn-success">exam02ListBtn 예제 확인</button>
			</form>
			
			<h5>매개변수 값을 배열(Array) 처리 예제</h5>
			<form id="exam02ArrayForm">
				
				<label class="checkbox-inline">
					<input type="checkbox" name="hobby" value="여행"> 여행
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="hobby" value="영화, 드라마 감상"> 영화, 드라마 감상
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="hobby" value="운동"> 운동
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="hobby" value="독서"> 독서
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="hobby" value="맛집 탐방"> 맛집 탐방
				</label>
				<button type="button" id="exam02ArrayBtn" class="btn btn-success">exam02Array 예제 확인</button>
			</form>
			
			<h5>SampleDTOList 값 처리 예제</h5>
			<form id="exam02BeanForm" class="form-inline">
				<div class="form-group">
					<label class="sr-only">이름</label>
																<!-- SampleDTOList의 필드명[인덱스].속성명 
																	나중에 장바구니 프로그램에 사용해야 함
																	list.add(new ArrayList("홍길동",20)) 
																	"홍길동" = list[0].name / 20 = list[0].age -->
					<input type="text" class="form-control" name="list[0].name" id="list[0].name" placeholder="이름 입력" />
				</div>
				<div class="form-group">
					<label class="sr-only">나이</label>
					<input type="text" class="form-control" name="list[0].age" id="list[0].age" placeholder="나이 입력" />
				</div>
				<div class="form-group">
					<label class="sr-only">이름</label>
					<input type="text" class="form-control" name="list[1].name" id="list[1].name" placeholder="이름 입력" />
				</div>
				<div class="form-group">
					<label class="sr-only">나이</label>
					<input type="text" class="form-control" name="list[1].age" id="list[1].age" placeholder="나이 입력" />
				</div>
				<button type="button" id="exam02BeanBtn" class="btn btn-success">exam02Bean 예제 확인</button>
			</form>
			
			<h5>DTO와 일반 매개변수 값 처리 예제</h5>
			<form id="exam03Form" class="form-inline">
				<div class="form-group">
					<label class="sr-only">이름</label>
					<input type="text" class="form-control" name="name" placeholder="이름 입력" />
				</div>
				<div class="form-group">
					<label class="sr-only">나이</label>
					<input type="text" class="form-control" name="age" placeholder="나이 입력" />
				</div>
				<div class="form-group">
					<label class="sr-only">상품번호</label>
					<input type="text" class="form-control" name="number" id="number" placeholder="상품번호 입력" />
				</div>
				<button type="button" id="exam03Btn" class="btn btn-success">exam03 예제 확인</button>
			</form>
			
			<h5>XML/JSON 값 요청 예제</h5>
			<dl class="dl-horizontal">
				<dt>데이터로만 반환(단순 문자열)&nbsp;</dt>
				<dd><a href="http://localhost:8080/sample/getText">getText</a></dd>
				
				<dt>데이터로만 반환(xml)&nbsp;</dt>
				<dd><a href="http://localhost:8080/sample/getExample">getExample</a></dd>
				
				<dt>데이터로만 반환(json-1)&nbsp;</dt>
				<dd><a href="http://localhost:8080/sample/getExample2">getExample2</a></dd>
				
				<dt>데이터로만 반환(json-2)</dt>
				<dd><a href="http://localhost:8080/sample/getExample3">getExample3</a></dd>
				
				<dt>데이터로만 반환(json-3)</dt>
				<dd><a href="http://localhost:8080/sample/getList">getList</a></dd>
				
				<dt>get 방식과 post 방식</dt>
				<dd><a href="http://localhost:8080/sample/examMethod">입력화면 요청</a></dd>
			</dl>
			
			<h5>Ajax 요청</h5>
			<button type="button" id="jsonBtn" class="btn btn-success">json 데이터 요청</button><br/>
			<ul id="dataArea" class="list-inline"></ul>
			
			<button type="button" id="jsonListBtn" class="btn btn-success">List 데이터 요청</button><br/>
			<div class="row col-sm-6" id="list">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>핸드폰</th>
						</tr>
					</thead>
					<tbody id="listData"></tbody>
				</table>
			</div>			
		</div>
	</body>
</html>