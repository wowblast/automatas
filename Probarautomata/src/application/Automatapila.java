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

	public void ver_vacio(String cadena,int posicion,String estado,ArrayList<String> pila,int regla)

	{
		String estadofinal= "no hay";
		for(int i=0;i<reglas.size();i++)
		{
			if(reglas.get(i).cadenaletra.equals("F"))
			{

				if(reglas.get(i).estado1.equals(reglas.get(regla).getEstado1()))
				{
					if(reglas.get(i).getCadenaPila().equals(pila.get(pila.size()-1)))
					{
						if(reglas.get(i).getOrderpila().equals("Neutro"))
						{							 
						}
						else if(reglas.get(i).getOrderpila().equals("D"))
						{
							pila.remove(pila.size()-1);

						}
						else
						{
							pila.add(reglas.get(i).getOrderpila().toLowerCase());
						}

						estadofinal = reglas.get(i).getEstaodo2();


					}
					else if(reglas.get(i).getCadenaPila().equals("Z"))
					{

						if(reglas.get(i).getOrderpila().equals("Neutro"))
						{							 
						}
						else if(reglas.get(i).getOrderpila().equals("D"))
						{
							pila.remove(pila.size()-1);

						}
						else
						{
							pila.add(reglas.get(i).getOrderpila().toLowerCase());
						}

						estadofinal = reglas.get(i).getEstaodo2();




					} 
				}




			}
			probar_regla(cadena, posicion, estadofinal, pila);
		}

	}

	public void probar_regla(String cadena,int posicion,String estado,ArrayList<String> pila)
	{
		String estadonuevo="No hay";
		ArrayList<String> pila2=pila;

		for(int x=0;x<reglas.size();x++)
		{
			char letra= reglas.get(x).getCadenaletra().charAt(0);

			if(estado.equals("aceptacion")&&pila.get(0).equals("ZO")&&Objects.equals(cadena.charAt(posicion),' '))
			{
				System.out.println("acepto vacio");
				break;
			}
			else if((Objects.equals(estado,reglas.get(x).getEstado1())&&Objects.equals(letra,cadena.charAt(posicion))) )
			{
				if(Objects.equals(reglas.get(x).getCadenaPila(),"Z") || Objects.equals(pila.get(pila.size()-1).toLowerCase(), reglas.get(x).getCadenaPila().toLowerCase()))
				{
					if(reglas.get(x).getOrderpila()=="Neutro")
					{
					}
					else if(reglas.get(x).getOrderpila().equals("D"))
					{
						pila.remove(pila.size()-1);	
					}
					else
					{
						pila.add(reglas.get(x).getOrderpila().toLowerCase());
					}
					estadonuevo=reglas.get(x).getEstaodo2();
					posicion++;
					probar_regla(cadena, posicion, estadonuevo, pila);
					probar_regla("F ", 0, estadonuevo, pila);
				}
			}

		}


	}


}
