

// 새 채팅방 만들기 미완성임
/* 

const createRoom = function(roomName) {
	swal({
		text: "사용하실 닉네임을 입력해주세요",
		content: "input",
		buttons: ["취소", "확인"],
		closeOnClickOutside: false
	})
		.then(function(nickname) {
			if (nickname) {
				const data = {
					roomName: roomName,
					nickname: nickname
				};

				$.ajax({
					url: "/chattingRoom",
					type: "POST",
					data: data,
				})
					.then(function(room) {
						initRoom(room, nickname);
					})
					.fail(function() {
						alert("에러가 발생했습니다");
					});
			}
		});
};
 

$(".new_chat").click(function() {
	swal({
		text: "방 이름을 입력해주세요",
		content: "input",
		buttons: ["취소", "확인"],
		closeOnClickOutside: false
	})
		.then(function(roomName) {
			if (roomName) {
				createRoom(roomName);
			}
		});
});
*/


// 대화 중이던 방
	/* 
	const chattingRoom = function() {
		let returnRoom = null;

		$.ajax({
			url: "/chattingRoom",
			type: "GET",
			async: false,
		})
			.then(function(result) {
				if (result !== "") {
					const room = result.chattingRoom;
					const nickname = result.myNickname;
					initRoom(room, nickname);
					returnRoom = result;
				}
			})
			.fail(function(result) {
				errorMSG(result);
			});

		return returnRoom;
	};
	*/

	/*
		const room = chattingRoom();
				if (room) {
					return;
				}
		*/ 