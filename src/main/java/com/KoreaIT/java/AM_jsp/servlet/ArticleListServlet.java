package com.KoreaIT.java.AM_jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/list")
public class ArticleListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		System.out.println(123);

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
			
			int cPage = 1;
			String inputCPage= request.getParameter("cPage");
			if(inputCPage!=null) {
				cPage =Integer.parseInt(inputCPage);
			}
			SecSql sql = SecSql.from("SELECT COUNT(*)");
			sql.append("FROM article;");
			int articleCount = DBUtil.selectRowIntValue(conn, sql);
			int articlePerPage = 10;
			int limitFrom = articlePerPage*(cPage-1);
			int pageCount=(int)Math.ceil(articleCount/(double)articlePerPage);
			
			
			sql = SecSql.from("SELECT a.id, a.regDate, a.updateDate, m.name, a.title, a.body");
			sql.append("FROM article a");
			sql.append("inner join `member` m");
			sql.append("on a.memberId = m.id");
			sql.append("order by a.id desc");
			sql.append("LIMIT ?, ?;", limitFrom, articlePerPage);
			

			List<Map<String, Object>> articleRows = DBUtil.selectRows(conn, sql);
			
			
			request.setAttribute("cPage", cPage);
			request.setAttribute("articleCount", articleCount);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("articleRows", articleRows);
			request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);

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