package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Access {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String uname = "root";
		String upass = "";
		
		private Connection conn;
		private Statement st;
		private PreparedStatement pst;
		private ResultSet rs;
		
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
}
