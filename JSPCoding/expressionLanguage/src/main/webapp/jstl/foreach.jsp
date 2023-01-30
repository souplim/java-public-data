<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.user.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSTL Core: forEach(foreach.jsp)</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		<style type="text/css">
			table{border-collapse:collapse}
			td{background-color:#F7F7F7; border: 1px solid #000000; padding:6px;} 
		</style>
	</head>
	<body>
		<h2>JSTL Core Tag: forEach</h2>
		<h3>배열 처리</h3>
		<c:set var="score" value="<%= new int[]{95,88,77,45,99} %>" />
		
		<c:set var="sum" value="0" />
		점수 :
		<c:forEach var="point" items="${ score }" >
			${ point }
			<c:set var="sum" value="${ sum + point }" />
		</c:forEach>
		<br/> 합 = ${ sum } <br/>
		
		<h3>1부터 100까지 합</h3>
		<c:set var="sum" value="0" />
		<c:forEach var="i" begin="1" end="100" >
			<c:set var="sum" value="${ sum + i }" />
		</c:forEach>
		결과 = ${ sum } <br/>
		
		<h3>Map인 sessionScope 처리</h3>
		<c:set target="${ sessionScope }" property="name" value="홍길동" />
		<c:set target="${ sessionScope }" property="id" value="dong" />
		<c:set target="${ sessionScope }" property="passwd" value="1234" />
		
		<c:forEach var="i" items="${ sessionScope }" >
			${i.key} = ${i.value}<br/>
		</c:forEach>
		
		<h3>ArrayList 원소 반복</h3>
		<%
			ArrayList<User> userList = new ArrayList<User>();
			userList.add(new User("홍길동","javajsp",180701));
			userList.add(new User("김희진","jspuser",180702));
			userList.add(new User("이철수","dbadmin",180703));
			pageContext.setAttribute("list",userList);
		%>
		<%-- <c:set var="list" value="<%=userList%>" /> --%>
		<c:forEach var="member" items="${list}" varStatus="status">
			${status.count}. ${member.uname} / ${member.uid} / ${member.unum} <br/>
		</c:forEach>
		
		<h3>2단부터 9단까지 출력</h3>
		<table>
			<c:forEach var="i" begin="1" end="9">
				<tr>
					<c:forEach var="j" begin="2" end="9">
						<td>${j} * ${i} = ${i*j}</td>
					</c:forEach>				
			</c:forEach> 
		</table>
		
		<h3>[Map(맵)]</h3>
		<c:set var="map" value="<%= new java.util.TreeMap<String, String>() %>" />
		<c:set target="${map}" property="홍길동" value="30"/>
		<c:set target="${map}" property="김철수" value="28"/>
		<c:set target="${map}" property="이진희" value="20"/>
		
		<c:forEach var="data" items="${map}">
			[${data.key} = ${data.value}]
		</c:forEach>
		
		<h3>[배열]</h3>
		<c:set var="intArray" value="<%= new int[] {1,2,3,4,5} %>" />
		<c:forEach var="i" items="${intArray}" begin="2" end="4">
			[${i}]
		</c:forEach>
		
		<h3>값을 변화시키면서 반복처리</h3>
		<c:set var="sum" value="0"/>
		<c:forEach var="i" begin="1" end="100" step="2">
			<c:set var="sum" value="${sum+i}"/>
		</c:forEach>
		<h4>결과 = ${sum}</h4>
		
		<h4>구구단: 4단</h4>
		<c:forEach var="i" begin="1" end="9">
			4 * ${i} = ${4*i}<br/>
		</c:forEach>
		
		<hr/>
		<h2>JSTL Core Tag: forTokens</h2>
		<p>
			<c:forTokens var="token" items="소설/역사/인문/정치/미술/종교/여행/과학/만화/건강" delims="/" >
				${token}
			</c:forTokens>
		</p>
		<hr/>
		<c:set var="str" value="JSTL은 표준태그로서 코어, XML, 국제화, SQL, 함수 관련 태그로 구성된다."/>
		<p>${str}</p>
		<hr/>
		위 문장은 forTokens의 속성 delims=" ,.은로서된다" 지정으로 다음 단어로 나뉘어진다.<hr/>
		<!-- delim=" ,.은로서된다" -> 명사만 남기고 구분하기 -->
		<p>
			<c:forTokens var="token" items="${str}" delims=" ,.은로서된다" varStatus="status">
				${status.count}. ${token}<br/>
			</c:forTokens>
		</p>
		<p>
			콤마와 점을 구분자로 사용:<br/>
			<c:forTokens var="token" items="빨강색,주황색.노란색.초록색,파랑색,남색.보라색" delims=",.">
				<button type="button">${token}</button>
			</c:forTokens>
		</p>
		<hr/>
		<p>
			<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤" />
			<c:forTokens var="token" items="${fruits}" delims="," >
				${token} <br/>
			</c:forTokens>
		</p>
	</body>
</html>