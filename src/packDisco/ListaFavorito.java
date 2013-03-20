package packDisco;

import java.util.ArrayList;

public class ListaFavorito {

	private ArrayList<Disco> listaDiscos;
	private ArrayList<Cancion> listaCanciones;

	public ArrayList<Disco> getListaDiscos() {
		return listaDiscos;
	}

	public ArrayList<Cancion> getListaCanciones() {
		return listaCanciones;
	}

	/*
	 * Instancia unica de la clase
	 */
	private static ListaFavorito mListaFavorito = new ListaFavorito();

	/*
	 * Constructor de la clase. Es privado para evitar que se se creen mas
	 * instancias
	 */
	private ListaFavorito() {
		// TODO: reemplazar por el codigo necesario para incializar el estado de
		// la instancia
		listaCanciones = new ArrayList<Cancion>();
		listaDiscos = new ArrayList<Disco>();
	}

	/*
	 * Metodo que devuelve la instancia unica de la clase
	 */
	public static ListaFavorito getListaFavorito() {
		return mListaFavorito;
	}

	/**
	 * Algoritmo de ordenacion que ordene de mayor a menor las puntuaciones de
	 * los discos y de las canciones en sus respectivas listas.
	 */
	public static void actualizarListaFavoritos() {

	}
	
	
}
