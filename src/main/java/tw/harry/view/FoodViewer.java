package tw.harry.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.harry.api.Food;
import tw.harry.api.HarryUtil;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@WebServlet("/FoodViewer")
public class FoodViewer extends HttpServlet {
	
	private static final String TEMPLAT_PATH = "/WEB-INF/views/view1.html";
	
	private String template = "";
	
	@Override
	public void init() throws ServletException {
		// read template
		try {
			template = readTemplate(TEMPLAT_PATH);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Load Template Failed.");
		}
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String title = (String) request.getAttribute("title");
		
		List<Food> foods = (List<Food>) request.getAttribute("foods");
		if (foods == null) foods = Collections.emptyList();
		
		Integer page = (Integer) request.getAttribute("page");
		String spage = (page != null) ? page.toString() : "1";
		
		Integer prev = (Integer) request.getAttribute("prev");
		String sprev = prev.toString();
		
		Integer next = (Integer) request.getAttribute("next");
		String snext = next.toString();
		
		String html = template
			.replace("{{TITLE}}", title)
			.replace("{{TABLE}}", bindTable(foods))
			.replace("{{PAGE}}", spage)
			.replace("{{PREV}}", sprev)
			.replace("{{NEXT}}", snext);
		
		response.getWriter().append(html);
	}
	
	private String readTemplate(String file) throws Exception {
		try (InputStream in = getServletContext().getResourceAsStream(file)) {
			if (in == null) throw new IOException("Templat File NOT FOUND");
			
			try (BufferedInputStream bin = new BufferedInputStream(in)) {
				return new String(bin.readAllBytes(), StandardCharsets.UTF_8);
			}
		}
	}
	
	private String bindTable(List<Food> foods) {
		StringBuilder sb = new StringBuilder();
		sb.append("<table width='100%' border='1'")
			.append("<caption>伴手禮列表</caption>")
			.append("<thead><tr>")
			.append("<th>編號</th>").append("<th>名稱</th>").append("<th>電話</th>").append("<th>地址</th>").append("<th>圖片</th>")
			.append("</tr></thead>")
			.append("<tbody>");
		
		if (foods.size() != 0) {
			for (Food food : foods) {
				sb.append("<tr>")
					.append("<td>").append(food.getId()).append("</td>")
					.append("<td>").append(food.getName()).append("</td>")
					.append("<td>").append(food.getTel()).append("</td>")
					.append("<td>").append(food.getCity() + food.getTown() + food.getTel()).append("</td>")
					.append("<td><img src='").append(food.getPicurl()).append("' width='160px' height='90px'>")
					.append("</tr>");
			}
		} else {
			sb.append("<tr><td colspan='5'>沒資料</td></tr>");
		}
		
		sb.append("</tbody></table>");
		return sb.toString();
	}
}
