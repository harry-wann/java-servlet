package tw.harry.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Harry24")
public class Harry24 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		int max = 49;
		try {
			max = Integer.valueOf(request.getParameter("max"));
		} catch (Exception e) {
			
		}
		
		if (max <= 0) {
			max = 49;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		int lottery = (int) (Math.random() * max + 1);
		out.append("" + lottery);
	}
}
