package controller.host;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HostLandingController")
public class HostLandingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/HostLanding.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = (String) request.getParameter("actionvalll");
		String nextpage = "/WEB-INF/pages/HostLanding.jsp";
		if (action != null) {
			if (action.equals("View")) {
				nextpage = "/ViewProfileController";
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(nextpage);
		rd.forward(request, response);
	}

}
