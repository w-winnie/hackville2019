package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.DietRestrictionBean;
import beans.LanguageBean;

public class DB_Access {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://34.73.62.4:3306/hackville2019";
	String uname = "root";
	String upass = "hackville2019";

	private Connection conn;
	private Statement statement;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;

	public DB_Access() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, upass);
			statement = conn.createStatement();
//				st = conn.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// TODO: Add look up for language and diet

	public int validateLogin(String email, String password) {
		int userid = -1;
		String sql = "select userid from user where email = ? and password = ?";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				userid = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userid;
	}

	public ArrayList<DietRestrictionBean> getDietRestrictions() {
		ArrayList<DietRestrictionBean> dietRestrictionList = new ArrayList<DietRestrictionBean>();
		try {
			resultSet = statement.executeQuery("select * from  diet_restriction");
			while (resultSet.next()) {
				DietRestrictionBean dbean = new DietRestrictionBean(resultSet.getInt("drid"),
						resultSet.getString("restriction_name"));
				dietRestrictionList.add(dbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dietRestrictionList;
	}

	public ArrayList<LanguageBean> getLanguages() {
		ArrayList<LanguageBean> languageList = new ArrayList<LanguageBean>();
		try {
			resultSet = statement.executeQuery("select * from  lang");
			while (resultSet.next()) {
				LanguageBean lbean = new LanguageBean(resultSet.getInt("langid"), resultSet.getString("language"));
				languageList.add(lbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return languageList;
	}

	public LanguageBean getBeanByLanguage(String language) {
		LanguageBean lbean = null;
		String sql = "select * from lang where language=?";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, language);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				lbean = new LanguageBean(resultSet.getInt("langid"), resultSet.getString("language"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lbean;
	}

	public DietRestrictionBean getBeanByDres(String dres) {
		DietRestrictionBean dbean = null;
		String sql = "select * from diet_restriction where restriction_name=?";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, dres);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				dbean = new DietRestrictionBean(resultSet.getInt("drid"), resultSet.getString("restriction_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbean;
	}

	public void insertUser(String firstName, String lastName, String gender, int age, String email, String password,
			String type, String skype, String phone, int streetNumber, String streetName, String city,
			String postalCode, String[] diets, String langs[]) {
		
		//insert into user table
		String sql = "insert into user(first_name, last_name, gender, age, email,password,type,skype_name,street_num,street_name,city,postal_code,phone)"
				+ "values (first_name = ?,last_name = ?,gender = ?,age = ?,email = ?,password = ?,type = ?,skype_name = ?,street_num = ?,street_name = ?,city = ?,postal_code = ?,phone = ?)";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, firstName);
			prepareStatement.setString(2, lastName);
			prepareStatement.setString(3, gender);
			prepareStatement.setInt(4, age);
			prepareStatement.setString(5, email);
			prepareStatement.setString(6, password);
			prepareStatement.setString(7, type);
			prepareStatement.setString(8, skype);
			prepareStatement.setString(9, phone);
			prepareStatement.setInt(10, streetNumber);
			prepareStatement.setString(11, streetName);
			prepareStatement.setString(12, city);
			prepareStatement.setString(13, postalCode);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//insert into user lang table
		int userid = validateLogin(email, password); // TODO: default is -1, check for it
		int langid;
		String sql2 = "INSERT INTO userlang VALUES userid = ?, langid = ?";
		try {
			prepareStatement = conn.prepareStatement(sql2);
			for (String lang : langs) {
				prepareStatement.setInt(1, userid);
				langid = getBeanByLanguage(lang).getLangid();
				prepareStatement.setInt(2, langid);
				prepareStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//insert into user- diet table
		int dietid;
		String sql3 = "INSERT INTO user_diet_restriction VALUES userid = ?, drid = ?";
		try {
			prepareStatement = conn.prepareStatement(sql3);
			for (String d : diets) {
				prepareStatement.setInt(1, userid);
				dietid = getBeanByDres(d).getDrid();
				prepareStatement.setInt(2, dietid);
				prepareStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
}
