package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dal.DB_Access;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/Login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		DB_Access db = new DB_Access();
		int userid = db.validateLogin(email, password);
		String nextpage = "/WEB-INF/pages/Login.jsp";
		
		if(userid == -1) {
			// invalid login attempt
			nextpage = "/WEB-INF/pages/Login.jsp";
		}
		else {
			// valid login attempt
			request.getSession().setAttribute("userid", userid);
			request.getSession().setAttribute("email", email);
			
			String action = (String) request.getParameter("actionvall");
			nextpage = "/WEB-INF/pages/Login.jsp";
			System.out.println("IIIIIIIII AAAAAAAMMMMMMMMM"+action);
			if (action!=null) {
				if(db.isGuest(userid)) {
					nextpage = "/GuestLandingController";
					System.out.println("IIIIIIIII AAAAAAAMMMMMMMMM"+db.isGuest(userid));
				}
				else {
					nextpage = "/HostLandingController";
				}
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(nextpage);
		rd.forward(request, response);
	}

}
