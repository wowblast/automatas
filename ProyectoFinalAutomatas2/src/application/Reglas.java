package application;

import javafx.beans.property.SimpleStringProperty;

public class Reglas {

	public SimpleStringProperty numregla;
	public SimpleStringProperty estado;
	public SimpleStringProperty entrada;
	public SimpleStringProperty topepila;
	public SimpleStringProperty futestado;
	public SimpleStringProperty accion;
	
	public Reglas(String numregla, String estado, String entrada, String topepila, String futestado, String accion)
	{
		this.numregla = new SimpleStringProperty(numregla);
		this.estado = new SimpleStringProperty(estado);
		this.entrada = new SimpleStringProperty(entrada);
		this.topepila = new SimpleStringProperty(topepila);
		this.futestado = new SimpleStringProperty(futestado);
		this.accion = new SimpleStringProperty(accion);
	}


	public String getNumregla() {
		return numregla.get();
	}

	public void setNumregla(String numregla) {
		this.numregla = new SimpleStringProperty(numregla);
	}

	public String getEstado() {
		return estado.get();
	}

	public void setEstado(String estado) {
		this.estado = new SimpleStringProperty(estado);
	}

	public String getEntrada() {
		return entrada.get();
	}

	public void setEntrada(String entrada) {
		this.entrada = new SimpleStringProperty(entrada);
	}

	public String getTopepila() {
		return topepila.get();
	}

	public void setTopepila(String topepila) {
		this.topepila = new SimpleStringProperty(topepila);
	}

	public String getFutestado() {
		return futestado.get();
	}

	public void setFutestado(String futestado) {
		this.futestado = new SimpleStringProperty(futestado);
	}

	public String getAccion() {
		return accion.get();
	}

	public void setAccion(String accion) {
		this.accion = new SimpleStringProperty(accion);
	}


	
	
	
	
}
