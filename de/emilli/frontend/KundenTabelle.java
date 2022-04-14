package de.emilli.frontend;


import java.sql.Timestamp;
import java.time.LocalDate;

import de.emilli.backend.*;
import de.emilli.main.*;
import javafx.application.Application; 
import javafx.beans.property.IntegerProperty; 
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty; 
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList; 
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * GUI Klassse mit JavaFX
 */
public class KundenTabelle extends Application {

    private TableView<Kunde> tView = new TableView<Kunde>();
    
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
        stage.setTitle("Kunden"); 
        stage.setWidth(800); 
        stage.setHeight(600); 

        tView.setEditable(true); 

        TableColumn<Kunde, String> vornameCol = new TableColumn<Kunde, String>("Vorname"); 
        vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname")); 
//        vornameCol.prefWidthProperty().bind(tView.widthProperty().multiply(0.45)); 

        TableColumn<Kunde, String> nachnameCol = new TableColumn<Kunde, String>("Nachname"); 
        nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname")); 
        TableColumn<Kunde, LocalDate> geburtstagCol = new TableColumn<Kunde, LocalDate>("Geburtsdatum"); 
        geburtstagCol.setCellValueFactory(new PropertyValueFactory<>("geburtsdatum")); 
        TableColumn<Kunde, String> notizenCol = new TableColumn<Kunde, String>("Notizen"); 
        notizenCol.setCellValueFactory(new PropertyValueFactory<>("notizen")); 
        TableColumn<Kunde, String> mitarbeiterCol = new TableColumn<Kunde, String>("Mitarbeiter"); 
        mitarbeiterCol.setCellValueFactory(new PropertyValueFactory<>("mitarbeiterId"));
        TableColumn<Kunde, Timestamp> lastchangeCol = new TableColumn<Kunde, Timestamp>("Letzte Änderung"); 
        lastchangeCol.setCellValueFactory(new PropertyValueFactory<>("lastChange"));
        TableColumn<Kunde, String> kundenTypCol = new TableColumn<Kunde, String>("Kunden Typ"); 
        kundenTypCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kunde, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Kunde, String> param) {
                return param.getValue().kundenTypProperty();
            }
        });
        TableColumn<Kunde, String> bezugsPersonCol = new TableColumn<Kunde, String>("Bezugs Person"); 
        bezugsPersonCol.setCellValueFactory(new PropertyValueFactory<>("bezugsPerson"));
        TableColumn<Kunde, String> kontaktCol = new TableColumn<Kunde, String>("Kontakt"); 
        kontaktCol.setCellValueFactory(new PropertyValueFactory<>("kontakt"));
        
        
        tView.getColumns().addAll(vornameCol, nachnameCol, geburtstagCol, notizenCol, mitarbeiterCol, lastchangeCol, kundenTypCol, bezugsPersonCol, kontaktCol); 
        tView.getItems().addAll(Kunde.getAllKunden());
//        tView.setItems((ObservableList<Kunden>) Kunden.getAllKunden()); 
        Scene scene = new Scene(tView); 
        stage.setScene(scene); 
        stage.show(); 
	}

	
}
