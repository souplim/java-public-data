<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>
	<script type="text/javascript">
		$(function(){
			$(".contentLayout .page-header h1").html("충남관광 - 관광명소 상세정보");
			let mng_no = ${param.mng_no};
			console.log(mng_no);
			
			// 화살표 함수(Arrow functions)는 => 구문을 사용한 함수 축약 표현. 함수가 반환할 값은 표현식의 결과가 됨
			const fruits = [{name: 'Apple', price: 100}, {name: 'Orange', price: 80}, {name:'Banana', price: 120}];
			
			/* let countFruits = function(){
				return fruits.length;
			}; */
			// 화살표함수로 나타낼 때 인자 없으면 빈 괄호 세트가() 필요
			let countFruits = () => fruits.length;
			
			let result1 = countFruits();
			console.log("result1: "+result1);
			
			/* let sum = function(num1, num2){
				return num1+num2;
			}; */
			
			let sum = (num1, num2) => num1 + num2;
			let result2 = sum(3,5);
			console.log("result2: "+result2);
		});
	</script>
	</head>
	<body>
		<div class="contentContainer container">
			
		</div>
	</body>
</html>
