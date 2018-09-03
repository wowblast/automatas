package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

public class FuncionAutomata {

	static Automatareglas autoreglas;
	static AutomataNpilas  nreglas;
	static ArrayList <Automatareglas> reglas=new ArrayList<Automatareglas>();
	static ArrayList <AutomataNpilas> reglasNpilas=new ArrayList<AutomataNpilas>();
	static ArrayList<ArrayList<String>> pilas= new ArrayList<ArrayList<String>>();
    static ArrayList<Reglamostrada> mostrartodo= new ArrayList<Reglamostrada>();
    static ArrayList<ArrayList<String>> pilasdepilas= new ArrayList<ArrayList<String>>();
    static ArrayList<Reglamostrada> mostrartodoN= new ArrayList<Reglamostrada>();
	static boolean camino=true;
	static boolean pilavacia=false;
	static boolean estadofinal=false;
	static String estadomostrado;
	static int numregla=77;
	static String topepila;
	static String topepila1;
	static String topepila2;
	static String topepila3;
	static String topepila4;
	static String letramostrar;
	
	public static ArrayList<String> obtenerarchivos()
	{

		String workingDir = System.getProperty("user.dir");
		File folder = new File(workingDir);
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> nombres= new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			if (file.isFile() && file.getName().endsWith(".txt")) {
				String dato= file.getName().substring(0, 4);

				if( !dato.equals("Reglas"))
				{
					nombres.add(file.getName());
				}


			} 
		}
		return nombres;
	}




	public static void guardar_estados_Automatanormal(String nombre)
	{

		try {
			File archivo;
			FileReader fr;
			BufferedReader br;
			archivo = new File(nombre);

			fr=new FileReader(archivo);

			br= new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null)

			{
				autoreglas= new Automatareglas();
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

	public static void guardarreglasNautomatas(String nombre)
	{
		try {
			File archivo;
			FileReader fr;
			BufferedReader br;
			archivo = new File(nombre);

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




	public static void probar_reglaAutomatanormal(String cadena,int posicion,String estado,ArrayList<String> pilaentrante)

	{

		ArrayList<String>pila = new ArrayList<String>();

		if( pilaentrante.get(( pilaentrante.size()-1)).equals("z0")&&Objects.equals(cadena.charAt(posicion), 'N')&&pilavacia&&estadofinal&&camino)
		{
			camino=!camino;
			
			System.out.println("acepto");
		}
		else if( pilaentrante.get( pilaentrante.size()-1).equals("z0")&&Objects.equals(cadena.charAt(posicion), 'N')&&pilavacia&&camino)
		{
			camino=!camino;
		}
		else if( pilaentrante.get( pilaentrante.size()-1).equals("z0")&&Objects.equals(cadena.charAt(posicion), 'N')&&estadofinal&&camino)
		{
			camino=!camino;
		}
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
					Datosautomata.pilavisible=Pila;
					System.out.println(posicion);
					  letramostrar= cadena.charAt(posicion)+"";
			            estadomostrado= estado;
			            numregla= (i+1);
			            topepila= pila.get(pila.size()-1);
                 // mostrardatos(i+1, estado, letramostrar, Pila.get(Pila.size()-1), Pila);
                  Reglamostrada a = new Reglamostrada(numregla+"", estadomostrado,letramostrar, topepila);
                  pilas.add(Pila);
                  mostrartodo.add(a);
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

	public static boolean  ver_pilas(int i,ArrayList<String> pila1,ArrayList<String> pila2,ArrayList<String> pila3,ArrayList<String> pila4)
	{
		boolean pilas= false;
		if(reglasNpilas.get(i).getCadenaPila1().equals(pila1.get(pila1.size()-1))&&
				reglasNpilas.get(i).getCadenaPila2().equals(pila2.get(pila2.size()-1))&&
				reglasNpilas.get(i).getCadenaPila3().equals(pila2.get(pila2.size()-1))&&
				reglasNpilas.get(i).getCadenaPila4().equals("z"))
		{
			pilas=true;
		}
		else if(reglasNpilas.get(i).getCadenaPila1().equals(pila1.get(pila1.size()-1))&&
				reglasNpilas.get(i).getCadenaPila2().equals(pila2.get(pila2.size()-1))&&
				reglasNpilas.get(i).getCadenaPila3().equals("z")&&
				reglasNpilas.get(i).getCadenaPila4().equals(pila4.get(pila4.size()-1)))
		{
			pilas=true;
		}
		else if(reglasNpilas.get(i).getCadenaPila1().equals(pila1.get(pila1.size()-1))&&
				reglasNpilas.get(i).getCadenaPila2().equals("z")&&
				reglasNpilas.get(i).getCadenaPila3().equals(pila3.get(pila3.size()-1))&&
				reglasNpilas.get(i).getCadenaPila4().equals(pila4.get(pila4.size()-1)))
		{
			pilas=true;
		}
		else if(reglasNpilas.get(i).getCadenaPila1().equals("z")&&
				reglasNpilas.get(i).getCadenaPila2().equals(pila2.get(pila2.size()-1))&&
				reglasNpilas.get(i).getCadenaPila3().equals(pila3.get(pila3.size()-1))&&
				reglasNpilas.get(i).getCadenaPila4().equals(pila4.get(pila4.size()-1)))
		{
			pilas=true;
		}
		else if(reglasNpilas.get(i).getCadenaPila1().equals("z")&&
				reglasNpilas.get(i).getCadenaPila2().equals(pila2.get(pila2.size()-1))&&
				reglasNpilas.get(i).getCadenaPila3().equals(pila3.get(pila3.size()-1))&&
				reglasNpilas.get(i).getCadenaPila4().equals("z"))
		{
			pilas=true;
		}
		else if(reglasNpilas.get(i).getCadenaPila1().equals(pila1.get(pila1.size()-1))&&
				reglasNpilas.get(i).getCadenaPila2().equals("z")&&
				reglasNpilas.get(i).getCadenaPila3().equals("z")&&
				reglasNpilas.get(i).getCadenaPila4().equals(pila4.get(pila4.size()-1)))
		{
			pilas=true;
		}
		else if(reglasNpilas.get(i).getCadenaPila1().equals("z")&&
				reglasNpilas.get(i).getCadenaPila2().equals(pila2.get(pila2.size()-1))&&
				reglasNpilas.get(i).getCadenaPila3().equals("z")&&
				reglasNpilas.get(i).getCadenaPila4().equals(pila4.get(pila4.size()-1)))
		{
			pilas=true;
		}
		else if(reglasNpilas.get(i).getCadenaPila1().equals(pila1.get(pila1.size()-1))&&
				reglasNpilas.get(i).getCadenaPila2().equals("z")&&
				reglasNpilas.get(i).getCadenaPila3().equals(pila3.get(pila3.size()-1))&&
				reglasNpilas.get(i).getCadenaPila4().equals("z"))
		{
			pilas=true;
		}		else if(reglasNpilas.get(i).getCadenaPila1().equals("z")&&
				reglasNpilas.get(i).getCadenaPila2().equals("z")&&
				reglasNpilas.get(i).getCadenaPila3().equals("z")&&
				reglasNpilas.get(i).getCadenaPila4().equals(pila4.get(pila4.size()-1)))
		{
			pilas=true;
		}
		else if(reglasNpilas.get(i).getCadenaPila1().equals("z")&&
				reglasNpilas.get(i).getCadenaPila2().equals("z")&&
				reglasNpilas.get(i).getCadenaPila3().equals(pila3.get(pila3.size()-1))&&
				reglasNpilas.get(i).getCadenaPila4().equals("z"))
		{
			pilas=true;
		}
		else if(reglasNpilas.get(i).getCadenaPila1().equals("z")&&
				reglasNpilas.get(i).getCadenaPila2().equals(pila2.get(pila2.size()-1))&&
				reglasNpilas.get(i).getCadenaPila3().equals("z")&&
				reglasNpilas.get(i).getCadenaPila4().equals("z"))
		{
			pilas=true;
		}
		else if(reglasNpilas.get(i).getCadenaPila1().equals(pila1.get(pila1.size()-1))&&
				reglasNpilas.get(i).getCadenaPila2().equals("z")&&
				reglasNpilas.get(i).getCadenaPila3().equals("z")&&
				reglasNpilas.get(i).getCadenaPila4().equals("z"))
		{
			pilas=true;
		}
		else if(reglasNpilas.get(i).getCadenaPila1().equals("z")&&
				reglasNpilas.get(i).getCadenaPila2().equals("z")&&
				reglasNpilas.get(i).getCadenaPila3().equals("z")&&
				reglasNpilas.get(i).getCadenaPila4().equals("z"))
		{
			pilas=true;
		}

		return pilas;

	}

	public static boolean compararpilas(int i,ArrayList<String> pila1,ArrayList<String> pila2,ArrayList<String> pila3,ArrayList<String> pila4) 
	{
		boolean pilas= false;
		if(reglasNpilas.get(i).getCadenaPila1().equals(pila1.get(pila1.size()-1))&&
				reglasNpilas.get(i).getCadenaPila2().equals(pila2.get(pila2.size()-1))&&
				reglasNpilas.get(i).getCadenaPila3().equals(pila3.get(pila3.size()-1))&&
				reglasNpilas.get(i).getCadenaPila3().equals(pila4.get(pila4.size()-1)))
		{
			pilas=true;
		} 

		return pilas;

	}


	public static void ordenpila(int i,ArrayList<String> pila1,ArrayList<String> pila2,ArrayList<String> pila3,ArrayList<String> pila4)
	{
		for(int x=0;x<5;x++)
		{
			switch(x)
			{
			case 1:
				if(reglasNpilas.get(i).getOrderpila1().equals("D"))
				{

					pila1.remove(pila1.size()-1);

				}
				else if(reglasNpilas.get(i).getOrderpila1().equals("Z"))
				{
					System.out.println("pila si cambiar");
				}
				else 
				{
					for(int a=0;a<reglasNpilas.get(i).getOrderpila1().length();a++)
					{

						pila1.add(reglasNpilas.get(i).getOrderpila1().toLowerCase().charAt(0)+"");
						System.out.println("apilo " + (a+1) +" "+ reglasNpilas.get(i).getOrderpila1().toLowerCase().charAt(0) );
					}
				}
				break;
			case 2:
				if(reglasNpilas.get(i).getOrderpila2().equals("D"))
				{

					pila2.remove(pila2.size()-1);

				}
				else if(reglasNpilas.get(i).getOrderpila2().equals("Z"))
				{
					System.out.println("pila si cambiar");
				}
				else 
				{
					for(int a=0;a<reglasNpilas.get(i).getOrderpila2().length();a++)
					{

						pila2.add(reglasNpilas.get(i).getOrderpila2().toLowerCase().charAt(0)+"");
						System.out.println("apilo " + (a+1) +" "+ reglasNpilas.get(i).getOrderpila2().toLowerCase().charAt(0) );
					}
				}
				break;
			case 3:
				if(reglasNpilas.get(i).getOrderpila3().equals("D"))
				{

					pila3.remove(pila3.size()-1);

				}
				else if(reglasNpilas.get(i).getOrderpila3().equals("Z"))
				{
					System.out.println("pila si cambiar");
				}
				else 
				{
					for(int a=0;a<reglasNpilas.get(i).getOrderpila3().length();a++)
					{

						pila3.add(reglasNpilas.get(i).getOrderpila3().toLowerCase().charAt(0)+"");
						
					}
				}
				break;
			case 4:
				if(reglasNpilas.get(i).getOrderpila4().equals("D"))
				{

					pila4.remove(pila4.size()-1);

				}
				else if(reglasNpilas.get(i).getOrderpila4().equals("Z"))
				{
					System.out.println("pila si cambiar");
				}
				else 
				{
					for(int a=0;a<reglasNpilas.get(i).getOrderpila4().length();a++)
					{

						pila4.add(reglasNpilas.get(i).getOrderpila4().toLowerCase().charAt(0)+"");
						
					}
				}
				break;
			}
		}
	}


	public static void probar_reglasAutomataNpilas(String cadena,int posicion,String estado,ArrayList<String> pilaentrante1,ArrayList<String> pilaentrante2,ArrayList<String> pilaentrante3,ArrayList<String> pilaentrante4)
	{

		if( pilaentrante1.get(( pilaentrante1.size()-1)).equals("z0")&&
			pilaentrante2.get(( pilaentrante2.size()-1)).equals("z0")&&
			pilaentrante3.get(( pilaentrante3.size()-1)).equals("z0")&&
			pilaentrante4.get(( pilaentrante4.size()-1)).equals("z0")&&
				Objects.equals(cadena.charAt(posicion), 'N')&&pilavacia&&estadofinal&&camino)
		{
			camino=!camino;
			
			System.out.println("acepto");
		}
		else if(pilaentrante1.get(( pilaentrante1.size()-1)).equals("z0")&&
				pilaentrante2.get(( pilaentrante2.size()-1)).equals("z0")&&
				pilaentrante3.get(( pilaentrante3.size()-1)).equals("z0")&&
				pilaentrante4.get(( pilaentrante4.size()-1)).equals("z0")&&Objects.equals(cadena.charAt(posicion), 'N')&&pilavacia&&camino)
		{
			camino=!camino;
		}
		else if(pilaentrante1.get(( pilaentrante1.size()-1)).equals("z0")&&
				pilaentrante2.get(( pilaentrante2.size()-1)).equals("z0")&&
				pilaentrante3.get(( pilaentrante3.size()-1)).equals("z0")&&
				pilaentrante4.get(( pilaentrante4.size()-1)).equals("z0")&&Objects.equals(cadena.charAt(posicion), 'N')&&estadofinal&&camino)
		{
			camino=!camino;
		}
		
		ArrayList<String>pila1 = new ArrayList<String>();
		ArrayList<String>pila2 = new ArrayList<String>();
		ArrayList<String>pila3 = new ArrayList<String>();
		ArrayList<String>pila4 = new ArrayList<String>();

		for(int t=0;t<pilaentrante1.size();t++)
		{
			pila1.add(pilaentrante1.get(t));
		}
		for(int t=0;t<pilaentrante2.size();t++)
		{
			pila2.add(pilaentrante2.get(t));
		}
		for(int t=0;t<pilaentrante3.size();t++)
		{
			pila3.add(pilaentrante3.get(t));
		}
		for(int t=0;t<pilaentrante4.size();t++)
		{
			pila4.add(pilaentrante4.get(t));
		}
		for(int i=0;i<reglasNpilas.size();i++)
		{
			String estadonuevo="no hay";
			char letra= reglasNpilas.get(i).getCadenaletra().charAt(0);
			//System.out.println("entrada "+cadena.charAt(posicion)+ " letra en regla "+letra + " posicion "+posicion+" estado "+estado +" con pila "+pila.get(pila.size()-1)  +" numero regla " +(i+1));



			if((compararpilas(i, pila1, pila2, pila3, pila4)
					&&camino
					&&reglas.get(i).getEstado1().equals(estado)
					&&Objects.equals(letra, cadena.charAt(posicion)))
					||((ver_pilas(i, pila1, pila2, pila3, pila4)
							&&camino
							&&reglas.get(i).getEstado1().equals(estado)
							&&Objects.equals(letra, cadena.charAt(posicion))))
					||(compararpilas(i, pila1, pila2, pila3, pila4)
							&&camino
							&&reglas.get((i)).getEstado1().equals(estado)
							&&Objects.equals(reglas.get(i).getCadenaletra(),"F"))
					||((ver_pilas(i, pila1, pila2, pila3, pila4)
							&&camino
							&&reglas.get((i)).getEstado1().equals(estado)
							&&Objects.equals(reglas.get(i).getCadenaletra(),"F")
							&&!Objects.equals('N', cadena.charAt(posicion)))))

			{
				if((compararpilas(i, pila1, pila2, pila3, pila4)
						&&camino
						&&reglas.get((i)).getEstado1().equals(estado)
						&&Objects.equals(reglas.get(i).getCadenaletra(),"F")
						&&!Objects.equals('N', cadena.charAt(posicion))
						&&(posicion-1)>=0)
						||(ver_pilas(i, pila1, pila2, pila3, pila4)
								&&camino
								&&reglas.get((i)).getEstado1().equals(estado)
								&&Objects.equals(reglas.get(i).getCadenaletra(),"F")
								&&!Objects.equals('N', cadena.charAt(posicion)) &&(posicion-1)>=0))
				{
					System.out.println("llego");
					posicion--;
				}


				ordenpila(i, pila1, pila2, pila3, pila4);
				

				posicion++;

				if(posicion<cadena.length())
				{
					ArrayList<String>Pila1 = new ArrayList<String>();
					ArrayList<String>Pila2 = new ArrayList<String>();
					ArrayList<String>Pila3 = new ArrayList<String>();
					ArrayList<String>Pila4 = new ArrayList<String>();

					for(int t=0;t<pila1.size();t++)
					{
						Pila1.add(pila1.get(t));
					}
					for(int t=0;t<pila2.size();t++)
					{
						Pila2.add(pila2.get(t));
					}
					for(int t=0;t<pila3.size();t++)
					{
						Pila3.add(pila3.get(t));
					}
					for(int t=0;t<pila4.size();t++)
					{
						Pila4.add(pila4.get(t));
					}
					estadonuevo=reglas.get(i).getEstaodo2(); 

					System.out.println(posicion);
					 letramostrar= cadena.charAt(posicion)+"";
			            estadomostrado= estado;
			            numregla= (i+1);
			            topepila1= pila1.get(pila1.size()-1);
			            topepila2= pila1.get(pila1.size()-1);
			            topepila3= pila1.get(pila1.size()-1);
			            topepila4= pila1.get(pila1.size()-1);
              // mostrardatos(i+1, estado, letramostrar, Pila.get(Pila.size()-1), Pila);
               Reglamostrada a = new Reglamostrada(numregla+"", estadomostrado,letramostrar, topepila1,topepila2,topepila3,topepila4);
              pilasdepilas.add(Pila1);
              pilasdepilas.add(Pila2);
              pilasdepilas.add(Pila3);
              pilasdepilas.add(Pila4);
               mostrartodo.add(a);
				probar_reglasAutomataNpilas(cadena, posicion, estadonuevo, Pila1, Pila2, Pila3, Pila4);

					pila1.clear();
					pila2.clear();
					pila3.clear();
					pila4.clear();
					for(int t=0;t<pilaentrante1.size();t++)
					{

						pila1.add(pilaentrante1.get(t));
					}
					for(int t=0;t<pilaentrante2.size();t++)
					{

						pila2.add(pilaentrante2.get(t));
					}
					for(int t=0;t<pilaentrante3.size();t++)
					{

						pila3.add(pilaentrante3.get(t));
					}
					for(int t=0;t<pilaentrante4.size();t++)
					{

						pila4.add(pilaentrante4.get(t));
					}
				

					posicion--;

					if((compararpilas(i, pila1, pila2, pila3, pila4)
							&&camino
							&&reglas.get((i)).getEstado1().equals(estado)
							&&Objects.equals(reglas.get(i).getCadenaletra(),"F")
							&&!Objects.equals('N', cadena.charAt(posicion))
							&&(posicion-1)>=0)
							||(ver_pilas(i, pila1, pila2, pila3, pila4)
									&&camino
									&&reglas.get((i)).getEstado1().equals(estado)
									&&Objects.equals(reglas.get(i).getCadenaletra(),"F")
									&&!Objects.equals('N', cadena.charAt(posicion)) &&(posicion-1)>=0))
					{
						System.out.println("llego");
						posicion++;
					}
					

				} 
			}


		}    
	}



	  



}
