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

@WebServlet("/Harry13")
public class Harry13 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String z = (String) request.getAttribute("z");
		Bike b1 = (Bike) request.getAttribute("bike");
				
		PrintWriter out = response.getWriter();
		out.println("Harry13 <br/>");
		out.printf("x = %s; y = %s; z = %s", x, y, z);
		out.println("<hr />");
		out.print(b1);
	}
}
