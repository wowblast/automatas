package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import javafx.animation.RotateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableFloatArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controlador {
	ArrayList<String> nombres;
	String pilavisible="hola";

	@FXML
	 private TableView<Reglamostrada> tablaestado;

	@FXML
	private TableColumn<Reglamostrada, Integer> numregla;

	@FXML
	private TableColumn<Reglamostrada, String> estado1;

	@FXML
	private TableColumn<Reglamostrada, String> letra;

	@FXML
	private TableColumn<Reglamostrada, String> topepila;
	@FXML
	private ImageView imagen1;

	@FXML
	private ImageView imagen2;
	@FXML
	private ImageView main;
	
	@FXML
	private ComboBox combobox;
	@FXML
	 private  TableView<Pilavisible> tablapila;
	@FXML
	private TableColumn<Pilavisible,String>  pilamostrar;
	@FXML
	private ComboBox combobox_de_funcionar;
	@FXML
	private Button botoncargar;
	@FXML
	private Button botonguardar;
	@FXML
	private Label linea;
	@FXML
	private CheckBox a_pv;
    Boolean terminopila=false;
   Boolean terminoreglas=false;
    int numerospilas=0;
    int numeroreglas=0;
	@FXML
	private CheckBox a_ef;


	private RotateTransition rotateTransition1, rotateTransition2 ;

	
	
	@FXML
	public void cargarAutomata()
	{
	//	tabla.setItems(null);
		System.out.println("nombre es"+combobox.getValue().toString());
		Editar.leer(combobox.getValue().toString());
		//tabla.setItems(Editar.data);
	}

  
    
	@FXML
	public void verificar()
	{
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/AutomataNpilas.fxml"));
			Scene scene = new Scene(root,1000,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		imagen1.setImage(new Image("imagenes/syn.png"));
		// text1.setText("Checking For Updates");
		rotateTransition1 = new RotateTransition(Duration.seconds(15), imagen1);
		rotateTransition2 = new RotateTransition(Duration.seconds(2), imagen2);
		FuncionAutomata.guardar_estados_Automatanormal(combobox_de_funcionar.getValue().toString()); 
		String  cadena= "aaabbN ";
		//t.cancel();
		Datosautomata.estadosiniciales.add("leer");
		
	     
		
		System.out.println(FuncionAutomata.mostrartodo.size()+" ffefggwge");
		for(int x=0;x<FuncionAutomata.mostrartodo.size();x++)
		{
			System.out.println(FuncionAutomata.mostrartodo.get(x).getEstado()+" "+FuncionAutomata.mostrartodo.get(x).getEntrada()+" "+FuncionAutomata.mostrartodo.get(x).getNumregla()+" "+FuncionAutomata.mostrartodo.get(x).getTopepila());
		}
		for(int x=0;x<FuncionAutomata.pilas.size();x++)
		{
			for(int y=0;y<FuncionAutomata.pilas.get(x).size();y++)
			{
				System.out.print(FuncionAutomata.pilas.get(x).get(y));
			}
			System.out.println("");
		}
     	RotateTransition transition[] = {rotateTransition1, rotateTransition2
		};
		for (RotateTransition rTransition : transition) {
			rTransition.setCycleCount(1);
			rTransition.setAutoReverse(false);
			rTransition.setFromAngle(720);
			rTransition.setToAngle(0);
		}
		rotateTransition1.play();
		if(a_pv.isSelected()&&a_ef.isSelected())
		{
			FuncionAutomata.pilavacia=true;
			FuncionAutomata.estadofinal=true;
			for(int x=0;x<Datosautomata.estadosiniciales.size();x++)
			{
				ArrayList<String> pila= new ArrayList<String>();
				pila.add("z0");
				FuncionAutomata.probar_reglaAutomatanormal(cadena, 0,Datosautomata.estadosiniciales.get(x), pila);
			}
			for(int x=0;x<FuncionAutomata.pilas.size();x++)
			{
				for(int y=0;y<FuncionAutomata.pilas.get(x).size();y++)
				{
					System.out.print(FuncionAutomata.pilas.get(x).get(y));
				}
				System.out.println("");
			}
			for(int x=0;x<FuncionAutomata.mostrartodo.size();x++)
			{
				System.out.println(FuncionAutomata.mostrartodo.get(x).getEstado()+" "+FuncionAutomata.mostrartodo.get(x).getEntrada()+" "+FuncionAutomata.mostrartodo.get(x).getNumregla()+" "+FuncionAutomata.mostrartodo.get(x).getTopepila());
			}
			ObservableList<String> piladatos  =    FXCollections.observableArrayList();
			ArrayList<String> lineas= new ArrayList<String>() ;
			
			Timer t = new Timer();
			TimerTask tt = new TimerTask() {
				@Override
				public void run() {
					//do something
					System.out.println("llego");
					
					
					if(terminopila&&terminoreglas)
					{
						t.cancel();
					}
					if(numeroreglas<FuncionAutomata.mostrartodo.size())
					{
						tablaestado.getItems().add(FuncionAutomata.mostrartodo.get(numeroreglas));
					}
					
					if(numerospilas<FuncionAutomata.pilas.size())
					{
						tablapila.getItems().clear();
						for(int d=(FuncionAutomata.pilas.get(numerospilas).size()-1);d>=0;d--)
						{

				        	 Pilavisible p= new Pilavisible(FuncionAutomata.pilas.get(numerospilas).get(d));
								tablapila.getItems().add(p);
						}
						
					}
					if(numeroreglas>FuncionAutomata.mostrartodo.size())
					{
						terminoreglas=true;
					}
					
					if(numerospilas>FuncionAutomata.pilas.size())
					{
						terminopila=true;
					}
					numeroreglas++;
					numerospilas++;
					
                    		 

				





				};
			};
			t.schedule(tt,400,400);

		}
		else if(a_pv.isSelected())
		{
			FuncionAutomata.pilavacia=true;
		}
		else if(a_ef.isSelected())
		{
			FuncionAutomata.pilavacia=true;
		}
		else

		{

		}
		rotateTransition1.setOnFinished((e) -> {
			imagen1.setImage(new Image("imagenes/ok.png"));
			linea.setStyle("-fx-background-color:#45A563");
			imagen2.setImage(new Image("imagenes/syn.png"));
			//text2.setText("Pre-scan Operations");
			rotateTransition2.play();
		});

		rotateTransition2.setOnFinished((e) -> {
			if(!FuncionAutomata.camino)
			{
				imagen2.setImage(new Image("imagenes/ok.png"));
			}
			else
			{
				imagen2.setImage(new Image("imagenes/x.png"));
			}

		});
	}
	private void start_scan(ActionEvent event) {
		imagen1.setImage(new Image("imagenes/syn.png"));
		// text1.setText("Checking For Updates");
		rotateTransition1 = new RotateTransition(Duration.seconds(2), imagen1);
		rotateTransition2 = new RotateTransition(Duration.seconds(2), imagen2);
		int a =10;
		RotateTransition transition[] = {rotateTransition1, rotateTransition2
		};
		for (RotateTransition rTransition : transition) {
			rTransition.setCycleCount(1);
			rTransition.setAutoReverse(false);
			rTransition.setFromAngle(720);
			rTransition.setToAngle(0);
		}
		rotateTransition1.play();
		rotateTransition1.setOnFinished((e) -> {
			imagen1.setImage(new Image("imagenes/ok.png"));
			linea.setStyle("-fx-background-color:#45A563");
			imagen2.setImage(new Image("imagenes/syn.png"));
			//text2.setText("Pre-scan Operations");
			rotateTransition2.play();
		});

		rotateTransition2.setOnFinished((e) -> {
			if(a<6)
			{
				imagen2.setImage(new Image("imagenes/ok.png"));
			}
			else
			{
				imagen2.setImage(new Image("imagenes/x.png"));
			}
			// lbl2.setStyle("-fx-background-color:#45A563");
			//  img3.setImage(new Image("imageness/syn.png"));
			//text3.setText("Scanning Memory");
			//rotateTransition3.play();
		});
	}







	@SuppressWarnings("unchecked")
	public void initialize() {
		// TODO Auto-generated method stub
	   
		
		main.setImage(new Image("imagenes/automata.png"));

		pilamostrar.setCellValueFactory(new PropertyValueFactory<Pilavisible, String>("topepila"));
		//cod
		 numregla.setCellValueFactory(new PropertyValueFactory<Reglamostrada, Integer>("numregla"));

		estado1.setCellValueFactory(new PropertyValueFactory<Reglamostrada, String>("estado"));
		 letra.setCellValueFactory(new PropertyValueFactory<Reglamostrada, String>("entrada"));

		 topepila.setCellValueFactory(new PropertyValueFactory<Reglamostrada, String>("topepila"));

		 
          
	
	
		nombres= Editar.obtenerarchivos();

		ObservableList<String> options = 
				FXCollections.observableArrayList();	   

		for(int x=0;x<nombres.size();x++)
		{

			options.add(nombres.get(x));
			System.out.println(options.get(x));
		}
		combobox.setItems(options); 
		combobox_de_funcionar.setItems(options);

		System.out.println("entro");



	}
}
