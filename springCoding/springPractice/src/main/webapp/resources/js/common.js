/* 함수명 : chkData(유효성 체크 대상, 메시지 내용)
 * 출력영역 : alert
 * 예시 : if(!chkData("#keyword","검색이름")) return;
 */
 
function chkData(item, msg){
	if($(item).val().replace(/s/g,"")==""){
		alert(msg+"입력해 주세요.");
		$(item).val("");
		$(item).focus();
		return false;
	} else
		return true;
}

/* 함수명 : dataCheck(유효성 체크 대상, 메시지 영역, 메시지 내용)
 * 출력영역 : 
 * 예시 : if(!dataCheck("#keyword","#area","검색이름")) return;
 */
function dataCheck(item, area, msg){
	if($(item).val().replace(/s/g,"")==""){
		$(area).text(msg+"입력해 주세요.").css("color","red");
		$(item).select();
		return false;
	} else
		return true;
}