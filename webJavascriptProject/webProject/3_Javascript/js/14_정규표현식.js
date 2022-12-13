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
    div1.innerHTML += "/java$/, hellojava : " + regExp4.test("hellojava")+"<hr>"; //
    div1.innerHTML += "/java$/, javascript : " + regExp4.test("javascript")+"<hr>"; //
});