<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>Insert title here</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		<script type="text/javascript" src="/scriptTag/js/jquery-3.6.2.min.js"></script>
	</head>
	<body>
		<form action="<%= request.getContextPath() %>/boardInsert" method="post">
			<table>
				<tr>
					<td>제목</td>
			        <td><input type="text" name="boardTitle​​" id="boardTitle​​"></td>
		        </tr>
			  	<tr>
			  		<td>작성자</td>
			        <td><input type="text" name="boardWriter​" id="boardWriter​"></td>
		        </tr>
			 	<tr>
			 	 	<td>내용</td>
			        <td><textarea cols="50" rows="7" name="boardContent​" id="boardContent"></textarea></td>
		        </tr>
			  	<tr>
			  		<td colspan="2">
				  		<input type="submit" value="등록하기">  
				  		<a href="<%=request.getContextPath()%>/boardList.jsp">목록으로</a>
			  		</td>
			  		</tr>
			</table>
		</form>
	</body>
</html>