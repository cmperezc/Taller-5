package model.logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.data_structures.ArregloDinamico;
import model.data_structures.BST;
import model.data_structures.IArregloDinamico;
import model.data_structures.LinearProbingHashST;
import model.data_structures.RedBlackBST;
import model.data_structures.SeparateChainingHashST;
import model.data_structures.listaDoble;

/**
 * Definicion del modelo del mundo
 *
 */


public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */

	private IArregloDinamico <Integer> datos;

	public static String ARCHIVO = "./data/us_accidents_small.csv";

	private SeparateChainingHashST<Integer, Movie> tablaSt;
	private SeparateChainingHashST<String, listaDoble<Movie>> tablaLinear;
	private SeparateChainingHashST<String, listaDoble<Movie>> tablaLinear2;
	private SeparateChainingHashST<String, listaDoble<Movie>> tablaLinear3;
	private RedBlackBST<Date, RedBlackBST<Double, listaDoble<accidents>>> Bst;
	private BST<Date, BST<Double, listaDoble<accidents>>> bst2;


	private Catalog catalogo;
	private Catalog catalogo2;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico <Integer> (7);
		catalogo = new Catalog();
		catalogo2 = new Catalog();

	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico <Integer> (capacidad);
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Integer dato)
	{	
		datos.agregar(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Integer buscar(Integer dato)
	{
		return datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Integer eliminar(Integer dato)
	{
		return datos.eliminar(dato);
	}


	public void cargaDatos() {

		int contador=0;

		tablaSt = new SeparateChainingHashST<Integer, Movie>(1);
		tablaLinear = new SeparateChainingHashST<String, listaDoble<Movie>>(1);
		tablaLinear2 = new SeparateChainingHashST<String, listaDoble<Movie>>(1);
		tablaLinear3 = new SeparateChainingHashST<String, listaDoble<Movie>>(1);
		Bst = new RedBlackBST<Date, RedBlackBST<Double, listaDoble<accidents>>>();
		bst2= new BST<Date, BST<Double, listaDoble<accidents>>>(); 




		Integer idPeliculaAct = -1;
		String id=null;

		File archivo1 = new File (ARCHIVO);


		FileReader fr1 = null;
		FileReader fr2 = null;
		int lineas = 0;


		try {

			fr1 = new FileReader (archivo1);

			BufferedReader br1 = new BufferedReader (fr1);


			String lineaActual = br1.readLine();

			while ((lineaActual=br1.readLine())!=null) {
				contador++;
				String[] atributos = lineaActual.split(",") ;
				accidents accidentes = new accidents(atributos[0]);
				id=atributos[0];
				accidentes.setSource(atributos[1]);
				if(!atributos[2].equals(""))
					accidentes.setTMC(Double.parseDouble(atributos[2]));
				if(!atributos[3].equals(""))
					accidentes.setSeverity(Double.parseDouble(atributos[3]));
				DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if(!atributos[4].equals(""))
					accidentes.setStart_Time(fechaHora.parse(atributos[4]));
				if(!atributos[5].equals(""))
					accidentes.setEnd_Time(fechaHora.parse(atributos[5]));
				if(!atributos[6].equals(""))
					accidentes.setStart_Lat(Double.parseDouble(atributos[6]));
				if(!atributos[7].equals(""))
					accidentes.setStart_Lng(Double.parseDouble(atributos[7]));
				if(!atributos[8].equals(""))
					accidentes.setEnd_Lat(Double.parseDouble(atributos[8]));
				if(!atributos[9].equals(""))
					accidentes.setEnd_Lng(Double.parseDouble(atributos[9]));
				if(!atributos[10].equals(""))
					accidentes.setDistance(Double.parseDouble(atributos[10]));
				accidentes.setDescription(atributos[11]);
				if(!atributos[12].equals(""))
					accidentes.setNumber(Double.parseDouble(atributos[12]));
				accidentes.setStreet(atributos[13]);
				accidentes.setSide(atributos[14]);
				accidentes.setCity(atributos[15]);
				accidentes.setCounty(atributos[16]);
				accidentes.setState(atributos[17]);
				accidentes.setZipcode(atributos[18]);
				accidentes.setCountry(atributos[19]);
				accidentes.setTimezone(atributos[20]);
				accidentes.setAirport_Code(atributos[21]);
				if(!atributos[22].equals(""))
					accidentes.setWeather_Timestamp(fechaHora.parse(atributos[22]));
				if(!atributos[23].equals(""))
					accidentes.setTemperature(Double.parseDouble(atributos[23]));
				if(!atributos[24].equals(""))
					accidentes.setWind_Chill(Double.parseDouble(atributos[24]));
				if(!atributos[25].equals(""))
					accidentes.setHumidity(Double.parseDouble(atributos[25]));
				if(!atributos[26].equals(""))
					accidentes.setPressure(Double.parseDouble(atributos[26]));
				if(!atributos[27].equals(""))
					accidentes.setVisibility(Double.parseDouble(atributos[27]));
				accidentes.setWind_Direction(atributos[28]);
				if(!atributos[29].equals(""))
					accidentes.setWind_Speed(Double.parseDouble(atributos[29]));
				if(!atributos[30].equals(""))
					accidentes.setPrecipitation(Double.parseDouble(atributos[30]));
				accidentes.setWeather_Condition(atributos[31]);
				accidentes.setAmenity(Boolean.parseBoolean(atributos[32]));
				accidentes.setBump(Boolean.parseBoolean(atributos[33]));
				accidentes.setCrossing(Boolean.parseBoolean(atributos[34]));
				accidentes.setGive_Way(Boolean.parseBoolean(atributos[35]));
				accidentes.setJunction(Boolean.parseBoolean(atributos[36]));
				accidentes.setNo_Exit(Boolean.parseBoolean(atributos[37]));
				accidentes.setRailway(Boolean.parseBoolean(atributos[38]));
				accidentes.setRoundabout(Boolean.parseBoolean(atributos[39]));
				accidentes.setStation(Boolean.parseBoolean(atributos[40]));
				accidentes.setStop(Boolean.parseBoolean(atributos[41]));
				accidentes.setTraffic_Calming(Boolean.parseBoolean(atributos[42]));
				accidentes.setTraffic_Signal(Boolean.parseBoolean(atributos[43]));
				accidentes.setTurning_Loop(Boolean.parseBoolean(atributos[44]));
				if (atributos.length>45) {
					accidentes.setSunrise_Sunset(atributos[45]);
					accidentes.setCivil_Twilight(atributos[46]);
					accidentes.setNautical_Twilight(atributos[47]);
					accidentes.setAstronomical_Twilight(atributos[48]);
				}
				DateFormat fechaHora2 = new SimpleDateFormat("yyyy-MM-dd");
				BST<Double, listaDoble<accidents>> nuevo = bst2.get(fechaHora2.parse(atributos[4]));

				if (nuevo!=null) {
					listaDoble<accidents> lista = nuevo.get(Double.parseDouble(atributos[3]));
					if (lista!=null) {
						lista.agregarInicio(accidentes);

					}
					else {
						lista = new listaDoble<accidents>();
						lista.agregarInicio(accidentes);
					}
					nuevo.put(Double.parseDouble(atributos[3]), lista);
				}else {
					nuevo=new BST<Double, listaDoble<accidents>>();
					listaDoble<accidents> lista2= new listaDoble<accidents>();
					lista2.agregarInicio(accidentes);
					nuevo.put(Double.parseDouble(atributos[3]), lista2);
				}
				bst2.put(fechaHora2.parse(atributos[4]), nuevo);
				/////////////////////
				RedBlackBST<Double, listaDoble<accidents>> nuevo2 = Bst.get(fechaHora2.parse(atributos[4]));

				if (nuevo2!=null) {
					listaDoble<accidents> lista2 = nuevo2.get(Double.parseDouble(atributos[3]));
					if (lista2!=null) {
						lista2.agregarInicio(accidentes);

					}
					else {
						lista2 = new listaDoble<accidents>();
						lista2.agregarInicio(accidentes);
					}
					nuevo2.put(Double.parseDouble(atributos[3]), lista2);
				}else {
					nuevo2=new RedBlackBST<Double, listaDoble<accidents>>();
					listaDoble<accidents> lista2= new listaDoble<accidents>();
					lista2.agregarInicio(accidentes);
					nuevo2.put(Double.parseDouble(atributos[3]), lista2);
				}
				Bst.put(fechaHora2.parse(atributos[4]), nuevo2);


			}


		}catch (Exception e) {
			System.out.println("error fatal: en pelicula " + idPeliculaAct + " descripción error: " + e.getMessage() );
		}
		finally {
			try {
				if(null!=fr1) {
					fr1.close();
				}
				if (null!= fr2) {
					fr2.close();
				}
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("numero de accidentes:"+contador + "llaves" + bst2.size()+"altura"+bst2.height()+"min:"+bst2.min()+"max:"+bst2.max()+"CON BST");
		System.out.println("numero de accidentes:"+contador + "llaves" + Bst.size()+"altura"+Bst.height()+"min:"+Bst.min()+"max:"+Bst.max()+"CON RBS");
	}

	public Catalog getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalog catalogo) {
		this.catalogo = catalogo;
	}

	public String R1BSt(Date fecha) {
		int contador = 0;
		listaDoble<accidents> nueva =new listaDoble<accidents>();
		BST<Double, listaDoble<accidents>> respuesta= bst2.get(fecha);
		for (Double actual : respuesta.keys()) {
			int totalSever=respuesta.get(actual).darTamaño();
			System.out.println("sever:"+actual+"cantidad"+totalSever);
			contador+=totalSever;
		}
		return "el numero de accidentes en la fecha es:"+contador;
	}
	
	public String R1RBS(Date fecha) {
		int contador = 0;
		listaDoble<accidents> nueva =new listaDoble<accidents>();
		RedBlackBST<Double, listaDoble<accidents>> respuesta= Bst.get(fecha);
		for (Double actual : respuesta.keys()) {
			int totalSever=respuesta.get(actual).darTamaño();
			System.out.println("sever:"+actual+"cantidad"+totalSever);
			contador+=totalSever;
		}
		return "el numero de accidentes en la fecha es:"+contador;
	}

}
