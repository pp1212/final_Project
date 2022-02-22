<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div id="header"><!-- 헤더 --></div>
		<div class="page_article">
			<div><!-- 메뉴 --></div>
			<div class="page_section">
				<div class="head_article">
					<h2>후기 작성</h2>
				</div>
				<form name="form_review" id="form_review" action="/mypage/updateReview" method="post" enctype="multipart/form-data">
					<div class="write_board">
						<div class="goods_info">
							<img src="/images/${r.product_img }">
							<div class="name">${r.product_name }</div>
						</div>
						<table class="tbl">
							<colgroup>
								<col style="width:110px;">
								<col style="width:auto">
							</colgroup>
							<tbody>
								<tr>
									<th>제목</th>
									<td>
										<input type="text" name="review_title" placeholder="제목을 입력해주세요." class="inp">
									</td>
								</tr>
								<tr>
									<th>후기작성</th>
									<td>
										<textarea id="fieldCmt" name="review_content" rows="10" cols="100" 
											placeholder="내용을 입력해주세요.반품/환불 문의는 상품문의로 가능합니다." style="height:202px;"></textarea>
									</td>
								</tr>
								<tr>
									<th>사진등록</th>
									<td>
										<input type="file" name="uploadFile">
									</td>
								</tr>
							</tbody>
						</table>
						<button type="button" id="btnSubmit" class="btn_reg"></button>
					</div>
				</form>
			</div>
		</div>
		<div id="footer"><!-- 푸터 --></div>
	</div>
</body>
</html>