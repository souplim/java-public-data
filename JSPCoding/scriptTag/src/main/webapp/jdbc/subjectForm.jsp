<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSP 예제 : subjectForm.jsp</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		<style type="text/css">
			body, table, input{font:12px 돋음;}
			table{width:400px; border-spacing :0px; border:1px solid #000000; 
		  			border-bottom:0px; text-align:center;}
			th, td{border-bottom:1px solid #000000; padding:4px;}
			input[type="text"],input[type="password"],
			input[type="email"],input[type="date"],select{width:180px;}  
			.ls3{letter-spacing:3px}
			.ls5{letter-spacing:5px}
		</style>
		
		<script type="text/javascript" src="/scriptTag/js/jquery-3.6.2.min.js"></script>
		<script type="text/javascript" src="/scriptTag/js/common.js"></script>
		<script type="text/javascript">
			$(function(){
				// 입력완료 버튼 제어
				$("#insertBtn").on("click", function(){
					if(!chkData("#s_num","학과번호를")) return;
					else if(!chkData("#s_name","학과명을")) return;
					else {
						$("#subject").attr({
							"method" : "post",
							"action" : "/scriptTag/insert" <!-- /scriptTag -> request.getContextPath() -->
						});
						$("#subject").submit();
					}
				});
				
				// 다시쓰기 버튼 제어
				$("#resetBtn").on("click", function(){
					$("#subject").each(function(){
						this.reset();
					});
				});
				
				// 목록 버튼 제어
				$("#listBtn").on("click", function(){
					location.href="/scriptTag/list";
				});
			});
		</script>
	</head>
	<body>
		<h3>테이블 subject 학과 정보 등록 프로그램</h3>
		<hr/>
		<form name="subject" id="subject">
			<table summary="학과 정보 등록을 위한 입력 페이지">
				<colgroup>
					<col width="100"></col>
					<col width="300"></col>
				</colgroup>
				<thead>
					<tr><th colspan="2">학과 정보 등록</th></tr>
				</thead>
				<tbody>
					<tr>
						<th class="ls5">학과번호</th>
						<td><input type="text" name="s_num" id="s_num" maxlength="14" /></td>
					</tr>
					<tr>
						<th class="ls3">학과명</th>
						<td><input type="text" name="s_name" id="s_name" maxlength="8" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input type="button" value="입력완료" id="insertBtn" />
							<input type="button" value="다시쓰기" id="resetBtn" />
							<input type="button" value="목록" id="listBtn" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>
