<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/common.css" type="text/css">
<link rel="stylesheet" href="../resources/css/mypageCommon.css" type="text/css">
<link rel="stylesheet" href="../resources/css/qnaDetail.css" type="text/css">
</head>
<body>

	<div id="container">
		<div><jsp:include page="../common/header.jsp"></jsp:include></div>
		<div class="page_article">
		
		
			<div id="snb">
				<h2 class="tit_snb">마이보글</h2>
				<div class="inner_snb">
					<ul class="list_menu">
						<li><a href="/mypage/orderList">주문 내역</a></li>
						<li><a href="/mypage/listReviewWrite">상품 후기</a></li>
						<li><a href="/mypage/listQna">상품 문의</a></li>
						<li><a href="/mypage/loginMypage">개인 정보 수정</a></li>
					</ul>
				</div>
			</div>
			
			
			<!-- 오른쪽 -->
			<div class="page_section">
				<!-- 제목 -->
				<div class="head_article" id="qna_head">
					<h2>1:1문의 상세</h2>
				</div>
				 
				<div id="qna_box">
					
					<div id="qna_title">
						<div class="qna_name">제목</div><div class="qna_content" id="q_qna_title">  ${q.qna_title }</div>
					</div>	
					<hr>
					<div id="order_no">
						<div class="qna_name">주문번호</div><div class="qna_content" id="q_detail_no">  ${q.detail_no}</div>
					</div>
					<hr>
					<div id="qna_content">
						<div class="qna_name">문의 내용</div><div class="qna_content" id="q_qna_content"><textarea rows="10" cols="50" readonly="readonly">${q.qna_content }</textarea></div>	
					</div>
					<hr>
					<div id="qna_img">
						<div class="qna_name">첨부파일</div><div class="qna_content" id="q_qna_img"> <img src="../images/${q.qna_img }" onerror="this.style.display='none'" width="100" height="100"></div>
					</div>
					
				</div>
				<br>
				<br>
				
					<span class="qna_link"><a href="updateQna?qna_no=${q.qna_no }" style="color: white">수정</a></span>
					<span class="qna_link" id="qna_list"><a href="listQna" style="color: white">목록</a></span>
				
	
			</div>
		
	</div>
	<div><jsp:include page="../common/footer.jsp"></jsp:include></div>
	
</body>
</html>