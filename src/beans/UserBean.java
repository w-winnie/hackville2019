package beans;

import java.util.ArrayList;

public class UserBean {
	private int userid;
	private String first_name;
	private String last_name;
	private String gender;
	private int age;
	private String email;
	private String password; //TODO:Add encoding
	private String type;
	private String skype_name; 
	private int street_num;
	private String street_name;
	private String city;
	private String postal_code;
	private String phone;
	
	private ArrayList<DietRestrictionBean> dietRestrictionList;
	private ArrayList<LanguageBean> languageBeanList;
	
	
	public ArrayList<DietRestrictionBean> getDietRestrictionList() {
		return dietRestrictionList;
	}
	public void setDietRestrictionList(ArrayList<DietRestrictionBean> dietRestrictionList) {
		this.dietRestrictionList = dietRestrictionList;
	}
	public ArrayList<LanguageBean> getLanguageBeanList() {
		return languageBeanList;
	}
	public void setLanguageBeanList(ArrayList<LanguageBean> languageBeanList) {
		this.languageBeanList = languageBeanList;
	}
	public UserBean() {
		super();
	}
	public UserBean(int userid, String first_name, String last_name, String gender, int age, String email,
			String password, String type, String skype_name, int street_num, String street_name, String city,
			String postal_code, String phone, ArrayList<DietRestrictionBean> dietRestrictionList,
			ArrayList<LanguageBean> languageBeanList) {
		super();
		this.userid = userid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.password = password;
		this.type = type;
		this.skype_name = skype_name;
		this.street_num = street_num;
		this.street_name = street_name;
		this.city = city;
		this.postal_code = postal_code;
		this.phone = phone;
		this.dietRestrictionList = dietRestrictionList;
		this.languageBeanList = languageBeanList;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSkype_name() {
		return skype_name;
	}
	public void setSkype_name(String skype_name) {
		this.skype_name = skype_name;
	}
	public int getStreet_num() {
		return street_num;
	}
	public void setStreet_num(int street_num) {
		this.street_num = street_num;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	
}
