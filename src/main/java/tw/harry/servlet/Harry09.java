package tw.harry.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.UUID;

@WebServlet("/Harry09")
public class Harry09 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		response.setContentType("text/html; charset=UTF-8");
		
		ServletContext context = getServletContext();
		String upload = context.getRealPath("/upload");
		System.out.println(upload);
		
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		
	}

}
