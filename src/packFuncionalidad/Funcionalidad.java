package packFuncionalidad;

import packGroups.Artista;
import packInterfaz.VentanaArtistas;

public class Funcionalidad {

	public boolean buscarArtista(String nombre) {
		VentanaArtistas va = new VentanaArtistas();
		boolean existe = false;
		Artista[] listaAr = va.getList();
		for (Artista i : listaAr) {
			System.out.println(i.getNombre());
			if(i.getNombre().equals(nombre)) {
				existe = true;
				return existe;
			} else {
				existe = false;
			}
		}
		return existe;
	}

}
