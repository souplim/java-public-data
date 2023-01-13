<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>chungnamForm.jsp</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		
		<link rel='stylesheet' type='text/css' href='/servletExample/css/chungnam.css'>
		<style>
			#chungnamForm {
				display: flex;
				justify-content: center;
			}
			.strong { font-weight: bold; }
			input textarea {text-align: left;}
			.center { text-align: center; }
			
			.border-none { border-bottom: none; }
		</style>
		<!-- jQuery Framework 참조하기 -->
		<script src="../js/jquery-3.6.2.min.js"></script>
		<script src="../js/common.js"></script>
		
		<!-- 사용자 스크립트 블록 -->
		<script type="text/javascript">
			$(function(){
				$("#regBtn").on("click", function(){
					// 유효성 검사 함수화
					if(!chkData("#mng_no","번호를")) return;
					else if(!chkData("#local_nm","지역명을")) return;
					else if(!chkData("#type","타입을")) return;
					else if(!chkData("#nm","제목을")) return;
					else if(!chkData("#nm_sub","부제목을")) return;
					else if(!chkData("#addr","주소를")) return;
					else if(!chkData("#lat","좌표(경도)를")) return;
					else if(!chkData("#lng","좌표(위도)를")) return;
					else if(!chkData("#description","상세설명을")) return;
					else if(!chkData("#list_img","리스트 썸네일 이미지를")) return;
					else {
						$("#chungnamForm").attr({
							"method" : "post", /* 상세설명 -> 길이수 제한 없음 이렇게 다량의 데이터는 post 방식으로 전송 */
							"action" : "/servletExample/insert"
						});
						$("#chungnamForm").submit(); // form 전송 
					}
				});
				
				// 다시쓰기 버튼(reset 타입을 button으로 만들었다면) 제어
				/* $("#resBtn").click(function(){
					// 폼의 요소는 input, textarea 등만 해당
					$('#chungnamForm').each(function(){
						this.reset();
					});
				}); */
				
				// 목록 버튼 제어
				/* $("#listBtn").click(function(){
					location.href = '/servletExample/select';
				}); */
			});
		</script>
	</head>
	<body>
		<h1 class='title'>충남 데이터 삽입</h1>
		<form id="chungnamForm">
			<table>
				<tr>
					<td colspan="2" class="strong center">충남 정보 등록</td>
				</tr>
				<tr>
					<td class="strong">구분 번호</td>
					<td><input type="number" class="item-no" name="mng_no" id="mng_no" placeholder="번호 입력"/></td>
				</tr>
				<tr>
					<td class="strong">지역명</td>
					<td><input type="text" class="item-name" name="local_nm" id="local_nm" maxlength="14" placeholder="지역명 입력"/></td>
				</tr>
				<tr>
					<td class="strong">타입(분류)</td>
					<td><input type="text" class="item-type" name="type" id="type" maxlength="50" placeholder="타입 입력"/></td>
				</tr>
				<tr>
					<td class="strong">명소명</td>
					<td><input type="text" class="item-title" name="nm" id="nm" maxlength="50" placeholder="제목 입력"/></td>
				</tr>
				<tr>
					<td class="strong">명소명(부)</td>
					<td><input type="text" class="item-sub" name="nm_sub" id="nm_sub" maxlength="80" placeholder="부제목 입력"/></td>
				<tr>
					<td class="strong">명소 주소</td>
					<td><input type="text" class="addr" name="addr" id="addr" maxlength="100" placeholder="주소 입력"/></td>
				</tr>
				<tr>
					<td rowspan="2" class="strong">위치 정보</td>
					<td class="border-none"><input type="number" class="lat" name="lat" id="lat" maxlength="10" placeholder="lat 좌표(경도)"/></td>
					
				</tr>
				<tr>
					<td><input type="number" class="lng" name="lng" id="lng" maxlength="10" placeholder="lng 좌표(위도)"/></td>
				</tr>
				<tr>
					<td class="strong">명소 설명</td>
					<td><textarea class="item-content" name="description" id="description"></textarea></td>
				</tr>
				<tr>
					<td class="strong">이미지</td>
					<td><input type="text" class="item-thumb" name="list_img" id="list_img"/></td>
				</tr>
				<tr>
					<td colspan="2" class="center buttons">
						<button type="button" id="regBtn">입력완료</button>
						<button type="reset" id="resBtn">다시쓰기</button>
						<button type="button" id="listBtn" onclick="location.href='/servletExample/select'">목록</button>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
