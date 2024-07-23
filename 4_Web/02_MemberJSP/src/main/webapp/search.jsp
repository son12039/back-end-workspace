<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%Member mem = (Member) request.getAttribute("mem");
	if(mem!=null) { %>
		<p>아이디 : <%=mem.getId() %></p>
		<p>비밀번호 : <%=mem.getPassword() %></p>
		<p>이름 : <%=mem.getName() %></p>
		
	<%} else {%> 
		<h1>회원 정보 없음</h1>
	<%} %>

		 
</body>
</html>