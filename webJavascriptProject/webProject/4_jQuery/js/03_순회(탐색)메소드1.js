$(document).ready(function(){

    // parent() : 선택된 요소의 바로 상위 요소(부모)를 선택
    // span 태그의 부모 요소의 테두리, 글자색을 변경
    $("span").parent().css("border","2px solid red").css("color","red");

    // li 태그의 모든 상위 요소의 글자색을 파란색으로 변경
    $("li").parents().css("color","blue");

    // li 태그의 상위 요소 중 div만 선택하여 테두리 변경
    $("li").parents("div").css("border","2px dashed magenta");

    // parents("매개변수") : 선택된 요소의 모든 상위 요소를 선택
    // 매개변수가 작성된 경우 상위 요소 중 매개변수에 맞는 요소만을 선택

    // span 태그 부터 상위 요소 중
    // div 태그를 만나기 이전 까지 요소를 선택하여 배경색 변경
    $("span").parentsUntil("div").css("background","springgreen");
});
