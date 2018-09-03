package application;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import org.omg.Messaging.SyncScopeHelper;

public class Probarautomata {

	Automata autoreglas;
	AutomataNpilas  nreglas;
	static ArrayList <Automata> reglas=new ArrayList<Automata>();
	static ArrayList <AutomataNpilas> reglasNpilas=new ArrayList<AutomataNpilas>();

	static boolean camino=true;


	public void guardar_estados_Automatanormal()
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

	public void guardarreglasNautomatas()
	{
		try {
			File archivo;
			FileReader fr;
			BufferedReader br;
			archivo = new File("hola2.txt");

			fr=new FileReader(archivo);

			br= new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null)

			{
                 nreglas= new AutomataNpilas();
				String []partes = linea.split(",");
				 nreglas.setNumeroregla(Integer.parseInt(partes[0]));
				 nreglas.setEstado1(partes[1]);
				 nreglas.setCadenaletra(partes[2]);
				 nreglas.setCadenaPila1(partes[3]);
				 nreglas.setCadenaPila2(partes[4]);
				 nreglas.setCadenaPila3(partes[5]);
				 nreglas.setCadenaPila4(partes[6]);
				 nreglas.setEstaodo2(partes[7]);
				 nreglas.setOrderpila1(partes[8]);
				 nreglas.setOrderpila2(partes[9]);
				 nreglas.setOrderpila3(partes[10]);
				 nreglas.setOrderpila4(partes[11]);
			
				reglasNpilas.add(nreglas);
			}
			//pw.close();
			br.close();
			for(int x=0;x<reglasNpilas.size();x++)
			{
				System.out.println( reglasNpilas.get(x).getNumeroregla()+"-"+ reglasNpilas.get(x).getEstado1()+"-"+reglasNpilas.get(x).getCadenaletra()+"-"+reglasNpilas.get(x).getCadenaPila1()+"-"+reglasNpilas.get(x).getCadenaPila2()+"-"+reglasNpilas.get(x).getCadenaPila3()+reglasNpilas.get(x).getCadenaPila4()+"-"+reglasNpilas.get(x).getEstaodo2()+"-"+reglasNpilas.get(x).getOrderpila1()+"-"+reglasNpilas.get(x).getOrderpila2()+"-"+reglasNpilas.get(x).getOrderpila3()+"-"+reglasNpilas.get(x).getOrderpila4());
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	


	
	public void probar_reglaAutomatanormal(String cadena,int posicion,String estado,ArrayList<String> pilaentrante)

	{
		
		ArrayList<String>pila = new ArrayList<String>();
		
		for(int t=0;t<pilaentrante.size();t++)
		{
			pila.add(pilaentrante.get(t));
		}
		for(int i=0;i<reglas.size();i++)
		{
			String estadonuevo="no hay";
			 char letra= reglas.get(i).getCadenaletra().charAt(0);
			System.out.println("entrada "+cadena.charAt(posicion)+ " letra en regla "+letra + " posicion "+posicion+" estado "+estado +" con pila "+pila.get(pila.size()-1)  +" numero regla " +(i+1));
            
			
			
			if((pila.get(pila.size()-1).equals(reglas.get(i).getCadenaPila().toLowerCase())
					&&camino
					&&reglas.get(i).getEstado1().equals(estado)
					&&Objects.equals(letra, cadena.charAt(posicion)))
					||(reglas.get(i).getCadenaPila().equals("Z")
							&&camino
							&&reglas.get(i).getEstado1().equals(estado)
							&&Objects.equals(letra, cadena.charAt(posicion)))
					||(pila.get(pila.size()-1).equals(reglas.get(i).getCadenaPila().toLowerCase())
							&&camino
							&&reglas.get((i)).getEstado1().equals(estado)
							&&Objects.equals(reglas.get(i).getCadenaletra(),"F")
							||((reglas.get(i).getCadenaPila().equals("Z")
									&&camino
									&&reglas.get((i)).getEstado1().equals(estado)
									&&Objects.equals(reglas.get(i).getCadenaletra(),"F")
									&&!Objects.equals('N', cadena.charAt(posicion)))))
					)
			{
				if((reglas.get(i).getCadenaPila().equals("Z")
							&&camino
							&&reglas.get((i)).getEstado1().equals(estado)
							&&Objects.equals(reglas.get(i).getCadenaletra(),"F")
							&&!Objects.equals('N', cadena.charAt(posicion)))
						    &&(posicion-1)>=0
						    ||(pila.get(pila.size()-1).equals(reglas.get(i).getCadenaPila().toLowerCase())
									&&camino
									&&reglas.get((i)).getEstado1().equals(estado)
									&&Objects.equals(reglas.get(i).getCadenaletra(),"F")) &&(posicion-1)>=0)
				{
					System.out.println("llego");
					posicion--;
				}
					
				
				if(reglas.get(i).getOrderpila().equals("D"))
				{
					System.out.println("desapilo" +pila.get(pila.size()-1));
					pila.remove(pila.size()-1);
					
				}
				else if(reglas.get(i).getOrderpila().equals("Z"))
				{
					System.out.println("pila si cambiar");
				}
				else 
				{
					for(int a=0;a<reglas.get(i).getOrderpila().length();a++)
					{
						
						pila.add(reglas.get(i).getOrderpila().toLowerCase().charAt(0)+"");
						System.out.println("apilo " + (a+1) +" "+ reglas.get(i).getOrderpila().toLowerCase().charAt(0) );
					}
				}
				ArrayList<String>Pila2 = new ArrayList<String>();
                 
				
				posicion++;
				
				if(posicion<cadena.length())
				{
					ArrayList<String>Pila = new ArrayList<String>();
					
					for(int t=0;t<pila.size();t++)
					{
						Pila.add(pila.get(t));
					}
				estadonuevo=reglas.get(i).getEstaodo2(); 
			
				System.out.println(posicion);
				
				probar_reglaAutomatanormal(cadena, posicion, estadonuevo, Pila);
				
				pila.clear();
				for(int t=0;t<pilaentrante.size();t++)
				{
					
					pila.add(pilaentrante.get(t));
				}
				
				posicion--;

				if((reglas.get(i).getCadenaPila().equals("Z")
							&&camino
							&&reglas.get((i)).getEstado1().equals(estado)
							&&Objects.equals(reglas.get(i).getCadenaletra(),"F")
							&&!Objects.equals('N', cadena.charAt(posicion)))
						    &&(posicion-1)>=0
						    ||(pila.get(pila.size()-1).equals(reglas.get(i).getCadenaPila().toLowerCase())
									&&camino
									&&reglas.get((i)).getEstado1().equals(estado)
									&&Objects.equals(reglas.get(i).getCadenaletra(),"F")) &&(posicion-1)>=0)
				{
					System.out.println("llego");
					posicion++;
				}
				System.out.println("estado "+estado);
			
				} 
			}
			
		
	}    
	}















}
