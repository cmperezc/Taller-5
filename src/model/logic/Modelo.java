package model.logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.LinearProbingHashST;
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

	public static String ARCHIVO_CASTING = "./data/AllMoviesCastingRaw.csv";

	public static String ARCHIVO_DETAILS = "./data/AllMoviesDetailsCleaned.csv";
	private SeparateChainingHashST<Integer, Movie> tablaSt;
	private SeparateChainingHashST<String, listaDoble<Movie>> tablaLinear;
	private SeparateChainingHashST<String, listaDoble<Movie>> tablaLinear2;
	private SeparateChainingHashST<String, listaDoble<Movie>> tablaLinear3;


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

		tablaSt = new SeparateChainingHashST<Integer, Movie>(1);
		tablaLinear = new SeparateChainingHashST<String, listaDoble<Movie>>(1);
		tablaLinear2 = new SeparateChainingHashST<String, listaDoble<Movie>>(1);
		tablaLinear3 = new SeparateChainingHashST<String, listaDoble<Movie>>(1);



		Integer idPeliculaAct = -1; 

		File archivo1 = new File (ARCHIVO_DETAILS);
		File archivo2 = new File (ARCHIVO_CASTING);

		FileReader fr1 = null;
		FileReader fr2 = null;
		int lineas = 0;


		try {

			fr1 = new FileReader (archivo1);
			fr2 = new FileReader (archivo2);

			BufferedReader br1 = new BufferedReader (fr1);
			BufferedReader br2 = new BufferedReader (fr2);

			String lineaActual = br1.readLine();
			
			while ((lineaActual=br1.readLine())!=null) {

				String[] atributos = lineaActual.split(";") ;
				Movie peliculaAct = new Movie (Integer.parseInt(atributos[0])) ;
				idPeliculaAct = Integer.parseInt(atributos[0]);

				peliculaAct.setBudget(Double.parseDouble(atributos [1]));
				String [] generos = atributos[2].split("|");

				ArregloDinamico<String> arregloGeneros = new ArregloDinamico <String>() ;
				for (int i = 0 ; i< generos.length ; i++ ) {
					arregloGeneros.agregar(generos [i]);
				}
				peliculaAct.setGenre(arregloGeneros);
				peliculaAct.setImbdID(atributos[3]);
				peliculaAct.setLanguage(atributos[4]);
				peliculaAct.setoriginalTitle(atributos[5]);
				peliculaAct.setOverview(atributos[6]);
				peliculaAct.setPopularity(atributos[7]);
				peliculaAct.setProductionCompany(atributos[8]);
				peliculaAct.setProductionCountry(atributos[9]);
				peliculaAct.setReleaseDate(atributos[10]);
				peliculaAct.setRevenue(Long.parseLong(atributos[11]));
				peliculaAct.setRunTime(atributos[12]);
				peliculaAct.setSpokenLanguage(atributos[13]);
				peliculaAct.setStatus(atributos[14]);
				peliculaAct.setTagLine(atributos[15]);
				peliculaAct.setTitle(atributos[16]);
				peliculaAct.setVoteAverage(Double.parseDouble(atributos[17]));
				peliculaAct.setProductionCompanies(Integer.parseInt(atributos[18]));
				peliculaAct.setProductionCountries(Integer.parseInt(atributos[19]));
				peliculaAct.setSpokenLanguages(Integer.parseInt(atributos[20]));
				// catalogo.peliculas.agregar(peliculaAct);
				// Agregar a la tabla de hash
				tablaSt.put(idPeliculaAct, peliculaAct);
				lineas++;
			}

			lineaActual = br2.readLine();
			//ArregloDinamico<Movie> peliculasCatalogo = catalogo.peliculas;

			while ((lineaActual=br2.readLine())!=null) {

				String[] atributos = lineaActual.split(";") ;
				// Obtener la pelicula por id de la tabla de hash
				Movie peliculaAct = tablaSt.get(Integer.parseInt(atributos[0]));

				ArregloDinamico<Actor> actores = peliculaAct.getActores();

				for (int j = 1 ; j < 11; j++) {
					Actor actorAct = new Actor(atributos [j],Integer.parseInt(atributos [j+1])); 
					j++;
					actores.agregar(actorAct);
				}
				peliculaAct.setActores(actores);

				peliculaAct.setNumberActors(Integer.parseInt(atributos[11]));
				Director director = new Director (atributos[12],Integer.parseInt(atributos [13])) ;

				peliculaAct.setDirectores(director);
				peliculaAct.setNumberDirectors(Integer.parseInt(atributos[14]));

				Producer productor = new Producer (atributos [15]);
				peliculaAct.setProductor(productor);

				peliculaAct.setNumberProducers(Integer.parseInt(atributos [16]));

				ScreenPlay screenplay = new ScreenPlay (atributos[17]);
				peliculaAct.setScreenplay(screenplay);

				Editor editor= new Editor (atributos[18]);
				peliculaAct.setEditor(editor);

				// Agregar a la tabla de hash
				tablaSt.put(Integer.parseInt(atributos[0]), peliculaAct);
				
				// Agregar a tabla de hash para RF1
				listaDoble<Movie> peliculas = tablaLinear.get(peliculaAct.getProductionCompany());
				if(peliculas == null)
				{
					peliculas = new listaDoble<Movie>();
				}
				peliculas.agregarfinal(peliculaAct);
				tablaLinear.put(peliculaAct.getProductionCompany(), peliculas);
				
				listaDoble<Movie> peliculas2 = tablaLinear2.get(peliculaAct.getDirectores().getDirectorName());
				if(peliculas2 == null)
				{
					peliculas2 = new listaDoble<Movie>();
				}
				peliculas2.agregarfinal(peliculaAct);
				tablaLinear2.put(peliculaAct.getDirectores().getDirectorName(), peliculas2);
				
				listaDoble<Movie> peliculas3 = tablaLinear3.get(peliculaAct.getProductionCountry());
				if(peliculas3 == null)
				{
					peliculas3 = new listaDoble<Movie>();
				}
				peliculas3.agregarfinal(peliculaAct);
				tablaLinear3.put(peliculaAct.getProductionCountry(),peliculas3);
				
				
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
		System.out.println("catalogo tamano:"+ tablaSt.size() + "-" + lineas);
	}

	public Catalog getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalog catalogo) {
		this.catalogo = catalogo;
	}
	
	public String R1(String CompProduccion) {
		double contador=0;
		double votos=0;
		listaDoble<Movie> nueva = tablaLinear.get(CompProduccion);
		if (nueva!=null) {
			System.out.println("Lista de peliculas:");
			for (int i = 0; i < nueva.darTamaño(); i++) {
				System.out.println(nueva.darElemento(i).getoriginalTitle());
				contador++;
				votos+=nueva.darElemento(i).getVoteAverage();
			}
		}
		double total=votos/contador;
		return "el numero total de peliculas es:"+contador+" "+ "y el promedio de votos es:"+total;
	}
	public String R2(String nombreDirector) {
		double contador=0;
		double votos=0;
		listaDoble<Movie> nueva = tablaLinear2.get(nombreDirector);
		if (nueva!=null) {
			System.out.println("Lista de peliculas:");
			for (int i = 0; i < nueva.darTamaño(); i++) {
				System.out.println(nueva.darElemento(i).getoriginalTitle());
				contador++;
				votos+=nueva.darElemento(i).getVoteAverage();
			}
		}
		double total=votos/contador;
		return "el numero total de peliculas es:"+contador+" "+ "y el promedio de votos es:"+total;
	}
	
	public String R5(String nombrePais) {
		double contador=0;
		double votos=0;
		listaDoble<Movie> nueva = tablaLinear3.get(nombrePais);
		if (nueva!=null) {
			System.out.println("Lista de peliculas:");
			for (int i = 0; i < nueva.darTamaño(); i++) {
				System.out.println(nueva.darElemento(i).getoriginalTitle()+""+"anio:"+nueva.darElemento(i).getReleaseDate()+" "+"y el director es:"+" "+nueva.darElemento(i).getDirectores().getDirectorName());
				
			}
		}
		return "fin";
	}

}
