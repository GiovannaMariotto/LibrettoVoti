package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Libretto model;
	
	/**
	 * Mi permette settare il modelo nell' EntryPoint
	 * @param model
	 */
	public void setModel(Libretto model) {
		this.model=model;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNomeEsame;

    @FXML
    private TextField txtVoto;

   // @FXML
    //private TextField txtData;

    @FXML
    private DatePicker pickerEsame;
    
    @FXML
    private Button button;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void inserisceVoto(ActionEvent event) {
    	//Leggi e controlla i dati
    	String nomeEsame = txtNomeEsame.getText();
    	if(nomeEsame.length()==0) {
    		txtRisultato.setText("ERRORE: nome esame vuoto");
    		return;
    	}
    	int voto;
    	
    	try {
    	voto = Integer.parseInt(txtVoto.getText());
    	
    	 }
    	catch(NumberFormatException ex) {
    		txtRisultato.setText("ERRORE: il voto deve essere numerico!");
    		return;
    	}
    	if(voto<18||voto>30) {
    		txtRisultato.setText("ERRORE: il voto deve essere compreso tra 18 e 30");
    		return;
    	}
    	
    	
    	LocalDate data = pickerEsame.getValue();
    	if(data==null) {
    		txtRisultato.setText("ERRORE: la data è errata o mancante");
    		return;
    	}
    	//Esegui l'azione
    	Voto v = new Voto(nomeEsame,voto,data);
    	model.add(v);
    	
    	//Aggiorna i risultati (nella View)
    	txtRisultato.setText(model.toString());
    	txtNomeEsame.clear();
    	txtVoto.clear();
    	pickerEsame.setValue(null);
    	
    	
    	
    }

    @FXML
    void initialize() {
        assert txtNomeEsame != null : "fx:id=\"txtNomeEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

