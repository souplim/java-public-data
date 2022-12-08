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
    //    해당 이벤트와 관련된 모든 정보가 담긴 이벤트 객체가 반환된다.
    // console.log(event);

    // event.target : 이벤트가 발생한 요소
    // event.target.style.backgroundColor = "gold";

    // 방법 3) this 활용하기 -> 이벤트가 발생한 요소 ( <button id="test2-3">고전 이벤트 모델 단점</button> )
    // event.target과 동일
    console.log(this);
    this.style.backgroundColor = "gold";
}

// 같은 이벤트 리스너에 이벤트 핸들러 작성한 것 까먹고 아래와 같은 코드 작성했다면...
// 위에서 적용한 속성 무시됨
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
