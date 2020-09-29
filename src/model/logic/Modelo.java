package model.logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */


public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */

	private IArregloDinamico <Integer> datos;

	public static String ARCHIVO_CASTING = "/Users/carpe/Downloads/Copia de T0_202020/data/MoviesCastingRaw-small.csv";

	public static String ARCHIVO_DETAILS = "/Users/carpe/Downloads/Copia de T0_202020/data/SmallMoviesDetailsCleaned_2.csv";

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

		Integer idPeliculaAct = -1; 

		File archivo1 = new File (ARCHIVO_DETAILS);
		File archivo2 = new File (ARCHIVO_CASTING);

		FileReader fr1 = null;
		FileReader fr2 = null;



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
				peliculaAct.setRevenue(Integer.parseInt(atributos[11]));
				peliculaAct.setRunTime(Integer.parseInt(atributos[12]));
				peliculaAct.setSpokenLanguage(atributos[13]);
				peliculaAct.setStatus(atributos[14]);
				peliculaAct.setTagLine(atributos[15]);
				peliculaAct.setTitle(atributos[16]);
				peliculaAct.setVoteAverage(Double.parseDouble(atributos[17]));
				peliculaAct.setProductionCompanies(Integer.parseInt(atributos[18]));
				peliculaAct.setProductionCountries(Integer.parseInt(atributos[19]));
				peliculaAct.setSpokenLanguages(Integer.parseInt(atributos[20]));

				catalogo.peliculas.agregar(peliculaAct);
			}

			lineaActual = br2.readLine();
			ArregloDinamico<Movie> peliculasCatalogo = catalogo.peliculas;

			while ((lineaActual=br2.readLine())!=null) {

				String[] atributos = lineaActual.split(";") ;
				for (int i = 0; i < peliculasCatalogo.darTamano(); i++) {
					Movie peliculaAct = peliculasCatalogo.darElemento(i);
					if (peliculaAct.getId()==Integer.parseInt(atributos[0])) {

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

					}

				}
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
		System.out.println("catalogo tamano:"+catalogo.peliculas.darTamano());
	}

	public Catalog getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalog catalogo) {
		this.catalogo = catalogo;
	}
	
	public void requerimiento1(String p)
	{
		//crear la tabla hash
		Hash ht = new Hash();
		Catalog copi=new Catalog();
		for(int i =0; i<catalogo.peliculas.darTamano(); i++)
		{
			copi.peliculas.agregar(catalogo.peliculas.darElemento(i));
		}
		for(int j =0; j<copi.peliculas.darTamano(); j++)
		{
			Integer x =Integer.valueOf(copi.peliculas.darElemento(j).getProductionCompany());
			Integer y =ht.peliculas.hash(x);
			if(ht.peliculas.buscar(y)!=null && ht.peliculas.buscar(y).getProductionCompany().equals(copi.peliculas.darElemento(j).getProductionCompany())){
				Movie z = ht.peliculas.buscar(y);
				while(ht.peliculas.buscar(y).darSiguiente()!=null)
				{
					z=ht.peliculas.buscar(y).darSiguiente();
				}
				z.cambiarSiguiente(copi.peliculas.darElemento(j));
			}
			else{
				ht.peliculas.agregar(y, copi.peliculas.darElemento(j));
			}
		}
		//requerimiento
		Integer a = Integer.valueOf(p);
		Integer k = ht.peliculas.hash(a);
		int c =0;
		double prom = 0;
        while(p!= ht.peliculas.buscar(k).getProductionCompany())
        {
        	k++;
        }
		Movie b = ht.peliculas.buscar(k);
		while(b!=null)
		{
			c++;
			prom+=b.getVoteAverage();
			System.out.println(b.getoriginalTitle());
			b=b.darSiguiente();
		}
		System.out.println("la cantidad total de peliculas es:"+c);
		prom=prom/c;
		System.out.println("la calificacion promedio de esta empresa es:"+prom);
	}
	
	public void requerimiento2(String d)
	{
		//crear la tabla hash
		Hash ht = new Hash();
		Catalog copi=new Catalog();
		for(int i =0; i<catalogo.peliculas.darTamano(); i++)
		{
			copi.peliculas.agregar(catalogo.peliculas.darElemento(i));
		}
		for(int j =0; j<copi.peliculas.darTamano(); j++)
		{
			Integer x =Integer.valueOf(copi.peliculas.darElemento(j).getDirectores().getDirectorName());
			Integer y =ht.peliculas.hash(x);
			if(ht.peliculas.buscar(y)!=null && ht.peliculas.buscar(y).getDirectores().getDirectorName().equals(copi.peliculas.darElemento(j).getDirectores().getDirectorName())){
				Movie z = ht.peliculas.buscar(y);
				while(ht.peliculas.buscar(y).darSiguiente()!=null)
				{
					z=ht.peliculas.buscar(y).darSiguiente();
				}
				z.cambiarSiguiente(copi.peliculas.darElemento(j));
			}
			else{
				ht.peliculas.agregar(y, copi.peliculas.darElemento(j));
			}
		}
		//requerimiento
		Integer a = Integer.valueOf(d);
		Integer k = ht.peliculas.hash(a);
		int c =0;
		double prom = 0;
		while(d!= ht.peliculas.buscar(k).getDirectores().getDirectorName())
        {
        	k++;
        }
		Movie b = ht.peliculas.buscar(k);
		while(b!=null)
		{
			c++;
			prom+=b.getVoteAverage();
			System.out.println(b.getoriginalTitle());
			b=b.darSiguiente();
		}
		System.out.println("la cantidad total de peliculas es:"+c);
		prom=prom/c;
		System.out.println("la calificacion promedio de este director es:"+prom);
	}
}
