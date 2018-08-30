package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableFloatArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class Controlador {
	Automata automata;
	ArrayList<String> nombres;


	@FXML
	private TableView tabla;
	@FXML
	 private ComboBox combobox;

	@FXML
	private Button botoncargar;
	@FXML
	private Button botonguardar;


	public Controlador() {


	}
	@FXML
	public void guardar()
	{
		ObservableList<Automata> datos = FXCollections.observableArrayList();
		

		for(Automata auto:Editar.data)
		{
			if(!auto.getEstado1().isEmpty())
			{
				datos.add(auto);
			}
		}
		for(int x=0;x<datos.size();x++)
		{
			System.out.println(datos.get(x).getEstado1());
		}
System.out.println("nombre es"+combobox.getAccessibleText());
		//Editar.sobreeescribir(combobox.getAccessibleText(), datos);
	}
	@FXML
	public void cargarAutomata()
	{
		tabla.setItems(null);
		System.out.println("nombre es"+combobox.getValue().toString());
		Editar.leer(combobox.getValue().toString());
		tabla.setItems(Editar.data);
	}

	





	@SuppressWarnings("unchecked")
	public void initialize() {
		// TODO Auto-generated method stub
		TableColumn regla= new TableColumn("Regla");
		TableColumn estado1= new TableColumn("Estado 1");
		TableColumn cadena= new TableColumn("cadena");
		TableColumn pila= new TableColumn("Pila");
		TableColumn estado2= new TableColumn("Estado 2");
		TableColumn orden= new TableColumn("Orden");
		tabla.getColumns().addAll(regla,estado1,cadena,pila,estado2,orden);          
		;

		regla.setCellValueFactory(new PropertyValueFactory<Automata,Integer>("numeroregla"));
		estado1.setCellValueFactory(new PropertyValueFactory<Automata,String>("estado1"));
		cadena.setCellValueFactory(new PropertyValueFactory<Automata,String>("cadenaletra"));
		pila.setCellValueFactory(new PropertyValueFactory<Automata,String>("cadenaPila"));
		estado2.setCellValueFactory(new PropertyValueFactory<Automata,String>("estado2"));
		orden.setCellValueFactory(new PropertyValueFactory<Automata,String>("orderpila"));
		
		tabla.setEditable(true);
		estado1.setCellFactory(TextFieldTableCell.forTableColumn());
		nombres= Editar.obtenerarchivos();
		
		ObservableList<String> options = 
			    FXCollections.observableArrayList();	   
		 
		for(int x=0;x<nombres.size();x++)
		{
		
			options.add(nombres.get(x));
			System.out.println(options.get(x));
		}
		 combobox.setItems(options); 
		
		System.out.println("entro");

		//ArrayList<String> columnData = new ArrayList<>();

	}
}
