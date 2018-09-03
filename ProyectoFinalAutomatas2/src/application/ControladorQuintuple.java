package application;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class ControladorQuintuple {

	//Para Quintuple.fxml
	@FXML public TextField txtnomauto;
	@FXML public TextField txtconjestad;
	@FXML public TextField txtalfabetoauto;
	@FXML public TextField txtalfabetopila;
	@FXML public TextField txtestadoin;
	@FXML public TextField txtsimboloin;
	

	
	//Metodo para Quintuple.fxml
	public void guardarycontinuar(ActionEvent event) throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/CrearAutomataP.fxml"));
		Scene scene = new Scene(root,700,650);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		File file = new File(txtnomauto.getText()+"DF.txt");	
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(txtconjestad.getText()+"-" + txtalfabetoauto.getText()+ "-" +txtalfabetopila.getText()+ "-"+ txtestadoin.getText()+ "-"+ txtsimboloin.getText() +"\n");
		fileWriter.flush();
		fileWriter.close();
		
		
		//Agarra el text field del alfabeto automata
		String s = txtalfabetoauto.getText();
	    String[] arrSplit1 = s.split("[\\s,]+");

	    Verificacion.alfabetoAuto = new String[arrSplit1.length];
	
	    for(int i=0; i<arrSplit1.length;i++)
	    {
	    	Verificacion.alfabetoAuto[i] = arrSplit1[i];
	    }
	    
	    
	    //Agarra el contenido del alfabeto de la Pila
	    String a = txtalfabetopila.getText();
	    String[] arrSplit2 = a.split("[\\s,]+");
	    
	    Verificacion.AlfabetoPila = new String[arrSplit2.length];

	    for(int i=0; i<arrSplit2.length;i++)
	    {
	    	Verificacion.AlfabetoPila[i] = arrSplit2[i];
	    }
	    
	    
	    //Agarra el contenido de los COnjuntos de Estado
	    String c = txtconjestad.getText();
	    String[] arrSplit3 = c.split("[\\s,]+");
	    
	    Verificacion.ConjuntoEstados = new String[arrSplit3.length];
	    
	    for(int i=0; i<arrSplit3.length;i++)
	    {
	    	Verificacion.ConjuntoEstados[i] = arrSplit3[i];
	    }
	    
	    
	    //Agarra el contenido del Simbolo Inicial de la Pila
	    String b = txtsimboloin.getText();
	    String[] arrSplit4 = b.split("[\\s,]+");
	    
	    Verificacion.SimboloInicial = new String[arrSplit4.length];

	    for(int i=0; i<arrSplit4.length;i++)
	    {
	    	Verificacion.SimboloInicial[0] = arrSplit4[i];
	    	System.out.println(Verificacion.SimboloInicial[0]);
	    }
		
	}
	
	
}
