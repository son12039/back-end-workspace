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
	<h1>회원 관리 기능</h1>	
	<ul>
		<!-- 로그인 되어 있지 않은 경우 -->
		<% 
		Member m = (Member) session.getAttribute("m");%>
		<% if(m != null) { %> 
			<!-- 로그인된 경우 -->
		<li><a href="views/search.jsp">회원검색</a></li>
		<!--  회원검색 검색할 아이디받고
				호출 /search 방식 get 
				SearchServlet
				성공하면 views/search_ok.jsp 해당 정보 출력
				실패하면 views/search_fail.jsp "검색실패했습니다-->
		<li><a href="/allMember">전체회원보기</a></li>
		<!-- 전체회원보기 : views/allMember.jsp에 리스트 출력 -->
		<li><a href="/logout">로그아웃</a></li>
		<!-- 로그아웃 index.jsp -->
			<% } else { %>
			<li><a href="/views/register.jsp">회원가입</a></li>
			<li><a href="/views/login.jsp">로그인</a></li> 		  
		<% } %>
 							 
	</ul>
</body>
</html>