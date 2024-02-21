<%@page import="java.util.List"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@page import="project.dao.TblBuyDao"%>
<%@page import="project.vo.CustomerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
   <%@taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
   <%@taglib prefix ="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 자바 객체 컬렉션(리스트) 활용하기 -->
	<h5>자바 객체 컬렉션(리스트) 활용하기</h5>
	<%
	//jdbc로 sql 조회한 결과 List 에 활용합니다.

		
	TblCustomerDao dao = new TblCustomerDao();
	
	List<CustomerVo> list = dao.allCustomers();
		
		pageContext.setAttribute("list",list);
	%>
	<c:forEach items="${list }" var="vo" varStatus="status">
	<!-- varStatus 속성 index는 지금처럼 items로 컬렉션 다룰 때 사용합니다. -->
	<c:out value="${status.index}"/>,<c:out value="${vo}"/>
	<ul>
		<li><c:out value="${vo.customId}"/></li>
		<li><c:out value="${vo.name}"/></li>
		<li><c:out value="${vo.email}"/></li>
		<li><c:out value="${vo.age}"/></li>
	</ul>	
	</c:forEach>

	
</body>
</html>