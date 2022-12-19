let count = 0; // 숫자가 0~9까지 증가하는 것을 세기 위한 변수

let interval; // setInterval을 저장할 변수

$(function(){
    
//                         반복수행할 기능, 지연시간(ms) 
    interval = setInterval(function(){
        const area = $(".area");

        if(count<10){

            // 0~9까지 출력할 span 태그 작성
            const span = "<span class='text1'>"+ count++ +"</span>"
            $(".area").append(span);
        } else { // count가 9초과한 경우

            // 클래스가 area인 요소 내부에 있는 내용을 모두 삭제
            // $(".area").empty();
            $(".area").html("");

            // count를 0으로 초기화하여 다시 0~9까지 카운트 가능하도록 함
            count = 0;
        }
        
    }, 300);

    // HTML 문서의 로딩이 완료된 후
    // 아이디가 stop인 요소가 클릭되었을 때의 동작을 추가
    $("#stop").on("click", function(){
        clearInterval(interval);

        console.log($(this).text()); /* button에 있는 text를 얻어와 console에 출력 */
        // this : 이벤트가 발생한 요소
        // $(this) : 이벤트가 발생한 요소를 선택
        //           -> jQuery 메소드 사용 가능 상태                     
    });

    // 클래스가 text1인 요소를 클릭했을 때 콘솔에 요소의 내용(text)을 출력

    // $(".text1").on("click", function(){
    $(document).on("click", ".text1", function(){
        console.log($(this).text());
    });
    /* 
        1. HTML 문서는 위에서 아래로 해석
        2. on(), addEventListener() 는 요소에 이벤트가 발생했을 때 동작(기능)을 추가하는 메소드
        
        (중요) 기존에 on(), addEventListener()를 이용하여 이벤트 동작을 추가할 때는 
               이미 화면에 로딩이 완료된 상태인 요소에 추가했었음
    
        지금 같은 경우는 기존 화면에 없던 요소(span)에 이벤트 동작을 추가하려 했지만
        되지 않았음

        정적 요소 : HTML 문서 로딩 전부터 이미 작성되어 있는 요소
                    -> 기존 방법 on("click", function(){}) 사용 가능
        동적 요소 : 자바스크립트 또는 제이쿼리에 의해서 HTML 문서 로딩 이후에 추가되는 요소
                    -> 기존 방법 불가
                    -> $(document).on("이벤트", "선택자", function(){});
    */
});

// 아이디가 focus-blur인 요소에 초점이 맞춰진 경우 
// 배경색을 pink로 바꾸는 동작 추가
$("#focus-blur").on("focus", function(){
    $(this).css("backgroundColor","pink");
});

// 아이디가 focus-blur인 요소에 초점이 해제된 경우
// 배경색을 원래대로 바꾸는 동작을 추가
$("#focus-blur").on("blur", function(){
    $(this).css("backgroundColor","");
});

// 아이디가 change1인 요소에 체크/해제될 때마다 콘솔에 "checkbox값이 변경되었습니다 출력
$("#change1").on("change", function(){
    console.log("checkbox 값이 변경되었습니다.");
});

// 아이디가 change2인 요소의 입력값이 변한 상태로 포커스가 해제될 때마다
// 콘솔에 "입력값이 변경되었습니다." 출력
$("#change2").on("change", function(){
    console.log("입력값이 변경되었습니다.");
    // 엔터 입력해도 change 이벤트가 발생함
});

// 아이디가 select인 요소의 입력값에 블러기 잡힌 경우
// 콘솔에 "입력값이 블럭이 잡힘" 출력
$("#select").on("select", function(){
    console.log("입력값이 블럭이 잡힘");
});

// #counter의 글자색 변경하기
// 글자수가 0~130이면 글자색이 검은색
// 131~149까지는 주황색
// 150부터는 빨간색으로 출력
$("#input-content").on("input", function(){
    // let length = $("#input-content").val().length;
    let length = $(this).val().length;

    if(length <= 130){
        $("#counter").css("color","black");
    } else if(length <= 149){ // 130이내는 이미 if문에서 거르기 때문에 130< 라는 조건은 생략 가능
        $("#counter").css("color","orange");
    } else {
        $("#counter").css("color","red");

        // 150글자 이상 작성 불가능하게 만들기
        // 1) textarea에 작성된 값(문자열)을 변수에 저장
        const str = $(this).val();

        // 2) substr을 이용해서 글자를 150글자까지만 잘라내기
        // 문자열.substr(시작인덱스, 종료인덱스)
        // -> 문자열을 시작 인덱스 이상부터, 종료 인덱스 미만까지를 잘라내 반환

        // 3) 150글자만 잘라내어 textarea의 값으로 세팅하기
        $(this).val(str.substr(0,150));
    }

    // console($(this).val().length);
    $("#counter").text(length);
    // $(this) : 입력(input) 이벤트가 발생한 현재 요소(textarea)
    // val() : teatarea에 입력된 값(문자열)
    // length : 문자열의 길이
    // text("문자열") : 요소의 내용으로 문자열 출력
});



/* $("#input-content").on("input", function(){

    //console.log( $(this).val().length );

    // #counter의 글자색 변경하기
    // 글자수가 0 ~ 130 이면 글자색이 검은색
    // 131 ~ 149 까지는 주황색 
    // 150부터는 빨간색으로 출력
    if( $(this).val().length <= 130 ){
        $("#counter").css("color", "black");

    } else if( $(this).val().length <= 149 ){
        $("#counter").css("color", "orange");

    } else { // 150 글자 이상인 경우
        $("#counter").css("color", "red");
        const str = $(this).val();
        $(this).val(str.substr(0,150));
    }

    $("#counter").text( $(this).val().length );
    // $(this) : 입력(input) 이벤트가 발생한 현재 요소(textarea)
    // val() : teatarea에 입력된 값(문자열)
}); */