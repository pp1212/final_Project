<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주문 내역 상세</h2>
	주문번호 ${order_no } <br>
	<table border="1">
		<c:forEach var="o" items="${list }">
			<tr>
				${o.product_img }<br>
				${o.product_name }<br>
				${o.product_price }<br>
				${o.detail_cnt }<br>
				${o.status_code }<br>
			</tr>
		</c:forEach>
	</table>
	<br>
	결제정보
	<hr>
	상품금액 ${totalDetail }<br>
	배송비 3000원<br>
	결제금액 ${totalDetail +3000 }<br>
	결제방법 ${payment_code }<br>
	<br>
	배송정보
	<hr>
	받는 분 ${cust_name }<br>
	휴대폰 ${cust_phone }<br>
	주소 ${cust_addr1 }${cust_addr2 }${cust_addr3 }<br>
	
	<a href="orderList">목록</a>
</body>
</html>