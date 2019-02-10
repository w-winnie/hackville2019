package beans;

public class LanguageBean {
	private int langid;
	private String language;
	
	public LanguageBean() {
		super();
	}
	public LanguageBean(int langid, String language) {
		this.langid = langid;
		this.language = language;
	}

	public int getLangid() {
		return langid;
	}
	public void setLangid(int langid) {
		this.langid = langid;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

}
