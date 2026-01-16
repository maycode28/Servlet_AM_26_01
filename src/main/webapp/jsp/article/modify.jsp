<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>


</head>
<body>
<h1><%=articleRow.get("id")%>번 글 수정</h1>
<form action="doModify" method="post">
		<input type="hidden" name="id" value="<%=articleRow.get("id")%>">
		제목 : <input type="text" name="title" value="<%=articleRow.get("title")%>" required><br>
		내용 : <textarea type="text" name="body" required><%=articleRow.get("body")%></textarea><br>
		<input type="reset" value="다시입력">
		<input type="submit" value="제출"><br>
	</form>
</body>
</html>