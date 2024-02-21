<%@page import="project.vo.CustomerVo"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> insert.jsp</title>
</head>
<body>
<p>2번 select 조회 결과 확인과 같이 이번에는 insert 실행해 봅니다.</p>
<%
	CustomerVo vo = new CustomerVo("sana","김사나","sana@gmail.com",23,null);
	//dao 생성해서 insert 하기
	TblCustomerDao dao = new TblCustomerDao();
	dao.join(vo);
%>
	
		<h4>CustomerVo 객체</h4>
		<table style="width:600px;">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>나이</th>
				<th>가입날짜</th>
			</tr>
			<tr>
				<td><%= vo.getCustomId() %></td>
				<td><%= vo.getName() %></td>
				<td><%= vo.getEmail() %></td>
				<td><%= vo.getAge() %></td>
				<td><%= vo.getReg_date()%></td>
			</tr>
				
		</table>
	</ul>
	
	<p>아래 링크로 페이지 이동해서 insert 완료됬는지 확인해 봅니다.
	<a href="2_jdbc.jsp">전체 고객 조회</a>

</body>
</html>