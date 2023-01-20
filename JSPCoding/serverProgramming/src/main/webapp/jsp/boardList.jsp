<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.board.vo.Board, com.board.service.BoardService" %>
<%
	ArrayList<Board> list = BoardService.getInstance().listBoard();
	int count = list.size();
	
/* 	int boardNum;
	Board board = new Board();
	board.setBoardNum(boardNum);
	request.setAttribute("board", board);
	RequestDispatcher dispatcher = request.getRequestDispatcher("scriptTag/board/boardUpdateForm.jsp"); */
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
		<style type="text/css">
			.container {display:flex; justify-content: center;}
			body { font:12px/2em "돋움"; }
			
			div#boardList{width:600px; float: left;}
			div#boardList table{border-collapse:collapse; width:600px; margin:0 auto; margin-top:8px;}
			div#boardList thead > div#boardList tr{background-color:#ececec}
			div#boardList th, div#boardList td{border:1px solid black;}
			td{padding-left:5px;}
			.center{text-aling:center; podding:0;}
		</style>
		
		<script type="text/javascript" src="/serverProgramming/js/jquery-3.6.2.min.js"></script>
		<script type="text/javascript" src="/serverProgramming/js/common.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#insertBtn").on("click", function(){
					location.href="<%=request.getContextPath()%>/jsp/boardForm.jsp";
				});
				
				$(".updateBtn").on("click", function(){
					const boardNum = $(this).parents('.boardnumber').data('no');
					const boardWriter = $(this).parents('.boardnumber').find('.writer').text();
					const boardTitle = $(this).parents('.boardnumber').find('.title').text();
					const boardContent = $(this).parents('.boardnumber').find('.content').text();
					
					$('#num').val(boardNum);
					$('#writer').val(boardWriter);
					$('#title').val(boardTitle);
					$('#content').val(boardContent);
				
					$("#boardForm").attr({
						"method" : "post",
						"action" :	"/serverProgramming/jsp/boardUpdateForm.jsp"
					});
					$("#boardForm").submit();
				});
				
				$(".delBtn").on("click", function(){
					if(confirm('선택하신 항목을 정말로 삭제하시겠습니까?')){
						const boardNum = $(this).parents('.boardnumber').data('no');
						location.href='/serverProgramming/boardDelete?boardNum='+boardNum;
					}
				});
			});
		</script>
	</head>
	<body>
		<div class="container">
			<div id="boardList">
				<h1>게시판</h1>
				<button type="button" id="insertBtn">등록하기</button>
				<form id="boardForm">
					<input type="hidden" id="num" name="boardNum"/>
					<input type="hidden" id="writer" name="boardWriter"/>
					<input type="hidden" id="title" name="boardTitle"/>
					<input type="hidden" id="content" name="boardContent"/>
				</form>
				
				<table>
					<colgroup>
						<col width="10%" />
						<col width="25%" />
						<col width="40%" />
						<col width="25%" />
					</colgroup>
					<thead>
						<tr>
							<th>작성자</th>
							<th>제목</th>
							<th>내용</th>
							<th>게시물 수정, 삭제</th>
						</tr>
					</thead>
					<tbody>
					<%
						if(count>0){
							for(Board board : list){
					%>
						<tr class="boardnumber" data-no="<%=board.getBoardNum()%>">
							<td class="writer"><%=board.getBoardWriter()%></td>
							<td class="title"><%=board.getBoardTitle()%></td>
							<td class="content"><%=board.getBoardContent()%></td>
							<td class="center">
								<button type="button" class="updateBtn">수정하기</button>
								<button type="button" class="delBtn">삭제하기</button>
							</td>
						</tr>
					
					<%
							}
						} else {
					%>
						<tr>
							<td colspan="4">불러올 게시글이 없습니다.</td>
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>