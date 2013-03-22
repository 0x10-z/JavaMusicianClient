package packGroups;

import java.util.ArrayList;

public class Registro {
	private ArrayList<SuperGrupo> listaRegistro;
	
	/*
	 * instancia unica de la clase
	 */
	private static Registro mRegistro = new Registro();

	/*
	 * Constructor privado de la clase
	 */
	private Registro() {
	}

	/*
	 * Metodo que devuelve la instacia unica
	 */
	public static Registro getRegistro() {
		return mRegistro;
	}
	
	
}
