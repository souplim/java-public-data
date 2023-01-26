<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.member.User, com.date.Today, com.test.Apple, java.util.ArrayList, java.util.HashMap" %>
<%@ page import="com.test.LanguageInfoBean, com.grade.StudentGrade, com.book.BookVO" %>
<%
	User member = new User();
	member.setUname("홍길동");
	member.setUid("goodday");
	member.setUnum(19010001);
	
	com.member.Address add = new com.member.Address();
	add.setCity("서울시 강남구 역삼동");
	add.setZipcode("06123");
	
	member.setAddress(add);
	out.print(member.getUname());
	out.print(member.getAddress().getCity());
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>표현언어에서 액션태그 이용</title>
		
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
		<h3>접근자로 데이터 출력(표현식 이용)</h3>
		<label>uname :</label><%=member.getUname()%><br/>
		<label>uid :</label><%out.print(member.getUid());%><br/>
		<label>unum :</label><%=member.getUnum()%><br/>
		
		<h3>인스턴스 생성 및 필드값 설정(액션태그 이용)</h3>
		<jsp:useBean id="user" class="com.member.User" scope="page"/>
		
		<jsp:setProperty property="uname" name="user" value="김늘봄"/>
		<jsp:setProperty property="uid" name="user" value="javauser"/>
		<jsp:setProperty property="unum" name="user" value="19050001"/>
		<!-- has-a 관계 설정 -->
		<jsp:useBean id="address" class="com.member.Address" scope="page"/>
		
		<jsp:setProperty property="city" name="address" value="서울특별시 강남구"/>
		<jsp:setProperty property="zipcode" name="address" value="04715"/>
		
		<jsp:setProperty property="address" name="user" value="${address}"/>
		
		<h3>액션태그에서 자바빈즈 getter 호출</h3>
		<label>uname :</label>
		<jsp:getProperty property="uname" name="user"/><br/>
		<label>uid :</label>
		<jsp:getProperty property="uid" name="user"/><br/>
		<label>unum :</label>
		<jsp:getProperty property="unum" name="user"/><br/>
		
		<h3>표현언어에서 자바빈즈 getter 호출</h3>
		<label>uname :</label>${user.uname}<br/>
		<label>uname :</label>${user.getUname()}<br/>
		<label>uid :</label>${user.uid}<br/>
		<label>unum :</label>${user.unum}<br/>
		
		<h5>표현언어에서 자바빈즈 getter 호출(has-a 관계 출력)</h5>
		<label>address city : </label>${user.address.city}<br/>
		<label>address zipcode : </label>${user.address.zipcode}<br/>
		
		<h2>객체의 getter 메서드, 컬렉션 객체의 원소</h2>
		<hr>
		<%
			// 이 예제를 작성하기 전에 com.date 패키지에 Today 클래스를 생성해야 함
			pageContext.setAttribute("today", new Today());
			// 위에서 설정한 속성을 출력하기 위해 지그까지 아래와 같이 코딩하였음
			// Today now = (Today)request.getAttribute("today");
			// out.print(now.getYear()+"년 "+now.getMonth()+"월 "+now.getDate()+"일");
		%>
	</body>
</html>
