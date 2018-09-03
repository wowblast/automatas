package application;

import javafx.beans.property.SimpleStringProperty;

public class Pilavisible {

	  public SimpleStringProperty topepila;
	  public SimpleStringProperty topepila1;
	  public SimpleStringProperty topepila2;
	  public SimpleStringProperty topepila3;
	  public SimpleStringProperty topepila4;
	  public Pilavisible( String topepila)
	    {
	      
	        this.topepila = new SimpleStringProperty(topepila);
	       
	    }
	  public Pilavisible( String topepila1,String topepila2,String topepila3,String topepila4)
	    {
	      
	        this.topepila1 = new SimpleStringProperty(topepila1);
	        this.topepila2 = new SimpleStringProperty(topepila2);
	        this.topepila3 = new SimpleStringProperty(topepila3);
	        this.topepila4 = new SimpleStringProperty(topepila4);
	       
	    }



	    public String getTopepila() {
	        return topepila.get();
	    }

	    public void setTopepila(String topepila) {
	        this.topepila = new SimpleStringProperty(topepila);
	    }
	    public String getTopepila1() {
	        return topepila1.get();
	    }

	    public void setTopepila1(String topepila) {
	        this.topepila1 = new SimpleStringProperty(topepila);
	    }
	    public String getTopepila2() {
	        return topepila2.get();
	    }

	    public void setTopepila2(String topepila) {
	        this.topepila2 = new SimpleStringProperty(topepila);
	    }
	    public String getTopepila3() {
	        return topepila3.get();
	    }

	    public void setTopepila3(String topepila) {
	        this.topepila1 = new SimpleStringProperty(topepila);
	    }
	    public String getTopepila4() {
	        return topepila4.get();
	    }

	    public void setTopepila4(String topepila) {
	        this.topepila4 = new SimpleStringProperty(topepila);
	    }

}