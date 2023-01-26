<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>책 정보 입력 예제 : bookInput.jsp</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		
		<script type="text/javascript" src="/scriptTag/js/jquery-3.6.2.min.js"></script>
		<script type="text/javascript" src="/scriptTag/js/common.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#submitBtn").on("click",function(){
					if(!chkData('#title','책제목을')) return;
					else if(!chkData('#author','책저자를')) return;
					else if(!chkData('#publisher','출판사를')) return;
					else {
						$("#frm").attr({
							"method" : "post",
							"action" : "bookResult.jsp"
						});
						$("#frm").submit();
					}
				});
			});
		</script>
	</head>
	<body>
		<form id="frm">
			<label>책제목: </label>
			<input type="text" name="title" id="title"><br/>
			
			<label>책저자: </label>
			<input type="text" name="author" id="author"><br/>
			
			<label>출판사: </label>
			<input type="text" name="publisher" id="publisher"><br/>
			
			<button type="button" id="submitBtn">등록</button>
		</form>
	</body>
</html>