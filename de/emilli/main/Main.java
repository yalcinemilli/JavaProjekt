package de.emilli.main;

import de.emilli.backend.*;
import de.emilli.frontend.*;
import javafx.application.Application;
public class Main extends KundenTabelle{

	public static void main(String[] args) {

		/**
		 * Startet die GUI
		 */
		Application.launch(KundenTabelle.class, args);

		/**
		 * Gibt Alle Kunde in der Konsole aus
		 */
		Datenbank.getAllKunden().forEach(kunde->System.out.println(kunde.toString()));

		}

}
