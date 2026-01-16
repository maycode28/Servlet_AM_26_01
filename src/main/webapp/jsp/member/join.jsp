<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<h1>회원 가입</h1>
<script type="text/javascript">
		function JoinForm__submit(form) {

			let loginId = form.loginId.value.trim();
			let loginPw = form.loginPw.value.trim();
			let loginPwConfirm = form.loginPwConfirm.value.trim();
			let name = form.name.value.trim();

			if (form.loginId.value.length == 0) {
				alert('아이디를 입력해주세요');
				form.loginId.focus();
				return;
			}
			if (loginPw.length == 0) {
				alert('비밀번호를 입력해주세요');
				form.loginPw.focus();
				return;
			}
			if (loginPwConfirm.length == 0) {
				alert('비밀번호 확인을 입력해주세요');
				form.loginPwConfirm.focus();
				return;
			}

			if (name.length == 0) {
				alert('이름을 입력해주세요');
				form.name.focus();
				return;
			}

			if (loginPw != loginPwConfirm) {
				alert('비밀번호가 비밀번호 확인과 일치하지 않습니다.');
				form.loginPw.focus();
				return;
			}

			form.submit();

		}
	</script>
<form onsubmit="JoinForm__submit(this); return false;" action="doJoin" method="post" >
		아이디 : <input autocomplete="off" type="text" name="loginId"><br>
		비밀번호 : <input autocomplete="off" type="text" name="loginPw"><br>
		비밀번호 확인 : <input autocomplete="off" type="text" name="loginPwConfirm"><br>
		이름 : <input autocomplete="off" type="text" name="name"><br>
		
		<input type="submit" value="가입하기"><br>
	</form>

</body>
</html>