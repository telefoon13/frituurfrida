package be.vdab.enteties;

import java.util.Date;

public class User {

	private long id;
	private String gebruikersnaam;
	private String email;
	private String pass;
	private String laatsteIP;
	private Date laatsteLogin;

	public User(long id,String gebruikersnaam, String email, String pass, String laatsteIP, Date laatsteLogin) {
		this.id = id;
		setGebruikersnaam(gebruikersnaam);
		this.email = email;
		this.pass = pass;
		this.laatsteIP = laatsteIP;
		this.laatsteLogin = laatsteLogin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		if (gebruikersnaam != null && !gebruikersnaam.isEmpty()) {
			this.gebruikersnaam = gebruikersnaam;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getLaatsteIP() {
		return laatsteIP;
	}

	public void setLaatsteIP(String laatsteIP) {
		this.laatsteIP = laatsteIP;
	}

	public Date getLaatsteLogin() {
		return laatsteLogin;
	}

	public void setLaatsteLogin(Date laatsteLogin) {
		this.laatsteLogin = laatsteLogin;
	}
}
