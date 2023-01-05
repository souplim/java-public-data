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
	</head>
	<body>
	<% 
		// 숫자를 저장한 변수 3개(7, 5, 9)를 정의하고 최대값 구하기
		int var1 = 7;
		int var2 = 5;
		int var3 = 9;
		int max;
		int count=0;
		
		max = var1;
		
		if(var2>max)
			max = var2;
		if(var3>max)
			max = var3;
		
		out.println("<p>");
		out.println("최대값은 : " + max);
		out.println("</p>");
	%>
	<p>
		최대값은 : <%=max%> 
	</p>
	
	<%
		// 배열의 값(12, 26, 68, 98, 76, 54, 8, 6, 4) 중 최대값과 최소값 구하기
		int[] arr = {12, 26, 68, 98, 76, 54, 8, 6, 4};
		int max2 = arr[0];
		int min2 = arr[0];
		for(int i=1; i<arr.length; i++){
			if(arr[i]>max2)
				max2 = arr[i];
			if(arr[i]<min2)
				min2 = arr[i];
		}
	%>
	<p>
		최소값 : <%=min2%>
		최대값 : <%=max2%> 
	</p>
	
	<%
		// 문자열 추출하기
		String str = "동해 물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세";
		int length = str.length();
		int idx = str.indexOf('닳');
		char cha = str.charAt(15);
	%>
	<p>
		"동해 물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세" => <%=length%>자이며, '닳'은 <%=idx%>번째에 있다.<br/>
		"동해 물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세" 의 15번째 문자는 '<%=cha%>'이다.
	</p>
	</body>
</html>
