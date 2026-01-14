<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");
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
	if(articleRows.isEmpty()){
	%>
	<div><%=id%>번 게시글은 존재하지 않습니다.</div>
	<%
	}else{
	%>
	<div><%=articleRows.get(0).get("id")%>번 게시글</div>
	<div>작성일 : <%=articleRows.get(0).get("regDate")%></div>
	<div>제목 : <%=articleRows.get(0).get("title")%></div>
	<div>내용 : <%=articleRows.get(0).get("body")%></div>
	<%
		}
	%>
</body>
</html>