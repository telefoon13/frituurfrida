package be.vdab.enteties;

import java.util.Date;

public class GastenboekEntry {

	private long id;
	private long posterid;
	private String poster;
	private String bericht;
	private Date plaatstijd;

	public GastenboekEntry(long id, long posterid,String poster, String bericht, Date plaatstijd) {
		this.id = id;
		this.posterid = posterid;
		this.poster = poster;
		this.bericht = bericht;
		this.plaatstijd = plaatstijd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPosterid() {
		return posterid;
	}

	public void setPosterid(long posterid) {
		this.posterid = posterid;
	}

	public String getBericht() {
		return bericht;
	}

	public void setBericht(String bericht) {
		this.bericht = bericht;
	}

	public Date getPlaatstijd() {
		return plaatstijd;
	}

	public void setPlaatstijd(Date plaatstijd) {
		this.plaatstijd = plaatstijd;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
}
