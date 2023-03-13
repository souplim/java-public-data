<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>
		
		<script type="text/javascript">
			$(function(){
				// close 인스턴스 메소드가 호출되는 즉시 실행
				$("#errorAlert").on("closed.bs.alert", function(){
					location.href="/";
				});
				$("#main").on("click", function(){
					location.href="/";
				});
			});
		</script>
	</head>
	<body>
		<%-- 이 부분은 개발 당시에 사용하면 됨(예외 메시지를 확인하기 위해서) 
		<h4><c:out value="${exception.getMessage()}"></c:out></h4>
		<ul>
			<c:forEach items="${exception.getStackTrace()}" var="stack">
				<li><c:out value="${stack}"></c:out></li>	
			</c:forEach>
		</ul>--%>
		
		<%-- 개발이 완료되면 이 부분을 주석해제 하면 됨 --%>
		<div class="alert alert-warning alert-dismissible fade in" role="alert" id="errorAlert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span></button>
			<h4>잘못된 URL을 요청하셨습니다.</h4>
			<p>
				해당 URL은 존재하지 않습니다. 잠시 후 다시 접근해주세요.<br/>
				감사합니다<br/>
			</p>
			<p>
				<button type="button" class="btn alert-warning" id="main">홈으로</button>
			</p>
		</div>
	</body>
</html>