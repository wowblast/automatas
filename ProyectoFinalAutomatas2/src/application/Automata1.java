package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Automata1 {

	SimpleIntegerProperty numeroregla;
	SimpleStringProperty estado1;
	SimpleStringProperty  cadenaletra;
	SimpleStringProperty  cadenaPila1;
	SimpleStringProperty  cadenaPila2;
	SimpleStringProperty  cadenaPila3;
	SimpleStringProperty  cadenaPila4;
	SimpleStringProperty  estado2;
	SimpleStringProperty  ordenpila1;
	SimpleStringProperty  ordenpila2;
	SimpleStringProperty  ordenpila3;
	SimpleStringProperty  ordenpila4;
	
	public Automata1(int numeroregla, String estado1, String cadenaletra,
			String cadenaPila1, String cadenaPila2, String cadenaPila3, String cadenaPila4,
			String estado2, String orderpila1, String orderpila2, String orderpila3, String orderpila4) {

		this.numeroregla =new SimpleIntegerProperty(numeroregla);
		this.estado1 = new SimpleStringProperty(estado1);
		this.cadenaletra = new SimpleStringProperty( cadenaletra);
		this.cadenaPila1 =  new SimpleStringProperty(cadenaPila1);
		this.cadenaPila2 =  new SimpleStringProperty(cadenaPila2);
		this.cadenaPila3 =  new SimpleStringProperty(cadenaPila3);
		this.cadenaPila4 =  new SimpleStringProperty(cadenaPila4);
		this.estado2 =  new SimpleStringProperty(estado2);
		this.ordenpila1 =  new SimpleStringProperty(orderpila1);
		this.ordenpila2 =  new SimpleStringProperty(orderpila2);
		this.ordenpila3 =  new SimpleStringProperty(orderpila3);
		this.ordenpila4 =  new SimpleStringProperty(orderpila4);
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
	
	public String getCadenaPila1() {
		return cadenaPila1.get();
	}
	public void setCadenaPila1(String cadenaPila1) {
		this.cadenaPila1.set(cadenaPila1);
	}
	
	public String getCadenaPila2() {
		return cadenaPila2.get();
	}
	public void setCadenaPila2(String cadenaPila2) {
		this.cadenaPila2.set(cadenaPila2);
	}
	
	public String getCadenaPila3() {
		return cadenaPila3.get();
	}
	public void setCadenaPila3(String cadenaPila3) {
		this.cadenaPila3.set(cadenaPila3);
	}
	
	public String getCadenaPila4() {
		return cadenaPila4.get();
	}
	public void setCadenaPila4(String cadenaPila4) {
		this.cadenaPila4.set(cadenaPila4);
	}
	
	public String getEstado2() {
		return estado2.get();
	}
	public void setEstado2(String estado2) {
		this.estado2.set(estado2);
	}
	
	public String getOrdenpila1() {
		return ordenpila1.get();
	}
	public void setOrdenpila1(String ordenpila1) {
		this.ordenpila1.set(ordenpila1);
	}
	
	public String getOrdenpila2() {
		return ordenpila2.get();
	}
	public void setOrdenpila2(String ordenpila2) {
		this.ordenpila2.set(ordenpila2);
	}
	
	public String getOrdenpila3() {
		return ordenpila3.get();
	}
	public void setOrderpila3(String ordenpila3) {
		this.ordenpila3.set(ordenpila3);
	}
	
	public String getOrdenpila4() {
		return ordenpila4.get();
	}
	public void setOrdenpila4(String ordenpila4) {
		this.ordenpila4.set(ordenpila4);
	}

}
