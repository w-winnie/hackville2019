package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dal.DB_Access;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/Login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("userpassword");
		DB_Access db = new DB_Access();
		int uid = db.validateLogin(username, password);
		
		if(uid == -1) {
			// invalid login attempt
			response.sendRedirect("Login?msg=either name or pass or both are wrong");
		}
		else {
			// valid login attempt
			request.getSession().setAttribute("uid", uid);
			request.getSession().setAttribute("username", username);
			response.sendRedirect("Home");
		}
	}

}
