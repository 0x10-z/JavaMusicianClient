package packDisco;

import java.util.ArrayList;

import packGlobalEnums.Genero;

public class Disco {
	private String titulo;
	private Genero genero;
	private ArrayList<Cancion> tracklist;
	private int esFavorito;

	public Disco(String pTitulo, Genero pGenero) {
		this.titulo = pTitulo;
		this.genero = pGenero;
		tracklist = new ArrayList<Cancion>();
		esFavorito = 0;
	}
	
	/*
	 * Getters y Setters
	 */
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public ArrayList<Cancion> getTracklist() {
		return tracklist;
	}
	
	public void addCancion(Cancion pCancion){
		//Anadir una cancion al tracklist
	}

	public int getEsFavorito() {
		return esFavorito;
	}

	public void setEsFavorito(int esFavorito) {
		this.esFavorito = esFavorito;
	}
	/*
	 * Fin de Getters y Setters
	 */
}
