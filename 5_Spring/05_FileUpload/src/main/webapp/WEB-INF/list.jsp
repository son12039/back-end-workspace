<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">

		<div class="header">
			<h1>List Page</h1>
			<a href="/write" class="btn btn-outline-warning">게시글 등록</a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>#번호</th>
					<th>제목</th>
					<th>작성시간</th>
				</tr>
			</thead>
			<tbody>
				<!-- 리스트 가져다가 뿌려주세요 -->


				<c:forEach items="${list}" var="i" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td><a href="/view?no=${i.no}">${i.title}</a></td>
						<td><fmt:formatDate value="${i.formatDate}"
								pattern="yyy-MM-dd HH:mm:ss" /></td>
						<td>${i.content}</td>
						<td>${i.url}</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
		<ul class="pagination">
			<li class="page-item ${paging.prev ? '' : 'disabled'}"><a class="page-link"
				href="/list?page=${paging.startPage - 1}">Previous</a></li>
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
				var="page">
				<li class="page-item">
				<a class="page-link ${paging.page == page ? 'active' : ''}"
					href="/list?page=${page}">${page}</a></li>
			</c:forEach>
			<li class="page-item"><a class="page-link" ${page.next ? '' : 'disabled'}
				href="/list?page=${paging.endPage + 1}">NEXT</a>
		</ul>

	</div>
</body>
</html>