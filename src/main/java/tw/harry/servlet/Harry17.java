package tw.harry.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Harry17")
public class Harry17 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession seesion = request.getSession();
		
		int lottery = (int) (Math.random()*49 + 1);
		seesion.setAttribute("lottery", lottery);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.printf("Harry17 <hr />");
		out.printf("Lottery: %d <hr />", lottery);
		out.printf("<a href='Harry19'>Logout</a");
	}
}
