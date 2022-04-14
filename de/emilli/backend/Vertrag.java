package de.emilli.backend;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Vertrag Klasse
 *  * 
 * Die Klasse dient zum auslesen der Inhalte der Tabelle vertraege aus der Datenbank.
 * 
 *  Die Klasse erbt von der Elternklasse Datenbank und VertragDAO
 */
public class Vertrag extends Datenbank implements VertragDAO {

	private long vertragId;
	private String tarifTyp;
	private String rufnummer;
	private String pkk;
	private String kundennummer;
	private String notiz;
	private Timestamp zeitstempel;
	private LocalDate vertragsEnde;
	private int mitarbeiterId;
	private int kundenId;
	private int statusId;
	private int bezugsPerson;
	
	
	public Vertrag(long vertragId, String tarifTyp, String rufnummer, String pkk, String kundennummer, String notiz,
			Timestamp zeitstempel, LocalDate vertragsEnde, int mitarbeiterId, int kundenId, int statusId,
			int bezugsPerson) {
		super();
		this.vertragId = vertragId;
		this.tarifTyp = tarifTyp;
		this.rufnummer = rufnummer;
		this.pkk = pkk;
		this.kundennummer = kundennummer;
		this.notiz = notiz;
		this.zeitstempel = zeitstempel;
		this.vertragsEnde = vertragsEnde;
		this.mitarbeiterId = mitarbeiterId;
		this.kundenId = kundenId;
		this.statusId = statusId;
		this.bezugsPerson = bezugsPerson;
	}

	/**
	 * @return the vertragId
	 */
	public long getVertragId() {
		return vertragId;
	}

	/**
	 * @return the tarifTyp
	 */
	public String getTarifTyp() {
		return tarifTyp;
	}
	/**
	 * @param tarifTyp the tarifTyp to set
	 */
	public void setTarifTyp(String tarifTyp) {
		this.tarifTyp = tarifTyp;
	}
	/**
	 * @return the rufnummer
	 */
	public String getRufnummer() {
		return rufnummer;
	}
	/**
	 * @param rufnummer the rufnummer to set
	 */
	public void setRufnummer(String rufnummer) {
		this.rufnummer = rufnummer;
	}
	/**
	 * @return the pkk
	 */
	public String getPkk() {
		return pkk;
	}
	/**
	 * @param pkk the pkk to set
	 */
	public void setPkk(String pkk) {
		this.pkk = pkk;
	}
	/**
	 * @return the kundennummer
	 */
	public String getKundennummer() {
		return kundennummer;
	}
	/**
	 * @param kundennummer the kundennummer to set
	 */
	public void setKundennummer(String kundennummer) {
		this.kundennummer = kundennummer;
	}
	/**
	 * @return the notiz
	 */
	public String getNotiz() {
		return notiz;
	}
	/**
	 * @param notiz the notiz to set
	 */
	public void setNotiz(String notiz) {
		this.notiz = notiz;
	}
	/**
	 * @return the zeitstempel
	 */
	public Timestamp getZeitstempel() {
		return zeitstempel;
	}
	/**
	 * @param zeitstempel the zeitstempel to set
	 */
	public void setZeitstempel(Timestamp zeitstempel) {
		this.zeitstempel = zeitstempel;
	}
	/**
	 * @return the vertragsEnde
	 */
	public LocalDate getVertragsEnde() {
		return vertragsEnde;
	}
	/**
	 * @param vertragsEnde the vertragsEnde to set
	 */
	public void setVertragsEnde(LocalDate vertragsEnde) {
		this.vertragsEnde = vertragsEnde;
	}
	/**
	 * @return the mitarbeiterId
	 */
	public int getMitarbeiterId() {
		return mitarbeiterId;
	}
	/**
	 * @param mitarbeiterId the mitarbeiterId to set
	 */
	public void setMitarbeiterId(int mitarbeiterId) {
		this.mitarbeiterId = mitarbeiterId;
	}
	/**
	 * @return the kundenId
	 */
	public int getKundenId() {
		return kundenId;
	}
	/**
	 * @param kundenId the kundenId to set
	 */
	public void setKundenId(int kundenId) {
		this.kundenId = kundenId;
	}
	/**
	 * @return the statusId
	 */
	public int getStatusId() {
		return statusId;
	}
	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	/**
	 * @return the bezugsPerson
	 */
	public int getBezugsPerson() {
		return bezugsPerson;
	}
	/**
	 * @param bezugsPerson the bezugsPerson to set
	 */
	public void setBezugsPerson(int bezugsPerson) {
		this.bezugsPerson = bezugsPerson;
	}
	
	/**
	 * Die Methode wird von dem Interface VertragDAO geerbt und Überschrieben
	 * 
 	 * Aus mangeln an Zeit wird die Methode nicht verwendet
 	 * 
	 * Fügt ein neuen Datensatz in die Tabelle vertraege der Datenbank hinzu
	 * 
	 */
	@Override
	public void addVertrag() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		con = DriverManager.getConnection(DatenbankServer.VERBINDUNG.getText(), DatenbankServer.USER.getText(), DatenbankServer.PW.getText());
		
		
		String einfacheEingabe = "INSERT INTO vertraege VALUES (null, ?,?,?,?,?,?,?,33,?,1,33)";//? sind Platzhalter f�r Werte aus einem Objekt
		PreparedStatement prep = con.prepareStatement(einfacheEingabe);
		//F�llen der Platzhalter
		prep.setString(1, this.tarifTyp); //1, Fragezeichen wird ersetzt
		prep.setString(2, this.rufnummer); 
		prep.setString(3, this.pkk);
		prep.setString(4, this.kundennummer);
		prep.setString(5, this.notiz);
		prep.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
		prep.setDate(7, Date.valueOf(this.vertragsEnde));
		System.out.println(prep);
		prep.execute();
		prep.close();
		con.close();
		
	}
	/**
 	 * Die Methode wird von dem Interface VertragDAO geerbt und Überschrieben
	 * 
 	 * Aus mangeln an Zeit wird die Methode nicht verwendet
 	 * 
	 * Beiarbeitet ein Datensatz aus der Tabelle vertraege in der Datenbank
	 */
	@Override
	public void updateVertrag() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		con = DriverManager.getConnection(DatenbankServer.VERBINDUNG.getText(), DatenbankServer.USER.getText(), DatenbankServer.PW.getText());
		
		
		String einfacheEingabe = "UPDATE vertraege SET tariftyp = ?, rufnummer = ?, pkk = ?, kdn = ?, notiz = ?, zeitstempel = ?, vertrags_ende = ?, mitarbeiter_id = ?, kunden_id = ?, status_id = ?, bperson = ? WHERE vertrag_id = " + this.vertragId;//? sind Platzhalter f�r Werte aus einem Objekt
		PreparedStatement prep = con.prepareStatement(einfacheEingabe);
		//F�llen der Platzhalter
		prep.setString(1, this.tarifTyp); //1, Fragezeichen wird ersetzt
		prep.setString(2, this.rufnummer); 
		prep.setString(3, this.pkk);
		prep.setString(4, this.kundennummer);
		prep.setString(5, this.notiz);
		prep.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
		prep.setDate(7, Date.valueOf(this.vertragsEnde));
		prep.setInt(8, this.mitarbeiterId);
		prep.setInt(9, this.kundenId);
		prep.setInt(10, this.statusId);
		prep.setInt(11, this.bezugsPerson);

		System.out.println(prep);
		prep.execute();
		prep.close();
		con.close();
	}
	
	/**
	 * Die Methode wird von dem Interface VertragDAO geerbt und Überschrieben
	 * 
 	 * Aus mangeln an Zeit wird die Methode nicht verwendet
 	 * 
	 * Löscht ein Datensatz aus der Tabelle vertaege in der Datenbank
	 */
	@Override
	public void deleteVertrag() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		con = DriverManager.getConnection(DatenbankServer.VERBINDUNG.getText(), DatenbankServer.USER.getText(), DatenbankServer.PW.getText());
		
		
		String einfacheEingabe = "DELETE FROM vertraege WHERE vertrag_id = " + this.vertragId;//? sind Platzhalter f�r Werte aus einem Objekt
		PreparedStatement prep = con.prepareStatement(einfacheEingabe);
		//F�llen der Platzhalter
		System.out.println(prep);
		prep.execute();
		prep.close();
		con.close();
	}


	
}
