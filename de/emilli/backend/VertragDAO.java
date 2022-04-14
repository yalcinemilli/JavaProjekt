package de.emilli.backend;

import java.sql.SQLException;

public interface VertragDAO {
//	List<Kunden> getAllKunde();
	void addVertrag() throws SQLException;
	void updateVertrag() throws SQLException;
	void deleteVertrag() throws SQLException;

}
