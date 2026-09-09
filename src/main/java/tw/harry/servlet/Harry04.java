package tw.harry.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/Harry04")
public class Harry04 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");

		if (x != null && y != null) {
			int r = Integer.parseInt(x) + Integer.parseInt(y);
			PrintWriter out = response.getWriter();
			out.printf("%s + %s = %d", x, y, r);
		}
	}
}
