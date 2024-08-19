<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous" />
</head>
<body>
	<h1>게시물 정보</h1>
		<form action="update" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label>Title</label>
				<input class="form-control" name="title" value="${a.title}">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control" name="content" rows="10">${a.content}</textarea>
			</div>
			<img src="http://192.168.10.51:8082/${a.url}" width="200px"/>
			<div class="form-group">
				<label>Add File</label>
				<input class="form-control" name="file" type="file" accept="image/*">
			</div>
<!--<button type="submit" class="btn btn-outline-warning">수정</button>--> 
			<button type="submit" class="btn btn-outline-warning">수정</button>  			
			<a class="btn btn-outline-danger" href="/delete">삭제</a>
	</form>
	
</body>
</html>
