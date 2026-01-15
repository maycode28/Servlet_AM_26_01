<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>게시글 목록</title>
</head>
<body>
<a href="../home/main">메인으로 이동</a>
	<h1>게시글 목록</h1>

	<ul>

	<%
		for(int i = articleRows.size() - 1; i >= 0; i--){
	%>

		<li><a href="http://localhost:8080/Servlet_AM_26_01/article/detail?id=<%=articleRows.get(i).get("id")%>"><%=articleRows.get(i).get("id")%> 번, <%=articleRows.get(i).get("regDate")%>,
			<%=articleRows.get(i).get("title")%>, <%=articleRows.get(i).get("body")%></a></li>

	<%
		}
	%>
	</ul>
</body>
</html>