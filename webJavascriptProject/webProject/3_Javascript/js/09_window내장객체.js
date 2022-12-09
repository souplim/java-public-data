// window.setTimeout(함수, 지연시간(ms))
document.getElementById("btn1").addEventListener("click", function(){
    setTimeout( function(){
        alert("3초 후 출력 확인!")
    } , 3000);
})