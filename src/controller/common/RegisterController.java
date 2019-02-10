package controller.common;

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
import beans.LanguageBean;
import dal.DB_Access;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DB_Access db = new DB_Access();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO: init() method
		ArrayList<DietRestrictionBean> dietRestrictionList = db.getDietRestrictions();
		HttpSession sess = request.getSession();
		sess.setAttribute("alldiets", dietRestrictionList);
		
		ArrayList<LanguageBean> languageList = db.getLanguages();
		sess.setAttribute("alllanguages", languageList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/Register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String type = request.getParameter("type");
		String skype = request.getParameter("skype");
		String phone = request.getParameter("phone");
		String streetNumber = request.getParameter("streetNumber");
		int streetName = Integer.parseInt(request.getParameter("streetName"));
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		
		String[] dres = request.getParameterValues("dres");
		ArrayList<DietRestrictionBean> dietList= new ArrayList<DietRestrictionBean>();
		for(String d : dres) {
			dietList.add(db.getBeanByDres(d));
		}
		
		String[] lang = request.getParameterValues("lang");
		ArrayList<LanguageBean> langList = new ArrayList<LanguageBean>();
		for(String l : lang) {
			langList.add(db.getBeanByLanguage(l));
		}
		
		
		
		
		
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
