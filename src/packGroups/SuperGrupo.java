package packGroups;

import packGlobalEnums.Genero;
import packDisco.Disco;
import packDisco.Cancion;
import packDisco.ListaFavorito;

import java.util.ArrayList;

public class SuperGrupo {
	private String nombre;
	private Genero genero;
	private Biografia biografia;
	private ArrayList<Disco> discografia;
	
	public SuperGrupo(String nombre, Genero genero, Biografia biografia,
			ArrayList<Disco> discografia) {
		this.nombre = nombre;
		this.genero = genero;
		this.biografia = biografia;
		this.discografia = discografia;
	}
	
	/*
	 * Getters y Setters
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Biografia getBiografia() {
		return biografia;
	}

	public void setBiografia(Biografia biografia) {
		this.biografia = biografia;
	}

	public ArrayList<Disco> getDiscografia() {
		return discografia;
	}

	public void setDiscografia(ArrayList<Disco> discografia) {
		this.discografia = discografia;
	}


	/*
	 * Fin de Getters y Setters
	 */
	
	
	public ArrayList<Disco> busquedaPorAutor() {
		// Devuelve una lista de discos
		return null;
	}
	
	public ArrayList<Disco> busquedaPorGenero() {
		// Devuelve una lista de discos
		// (habia pensado en devolver una lista de canciones pero cancion no tiene genero)
		return null;
	}
	
	public Disco busquedaPorTituloDisco() {
		// Devuelve un disco
		return null;
	}
	
	public Cancion busquedaPorTituloCancion() {
		// Devuelve una cancion
		return null;
	}
	
	public void addDisco(Disco disco) {
		discografia.add(disco);
	}

}
