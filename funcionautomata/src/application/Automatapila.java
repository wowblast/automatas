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
	boolean camino=true;


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
	public void ver_vacio(String cadena,int posicion,String estado,ArrayList<String> pila,int regla)

	{
		String estadofinal= "no hay";
		for(int i=0;i<reglas.size();i++)
		{
			if(reglas.get(i).cadenaletra.equals("F")&&camino)
			{

				if(reglas.get(i).estado1.equals(reglas.get(regla).getEstado1())&&camino)
				{
					if(reglas.get(i).getCadenaPila().equals(pila.get(pila.size()-1))&&camino)
					{
						if(reglas.get(i).getOrderpila().equals("Neutro")&&camino)
						{							 
						}
						else if(reglas.get(i).getOrderpila().equals("D")&&camino)
						{
							pila.remove(pila.size()-1);

						}
						else
						{
							pila.add(reglas.get(i).getOrderpila().toLowerCase());
						}

						estadofinal = reglas.get(i).getEstaodo2();
						ArrayList<String> listaCopiada2 = new ArrayList<String>(pila);
						probar_regla(cadena, posicion, estadofinal,  listaCopiada2);


					}
					else if(reglas.get(i).getCadenaPila().equals("Z")&&camino)
					{

						if(reglas.get(i).getOrderpila().equals("Neutro")&&camino)
						{							 
						}
						else if(reglas.get(i).getOrderpila().equals("D")&&camino)
						{
							pila.remove(pila.size()-1);

						}
						else
						{
							pila.add(reglas.get(i).getOrderpila().toLowerCase());
						}

						int pos =posicion;
						estadofinal = reglas.get(i).getEstaodo2();
						ArrayList<String> listaCopiada2 = new ArrayList<String>(pila);
						probar_regla(cadena, pos, estadofinal,  listaCopiada2);




					} 
				}




			}
			
		}

	}

	public void probar_regla(String cadena,int posicion,String estado,ArrayList<String> pila)
	{
		
		System.out.println(camino);
		String estadonuevo="No hay";
		//ArrayList<String> pila2=pila;
System.out.println(cadena.charAt(posicion)+" estado "+estado+" pila "+pila.get(pila.size()-1)+" posicion "+posicion);
		for(int x=0;x<reglas.size();x++)
		{
			char letra= reglas.get(x).getCadenaletra().charAt(0);

			if(estado.equals("aceptacion")&&pila.get(pila.size()-1).equals("ZO")&&camino)
			{
				System.out.println("acepto vacio");
				camino=!camino;
			}
			else if((Objects.equals(estado,reglas.get(x).getEstado1())&&Objects.equals(letra,cadena.charAt(posicion)))&&camino )
			{
				if((Objects.equals(reglas.get(x).getCadenaPila(),"Z")&&camino) || (Objects.equals(pila.get(pila.size()-1).toLowerCase(), reglas.get(x).getCadenaPila().toLowerCase())&&camino))
				{
					if(reglas.get(x).getOrderpila()=="Neutro"&&camino)
					{
					}
					else if(reglas.get(x).getOrderpila().equals("D")&&camino)
					{
						pila.remove(pila.size()-1);	
					}
					else
					{
						pila.add(reglas.get(x).getOrderpila().toLowerCase());
					}
					estadonuevo=reglas.get(x).getEstaodo2();
					ArrayList<String> listaCopiada = new ArrayList<String>(pila);
					ArrayList<String> listaCopiada2 = new ArrayList<String>(pila);
					
					posicion++;
					// esta variable cambia a cada rato dAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
					int pos =posicion;
					int pos2 = pos-1;
					System.out.println("pos2 es "+pos2);
					probar_regla(cadena, posicion, estadonuevo,listaCopiada);
					
					ver_vacio(cadena, pos2, estado, listaCopiada2, x);
					
				}
			}

		}


	}




}
