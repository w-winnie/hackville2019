package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.DietRestrictionBean;
import beans.GuestBean;
import beans.LanguageBean;
import beans.UserBean;

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

	// TODO: Delete the methods and test by id in jsps
	public int getBeanByLanguage(String language) {
		int lid = 0;
		String sql = "select langid from lang where language=?";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, language);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				lid = rs.getInt("langid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lid;
	}

	public int getBeanByDres(String dres) {
		System.out.println(dres);
		int did = 0;
		String sql = "select drid from diet_restriction where restriction_name=?";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, dres);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				System.out.println("LOOOOOOP");
				did = rs.getInt("drid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return did;
	}

	public void insertUser(String firstName, String lastName, String gender, int age, String email, String password,
			String type, String skype, String phone, int streetNumber, String streetName, String city,
			String postalCode, String[] diets, String langs[]) {

		// insert into user table
		String sql = "insert into user(first_name, last_name, gender, age, email,"
				+ "password,type,skype_name,phone,street_num,street_name,city,postal_code)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			boolean result = prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertUserLang(int userid, int langid) {

		String sql2 = "INSERT INTO userlang(userid,langid) VALUES (?,?)";
		try {
			prepareStatement = conn.prepareStatement(sql2);
				prepareStatement.setInt(1, userid);
				prepareStatement.setInt(2, langid);
				boolean result = prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertUserDres(int userid, int dietid) {
		String sql3 = "INSERT INTO user_diet_restriction(userid,drid) VALUES (?,?)";
		try {
			prepareStatement = conn.prepareStatement(sql3);
				prepareStatement.setInt(1, userid);
				prepareStatement.setInt(2, dietid);
				boolean result = prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertGuest(int userid, String note) {
		String sql3 = "INSERT INTO guest(userid,note) VALUES (?,?)";
		try {
			prepareStatement = conn.prepareStatement(sql3);
				prepareStatement.setInt(1, userid);
				prepareStatement.setString(2, note);
				boolean result = prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//TODO: Improve algorithms to support join
	public ArrayList<DietRestrictionBean> getUserDiet(int userid) {
		String sql = "SELECT drid FROM user_diet_restriction WHERE userid="+userid;
		ArrayList<DietRestrictionBean> dlist = new ArrayList<DietRestrictionBean>();
		try {
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				int drid = resultSet.getInt("drid");
				String sql2 =  "SELECT restriction_name FROM diet_restriction WHERE drid="+drid;
				ResultSet resultSet2 = statement.executeQuery(sql2);
				DietRestrictionBean dbean = new DietRestrictionBean(drid, resultSet.getString("restriction_name"));
				dlist.add(dbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dlist;
	}
	
	public ArrayList<LanguageBean> getUserLanguage(int userid) {
		String sql = "SELECT langid FROM userlang WHERE userid="+userid;
		ArrayList<LanguageBean> llist = new ArrayList<LanguageBean>();
		try {
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				int langid = resultSet.getInt("langid");
				String sql2 =  "SELECT lang FROM lang WHERE langid="+langid;
				ResultSet resultSet2 = statement.executeQuery(sql2);
				LanguageBean lbean = new LanguageBean(langid, resultSet.getString("lang"));
				llist.add(lbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return llist;
	}
	
	public UserBean getUserInfo(int userid, ArrayList<DietRestrictionBean> dlist,ArrayList<LanguageBean> llist) {
		String sql = "SELECT * FROM user WHERE userid="+userid;
		UserBean userBean = null;
		try {
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
					 userBean = new UserBean(resultSet.getInt("userid"), 
							 resultSet.getString("first_name"), 
							 resultSet.getString("last_name"), 
							 resultSet.getString("gender"),
							 resultSet.getInt("age"), 
							 resultSet.getString("email"), 
							 resultSet.getString("password"), 
							 resultSet.getString("type"), 
							 resultSet.getString("skype_name"), 
							 resultSet.getInt("street_num"),
							 resultSet.getString("street_name"),
							 resultSet.getString("city"), 
							 resultSet.getString("postal_code"), 
							 resultSet.getString("phone"), dlist, llist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userBean;
		
	}
	
	public GuestBean getGuestUserInfo(int userid, UserBean userBean) {
		String sql = "SELECT * FROM guest WHERE hostid="+userid;
		GuestBean guestBean = new GuestBean();
		try {
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				guestBean.setHostid(resultSet.getInt("hostid"));
				guestBean.setNotes(resultSet.getString("notes"));
				guestBean.setUserBean(userBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return guestBean;		
	}
	
	public void editGuestUserInfo(int userid, String editString) {
		String sql = "UPDATE guest SET notes= '"+editString+"' WHERE hostid="+userid;
		GuestBean guestBean = new GuestBean();
		try {
			  statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getDiet(int userid) {
        String query = "SELECT drid FROM user_diet_restriction WHERE userid = ?";
        String query2 = "SELECT restriction_name FROM diet_restriction WHERE drid = ?";
        ArrayList<Integer> arrDrid = new ArrayList<>();
        ArrayList<String> dietRestriction = new ArrayList<>();

        try {
            prepareStatement = conn.prepareStatement(query);
            prepareStatement.setInt(1, userid);
            ResultSet rs = prepareStatement.executeQuery();

            while(rs.next()) {
                arrDrid.add(rs.getInt("drid"));
            }


            prepareStatement = conn.prepareStatement(query2);
            for(int drid : arrDrid) {
                prepareStatement.setInt(1, drid);
                ResultSet rs2 = prepareStatement.executeQuery();
                if(rs2.next()) {
                    dietRestriction.add(rs2.getString("restriction_name"));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return dietRestriction;
    }
	
	
	public ArrayList<LanguageBean> getLang(int userid) {
        String query = "SELECT langid FROM userlang WHERE userid = ?";
        String query2 = "SELECT language FROM lang WHERE langid = ?";
        ArrayList<Integer> arrLangId = new ArrayList<>();
        ArrayList<String> languages = new ArrayList<>();
        ArrayList<LanguageBean> lb = new ArrayList<>();

        try {
            prepareStatement = conn.prepareStatement(query);
            prepareStatement.setInt(1, userid);
            ResultSet rs = prepareStatement.executeQuery();

            while(rs.next()) {
                arrLangId.add(rs.getInt("drid"));
            }


            prepareStatement = conn.prepareStatement(query2);
            for(int langId : arrLangId) {
                prepareStatement.setInt(1, langId);
                ResultSet rs2 = prepareStatement.executeQuery();
                if(rs2.next()) {
                    lb.add(new LanguageBean(langId, rs2.getString("language")) );
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return lb;
    }
	
	public ArrayList<GuestBean> getAllGuests() {
        String query = "SELECT * FROM user join guest on userid = hostid";
        ArrayList<GuestBean> guests = new ArrayList<>();
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);

            if(rs.next()) {
                //GuestBean gb = new GuestBean(rs.getInt("hostid"),rs.getString("notes"),new UserBean(rs.getString("userid"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("gender"),rs.getInt("age"),rs.getString("email"),rs.getString("password"),
            	//rs.getString("type"),rs.getString("skype_name"),rs.getString("street_num"),rs.getString("street_name"),rs.getString("city"),
            	//rs.getString("postal_code"),rs.getString("phone"),getLang(rs.getString("userid")),getDiet(rs.getString("userid"))));
                GuestBean gb = new GuestBean();
                gb.setHostid(rs.getInt("hostid"));
                gb.setNotes(rs.getString("notes"));
                UserBean ub = new UserBean();
                ub.setUserid(rs.getInt("userid"));
                ub.setFirst_name(rs.getString("first_name"));
                ub.setLast_name(rs.getString("last_name"));
                ub.setGender(rs.getString("gender"));
                ub.setAge(rs.getInt("age"));
                ub.setEmail(rs.getString("email"));
                ub.setPassword(rs.getString("password"));
                ub.setType(rs.getString("type"));
                ub.setSkype_name(rs.getString("skype_name"));
                ub.setStreet_name(rs.getString("street_name"));
                ub.setStreet_num(rs.getInt("street_num"));
                ub.setCity(rs.getString("city"));
                ub.setPostal_code(rs.getString("postal_code"));
                ub.setPhone(rs.getString("phone"));
                ub.setLanguageBeanList(getLang(rs.getInt("userid")));
                ub.setDietRestrictionList(getUserDiet(rs.getInt("userid")));
                gb.setUserBean(ub);
                guests.add(gb);
                System.out.println("HELLO");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guests;
    }
	
	public boolean isGuest(int userid) {
		String sql = "select type from user where userid = ?";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setInt(1, userid);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				String type = rs.getString(1);
				if(type.equalsIgnoreCase("guest")) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int getmaxuid() {
		int result = 0;
		String sql = "select MAX(userid) from user";
		try {
			prepareStatement = conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				String type = rs.getString(1);
				if(type.equalsIgnoreCase("guest")) {
					result = rs.getInt(1)+1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
