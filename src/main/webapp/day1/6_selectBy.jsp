<%@page import="project.vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>4번 url 주소에서 보낸 파라미터를 받아 값을 저장합니다.-> 조회</h3>
<%
	//getParameter 의 리턴 타입은 String
	String name = request.getParameter("name");
	String temp = request.getParameter("age");
	
	TblCustomerDao dao = new TblCustomerDao();
	List<CustomerVo> list = null;
	
	if((name !=null && name.length()!=0) && (temp!=null && temp.length() !=0)){
		int age = Integer.parseInt(temp);
		list = dao.selectByNameAge(name,age);
		out.print(list);
		if(list.size()==0) out.print("<h4>조회결과가 없습니다.</h4>");
	}else{
		out.print("파라미터를 모두 입력해 주세요.");
	}
%>
</body>
</html>