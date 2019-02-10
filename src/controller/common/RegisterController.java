package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/Register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String type = request.getParameter("type");
		String skype = request.getParameter("skype");
		String phone = request.getParameter("phone");
		String streetNumber = request.getParameter("streetNumber");
		String streetName = request.getParameter("streetName");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		
		
		
		String action = (String) request.getParameter("actionval2");
		String nextpage = "/WEB-INF/pages/Register.jsp";
		if (action != null) {
			if (action.equals("Register")) {
				nextpage = "/GuestLandingController";
			}
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher(nextpage);
		rd.forward(request, response);
	}

}
