// 정규 표현식 객체 생성 + 확인하기
document.getElementById("check1").addEventListener("click", function(){
    // 정규 표현식 객체 생성
    const regExp1 = new RegExp("script");
                    // "script"와 일치하는 문자열이 있는지 검사하는 정규 표현식

    const regExp2 = /java/;
                    // "java"와 일치하는 문자열이 있는지 검사하는 정규 표현식


    // 확인하기
    const str1 = "저희는 지금 javascript를 공부하고 있습니다.";

    const str2 = "servlet/jsp(java server page)도 조만간 합니다.";
    
    const str3 = "java, java, java";
    
    console.log("regExp1.test(str1) : "+regExp1.test(str1)); // true
    console.log(regExp1.exec(str1)); // index : 11

    console.log("regExp2.test(str2) : "+regExp2.test(str2)); // true
    console.log(regExp2.exec(str2)); // index : 12

    // 일치하는 게 없는 경우
    console.log("regExp1.test(str2) : "+regExp1.test(str2)); // false
    console.log(regExp1.exec(str2)); // null

    // 일치하는 게 여러개 있을 경우
    console.log("regExp2.test(str3) : "+regExp2.test(str3)); // true
    console.log(regExp2.exec(str3)); // index : 0 -> 여러 개 중 처음 매칭되는 문자열 반환
});

document.getElementById("btn1").addEventListener("click", function(){

    const div1 = document.getElementById("div1");

    div1.innerHTML = ""; // 내용 모두 삭제

    // a (일반 문자열) : 문자열 내에 a라는 문자열이 존재하는지 검색
    const regExp1 = /a/;
    div1.innerHTML += "/a/ , apple : "+ regExp1.test("apple")+",<hr>"; // true
    div1.innerHTML += "/a/ , price : "+ regExp1.test("price")+",<hr>"; // false

    // [abcd] : 문자열 내에 a,b,c,d 중 하나라도 일치하는 문자가 있는지 검색
    const regExp2 = /[abcd]/;
    div1.innerHTML += "/abcd/ , apple : "+ regExp1.test("apple")+",<hr>"; // true
    div1.innerHTML += "/abcd/ , apple : "+ regExp1.test("apple")+",<hr>"; // true
    div1.innerHTML += "/abcd/ , qwert : "+ regExp1.test("qwert")+",<hr>"; // false

    // ^(캐럿) : 문자열의 시작을 의미
    const regExp3 = /^group/; // 문자열의 시작이 "group"인지 확인
    div1.innerHTML += "/^group/ , group100 : " + regExp3.test("group100") +"<hr>"; // true
    div1.innerHTML += "/^group/ , 100group : " + regExp3.test("100group") +"<hr>"; // false

    // $(달러) : 문자열의 끝을 의미
    const regExp4 = /java$/; // 문자열의 끝이 "java"인지 확인
    div1.innerHTML += "/java$/, hellojava : " + regExp4.test("hellojava")+"<hr>"; // true
    div1.innerHTML += "/java$/, javascript : " + regExp4.test("javascript")+"<hr>"; // false
});

// 이름 유효성 검사
document.getElementById("inputName").addEventListener("keyup", function(){
    
    // 결과 출력용 span
    const span = document.getElementById("inputNameResult")
    
    // 한글 2~5글자 정규 표현식(정규식)
    // [가-힣] : 한글(단일 자음, 모음 제외)
    const regExp = /^[가-힣]{2,5}$/;
    
    // 유효성 검사
    const inputName = document.getElementById("inputName").value;
     
    // 만약에 정규식이 유효하다면 span 내부에 "유효한 이름 형식입니다." span 폰트 색상 : green, 폰트 굵게
    // 만약 정규식이 유효하지 않다면 span 내부에 "이름 형식이 유효하지 않습니다." span 폰트 색상 : red, 폰트 굵게

    if(regExp.test(inputName)){ // if(regExp.test(this.value)){ -> keyup 이벤트가 발생한 요소 this의 value
        span.innerHTML = "유효한 이름 형식입니다.";
        span.style.color = "green";
        span.style.fontWeight = "bold";
    } else {
        span.innerHTML = "이름 형식이 유효하지 않습니다.";
        span.style.color = "red";
        span.style.fontWeight = "bold";
    }
  
    // 빈칸인지 검사
    // 빈칸이라면 span에 작성된 내용 초기화(삭제) -> 이름을 쓰고 지웠을 때 처음화면처럼 보여야 함
    
    if(inputName == ""){ // if(this.value == ""){       
        span.innerHTML = "";
    }
    
    // if(inputName.length == 0){
    //     span.innerHTML = "";
    // }

    // Q. 한데 왜 null로 하면 안되나?
    // undefined : 선언(define)되었으나 초기값 지정 안 된 상태
    // "" : 변수의 메모리에 0byte의 문자열이 할당된 상태
    // script에선 사용자가 null을 넣어주지 않으면 null이 나올일은 없음

    // console.log(inputName); // 콘솔로 찍은 inputName은 null값이 아닌 공백
    // var a;
    // console.log(a); // undefined -> 초기값 지정 X
    // var b = null;
    // console.log(b); // null -> 의도적으로 집어넣었을 때 null
    // var c = "";
    // console.log(c); // "" -> 공백

})

// 주민등록번호 유효성 검사
document.getElementById("inputPno").addEventListener("keyup", function(){

    // 결과 출력 span 태그
    const span = document.getElementById("inputPnoResult");

    // 주민등록번호 정규식
    // 생년월일(6)-고유번호(7)
    // 연도(2) 월(2) 일(2)
    // const regExp = /^[0-9]{6}\-[1-4][0-9]{6}$/;
    // const regExp = /^\d{6}\-[1-4]\d{6}$/;

    // 업그레이드
    const regExp = /^\d{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])\-[1-4]\d{6}$/;
    // () : 포획 괄호, 괄호 내부에 대응되는 부분을 찾아서 기억함
    // | : 또는 

    // 월 : 01 ~ 09 -> 0[1-9] 
    //      10 ~ 12 -> 1[0-2]

    // (0[1-9]|1[0-2]) : 괄호 내 | 기호를 기준으로 구본되며
    // 0이 먼저 입력된 경우 다음 자리는 1~9
    // 1이 먼저 입력된 경우 다음 자리는 0~2


    // 일 : 01 ~ 09 -> 0[1-9]
    //      10 ~ 19 -> 1[0-9]
    //      20 ~ 29 -> 2[0-9]
    //      30 ~ 31 -> 3[0-1]

    // (0[1-9]|1[0-9|2[0-9]|3[0-1]])

    // 요소.classList : 요소가 가지고 있는 클래스를 배열로 반환
    // 요소.classList.remove("클래스명") : 요소의 특정 클래스 제거
    // 요소.classList.add("클래스명") : 요소에 특정 클래스 추가

    // 요소.classList.toggle("클래스명") : 클래스가 있으면 제거 없으면 추가

    // 유효성 검사
    if(regExp.test(this.value)){
        span.innerText = "유효한 주민등록번호 형식입니다.";
        // span.style.color = "green"; 
        
        // CSS 스타일로 색깔 주기
        // span.setAttribute("class","");

        // Q. 클래스 제거는 어떻게?
        span.classList.remove("error"); // error 클래스 제거
        span.classList.add("confirm"); // confirm 클래스 추가
    } else {
        span.innerText = "유효하지 않은 주민등록번호 형식입니다.";
        // span.style.color = "red"; // CSS 스타일로 색깔 줌

        // CSS 스타일로 색깔 주기
        span.classList.remove("confirm"); // confirm 클래스 제거
        span.classList.add("error"); // error 클래스 추가
    }

    if(this.value == ""){ 
        span.innerText = "";
    }
});
