<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
<link rel="stylesheet" href="./resources/css/board.css">
</head>
<body>
	<%@ include file="menu.jsp"%>
	<h1>I am board</h1>
	<img alt="??" src="./img/majayong.png" height="100px">
	<br>
	<a href="./index">index</a>
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
				<td class="td1">${i.bwrite}</td>
				<td class="td2">${i.bdate}</td>
				<td class="td1">${i.blike}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>