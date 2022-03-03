<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주문 내역</h2>
	<hr>
	<table border="1">
		<c:forEach var="o" items="${list }">
			<tr>
				<td><fmt:formatDate value="${o.order_date }"/></td>
				<td><a href="orderDetail?order_no=${o.order_no}">주문상세보기</a></td>	
				<td>${o.order_no }</td>					
				<td>${o.status_code }</td>					
			</tr>
		</c:forEach>
	</table>
</body>
</html>