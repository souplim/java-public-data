<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>formatNumber - formatNumber.jsp</title>
		
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
		<h4>formatNumber 태그</h4>
		<%--
			formatNumber: 숫자, 통화, 퍼센트를 표시하기 위해 사용하는 태그
			- value: 숫자값 지정
			- type: number(기본값), currency(통화), percent(퍼센트)로 표현
			- groupingUsed: 천단위로 콤마 구분자 표시 여부. true/false
			- maxIntegerDigits / minIntegerDigits: 정수의 최대/최소 자릿수
			- maxFractionDigits / minFractionDigits: 소숫점 이하 자릴수
		 --%>
		 <p>
		 	<c:set var="price" value="10000" />
		 	<fmt:formatNumber value="${ price }" type="number" var="numberType" /><br/>
		 	<label>숫자 : ${ numberType }</label><br/>
		 	<label>통화 : <fmt:formatNumber value="${ price }" type="currency" currencySymbol="$" /></label><br/>
		 	<%-- currencySymbol 속성값 설정할 때 ㄹ+한자키로 기호 명시 --%>
		 	
		 	<c:set var="price" value="0.85" />
		 	<label>퍼센트: <fmt:formatNumber value="${ price }" type="percent" groupingUsed="false" /></label><br/>
		 	
		 	<c:set var="price" value="100000" />
		 	<label>패턴: <fmt:formatNumber value="${price}" pattern="00000000.00"/></label>
		 </p>
		 <p>
		 	<fmt:formatNumber value="4578.8743" type="number" maxIntegerDigits="3" /><br/>
		 	<fmt:formatNumber value="2" 		type="number" maxIntegerDigits="2" groupingUsed="false"/><br/>
		 	<fmt:formatNumber value="4578.8743" type="number" maxIntegerDigits="2" /><br/>
		 	<fmt:formatNumber value="4578" 		type="number" maxIntegerDigits="1" /><br/>
		 </p>
		 
		 <h4>parseNumber 태그</h4>
		 <p>
		 	<fmt:parseNumber value="1,234.56" pattern="0,000.000" var="num1"/>
		 	<fmt:parseNumber value="123" var="num2"/>
		 	<fmt:parseNumber type="number" value="${num1 + num2}" />
		 </p>
	</body>
</html>