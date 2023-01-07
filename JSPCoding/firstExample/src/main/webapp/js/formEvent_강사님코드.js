$(function() {
	$("#emailAddress").change(function(){
		// val(): form 하위 태그에 입력된 값을 반환받기 위한 메서드 
		// val("값"): form 하위 태그에 값 설정하기 위한 메서드 
		
		//$("#emailDomain").val( $("select[name='emailAddress']").val());
		
		let emailAddress = $("select[name='emailAddress']").val();
		
		if($("#emailAddress >  option:selected").index() == 5){
			$("#emailDomain").removeAttr( "readonly" ); // 설정된 속성을 제거하기 위한 메서드
			$("#emailDomain").val("");
			$("#emailDomain").focus();
		} else {
			$("#emailDomain").prop("readonly", "readonly"); // 속성을 설정해 주기 위한 메서드
			$("#emailDomain").val(emailAddress);
			
		}
	});
	
	// id 속성이 join인 <form>태그 안의 submit 버튼을 누른 경우
	//$("버튼요소").click(function(){  if(조건문) { 실행문; return; }... });
	$("#join").submit(function() {
		// $(input요소).val() 함수는 사용자가 입력한 값 반환.
		// $(input요소).val('매개변수') 함수는 요소에 값 설정.
		
		/** 아이디 입력검사 */
		let userid = $("input[name='user_id']").val();
		
		if (userid.replace(/\s/g,"")=="") {
			alert("아이디를 입력하세요.");
			$("input[name='user_id']").val("");
			$("input[name='user_id']").focus();
			
			// placeholder 속성을 input 요소에 추가할고자 할 때 placeholder="아이디를 입력해 주세요"
			//$("input[name='user_id']").val("");
			//$("input[name='user_id']").attr("placeholder","아이디를 입력해 주세요");
			return false;
		}
		
		let idPattern = /(^[a-zA-Z].\w{5,11}$)/g;
		if(!idPattern.test(userid)){
			alert("아이디는 첫글자 영문자로, 두번째부터 영문자와 숫자로 6글자이상 12글자이하로 작성해 주셔야 합니다.");
			$("#user_id").val("");
			$("#user_id").focus();
			return false;
		}
		
		/** 비밀번호 입력검사 */
		if ($("input[name='user_pw']").val().replace(/\s/g,"")=="") {
			alert("비밀번호를 입력하세요.");
			$("input[name='user_pw']").val("");
			$("input[name='user_pw']").focus();
			return false;
		}
		
		if ($("#user_pw2").val().replace(/\s/g,"")=="") {
			alert("비밀번호를 입력하세요.");
			$("#user_pw2").val("");
			$("#user_pw2").focus();
			return false;
		}
		
		if ($("#user_pw").val() != $("#user_pw2").val()) {
			alert("비밀번호와 비밀번호 확인은 일치해야 합니다.\n 다시 입력해 주세요.");
			$("#user_pw2").val("");
			$("#user_pw2").focus();
			return false;
		}
		
		let pwdPattern =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,32}$/;
		if(!pwdPattern.test($("#user_pw").val())){
			alert("비밀번호는 영문 대문자와 소문자, 숫자, 특수문자로 구성되면 8글자이상 32글자이하로 작성해 주셔야 합니다.");
			$("#user_pw").val("");
			$("#user_pw").focus();
			return false;
		}
		
		/** 이름 입력검사 */
		if ($("#user_name").val().replace(/\s/g,"")=="") {
			alert("이름을 입력하세요.");
			$("#user_name").val("");
			$("#user_name").focus();
			return false;
		}
		
		/** 생년월일 입력검사 */
		if ($("#birth").val().replace(/\s/g,"")=="") {
			alert("생년월일를 입력하세요.");
			$("#birth").val("");
			$("#birth").focus();
			return false;
		}	

		/** 라디오버튼 선택여부 검사 */
		// $("라디오버튼CSS셀렉터").is(":checked") 
		// --> 체크일 경우: true
		if (!$("input[name='gender']").is(":checked")) {
			alert("성별을 선택해 주세요.");
			$("input[name='gender']:eq(0)").focus();
			return false;
		}
		
		/** 이메일주소 입력여부 검사 */
		if ($("input[name='email']").val().replace(/\s/g,"")=="") {
			alert("이메일 주소를 입력하세요.");
			$("input[name='email']").val("");
			$("input[name='email']").focus();
			return false;
		}
		
		/** 이메일주소 입력여부 검사 */
		if ($("input[name='emailDomain']").val().replace(/\s/g,"")=="") {
			alert("이메일 주소를 입력하세요.");
			$("input[name='emailDomain']").val("");
			$("input[name='emailDomain']").focus();
			return false;
		}
		
		/** 핸드폰 번호 입력여부 검사 */
		if ($("input[name='hpno']").val().replace(/\s/g,"")=="") {
			alert("핸드폰 번호를 입력하세요.");
			$("input[name='hpno']").val("");
			$("input[name='hpno']").focus();
			return false;
		}
		
		/** 체크박스 선택여부 검사 */
		if (!$("input[name='hobby']").is(":checked")) {
			alert("취미를 선택해 주세요.");
			$("input[name='hobby']:eq(0)").focus();
			return false;
		}
		
		/** selectbox 선택여부 검사 
		 - $("select의 셀렉터 >  option:selected").index() : 선택된 항목의 index 번호.
		 - $("select의 셀렉터 >  option:selected").val() : 선택된 항목의 값
		 - $("select의 셀렉터").val() : 선택된 항목의 값을 반환.
		*/	   
		if ($("select[name='job'] >  option:selected").index() < 1) {
			alert("직업을 선택해 주세요.");
			$("select[name='job']").focus();
			return false;
		}
		 /** 입력 내용을 화면에 출력해 봅시다. */
		let user_id = $("#user_id").val();
		let user_pw = $("input[name='user_pw']").val();
		let user_name = $("#user_name").val();
		let birth = $("input[name='birth']").val();
		
		let gender = $("input[name='gender']:checked").val();
		let email = $("input[name='email']").val()+"@"+$("input[name='emailDomain']").val();
			
		let hpno = $("input[name='hpno']").val();
		let job = $("select[name='job'] > option:selected").val();
		
		// 체크박스의 선택항목 값들을 추출
		//let hobby = $("input[name='hobby']:checked");
		let hobby = $(".hobby_check:checked");
		
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
		result += "<li>성별: " + gender + "</li>";
		result += "<li>이메일: " + email + "</li>";
		result += "<li>핸드폰번호: " + hpno + "</li>";
		result += "<li>취미: " + select_hobby + "</li>";
		result += "<li>직업: " + job + "</li>";
		result += "</ul>";
		$("#formResult").show();
		$("#formResult").html(result);
			
		// submit되면 결과 확인이 안되므로 전송처리 강제 종료
		return false; 
	});
	
	// #all_check 요소의 상태가 변한 경우
	$("#all_check").change(function() {
		// 스스로의 체크 상태 판별
		let is_check = $(this).is(":checked");
		$(".hobby_check").prop("checked", is_check);
	});
	
	// #upload_file_check 요소의 상태가 변한 경우
	$("#upload_file_check").change(function() {
		let is_check = $(this).is(":checked"); //선택시 true / 선택해제시 false
		//disabled 속성 비활성화
		$("#attach_file").prop("disabled", !is_check); //disabled=true disabled=false
	});
}); // $함수의 종료