package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Editar {
	static ArrayList<Automata> Automata = new ArrayList<Automata>();
    static Automata autoreglas;
	
	public static  void escribir(String nombre)
	{
		File f;
		FileWriter w;
		BufferedWriter bw;
		PrintWriter pw;
		try
		{
			f=new File(nombre);
			w=new FileWriter(f);
			bw= new BufferedWriter(w);
			pw = new PrintWriter(bw);
			
			pw.write("1,q0,a,Z,q1,A");
			pw.append("\n1,q0,b,Z,q1,B");
			pw.close();
			bw.close();
		}
		catch(Exception e)
		{
			
		}
		
		
	}
	public static void leer(String nombre)
	{
	   File archivo;
	   FileReader fr;
	   BufferedReader br;
	   
	   try
	   {
		   archivo = new File(nombre);
		   fr=new FileReader(archivo);
		   br= new BufferedReader(fr);
		   String linea;
		   while((linea=br.readLine())!=null)
			   
		   {
			   autoreglas= new Automata();
			   String []partes = linea.split(",");
			   autoreglas.setNumeroregla(Integer.parseInt(partes[0]));
			   autoreglas.setEstado1(partes[1]);
			   autoreglas.setCadenaletra(partes[2]);
			   autoreglas.setCadenaPila(partes[3]);
			   autoreglas.setOrderpila(partes[4]);
			   Automata.add(autoreglas);
		   }
		  for(int x=0;x<Automata.size();x++)
		  {
			  System.out.println(Automata.get(x).getNumeroregla()+"-"+Automata.get(x).getEstado1()+"-"+Automata.get(x).getCadenaletra()+"-"+Automata.get(x).getCadenaPila()+"-"+Automata.get(x).getEstaodo2()+"-"+Automata.get(x).getOrderpila());
		  }
		  String workingDir = System.getProperty("user.dir");
		  File folder = new File(workingDir);
		  File[] listOfFiles = folder.listFiles();
		
		  for (int i = 0; i < listOfFiles.length; i++) {
		    File file = listOfFiles[i];
		    if (file.isFile() && file.getName().endsWith(".txt")) {
		    
		    System.out.println(file.getName());
		    } 
		  }
		   
	   }
	   catch(Exception e)
	   {
		   
	   }
	}
}
