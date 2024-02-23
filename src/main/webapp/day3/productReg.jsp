<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<!-- <link rel="stylesheet" href="../assets/css/register.css"> -->
<!-- jsp 파일을 실행할 때는 css 아래와 같이 하고요,,,,, -->
<link rel="stylesheet" href="assets/css/register.css">
<!-- 서블릿으로 화면을 보여 줄 때에는 ????? -->
</head>
<body>
	<div class="contents-wrap">
		<h3 style="text-align: center;">상품 등록</h3>
		<hr>
		<form action="register.cc" method="post">
			<ul class="join-wrap1" >
				<li>카테고리</li>
				<li>
					<input name="category" type="text"
					placeholder="카테고리를 입력해주세요" />
				</li>
				<li>상품코드</li>
				<li>
					<input name="pcode" type="text"
					 placeholder="상품코드를 입력해주세요." />
				</li>
				<li>상품명</li>
				<li>
					<input name="pname" type="text"
					placeholder="상품명을 입력해주세요." />
				</li>
				<li>가격</li>
				<li>
					<input name="price" type="text"
					placeholder="가격을 입력해주세요." />
				</li>
			</ul>
			<button class="join-btn">상품 등록</button>
		</form>
	</div>
	<script src="assets/js/script.js"></script>
</body>
</html>l>