package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		int time = 0;		
		List<Tavolo> tavoli = new ArrayList<Tavolo>();
	
		for(int i = 1; i <= 5; i++)
			tavoli.add(new Tavolo(i,4));
		for(int i = 6; i <= 9; i++)
			tavoli.add(new Tavolo(i,6));
		for(int i = 10; i <= 13; i++)
			tavoli.add(new Tavolo(i,8));
		for(int i = 14; i <= 15; i++)
			tavoli.add(new Tavolo(i,10));		
		
		Collections.sort(tavoli);
		
		//for(Tavolo t : tavoli)
			//System.out.println(t + "\n");
		
		Statistiche statistiche = new Statistiche(tavoli);
		
		for(int i = 0; i < 2000; i++) {
			time += (int)(1+Math.random()*10);
			statistiche.addClienti(time, new Gruppo((int)(1+Math.random()*10),(int)(60+Math.random()*60),(float)(0.0+Math.random()*0.9)));
		}
		
		statistiche.run();
		
		System.out.format("Gruppi totali arrivati: %d\n", statistiche.getGruppiTot()) ;
		System.out.format("Gruppi soddisfatti  : %d\n", statistiche.getGruppiSoddisfatti());
		System.out.format("Gruppi insoddisfatti  : %d\n", statistiche.getGruppiInsoddisfatti());		
	}
}
