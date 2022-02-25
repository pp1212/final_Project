<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
function kakaopost() {
    new daum.Postcode({
        oncomplete: function(data) {
           document.querySelector("#cust_addr1").value = data.zonecode;
           document.querySelector("#address").value =  data.address
        }
    }).open();
}
function passConfirm() {
	
	var password = document.getElementById('cust_pwd');				//비밀번호 
	var passwordConfirm = document.getElementById('cust_pwd_ck');	//비밀번호 확인 값
	var confrimMsg = document.getElementById('confirmMsg');			//확인 메세지
	var correctColor = "#00ff00";
	var wrongColor ="#ff0000";
	
	if(password.value == passwordConfirm.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
		confirmMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
		confirmMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
	}else{
		confirmMsg.style.color = wrongColor;
		confirmMsg.innerHTML ="비밀번호 불일치";
		return false;
	}
}
</script>
</head>
<body>
	<h2>개인 정보 수정</h2>
	<h4>*필수입력사항</h4>
	<hr>
	<form action="updateCustomer" method="post" name="joinForm">
		<div>아이디*  <input type="hidden" name="cust_id" value="${c.cust_id }"> ${c.cust_id }</div> 
		
		<div>비밀번호*  <input type="password" name="cust_pwd" value="${c.cust_pwd }" id="cust_pwd" size="27"></div> 
		
		비밀번호확인*  <input type="password" name="cust_pwd_ck" id="cust_pwd_ck" onkeyup="passConfirm()" size="27"> <span id ="confirmMsg"></span><br>
		
		이름*  <input type="text" name="cust_name" value="${c.cust_name }" size="27"><br>
		
		휴대폰*  <input type="text" name="cust_phone" value="${c.cust_phone }" size="27"><br>
		
		이메일*  <input type="text" name="cust_email" value="${c.cust_email }" size="27">
				<input type="submit" value="중복확인"><br>
		
		주소*		<input type="text" name="cust_addr1" id="cust_addr1"value="${c.cust_addr1 }"size="10"> 
           		<input type="button" value="우편번호찾기" onclick="kakaopost()"><br>
				<input type="text" name="cust_addr2" value="${c.cust_addr2 }" id="address" size="27"><br>
				<input type="text" name="cust_addr3" value="${c.cust_addr3 }" size="27"><br>
		<br>
		<input type="submit" value="확인">
	</form>
</body>
</html>