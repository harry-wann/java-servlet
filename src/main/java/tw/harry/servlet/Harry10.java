package tw.harry.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.UUID;

import javax.imageio.ImageIO;

@WebServlet("/Harry10")
public class Harry10 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		double pr = Double.parseDouble(request.getParameter("pr"));
		
		BufferedImage img = new BufferedImage(800, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		
		g2d.setColor(Color.yellow);
		g2d.fillRect(0, 0, 800, 20);
		
		g2d.setColor(Color.red);
		g2d.fillRect(0, 0, (int) (800 * pr / 100), 20);
		
		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		
		File file = new File(getServletContext().getRealPath("/upload"), "harry.jpg");
		System.out.println(file.getPath());
		ImageIO.write(img, "JPEG", file);
		response.flushBuffer();
		
	}

}
