<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" href="./css/login.css">
<script type="text/javascript">
		
		//호이스팅? let, var? json? const? 다 찾아서 저게 뭔지 읽어보세요.
		/* 인터프리터가 변수와 함수의 메모리 공간을 선언 전에 미리 할당하는 것을 의미합니다. 
		var로 선언한 변수의 경우 호이스팅 시 undefined로 변수를 초기화합니다. 
		반면 let과 const로 선언한 변수의 경우 호이스팅 시 변수를 초기화하지 않습니다.*/
	function checkID() {
		//alert("!");
		let msg = document.getElementById("msg");
		msg.innerHTML += "<p>" + document.getElementById("id").value + "아이디를 변경했습니다.</p>";
	}
	function check() {
		//alert("!");
		let msg = document.getElementById("msg");
		let id = document.getElementById("id");
		let id = document.getElementById("pw");
		//alert(id.value);
		//alert(id.value.length);
		if(id.value.length <= 4){
			alert("아이디는 4글자 이상이어야 합니다.");
			msg.innerHTML = text;
			id.focus();
			return false;
		}
		
		//alert(id.value);
		//alert(id.value.length);
		if(pw.value.length <= 4){
			alert("패스워드는 4글자 이상이어야 합니다.");
			pw.focus();
			return false;
		}
		
	}
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="login-box">
		<div class="login-image">
			<img alt="logo" src="./img/majayong.png" height="150px">
		</div>
		<div class="login-form">
			<form action="./login" method="post" onsubmit="return check()">
				ID<br><input type="text" id="id" name="id" placeholder="ID" required="required" maxlength="20" onchange="checkID()"><br> 
				PW<br><input type="password" id="pw" name="pw" placeholder="PW" required="required" maxlength="20"><br>
				<button type="submit" class="login" >LOGIN</button>
				<span id="msg"></span>
			</form>
		</div>
	</div>
</body>
</html>