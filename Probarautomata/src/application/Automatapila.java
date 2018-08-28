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

	public void guardar_estadofinal()

	{

	}

	public void probar_cadena(String cadena,int posicion,String estado)


	{

	}

	public void probar_regla(String cadena,int posicion,String estado,ArrayList<String> pila)
	{
		String estadonuevo="No hay";

		for(int x=0;x<reglas.size();x++)
		{
			if(estado=="aceptacion")
			{
				System.out.println("acepto");
				break;
			}

			char letra= reglas.get(x).getCadenaletra().charAt(posicion);
			
			if((Objects.equals(estado, reglas.get(x).getEstado1())&&Objects.equals(letra, cadena.charAt(posicion))))
			{
				if(Objects.equals(pila.get(pila.size()-1), reglas.get(x).getCadenaPila()))
				{
					if(reglas.get(x).getOrderpila()=="Neutro")
					{
					}
					else if(reglas.get(x).getOrderpila()!="D")

					{
						pila.add(reglas.get(x).getOrderpila().toLowerCase());
					}
					else
					{
						pila.remove(pila.size()-1);	
					}
					estadonuevo=reglas.get(x).getEstaodo2();
					posicion++;
					probar_regla(cadena, posicion, estadonuevo, pila);

				}
				else if(Objects.equals(reglas.get(x).getCadenaPila(),"Z"))
				{

					if(reglas.get(x).getOrderpila()=="Neutro")
					{
					}
					else if(!Objects.equals(reglas.get(x).getOrderpila(),"D"))

					{
						pila.add(reglas.get(x).getOrderpila().toLowerCase());
					}
					else
					{
						pila.remove(pila.size()-1);	
					}
					estadonuevo=reglas.get(x).getEstaodo2();
					probar_regla(cadena, posicion, estadonuevo, pila);
				}
			}
		}


	}


}
