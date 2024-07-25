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
	<% 	Member mb = (Member) request.getAttribute("user");
	%>
	<ul>
		<li>검색한 아이디 :  <%=mb.getId() %></li>
		<li>검색한 비밀번호 :  <%=mb.getPassword() %></li>
		<li>검색한 이름 :  <%=mb.getName() %></li>

	
	</ul>
	<a href="/">돌아가기</a>
</body>
</html>