package tw.harry.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.harry.api.HarryUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalcViewer")
public class CalcViewer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String x = (String) request.getAttribute("x");
		String y = (String) request.getAttribute("y");
		String result = (String) request.getAttribute("result");
		
		String webContent = "ERROR";
		PrintWriter out = response.getWriter();
		
		try {
			var view = (String) request.getAttribute("view");
			var source = String.format(
				"C:\\Users\\User\\Desktop\\EEIT25\\JAVA\\HarryWeb\\src\\main\\webapp\\views\\%s.html",
				view	
			);
			System.out.println("VIEW is " + view);
			webContent = HarryUtil.loadView(source)
				.replaceAll("#x", x)
				.replaceAll("#y", y)
				.replaceAll("#result", result);
			out.printf(webContent);
		} catch (Exception e) {
			out.print(e);
		}
	}

}
