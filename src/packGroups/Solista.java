package packGroups;

import java.util.ArrayList;

import packDisco.Disco;
import packGlobalEnums.Genero;

public class Solista extends SuperGrupo {
	private Artista integrante;

	public Solista(String nombre, Genero genero, Biografia biografia,
			ArrayList<Disco> discografia, Artista integrante) {
		super(nombre, genero, biografia, discografia);
		this.integrante = integrante;
	}

}
