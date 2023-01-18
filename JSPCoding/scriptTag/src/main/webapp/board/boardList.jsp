<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.board.Board, com.board.BoardService" %>
<%
	ArrayList<Board> list = BoardService.getInstance().listBoard();
	int count = list.size();
%>
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
		<script type="text/javascript" src="/scriptTag/js/common.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#insertBtn").on("click", function(){
					location.href="<%=request.getContextPath()%>/board/boardForm.jsp";
				});
				
				$("#updateBtn").on("click", function(){
					location.href="<%=request.getContextPath()%>/board/boardUpdateForm.jsp";
				});
			});
		</script>
	</head>
	<body>
		<h1>게시판</h1>
		<button type="button" id="insertBtn">등록하기</button>
		<button type="button" id="updateBtn">수정하기</button>
		<table>
			<thead>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>내용</th>
				</tr>
			</thead>
			<%
				if(count>0){
					for(Board board : list){
				
			%>
			
			<tbody>
				<tr>
					<td><%=board.getBoardTitle()%></td>
					<td><%=board.getBoardWriter()%></td>
					<td><%=board.getBoardContent()%></td>
				</tr>
			
			<%
					}
				} else {
			%>
				<tr>
					<td colspan="3">불러올 게시글이 없습니다.</td>
				</tr>
			<%
				}
			%>
			</tbody>
		</table>
	</body>
</html>