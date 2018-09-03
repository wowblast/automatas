package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Editar {
	static ArrayList<Automata> Automata = new ArrayList<Automata>();
	static ObservableList<Automata> data  =    FXCollections.observableArrayList();;
	static ObservableList<Alfabeto> data1 = FXCollections.observableArrayList();
	static Automata autoreglas;

	public static  void sobreeescribir(String nombre,ObservableList<Automata> datos)
	{
		File f;
		FileWriter w;
		BufferedWriter bw;
		PrintWriter pw;
		for(int i=0; i < datos.size(); i++)
		{
			System.out.println(datos.get(i).getEstado1());
		}
		try
		{
			f=new File(nombre);
			w=new FileWriter(f);
			bw= new BufferedWriter(w);
			pw = new PrintWriter(bw);
			String linea=datos.get(0).getNumeroregla()+","+datos.get(0).getEstado1()+","+datos.get(0).getCadenaletra()+","+datos.get(0).getCadenaPila()+","+datos.get(0).getEstado2()+","+datos.get(0).getOrderpila();
			pw.write(linea);
			for(int x=1;x<datos.size();x++)
			{
				linea="\n"+datos.get(x).getNumeroregla()+","+datos.get(x).getEstado1()+","+datos.get(x).getCadenaletra()+","+datos.get(x).getCadenaPila()+","+datos.get(x).getEstado2()+","+datos.get(x).getOrderpila();

				pw.append(linea);
			}


			pw.close();
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("error sobreescribir");
		}
	}

	
	public static  void sobreeescribir1(String nombre,ObservableList<Alfabeto> datos)
	{
		File f;
		FileWriter w;
		BufferedWriter bw;
		PrintWriter pw;
		for(int i=0; i < datos.size(); i++)
		{
			System.out.println(datos.get(i).getEstadoini());
		}
		try
		{
			f=new File(nombre);
			w=new FileWriter(f);
			bw= new BufferedWriter(w);
			pw = new PrintWriter(bw);
			String linea=(datos.get(0).getConjunto()+"-"+datos.get(0).getAlfabeto1()+"-"+datos.get(0).getAlfabeto2()+"-"+datos.get(0).getEstadoini()+"-"+datos.get(0).getEstadosacept());
			pw.write(linea);


			pw.close();
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("error sobreescribir");
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
			String linea=null;;


			while((linea=br.readLine())!=null)

			{

				String []partes = linea.split(",");

				System.out.println("llego ");
				
					data.add(new Automata(Integer.parseInt(partes[0]),partes[1],partes[2],partes[3],partes[4],partes[5]));
				

			}
			System.out.println("salio");

			br.close();
			fr.close();


		}
		catch(Exception e)
		{

		}
	}
	public static void leer1(String nombre1)
	{
		File archivo;
		FileReader fr;
		BufferedReader br;

		try
		{
			archivo = new File(nombre1);
			fr=new FileReader(archivo);
			br= new BufferedReader(fr);
			String linea=null;;


			while((linea=br.readLine())!=null)

			{

				String []partes1 = linea.split("-");

				System.out.println("llego ");
				
					data1.add(new Alfabeto(partes1[0], partes1[1], partes1[2], partes1[3], partes1[4]));
				

			}
			System.out.println("salio");

			br.close();
			fr.close();


		}
		catch(Exception e)
		{

		}
	}
	
	public static ArrayList<String> obtenerarchivos()
	{
		
		String workingDir = System.getProperty("user.dir");
		File folder = new File(workingDir);
		File[] listOfFiles = folder.listFiles();
        ArrayList<String> nombres= new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			if (file.isFile() && file.getName().endsWith(".txt") && !file.getName().endsWith("al.txt")) {

				nombres.add(file.getName());
				
			} 
		}
		return nombres;
	}
	
	public static ArrayList<String> obtenerarchivos1()
	{
		
		String workingDir = System.getProperty("user.dir");
		File folder = new File(workingDir);
		File[] listOfFiles = folder.listFiles();
        ArrayList<String> nombres1= new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			if (file.isFile() && file.getName().endsWith(".txt") && file.getName().endsWith("al.txt")) {

				nombres1.add(file.getName());
				
			} 
		}
		return nombres1;
	}
	
	public static void clearConsole(String a1) {

	    File fichero = new File(a1 + ".txt");

	    
	    if (fichero.delete())
	        System.out.println("El fichero ha sido borrado satisfactoriamente");
	    else
	        System.out.println("El fichero no pudó ser borrado");
	}

}
