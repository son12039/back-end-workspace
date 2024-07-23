<%@page import="java.util.ArrayList"%>
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

	<h2>회원 조회</h2>
	<form action="search">
		검색할 회원 아이디를 입력해주세요 <br>
		<input type="text" name="id">
		<input type="submit" value="조회">
	</form>
	 

	
	
	
	<h1>전체 리스트</h1>
	<table border="1">
	
	<%ArrayList<Member> mlist = (ArrayList<Member>) request.getAttribute("mlist");%>
	    
	<% for(Member m : mlist) { 
		%> <tr>
		<th>아이디<%=m.getId() %></th>  
		<th>비밀번호<%=m.getPassword() %></th>
		<th>이름<%=m.getName() %></th> 
		</tr>
		<% }%>

	 
	 <!--  member mlist = (member) request.getAttribute("list"); -->
		<!--  리스트로 가지고 오고 for문 활용 -->
	</table>
</body>
</html>