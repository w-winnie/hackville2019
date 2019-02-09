package beans;

public class DietRestrictionBean {
	private int drid;
	private String restriction_name;
	
	public DietRestrictionBean() {
		super();
	}
	
	public DietRestrictionBean(int drid, String restriction_name) {
		this.drid = drid;
		this.restriction_name = restriction_name;
	}

	public int getDrid() {
		return drid;
	}
	public void setDrid(int drid) {
		this.drid = drid;
	}
	public String getRestriction_name() {
		return restriction_name;
	}
	public void setRestriction_name(String restriction_name) {
		this.restriction_name = restriction_name;
	}
	
}
