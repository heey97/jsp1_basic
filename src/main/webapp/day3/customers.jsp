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
<title>고객 전체 조회</title>
</head>
<body>
	<h3>고객 전체 조회</h3>
	<hr>
	<ul>
	<!-- list 이름의 애트리뷰ㅗ트를 대상으로 합니다. : 애트리뷰트작성은 서블릿에서 합니다. -->
	<c:forEach items="${list }" var="vo" varStatus="status">
		<li>
			<ul class="row">
			<!-- <li><c:out value="${status.index+1}"/></li> -->
			<li><c:out value="Id : ${vo.customId}"/></li><!-- fn:toUpperCase(vo.customId) -->
			<li><c:out value="Name : ${vo.name}"/></li>
			<li class ="hh"><c:out value="Email : ${vo.email}"/></li>
			<li><c:out value="Age : ${vo.age}"/></li>
			<li><fmt:formatDate value="${vo.reg_date}" pattern="yyyy-MM-dd a hh:mm:ss"/><li> 	
		</ul>
		</li>
		</c:forEach>
	</ul>
</body>
</html>