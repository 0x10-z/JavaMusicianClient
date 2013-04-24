package packGroups;

import packDisco.Disco;
import packGlobalEnums.Genero;
import java.util.ArrayList;

public class Grupo extends SuperGrupo {
	private ArrayList<Artista> listaIntegrantes;

	public Grupo(String nombre, Genero genero, Biografia biografia, ArrayList<Disco> discografia, ArrayList<Artista> listaIntegrantes) {
		super(nombre, genero, biografia, discografia);
		this.listaIntegrantes = listaIntegrantes;
	}
	
	
	public void addArtista(Artista artista) {
		listaIntegrantes.add(artista);
	}
	
	public ArrayList<Artista> getArtistas() {
		return listaIntegrantes;
	}
	
	public void anadirHito(String hito) {
		
	}
	
	public void addDisco(Disco disco) {
		super.addDisco(disco);
	}
	
	public ArrayList<Disco> getDiscografia() {
		return super.getDiscografia();
	}
	
}
