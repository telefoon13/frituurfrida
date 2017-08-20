package be.vdab.enteties;

import java.util.ArrayList;
import java.util.List;

public class Saus {

	private long nummer;
	private String naam;
	private List<String> ingredienten;

	public Saus(long nummer, String naam, List<String> ingredienten) {
		this.nummer = nummer;
		this.naam = naam;
		this.ingredienten = ingredienten;
	}

	public Saus(long nummer, String naam) {
		this(nummer, naam, new ArrayList<>());
	}

	public long getNummer() {
		return nummer;
	}

	public void setNummer(long nummer) {
		this.nummer = nummer;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if(!isNaamValid(naam)){
			throw new IllegalArgumentException();
		} else {
			this.naam = naam;
		}
	}

	public List<String> getIngredienten() {
		return ingredienten;
	}

	public void setIngredienten(List<String> ingredienten) {
		this.ingredienten = ingredienten;
	}

	public static boolean isNaamValid(String naam) {
		return naam != null && !naam.isEmpty();
	}
}
