package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableFloatArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class Controlador1P {
	Automata automata;
	ArrayList<String> nombres;
	ArrayList<String> nombres1;


	@FXML
	private TableView tabla;
	@FXML
	private ComboBox combobox;
	@FXML
	private ComboBox combobox1;
	@FXML
	private TableView tabla1;

	@FXML
	private Button botoncargar;
	@FXML
	private Button botonguardar;
	@FXML
	private CheckBox check;
	@FXML
    private Button probarAutomata;


	public Controlador1P() {

	}
	@FXML
	public void probar_automata()
	{
	}

	
	@FXML
	public void Guardar()
	{
		guardar();
		guardar1();
	}
	
	public void Extension(ActionEvent event) throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Menuprinc4P.fxml"));
		Scene scene = new Scene(root,1000,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void CrearAutomata1P(ActionEvent event) throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Quintuple.fxml"));
		Scene scene = new Scene(root,663,508);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void guardar()
	{
		ObservableList<Automata> datos = FXCollections.observableArrayList();


		System.out.println(estado1.getCellData(0).toString());

		for(Automata auto:Editar.data)
		{
			if(!auto.getEstado1().isEmpty())
			{
				datos.add(auto);
			}
		}
		System.out.println("nombre es "+combobox.getValue().toString());
		Editar.sobreeescribir(combobox.getValue().toString(), datos);
	}
	
	@FXML
	public void guardar1()
	{
		ObservableList<Alfabeto> datos1 = FXCollections.observableArrayList();


		System.out.println(estado1.getCellData(0).toString());

		for(Alfabeto auto1:Editar.data1)
		{
				datos1.add(auto1);
		}
		System.out.println("nombre es "+combobox.getValue().toString());
		Editar.sobreeescribir1(combobox1.getValue().toString(), datos1);
	}
	
	@FXML
	public void CargarAuto()
	{
		cargarAutomata();
		cargarAutomata1();
	}
	
	public void cargarAutomata()
	{
		tabla.getItems().clear();
		tabla.setItems(null);
		System.out.println("nombre es "+combobox.getValue().toString());
		Editar.leer(combobox.getValue().toString());
		tabla.setItems(Editar.data);
		
		if(check.isSelected())
		{
		Alfabeto();
		System.out.println("marcado");
		}
		else
		{
			System.out.println("Desmarcado");
		}
	}
	
	public void cargarAutomata1()
	{
		tabla1.getItems().clear();
		tabla1.setItems(null);
		System.out.println("nombre es "+combobox1.getValue().toString());
		Editar.leer1(combobox1.getValue().toString());
		tabla1.setItems(Editar.data1);
		
		if(check.isSelected())
		{
		Alfabeto();
		System.out.println("marcado");
		}
		else
		{
			System.out.println("Desmarcado");
		}
	}




	@FXML
	TableColumn regla;
	@FXML
	TableColumn estado1;
	@FXML
	TableColumn cadena;
	@FXML
	TableColumn pila;
	@FXML
	TableColumn estado2;
	@FXML
	TableColumn orden;

	@SuppressWarnings("unchecked")
	public void initialize() {

		regla= new TableColumn("Regla");
		estado1= new TableColumn("Estado 1");
		cadena= new TableColumn("cadena");
		pila= new TableColumn("Pila");
		estado2= new TableColumn("Estado 2");
		orden= new TableColumn("Orden");
		tabla.getColumns().addAll(regla,estado1,cadena,pila,estado2,orden);



		regla.setCellValueFactory(new PropertyValueFactory<Automata,Integer>("numeroregla"));
		estado1.setCellValueFactory(new PropertyValueFactory<Automata,String>("estado1"));
		cadena.setCellValueFactory(new PropertyValueFactory<Automata,String>("cadenaletra"));
		pila.setCellValueFactory(new PropertyValueFactory<Automata,String>("cadenaPila"));
		estado2.setCellValueFactory(new PropertyValueFactory<Automata,String>("estado2"));
		orden.setCellValueFactory(new PropertyValueFactory<Automata,String>("orderpila"));

		tabla.setEditable(true);
		
		Alfabeto();
		
		editado();
		
		
		
		//regla.addEventHandler(TableColumn.editCommitEvent(), handler);

		nombres= Editar.obtenerarchivos();

		ObservableList<String> options = 
				FXCollections.observableArrayList();	   

		for(int x=0;x<nombres.size();x++)
		{

			options.add(nombres.get(x));
			System.out.println(options.get(x) + " fd");
		}
		combobox.setItems(options); 

		System.out.println("entro");
		
		
		nombres1= Editar.obtenerarchivos1();

		ObservableList<String> options1 = 
				FXCollections.observableArrayList();	   

		for(int x=0;x<nombres1.size();x++)
		{

			options1.add(nombres1.get(x));
			System.out.println(options1.get(x) + " fd");
		}
		combobox1.setItems(options1);

		System.out.println("entro");

		//ArrayList<String> columnData = new ArrayList<>();

	}

	public void editado()
	{
		estado1.setCellFactory(TextFieldTableCell.<Automata>forTableColumn());
		estado1.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata, String>>() {
				       public void handle(CellEditEvent<Automata, String> t) {((Automata) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEstado1(t.getNewValue());}});
		
		cadena.setCellFactory(TextFieldTableCell.<Automata>forTableColumn());
		cadena.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata, String>>() {
				       public void handle(CellEditEvent<Automata, String> t) {((Automata) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCadenaletra(t.getNewValue());}});
		
		pila.setCellFactory(TextFieldTableCell.<Automata>forTableColumn());
		pila.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata, String>>() {
				       public void handle(CellEditEvent<Automata, String> t) {((Automata) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCadenaPila(t.getNewValue());}});
	
		estado2.setCellFactory(TextFieldTableCell.<Automata>forTableColumn());
		estado2.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata, String>>() {
				       public void handle(CellEditEvent<Automata, String> t) {((Automata) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEstado2(t.getNewValue());}});
	
		orden.setCellFactory(TextFieldTableCell.<Automata>forTableColumn());
		orden.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata, String>>() {
				       public void handle(CellEditEvent<Automata, String> t) {((Automata) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOrderpila(t.getNewValue());}});
	}
	
	@FXML
	TableColumn conjunto;
	@FXML
	TableColumn alfabeto1;
	@FXML
	TableColumn alfabeto2;
	@FXML
	TableColumn estadoini;
	@FXML
	TableColumn estadosacept;
	
	
	public void Alfabeto()
	{
		conjunto= new TableColumn("Conjunto finito");
		alfabeto1= new TableColumn("Alfabeto de entrada");
		alfabeto2= new TableColumn("Alfabeto de pila");
		estadoini= new TableColumn("Estado Inicial");
		estadosacept= new TableColumn("Estados aceptados");
		tabla1.getColumns().addAll(conjunto,alfabeto1,alfabeto2,estadoini,estadosacept);



		conjunto.setCellValueFactory(new PropertyValueFactory<Automata,Integer>("conjunto"));
		alfabeto1.setCellValueFactory(new PropertyValueFactory<Automata,String>("alfabeto1"));
		alfabeto2.setCellValueFactory(new PropertyValueFactory<Automata,String>("alfabeto2"));
		estadoini.setCellValueFactory(new PropertyValueFactory<Automata,String>("estadoini"));
		estadosacept.setCellValueFactory(new PropertyValueFactory<Automata,String>("estadosacept"));

		tabla1.setEditable(true);
		
		conjunto.setCellFactory(TextFieldTableCell.<Alfabeto>forTableColumn());
		conjunto.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto, String>>() {
				       public void handle(CellEditEvent<Alfabeto, String> t) {((Alfabeto) t.getTableView().getItems().get(t.getTablePosition().getRow())).setConjunto(t.getNewValue());}});
		
		alfabeto1.setCellFactory(TextFieldTableCell.<Alfabeto>forTableColumn());
		alfabeto1.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto, String>>() {
				       public void handle(CellEditEvent<Alfabeto, String> t) {((Alfabeto) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAlfabeto1(t.getNewValue());}});
		
		alfabeto2.setCellFactory(TextFieldTableCell.<Alfabeto>forTableColumn());
		alfabeto2.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto, String>>() {
				       public void handle(CellEditEvent<Alfabeto, String> t) {((Alfabeto) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAlfabeto2(t.getNewValue());}});
		
		estadoini.setCellFactory(TextFieldTableCell.<Alfabeto>forTableColumn());
		estadoini.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto, String>>() {
				       public void handle(CellEditEvent<Alfabeto, String> t) {((Alfabeto) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEstadoini(t.getNewValue());}});
		
		estadosacept.setCellFactory(TextFieldTableCell.<Alfabeto>forTableColumn());
		estadosacept.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto, String>>() {
				       public void handle(CellEditEvent<Alfabeto, String> t) {((Alfabeto) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEstadosacept(t.getNewValue());}});
	}
}
