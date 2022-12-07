// alert 확인
function fnAlert(){
    window.alert("alert 버튼 클릭됨");

    // window는 브라우저 자체를 나타내는 객체
    // -> JS 코드는 브라우저(window) 내부에서 실행되는 코드이다보니 window 생략 가능
}

function documentWrite(){
    // document.write("안녕하세요");
    document.write("<b>안녕하세요</b><br/><br/><h2>반가워요</h2>");
    // 출력할 문구에 html 태그가 있을 경우 해석해서 시각적인 요소로 보여줌

    let a = "<table border='1'>";
    a += "<tr>";
    a += "<td>1</td>";
    a += "<td>2</td>";
    a += "</tr></table>";

    document.write(a);
}

// innerText 읽어오기
function getInnerText(){
    // html 문서 내에서 아이디가 "test1"인 요소를 얻어와 test1 변수에 대입
    const test1 = document.getElementById("test1");

    // test1 변수에 대입된 요소에서 내용을 얻어와 console에 출력
    console.log(test1.innerHTML);
}

// innerText로 변경하기
function setInnerText(){
    // id가 "test1"인 요소를 얻어와 test1 변수에 대입
    const test1 = document.getElementById("test1");

    // test1 변수에 대입된 요소에 새로운 내용을 작성
    test1.innerText = "innerText로 <br> 변경된 내용입니다.";
}

// innerHTML로 읽어오기
function getInnerHTML1(){
    // id가 test2인 요소를 얻어와 test2 변수에 대입
    const test2 = document.getElementById("test2");

    // test2 요소 내부에 내용(태그+속성+내용)을 읽어 콘솔에 출력 
    console.log(test2.innerText);
}

// innerHTML로 변경하기
function setInnerHTML1(){
    const test2 = document.getElementById("test2");

    test2.innerHTML = "<b>innerHTML로 변경된 내용</b> <br> 반갑습니다.";
}

function add(){
    // 1) 아이디가 area1인 요소 얻어와 area1 변수에 대입
    const area1 = document.getElementById("area1");

    // 2) area1 내부 내용(태그, 속성, 내용 포함) 모두 읽어오기
    // const content = area1.innerHTML;

    // 3) area1에 이전 내용 + 새로운 요소(div.box2)추가
    // area1.innerHTML = content + "<div class='box2'></div>";

    // 2번 + 3번
    area1.innerHTML += "<div class='box2'></div>";
}

// confirm 확인하기
function fnConfirm(){
    // 확인
    if(confirm("버튼 배경색을 분홍색으로 바꾸시겠습니까?")){
        document.getElementById("confirmBtn").style.backgroundColor = "pink";
    } else {
        document.getElementById("confirmBtn").style.backgroundColor = "yellow";
    }
}

// prompt 확인하기
function fnPrompt1(){
    const name = prompt("당신의 이름은 무엇입니까?");
    const age = prompt("당신의 나이는 몇 살입니까?");

    console.log(name);
    console.log(age);

    const divEl = document.getElementById("area2");
    divEl.innerHTML = "<b>앗, 당신이 바로 "+age+"살 "+name+"님이군요!</b>";
}

function fnPrompt2(){
    const input = prompt("이름을 입력하세요");
    const promptResult = document.getElementById("area3");
    if(input!=null){
        promptResult.innerHTML = input + "님 환영합니다";
    } else {
        promptResult.innerHTML = "이름을 입력해주세요.";
    }
}

// 선택한 input요소.value 확인하기
function fnInput(){
    const input1 = document.getElementById("userId"); // 아이디 input 요소
    const input2 = document.getElementById("userPwd"); // 비밀번호 input 요소

    //console.dir(input1); /* 요소에 내장된 속성 알 수 있음 */

    const id = input1.value;
    const pwd = input2.value;

    console.log(id);
    console.log(pwd);

    // id, pw 적은 칸 클릭하면 비우기
    document.getElementById("area4").value = id +", "+pwd;
    input1.value = "";
    input2.value = "";
}
