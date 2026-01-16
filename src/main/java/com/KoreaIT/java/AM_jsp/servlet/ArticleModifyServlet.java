package com.KoreaIT.java.AM_jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/modify")
public class ArticleModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		String inputId=request.getParameter("id");
		if(inputId==null) {
			response.getWriter().append("id 정보 누락");
			return;
		}
		int id = Integer.parseInt(inputId);


		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 없음");
			e.printStackTrace();
		}

		String url = "jdbc:mysql://127.0.0.1:3306/Servlet_AM_26_01?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "1234";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			response.getWriter().append("연결 성공");
			
			SecSql sql = SecSql.from("SELECT COUNT(*)");
			sql.append("FROM article");
			sql.append("where id = ?;",id);
			int articleCount = DBUtil.selectRowIntValue(conn, sql);
			if (articleCount==0) {
				response.getWriter().append(String.format("<script>alert(%d+'번 글은 존재하지 않음'); location.replace('list');</script>",id));
			}else if(articleCount==1){
				sql = new SecSql();
				sql.append("SELECT * FROM article where id=?;",id);

				Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);

				request.setAttribute("articleRow", articleRow);
				
				request.getRequestDispatcher("/jsp/article/modify.jsp").forward(request, response);
			}
			
            

		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}