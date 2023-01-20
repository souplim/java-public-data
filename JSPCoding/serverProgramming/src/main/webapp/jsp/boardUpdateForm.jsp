<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.board.vo.Board"%>
<%
	request.setCharacterEncoding("UTF-8");

	int boardNum = Integer.parseInt(request.getParameter("boardNum")) ;
	String boardWriter = request.getParameter("boardWriter");
	String boardTitle = request.getParameter("boardTitle");
	String boardContent = request.getParameter("boardContent");
	
	Board board = new Board();
	board.setBoardNum(boardNum);
	board.setBoardWriter(boardWriter);
	board.setBoardTitle(boardTitle);
	board.setBoardContent(boardContent);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			.container {display:flex; justify-content: center;}
			body, table, input{font:12px 돋음;}
			table{width:42  0px; border-spacing :0px; border:1px solid #000000; 
		  			border-bottom:0px; text-align:center;}
			th, td{border-bottom:1px solid #000000; padding:4px;}
			input{width:250px;}  
			#subBtn{width:100px;}
		</style>
		<script type="text/javascript" src="/serverProgramming/js/jquery-3.6.2.min.js"></script>
	</head>
	<body>
		<div align="center">
			<form action="<%=request.getContextPath()%>/update" method="post">
				<input type="hidden" name="boardNum" value="<%=board.getBoardNum()%>" />
				<table>
					<tr>
						<td>제목</td>
						<td>
							<input type="text" name="boardTitle" value="<%=board.getBoardTitle()%>" />
						</td>
					</tr>	
					<tr>
						<td>작성자</td>
						<td>
							<input type="text" name="boardWriter" value="<%=board.getBoardWriter()%>" />
						</td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea name="boardContent" cols="50" rows="7">
								<%=board.getBoardContent()%>
							</textarea>
						</td>
					</tr>
					<tr>
				  		<td colspan="2">
					  		<button type="button" onclick="history.back();">취소</button>
							<button type="submit">수정하기</button>
				  		</td>
			  		</tr>
				</table>
			</form>
		</div>
	</body>
</html>