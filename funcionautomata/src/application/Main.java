package application;

	
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			//primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Automatapila a = new Automatapila();
		ArrayList<String> pila= new ArrayList<String>();

		File f;
		FileWriter w;
		BufferedWriter bw;
		PrintWriter pw;
		try
		{
			f=new File("hola.txt");
			w=new FileWriter(f);
			bw= new BufferedWriter(w);
			pw = new PrintWriter(bw);

			pw.write("1,q0,a,Z,q0,A");
			pw.append("\n2,q0,a,Z,aceptacion,A");
			pw.append("\n3,q0,b,Z,q0,B");
			pw.append("\n4,q0,b,Z,aceptacion,B");
			pw.append("\n5,aceptacion,b,B,aceptacion,D");
			pw.append("\n6,aceptacion,a,A,aceptacion,D");
			pw.close();
			bw.close();
		}
		catch(Exception e)
		{


		}
		pila.add("ZO");
		String  cadena= "baab ";
		a.guardar_estados();
		//a.probar_regla(cadena, 0,"q0", pila, a.buscar_reglas(cadena, 0, "q0", pila));
		
		//a.probar_regla(cadena, 0, "q0", pila);
		ArrayList<String> pila2= new ArrayList<String>(pila);
		boolean v= true;
		int dato=0; 
	/*	Timer t = new Timer();
		TimerTask tt = new TimerTask() {
		    @Override
		    public void run() {
		        //do something
		    	System.out.println("llego");
		    	if(!Automatapila.camino)
				{
					t.cancel();
				}
		    	a.probar_regla(cadena, 0,"q0", pila, a.buscar_reglas(cadena, 0, "q0", pila));
		    	
		    };
		};*/
		//t.schedule(tt,1000,1000);
		
		//t.cancel();
		a.probar_regla(cadena, 0,"q0", pila, a.buscar_reglas(cadena, 0, "q0", pila));
			
		launch(args);
	}
}
