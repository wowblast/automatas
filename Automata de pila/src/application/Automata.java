package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Automata {

	SimpleIntegerProperty numeroregla;
	SimpleStringProperty estado1;
	SimpleStringProperty  cadenaletra;
	SimpleStringProperty  cadenaPila;
	SimpleStringProperty  estado2;
	SimpleStringProperty  ordenpila;
	public Automata(int numeroregla, String estado1, String cadenaletra,
			String cadenaPila, String estado2, String orderpila) {

		this.numeroregla =new SimpleIntegerProperty(numeroregla);
		this.estado1 = new SimpleStringProperty(estado1);
		this.cadenaletra = new SimpleStringProperty( cadenaletra);
		this.cadenaPila =  new SimpleStringProperty(cadenaPila);
		this.estado2 =  new SimpleStringProperty(estado2);
		this.ordenpila =  new SimpleStringProperty(orderpila);
	}
	public int getNumeroregla() {
		return numeroregla.get();
	}
	public void setNumeroregla(int  numeroregla) {
		this.numeroregla.set(numeroregla);
	}
	public String getEstado1() {
		return estado1.get();
	}
	public void setEstado1(String estado1) {
		this.estado1.set(estado1);
	}
	public String getCadenaletra() {
		return cadenaletra.get();
	}
	public void setCadenaletra(String cadenaletra) {
		this.cadenaletra.set(cadenaletra);
	}
	public String getCadenaPila() {
		return cadenaPila.get();
	}
	public void setCadenaPila(String cadenaPila) {
		this.cadenaPila.set(cadenaPila);;
	}
	public String getEstado2() {
		return estado2.get();
	}
	public void setEstado2(String estado2) {
		this.estado2.set(estado2);
	}
	public String getOrderpila() {
		return ordenpila.get();
	}
	public void setOrderpila(String orderpila) {
		this.ordenpila.set(orderpila);
	}

}
