// 배열 확인 1
document.getElementById("btn1").addEventListener("click", function(){
    // 배열 선언 방법
    const arr1 = new Array(3); // 세 칸짜리 배열 생성
    const arr2 = new Array(); // 0 칸짜리(비어 있는) 배열 생성

    console.log(arr1);
    console.log(arr2);

    // 다른 자료형 대입
    arr1[0] = "김밥"
    arr1[1] = 123;
    arr1[2] = true;
    console.log(arr1);
    

    // 0칸 짜리 배열에 대입 -> 자동으로 길이 증가
    arr2[0] = "김밥"
    arr2[1] = 123;
    arr2[2] = true;
    console.log(arr2);

    // 배열 선언 방법
    const arr3 = []; // 비어 있는 배열 (0칸)
    const arr4 = ["사과","딸기","바나나"]; // 선언 및 초기화

    console.log(arr4);
    // for문으로 배열 요소 반복 접근하기
    // 1. 일반 for문
    // for(let i=0;i<arr4.length;i++){
    //     console.log(arr4[i]);
    // }
    // 2. 향상된 for문(for ... of) : 배열용 향상된 for문
    for(let a of arr4){ // arr4 배열에서 요소를 하나씩 얻어와 a에 대입
        console.log(a);
    }
})


// 배열 확인 2
document.getElementById("btn2").addEventListener("click", function(){
    
    // 비어있는 배열 생성
    const arr = [];    

    // push() : 배열 마지막 요소로 추가
    arr.push("삼겹살");
    arr.push("곱창");
    arr.push("초밥");
    arr.push("치킨");

    console.log(arr);

    // pop() : 배열 마지막 요소 꺼내오기
    console.log("꺼내온 요소 : "+arr.pop());

    console.log(arr);

    // 배열.indexOf("값") : 일치하는 값을 가진 요소의 index를 반환
    console.log(arr.indexOf("곱창")); // 1
    console.log(arr.indexOf("갈비")); // 배열에 없는 값 -1 반환

    // 배열.sort([정렬기준 함수]) : 배열 내 요소를 오름차순 정렬(문자열)
    const arr2 = [5,3,2,10,1];
    
    console.log(arr.sort()); // 문자열 순서대로 출력
    console.log(arr2.sort()); // 1, 10, 2, 3, 5 -> 왜? 문자열로 변환되서 정렬됨 (문자열 정렬 기준이 기본값)

    // 숫자 오름차순 정렬
    console.log(arr2.sort(function(a,b){ return a-b; } ));

    // 문자열로 출력
    console.log(arr.toString()); // 곱창,삼겹살,초밥
    // 구분자
    console.log(arr.join("/")); // 곱창/삼겹살/초밥
})