package de.emilli.backend;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * 
 * Kunden Klasse 
 * 
 * Die Klasse dient zum auslesen der Inhalte der Tabelle Kunden aus der Datenbank.
 * 
 *  Die Klasse erbt von der Elternklasse Datenbank und KundeDAO
 *  
 * @author yalcinemilli
 *
 */

public class Kunde extends Datenbank implements KundeDAO{

	private long kundenId;
	private String vorname;
	private String nachname;
	private LocalDate geburtsdatum;
	private String notizen;
	private String mitarbeiterId;
	private Timestamp lastChange;
	private int kundenTyp;
	private String bezugsPerson;
	private String kontakt;
	private int shop;
	private List<Vertrag> vertrag = new ArrayList<Vertrag>();
	
	
	public Kunde(long kundenId, String vorname, String nachname, LocalDate geburtsdatum, String notizen,
			String mitarbeiterId, Timestamp lastChange, int kundenTyp, String bezugsPerson, String kontakt, int shop,
			List<Vertrag> vertraege) {
		super();
		this.kundenId = kundenId;
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
		this.notizen = notizen;
		this.mitarbeiterId = mitarbeiterId;
		this.lastChange = lastChange;
		this.kundenTyp = kundenTyp;
		this.bezugsPerson = bezugsPerson;
		this.kontakt = kontakt;
		this.shop = shop;
		vertrag = vertraege;
	}
	
	public Kunde(long kundenId, String vorname, String nachname, LocalDate geburtsdatum, String notizen,
			String mitarbeiterId, Timestamp lastChange, int kundenTyp, String bezugsPerson, String kontakt, int shop) {
		super();
		this.kundenId = kundenId;
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
		this.notizen = notizen;
		this.mitarbeiterId = mitarbeiterId;
		this.lastChange = lastChange;
		this.kundenTyp = kundenTyp;
		this.bezugsPerson = bezugsPerson;
		this.kontakt = kontakt;
		this.shop = shop;
	}
	
	/**
	 * @return the kundenId
	 */
	public long getKundenId() {
		return kundenId;
	}
	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}
	/**
	 * @param nachname the nachname to set
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	/**
	 * @return the geburtsdatum
	 */
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}
	/**
	 * @param geburtsdatum the geburtsdatum to set
	 */
	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	/**
	 * @return the notizen
	 */
	public String getNotizen() {
		return notizen;
	}
	/**
	 * @param notizen the notizen to set
	 */
	public void setNotizen(String notizen) {
		this.notizen = notizen;
	}
	/**
	 * @return the mitarbeiterId
	 */
	public String getMitarbeiterId() {
		return mitarbeiterId;
	}
	/**
	 * @param mitarbeiterId the mitarbeiterId to set
	 */
	public void setMitarbeiterId(String mitarbeiterId) {
		this.mitarbeiterId = mitarbeiterId;
	}
	/**
	 * @return the lastChange
	 */
	public Timestamp getLastChange() {
		return lastChange;
	}

	/**
	 * @return the kundenTyp
	 */
	
	public StringProperty kundenTypProperty() {
		
		switch (kundenTyp) {
		case 1: {
			return new SimpleStringProperty(KundenTyp.PRIVATEKUNDE.getText());
		}
		case 2:
			return new SimpleStringProperty(KundenTyp.GESCHAEFTSKUNDE.getText());
			}
		return null;
	}
	public int getKundenTyp() {
		return kundenTyp;
	}
	/**
	 * @param kundenTyp the kundenTyp to set
	 */
	public void setKundenTyp(int kundenTyp) {
		this.kundenTyp = kundenTyp;
	}
	/**
	 * @return the bezugsPerson
	 */
	public String getBezugsPerson() {
		return bezugsPerson;
	}
	/**
	 * @param bezugsPerson the bezugsPerson to set
	 */
	public void setBezugsPerson(String bezugsPerson) {
		this.bezugsPerson = bezugsPerson;
	}
	/**
	 * @return the kontakt
	 */
	public String getKontakt() {
		return kontakt;
	}
	/**
	 * @param kontakt the kontakt to set
	 */
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	/**
	 * @return the shop
	 */
	public int getShop() {
		return shop;
	}
	/**
	 * @param shop the shop to set
	 */
	public void setShop(int shop) {
		this.shop = shop;
	}
	
	/**
	 * @param vertraege the vertraege to set
	 */
	public void setVertraege(List<Vertrag> vertraege) {
		vertrag = vertraege;
	}

	/**
	 * @return the vertraege
	 */
	public List<Vertrag> getVertraege() {
		return vertrag;
	}

	@Override
	public String toString() {
		return "Kunden [kundenId=" + kundenId + ", vorname=" + vorname + ", nachname=" + nachname + ", geburtsdatum="
				+ geburtsdatum + ", notizen=" + notizen + ", mitarbeiterId=" + mitarbeiterId + ", lastChange="
				+ lastChange + ", kundenTyp=" + kundenTyp + ", bezugsPerson=" + bezugsPerson + ", kontakt=" + kontakt
				+ ", shop=" + shop + ", Verträge Anzahl= " + + vertrag.size() + "]";
	}
	/**
	 * Die Methode wird von dem Interface KundenDAO geerbt und Überschrieben
	 * 
 	 * Aus mangeln an Zeit wird die Methode nicht verwendet
 	 * 
	 * Fügt ein neuen Datensatz in die Tabelle Kunden der Datenbank hinzu
	 * 
	 */
	@Override
	public void addKunde() throws SQLException {
		// TODO Auto-generated method stub#
		Connection con = null;
		con = DriverManager.getConnection(DatenbankServer.VERBINDUNG.getText(), DatenbankServer.USER.getText(), DatenbankServer.PW.getText());
		
		
		String einfacheEingabe = "INSERT INTO kunden VALUES (null, ?,?,?,?,33,null,null,1,33,?,1)";//? sind Platzhalter f�r Werte aus einem Objekt
		PreparedStatement prep = con.prepareStatement(einfacheEingabe);
		//F�llen der Platzhalter
		prep.setString(1, this.vorname); //1, Fragezeichen wird ersetzt
		prep.setString(2, this.nachname); 
		prep.setDate(3, Date.valueOf(this.geburtsdatum));
		prep.setString(4, this.notizen);
		prep.setString(5, this.kontakt);
		System.out.println(prep);
		prep.execute();
		prep.close();
		con.close();

		
	}

	/**
 	 * Die Methode wird von dem Interface KundenDAO geerbt und Überschrieben
	 * 
 	 * Aus mangeln an Zeit wird die Methode nicht verwendet
 	 * 
	 * Beiarbeitet ein Datensatz aus der Tabelle Kunden in der Datenbank
	 */
	@Override
	public void updateKunde() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		con = DriverManager.getConnection(DatenbankServer.VERBINDUNG.getText(), DatenbankServer.USER.getText(), DatenbankServer.PW.getText());
		
		
		String einfacheEingabe = "UPDATE kunden SET vorname = ?, nachname = ?, geburtsdatum = ?, notizen = ?, mitarbeiter_id = ?, kundentyp = ?, bperson = ?, kontakt = ?, shop = ? WHERE kunde_id = " + this.kundenId;//? sind Platzhalter f�r Werte aus einem Objekt
		PreparedStatement prep = con.prepareStatement(einfacheEingabe);
		prep.setString(1, this.vorname); //1, Fragezeichen wird ersetzt
		prep.setString(2, this.nachname); 
		prep.setDate(3, Date.valueOf(this.geburtsdatum));
		prep.setString(4, this.notizen);
		prep.setInt(5, Integer.parseInt(this.mitarbeiterId));
		prep.setInt(6, this.kundenTyp);
		prep.setInt(7, Integer.parseInt(this.bezugsPerson));
		prep.setString(8, this.kontakt);
		prep.setInt(9, this.shop);
		System.out.println(prep);
		prep.execute();
		prep.close();
		con.close();

	}

	/**
	 * Die Methode wird von dem Interface KundenDAO geerbt und Überschrieben
	 * 
 	 * Aus mangeln an Zeit wird die Methode nicht verwendet
 	 * 
	 * Löscht ein Datensatz aus der Tabelle kunden in der Datenbank
	 */
	@Override
	public void deleteKunde() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		con = DriverManager.getConnection(DatenbankServer.VERBINDUNG.getText(), DatenbankServer.USER.getText(), DatenbankServer.PW.getText());
		
		
		String einfacheEingabe = "DELETE FROM kunden WHERE kunde_id = " + this.kundenId;//? sind Platzhalter f�r Werte aus einem Objekt
		PreparedStatement prep = con.prepareStatement(einfacheEingabe);
		//F�llen der Platzhalter
		System.out.println(prep);
		prep.execute();
		prep.close();
		con.close();

	}
	
}
