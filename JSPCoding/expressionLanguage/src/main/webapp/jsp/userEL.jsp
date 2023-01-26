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
			
			// 이 예제를 작성하기 전에 com.text 패키지에 Apple 클래스를 생성해야함
			ArrayList<Apple> myList = new ArrayList<>();
			myList.add(new Apple("청색"));
			myList.add(new Apple("빨간색"));
			myList.add(new Apple("황색"));
			pageContext.setAttribute("list", myList);
			
			// 위에서 설정한 속성을 출력하기 위해 지금까지 아래와 같이 코딩함
			// @SuppressWarnings("unchecked")
			// ArrayList<Apple> list = (ArrayList<Apple>)pageContext.getAttribute("list");
			// out.print((list.get(0)).getColor());
			
			HashMap<String, String> map = new HashMap<>();
			map.put("uname","홍길동");
			map.put("uid","javauser");
			pageContext.setAttribute("map",map);
			
			// 위에서 설정한 속성을 출력하기 위해 지금까지 아래와 같이 코딩함
			// @SuppressWarnings("unchecked")
			// HashMap<String, String> map1 = (HashMap<String, String>)pageContext.getAttribute("map");
			// out.print(map1.get("uname"));
		%>
		
		<%-- 위의 속성을 표현언어로 출력 --%>
		<h3>객체의 멤버 접근</h3>
		<div>&{pageScope.today.year}년 ${today.month}월 ${today.date}일</div>
		<%-- ${객체명.필드명(속성명)} -> 객체명.getXXX() 접근자 호출 --%>
		
		<h3>컬렉션의 객체 사용(ArrayList / HashMap)</h3>
		<div>${ pageScope.list[0].color }-${ list[1].color }-${ list[2].color }</div>
		<%-- ${컬렉션[인덱스].필드명(속성명)} -> 컬렉션인스턴스명.get(인덱스).getXXX() 호출 --%>
		<div>${ map.uname } - ${ map.uid }</div>
		<%-- ${map인스턴스명.key이름} -> map인스턴스명.get("key이름") 호출 --%>
		
		<%-- 이 예제를 작성하기 전에 com.text 패키지에 LangaugeInfoBean 클래스를 생성해야 함 --%>
		<h3>클래스의 정적 멤버 사용</h3>
		${ LanguageInfoBean.name }<br/>
		${ LanguageInfoBean.getBirthYear() }<br/>
		${ LanguageInfoBean.getKindInfo() }<br/>
		
		<%-- 이 예제를 작성하기 전에 com.book 패키지에 BookVO 클래스를 생성해야 함 --%>
		<h3>책정보 출력</h3>
		<jsp:useBean id="bookVO" class="com.book.BookVO" scope="page" />
		<jsp:setProperty property="title" name="bookVO" value="가자, 길이 보이지 않아도" />
		<jsp:setProperty property="author" name="bookVO" value="이호준" />
		<jsp:setProperty property="publisher" name="bookVO" value="꽃길" />
		
		<label>책제목 : </label>${ bookVO.title }<br/>
		<label>책저자 : </label>${ bookVO.author }<br/>
		<label>출판사 : </label>${ bookVO.publisher }<br/>
		
		<%-- 이 예제를 작성하기 전에 com.grade 패키지에 StudentGrade 클래스를 생성해야 함 --%>
		<h3>EL 메서드 호출</h3>
		<%
			StudentGrade grade = new StudentGrade();
			request.setAttribute("grade", grade);
			
			BookVO book = new BookVO();
			request.setAttribute("book", book);
		%>
		${ grade.setAverage(1,2,3) }
		${ "평균 : " += grade.getAverage() }<br/>
		
		${ book.setTitle("자바") }
		${ "제목 : " += book.getTitle() }
	</body>
</html>
