<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"  %>
	
	<style>
		#item-template {display:none;}
		.inline {display:inline-block;}
	</style>
	<script type="text/javascript">
		let message = "작성시 입력한 비밀번호를 입력해주세요"
		let btnkind=""; // 수정버튼과 삭제버튼을 구별하기 위한 변수
	
		$(function(){
			/* 덧글 비밀번호 숨김 */
			$("form[name='pwdForm']").hide(); // 필요할 때 show()를 통해서 보여줌
			
			/* 기본 덧글 목록 불러오기 */
			let b_num = ${boardVO.b_num};
			listAll(b_num);
			
			/* 글 입력을 위한 ajax 연동 처리 */
			// $("#replyInsertBtn").click(function(){
			$(document).on("click","#replyInsertBtn", function(){ // 입력 화면을 수정폼으로도 쓰기 때문에 수정
				let insertUrl = "/replies/replyInsert";
				
				/* JSON.stringify() : JavaScript 값이나 객체를 JSON 문자열로 변환 
				   
				   json 기본 형식
				   { 
					   "name" : 값(숫자),
					   "name" : "값(문자)"
				   }
				*/
				let value = JSON.stringify({ /* => {"b_num":1,"r_name":"홍길동",...} 이렇게 변환 */
					b_num : b_num,
					r_name : $("#r_name").val(),
					r_pwd : $("#r_pwd").val(),
					r_content : $("#r_content").val()
				});
				
				$.ajax({
					url : insertUrl, // 전속 url
					type : "post", 	// 전송 시 method 방식
					headers : {
						"Content-Type" : "application/json"  // content-Type => 클라이언트가 서버에게 제공하는 문서타입 지정
					},
					dataType : "text", // 받아오는 데이터는 SUCCESS / FAILURE -> TEXT
					data : value, // json을 문자열 형태로 받아들이기 위해 위에서 함수 정의
					error : function(xhr, textStatus, errorThrown){ // 실행시 오류가 발생했을 경우
						alert(textStatus + " (HTTP-"+ xhr.status + " / " +errorThrown + ")");
					},
					beforeSend: function(){ // 전송 전 유효성 체크 => 칸 비었으면 전송하면 안되기 때문에 return false
						if(!checkForm("#r_name","작성자를")) 			return false; // checkForm() 함수는 placeholder 속성 이용해서 메시지 출력
						else if(!checkForm("#r_pwd","비밀번호를"))		return false; //  함수 종료가 아닌 전송하지 않겠습니다-의 return false
						else if(!checkForm("#r_content","댓글내용을")) return false;
					},
					success : function(result){ // 서버로부터 응답코드 200으로 정상처리가 되었을 경우
						if(result=="SUCCESS"){
							alert("댓글 등록이 완료되었습니다.");
							dataReset(); // 입력폼 초기화
							listAll(b_num);
						}
					}
				});
			});
			
			/* 수정 및 삭제 전 비밀번호 화면 출력을 위한 처리 */
			$(document).on("click", "button[data-btn]", function() {
				dataReset(); // 다른 댓글 클릭했을 때 이전 비밀번호 폼은 숨겨야 하므로
				$("form[name='pwdForm']").show();
				let $pwdView = $("#pwdForm").clone().removeAttr('id'); // hidden이 아닌 폼 복제 -> 여러번 줄거니 id 속성 삭제
				$("form[name='pwdForm']").hide();
				
				let dataArea = $(this).parents("div.panel .panel-heading .panel-title"); // 비밀번호 칸 띄울 자리 찾기
				dataArea.append($pwdView); // 비밀번호 칸 추가
				btnKind = $(this).attr("data-btn"); // 버튼 종류 읽어오기
			});
			
			/* 비밀번호 체크 화면에서 "취소" 버튼 클릭 처리 */
			$(document).on("click", ".pwdResetBtn", function() {
				formHide(); // 댓글 비밀번호 칸 취소 누르면 폼 숨기는 함수
			});
			
			/* 비밀번호 체크 화면에서 "확인" 버튼 클릭 처리 */
			// 댓글 번호 어디서? -> template 함수에서 item-template에 추가해놓음
			$(document).on("click", ".pwdCheckBtn", function(){ 
				let panel = $(this).parents("div.panel");
				let r_num = panel.attr("data-num"); // 댓글번호
				let form = $(this).parents(".inline");
				let pwd = form.find(".passwd");
				let msg = form.find(".msg");
				let value = 0;
				
				if(!formCheck(pwd, msg, "비밀번호를")) return;
				else {
					$.ajax({
						url : "/replies/pwdConfirm",
						type : "POST",
						data : "r_num="+r_num+"&r_pwd="+pwd.val(), // r_num=1&r_pwd=1234
						dataType : "text", // "0" or "1" 받아옴
						error : function(){
							alert('시스템 오류 입니다. 관리자에게 문의 하세요');
						},
						success : function(resultData){
							//console.log("resultData : "+resultData);
							if(resultData==0){ // 일치하지 않는 경우
								msg.addClass("msg_error"); // 빨간글씨
								msg.text("비밀번호가 일치하지 않습니다.");
								pwd.select();
							} else if(resultData==1){ // 일치할 경우
								if(btnKind == "upBtn"){
									//console.log("수정 폼 출력");
									updateForm(r_num, panel); // 수정 폼 출력
									formHide();
								} else if(btnKind=='delBtn'){
									//console.log("삭제 처리");
									deleteBtn(b_num, r_num);
								}
								btnKind="";
							}
						}
					});
				}
			});
			
			/* 수정 폼 화면 구현 함수 - 최상위 안에 넣을 필요는 없음(용이한 설명 위함) */	
			function updateForm(r_num, panel){
				$("#replyForm .resetBtn").detach(); // 동적으로 구현했던 버튼 요소 제거?
				
				$("#r_name").val(panel.find(".panel-title .name").html());
				$("#r_name").prop("readonly", true); // 작성자 이름은 바꾸지 못하게
				
				let content = panel.find(".panel-body").html();
				content = content.replace(/(<br>|<br\/>|<br \/>)/g,'\r\n'); // <br> <br/> <br />
				// 댓글 불러올 때 두 줄 댓글의 경우 \r\n -> <br>로 변경했으므로 그냥 두면 <br>이 그대로 나올 수 있으므로 제어
				$("#r_content").val(content);
				
				$("#replyForm button[type='button']").attr("id","replyUpdateBtn");
				$("#replyForm button[type='button']").attr("data-rnum", r_num);
				$("#replyForm button[type='button']").html("수정"); // '저장'이었던 버튼값 변경
				
				let resetButton = $("<button type='button' class='btn btn-success resetBtn'>"); // 동적으로 버튼 생성
				resetButton.html("취소");
				$("#replyForm .sendBtn").after(resetButton); // 저장하기 다음에 취소 버튼 생성
			}
			
			/* 수정하기 클릭시 동적으로 생성된 "취소" 버튼 이벤트 처리 */
			$(document).on("click",".resetBtn", function(){
				dataReset();
			});
			
			/* 수정을 위한 Ajax 연동 처리 */
			$(document).on("click", "#replyUpdateBtn", function(){
				let r_num = $(this).attr("data-rnum");
				$.ajax({
					url : '/replies/'+r_num,
					type : 'put', // Controller의 replyUpdate에서 처리
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "PUT"
					},
					data : JSON.stringify({
						r_content : $("#r_content").val(),
						r_pwd : $("#r_pwd").val()
					}),
					dataType : 'text', // 받아올 문서 타입
					error : function(xhr, textStatus, errorThrown){
						alert(textStatus + " (HTTP-" + xhr.status + " / " + errorThrown + ")");
					},
					beforeSend : function(){
						if(!checkForm("#r_content","댓글내용을")) return false; // 댓글 내용 입력해야 함
					},
					success : function(result){
						console.log("result: "+ result);
						if(result == "SUCCESS"){
							alert("댓글 수정이 완료되었습니다.");
							dataReset();
							listAll(b_num);
						}
					}
				});
			});
			
		});	// 최상위 $ 종료
			
		/* 댓글 목록 보여주는 함수 - 서버로부터 리스트 받아오기 위한 요청 함수 */
		function listAll(b_num){
			$(".reply").detach(); // detach(): 선택한 요소를 DOM 트리에서 삭제(불러올 때마다 클래스 추가하므로 중복 출력 방지)
			
			let url = "/replies/all/"+b_num; // 요청 uri: 단 게시글번호(b_num)이 1번이라면 => /replies/all/1
			
			$.getJSON(url, function(data){ // data = [{r_num:1, r_name:"홍길동"...},{...}]
				$(data).each(function(){
					let r_num = this.r_num;
					let r_name = this.r_name;
					let r_content = this.r_content;
					let r_date = this.r_date;
					r_content = r_content.replace(/(\r\n|\r|\n)/g, "<br />"); 
					// 댓글내용에서 enter를 입력하면 \n\r or \r or \n으로 처리
					template(r_num, r_name, r_content, r_date);
				});
			}).fail(function(){
				alert("덧글 목록을 불러오는 데 실패하였습니다. 잠시 후에 다시 시도해주세요.");
			});
		}
		
		/* 새로운 글을 화면에 보여주기(추가하기) 위한 함수 */
		function template(r_num, r_name, r_content, r_date){
			let $div = $("#reviewList"); // => <div id="reviewList">
			
			let $element = $("#item-template").clone().removeAttr('id'); // id 속성 중복될 수 없기 때문에 삭제 => <div> 
			$element.attr("data-num", r_num); // <div data-num="1" class="panel panel-success reply">
			$element.addClass("reply");
			$element.find('.panel-heading > .panel-title > .name').html(r_name);
			$element.find(".panel-heading > .panel-title > .date").html(" / " + r_date);
			$element.find('.panel-body').html(r_content);
			
			$div.append($element);
		}
		
		/* 입력폼 초기화 함수 */
		function dataReset(){
			$("#replyForm").each(function(){
				this.reset();
			});
			
			$("#r_name").prop("readonly", false);
			$("#replyForm button[type='button']").removeAttr("data-rnum");
			$("#replyForm button[type='button']").attr("id", "replyInsertBtn");
			$("#replyForm button[type='button'].sendBtn").html("저장"); // 수정 -> 저장
			$("#replyForm button[type='button'].resetBtn").detach(); // 취소버튼 제거
		}
		
		/* 비밀번호 화면 초기화 */
		function formHide(){
			$("form[name='pwdForm']").hide();
		}
		
		/* 글 삭제를 위한 Ajax 연동 처리 */
		function deleteBtn(b_num, r_num){ // 삭제하고 게시글 번호 다시 로딩하기 위한 b_num -> listAll(b_num)에서 사용
			if(confirm("선택하신 댓글 삭제하시겠습니까?")){
				$.ajax({
					//url : '/replies/' + b_num + '/' + r_num,
					url : '/replies/' + r_num,
					type : 'delete', // method - get(조회)/post(입력)/put(수정)/delete(삭제) 존재
					headers : {
						"X-HTTP-Method-Override" : "DELETE"
					},
					dataType : 'text',
					error : function(xhr, textStatus, errorThrown){
						alert(textStatus + " (HTTP-" + xhr.status + " / " + errorThrown + ")");
					},
					success : function(result){
						console.log("result: "+ result);
						if(result == "SUCCESS"){
							alert("댓글 삭제가 완료되었습니다.");
							listAll(b_num);
						}
					}
				});
			} else { // 삭제하시겠습니까? 했을 때 취소 누름
				formHide();
			}
		}
	</script>
	</head>
	<body>
		<div id="replyContainer">
			<!-- 댓글 입력 화면 -->
			<form id="replyForm">
				<div class="panel panel-default">
					<table class="table">
						<tbody>
							<tr>
								<td class="col-md-1">작성자</td>
								<td class="col-md-3 text-left">
									<input type="text" id="r_name" name="r_name" maxlength="5" class="form-control" />
								</td>
								<td class="col-md-1">비밀번호</td>
								<td class="col-md-3 text-left">
									<input type="password" id="r_pwd" name="r_pwd" maxlength="18" class="form-control" />
								</td>
								<td class="col-md-4 btnArea">
									<button type="button" id="replyInsertBtn" class="btn btn-success gap sendBtn">저장</button>
								</td>
							</tr>
							<tr>
								<td class="col-md-1">댓글내용</td>
								<td colspan="4" class="col-md-11 text-left">
									<textarea name="r_content" id="r_content" class="form-control" rows="3"></textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</form>
			
			<!-- 비밀번호 확인 -->
			<form name="pwdForm" id="pwdForm" class="form-inline inline passwdArea">
				<div class="form-group">
					<label for="passwd"> 비밀번호 : </label>
					<input type="password" name="passwd" class="form-control passwd gap" />
				</div>
				<button type="button" class="btn btn-default pwdCheckBtn gap">확인</button>
				<button type="button" class="btn btn-default pwdResetBtn gap">취소</button>
				<span class="msg"></span>
			</form>
			
			<!-- 리스트 영역 -->
			<div id="reviewList">
				<div id="item-template" class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="name"></span>
							<span class="date"></span>
							<button type="button" data-btn="upBtn" class="btn btn-default gap">수정하기</button><!-- 식별하기 위한 data- -->
							<button type="button" data-btn="delBtn" class="btn btn-default gap">삭제하기</button>
						</h3>
					</div>
					<div class="panel-body"></div>
				</div>
			</div>
		</div>
	</body>
</html>