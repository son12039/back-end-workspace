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
	<h1>회원가입</h1>

	아이디 :
	<input type="text" id="id">
	<input type="button" value="중복체크" id="idCheck">
	<br><br><br><br><br>
	<div class="idCheckView"></div>
	<br><br><br><br><br>
	<div class="idCheckView"></div>
	<br><br><br><br><br>
	<div class="idCheckView"></div>

	<!-- 중복체크 버튼을 눌렀을 때 post 방식으로
		/check로 id 값 넘겨서 결과값은 boolean을 받아서
		아이디가 있으면 ID 사용 불가, 없으면 ID 사용 가능
		DB는 스키마 : member, 테이블 : member
	-->
	<style>
	@keyframes t {
					  0% {
					    transform: scaleY(0.3);
					    background-color: red;
					    background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWBJz3yXslUdTK_M6JhC_-cAnpp8muuh-AAYv4S-fyKA_wSH5a');
					background-position: center;
					  }
					  50% {
					    transform: scaleY(1.5);
					    background-color: green;
					     background-image: url('https://png.pngtree.com/thumb_back/fh260/background/20230609/pngtree-three-puppies-with-their-mouths-open-are-posing-for-a-photo-image_2902292.jpg');
					     background-position: center;
					  }
					  100% {
					    transform: scaleY(0.3);
					    background-color: blue;
					    background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWBJz3yXslUdTK_M6JhC_-cAnpp8muuh-AAYv4S-fyKA_wSH5a');
					  background-position: center;
					  }
					}
					.animate {
            animation: t 3s linear infinite;
        }
	</style>
	<script>			
	$("#idCheck").click(()=>{
		$.ajax({
			// 요청
			type: "post",
			url: "/check",
			data:"id="+ $("#id").val(),
			// 응답
			success: function(a) {
				let ida = a.id+"님 중복입니다";
				let tt = a?ida:"가입성공";
				let col= !a?"green":"purple";	
				let co = a?"orange":"white";
				let s = a? "100px" : "100px"
				 $(".idCheckView").text(tt).css({backgroundColor: col, color: co, 
		  fontSize: s}).addClass("animate");
				$(".idCheckView").hover(
                        function() {
                            // 마우스를 올렸을 때
                            $(this).css({ backgroundColor: "yellow", color: "black", backgroundImage: "url("+'https://cdn.imweb.me/upload/S201910012ff964777e0e3/62f9a36ea3cea.jpg'+")"});
                        },
                        function() {
                            // 마우스를 뗐을 때
                            $(this).css({ backgroundColor: col, color: co });
                        }
                    );
			}
		});
	});
	</script>
</body>
</html>