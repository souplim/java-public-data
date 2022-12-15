// JS와 jQuery 차이점

// 배경색 : black
// 글자색 : yellow
// 글자 크기 : 20px

// Javascript
// document.getElementById("jsBtn").addEventListener("click", function(){
document.querySelector("#jsBtn").addEventListener("click", function(){
    this.style.backgroundColor = "black";
    this.style.color = "yellow";
    this.style.fontSize = "20px";
});

// jQuery -> 코드 간소화됨
// on() == addEventListener
// -> 특정 이벤트 발생 시 동작(이벤트 핸들러) 지정
$("#jQueryBtn").on("click", function(){
    $(this).css("backgroundColor","black").css("color","yellow").css("fontSize","20px");
});

// window.onload 확인
window.onload = function(){ // 문서 로딩이 완료된 후 수행. 2보다 나중에 실행됨
    console.log("1"); 
}

// window.onload 중복 작성 -> 앞서 작성한 window.onload를 덮어 씌움 -> 2, 3
window.onload = function(){
    console.log("3");
}

console.log("2");

// ready() 함수 확인
// js 링크 아래에 있는 readyTest가 누군지 몰라 동작 안 했던 것이 가장 마지막에 해석되기 때문에 실행됨
$(document).ready(function(){
    $("#readyTest").on("click", function(){ 
        alert("클릭이 되었습니다");
    });
});

// ready() 중복 작성 -> 작성한 모든 내용이 적용됨
$(document).ready(function(){
    document.getElementById("readyTest").style.color = "gold";
});

// ready() 함수의 다른 형태
$(function(){
    console.log("ready() 함수의 다른 형태");
});

// ready() + 화살표 함수
$(()=> { console.log("이렇게도 됩니다"); });
