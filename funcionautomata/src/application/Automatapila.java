package application;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Automatapila {

	Automata autoreglas;
	ArrayList <Automata> reglas=new ArrayList<Automata>();

	static boolean camino=true;


	public void guardar_estados()
	{

		try {
			File archivo;
			FileReader fr;
			BufferedReader br;
			archivo = new File("hola.txt");

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
				autoreglas.setEstaodo2(partes[4]);
				autoreglas.setOrderpila(partes[5]);
				reglas.add(autoreglas);
			}
			//pw.close();
			br.close();
			for(int x=0;x<reglas.size();x++)
			{
				System.out.println(reglas.get(x).getNumeroregla()+"-"+reglas.get(x).getEstado1()+"-"+reglas.get(x).getCadenaletra()+"-"+reglas.get(x).getCadenaPila()+"-"+reglas.get(x).getEstaodo2()+"-"+reglas.get(x).getOrderpila());
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void guardar_estadofinal()

	{

	}

	public void probar_cadena(String cadena,int posicion,String estado)


	{

	}
	public ArrayList<Cadenas> buscar_reglas(String cadena,int posicion,String estado,ArrayList<String> pila)
	{
	//	ArrayList<Integer> regla = new ArrayList<Integer>();
		ArrayList<Cadenas> posibles_reglas = new ArrayList<Cadenas>();

		ArrayList<String>Pila = new ArrayList<String>(pila);
		//ArrayList<Integer>Numeroreglas = new ArrayList<Integer>();
		String estadonuevo="no hay";

		/*posibles_reglas.add(new Cadenas());
		posibles_reglas.get(0).setEstado(new String(" "));
		posibles_reglas.get(0).setPila(new ArrayList<String>(Pila));
		posibles_reglas.get(0).setLetraentrada(new Character(cadena.charAt(posicion)));
		posibles_reglas.get(0).setEstado2((new String(estadonuevo)));
		posibles_reglas.get(0).setNumeroregla(new Integer(0));*/
		for(int x=0;x<reglas.size();x++)
		{
			char letra= reglas.get(x).getCadenaletra().charAt(0);
			System.out.println(estado);
			if((Pila.get(Pila.size()-1).equals(reglas.get(x).getCadenaPila().toLowerCase())
					&&camino
					&&reglas.get(x).getEstado1().equals(estado)
					&&Objects.equals(letra, cadena.charAt(posicion)))
					||(reglas.get(x).getCadenaPila().equals("Z")
							&&camino
							&&reglas.get(x).getEstado1().equals(estado)
							&&Objects.equals(letra, cadena.charAt(posicion)))
					||(Pila.get(Pila.size()-1).equals(reglas.get(x).getCadenaPila().toLowerCase())
							&&camino
							&&reglas.get((x)).getEstado1().equals(estado)
							&&Objects.equals(reglas.get(x).getCadenaletra(),"F")))
			{
				estadonuevo= reglas.get(x).getEstaodo2();
				System.out.println(estado+" "+ estadonuevo+" "+x);
				posibles_reglas.add(new Cadenas());
				posibles_reglas.get(posibles_reglas.size()-1).setEstado(new String(estado));
				posibles_reglas.get(posibles_reglas.size()-1).setPila(new ArrayList<String>(Pila));
				posibles_reglas.get(posibles_reglas.size()-1).setLetraentrada(new Integer(posicion));
				//posibles_reglas.get(posibles_reglas.size()-1).setEstado2((new String(estadonuevo)));
				posibles_reglas.get(posibles_reglas.size()-1).setNumeroregla(new Integer(x));
			}






		}
		return posibles_reglas;
	}
	public void probar_regla(String cadena,int posicion,String estado,ArrayList<String> pila,ArrayList<Cadenas> numeroregla)
	{

		//ArrayList<String>Pila = new ArrayList<String>(pila);
		ArrayList<Cadenas>Numeroreglas = new ArrayList<Cadenas>(numeroregla);
		String estadonuevo= "no hay";
		//System.out.println();


		//System.out.println("cadena "+cadena.charAt(posicion)+" estado "+estado+" pila "+Pila.get(Pila.size()-1)+" posicion "+posicion);
		for(int x=0;x<Numeroreglas.size();x++)
		{
			System.out.println("cadena "+cadena.charAt(posicion)+" estado "+estado+" pila "+Numeroreglas.get(x).getPila().get(Numeroreglas.get(x).getPila().size()-1)+" posicion "+posicion);
			
				ArrayList<String>Pila = new ArrayList<String>(Numeroreglas.get(x).getPila());
				char letra= reglas.get(Numeroreglas.get(x).getNumeroregla()).getCadenaletra().charAt(0);


				if(reglas.get(Numeroreglas.get(x).getNumeroregla()).getOrderpila().equals("Neutro")&&camino)
				{

				}
				else if(reglas.get(Numeroreglas.get(x).getNumeroregla()).getOrderpila().equals("D")&&camino)
				{
					Pila.remove(Pila.size()-1);
					Numeroreglas.get(x).setPila(Pila); 
				}
				else
				{
					System.out.println("apilo "+reglas.get(Numeroreglas.get(x).getNumeroregla()).getOrderpila().toLowerCase());
					Pila.add(reglas.get(Numeroreglas.get(x).getNumeroregla()).getOrderpila().toLowerCase());
					Numeroreglas.get(x).setPila(Pila); 
				}
				estadonuevo= reglas.get(Numeroreglas.get(x).getNumeroregla()).getEstaodo2();



				posicion++;

				
					probar_regla(cadena, new Integer(posicion), estadonuevo, Numeroreglas.get(x).getPila(), buscar_reglas(cadena,new Integer( posicion), estadonuevo,Numeroreglas.get(x).getPila()));
				
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				estadonuevo="no hay";
				//buscar_reglas(cadena, posicion, estadonuevo, Pila);
			}

		

		camino=!camino;


	}


}
