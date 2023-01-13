<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%!
	/* 합을 구하는 메서드 */
	// 선언문은 전역변수(필드), 메서드들 -> 클래스 안에 선언되기 때문에 위치는 중요하지 않음
	// 아래쪽에 선언해도 됨
	int sum(int a, int b){
		int result=0;
		for(int i=a; i<=b; i++){
			result += i;
		}
		return result;
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>첫페이지 작성 - hello.jsp</title>
		
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
		<h1>JSP 페이지 실행</h1>
		<p>JSP 파일은 반드시 서블릿 파일로 변환된다.</p>
		<p>서블릿 파일은 클래스 파일로 컴파일 된다.</p>
		<p>컴파일된 파일은 다시 메모리에 적재되고 인스턴스 생성 후 _jspService() 메서드를 호출하여 사용자에게 응답하게 된다.</p>

		<h4>JSP로 구현한 구구단 - 단을 입력받아 해당하는 단만 출력 1</h4>
		<%
			int dan = 5;
			if(request.getParameter("dan")!=null){ // 브라우저에서 변수 주면 이것으로 실행
				dan = Integer.parseInt(request.getParameter("dan"));
			}
			
			if(dan >= 1 && dan <= 9)
				for(int i=1; i<=9; i++)
					out.println(dan + " x " + i + " = " + (dan*i)+ "<br/>");
		%>
		<h4>JSP로 구현한 구구단 - 단을 입력받아 해당하는 단만 출력 2</h4>
		<% 
			// 중간에 스크립트릿 닫고 표현식 열고... 가독성 떨어짐. 이를 액션 태그로 만들다가... 사용자 태그 사용
			// http://localhost:8080/scriptTag/jsp/hello.jsp?dan=9 브라우저에서 get방식으로 변수 주기
			if(dan >=1 && dan <= 9){
				for(int i=1; i<=9; i++){
		%>
				<%= dan %> x <%=i %> = <%=dan*i %><br/>
		<%
				}
			}
		%>
		
		<%! double radius = 4.8; %>
		<%!
			// 원의 면적을 구하는 메서드
			public double getArea(double r){
				return r * r * 3.14;
			}
		%>
		<%-- 위의 태그는 선언문으로 메서드의 선언이나 멤버변수(필드,전역변수)를 정의하고자 할 때 사용. --%>
		반지름이 <%= radius %>인
		원의 면적은 <%= getArea(radius) %>이다.
		
		<%! 
			// Calendar는 java.lang에 없으므로 자동 import 안 됨 
			char getKorDay(){
				char result = ' ';
				int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
				switch(day){
				case 1: result = '일'; break;
				case 2: result = '월'; break;
				case 3: result = '화'; break;
				case 4: result = '수'; break;
				case 5: result = '목'; break;
				case 6: result = '금'; break;
				case 7: result = '토'; 
				}
				return result;
			}
		%>
		<p>
			<% int i = 0; %>
			<label>[지역변수] i = <%= ++i %></label>
		</p>
		<p>
			<label>[전역변수/필드] memi = <%= ++memi %></label>
			<%! 
				// 선언문은 class 바로 밑에 들어가기 때문에 memi가 위에 있더라도 에러 없이 사용 가능 
				// 객체가 사라지기 전까지 유효하므로 새로고침 하면 계속 1씩 증가함
				int memi = 0; 
			%>
		</p>
		
		<!-- 1부터 10까지의 합 구하기 (직접 sum 메서드 선언해주세요) -->
		<p>
			<%= "1부터 10까지의 합은 "+ sum(1, 10) + " 입니다" %>
		</p>
		
		
		
	</body>
</html>