<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>문서 examMethod</title>
		
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
		</style>
		<script type="text/javascript" src="/resources/js/jquery-3.6.2.min.js"></script>
		<script type="text/javascript" src="/resources/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#btn").click(function(){
					$.ajax({
						url : "/sample/examMethod", // 전송 url
						type : "post",					// 전송 시 method 방식
						data : $("form").serialize(),	// 폼 전체 데이터 전송
						dataType : "text",
						error : function(xhr, textStatus, errorThrown){
							alert(textStaus + "(HTTP-"+ xhr.status + " / " + errorThrown +")");
						},
						success : function(resultData){
							alert(resultData);
						}
					});
				});
			});
		</script>
	</head>
	<body>
		<div class="container">
			<div class="text-center"><h3>여러 폼 데이터를 하나의 요청 데이터로 보내기</h3></div>
			
			<form id="example" class="form-horizontal">
				<div class="form-group">
					<label for="no" class="col-sm=2 control-label">번 호</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="no" id="no" placeholder="번호 입력" />
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm=2 control-label">이 름</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="name" id="name" placeholder="이름 입력" />
					</div>
				</div>
				<div class="form-group">
					<label for="tno" class="col-sm=2 control-label">핸드폰</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="tno" id="tno" placeholder="핸드폰 번호 입력" />
					</div>
				</div>
				<div class="form-group">
					<label for="owner" class="col-sm=2 control-label">소유자</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="owner" id="owner" placeholder="소유자 입력" />
					</div>
				</div>
				<div class="form-group">
					<label for="grade" class="col-sm=2 control-label">등 급</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="grade" id="grade" placeholder="등급 입력" />
					</div>
				</div>
				
			</form>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" id="btn" class="btn btn-default">확인</button>
				</div>
			</div>

		</div>
	</body>
</html>