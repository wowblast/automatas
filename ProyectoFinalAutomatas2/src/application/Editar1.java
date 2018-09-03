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

public class Editar1 {
	static ArrayList<Automata1> Automata1 = new ArrayList<Automata1>();
	static ObservableList<Automata1> data2  =    FXCollections.observableArrayList();;
	static ObservableList<Alfabeto1> data3 = FXCollections.observableArrayList();
	static Automata1 autoreglas1;

	public static  void sobreeescribir2(String nombre,ObservableList<Automata1> datos)
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
			String linea=datos.get(0).getNumeroregla()+","+datos.get(0).getEstado1()+","+datos.get(0).getCadenaletra()+","+datos.get(0).getCadenaPila1()+","+datos.get(0).getCadenaPila2()+","+datos.get(0).getCadenaPila3()+","+datos.get(0).getCadenaPila4()+","+datos.get(0).getEstado2()+","+datos.get(0).getOrdenpila1()+","+datos.get(0).getOrdenpila2()+","+datos.get(0).getOrdenpila3()+","+datos.get(0).getOrdenpila4();
			pw.write(linea);
			for(int x=1;x<datos.size();x++)
			{
				linea="\n"+datos.get(x).getNumeroregla()+","+datos.get(x).getEstado1()+","+datos.get(x).getCadenaletra()+","+datos.get(x).getCadenaPila1()+","+datos.get(x).getCadenaPila2()+","+datos.get(x).getCadenaPila3()+","+datos.get(x).getCadenaPila4()+","+datos.get(x).getEstado2()+","+datos.get(x).getOrdenpila1()+","+datos.get(x).getOrdenpila2()+","+datos.get(x).getOrdenpila3()+","+datos.get(x).getOrdenpila4();

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

	
	public static  void sobreeescribir3(String nombre,ObservableList<Alfabeto1> datos)
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
			String linea=(datos.get(0).getConjunto()+"-"+datos.get(0).getAlfabetoauto()+"-"+datos.get(0).getAlfabeto1()+"-"+datos.get(0).getAlfabeto2()+"-"+datos.get(0).getAlfabeto3()+"-"+datos.get(0).getAlfabeto4()+"-"+datos.get(0).getEstadoini()+"-"+datos.get(0).getEstadofin()+"-"+datos.get(0).getSipila1()+"-"+datos.get(0).getSipila2()+"-"+datos.get(0).getSipila3()+"-"+datos.get(0).getSipila4());
			pw.write(linea);


			pw.close();
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println("error sobreescribir");
		}
	}
	public static void leer2(String nombre)
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
				
					data2.add(new Automata1(Integer.parseInt(partes[0]),partes[1],partes[2],partes[3],partes[4],partes[5],partes[6],partes[7],partes[8],partes[9],partes[10],partes[11]));
				

			}
			System.out.println("salio");

			br.close();
			fr.close();


		}
		catch(Exception e)
		{

		}
	}
	public static void leer3(String nombre1)
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
				
					data3.add(new Alfabeto1(partes1[0], partes1[1], partes1[2], partes1[3], partes1[4],partes1[5], partes1[6], partes1[7], partes1[8], partes1[9], partes1[10], partes1[11]));
				

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
