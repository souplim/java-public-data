//----- 전체 ---------------------------------------------------------


// input 클릭시 placeholder 내용 삭제
$(".inputText").on("focus", function(){
    
    $(this).attr("placeholder","");

});

// input 내용 없이 포커스 나가면 placeholder 다시 띄우기 /* 왜 안 얻어질까? 클래스이름 -> 배열이라? 각각 구현해야 하나? */
// focus 있을 때 placeholder값 공백으로 설정했으므로 아무것도 안 가져와지는 것이 당연
// 각각의 항목에 text 다시 줘서 설정해야 함
/* $(".inputText").on("blur", function(){
    const textPh = $(this).attr("placeholder"); 

    if($(this).val()!=""){
        $(this).attr("placeholder","");
    } else {
        $(this).attr("placeholder", textPh);
    }
}); */


// inputText에 마우스 대면 CURSOR: POINTER (아무것도 써져있지 않을 때)
// focus 없을 때만
$(".inputText").hover(function(){

    // 어떤 요소가 현재 사용자에 의하여 포커스 되었는지 알고 이를 확인할 경우 document.activeElement를 사용
    // document.activeElement 속성은 현재 포커스 중인 DOM 요소를 찾아 반환
    let focusEle = document.activeElement;

    if($(this).val()=="" && this!=focusEle){
        $(this).css("cursor","pointer");
    } 

}, function(){
    $(this).css("cursor","");
});


//----- 아이디 ---------------------------------------------------------

// id 유효성 검사 
// 띄어쓰기 없이 영/숫자 6~10자
// 빈칸이면 "필수 정보입니다" -> 빨간색
// 정규표현식에 맞으면 "사용가능한 아이디 입니다" -> 파란색

$("#inputId").on("change", function(){
    const regExp = /^[a-zA-Z0-9]{6,10}$/;

    if(regExp.test( $(this).val() )){
        $("#idMessage").html("사용가능한 아이디 입니다.");
        $("#idMessage").addClass("confirm");
        $("#idMessage").removeClass("error");
        
        $("#imgId").attr("src","checkBlue.png");
    } else {
        $("#idMessage").html("회원 아이디(ID)는 띄어쓰기 없이 6~10자리의 영문자와 숫자 조합만 가능합니다.");
        $("#idMessage").addClass("error");
        $("#idMessage").removeClass("confirm");
    }
    
    if($(this).val().length == 0){
        $("#idMessage").html("필수 정보입니다");
        $("#idMessage").addClass("error");
        $("#idMessage").removeClass("confirm");
    }
});

// focus 나갔을 때 공백이면 "필수정보입니다"
$("#inputId").on("blur", function(){
    
    if($(this).val().length == 0){
        $("#idMessage").html("필수 정보입니다");
        $("#idMessage").addClass("error");
        $("#idMessage").removeClass("confirm");

        // input 내용 없이 포커스 나가면 placeholder 다시 띄우기 
        $(this).attr("placeholder", "ID를 만들어주세요 띄어쓰기 없이 영/숫자 6~10자");
    }

});

//----- 비밀번호 ---------------------------------------------------------

// 비밀번호 유효성 검사 
// 비밀번호 입력 8~15자의 영문 대소문자, 숫자 또는 특수문자 조합
// 빈칸이면 "띄어쓰기 없는 8~15자의 영문 대/소문자, 숫자 또는 특수문자 조합으로 입력하셔야 합니다." -> 빨간색
// 정규표현식에 맞으면 "적정 수준의 안전한 비밀번호입니다." -> 파란색
$("#inputPw").on("change", function(){
    const regExp = /^(?=.*?[A-Za-z)(?=.*[0-9])(?=.*?[#?!@$ %^&*-]).{8,15}$/;
    
    if(regExp.test( $(this).val() )){
        $("#pwMessage").html("적정 수준의 안전한 비밀번호입니다.");
        $("#pwMessage").addClass("confirm");
        $("#pwMessage").removeClass("error");
        $("#imgPw").attr("src","lockBlue.png");
    } else {
        $("#pwMessage").html("비밀번호 조합기준에 적합하지 않습니다.");
        $("#pwMessage").addClass("error");
        $("#pwMessage").removeClass("confirm");
    }
    
    if($(this).val().length == 0){
        $("#pwMessage").html("띄어쓰기 없는 8~15자의 영문 대/소문자, 숫자 또는 특수문자 조합으로 입력하셔야 합니다.");
        $("#pwMessage").addClass("error");
        $("#pwMessage").removeClass("confirm");
    }
});

// focus 나갔을 때 공백이면 "띄어쓰기 없는 8~15자의 영문 대/소문자, 숫자 또는 특수문자 조합으로 입력하셔야 합니다."
$("#inputPw").on("blur", function(){
    
    if($(this).val().length == 0){
        $("#pwMessage").html("띄어쓰기 없는 8~15자의 영문 대/소문자, 숫자 또는 특수문자 조합으로 입력하셔야 합니다.");
        $("#pwMessage").addClass("error");
        $("#pwMessage").removeClass("confirm");

        // input 내용 없이 포커스 나가면 placeholder 다시 띄우기 
        $(this).attr("placeholder", "띄어쓰기 없는 8~15자의 영문 대/소문자, 숫자 또는 특수문자 조합");
    }
});


// 비밀번호 암호화?


//----- 비밀번호 확인 ---------------------------------------------------------

// 비밀번호와 같지 않을 때 "비밀번호가 일치하지 않습니다"
// 같을 때 span 없어짐
$("#inputPwConfirm").on("change", function(){
    if( $("#inputPw").val() == $(this).val() ){
        $("#pwConfirmMessage").html("");
        $("#imgPwConfirm").attr("src","lockBlue.png");
    } else {
        $("#pwConfirmMessage").html("비밀번호가 일치하지 않습니다.");
        $("#pwConfirmMessage").addClass("error");
        $("#pwConfirmMessage").removeClass("confirm");
    }
    
    if($(this).val().length == 0){
        $("#pwConfirmMessage").html("필수 정보입니다.");
        $("#pwConfirmMessage").addClass("error");
        $("#pwConfirmMessage").removeClass("confirm");
    }
});

// focus 나갔을 때 공백이면 "필수정보입니다."
$("#inputPwConfirm").on("blur", function(){
    
    if($(this).val().length == 0){
        $("#pwConfirmMessage").html("필수 정보입니다.");
        $("#pwConfirmMessage").addClass("error");
        $("#pwConfirmMessage").removeClass("confirm");

        // input 내용 없이 포커스 나가면 placeholder 다시 띄우기 
        $(this).attr("placeholder", "위의 비밀번호를 다시 입력해주세요");
    }
});


//----- 이름 ---------------------------------------------------------
// 공백일 때 "필수 정보입니다."
// 정규표현식에 맞으면 체크 이미지 파란색
$("#inputName").on("change", function(){
    const regExp = /^[가-힣]{2,5}$/;
    
    if(regExp.test( $(this).val() )){
        $("#nameMessage").html("");
        $("#nameMessage").addClass("confirm");
        $("#nameMessage").removeClass("error");
        $("#imgName").attr("src","checkBlue.png");
    } else {
        $("#nameMessage").html("한글만 입력하세요.");
        $("#nameMessage").addClass("error");
        $("#nameMessage").removeClass("confirm");
    }
    
    if($(this).val().length == 0){
        $("#nameMessage").html("필수 정보입니다.");
        $("#nameMessage").addClass("error");
        $("#nameMessage").removeClass("confirm");
    }
});

// focus 나갔을 때 공백이면 "필수정보입니다."
$("#inputName").on("blur", function(){
    
    if($(this).val().length == 0){
        $("#nameMessage").html("필수 정보입니다.");
        $("#nameMessage").addClass("error");
        $("#nameMessage").removeClass("confirm");

        // input 내용 없이 포커스 나가면 placeholder 다시 띄우기 
        $(this).attr("placeholder", "이름");
    }
});



//----- 성별 ---------------------------------------------------------
function validate(){ // Q. 다른 항목들도 입력되지 않았을 때 안 넘어가게 하려면 어떻게 해야 할까? function 안에 넣으면 이벤트 사라짐
    
    const gender = $("input[name='gender']:checked");

    if(gender.length==0){
        alert("성별 입력이 잘못되었습니다.");

        return false;
    } 
}

// gender 체크시 아이콘 변경
$("input[name='gender']").on("change", function(){

    const gender = $("input[name='gender']:checked");

    if(gender.length!=0){
        $("#imgGender").attr("src","checkBlue.png");
    }
});


    
//----- 휴대폰번호 ---------------------------------------------------------

// inputTel1 혹은 inputTel2에 focus 되면 span(dash)에 '-' 생기게
$("#inputTel1").on("focus", function(){
    $("#dash").html("-");
    $("#dash").css("color","black");
});
$("#inputTel2").on("focus", function(){
    $("#dash").html("-");
    $("#dash").css("color","black");
});
// 둘다 공백일 때 다시 span에 dash 제거
$("#inputTel1").on("blur", function(){
    if($("#inputTel1").val()=="" && $("#inputTel2").val()=="")
        $("#dash").html("");
});
$("#inputTel2").on("blur", function(){
    if($("#inputTel1").val()=="" && $("#inputTel2").val()=="")
        $("#dash").html("");
});


// 각각 4자리까지만 입력되게 하기. 숫자, 자리 벗어난 숫자 제거
// 입력 없을 때, 자리수 모자랄 때 "전화번호를 정확히 입력해주세요."
// 입력 알맞을 때 파란색 체크 이미지
// /^[0][0-9]{1,2}-[0-9]{3,4}-[0-9]{4}$/;

const regExpNo = /^[a-zA-Z<>?!@#$%^&*()\-_=+]$/;
const regExpNo2 = /^[0-9]{5,}$/;

$("#inputTel1").on("input", function(){ 
    if( regExpNo.test( $(this).val()) ){
        const num = $(this).val();
        $(this).val("");
    }

    if( regExpNo2.test( $(this).val()) ){
        const num = $(this).val();
        $(this).val(num.substr(0,4));
    }
});

$("#inputTel2").on("input", function(){ 
    if( regExpNo.test( $(this).val()) ){
        const num = $(this).val();
        $(this).val("");
    }

    if( regExpNo2.test( $(this).val()) ){
        const num = $(this).val();
        $(this).val(num.substr(0,4));
    }
});

const regExp1 = /^[0-9]{3,4}$/;
const regExp2 = /^[0-9]{4}$/;

$("#inputTel1").on("change", function(){
    
    if(regExp1.test( $(this).val() ) && regExp2.test( $("#inputTel2").val())){
        $("#telMessage").html("");
        $("#telMessage").addClass("confirm");
        $("#telMessage").removeClass("error");
        $("#imgTel").attr("src","checkBlue.png");
    } else {
        $("#telMessage").html("전화번호를 정확히 입력해주세요.");
        $("#telMessage").addClass("error");
        $("#telMessage").removeClass("confirm");
    }
    
    if($(this).val().length == 0){
        $("#telMessage").html("전화번호를 정확히 입력해주세요.");
        $("#telMessage").addClass("error");
        $("#telMessage").removeClass("confirm");
    }
});

$("#inputTel2").on("change", function(){
    
    if(regExp2.test( $(this).val() )  && regExp1.test( $("#inputTel1").val())){
        $("#telMessage").html("");
        $("#telMessage").addClass("confirm");
        $("#telMessage").removeClass("error");
        $("#imgTel").attr("src","checkBlue.png");
    } else {
        $("#telMessage").html("전화번호를 정확히 입력해주세요.");
        $("#telMessage").addClass("error");
        $("#telMessage").removeClass("confirm");
    }
    
    if($(this).val().length == 0){
        $("#telMessage").html("전화번호를 정확히 입력해주세요.");
        $("#telMessage").addClass("error");
        $("#telMessage").removeClass("confirm");
    }
});

// focus 나갔을 때 공백이면 "전화번호를 정확히 입력해주세요."
$("#inputTel1").on("blur", function(){
    
    if($(this).val().length == 0){
        $("#telMessage").html("전화번호를 정확히 입력해주세요.");
        $("#telMessage").addClass("error");
        $("#telMessage").removeClass("confirm");
    }

    // input 내용 없이 포커스 나가면 placeholder 다시 띄우기 
    if($(this).val().length == 0 && $("#inputTel2").val().length == 0){
        $(this).attr("placeholder", "휴대폰번호입력");
    }
});
$("#inputTel2").on("blur", function(){
    
    if($(this).val().length == 0){
        $("#telMessage").html("전화번호를 정확히 입력해주세요.");
        $("#telMessage").addClass("error");
        $("#telMessage").removeClass("confirm");
    }
});


//----- 이메일 ---------------------------------------------------------

// inputEmail1 혹은 inputEmail2 focus 되면 span(at)에 @ 생기게
$("#inputEmail1").on("focus", function(){
    $("#at").html("@");
    $("#at").css("color","black");
});
$("#inputEmail2").on("focus", function(){
    $("#at").html("@");
    $("#at").css("color","black");
});

// 둘다 공백일 때 다시 span에 dash 제거
$("#inputEmail1").on("blur", function(){
    if($("#inputEmail1").val()=="" && $("#inputEmail2").val()=="")
        $("#at").html("");
});
$("#inputEmail2").on("blur", function(){
    if($("#inputEmail1").val()=="" && $("#inputEmail2").val()=="")
        $("#at").html("");
});


// select option 고르면 inputEmail2에 값 가져오기
$("#emailAddress").on("change", function(){
    let email =  $("#emailAddress option:selected").val();

    if(email != "직접입력"){
        $("#inputEmail2").val(email);
    } else {
        $("#inputEmail2").val("");
    }
});


// 올바른 양식일 경우 span 제거
// 아닐 경우 "이메일 주소를 다시 확인해주세요" // 아직 구현 안 함

const regExp11 = /^([a-z0-9_\.-]+)$/;
const regExp22 = /^([\da-z\.-]+)\.([a-z\.]{2,6})$/;

$("#inputEmail1").on("change", function(){

    if(regExp11.test( $(this).val() ) && regExp22.test( $("#inputEmail2").val())){
        $("#emailMessage").html("");
        $("#emailMessage").addClass("confirm");
        $("#emailMessage").removeClass("error");
    } else {
        $("#emailMessage").html("이메일 주소를 다시 확인해주세요.");
        $("#emailMessage").addClass("error");
        $("#emailMessage").removeClass("confirm");
    }
    
    if($(this).val().length == 0){
        $("#emailMessage").html("이메일 주소를 다시 확인해주세요.");
        $("#emailMessage").addClass("error");
        $("#emailMessage").removeClass("confirm");
    }

});

$("#inputEmail2").on("change", function(){

    if(regExp11.test( $(this).val() ) && regExp22.test( $("#inputEmail2").val())){
        $("#emailMessage").html("");
        $("#emailMessage").addClass("confirm");
        $("#emailMessage").removeClass("error");
    } else {
        $("#emailMessage").html("이메일 주소를 다시 확인해주세요.");
        $("#emailMessage").addClass("error");
        $("#emailMessage").removeClass("confirm");
    }
    
    if($(this).val().length == 0){
        $("#emailMessage").html("이메일 주소를 다시 확인해주세요.");
        $("#emailMessage").addClass("error");
        $("#emailMessage").removeClass("confirm");
    }

});
