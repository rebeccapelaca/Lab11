package it.polito.tdp.bar.model;

public class Tavolo implements Comparable<Tavolo>{
	
	private int id;
	private int capienza;
	private boolean occupato;

	public Tavolo(int id, int capienza) {
		super();
		this.capienza = capienza;
		this.occupato = false;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public String toString() {
		return "Tavolo " + id + ", capienza " + capienza + " persone, occupato = " + occupato;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Tavolo altro) {
		
		if(this.capienza!=altro.getCapienza())
			return this.capienza-altro.getCapienza();
		return this.id-altro.getId();
	}
}
