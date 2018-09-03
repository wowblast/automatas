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

public class Controlador4P {
	Automata1 automata1;
	ArrayList<String> nombres2;
	ArrayList<String> nombres3;


	@FXML
	private TableView tabla2;
	@FXML
	private ComboBox combobox2;
	@FXML
	private ComboBox combobox3;
	@FXML
	private TableView tabla3;

	@FXML
	private Button botoncargar1;
	@FXML
	private Button botonguardar1;

	
	
	
	
	public Controlador4P() 
	{
		
	}
	public void CrearAutomata4P(ActionEvent event) throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Quintuple4P.fxml"));
		Scene scene = new Scene(root,733,587);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@FXML
	public void Guardar1()
	{
		guardar2();
		guardar3();
	}
	
	public void guardar2()
	{
		ObservableList<Automata1> datos = FXCollections.observableArrayList();


		System.out.println(estado1.getCellData(0).toString());

		for(Automata1 auto:Editar1.data2)
		{
			if(!auto.getEstado1().isEmpty())
			{
				datos.add(auto);
			}
		}
		System.out.println("nombre es "+combobox2.getValue().toString());
		Editar1.sobreeescribir2(combobox2.getValue().toString(), datos);
	}
	
	@FXML
	public void guardar3()
	{
		ObservableList<Alfabeto1> datos1 = FXCollections.observableArrayList();


		System.out.println(estado1.getCellData(0).toString());

		for(Alfabeto1 auto1:Editar1.data3)
		{
				datos1.add(auto1);
		}
		System.out.println("nombre es "+combobox3.getValue().toString());
		Editar1.sobreeescribir3(combobox3.getValue().toString(), datos1);
	}
	
	@FXML
	public void CargarAuto1()
	{
		cargarAutomata2();
		cargarAutomata3();
	}
	
	public void cargarAutomata2()
	{
		tabla2.getItems().clear();
		tabla2.setItems(null);
		System.out.println("nombre es "+combobox2.getValue().toString());
		Editar1.leer2(combobox2.getValue().toString());
		tabla2.setItems(Editar1.data2);
		
	}
	
	public void cargarAutomata3()
	{
		tabla3.getItems().clear();
		tabla3.setItems(null);
		System.out.println("nombre es "+combobox3.getValue().toString());
		Editar1.leer3(combobox3.getValue().toString());
		tabla3.setItems(Editar1.data3);
		
	}




	@FXML
	TableColumn regla;
	@FXML
	TableColumn estado1;
	@FXML
	TableColumn cadena;
	@FXML
	TableColumn pila1;
	@FXML
	TableColumn pila2;
	@FXML
	TableColumn pila3;
	@FXML
	TableColumn pila4;
	@FXML
	TableColumn estado2;
	@FXML
	TableColumn orden1;
	@FXML
	TableColumn orden2;
	@FXML
	TableColumn orden3;
	@FXML
	TableColumn orden4;

	@SuppressWarnings("unchecked")
	public void initialize() {

		regla= new TableColumn("Regla");
		estado1= new TableColumn("Estado 1");
		cadena= new TableColumn("Cadena");
		pila1= new TableColumn("Pila 1");
		pila2= new TableColumn("Pila 2");
		pila3= new TableColumn("Pila 3");
		pila4= new TableColumn("Pila 4");
		estado2= new TableColumn("Estado 2");
		orden1= new TableColumn("Orden 1");
		orden2= new TableColumn("Orden 2");
		orden3= new TableColumn("Orden 3");
		orden4= new TableColumn("Orden 4");
		tabla2.getColumns().addAll(regla,estado1,cadena,pila1,pila2,pila3,pila4,estado2,orden1,orden2,orden3,orden4);



		regla.setCellValueFactory(new PropertyValueFactory<Automata1,Integer>("numeroregla"));
		estado1.setCellValueFactory(new PropertyValueFactory<Automata1,String>("estado1"));
		cadena.setCellValueFactory(new PropertyValueFactory<Automata1,String>("cadenaletra"));
		pila1.setCellValueFactory(new PropertyValueFactory<Automata1,String>("cadenaPila1"));
		pila2.setCellValueFactory(new PropertyValueFactory<Automata1,String>("cadenaPila2"));
		pila3.setCellValueFactory(new PropertyValueFactory<Automata1,String>("cadenaPila3"));
		pila4.setCellValueFactory(new PropertyValueFactory<Automata1,String>("cadenaPila4"));
		estado2.setCellValueFactory(new PropertyValueFactory<Automata1,String>("estado2"));
		orden1.setCellValueFactory(new PropertyValueFactory<Automata1,String>("ordenpila1"));
		orden2.setCellValueFactory(new PropertyValueFactory<Automata1,String>("ordenpila2"));
		orden3.setCellValueFactory(new PropertyValueFactory<Automata1,String>("ordenpila3"));
		orden4.setCellValueFactory(new PropertyValueFactory<Automata1,String>("ordenpila4"));

		tabla2.setEditable(true);
		
		Alfabeto();
		
		editado();
		
		
		
		//regla.addEventHandler(TableColumn.editCommitEvent(), handler);

		nombres2= Editar1.obtenerarchivos();

		ObservableList<String> options = 
				FXCollections.observableArrayList();	   

		for(int x=0;x<nombres2.size();x++)
		{

			options.add(nombres2.get(x));
			System.out.println(options.get(x) + " fd");
		}
		combobox2.setItems(options); 

		System.out.println("entro");
		
		
		nombres3= Editar1.obtenerarchivos1();

		ObservableList<String> options1 = 
				FXCollections.observableArrayList();	   

		for(int x=0;x<nombres3.size();x++)
		{

			options1.add(nombres3.get(x));
			System.out.println(options1.get(x) + " fd");
		}
		combobox3.setItems(options1);

		System.out.println("entro");

		//ArrayList<String> columnData = new ArrayList<>();

	}

	public void editado()
	{
		estado1.setCellFactory(TextFieldTableCell.<Automata1>forTableColumn());
		estado1.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata1, String>>() {
				       public void handle(CellEditEvent<Automata1, String> t) {((Automata1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEstado1(t.getNewValue());}});
		
		cadena.setCellFactory(TextFieldTableCell.<Automata1>forTableColumn());
		cadena.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata1, String>>() {
				       public void handle(CellEditEvent<Automata1, String> t) {((Automata1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCadenaletra(t.getNewValue());}});
		
		pila1.setCellFactory(TextFieldTableCell.<Automata1>forTableColumn());
		pila1.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata1, String>>() {
				       public void handle(CellEditEvent<Automata1, String> t) {((Automata1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCadenaPila1(t.getNewValue());}});
	
		pila2.setCellFactory(TextFieldTableCell.<Automata1>forTableColumn());
		pila2.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata1, String>>() {
				       public void handle(CellEditEvent<Automata1, String> t) {((Automata1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCadenaPila2(t.getNewValue());}});
		
		pila3.setCellFactory(TextFieldTableCell.<Automata1>forTableColumn());
		pila3.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata1, String>>() {
				       public void handle(CellEditEvent<Automata1, String> t) {((Automata1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCadenaPila3(t.getNewValue());}});
		
		pila4.setCellFactory(TextFieldTableCell.<Automata1>forTableColumn());
		pila4.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata1, String>>() {
				       public void handle(CellEditEvent<Automata1, String> t) {((Automata1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCadenaPila4(t.getNewValue());}});
		
		estado2.setCellFactory(TextFieldTableCell.<Automata1>forTableColumn());
		estado2.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata1, String>>() {
				       public void handle(CellEditEvent<Automata1, String> t) {((Automata1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEstado2(t.getNewValue());}});
	
		orden1.setCellFactory(TextFieldTableCell.<Automata1>forTableColumn());
		orden1.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata1, String>>() {
				       public void handle(CellEditEvent<Automata1, String> t) {((Automata1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOrdenpila1(t.getNewValue());}});
		
		orden2.setCellFactory(TextFieldTableCell.<Automata1>forTableColumn());
		orden2.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata1, String>>() {
				       public void handle(CellEditEvent<Automata1, String> t) {((Automata1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOrdenpila2(t.getNewValue());}});
		
		orden3.setCellFactory(TextFieldTableCell.<Automata1>forTableColumn());
		orden3.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata1, String>>() {
				       public void handle(CellEditEvent<Automata1, String> t) {((Automata1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOrderpila3(t.getNewValue());}});
		
		orden4.setCellFactory(TextFieldTableCell.<Automata1>forTableColumn());
		orden4.setOnEditCommit(
				new EventHandler<CellEditEvent<Automata1, String>>() {
				       public void handle(CellEditEvent<Automata1, String> t) {((Automata1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOrdenpila4(t.getNewValue());}});
	}
	
	@FXML
	TableColumn conjunto;
	@FXML
	TableColumn alfabetoauto;
	@FXML
	TableColumn alfabeto1;
	@FXML
	TableColumn alfabeto2;
	@FXML
	TableColumn alfabeto3;
	@FXML
	TableColumn alfabeto4;
	@FXML
	TableColumn estadoini;
	@FXML
	TableColumn estadofin;
	@FXML
	TableColumn sipila1;
	@FXML
	TableColumn sipila2;
	@FXML
	TableColumn sipila3;
	@FXML
	TableColumn sipila4;
	
	
	public void Alfabeto()
	{
		conjunto= new TableColumn("Conjunto finito");
		alfabetoauto= new TableColumn("Alfabeto del automata");
		alfabeto1= new TableColumn("Alfabeto 1");
		alfabeto2= new TableColumn("Alfabeto 2");
		alfabeto3= new TableColumn("Alfabeto 3");
		alfabeto4= new TableColumn("Alfabeto 4");
		estadoini= new TableColumn("Estado Inicial");
		estadofin= new TableColumn("Estado Fin");
		sipila1= new TableColumn("Pila 1");
		sipila2= new TableColumn("Pila 2");
		sipila3= new TableColumn("Pila 3");
		sipila4= new TableColumn("Pila 4");
		tabla3.getColumns().addAll(conjunto,alfabetoauto,alfabeto1,alfabeto2,alfabeto3,alfabeto4,estadoini,estadofin,sipila1,sipila2,sipila3,sipila4);



		conjunto.setCellValueFactory(new PropertyValueFactory<Automata1,Integer>("conjunto"));
		alfabetoauto.setCellValueFactory(new PropertyValueFactory<Automata1,String>("alfabetoauto"));
		alfabeto1.setCellValueFactory(new PropertyValueFactory<Automata1,String>("alfabeto1"));
		alfabeto2.setCellValueFactory(new PropertyValueFactory<Automata1,String>("alfabeto2"));
		alfabeto3.setCellValueFactory(new PropertyValueFactory<Automata1,String>("alfabeto3"));
		alfabeto4.setCellValueFactory(new PropertyValueFactory<Automata1,String>("alfabeto4"));
		estadoini.setCellValueFactory(new PropertyValueFactory<Automata1,String>("estadoini"));
		estadofin.setCellValueFactory(new PropertyValueFactory<Automata1,String>("estadofin"));
		sipila1.setCellValueFactory(new PropertyValueFactory<Automata1,String>("sipila1"));
		sipila2.setCellValueFactory(new PropertyValueFactory<Automata1,String>("sipila2"));
		sipila3.setCellValueFactory(new PropertyValueFactory<Automata1,String>("sipila3"));
		sipila4.setCellValueFactory(new PropertyValueFactory<Automata1,String>("sipila4"));
		

		tabla3.setEditable(true);
		
		conjunto.setCellFactory(TextFieldTableCell.<Alfabeto1>forTableColumn());
		conjunto.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setConjunto(t.getNewValue());}});
		
		alfabetoauto.setCellFactory(TextFieldTableCell.<Alfabeto1>forTableColumn());
		alfabetoauto.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAlfabetoauto(t.getNewValue());}});
		
		alfabeto1.setCellFactory(TextFieldTableCell.<Alfabeto1>forTableColumn());
		alfabeto1.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAlfabeto1(t.getNewValue());}});
		
		alfabeto2.setCellFactory(TextFieldTableCell.<Alfabeto1>forTableColumn());
		alfabeto2.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAlfabeto2(t.getNewValue());}});
		
		alfabeto3.setCellFactory(TextFieldTableCell.<Alfabeto1>forTableColumn());
		alfabeto3.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAlfabeto3(t.getNewValue());}});
		
		alfabeto4.setCellFactory(TextFieldTableCell.<Alfabeto1>forTableColumn());
		alfabeto4.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAlfabeto4(t.getNewValue());}});
		
		estadoini.setCellFactory(TextFieldTableCell.<Alfabeto>forTableColumn());
		estadoini.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEstadoini(t.getNewValue());}});
		
		estadofin.setCellFactory(TextFieldTableCell.<Alfabeto>forTableColumn());
		estadofin.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEstadofin(t.getNewValue());}});
		
		sipila1.setCellFactory(TextFieldTableCell.<Alfabeto1>forTableColumn());
		sipila1.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSipila1(t.getNewValue());}});
		
		sipila2.setCellFactory(TextFieldTableCell.<Alfabeto1>forTableColumn());
		sipila2.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSipila2(t.getNewValue());}});
		
		sipila3.setCellFactory(TextFieldTableCell.<Alfabeto1>forTableColumn());
		sipila3.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSipila3(t.getNewValue());}});
		
		sipila4.setCellFactory(TextFieldTableCell.<Alfabeto1>forTableColumn());
		sipila4.setOnEditCommit(
				new EventHandler<CellEditEvent<Alfabeto1, String>>() {
				       public void handle(CellEditEvent<Alfabeto1, String> t) {((Alfabeto1) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSipila4(t.getNewValue());}});
	}
}
