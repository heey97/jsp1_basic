<%@page import="java.util.Date"%>
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
<title>13_jdbc_jstl</title>
<style>
	body{
		background-image:url("dodo.jpg");
	}
	fieldset{
		margin-top:10px;
		width: 350px;
		margin:auto;
		color:black;
		-webkit-text-stroke: 0.5px yellow;
		font-weight:bold;
		margin:auto;
		height: 150px;
		border-width: 6px;
		border-color: black;
		
		background-image:url("peng2.jpg");
		
		background-size: 90%;
		background-color: yellow;
		background-repeat: no-repeat;
		background-position: center;
	}
	.hhhh{
		width :700px;
		background-image:url(images.png);
		margin:auto;
		border-color: black;
		border-width: 3px;
	}
	li{
		list-style: none;
		margin : 5px;
	}
	.hh{
		width: 1000px;
		margin:auto;
		text-align:center;
		background-color: white;
	}

</style>
</head>
<body>
	<div class="hh">
		<h2>2번 소스파일 스크립트릿과 출력식을 jstl과 el로 변경하기</h2>
	</div>
	
<%
	//jdbc로 sql 조회한 결과 List 에 활용합니다.

		
	TblCustomerDao dao = new TblCustomerDao();
	
	List<CustomerVo> list = dao.allCustomers();
		
		pageContext.setAttribute("list",list);
		
	%>
	<div class="hhhh">
	<br>
			<c:forEach items="${list }" var="vo" varStatus="status">
	<fieldset>
			<ul>
		
				<!-- <li><c:out value="${status.index+1}"/></li> -->
				<li><c:out value="Id : ${vo.customId}"/></li><!-- fn:toUpperCase(vo.customId) -->
				<li><c:out value="Name : ${vo.name}"/></li>
				<li><c:out value="Email : ${vo.email}"/></li>
				<li><c:out value="Age : ${vo.age}"/></li>
				<li><fmt:formatDate value="${vo.reg_date}" pattern="yyyy-MM-dd a hh:mm:ss"/><li> 
			</ul>
	</fieldset>
	
	<br>
		
	</c:forEach>
	</div>


	
</body>
</html>