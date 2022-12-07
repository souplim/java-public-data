var str = "JS 코드를 함수 내부가 아닌 JS 파일 또는 script 태그 밑에 바로 작성하면"
          +"HTML 랜더링 시 바로 수행됨"
console.log(str);

// 변수 선언 위치에 따른 구분
var num1 = 10; // 전역 변수
num2 = 20; // 전역 변수, 자바와는 다르게 변수타입 선언 않아도 됨

var num1 = 20; // 변수명 중복 ok -> var의 특징

console.log("num1 : "+num1);
console.log("num2 : "+num2);

function test(){
    console.log("num1 : "+num1);
    console.log("num2 : "+num2); // 전역변수
    
    var num3 = 3; // function의 지역변수. function 안에서만 사용
    num4 = 4; // 전역변수

    if(true){
        var num5 = 5; // if의 지역변수 -> function의 지역변수
        num6 = 6; // 전역변수
    }
    console.log("num5: "+num5); // ok. why? function의 지역변수가 됨
}

test(); // 바로 함수 호출
// console.log("num3 : "+num3); // error. 
console.log("num4 : "+num4); // function 종료 후에도 사용 가능
// console.log("num5 : "+num5); // error
console.log("num6 : "+num6); // function 내부 if문 종료 후에도 사용 가능


// 자료형 확인
function typeTest(){
    const typeBox = document.getElementById("typeBox");
    let temp; // 선언 후 값을 초기화 하지 않음 ->  undefined

    // typeBox 요소 얻어와서 그 안에 temp 넣기
    typeBox.innerHTML = "tmp : "+temp;

    // 1. string
    const name = "다나카";

    typeBox.innerText += "<br>name : "+name; // 태그 적용 X
    // typeof 변수명 : 해당 변수의 자료형을 검사하는 연산자
    typeBox.innerHTML += "<br>name : "+name+" / "+typeof name; // 태그 적용 O

    const gender = "M";
    typeBox.innerHTML += "<br>gender : "+ gender + " / " +typeof gender; 
    // 자바스크립트는 char 자료형이 존재하지 않음
    // "", '' 모두 string 리터럴 표기법

    // 2. number
    const age = 20;
    const height = 178.3;
    typeBox.innerHTML += "<br>age : "+age+" / "+typeof age;
    typeBox.innerHTML += "<br>height : "+height+" / "+typeof height;

    // 3. boolean
    const isTrue = true;
    typeBox.innerHTML += "<br>isTrue : "+isTrue+" / "+typeof isTrue;

    // 4. object

    // 1) 배열
    // java({} 사용)
    // int[] arr = {1,2,3,4,5};

    // javascript(배열기호 X, [] 사용)
    const arr =[10, 30, 70, 50];
    typeBox.innerHTML += "<br>arr : " + arr + " / " + typeof arr;

    // 작성법은 java와 다르나, 사용법은 동일(index 사용)
    for(let i=0; i<arr.length; i++){
        typeBox.innerHTML += "<br>arr["+i+"] : " + arr[i];
    }

    // 2) 자바스크립트 객체는 K:V(Map 형식)로 작성
    const user = {"id" : "user01", "pw" : "pass01"};
    typeBox.innerHTML += "<br>user : " + user+ " / " + typeof user;

}