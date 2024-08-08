<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h2>Encoding 처리하기</h2>
	닉네임 :
	<input type="text" id="nick">
	<input type="button" value="닉네임 보내기" id="btn">
	<div id="result"></div>

	<!-- 자바 스크립트 방식 
	 get 방식으로 /encoding 닉네임보내서 : 요청 
		해당 닉네임 받아서 result에 보여주기 -->
	<!-- <script>
		let xhr;

		function startRequest() { // 요청에 해당하는 로직을 담는 메서드
			let a = document.querySelector("#nick").value;
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = callback;  
			xhr.open('get', '/encoding?nick=' + encodeURI(encodeURIComponent(a)));// form으로 보낼때 두가지
			xhr.send(null); // 이때 서버로 전송된다.. 실직적인 요청이 들어간다.
		}

		function callback() { // 응답에 해당하는 로직을 담는 메서드
			if (xhr.readyState === 4) {
				if (xhr.status === 200) {
					const nick = (xhr.responseText);
					document.querySelector("#result").innerHTML = decodeURI(decodeURIComponent(nick));
				}
			}
		}
	</script> -->
	<!-- jQuery -->
	<script>
		$("#btn").click(()=>{
			const nick = $("#nick").val();
			$.ajax({
				// 요청
				type: "get",
				url: "/encoding",
				data: "nick="+ encodeURI(encodeURIComponent(nick)),
				// 응답
				success: function(result) {
					$("#result").text(decodeURI(decodeURIComponent(result)));
				}
			});
		});
	</script>
</body>
</html>

















