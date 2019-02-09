package beans;

public class GuestBean {
	private int hostid;
	private String notes;
	private UserBean userBean;
	
	public GuestBean() {
		super();
	}
	
	public GuestBean(int hostid, String notes, UserBean userBean) {
		this.hostid = hostid;
		this.notes = notes;
		this.userBean = userBean;
	}

	public int getHostid() {
		return hostid;
	}
	public void setHostid(int hostid) {
		this.hostid = hostid;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	
}
