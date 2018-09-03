







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
		Probarautomata a = new Probarautomata();
	
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

			/*pw.write("1,leer,a,Z,leer,A");
			pw.append("\n2,leer,b,Z,comp,B");
			pw.append("\n3,leer,F,Z,comp,Z");
			pw.append("\n4,comp,a,A,comp,D");
			pw.append("\n5,comp,b,B,comp,D");*/
			//wcwr
			/*pw.write("1,leer,a,Z,leer,A");
			pw.append("\n2,leer,b,Z,leer,B");
			pw.append("\n3,leer,c,Z,comp,Z");
			pw.append("\n4,comp,a,A,comp,D");
			pw.append("\n5,comp,b,B,comp,D");*/
			
			//wwr
			/*pw.write("1,q0,a,Z,q0,A");
			pw.append("\n2,q0,a,Z,aceptacion,A");
			pw.append("\n3,q0,b,Z,q0,B");
			pw.append("\n4,q0,b,Z,aceptacion,B");
			pw.append("\n5,aceptacion,b,B,aceptacion,D");
			pw.append("\n6,aceptacion,a,A,aceptacion,D");*/
			
			
			/*pw.write("1,q0,a,A,B,B,A,q2,A,A,D,Z");
			pw.append("\n2,q0,a,B,B,B,A,q2,A,A,D,Z");*/
			
			//a=2b
			/*pw.write("1,leer,F,z0,acept,Z");
			pw.append("\n2,leer,a,z0,leer,A");
			pw.append("\n3,leer,b,z0,leer,BB");
			pw.append("\n4,leer,a,A,leer,A");
			pw.append("\n5,leer,a,B,leer,D");
			pw.append("\n6,leer,b,B,leer,BB");
			pw.append("\n7,leer,b,A,Segunda_a,D");
			pw.append("\n8,Segunda_a,F,A,leer,D");
			pw.append("\n9,Segunda_a,F,B,leer,B");
			pw.append("\n10,Segunda_a,F,z0,leer,B");*/
			
			
			//ambn
			pw.write("1,leer,F,z0,acept,Z");
			pw.append("\n2,leer,a,z0,leer,A");
			pw.append("\n3,leer,a,z0,leer,AA");
			pw.append("\n4,leer,a,A,leer,A");
			pw.append("\n5,leer,a,A,leer,AA");
			pw.append("\n6,leer,b,A,leer_b,D");
			pw.append("\n7,leer_b,b,A,leer_b,D");
			pw.append("\n8,leer_b,F,z0,acept,Z");
			 
			//ambmcn
			/* pw.write("1,leer_a,a,Z,leer_a,A");
			pw.append("\n2,leer_a,b,A,leer_b,D");
			pw.append("\n3,leer_b,b,A,leer_b,D");
			pw.append("\n4,leer_b,c,z0,leer_c,Z");
			pw.append("\n5,leer_c,c,z0,leer_c,Z");
			pw.append("\n6,leer_c,F,z0,acept,Z");*/
			
			
			pw.close();
			bw.close();
		}
		catch(Exception e)
		{


		}
		
		a.guardar_estados_Automatanormal();
		//a.probar_regla(cadena, 0,"q0", pila, a.buscar_reglas(cadena, 0, "q0", pila));
		//a.guardarreglasNautomatas();
		//a.probar_regla(cadena, 0, "q0", pila);
	
		
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
		String  cadena= "aabbN ";
		//t.cancel();
		
		
	
			ArrayList<String> pila= new ArrayList<String>();
			pila.add("z0");
			a.probar_reglaAutomatanormal(cadena, 0,"leer", pila);
	
		
			
		
		
		
			
		launch(args);
	}
}
