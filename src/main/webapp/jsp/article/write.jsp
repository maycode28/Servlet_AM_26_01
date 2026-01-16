<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>


</head>
<body>
<h1>글 쓰기</h1>
<form action="doWrite" method="post">
		제목 : <input type="text" name="title" required><br>
		내용 : <textarea type="text" name="body" required></textarea><br>
		<input type="reset" value="다시입력">
		<input type="submit" value="제출"><br>
	</form>
</body>
</html>