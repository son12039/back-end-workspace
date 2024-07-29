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
	<h1>회원 검색 결과</h1>
	<ul>
		<li>검색한 아이디 :  ${m.id}</li>
		<li>검색한 비밀번호 :  ${m.password}</li>
		<li>검색한 이름 :  ${m.name}</li>
	</ul>
	<a href="/">돌아가기</a>
</body>
</html>