<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.bno }</title>
<link rel="stylesheet" href="./css/detail.css">
</head>
<body>
<%@ include file="menu.jsp" %>
<h1>상세보기</h1>
	<div class="detail-content">
		<div class="title">${dto.bno } / ${dto.btitle }</div>
		<div class="namebar">
			<div class="name">${dto.bwrite }</div>
			<div class="like">${dto.blike }</div>
			<div class="date">${dto.bdate }</div>
			<div class="ip">아직없다</div>
		</div>
		<div class="content">${dto.bcontent }</div>
	</div>	
</body>
</html>