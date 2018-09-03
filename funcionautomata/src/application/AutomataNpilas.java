package application;


import java.util.ArrayList;


public class AutomataNpilas {

	Automata autoreglas;
	static ArrayList <Automata> reglas=new ArrayList<Automata>();

	static boolean camino=true;
	int numeroregla;
	String estado1;
	String cadenaletra;
	String cadenaPila1;
	String cadenaPila2;
	String cadenaPila3;
	String cadenaPila4;
	String estaodo2;
	String orderpila1;
	String orderpila2;
	String orderpila3;
	String orderpila4;
	public Automata getAutoreglas() {
		return autoreglas;
	}
	public void setAutoreglas(Automata autoreglas) {
		this.autoreglas = autoreglas;
	}
	public static ArrayList<Automata> getReglas() {
		return reglas;
	}
	public static void setReglas(ArrayList<Automata> reglas) {
		AutomataNpilas.reglas = reglas;
	}
	public static boolean isCamino() {
		return camino;
	}
	public static void setCamino(boolean camino) {
		AutomataNpilas.camino = camino;
	}
	public int getNumeroregla() {
		return numeroregla;
	}
	public void setNumeroregla(int numeroregla) {
		this.numeroregla = numeroregla;
	}
	public String getEstado1() {
		return estado1;
	}
	public void setEstado1(String estado1) {
		this.estado1 = estado1;
	}
	public String getCadenaletra() {
		return cadenaletra;
	}
	public void setCadenaletra(String cadenaletra) {
		this.cadenaletra = cadenaletra;
	}
	public String getCadenaPila1() {
		return cadenaPila1;
	}
	public void setCadenaPila1(String cadenaPila1) {
		this.cadenaPila1 = cadenaPila1;
	}
	public String getCadenaPila2() {
		return cadenaPila2;
	}
	public void setCadenaPila2(String cadenaPila2) {
		this.cadenaPila2 = cadenaPila2;
	}
	public String getCadenaPila3() {
		return cadenaPila3;
	}
	public void setCadenaPila3(String cadenaPila3) {
		this.cadenaPila3 = cadenaPila3;
	}
	public String getCadenaPila4() {
		return cadenaPila4;
	}
	public void setCadenaPila4(String cadenaPila4) {
		this.cadenaPila4 = cadenaPila4;
	}
	public String getEstaodo2() {
		return estaodo2;
	}
	public void setEstaodo2(String estaodo2) {
		this.estaodo2 = estaodo2;
	}
	public String getOrderpila1() {
		return orderpila1;
	}
	public void setOrderpila1(String orderpila1) {
		this.orderpila1 = orderpila1;
	}
	public String getOrderpila2() {
		return orderpila2;
	}
	public void setOrderpila2(String orderpila2) {
		this.orderpila2 = orderpila2;
	}
	public String getOrderpila3() {
		return orderpila3;
	}
	public void setOrderpila3(String orderpila3) {
		this.orderpila3 = orderpila3;
	}
	public String getOrderpila4() {
		return orderpila4;
	}
	public void setOrderpila4(String orderpila4) {
		this.orderpila4 = orderpila4;
	}
	


	


}
