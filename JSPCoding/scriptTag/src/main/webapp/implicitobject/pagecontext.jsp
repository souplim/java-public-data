<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSP 예제 pagecontext.jsp</title>
		
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
		<h2>pageContext 예제</h2>
		<%! 
		public void work(String param, PageContext page){
			try {
				JspWriter out = page.getOut();
				
				if(param==null){
					out.print("다음과 같은 형식으로 URL을 요청해야 정상 처리됩니다.<br/>");
					out.print("http://localhost:8080/scriptTag/implicitobject/pagecontext.jsp?param=include or forward");
					return;
				}
				
				if(param.equals("include")){
					out.print("-- include 전 -- <br/><hr/>");
					page.include("page.jsp");
					out.print("-- include 후 -- <br/><hr/>");
				} else if(param.equals("forward")){
					out.print("-- forward 전 -- <br/><hr/>"); // 출력되지 않음
					page.forward("page.jsp"); // 버퍼 값을 비우고 이동하기 때문에
				}
			} catch(Exception e){
				System.out.println("오류발생");
			}
		}
		%>
		<%
			String param = request.getParameter("param");
			this.work(param, pageContext); // this -> JSP 페이지 자체를 나타내는 객체
		%>
	</body>
</html>