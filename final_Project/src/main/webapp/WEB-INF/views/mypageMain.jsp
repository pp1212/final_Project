<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>개인 정보 수정</h2>
	<h3>비밀번호 재확인</h3>
	<hr>
	<form action="mypageMain" method="post">
		아이디 ${cust_id }<br>
		비밀번호 <input type="password" name="cust_pwd"><br>
		<hr>
		<input type="submit" value="확인">
	</form>
</body>
</html>