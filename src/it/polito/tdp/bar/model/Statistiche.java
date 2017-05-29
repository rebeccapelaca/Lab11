package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.List;

import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.EventType;

public class Statistiche {
	
	private List<Tavolo> tavoliModel = new ArrayList<Tavolo>();
	
	private int gruppiTot;
	private int gruppiSoddisfatti;
	private int gruppiInsoddisfatti;
	
	private PriorityQueue<Event> queue;
	
	public Statistiche(List<Tavolo> tavoli) {
		
		this.tavoliModel = tavoli;	
		this.gruppiTot = 0;
		this.gruppiSoddisfatti = 0;
		this.gruppiInsoddisfatti = 0;
		
		this.queue = new PriorityQueue<>();		
	}
	
	public void addClienti(int time, Gruppo group) {
		queue.add(new Event(EventType.ARRIVO_NUOVO_CLIENTE, group, time));
	}
	
	public void run() {
		
		while(!queue.isEmpty()) {
			
			Event e = queue.poll() ;
				
			switch(e.getType()) {
			
			case ARRIVO_NUOVO_CLIENTE:
				
				this.arrivoNuovoCliente(e);
				break ;
				
			case TAVOLO_LIBERATO:
				
				this.tavoloLiberato(e);
				break ;
			}
		}
	}
	
	private void arrivoNuovoCliente(Event e) {
		
		Gruppo group = e.getGroup();
		boolean tavoloTrovato = false;
		
		//for(Tavolo t : tavoliModel)
			//System.out.println(t + "\n");
		
		System.out.println("Entra gruppo : " + e.getGroup() + " TIME : " + e.getTime());
		
		for(Tavolo t : tavoliModel) {	
			if(!t.isOccupato() && t.getCapienza() >= group.getNumPersone() && group.getNumPersone() >= 0.5*t.getCapienza()) {
				tavoloTrovato = true;
				group.setTavolo(t);
				t.setOccupato(true);
				this.gruppiSoddisfatti++;
				queue.add(new Event(EventType.TAVOLO_LIBERATO, group, e.getTime() + group.getDurata()));
				System.out.println("TAVOLO TROVATO! Gruppo : " + group + "\n\n");
				break;
			}
			System.out.println(t + " TAVOLO SCARTATO!");
		}
		
		if(tavoloTrovato==false) {
			if(group.getTolleranza() >= (float)(0.0 + Math.random()*0.9)) {
				System.out.println("Il gruppo : " + group + ", al BANCONE! \n\n");
				this.gruppiSoddisfatti ++;
			}
			else {
			    System.out.println("Il gruppo : " + group + ", esce INSODDISFATTO! \n\n");
				this.gruppiInsoddisfatti ++;
			}
		}
		
		this.gruppiTot ++;
	}

	private void tavoloLiberato(Event e) {
		
		System.out.println("Esce il gruppo : " + e.getGroup());
		
		for(Tavolo t : tavoliModel) {
			if(t.equals(e.getGroup().getTavolo())) {
				t.setOccupato(false);	
				System.out.println("Liberato il tavolo : " + t + "\n\n");
				break;
			}
		}
	}

	public int getGruppiTot() {
		return gruppiTot;
	}

	public int getGruppiSoddisfatti() {
		return gruppiSoddisfatti;
	}

	public int getGruppiInsoddisfatti() {
		return gruppiInsoddisfatti;
	}
}
