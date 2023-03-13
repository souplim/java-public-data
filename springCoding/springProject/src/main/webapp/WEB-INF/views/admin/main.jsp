<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page trimDirectiveWhitespaces="true" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/resources/images/common/icon.png">

    <title>관리자 페이지</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/include/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/include/dist/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="resources/include/dist/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/resources/include/dist/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="/resources/include/js/jquery-3.6.2.min.js"></script>
    <script type="text/javascript" src="/resources/include/js/common.js"></script>
    <script type="text/javascript">
    	$(function(){
    		let errorMsg = "${errorMsg}";
    		if(errorMsg != ""){
    			alert(errorMsg);
    			errorMsg = "";
    		}
    		
    		$("#loginBtn").click(function(){
    			if(!checkForm("#a_id","관리자 아이디를")) return;
    			else if(!checkForm("#a_pwd","비밀번호를")) return;
    			else {
    				$("#loginForm").attr({
    					"method" : "post",
    					"action" : "/admin/login"
    				});
    				$("#loginForm").submit();
    			}
    		});
    	});
    </script>
  </head>
  <body>
    <div class="container">
      <form class="form-signin" id="loginForm">
        <h2 class="form-signin-heading">관리자 로그인</h2>
        <label for="a_id" class="sr-only">id</label> <!-- 숨겨져 있음 -->
        <input type="text" id="a_id" name="a_id" class="form-control" placeholder="id" required autofocus>
        <label for="a_pwd" class="sr-only">Password</label>
        <input type="password" id="a_pwd" name="a_pwd" class="form-control" placeholder="Password" required>
        
        <button class="btn btn-lg btn-primary btn-block" type="button" id="loginBtn">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/resources/include/dist/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
