package tw.harry.servlet;

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

@WebServlet("/Harry07")
@MultipartConfig(location = "C:\\Users\\User\\Desktop\\EEIT25\\JAVA\\HarryWeb\\src\\main\\webapp\\upload")
public class Harry07 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Part part = request.getPart("upload");
		String type = part.getContentType();
		String name = part.getName();
		long size = part.getSize();
		String fileName = part.getSubmittedFileName();
		System.out.printf("%s %s %d %s", type, name, size, fileName);
		part.write(fileName);
		
		response.setContentType("text/html; charset=UTF-8");
	}

}
