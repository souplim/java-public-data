// window.setTimeout(함수, 지연시간(ms))
document.getElementById("btn1").addEventListener("click", function(){
    setTimeout(function(){
        alert("3초 후 출력 확인!")
    } , 3000);
})

let interval; // setInterval을 저장하기 위한 전역변수

function clockFn(){
    const clock = document.getElementById("clock");
    clock.innerText = currentTime();

    // 지연 시간마다 반복(첫 반복도 지연 시간 후에 시작)
    // -> 페이지 로딩 후 1초 후부터 반복(지연 -> 함수 실행 -> 지연 -> 함수 실행)
    interval = setInterval(function(){
        clock.innerText = currentTime();
    }, 1000);
}

// 현재 시간 문자열로 반환하는 함수
function currentTime(){
    const now = new Date();

    let hour = now.getHours();
    let minute = now.getMinutes();
    let second = now.getSeconds();

    if(hour<10) hour = "0"+hour;
    if(minute<10) minute = "0"+minute;
    if(second<10) second = "0"+second;

    return hour+" : "+minute+" : "+second;
}


clockFn(); // 로딩이 되자마자 함수 호출

// clearInterval
document.getElementById("stop").addEventListener("click", function(){
    clearInterval(interval);
})
