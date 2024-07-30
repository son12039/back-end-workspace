<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		
	</tr>
	<c:forEach items="${list}" var="mm" varStatus="status"> 
		<tr>  
			<%-- index : 0부터, count : 1부터 시작 --%>
			<th>${status.count}</th>
			<td>${mm.id}</td>
			<td>${mm.password}</td>
			<td>${mm.name}</td>	
			</tr>
		</c:forEach>			
	</table>
	 
	
	
	<a href="/">돌아가기</a>
	
</body>
</html>