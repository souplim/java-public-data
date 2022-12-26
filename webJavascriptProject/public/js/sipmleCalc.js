// 빈 객체의 선언
let Calc = {}; // 비어 있는 형태로 만들었을 때 얼마든지 추가 가능

// 객체에 포함된 데이터 하나(이름과 값의 한쌍)를 가리켜 객체의 프로퍼티라고 한다
Calc.num1 = 0;
Calc.num2 = 0;

// 함수 객체의 참조를 값으로 담고 있는 프로퍼티를 가리켜 메서드라고 부른다.
Calc.setValue = function(num1, num2){
	this.num1 = num1;
	this.num2 = num2;
};

// 멤버변수 끼리의 덧셈결과를 리턴
Calc.plus = function(){
	return this.num1 + this.num2;
};

// 멤버변수 끼리의 뺄셈결과를 리턴
Calc.minus = function(){
	return this.num1 - this.num2;
};

Calc.result = function(oper, area){
	/** 어떤 메서드 안에서 같은 객체 안에 존재하는 다른 메서드를 호출하는 경우에도 "this."라는 예약어를 사용해야 한다. **/
	let value = 0;
	console.log("oper= "+oper);
	
	switch(oper){
		case "+" : value = this.plus(); break;
		case "-" : value = this.minus(); break;
	}
	area.innerHTML = value;
}

function showResult(){
	let pattern = /(^\d+$)/g;
	let resultArea = document.getElementById("resultArea");
	
	if(!pattern.test(document.getElementById("number1").value) && !pattern.test(document.getElementById("number2").value)){
		resultArea.innerHTML = "숫자만 가능";
		return;
	}
	
	let num1 = parseInt(document.getElementById("number1").value);
	let num2 = parseInt(document.getElementById("number2").value);
	
	Calc.setValue(num1, num2);
	let oper = document.getElementById("op").value;
	
	Calc.result(oper, resultArea);
	resultArea.style.color = "#000000";
}

function hideResult(){
	// document.getElementById("number1").value = "";
	// document.getElementById("number2").value = "";
	document.form.reset();
	document.getElementById("resultArea").innerHTML = "?";
	document.getElementById("resultArea").style.color = "red";
}

