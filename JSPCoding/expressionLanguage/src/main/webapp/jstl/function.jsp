<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>JSTL function Tag: (function.jsp)</title>
		
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
		<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
		
		<h2>JSTL Function Tag: functions</h2>
		<c:set var="str1" value="test String"/>
		<c:set var="str2" value="<a href='${contextPath}/jstl/request.html'>여기</a>를 클릭해서 이동"/>
		
		<p>str1 출력 : ${str1}</p>
		<p>str2 출력 : ${str2}</p>
		<p>str2 출력 : ${fn:escapeXml(str2)}</p>
		
		<c:if test="${fn:contains(str1, 'test')}">
			<p>test 문자열이 해당 데이터에 포함됨</p>
		</c:if>
		
		<p>indexOf(str1,'t') : ${fn:indexOf(str1,'t')}</p>
		<p>length(str2) : ${fn:length(str2)}</p>
		
		<c:set var="spStr" value="${fn:split(str1, ' ')}" />
		<p>
			fn:split(str1, ' ') 수행후 원소값: <br/>
			<c:forEach var="data" items="${spStr}" varStatus="status">
				${status.count}. ${data} <br/>
			</c:forEach>
		</p>		
		<p>join(str1,'-') : ${fn:join(spStr,'-')}</p>
		
		<p>replace(str1,'test','테스트') : ${fn:replace(str1, 'test','테스트')}</p>
		<p>startsWith(str1, 'test') : ${fn:startsWith(str1,'test')}</p>
		
		<p>substring(str1,0,3) : ${fn:substring(str1,0,3)}</p>
		<p>substringAfter(str1, ' ') : ${fn:substringAfter(str1, ' ')}</p>
		
		<p>toLowerCase(str1) : ${fn:toLowerCase(str1)}</p>	
		<p>toUpperCase(str1) : ${fn:toUpperCase(str1)}</p>	
	</body>
</html>