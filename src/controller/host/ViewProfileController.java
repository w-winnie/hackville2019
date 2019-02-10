package controller.host;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.GuestBean;
import dal.DB_Access;

@WebServlet("/ViewProfileController")
public class ViewProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/ViewProfile.jsp");
		DB_Access db = new DB_Access();
		HttpSession session = request.getSession();
		session.setAttribute("guests", db.getAllGuests());
		for(GuestBean gb: db.getAllGuests()) {
			System.out.println(gb.getHostid());
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
