// id로 접근하기
function accessId(){
    const div1 = document.getElementById("div1");
    // 접근한 요소의 배경색 얻어오기
    const bgColor = div1.style.backgroundColor;

    // 버튼 하나로 색깔 다르게
    // *** 자바스크립트는 문자열 비교시에도 비교 연산자를 사용
    if(bgColor == "red"){
        // 배경색 yellow로 변경
        div1.style.backgroundColor = "yellow";
    } else {
        // 배경색 red로 변경
        div1.style.backgroundColor = "red";
    }
}

// class로 접근하기
function accessClass(){
    // 요소를 여러개 접근하는 경우 [배열] 형태로 반환됨
    const arr = document.getElementsByClassName("div2");

    // 인덱스를 이용해서 요소 하나씩 접근
    arr[0].style.backgroundColor = "pink";
    arr[0].innerHTML = "첫 번째 요소";
    arr[1].style.backgroundColor = "tomato";
    arr[1].innerHTML = "두 번째 요소";
    arr[2].style.backgroundColor = "skyblue";
    arr[2].innerHTML = "세 번째 요소";
}

// tag명으로 접근하기
function accessTagName(){
    // 문서 내 모든 li 태그 접근(배열 반환)
    const arr = document.getElementsByTagName("li");

    // 반복문(java랑 비슷)
    for(let i = 0; i<arr.length; i++){

        const num = arr[i].innerText; // 요소에 작성된 내용 얻어오기
        arr[i].style.backgroundColor = "rgb(130, 200, "+(50*num)+")"; // 그라데이션 효과
    }
}

// input 태그의 값(value) 얻어오기/변경하기
function inputTest(){
    // input 요소 접근하기
    const input = document.getElementById("input-test");

    // ** innerText, innerHTML은 요소의 내용(시작태그, 종료태그 사이의 내용)을
    //      얻어오거나, 변경할 때만 사용 가능
    // ** input은 [value]를 이용해서 값을 얻어오거나, 변경할 수 있음
    console.log(input.value); 

    // input에 작성된 값 변경하기
    input.value = ""; // 빈 문자열 == value로 지우기

    // input에 초점 맞추기(클릭하지 않아도 다시 커서 text박스 안에서 깜박이게) -> focus() 
    input.focus();
}

// name으로 접근하기
function accessName(){
    const hobbyList = document.getElementsByName("hobby");

    let str = "";
    let count = 0;

    for(let i=0; i<hobbyList.length; i++){
        // * radio / checkbox 전용 속성 *
        // .checked : 해당 요소가 체크되어 있으면 true, 아니면 false 반환
        if(hobbyList[i].checked){ //  현재 요소가 체크되어 있으면
            // str 변수에 value 누적
            str += hobbyList[i].value + " ";
            count++;
        }
    }

    // #name-div에 출력
    document.getElementById("name-div").innerHTML = str;

    document.getElementById("name-div").innerHTML += "<br><br>선택된 개수: "+count;
}