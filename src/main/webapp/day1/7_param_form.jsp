<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>7_param_form</title>
</head>
<body>
	<h3>테이블 행 조회에 필요한 조건값(name,age)을 input 에 입력하고 전송하기</h3>
	<hr>
	<form action="6_selectBy.jsp">
		<!--  input의 required 는 form 의 submit 으로만 동작합니다. -->
		<input type = "text" name="name" placeholder="이름을 입력하세요"required>
		<input type = "number" name="age" placeholder="나이를 입력하세요"required>
		<button>조회</button>
		<!-- 기본 type = submit. 클릭하면 action 에 지정된 url로 전송됩니다.
			form method="get"(기본값)이면 파라미터가 url에 포함됩니다.(조회)
			실행하면 url 확인해보세요. 4번 실행 url과 같습니다. 
		 -->
	</form>
</body>
</html>