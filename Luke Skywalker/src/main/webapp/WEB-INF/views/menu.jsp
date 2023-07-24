<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="./css/menu.css">
<nav>
	<ul>
		<li onclick="link('')">메인</li>
		<li onclick="link('board')">게시판</li>
		<li onclick="link('board2')">일기장</li>
		<li onclick="link('mooni')">문의사항</li>
		<li onclick="link('notice')">공지</li>
		<div class="namespace">
		<div class="ni">
		</div>
		<div class="log">
		<c:choose>
			<c:when test="${sessionScope.mname eq null}">
				<li class="lir" onclick="link('login')">로그인</li>
			</c:when>
			<c:otherwise>
			 	<li class = "lir" onclick="link('logout')">로그아웃</li>
		<li class="gdgd" onclick="link('myInfo')">${sessionScope.mname }(${sessionScope.mid })님 반갑습니다.</li>
			</c:otherwise>
		</c:choose>
		</div>
		</div>
	</ul>
</nav>
<div style="height: 50px; width: 100%;">
</div>
<script>
function link(url) {
	location.href="./"+url;
}
</script>