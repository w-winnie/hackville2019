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
		// TODO: init() method
		ArrayList<DietRestrictionBean> dietRestrictionList = db.getDietRestrictions();
		System.out.println(dietRestrictionList.get(0).getRestriction_name());
		HttpSession sess = request.getSession();
		sess.setAttribute("alldiets", dietRestrictionList);

		ArrayList<LanguageBean> languageList = db.getLanguages();
		sess.setAttribute("alllanguages", languageList);

		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = (String) request.getParameter("actionval2");
		String nextpage = "register.jsp";
		if (action != null) {
			if (action.equals("Register")) {
				String firstName = request.getParameter("fname");
				String lastName = request.getParameter("lname");
				String gender = request.getParameter("gender");
				int age = Integer.parseInt((String) request.getParameter("age"));
				String email = request.getParameter("email");
				String password = request.getParameter("pass");
				
				String skype = request.getParameter("skype");
				String phone = request.getParameter("phone");
				int streetNumber = Integer.parseInt((String)request.getParameter("streetNumber"));
				String streetName =  request.getParameter("streetName");
				String city = request.getParameter("city");
				String postalCode = request.getParameter("postalCode");
				
				String[] diets = request.getParameterValues("dres");
				String[] langs = request.getParameterValues("language");
				
				String type = request.getParameter("type");
				
				if(type.equals("guest")) {
					String notes = request.getParameter("bio");
					db.insertGuest(db.getmaxuid(), notes);
				}
				
				db.insertUser(firstName, lastName, gender, age, email, password, 
						type, skype, phone, streetNumber, streetName, city, postalCode, 
						diets, langs);
				
				int uid = db.validateLogin(email, password);
				
				for (String lang : langs) {
					int langid = db.getBeanByLanguage(lang);
					db.insertUserLang(uid, langid);
				}
				
				for (String d : diets) {
					int dietid = db.getBeanByDres(d);
					System.out.println(dietid);
					db.insertUserDres(uid, dietid);
				}
			}
		}
		

		int userid = db.getmaxuid()- 1;
		
		if(db.isGuest(userid)) {
			nextpage = "/GuestLandingController";
		}
		else {
			nextpage = "/ViewProfileController";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(nextpage);
		rd.forward(request, response);
	}

}
