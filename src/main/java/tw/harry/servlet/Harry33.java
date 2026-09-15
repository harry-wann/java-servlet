package tw.harry.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/Harry33")
public class Harry33 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		if (name == null || name.isEmpty()) {
			name = "visitor";
		}
		
		String title = "Hello";
		
		request.setAttribute("title", title);
		request.setAttribute("name", name);
		request.setAttribute("time", LocalDateTime.now());
	
		request.getRequestDispatcher("/WEB-INF/views/Harry33.jsp")
			.forward(request, response);	
	}
}
