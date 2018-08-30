package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

public class Automatapila {

	Automata autoreglas;
	ArrayList <Automata> reglas=new ArrayList<Automata>();
	static String cadena="aaabb";
	boolean camino = true;

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
			for(int x=0;x<reglas.size();x++)
			{
				System.out.println(reglas.get(x).getNumeroregla()+"-"+reglas.get(x).getEstado1()+"-"+reglas.get(x).getCadenaletra()+"-"+reglas.get(x).getCadenaPila()+"-"+reglas.get(x).getEstaodo2()+"-"+reglas.get(x).getOrderpila());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Integer> buscar_reglas(String cadena,int posicion,String estado,ArrayList<String> pila)
	{
		ArrayList<Integer> regla = new ArrayList<Integer>();

		System.out.println(posicion+" es pos "+cadena.length());
		
		
		for(int x=0;x<reglas.size();x++)
		{
			char letra= reglas.get(x).getCadenaletra().charAt(0);
			if(reglas.get(x).cadenaletra.equals("F")&&reglas.get(x).getEstado1().equals(estado)&&camino)
			{
				regla.add(x);
				
			}
			else if(reglas.get(x).getEstado1().equals(estado)&&Objects.equals(letra, cadena.charAt(posicion))&&camino)
			{
				regla.add(x);
			}

		}
		
		return regla;

		

	}
	public void probar_regla(String cadena,int posicion,String estado,ArrayList<String> pila,ArrayList<Integer> numeroregla)
	{

		ArrayList<String>Pila = new ArrayList<String>(pila);
		ArrayList<Integer>Numeroreglas = new ArrayList<Integer>(numeroregla);
		String estadonuevo= estado;
		
		System.out.println(cadena.length()+" dwaf");
        System.out.println("cadena "+cadena.charAt(posicion)+" estado "+estado+" pila "+Pila.get(Pila.size()-1)+" posicion "+posicion);
		for(int x=0;x<Numeroreglas.size();x++)
		{
			if(reglas.get(Numeroreglas.get(x)).getEstado1().equals("aceptacion")&&Pila.get(Pila.size()-1).equals("ZO"))
			{
				System.out.println("acpeta");
				camino =!camino;
			}
			else if((Pila.get(Pila.size()-1).equals(reglas.get(Numeroreglas.get(x)).getCadenaPila().toLowerCase())&&camino)||(reglas.get(Numeroreglas.get(x)).getCadenaPila().equals("Z")&&camino))
			{
				if(reglas.get(Numeroreglas.get(x)).getOrderpila().equals("Neutro")&&camino)
				{

				}
				else if(reglas.get(Numeroreglas.get(x)).getOrderpila().equals("D")&&camino)
				{
					Pila.remove(Pila.size()-1);
				}
				else
				{
					Pila.add(reglas.get(Numeroreglas.get(x)).getOrderpila().toLowerCase());
				}
				estadonuevo= reglas.get(Numeroreglas.get(x)).getEstaodo2();
				System.out.println("posicion antes de cambiar "+ posicion);
				if((!reglas.get(Numeroreglas.get(x)).getCadenaletra().equals("F")&&camino))
				{
				posicion++;
				System.out.println("aumento");
				}
			 if((Objects.equals(cadena.charAt(x),' ')))
						{
					posicion=0;
					
						}
			
					probar_regla(cadena, posicion, estadonuevo, Pila, buscar_reglas(cadena, posicion, estadonuevo, Pila));
				//buscar_reglas(cadena, posicion, estadonuevo, Pila);
			}

		}


	}
	


}
