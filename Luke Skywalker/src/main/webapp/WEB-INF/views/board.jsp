<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
<link rel="stylesheet" href="./resources/css/board.css">
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="f1"><h1>I am board</h1>
	길이 검사: ${fn:length(list) }
	<br>
	<c:choose>
		<c:when test="${fn:length(list) gt 0}">
			출력할 데이터가 있습니다.
			<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list}" var="i">
			<!-- onclick 자바스크립트 페이지 이동, URL?파라미터=값 -->
			<tr onclick="location.href='./detail?bno=${i.bno }'">
				<td class="td1">${i.bno }</td>
				<td class="title">${i.btitle}</td>
				<td class="td1">${i.m_name}</td>
				<td class="td2">${i.bdate}</td>
				<td class="td1">${i.blike}</td>
			</tr>
		</c:forEach>
	</table>
		</c:when>
		<c:otherwise>
			<h1>출력할 데이터가 없습니다.</h1>
		</c:otherwise>
	</c:choose></div>
	<img alt="??" src="./img/majayong.png" height="100px">
	<br>
	
	<!-- 로그인하면 글쓰기 버튼이 보여요 -->
	로그인한 이름: ${sessionScope.mname }/${sessionScope.mid }
	<c:if test="${sessionScope.mname ne null }">
	<button onclick="location.href='./write'">글쓰기</button>
	</c:if>
</body>
</html>