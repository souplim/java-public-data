// Node 확인하기
document.getElementById("btn1").addEventListener("click", function(){
    // #test의 자식 노드를 모두 얻어오기
    // - 요소.childNodes : 요소의 자식 노드를 모두 반환
    const nodeList = document.getElementById("test").childNodes;
    
    console.log(nodeList); // text, 태그 등

    // 노드 탐색
    // 1) 부모 노드 탐색 : parentNode
    const li1 = document.getElementById("li1");
    console.log(li1.parentNode); // ul#test

    // 부모 노드의 배경색 변경
    li1.parentNode.style.backgroundColor = "orange";

    // 부모 노드의 마지막에 새로운 노드 추가 (append : 마지막에 덧붙이다)
    li1.parentNode.append("ABCD");

    // 2)첫 번째 자식 노드 탐색 : firstChild
    console.log(document.getElementById("test").firstChild); // '\n          '

    // 3) 마지막 자식 노드 탐색 : lastChild
    console.log(document.getElementById("test").lastChild); // 추가된 ABCD

    // 4) 중간에 존재하는 자식 노드 탐색 : 부모요소.childNodes[인덱스]
    console.log(nodeList[11]);
    nodeList[11].append("1234");

    // 5) 이전 형제 노드 탐색 : previousSibling
    //    다음 형제 노드 탐색 : nextSibling
    console.log(nodeList[8].previousSibling); // <!-- 중간 주석 -->
    console.log(nodeList[8].nextSibling); // li style

    // 노드 탐색을 위한 구문은 연달아서 사용 가능
    console.log(nodeList[8].previousSibling.previousSibling.previousSibling); // li.cls
})

// Eliment 확인하기
document.getElementById("btn2").addEventListener("click", function(){

    // #test의 모든 자식 요소를 반환
    const list = document.getElementById("test").children;
    console.log(list);

    // #test의 첫 번째 자식 요소 (배경색 바꾸기)
    const first = document.getElementById("test").firstElementChild;
    first.style.backgroundColor = "gold";

    // #test의 마지막 자식 요소 (배경색 바꾸기)
    const last = document.getElementById("test").lastElementChild;
    last.style.backgroundColor = "green";

    // #test의 자식(list) 중 2번 인덱스의 이전/다음 형제요소 클릭했을 때 아래 alert구문 실행
    // 1
    // const previous = document.getElementById("test").children[2].previousElementSibling;
    // // console.log(previous);
    // previous.onclick = function(){
    //     alert('2번 인덱스의 이전 형제 요소 클릭됨');
    // }

    // 2
    // list[2].previousElementSibling.addEventListener("click", function(){
    //     alert('2번 인덱스의 이전 형제 요소 클릭됨');
    // })

    list[2].nextElementSibling.addEventListener("click", function(){
        alert('2번 인덱스의 다음 형제 요소 클릭됨');
    })

    console.log(prevEL(list[2])); // li.cl
    console.log(prevEL(prevEL(list[2]))); // li1
    
    console.log(nextEl(list[2])); // a href="#"
})

// 이전 형제 요소 선택 함수
function prevEL(el){
    return el.previousElementSibling;
}

// 다음 형제 요소 선택 함수
function nextEl(el){
    return el.nextElementSibling;
}

let count1 = 0;

// innerHTML 버튼 클릭 시
document.getElementById("btn3-1").addEventListener("click", function(){
    const div = document.getElementById("div3-1");
    
    if(count1<10){
        div.innerHTML += "<div>"+(count1+1)+"</div>";
        count1++;
    }
})

let count2 = 1;
// createElement 버튼 클릭시
document.getElementById("btn3-2").addEventListener("click", function(){
    const div = document.getElementById("div3-2");

    // createElement를 이용하여 div 요소 생성
    // document.createElement("태그명") : 해당 태그 요소를 생성하여 반환
    const child = document.createElement("div"); // div 생성 o, 화면 배치 X

    if(count2 <= 10){
        // 만들어진 div(child)에 내용 추가
        child.innerText = count2;
        count2++;

        // #div3-2의 마지막 자식 요소로 추가하기(append)
        div.append(child);
    }
})

document.getElementById("temp").addEventListener("click", function(){
    alert("temp");
});