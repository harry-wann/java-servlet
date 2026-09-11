package tw.harry.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.harry.api.Food;
import tw.harry.dao.FoodDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/FoodMain")
public class FoodMain extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int page = 1;
		int rpp = 1;
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
			rpp = Integer.parseInt(request.getParameter("rpp"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 2. Model => Dao
		try {
			List<Food> foods = new FoodDao().queryByPage(page, 10);
			
			// 3. Viewer
			request.setAttribute("foods", foods);
			request.setAttribute("title", "Big Harry Company");
			request.setAttribute("page", page);
			request.setAttribute("prev", (page <= 1) ? 1 : page - 1);
			request.setAttribute("next", page + 1);
			request.getRequestDispatcher("FoodViewer").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
