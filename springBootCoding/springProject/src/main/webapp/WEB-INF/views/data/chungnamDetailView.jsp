<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>
	<script type="text/javascript">
		$(function(){
			$(".contentLayout .page-header h1").html("충남관광 - 관광명소 상세정보");
			let mng_no = ${param.mng_no};
			console.log(mng_no);
		});
	</script>
	</head>
	<body>
		<div class="contentContainer container">
			
		</div>
	</body>
</html>