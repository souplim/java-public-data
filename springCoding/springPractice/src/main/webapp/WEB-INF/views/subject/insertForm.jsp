<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>insertForm.jsp</title>
		
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
		
		<script type="text/javascript" src="/resources/js/jquery-3.6.2.min.js"></script>
		<script type="text/javascript" src="/resources/js/common.js"></script>
		<script type="text/javascript" src="/resources/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function(){
				// 저장 버튼 클릭 시 처리 이벤트
				$("#insertBtn").click(function(){
					/* 유효성 검정 */
					if(!checkForm("#s_num","학과번호를")) return;
					else if(!checkForm("#s_name","학과이름을")) return;
					else {
						$("#insertForm").attr({
							"method" : "get",
							"action" : "/subject/subjectInsert"
						});
						$("#insertForm").submit();
					}
				});
				
				// 취소 버튼 클릭 시 처리 이벤트
				$("#cancelBtn").click(function(){
					$("#insertForm").each(function(){
						this.reset();
					});
				});
			});
		</script>
	</head>
	<body>
		<div class="col-xs-12"> <!-- import할 때 공간 적게 차지하기 위한 class -->
			<div class="text-center"><h2>학과 정보 입력</h2></div>
			
			<form class="form-horizontal" id="insertForm">
				<table class="table table-striped">
					<tr>
						<td>학과번호</td>
						<td><input type="text" id="s_num" name="s_num" class="form-control" /></td>
					</tr>
					<tr>
						<td>학과이름</td>
						<td><input type="text" id="s_name" name="s_name" class="form-control" /></td>
					</tr>
				</table>
				<div class="text-right">
					<button type="button" class="btn btn-default" id="insertBtn">저장</button>
					<button type="button" class="btn btn-default" id="cancelBtn">취소</button>
				</div>
			</form>
		</div>
	</body>
</html>