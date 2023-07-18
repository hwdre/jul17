<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="./css/menu.css">
<nav>
	<ul>
		<li onclick="link('')">메인</li>
		<li onclick="link('board')">게시판</li>
		<li onclick="link('')">일기장</li>
		<li onclick="link('')">문의사항</li>
		<li onclick="link('')">공지</li>
	</ul>
</nav>
<div style="height: 50px; width: 100%;">
</div>
<script>
function link(url) {
	location.href="./"+url;
}
</script>