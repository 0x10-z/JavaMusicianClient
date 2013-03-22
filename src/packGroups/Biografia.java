package packGroups;

import java.util.ArrayList;

public class Biografia {

	private String titulo;
	private ArrayList<String> listaHitos;

	public Biografia(String pTitulo,ArrayList <String> pListaHitos) {

		this.titulo=pTitulo;
		this.listaHitos=pListaHitos;
		
	}
	
	
	//Getters y setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String pTitulo) {
		this.titulo = pTitulo;
	}
	//Fin getters y setters
	

	//Añade a la ultima posicion de listahitos pHito ****
	public void addHito(String pHito){
		
		listaHitos.add((listaHitos.lastIndexOf(listaHitos)+1), pHito);
		
	}
	
	// devuelve la lista con todos los hitos 
	public ArrayList<String> getHitos(){
		
		return listaHitos;
		
	}
	
	
}
