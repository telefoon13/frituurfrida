package be.vdab.enteties;

public class Gemeente {

	private String naam;
	private int postCode;

	public Gemeente(String naam, int postCode) {
		setNaam(naam);
		setPostCode(postCode);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

}
