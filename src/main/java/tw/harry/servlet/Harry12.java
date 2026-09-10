package tw.harry.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.harry.api.Bike;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Harry12")
public class Harry12 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Harry13");
		
		request.setAttribute("z", "10");
		
		Bike b1 = new Bike();
		b1.upSpeed().upSpeed().upSpeed().upSpeed();
		
		request.setAttribute("bike", b1);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Big Harry Company</h1>");
		out.println("<hr />");
		dispatcher.include(request, response);
		out.println("<hr />");
		out.println("<div>Footer</div>");
	}
}
