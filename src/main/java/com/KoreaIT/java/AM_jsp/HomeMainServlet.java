package com.KoreaIT.java.AM_jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/printDan")
public class HomeMainServlet extends HttpServlet {

  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset:UTF-8");
		String inputDan = request.getParameter("dan");
		String inputLimit =request.getParameter("limit");
		String inputColor=request.getParameter("color");
		if (inputDan==null) {
			inputDan="1";
		}
		if (inputLimit==null) {
			inputLimit="1";
		}

		int dan =Integer.parseInt(inputDan);
		int limit = Integer.parseInt(inputLimit);
		response.getWriter().append(String.format("<div style=\"color:%s;\">==%d단==<br>",inputColor,dan));

		for (int i=1; i<=limit;i++) {
			response.getWriter().append(String.format("%d * %d = %d<br>",dan,i,dan*i));
		}
		response.getWriter().append("</div>");
	}



}
