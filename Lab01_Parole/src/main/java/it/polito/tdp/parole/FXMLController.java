package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTime;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	String par=txtParola.getText();
    	if(!par.matches(".*[0-9].*")) {
    		elenco.addParola(par);
    	}
    	else {
    		txtResult.setText("Inserire solo caratteri alfabetici");
    		txtParola.clear();
    		String time=String.valueOf(System.nanoTime());
        	txtTime.appendText(time+"\n");
    		return;
    	}
    		
    	txtResult.setText(elenco.toString());
    	txtParola.clear();
    	String time=String.valueOf(System.nanoTime());
    	txtTime.appendText(time+"\n");
    }
    
/*  CORREZIONE:
    void doInsert(ActionEvent event) {
    	// TODO

    	double start = System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	double stop = System.nanoTime();

    	txtResult.clear();
    	String result = "";
    	for (String p:elenco.getElenco())
    		result +=p + "\n";
    	txtResult.setText(result);

    	txtPerformance.clear();
    	txtPerformance.setText("[INSERT]: " + (stop - start)/1e9 + " seconds");


    	txtParola.clear();
    }
  
 */

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.clear();
    	String time=String.valueOf(System.nanoTime());
    	txtTime.appendText(time+"\n"); //CORREZIONE: txtPerformance.clear();
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	String s=txtResult.getSelectedText();
    	if(elenco.getElenco().contains(s)) {
    		elenco.removeParola(s);
    		txtResult.setText(elenco.toString());
    	}
    	String time=String.valueOf(System.nanoTime());
    	txtTime.appendText(time+"\n");
    }
/*
 * void doCancella(ActionEvent event) {

    	String selected = txtResult.getSelectedText();
    	double start = System.nanoTime();
    	elenco.removeParola(selected);
    	double stop = System.nanoTime();

    	txtResult.clear();
    	String result = "";
    	for (String p:elenco.getElenco())
    		result +=p + "\n";
    	txtResult.setText(result);

    	txtPerformance.clear();
    	txtPerformance.setText("[REMOVE]: " + (stop - start)/1e9 + " seconds");
	}
*/
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
