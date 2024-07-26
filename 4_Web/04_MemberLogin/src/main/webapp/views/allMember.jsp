<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.model.dao.MemberDAO"%>
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
	
	<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");%>
	<table border="1">
		<tr>
		<% for(Member m : list) { %>  
			<th><%=m.getId() %> </th>
			<th><%=m.getPassword() %> </th>
			<th><%=m.getName() %> </th>	
			</tr>
			
			 <% } %>
	</table>
	
	
	<a href="/">돌아가기</a>
	
</body>
</html>