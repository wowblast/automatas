package application;

import javafx.beans.property.SimpleStringProperty;

public class Alfabeto 
{
	
	SimpleStringProperty conjunto;
	SimpleStringProperty alfabeto1;
	SimpleStringProperty alfabeto2;
	SimpleStringProperty estadoini;
	SimpleStringProperty estadosacept;
	
	public Alfabeto(String conjunto, String alfabeto1, String alfabeto2, String estadoini, String estadosacept)
	{
		this.conjunto = new SimpleStringProperty(conjunto);
		this.alfabeto1 = new SimpleStringProperty(alfabeto1);
		this.alfabeto2 = new SimpleStringProperty(alfabeto2);
		this.estadoini = new SimpleStringProperty(estadoini);
		this.estadosacept = new SimpleStringProperty(estadosacept);
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

	public String getEstadoini() {
		return estadoini.get();
	}

	public void setEstadoini(String estadoini) {
		this.estadoini.set(estadoini);
	}

	public String getEstadosacept() {
		return estadosacept.get();
	}

	public void setEstadosacept(String estadosacept) {
		this.estadosacept.set(estadosacept);
	}
}
