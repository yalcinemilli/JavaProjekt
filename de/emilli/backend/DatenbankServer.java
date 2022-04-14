package de.emilli.backend;

public enum DatenbankServer {
	

	VERBINDUNG("jdbc:mysql://192.168.2.92:3306/projekt1"),
	USER("yali"),
	PW("Emilli1987!");

	private String text;
	
	private DatenbankServer (String text) {
		this.text = text;
		
	}

	
	public String getText() {
		return this.text;
	}
}
