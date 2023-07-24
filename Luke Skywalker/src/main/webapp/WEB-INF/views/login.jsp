<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="login-box">
		<div class="login-image">
			<img alt="logo" src="./img/majayong.png" height="150px">
		</div>
		<div class="login-form">
			<form action="./login" method="post">
				ID<br><input type="text" id="id" name="id" placeholder="ID를 적어주세요."
					required="required" maxlength="20"><br> PW<br><input type="password"
					id="pw" name="pw" placeholder="PW를 적어주세요." required="required"
					maxlength="20"><br>
				<button class="login">LOGIN</button>
			</form>
		</div>
	</div>
</body>
</html>