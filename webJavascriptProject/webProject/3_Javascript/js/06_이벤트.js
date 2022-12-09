// 인라인 이벤트 모델 확인하기
function test1(button){
    button.style.backgroundColor = "gold";
    button.style.color = "brown";
}

//고전 이벤트 모델 확인하기

// ** 주의사항 **
// 고전/표준 이벤트 모델은 랜더링된 HTML 요소에 
// 이벤트 관련된 동작을 부여하는 코드

// -> 랜더링이 되지 않은 요소에는 이벤트 관련 동작을 추가할 수 없음!
// HTML 문서 읽기 전 script 문서 읽기 때문에 "test2-1"을 해석할 수 없음 -> null
// (문제 원인 : HTML 코드 해석 순서 (위->아래))
// --> 해결 방법 : HTML 요소가 먼저 랜더링 된 후 JS코드 수행하기 하면 됨 -> script태그 아래로 위치

console.log(document.getElementById("test2-1"));
document.getElementById("test2-1").onclick = function(){
    // 익명 함수(이벤트 핸들에 많이 사용함)

    alert("고전 이벤트 모델로 출력된 대화상자");
}

// 이벤트 제거
document.getElementById("test2-2").onclick = function(){
    // test2-1 이벤트 제거
    document.getElementById("test2-1").onclick = null;
    alert("test2-1 이벤트를 제거하였습니다.");
}

// 고전 이벤트 모델 단점
// -> 한 요소에 동일한 이벤트 리스너(onclick)에 대한 
// 다수의 이벤트 핸들러(배경색 변경, 폰트색 변경)를 작성할 수 없다.
// (마지막으로 해석된 이벤트 핸들러만 적용됨)

// 해결 방법 : 표준 이벤트 모델 사용
document.getElementById("test2-3").onclick = function(event){

    // 버튼 색 바꾸기 (이벤트 자체 선택하는 방법 3개)

    // 방법 1) 요소(태그전체 즉 속성+속성값+내용)를 문서에서 찾아서 선택
    // document.getElementById("test2-3").style.backgroundColor = "gold";

    // 방법 2) 매개변수 e 또는 event 활용하기
    // -> 이벤트 핸들러에 e 또는 event 작성하는 경우
    //    해당 이벤트와 관련된 모든 정보(버튼의 위치 등등등)가 담긴 이벤트 객체가 반환된다.
    console.log(event);

    // event.target : 이벤트가 발생한 요소
    // event.target.style.backgroundColor = "gold";

    // 방법 3) this 활용하기 -> 이벤트가 발생한 요소 ( <button id="test2-3">고전 이벤트 모델 단점</button> )
    // event.target과 동일
    console.log(this);
    this.style.backgroundColor = "gold";
}

// 같은 이벤트 리스너에 이벤트 핸들러 작성한 것 까먹고 아래와 같은 코드 작성했다면...
/* document.getElementById("test2-3").onclick = function(){
    // 버튼 색 바꾸기
    // 방법 1) 요소(태그전체 즉 속성+속성값+내용)를 문서에서 찾아서 선택
    document.getElementById("test2-3").style.color = "pink";
} */

// 표준 이벤트 모델
/*
    요소.addEventListener("click", function(){} )
                           이벤트  이벤트 핸들러 클릭이라는 이벤트 감지 되면 function()이라는 이벤트 더해줄 것
*/
document.getElementById("test3").addEventListener("click", function(){
    // this : 이벤트가 발생한 요소
    console.log(this.clientWidth); // 현재 요소의 너비(테두리 제외)

    // this.style.width = "300px" // 현재 요소 너비 변경
    
    this.style.width = this.clientWidth + 20 + "px";
    
})

// test3에 이미 click 이벤트에 대한 동작이 존재하는데
// 중복해서 적용(고전 이벤트 모델 문제점 해결 확인)
document.getElementById("test3").addEventListener("click", function(){
    //높이 증가
    this.style.height = this.clientHeight + 20 + "px";
})

// 이벤트 복습 문제
// 1. 고전 이벤트 모델
// document.getElementById("changeBtn1").onclick = function(){
//     document.getElementById("div1").style.backgroundColor = document.getElementById("input1").value + "";
// }

// 2. 표준 이벤트 모델
document.getElementById("changeBtn1").addEventListener("click", function(){
/*     const div1 = document.getElementById("div1");
    const input1 = document.getElementById("input1");

    // input1에 작성된 값 얻어오기
    const bgColor = input1.value;

    // div1 배경색 변경
    div1.style.backgroundColor = bgColor; */

    // 한 줄로 작성
    document.getElementById("div1").style.backgroundColor = document.getElementById("input1").value;
})

// input1에 값이 변경되었을 때 입력된 값으로 배경색 변경
document.getElementById("input1").addEventListener("change", function(){
    // change 이벤트
    // - text 관련 input 태그는
    // 입력된 값이 변할 때를 change라고 하지 않고
    
    // 입력이 완료된 후 포커스를 잃거나, 엔터를 입력하는 경우
    // 입력된 값이 이전과 다를 경우를 change 이벤트가 발생한 것으로 인식

    // document.getElementById("div1").style.backgroundColor = document.getElementById("input1").value;
    // this(이벤트가 발생된 요소) 사용해서
    document.getElementById("div1").style.backgroundColor = this.value;
    // 값 입력하고 나면 자동으로 지워주기
    this.value ="";
    // 값 입력하고 나면 자동으로 포커스 맞춰주기
    this.focus();
})

// a 태그 기본 이벤트 제거
document.getElementById("moveNaver").addEventListener("click", function(e){
    // 매개변수 e 또는 event == 이벤트 발생 객체(이벤트와 관련된 정보가 담겨있는 객체)

    // default : 기본값
    // prevent : 막다, 방지하다
    e.preventDefault(); // HTML 요소가 가지고 있는 기본 이벤트를 막음(제거)
})

// form 태그 기본 이벤트 제거
// 방법 1. submit 버튼을 사용 안 하는 방법
document.getElementById("testBtn1").addEventListener("click", function(){
    // #in1에 입력값 얻어오기
    const in1 = document.getElementById("in1").value;

    // #in1에 작성된 값이 "제출"일 경우 testForm1을 submit
    if( in1== "제출" ){
        // ** form 태그의 name 속성이 있을 경우 직접 선택 가능
        // document.form태그 name 속성값

        // ** form요소.submit() : form요소 제출 함수
        document.testForm1.submit();
    }
})

// 방법 2. onsubmit을 이용해서 form 태그 제출되는 것을 막는 방법
function checkIn2(){
    // #in2에 "제출"이 입력된 경우에만 submit(return true)
    const in2 = document.getElementById("in2").value;

    if(in2 == "제출"){
        return true;
    } else {
        return false;
    }
}
