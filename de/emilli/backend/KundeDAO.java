package de.emilli.backend;

import java.sql.SQLException;
import java.util.List;

public interface KundeDAO {


//	List<Kunden> getAllKunde();
	void addKunde() throws SQLException;
	void updateKunde() throws SQLException;
	void deleteKunde() throws SQLException;

}
