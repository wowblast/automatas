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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class ControladorCrearAutomata implements Initializable{
	
	@FXML public TableView<Reglas> tblviewReglas;
	@FXML public TableColumn<Reglas, String> clmnumregla;
	@FXML public TableColumn<Reglas, String> clmEstado;
	@FXML public TableColumn<Reglas, String> clmEntrada;
	@FXML public TableColumn<Reglas, String> clmTopePila;
	@FXML public TableColumn<Reglas, String> clmFuturoEstado;
	@FXML public TableColumn<Reglas, String> clmAccion;
	
	@FXML public TextField txtNumRegla;
	@FXML public TextField txtEstado;
	@FXML public TextField txtEntrada;
	@FXML public TextField txtTopePila;
	@FXML public TextField txtFutEstado;
	@FXML public TextField txtAccion;
	@FXML public TextField txtNombreAutomata;
		
	String Verificar1 = "";
	String Verificar2 = "";
	String Verificar3 = "";
	String Verificar4 = "";
	String Verificar5 = "";



	public void addregla()
	{	

		
		//Verifica si la entrada pertenece al Alfabeto
			for(int i=0; i < Verificacion.alfabetoAuto.length; i++ )
			{
				if(Verificacion.alfabetoAuto[i].equals(txtEntrada.getText()))
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
		for(int i=0; i < Verificacion.ConjuntoEstados.length; i++)
		{
			if(Verificacion.ConjuntoEstados[i].equals(txtEstado.getText()))
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
		for(int i=0; i < Verificacion.ConjuntoEstados.length; i++)
		{
			if(Verificacion.ConjuntoEstados[i].equals(txtFutEstado.getText()))
			{
				Verificar3 = "true";
				break;
			}
			else
			{
				Verificar3 = "false";
			}
		}
		
		//Verifica si el Tope de Pila pertenece al estado
		for(int i=0; i < Verificacion.AlfabetoPila.length; i++)
		{

			if(txtTopePila.getText().equals(Verificacion.AlfabetoPila[i]+"Z")||txtTopePila.getText().equals(Verificacion.AlfabetoPila[i])
					|| txtTopePila.getText().equals(Verificacion.AlfabetoPila[i]+Verificacion.SimboloInicial[0])|| txtTopePila.getText().equals(Verificacion.SimboloInicial[0])
					|| txtTopePila.getText().equals("Z"))
			{
				Verificar4 = "true";
				break;

			}
			else
			{
				Verificar4 = "false";				
			}
		}
		
		//Verifica si la Accion pertenece al Alfabeto de la Pila
		
		for(int i=0; i < Verificacion.AlfabetoPila.length; i++)
		{

			if(txtAccion.getText().equals("D")||txtAccion.getText().equals(Verificacion.AlfabetoPila[i])
					|| txtAccion.getText().equals(Verificacion.AlfabetoPila[i]+Verificacion.SimboloInicial[0])|| txtAccion.getText().equals(Verificacion.AlfabetoPila[i]+"Z"))
			{
				Verificar5 = "true";
				break;
			}
			else
			{
				Verificar5 = "false";
			}
		}
		
		
		if(Verificar1.equals("true") && Verificar2.equals("true") && Verificar3.equals("true") && Verificar4.equals("true") && Verificar5.equals("true"))
		{
			
			//Agrega a la tabla
			Reglas nuevaRegla = new Reglas(txtNumRegla.getText(), txtEstado.getText(), txtEntrada.getText(), 
					                        txtTopePila.getText(), txtFutEstado.getText(), txtAccion.getText());
			
			tblviewReglas.getItems().add(nuevaRegla);
			
			//Lo pone en blanco los text fields
			txtNumRegla.setText("");
			txtEstado.setText("");
			txtEntrada.setText("");
			txtTopePila.setText("");
			txtFutEstado.setText("");
			txtAccion.setText("");
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
			System.out.println(txtTopePila.getText() + " No pertenece al Alfabeto de la Pila o el Simbolo Inicial");
			}
			if(Verificar5.equals("false"))
			{
			System.out.println(txtAccion.getText() + " No pertenece al Alfabeto de la Pila");
			}
			System.out.println(" ");
			
		}

		
	}
	
	public void guardarReglas(ActionEvent event) throws IOException
	{
		Reglas regla = new Reglas(null, null, null, null, null, null);
		List<List<String>> arrList = new ArrayList();
		
		File file = new File(txtNombreAutomata.getText()+"reglas_al.txt");
		FileWriter fileWriter = new FileWriter(file);
		for(int i=0; i<tblviewReglas.getItems().size(); i++)
		{
			regla = tblviewReglas.getItems().get(i);
			arrList.add(new ArrayList<>());
			arrList.get(i).add(regla.getNumregla()+","+ regla.getEstado()+"," + regla.getEntrada()+
			              regla.getTopepila()+","+regla.getFutestado()+","+regla.getAccion());
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
		
		clmnumregla.setCellValueFactory(new PropertyValueFactory<Reglas, String>("numregla"));
		clmEstado.setCellValueFactory(new PropertyValueFactory<Reglas, String>("estado"));
		clmEntrada.setCellValueFactory(new PropertyValueFactory<Reglas, String>("entrada"));
		clmTopePila.setCellValueFactory(new PropertyValueFactory<Reglas, String>("topepila"));
		clmFuturoEstado.setCellValueFactory(new PropertyValueFactory<Reglas, String>("futestado"));
		clmAccion.setCellValueFactory(new PropertyValueFactory<Reglas, String>("accion"));

		tblviewReglas.setEditable(true);
		clmnumregla.setCellFactory(TextFieldTableCell.forTableColumn());
		clmEstado.setCellFactory(TextFieldTableCell.forTableColumn());
		clmEntrada.setCellFactory(TextFieldTableCell.forTableColumn());
		clmTopePila.setCellFactory(TextFieldTableCell.forTableColumn());
		clmFuturoEstado.setCellFactory(TextFieldTableCell.forTableColumn());
		clmAccion.setCellFactory(TextFieldTableCell.forTableColumn());
		
	}
	
	//Metodos para poder editar detro del table view
	@SuppressWarnings("rawtypes")
	public void editarNumRegla(CellEditEvent edditedCell)
	{
		Reglas ReglaSelectNum = tblviewReglas.getSelectionModel().getSelectedItem();
		ReglaSelectNum.setNumregla((String) edditedCell.getNewValue());
	}
	
	public void editarEstado(CellEditEvent edditedCell)
	{
		Reglas ReglaSelectEst = tblviewReglas.getSelectionModel().getSelectedItem();
		ReglaSelectEst.setEstado((String) edditedCell.getNewValue());
	}
	
	public void editarEntrada(CellEditEvent edditedCell)
	{
		Reglas ReglaSelectEnt = tblviewReglas.getSelectionModel().getSelectedItem();
		ReglaSelectEnt.setEntrada((String) edditedCell.getNewValue());
	}
	
	public void editarTopePila(CellEditEvent edditedCell)
	{
		Reglas ReglaSelectTope = tblviewReglas.getSelectionModel().getSelectedItem();
		ReglaSelectTope.setTopepila((String) edditedCell.getNewValue());
	}
	
	public void editarFutEstado(CellEditEvent edditedCell)
	{
		Reglas ReglaSelectFut = tblviewReglas.getSelectionModel().getSelectedItem();
		ReglaSelectFut.setFutestado((String) edditedCell.getNewValue());
	}
	
	public void editarAccion(CellEditEvent edditedCell)
	{
		Reglas ReglaSelectAcc = tblviewReglas.getSelectionModel().getSelectedItem();
		ReglaSelectAcc.setAccion((String) edditedCell.getNewValue());
	}
	

}
