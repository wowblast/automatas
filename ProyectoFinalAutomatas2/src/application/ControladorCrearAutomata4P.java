package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class ControladorCrearAutomata4P implements Initializable{

	//ID de la tabla y Columnas
	@FXML public TableView<Reglas4P> tblviewReglas4P;
	@FXML public TableColumn<Reglas4P, String> clmnumregla;
	@FXML public TableColumn<Reglas4P, String> clmEstado;
	@FXML public TableColumn<Reglas4P, String> clmEntrada;
	@FXML public TableColumn<Reglas4P, String> clmTopePila1;
	@FXML public TableColumn<Reglas4P, String> clmTopePila2;
	@FXML public TableColumn<Reglas4P, String> clmTopePila3;
	@FXML public TableColumn<Reglas4P, String> clmTopePila4;
	@FXML public TableColumn<Reglas4P, String> clmFuturoEstado;
	@FXML public TableColumn<Reglas4P, String> clmAccion1;
	@FXML public TableColumn<Reglas4P, String> clmAccion2;
	@FXML public TableColumn<Reglas4P, String> clmAccion3;
	@FXML public TableColumn<Reglas4P, String> clmAccion4;

	//ID de los TextFields
	@FXML public TextField txtNumRegla;
	@FXML public TextField txtEstado;
	@FXML public TextField txtEntrada;
	@FXML public TextField txtTopePila1;
	@FXML public TextField txtTopePila2;
	@FXML public TextField txtTopePila3;
	@FXML public TextField txtTopePila4;
	@FXML public TextField txtFutEstado;
	@FXML public TextField txtAccion1;
	@FXML public TextField txtAccion2;
	@FXML public TextField txtAccion3;
	@FXML public TextField txtAccion4;
	@FXML public TextField txtNombreAutomata;
	
	String Verificar1 = "";
	String Verificar2 = "";
	String Verificar3 = "";
	String Verificar4 = "";
	String Verificar44 = "";
	String Verificar444 = "";
	String Verificar4444 = "";
	String Verificar5 = "";
	String Verificar55 = "";
	String Verificar555 = "";
	String Verificar5555 = "";

	
	public void addregla()
	{	

		
		//Verifica si la entrada pertenece al Alfabeto
			for(int i=0; i < Verificacion.alfabetoAuto4P.length; i++ )
			{
				if(Verificacion.alfabetoAuto4P[i].equals(txtEntrada.getText()))
				{
					Verificar1 = "true";
					break;
				}
				else
				{
					Verificar1 = "false";
				}
			}
		
		//Verifica el estado si pertenece
		for(int i=0; i < Verificacion.ConjuntoEstados4P.length; i++)
		{
			if(Verificacion.ConjuntoEstados4P[i].equals(txtEstado.getText()))
			{
				Verificar2 = "true";
				break;
			}
			else
			{
				Verificar2 = "false";
			}
		}
		
		//Verifica si el futuro estado pertenece al conjunto de Estados
		for(int i=0; i < Verificacion.ConjuntoEstados4P.length; i++)
		{
			if(Verificacion.ConjuntoEstados4P[i].equals(txtFutEstado.getText()))
			{
				Verificar3 = "true";
				break;
			}
			else
			{
				Verificar3 = "false";
			}
		}
		
		//Verifica si el Tope de Pila 1 pertenece al estado
		for(int i=0; i < Verificacion.AlfabetoPila1.length; i++)
		{

			if(txtTopePila1.getText().equals(Verificacion.AlfabetoPila1[i]+"Z")||txtTopePila1.getText().equals(Verificacion.AlfabetoPila1[i])
					|| txtTopePila1.getText().equals(Verificacion.AlfabetoPila1[i]+Verificacion.SimboloInicial1[0])|| txtTopePila1.getText().equals(Verificacion.SimboloInicial[0])
					|| txtTopePila1.getText().equals("Z"))
			{
				Verificar4 = "true";
				break;
			}
			else
			{
				Verificar4 = "false";				
			}
		}
		
		//Verifica si el Tope de Pila 2 pertenece al estado
				for(int i=0; i < Verificacion.AlfabetoPila2.length; i++)
				{

					if(txtTopePila2.getText().equals(Verificacion.AlfabetoPila2[i]+"Z")||txtTopePila2.getText().equals(Verificacion.AlfabetoPila2[i])
							|| txtTopePila2.getText().equals(Verificacion.AlfabetoPila2[i]+Verificacion.SimboloInicial2[0])|| txtTopePila2.getText().equals(Verificacion.SimboloInicial2[0])
							|| txtTopePila2.getText().equals("Z"))
					{
						Verificar44 = "true";
						break;
					}
					else
					{
						Verificar44 = "false";				
					}
				}
				//Verifica si el Tope de Pila 3 pertenece al estado
				for(int i=0; i < Verificacion.AlfabetoPila3.length; i++)
				{

					if(txtTopePila3.getText().equals(Verificacion.AlfabetoPila3[i]+"Z")||txtTopePila3.getText().equals(Verificacion.AlfabetoPila3[i])
							|| txtTopePila3.getText().equals(Verificacion.AlfabetoPila3[i]+Verificacion.SimboloInicial3[0])|| txtTopePila3.getText().equals(Verificacion.SimboloInicial3[0])
							|| txtTopePila3.getText().equals("Z"))
					{
						Verificar444 = "true";
						break;
					}
					else
					{
						Verificar444 = "false";				
					}
				}	
				
				//Verifica si el Tope de Pila 4 pertenece al estado
				for(int i=0; i < Verificacion.AlfabetoPila4.length; i++)
				{

					if(txtTopePila4.getText().equals(Verificacion.AlfabetoPila4[i]+"Z")||txtTopePila4.getText().equals(Verificacion.AlfabetoPila4[i])
							|| txtTopePila4.getText().equals(Verificacion.AlfabetoPila4[i]+Verificacion.SimboloInicial4[0])|| txtTopePila4.getText().equals(Verificacion.SimboloInicial4[0])
							|| txtTopePila4.getText().equals("Z"))
					{
						Verificar4444 = "true";
						break;
					}
					else
					{
						Verificar4444 = "false";				
					}
				}	
 
		
		//Verifica si la Accion 1 pertenece al Alfabeto de la Pila 1
		
		for(int i=0; i < Verificacion.AlfabetoPila1.length; i++)
		{

			if(txtAccion1.getText().equals("D")||txtAccion1.getText().equals(Verificacion.AlfabetoPila1[i])
					|| txtAccion1.getText().equals(Verificacion.AlfabetoPila1[i]+Verificacion.SimboloInicial1[0])|| txtAccion1.getText().equals(Verificacion.AlfabetoPila1[i]+"Z"))
			{
				Verificar5 = "true";
				break;
			}
			else
			{
				Verificar5 = "false";
			}
		}
		
		//Verifica si la Accion 2 pertenece al Alfabeto de la Pila 2
		
				for(int i=0; i < Verificacion.AlfabetoPila2.length; i++)
				{

					if(txtAccion2.getText().equals("D")||txtAccion2.getText().equals(Verificacion.AlfabetoPila2[i])
							|| txtAccion2.getText().equals(Verificacion.AlfabetoPila2[i]+Verificacion.SimboloInicial2[0])|| txtAccion2.getText().equals(Verificacion.AlfabetoPila2[i]+"Z"))
					{
						Verificar55 = "true";
						break;
					}
					else
					{
						Verificar55 = "false";
					}
				}
				
				//Verifica si la Accion 3 pertenece al Alfabeto de la Pila 3
				
				for(int i=0; i < Verificacion.AlfabetoPila3.length; i++)
				{

					if(txtAccion3.getText().equals("D")||txtAccion3.getText().equals(Verificacion.AlfabetoPila3[i])
							|| txtAccion3.getText().equals(Verificacion.AlfabetoPila3[i]+Verificacion.SimboloInicial3[0])|| txtAccion3.getText().equals(Verificacion.AlfabetoPila3[i]+"Z"))
					{
						Verificar555 = "true";
						break;
					}
					else
					{
						Verificar555 = "false";
					}
				}
				
				//Verifica si la Accion 4 pertenece al Alfabeto de la Pila 4
				
				for(int i=0; i < Verificacion.AlfabetoPila4.length; i++)
				{

					if(txtAccion4.getText().equals("D")||txtAccion4.getText().equals(Verificacion.AlfabetoPila4[i])
							|| txtAccion4.getText().equals(Verificacion.AlfabetoPila4[i]+Verificacion.SimboloInicial4[0])|| txtAccion4.getText().equals(Verificacion.AlfabetoPila4[i]+"Z"))
					{
						Verificar5555 = "true";
						break;
					}
					else
					{
						Verificar5555 = "false";
					}
				}
		
		
		if(Verificar1.equals("true") && Verificar2.equals("true") && Verificar3.equals("true") && Verificar4.equals("true") 
				&& Verificar44.equals("true") && Verificar444.equals("true") && Verificar4444.equals("true") 
				&& Verificar5.equals("true") && Verificar55.equals("true") && Verificar555.equals("true") && Verificar5555.equals("true"))
		{
			
			//Agrega a la tabla
			Reglas4P nuevaRegla4P = new Reglas4P(txtNumRegla.getText(), txtEstado.getText(), txtEntrada.getText(), 
					                        txtTopePila1.getText(), txtTopePila2.getText(),  txtTopePila3.getText(),
					                        txtTopePila4.getText(),txtFutEstado.getText(), txtAccion1.getText(), 
					                        txtAccion2.getText(), txtAccion3.getText(), txtAccion4.getText());
			
			tblviewReglas4P.getItems().add(nuevaRegla4P);
			
			//Lo pone en blanco los text fields
			txtNumRegla.setText("");
			txtEstado.setText("");
			txtEntrada.setText("");
			txtTopePila1.setText("");
			txtTopePila2.setText("");
			txtTopePila3.setText("");
			txtTopePila4.setText("");
			txtFutEstado.setText("");
			txtAccion1.setText("");
			txtAccion2.setText("");
			txtAccion3.setText("");
			txtAccion4.setText("");

		}
		else
		{
			if(Verificar1.equals("false"))
			{
			System.out.println(txtEntrada.getText() + " No pertenece al Alfabeto del Automata");
			}
			if(Verificar2.equals("false"))
			{
			System.out.println(txtEstado.getText() + " No pertenece al Alfabeto del Automata");
			}
			if(Verificar3.equals("false"))
			{
			System.out.println(txtFutEstado.getText()+" No pertenece al Alfabeto del Automata");
			}
			if(Verificar4.equals("false"))
			{
			System.out.println(txtTopePila1.getText() + " No pertenece al Alfabeto de la Pila o el Simbolo Inicial");
			}
			if(Verificar44.equals("false"))
			{
			System.out.println(txtTopePila2.getText() + " No pertenece al Alfabeto de la Pila o el Simbolo Inicial");
			}
			if(Verificar444.equals("false"))
			{
			System.out.println(txtTopePila3.getText() + " No pertenece al Alfabeto de la Pila o el Simbolo Inicial");
			}
			if(Verificar4444.equals("false"))
			{
			System.out.println(txtTopePila4.getText() + " No pertenece al Alfabeto de la Pila o el Simbolo Inicial");
			}
			if(Verificar5.equals("false"))
			{
			System.out.println(txtAccion1.getText() + " No pertenece al Alfabeto de la Pila");
			}
			if(Verificar55.equals("false"))
			{
			System.out.println(txtAccion2.getText() + " No pertenece al Alfabeto de la Pila");
			}
			if(Verificar555.equals("false"))
			{
			System.out.println(txtAccion3.getText() + " No pertenece al Alfabeto de la Pila");
			}
			if(Verificar5555.equals("false"))
			{
			System.out.println(txtAccion4.getText() + " No pertenece al Alfabeto de la Pila");
			}
			System.out.println(" ");
			
		}

		
	}
	
	public void guardarReglas(ActionEvent event) throws IOException
	{
		Reglas4P regla = new Reglas4P(null, null, null, null, null, null, null, null, null, null, null, null);
		List<List<String>> arrList = new ArrayList();
		
		File file = new File(txtNombreAutomata.getText()+"reglas4P_al.txt");
		FileWriter fileWriter = new FileWriter(file);
		for(int i=0; i<tblviewReglas4P.getItems().size(); i++)
		{
			regla = tblviewReglas4P.getItems().get(i);
			arrList.add(new ArrayList<>());
			arrList.get(i).add(regla.getNumregla()+","+ regla.getEstado()+"," + regla.getEntrada()+ "," +
			              regla.getTopepila1()+ "," + regla.getTopepila2()+ ","+ regla.getTopepila3()+","
			              +regla.getTopepila4()+","+regla.getFutestado()+","+regla.getAccion1() +","+regla.getAccion2()
			              +","+regla.getAccion3() +","+regla.getAccion4());
		}
		
		for(int i=0; i<arrList.size(); i++)
		{
			for(int j=0; j<arrList.get(i).size();j++)
			{
				System.out.println(arrList.get(i).get(j));
				fileWriter.write("\n"+arrList.get(i).get(j));
			}
		}
		fileWriter.flush();
		fileWriter.close();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		clmnumregla.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("numregla"));
		clmEstado.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("estado"));
		clmEntrada.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("entrada"));
		clmTopePila1.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("topepila"));
		clmTopePila2.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("topepila"));
		clmTopePila3.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("topepila"));
		clmTopePila4.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("topepila"));
		clmFuturoEstado.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("futestado"));
		clmAccion1.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("accion"));
		clmAccion2.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("accion"));
		clmAccion3.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("accion"));
		clmAccion4.setCellValueFactory(new PropertyValueFactory<Reglas4P, String>("accion"));


		tblviewReglas4P.setEditable(true);
		clmnumregla.setCellFactory(TextFieldTableCell.forTableColumn());
		clmEstado.setCellFactory(TextFieldTableCell.forTableColumn());
		clmEntrada.setCellFactory(TextFieldTableCell.forTableColumn());
		clmTopePila1.setCellFactory(TextFieldTableCell.forTableColumn());
		clmTopePila2.setCellFactory(TextFieldTableCell.forTableColumn());
		clmTopePila3.setCellFactory(TextFieldTableCell.forTableColumn());
		clmTopePila4.setCellFactory(TextFieldTableCell.forTableColumn());
		clmFuturoEstado.setCellFactory(TextFieldTableCell.forTableColumn());
		clmAccion1.setCellFactory(TextFieldTableCell.forTableColumn());
		clmAccion2.setCellFactory(TextFieldTableCell.forTableColumn());
		clmAccion3.setCellFactory(TextFieldTableCell.forTableColumn());
		clmAccion4.setCellFactory(TextFieldTableCell.forTableColumn());
	
	}
	
	//Metodos para poder editar detro del table view
		@SuppressWarnings("rawtypes")
		public void editarNumRegla(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectNum = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectNum.setNumregla((String) edditedCell.getNewValue());
		}
		
		public void editarEstado(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectEst = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectEst.setEstado((String) edditedCell.getNewValue());
		}
		
		public void editarEntrada(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectEnt = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectEnt.setEntrada((String) edditedCell.getNewValue());
		}
		
		public void editarTopePila1(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectTope = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectTope.setTopepila1((String) edditedCell.getNewValue());
		}
		public void editarTopePila2(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectTope = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectTope.setTopepila2((String) edditedCell.getNewValue());
		}
		public void editarTopePila3(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectTope = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectTope.setTopepila3((String) edditedCell.getNewValue());
		}
		public void editarTopePila4(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectTope = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectTope.setTopepila4((String) edditedCell.getNewValue());
		}
		
		public void editarFutEstado(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectFut = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectFut.setFutestado((String) edditedCell.getNewValue());
		}
		
		public void editarAccion1(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectAcc = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectAcc.setAccion1((String) edditedCell.getNewValue());
		}
		public void editarAccion2(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectAcc = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectAcc.setAccion2((String) edditedCell.getNewValue());
		}public void editarAccion3(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectAcc = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectAcc.setAccion3((String) edditedCell.getNewValue());
		}public void editarAccion4(CellEditEvent edditedCell)
		{
			Reglas4P ReglaSelectAcc = tblviewReglas4P.getSelectionModel().getSelectedItem();
			ReglaSelectAcc.setAccion4((String) edditedCell.getNewValue());
		}
	
}
