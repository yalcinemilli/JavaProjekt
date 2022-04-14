package de.emilli.backend;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Baut die Verbindung zu der MySQL Datenbank auf und ließt die Daten aus der Datenbank.
 * @author yalcinemilli
 *
 */
public class Datenbank {
	


	private static List<Kunde> alleKunden = new ArrayList<Kunde>();

	/**
	 * Ließt alle Kunden ein.
	 * @return
	 */
	public static List<Kunde> getAllKunden() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DatenbankServer.VERBINDUNG.getText(), DatenbankServer.USER.getText(), DatenbankServer.PW.getText());

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM kunden");

			while (rs.next()) {
				long kundenId = rs.getLong("kunde_id");
				String vorname = rs.getString("vorname");
				String nachname = rs.getString("nachname");
				LocalDate geburtsdatum = rs.getDate("geburtsdatum").toLocalDate();
				String notizen  = rs.getString("notizen");
				int mitarbeiterId  = rs.getInt("mitarbeiter_id");
				Timestamp lastChange = rs.getTimestamp("last_change");
				int kundenTyp  = rs.getInt("kundentyp");
				int bezugsPerson  = rs.getInt("bperson");
				String kontakt   = rs.getString("kontakt");
				int shop   = rs.getInt("shop");
				List<Vertrag> Vertrag = getVertreage(kundenId);
				Kunde kunden = new Kunde(kundenId, vorname, nachname, geburtsdatum, notizen, getMitarbeiter(mitarbeiterId), lastChange, kundenTyp, getMitarbeiter(bezugsPerson), kontakt, shop, Vertrag);

				alleKunden.add(kunden);
			}

		} catch (SQLException datenbankAusnahme) {
			System.out.println("Danbank wechseln oder Dateispeicherung verwenden");
			System.err.println(datenbankAusnahme);

		} finally { // Wird ausgef�hrt, unabh�ngig davon, ob im try eine Exception geworfen wurde,
					// oder nicht
			if (conn != null) {
				try {
					conn.close();//Deklaration der close Methode: close() throws SQLEXception{
				} catch (SQLException schliessAusnahme) {
					System.out.println(schliessAusnahme);
				}
			}
		}
		return alleKunden;
	}
	
	/**
	 * Gibt alle Verträge des jeweiligen Kunden zurück
	 * @param kundenid
	 * @return
	 */
	public static List<Vertrag> getVertreage(long kundenid) {
		
		List<Vertrag> Vertraege = new ArrayList<Vertrag>();

		Connection conn = null;
		try {
			
			conn = DriverManager.getConnection(DatenbankServer.VERBINDUNG.getText(), DatenbankServer.USER.getText(), DatenbankServer.PW.getText());

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM vertraege WHERE kunden_id =" + kundenid);

			while (rs.next()) {
				long vertragId = rs.getLong("vertrag_id");
				String tarifTyp = rs.getString("tariftyp");
				String rufnummer = rs.getString("rufnummer");
				LocalDate vertragsEnde = rs.getDate("vertrags_ende").toLocalDate();
				String pkk  = rs.getString("pkk");
				String kundennummer  = rs.getString("kdn");
				String notiz  = rs.getString("notiz");
				int mitarbeiterId  = rs.getInt("mitarbeiter_id");
				Timestamp zeitstempel = rs.getTimestamp("zeitstempel");
				int kundenId  = rs.getInt("kunden_id");
				int bezugsPerson  = rs.getInt("bperson");
				int statusId   = rs.getInt("status_id");
				Vertrag vertrag = new Vertrag(vertragId, tarifTyp, rufnummer, pkk, kundennummer, notiz, zeitstempel, vertragsEnde, mitarbeiterId, kundenId, statusId, bezugsPerson);

				Vertraege.add(vertrag);
			}

		} catch (SQLException datenbankAusnahme) {
			System.out.println("Danbank wechseln oder Dateispeicherung verwenden");
			System.err.println(datenbankAusnahme);

		} finally { // Wird ausgef�hrt, unabh�ngig davon, ob im try eine Exception geworfen wurde,
					// oder nicht
			if (conn != null) {
				try {
					conn.close();//Deklaration der close Methode: close() throws SQLEXception{
				} catch (SQLException schliessAusnahme) {
					System.out.println(schliessAusnahme);
				}
			}
		}

		return Vertraege;
	}
	
	/**
	 * Gibt den Vor- und Nachnamen des Mitarbeiter zurück dessen ID als Parameter übergeben wurde
	 * @param mitarbeiterid
	 * @return
	 */
	
	public static String getMitarbeiter(int mitarbeiterid) {

		String vorname = "";
		String nachname = "";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DatenbankServer.VERBINDUNG.getText(), DatenbankServer.USER.getText(), DatenbankServer.PW.getText());

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT vorname, nachname FROM mitarbeiter WHERE userid = " + mitarbeiterid);

			if(rs.next()) {
				vorname = rs.getString("vorname");
				nachname = rs.getString("nachname");
			}
				
		} catch (SQLException datenbankAusnahme) {
			System.out.println("Danbank wechseln oder Dateispeicherung verwenden arbeiter");
			System.err.println(datenbankAusnahme);

		} finally { // Wird ausgef�hrt, unabh�ngig davon, ob im try eine Exception geworfen wurde,
					// oder nicht
			if (conn != null) {
				try {
					conn.close();//Deklaration der close Methode: close() throws SQLEXception{
				} catch (SQLException schliessAusnahme) {
					System.out.println(schliessAusnahme);
				}
			}
		}

		return vorname + " " + nachname;
	}

}
