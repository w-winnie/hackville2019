package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("home.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = (String) request.getParameter("actionvaal");
//		String nextpage = "home.html";
//		
//		if (action.equals("Login")) {
//			nextpage = "/LoginController";
//		}
////		if (action.equals("Register")) {
////			nextpage = "/RegisterController";
////		}
//		RequestDispatcher rd = request.getRequestDispatcher(nextpage);
//		rd.forward(request, response);
//		
		doGet(request,response);
	}

}
