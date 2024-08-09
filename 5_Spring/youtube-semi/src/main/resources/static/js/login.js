let idSubmit = false;
let pwdSubmit = false;
id.addEventListener("input", function(e) {
	const regExp = /^[a-zA-Z][a-zA-Z0-9]{9,13}$/;
	$.ajax({
		type: 'post',
		url: '/check',
		data: {
			id: e.target.value
		},
		success: function(data) {
			if (data) {
				idCheck.innerHTML = "중복된 아이디입니다. 다시 입력해주세요"
				idCheck.style.color = "red";
				idSubmit = false;
			} else {
				if (regExp.test(e.target.value)) {
					idCheck.innerHTML = "OK!"
					idCheck.style.color = "green";
					idSubmit = true;
				} else if (e.target.value === "") {
					idCheck.innerHTML = ""
					idSubmit = false;
				}
				else {
					idCheck.innerHTML = "첫글자는 영어로, 영어 또는 숫자로만 10~14글자 입력"
					idCheck.style.color = "red";
					idSubmit = false;
				}
			}
		}
	});



});


password.addEventListener("input", function(e){
	const regExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).*$/;
	if(regExp.test(e.target.value)) {
		pwdCheck.innerHTML = "OK!";
		pwdCheck.style.color = "green";
		pwdSubmit = true;
	} else if(e.target.value === "") {
		pwdCheck.innerHTML = ""
	} 
	else {
		pwdCheck.innerHTML = "특수문자, 대문자, 소문자, 숫자 한 개 이상 무조건 포함되어야합니다";
		pwdCheck.style.color = "red";
		pwdSubmit = false;
	}
});

function validate() {
	if(!idSubmit) id.focus();
	else if(!pwdSubmit) password.focus();
	return idSubmit && pwdSubmit;
}














