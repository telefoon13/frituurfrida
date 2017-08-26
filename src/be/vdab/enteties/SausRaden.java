package be.vdab.enteties;

import java.io.Serializable;
import java.util.stream.IntStream;

public class SausRaden implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final int MAX_BEURTEN = 10;
	private final String saus;
	private final StringBuilder sausMetPuntje;
	private int verkeerdeBeurten;

	public SausRaden(String saus){
		this.saus = saus.toLowerCase();
		sausMetPuntje = new StringBuilder(saus.length());
		IntStream.rangeClosed(1,saus.length()).forEach(teller -> sausMetPuntje.append('.'));
	}

	public String getSaus() {
		return saus.toLowerCase();
	}

	public String getSausMetPuntje() {
		return sausMetPuntje.toString().toLowerCase();
	}

	public int getVerkeerdeBeurten() {
		return verkeerdeBeurten;
	}

	public void doeGok(char letter){
		int letterIndex = saus.indexOf(letter);
		if (letterIndex == -1){
			verkeerdeBeurten++;
		} else {
			do{
				sausMetPuntje.setCharAt(letterIndex,letter);
				letterIndex = saus.indexOf(letter,letterIndex+1);
			} while (letterIndex != -1);
		}
	}

	public boolean isGewonnen(){
		return sausMetPuntje.indexOf(".") == -1;
	}

	public boolean isVerloren(){
		return verkeerdeBeurten == MAX_BEURTEN;
	}
}
