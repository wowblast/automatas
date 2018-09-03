package application;

import java.io.File;
import java.io.FileWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorQuintuple4P {

	@FXML public TextField txtnomauto;
	@FXML public TextField txtconjestad;
	@FXML public TextField txtalfabetoauto;
	@FXML public TextField txtalfabetopila1;
	@FXML public TextField txtalfabetopila2;
	@FXML public TextField txtalfabetopila3;
	@FXML public TextField txtalfabetopila4;
	@FXML public TextField txtestadoin;
	@FXML public TextField txtestadofin;
	@FXML public TextField txtsimboloin1;
	@FXML public TextField txtsimboloin2;
	@FXML public TextField txtsimboloin3;
	@FXML public TextField txtsimboloin4;

	//Metodo que guarda en un text file
	public void guardarycontinuar(ActionEvent event) throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/CrearAutomata4P.fxml"));
		Scene scene = new Scene(root,1123,754);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		File file = new File(txtnomauto.getText()+"DF4P.txt");	
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(txtconjestad.getText() +"-"+ txtalfabetoauto.getText()+"-"+ txtalfabetopila1.getText()+"-"+ txtalfabetopila2.getText()
							+"-"+ txtalfabetopila3.getText()+"-"+ txtalfabetopila4.getText()+"-"+ txtestadoin.getText()
							+"-"+ txtestadofin.getText()+"-"+ txtsimboloin1.getText()+"-"+ txtsimboloin2.getText()
							+"-"+ txtsimboloin3.getText()+"-"+txtsimboloin4.getText());
		fileWriter.flush();
		fileWriter.close();
		
		//Agarra el text field del alfabeto automata
				String s = txtalfabetoauto.getText();
			    String[] arrSplit1 = s.split("[\\s,]+");

			    Verificacion.alfabetoAuto4P = new String[arrSplit1.length];
			
			    for(int i=0; i<arrSplit1.length;i++)
			    {
			    	Verificacion.alfabetoAuto4P[i] = arrSplit1[i];
			    }
			    
			    
			    //Agarra el contenido del alfabeto de la Pila 1
			    String a = txtalfabetopila1.getText();
			    String[] arrSplit2 = a.split("[\\s,]+");
			    
			    Verificacion.AlfabetoPila1 = new String[arrSplit2.length];

			    for(int i=0; i<arrSplit2.length;i++)
			    {
			    	Verificacion.AlfabetoPila1[i] = arrSplit2[i];
			    }
			    
			  //Agarra el contenido del alfabeto de la Pila 2
			    String aa = txtalfabetopila2.getText();
			    String[] arrSplit5 = aa.split("[\\s,]+");
			    
			    Verificacion.AlfabetoPila2 = new String[arrSplit5.length];

			    for(int i=0; i<arrSplit5.length;i++)
			    {
			    	Verificacion.AlfabetoPila2[i] = arrSplit5[i];
			    }
			    
			  //Agarra el contenido del alfabeto de la Pila 3
			    String aaa = txtalfabetopila3.getText();
			    String[] arrSplit6 = aaa.split("[\\s,]+");
			    
			    Verificacion.AlfabetoPila3 = new String[arrSplit6.length];

			    for(int i=0; i<arrSplit6.length;i++)
			    {
			    	Verificacion.AlfabetoPila3[i] = arrSplit6[i];
			    }
			    
			  //Agarra el contenido del alfabeto de la Pila 4
			    String aaaa = txtalfabetopila4.getText();
			    String[] arrSplit7 = aaaa.split("[\\s,]+");
			    
			    Verificacion.AlfabetoPila4 = new String[arrSplit7.length];

			    for(int i=0; i<arrSplit7.length;i++)
			    {
			    	Verificacion.AlfabetoPila4[i] = arrSplit7[i];
			    }
			    
			    
			    //Agarra el contenido de los COnjuntos de Estado
			    String c = txtconjestad.getText();
			    String[] arrSplit3 = c.split("[\\s,]+");
			    
			    Verificacion.ConjuntoEstados4P = new String[arrSplit3.length];
			    
			    for(int i=0; i<arrSplit3.length;i++)
			    {
			    	Verificacion.ConjuntoEstados4P[i] = arrSplit3[i];
			    }
			    
			    
			    //Agarra el contenido del Simbolo Inicial de la Pila 1
			    String b = txtsimboloin1.getText();
			    String[] arrSplit4 = b.split("[\\s,]+");
			    
			    Verificacion.SimboloInicial1 = new String[arrSplit4.length];

			    for(int i=0; i<arrSplit4.length;i++)
			    {
			    	Verificacion.SimboloInicial1[0] = arrSplit4[i];
			    	//System.out.println(Verificacion.SimboloInicial1[0]);
			    }
			    
			  //Agarra el contenido del Simbolo Inicial de la Pila 2
			    String bb = txtsimboloin2.getText();
			    String[] arrSplit8 = bb.split("[\\s,]+");
			    
			    Verificacion.SimboloInicial2 = new String[arrSplit8.length];

			    for(int i=0; i<arrSplit8.length;i++)
			    {
			    	Verificacion.SimboloInicial2[0] = arrSplit8[i];
			    	//System.out.println(Verificacion.SimboloInicial2[0]);
			    }
			    
			  //Agarra el contenido del Simbolo Inicial de la Pila 3
			    String bbb = txtsimboloin3.getText();
			    String[] arrSplit9 = bbb.split("[\\s,]+");
			    
			    Verificacion.SimboloInicial3 = new String[arrSplit9.length];

			    for(int i=0; i<arrSplit9.length;i++)
			    {
			    	Verificacion.SimboloInicial3[0] = arrSplit9[i];
			    	//System.out.println(Verificacion.SimboloInicial3[0]);
			    }
			    
			  //Agarra el contenido del Simbolo Inicial de la Pila 4
			    String bbbb = txtsimboloin4.getText();
			    String[] arrSplit10 = bbbb.split("[\\s,]+");
			    
			    Verificacion.SimboloInicial4 = new String[arrSplit10.length];

			    for(int i=0; i<arrSplit10.length;i++)
			    {
			    	Verificacion.SimboloInicial4[0] = arrSplit10[i];
			    	//System.out.println(Verificacion.SimboloInicial4[0]);
			    }
			    
			    //probar si se guardan en los arreglos
			    /*
			    for (int i=0; i<Verificacion.alfabetoAuto4P.length; i++)
			    {
			    	System.out.println(Verificacion.alfabetoAuto4P[i]);
			    }
			    
			    System.out.println(" ");
			    
			    for (int i=0; i<Verificacion.ConjuntoEstados4P.length; i++)
			    {
			    	System.out.println(Verificacion.ConjuntoEstados4P[i]);
			    }
			    
			    System.out.println(" ");
			    
			    for (int i=0; i<Verificacion.AlfabetoPila1.length; i++)
			    {
			    	System.out.println(Verificacion.AlfabetoPila1[i]);
			    }
			    
			    System.out.println(" ");
			    
			    for (int i=0; i<Verificacion.AlfabetoPila2.length; i++)
			    {
			    	System.out.println(Verificacion.AlfabetoPila2[i]);
			    }
			    
			    System.out.println(" ");
			    
			    for (int i=0; i<Verificacion.AlfabetoPila3.length; i++)
			    {
			    	System.out.println(Verificacion.AlfabetoPila3[i]);
			    }
			    
			    System.out.println(" ");
			    
			    for (int i=0; i<Verificacion.AlfabetoPila4.length; i++)
			    {
			    	System.out.println(Verificacion.AlfabetoPila4[i]);
			    }
			    
			    System.out.println(" ");
			    
			    for (int i=0; i<Verificacion.SimboloInicial1.length; i++)
			    {
			    	System.out.println(Verificacion.SimboloInicial1[i]);
			    }
			    
			    System.out.println(" ");
			    
			    for (int i=0; i<Verificacion.SimboloInicial2.length; i++)
			    {
			    	System.out.println(Verificacion.SimboloInicial2[i]);
			    }
			    
			    System.out.println(" ");
			    
			    for (int i=0; i<Verificacion.SimboloInicial3.length; i++)
			    {
			    	System.out.println(Verificacion.SimboloInicial3[i]);
			    }
			    
			    System.out.println(" ");
			    
			    for (int i=0; i<Verificacion.SimboloInicial4.length; i++)
			    {
			    	System.out.println(Verificacion.SimboloInicial4[i]);
			    }
			    
			    System.out.println(" ");*/
		
	}
	
}
