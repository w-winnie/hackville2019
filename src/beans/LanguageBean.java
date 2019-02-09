package beans;
//CREATE TABLE lang(
//langid int unsigned not null auto_increment,
//language varchar(50) not null,
//primary key (langid)
//);
//
//CREATE TABLE userlang(
//userid int unsigned not null,
//langid int unsigned not null,
//foreign key(userid) references user(userid),
//foreign key(langid) references lang(langid),
//primary key (userid, langid)
//);
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
