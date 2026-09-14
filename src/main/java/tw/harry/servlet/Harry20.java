package tw.harry.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.harry.api.Member;
import tw.harry.dao.MemberDao;

import java.io.IOException;

@WebServlet("/Harry20")
public class Harry20 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("password");
		
		MemberDao dao = new MemberDao();
		try {
			Member member = dao.login(account, passwd);
			if (member != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("member", member);
				
				int lottery = (int) (Math.random() * 49 + 1);
				session.setAttribute("lottery", lottery);
				
				int[] ary = {1, 2, 3, 4, 5};
				session.setAttribute("ary", ary);
				
				lottery = 1234;
				ary[2] = 3000;
				
				session.setMaxInactiveInterval(10);
				
				response.sendRedirect("Harry21");
//				response.getWriter().append("Success");
			} else {
				System.out.printf("NO member");
				response.sendRedirect("Harry20.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(500, e.toString());
		}
	}
}
