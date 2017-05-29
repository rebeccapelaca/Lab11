package it.polito.tdp.bar.model;

public class Event implements Comparable<Event> {
	
	public enum EventType {ARRIVO_NUOVO_CLIENTE, TAVOLO_LIBERATO};
	
	private EventType type;
	private Gruppo group;
	private int time;
	
	public Event(EventType type, Gruppo group, int time) {
		super();
		this.type = type;
		this.time = time;
		this.group = group;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Gruppo getGroup() {
		return group;
	}

	public void setGroup(Gruppo group) {
		this.group = group;
	}

	@Override
	public int compareTo(Event other) {
		
		return this.time - other.time;
	}	
}