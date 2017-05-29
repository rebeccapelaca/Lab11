package it.polito.tdp.bar.model;

public class Gruppo {
	
	private int numPersone;
	private int durata;
	private float tolleranza;
	private Tavolo tavolo;
	
	public Gruppo(int numPersone, int durata, float tolleranza) {
		super();
		this.numPersone = numPersone;
		this.durata = durata;
		this.tolleranza = tolleranza;
	}

	public int getNumPersone() {
		return numPersone;
	}

	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	@Override
	public String toString() {
		return numPersone + " persone, " + durata + " min (permanenza), " + tolleranza + " (tolleranza), tavolo assegnato : " + tavolo;
	}
}
