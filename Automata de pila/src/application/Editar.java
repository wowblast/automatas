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
	static Automata autoreglas;

	public static  void sobreeescribir(String nombre,ObservableList<Automata> datos)
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
				for(int x=0;x<10;x++)
				{
					data.add(new Automata(Integer.parseInt(partes[0]),partes[1],partes[2],partes[3],partes[4],partes[5]));
				}

			}
			System.out.println("salio");




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
			if (file.isFile() && file.getName().endsWith(".txt")) {

				nombres.add(file.getName());
				
			} 
		}
		return nombres;
	}

}
