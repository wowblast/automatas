package application;

import javafx.beans.property.SimpleStringProperty;

public class Alfabeto1 
{
	
	SimpleStringProperty conjunto;
	SimpleStringProperty alfabetoauto;
	SimpleStringProperty alfabeto1;
	SimpleStringProperty alfabeto2;
	SimpleStringProperty alfabeto3;
	SimpleStringProperty alfabeto4;
	SimpleStringProperty estadoini;
	SimpleStringProperty estadofin;
	SimpleStringProperty sipila1;
	SimpleStringProperty sipila2;
	SimpleStringProperty sipila3;
	SimpleStringProperty sipila4;
	
	public Alfabeto1(String conjunto, String alfabetoauto , String alfabeto1, String alfabeto2, 
			String alfabeto3, String alfabeto4, String estadoini, String estadofin, String sipila1, String sipila2, 
			String sipila3, String sipila4)
	{
		this.conjunto = new SimpleStringProperty(conjunto);
		this.alfabetoauto = new SimpleStringProperty(alfabetoauto);
		this.alfabeto1 = new SimpleStringProperty(alfabeto1);
		this.alfabeto2 = new SimpleStringProperty(alfabeto2);
		this.alfabeto3 = new SimpleStringProperty(alfabeto3);
		this.alfabeto4 = new SimpleStringProperty(alfabeto4);
		this.estadoini = new SimpleStringProperty(estadoini);
		this.estadoini = new SimpleStringProperty(estadofin);
		this.sipila1 = new SimpleStringProperty(sipila1);
		this.sipila2 = new SimpleStringProperty(sipila2);
		this.sipila3 = new SimpleStringProperty(sipila3);
		this.sipila4 = new SimpleStringProperty(sipila4);
	}

	public String getConjunto() {
		return conjunto.get();
	}

	public void setConjunto(String conjunto) {
		this.conjunto.set(conjunto);
	}

	public String getAlfabeto1() {
		return alfabeto1.get();
	}

	public void setAlfabeto1(String alfabeto1) {
		this.alfabeto1.set(alfabeto1);
	}

	public String getAlfabeto2() {
		return alfabeto2.get();
	}

	public void setAlfabeto2(String alfabeto2) {
		this.alfabeto2.set(alfabeto2);
	}

	public String getAlfabeto3() {
		return alfabeto3.get();
	}

	public void setAlfabeto3(String alfabeto3) {
		this.alfabeto3.set(alfabeto3);
	}
	
	public String getAlfabeto4() {
		return alfabeto4.get();
	}

	public void setAlfabeto4(String alfabeto4) {
		this.alfabeto4.set(alfabeto4);
	}
	
	public String getEstadoini() {
		return estadoini.get();
	}

	public void setEstadoini(String estadoini) {
		this.estadoini.set(estadoini);
	}
	
	public String getEstadofin() {
		return estadofin.get();
	}

	public void setEstadofin(String estadofin) {
		this.estadofin.set(estadofin);
	}

	public String getSipila1() {
		return sipila1.get();
	}

	public void setSipila1(String sipila1) {
		this.sipila1.set(sipila1);
	}
	
	public String getSipila2() {
		return sipila2.get();
	}

	public void setSipila2(String sipila2) {
		this.sipila2.set(sipila2);
	}
	
	public String getSipila3() {
		return sipila3.get();
	}

	public void setSipila3(String sipila3) {
		this.sipila3.set(sipila3);
	}
	
	public String getSipila4() {
		return sipila4.get();
	}

	public void setSipila4(String sipila4) {
		this.sipila4.set(sipila4);
	}
	
	public String getAlfabetoauto() {
		return sipila4.get();
	}

	public void setAlfabetoauto(String alfabetoauto) {
		this.alfabetoauto.set(alfabetoauto);
	}
}
