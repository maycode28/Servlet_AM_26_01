<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
int id = Integer.parseInt(request.getParameter("id"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=id%>번 게시글 상세</title>
</head>
<body>
	<h1><%=id%>번 게시글 상세</h1>
	<%
	if(articleRow.isEmpty()){
	%>
	<div><%=id%>번 게시글은 존재하지 않습니다.</div>
	<%
	}else{
	%>
	<div><%=articleRow.get("id")%>번 게시글</div>
	<div>작성일 : <%=articleRow.get("regDate")%></div>
	<div>제목 : <%=articleRow.get("title")%></div>
	<div>내용 : <%=articleRow.get("body")%></div>
	<%
		}
	%>
	<div><a href="list" style="color:green">리스트로 돌아가기</a></div>
</body>
</html>