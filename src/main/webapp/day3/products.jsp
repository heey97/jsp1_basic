<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix ="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/all.css">
<title>상품 전체 조회</title>
</head>
<body>
	<h3>상품 전체 조회</h3>
	<hr>
	<ul>
	<!-- list 이름의 애트리뷰트를 대상으로 합니다. : 애트리뷰트작성은 서블릿에서 합니다. -->
	<c:forEach items="${list }" var="vo" varStatus="status">
		<li>
			<ul class="row">
			<li><c:out value="pcode : ${vo.pcode}"/></li><!-- fn:toUpperCase(vo.customId) -->
			<li><c:out value="category : ${vo.category}"/></li>
			<li><c:out value="pname : ${vo.pname}"/></li>
			<li><c:out value="price : ${vo.price}"/></li> 	
		</ul>
		</li>
		</c:forEach>
	</ul>
</body>
</html>