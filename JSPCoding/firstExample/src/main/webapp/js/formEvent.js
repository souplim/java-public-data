// html load 되고 난 후 읽으라는 ready 함수
$(function(){
		
	$("#userId").on("input", function(){
		// 아이디는 첫글자 영문자, 두번째부터 영문자와 숫자로 6글자 이상 12글자 이하
		const regExp = /^[a-zA-Z][a-zA-Z0-9]{5,11}$/;
		
		if(regExp.test($(this).val())){
			$("#msgId").html("사용가능한 아이디입니다");
			$("#msgId").addClass("confirm");
			$("#msgId").removeClass("error");
		} else {
			$("#msgId").html("첫글자 영문자, 두번째부터 영문자와 숫자로 6글자 이상 12글자 이하로 입력해주세요");
			$("#msgId").addClass("error");
			$("#msgId").removeClass("confirm");
		}
	});

	$("#userPw").on("input", function(){
		// 비밀번호는 영문 대문자와 소문자, 숫자, 특수문자로 구성되고 8글자 이상 32글자 이하
		const regExp = /^[a-zA-Z0-9`~!@#$%^&*()\-_=+]{8,32}$/;
		
		if(regExp.test($(this).val())){
			$("#msgPw").html("사용가능한 비밀번호입니다");
			$("#msgPw").addClass("confirm");
			$("#msgPw").removeClass("error");
		} else {
			$("#msgPw").html("영문 대문자와 소문자, 숫자, 특수문자로 구성되고 8글자 이상 32글자 이하로 입력해주세요");
			$("#msgPw").addClass("error");
			$("#msgPw").removeClass("confirm");
		}
	});
	
	$("#userPwConfirm").on("change", function(){
		if ($("#userPw").val() != $("#userPwConfirm").val()) {
			alert("비밀번호와 비밀번호 확인은 일치해야 합니다.\n 다시 입력해 주세요.");
			$("#userPwConfirm").val("");
			$("#userPwConfirm").focus();
		}
	});
	
	// 이메일 선택하면 input 들어가게
 	$("#emailAddress").on("change", function(){
 		// val() : form 하위 태그에 입력된 값을 반환받기 위한 메서드
 		// val("값") : form 하위 태그에 값 설정하기 위한 메서드
		
 		let emailAddress = $("select[name='emailAddress']").val(); // value값
		
 		if($("#emailAddress > option:selected").index() == 5){ // 직접입력
  		   	 $("#emailDomain").removeAttr("readonly"); // 설정된 속성을 제거하기 위한 메서드
 			 $("#emailDomain").val("");
 			 $("#emailDomain").focus();
 		} else {
			 // 속성을 설정해주기 위한 메서드 attr->명확하게 정의되는 속성 prop->명확한 값을 가지지 않은 것
 			 $("#emailDomain").prop("readonly", "readonly"); 
 			 $("#emailDomain").val(emailAddress);
 		}
 	});
	
	// 취미 옆 checkbox 선택하면 option 다 선택되게
	/* 라디오버튼 선택여부 검사 */
	// $("라디오버튼CSS셀렉터").is(":checked") 
	// --> 체크일 경우: true
	$("#hobbyCheckTotal").on("change", function(){
		let hobby = $(".hobbyCheck");
		
		if($("#hobbyCheckTotal").is(":checked") ){
			for(let i=0; i<hobby.length; i++)
				hobby[i].checked = true;
		} else {
			for(let i=0; i<hobby.length; i++)
				hobby[i].checked = false;
		}
	});


	/* 필수 항목 제어 */
	$("#btnReg").on("click", function(){
		const gender = $("input[name='gender']");
		const hobbyCheck = $(".hobbyCheck");

		if($("#userId").val().replace(/s/g,"") == ""){
			alert("아이디를 입력해주세요");
			$("#userId").val("");
			$("#userId").focus();
			return false;
		} else if ($("#userPw").val().replace(/s/g,"") == ""){
			alert("비밀번호를 입력해주세요");
			return false;
		} else if ($("#userPwConfirm").val().replace(/s/g,"") == ""){
			alert("비밀번호 확인을 입력해주세요");
			return false;
		} else if ($("#userName").val().replace(/s/g,"") == ""){
			alert("이름을 입력해주세요");
			return false;
		} else if ($("#birth").val().replace(/s/g,"") == ""){
			alert("생년월일을 입력해주세요");
			return false;
		} else if (!gender[0].checked && !gender[1].checked){
			alert("성별을 체크해주세요");
			return false;
		} else if ($("#email").val().replace(/s/g,"") == "" || $("#emailDomain").val().replace(/s/g,"") == ""){
			alert("이메일을 입력해주세요");
			return false;
		} else if ($("#hpno").val().replace(/s/g,"") == ""){
			alert("핸드폰번호를 입력해주세요");
			return false;
		} else if (!hobbyCheck[0].checked && !hobbyCheck[1].checked && !hobbyCheck[2].checked && !hobbyCheck[3].checked && !hobbyCheck[4].checked && !hobbyCheck[5].checked){
			alert("취미를 하나 이상 체크해주세요");
			return false;
		} else if ($("#job").val()=="----- 선택하세요 -----"){
			alert("직업을 입력해주세요");
			return false;
		}

		alert("회원가입이 완료되었습니다");

		// 출력할 문자열 만들기
		let user_id = $("#userId").val();
		let user_pw = $("#userPw").val();
		let user_name = $("#userName").val();
		let birth = $("#birth").val();
		
		let gender_val = $("input[name='gender']:checked").val();
		let email = $("#email").val()+"@"+$("#emailDomain").val();
			
		let hpno = $("#hpno").val();
		let job = $("#job option:selected").val();
		
		// 체크박스의 선택항목 값들을 추출
		//let hobby = $("input[name='hobby']:checked");
		let hobby = $(".hobbyCheck:checked");
		
		let select_hobby = "";
		// each() 함수에 hobby의 개체 수 만큼 반복적으로 function()이 실행된다.
		hobby.each(function() {
			// 이벤트가 발생한 자기 자신을 가리키는 키워드
			select_hobby += $(this).val() + " ";
		});
		
		// 출력할 문자열 만들기
		let result = "<h1>회원가입 입력 데이터</h1><ul>";
		result += "<li>아이디: " + user_id + "</li>";
		result += "<li>비밀번호: " + user_pw + "</li>";
		result += "<li>이름: " + user_name + "</li>";
		result += "<li>생년월일: " + birth + "</li>";
		result += "<li>성별: " + gender_val + "</li>";
		result += "<li>이메일: " + email + "</li>";
		result += "<li>핸드폰번호: " + hpno + "</li>";
		result += "<li>취미: " + select_hobby + "</li>";
		result += "<li>직업: " + job + "</li>";
		result += "</ul>";
		
		$("#result").html(result);
	});	
});
