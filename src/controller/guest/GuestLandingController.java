package controller.guest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DietRestrictionBean;
import beans.GuestBean;
import beans.LanguageBean;
import beans.UserBean;
import dal.DB_Access;

@WebServlet("/GuestLandingController")
public class GuestLandingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DB_Access db = new DB_Access();
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<DietRestrictionBean> dlist = db.getUserDiet(7);
		ArrayList<LanguageBean> llist = db.getUserLanguage(7);
		UserBean userBean = db.getUserInfo(7, dlist, llist);
		GuestBean guest = db.getGuestUserInfo(7, userBean);
		
		HttpSession sess = request.getSession();
		sess.setAttribute("guest", guest);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/GuestLanding.jsp");
		rd.forward(request, response);
		
		String action = (String) request.getParameter("actionn");
		if (action != null) {
			if (action.equals("CommitChange")) {
				db.editGuestUserInfo(7, "edited strrrr");
			}
		}
	}

}
