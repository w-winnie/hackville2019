package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
//				st = conn.createStatement();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		//TODO: Add look up for language and diet
		
		public int validateLogin(String email, String password) {
			int userid = -1; 
			String sql = "select userid from user where email = ? and password = ?";
			try {
				prepareStatement = conn.prepareStatement(sql);
				prepareStatement.setString(1, email);
				prepareStatement.setString(2, password);
				ResultSet rs = prepareStatement.executeQuery();
				if(rs.next()) {
					userid = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return userid;		
		}
		public void insertUser(String firstName, String lastName, String gender, String age, String email, String password, String type, String skype, String phone, String streetNumber, String streetName, String city, String postalCode) {
			String sql = "insert into user(first_name, last_name, gender, age, email,password,type,skype_name,street_num,street_name,city,postal_code,phone)"
					+ "values (first_name = ?,last_name = ?,gender = ?,email = ?,  )";
		}
}
