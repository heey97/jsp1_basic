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
	<h3>JSTL 태그라이브러리 테스트</h3>
	<p>기존에 사용하던 jsp의 스크립트릿,출력식 기호를 대체합니다.
		이유는 요청을 처리하는 자바코드와 화면을 구성하는 html 태그
		jsp 파일을 태그형식으로만 작성하기 위함입니다.
	</p>
	<p>태그 라이브러리는 맨 위 지시자에서 정의하고 사용합니다. 
		EL기호는 애트리뷰트 값만 출력할 수 있습니다.
	</p>
	<% String name="sana"; //자바의 변수 %>
	<hr>
	<h4>c: 으로 시작하는(prefix) core 태그</h4>
	<!-- 1. pageContext 영역에 애트리뷰트 이름 age, 값 23을 저장합니다. -->
	<c:set var = "age" value ="23"/>
	<!-- 2. 저장된 애트리뷰트 값을 출력합니다. -->
	<h5>age : <c:out value="${age}"/></h5>
	<!-- 3. 자바의 if문을 대체하는 태그 입니다. -->
	<h5>c:if 테스트</h5>
	<!-- 조건식을 test 속성에 작성. EL기호 안에 씁니다. -->
	<c:if test="${age<20}">
		
	</c:if>
	<c:if test="${age>=20}">
		<div style="color:red">성인 입니다. </div>
	</c:if>
	
	<!-- 4. if ~ else 형식 -->
	<h5>>c:choose 테스트</h5>
	<c:set var="age" value="23"/> <!-- 애트리뷰트 age값 변경하기 -->
	<c:choose>
		<c:when test="${age<20}">
			<div style="color:green">청소년 입니다. </div>
		</c:when>
		<c:otherwise>
			<div style="color:red">성인 입니다. </div>
		</c:otherwise>
	</c:choose>
	<!-- 5. for문 -->
	<h5>c:forEach 테스트</h5>
	<c:forEach var ="i" begin="1" end="10" varStatus="status">
	<div>
		<c:out value="${i}"/>
		<c:out value="${i*11}"/>
		<!-- varstatus 속성은 for -->
		<c:out value="${status.count}"/>
	</div>
	</c:forEach>
	<!-- 6. 자바 객체 활용하기 -->
	<h5>자바 객체 활용하기</h5>
	<%
		TblCustomerDao dao = new TblCustomerDao(); 
		CustomerVo vo = new CustomerVo("momo2","강모모","momo22@daum.net",29,null);
		//만들어진 객체를 pageContext scope 의 애트리뷰트로 저장합니다.	
		//애트리뷰트 이름 customer 값은 vo
		pageContext.setAttribute("customer",vo);
	%>
	<c:out value="${customer }"/>
	<ul>
		<li>${customer.customId}</li>
		<li>${customer.name}</li>
		<li>${customer.email}</li>
		<li>${customer.age}</li>
	</ul>
	
</body>
</html>