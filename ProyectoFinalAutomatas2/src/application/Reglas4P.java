package application;

import javafx.beans.property.SimpleStringProperty;

public class Reglas4P {
	public SimpleStringProperty numregla;
	public SimpleStringProperty estado;
	public SimpleStringProperty entrada;
	public SimpleStringProperty topepila1;
	public SimpleStringProperty topepila2;
	public SimpleStringProperty topepila3;
	public SimpleStringProperty topepila4;
	public SimpleStringProperty futestado;
	public SimpleStringProperty accion1;
	public SimpleStringProperty accion2;
	public SimpleStringProperty accion3;
	public SimpleStringProperty accion4;

	
	public Reglas4P(String numregla, String estado, String entrada, String topepila1, String topepila2, String topepila3, 
			String topepila4, String futestado, String accion1, String accion2, String accion3, String accion4)
	{
		this.numregla = new SimpleStringProperty(numregla);
		this.estado = new SimpleStringProperty(estado);
		this.entrada = new SimpleStringProperty(entrada);
		this.topepila1 = new SimpleStringProperty(topepila1);
		this.topepila2 = new SimpleStringProperty(topepila2);
		this.topepila3 = new SimpleStringProperty(topepila3);
		this.topepila4 = new SimpleStringProperty(topepila4);
		this.futestado = new SimpleStringProperty(futestado);
		this.accion1 = new SimpleStringProperty(accion1);
		this.accion2 = new SimpleStringProperty(accion2);
		this.accion3 = new SimpleStringProperty(accion3);
		this.accion4 = new SimpleStringProperty(accion4);
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

	public String getTopepila1() {
		return topepila1.get();
	}

	public void setTopepila1(String topepila1) {
		this.topepila1 = new SimpleStringProperty(topepila1);
	}
	public String getTopepila2() {
		return topepila2.get();
	}

	public void setTopepila2(String topepila2) {
		this.topepila2 = new SimpleStringProperty(topepila2);
	}
	public String getTopepila3() {
		return topepila3.get();
	}

	public void setTopepila3(String topepila3) {
		this.topepila3 = new SimpleStringProperty(topepila3);
	}
	public String getTopepila4() {
		return topepila4.get();
	}

	public void setTopepila4(String topepila4) {
		this.topepila4 = new SimpleStringProperty(topepila4);
	}
	public String getFutestado() {
		return futestado.get();
	}

	public void setFutestado(String futestado) {
		this.futestado = new SimpleStringProperty(futestado);
	}

	public String getAccion1() {
		return accion1.get();
	}

	public void setAccion1(String accion1) {
		this.accion1 = new SimpleStringProperty(accion1);
	}
	public String getAccion2() {
		return accion2.get();
	}

	public void setAccion2(String accion2) {
		this.accion2 = new SimpleStringProperty(accion2);
	}
	public String getAccion3() {
		return accion1.get();
	}

	public void setAccion3(String accion3) {
		this.accion3 = new SimpleStringProperty(accion3);
	}
	public String getAccion4() {
		return accion4.get();
	}

	public void setAccion4(String accion4) {
		this.accion4 = new SimpleStringProperty(accion4);
	}
	
}
