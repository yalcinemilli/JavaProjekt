package de.emilli.backend;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.cell.PropertyValueFactory;

public enum KundenTyp {

	
	PRIVATEKUNDE("Privatekunde"),
	GESCHAEFTSKUNDE("Geschäftskunde");
	
	
	private String text;
	
	
	private KundenTyp (String text) {
		this.text = text;
	}
	

	public String getText() {
		return this.text;
	}


}
