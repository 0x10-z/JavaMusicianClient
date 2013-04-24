package packGroups;

import java.util.Date;

public class Artista{

	private	String nombre;
	private String alias;
	private int edad;
	private	packGlobalEnums.Instrumentos instrumento;
	private boolean estaDisponible;
	
	public Artista(String pNombre,String pAlias,int pEdad,packGlobalEnums.Instrumentos pInstrumento){
		this.nombre=pNombre;
		this.alias=pAlias;
		this.edad=pEdad;
		this.instrumento=pInstrumento;
			
	}
	
	//getters y setters
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String pAlias) {
		this.alias = pAlias;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int pEdad) {
		this.edad = pEdad;
	}
	
	public packGlobalEnums.Instrumentos getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(packGlobalEnums.Instrumentos pInstrumento) {
		this.instrumento = pInstrumento;
	}
	//Fin de getters y setters
	
	
	//Devuelve el objeto actual.
	public Object getArtista() throws CloneNotSupportedException{
		return this.clone();
	}
	
	
	public boolean estaDisponible (Date pFecha){
		return estaDisponible;
	//TO DO
		
	}
	
	public void setDisponibilidad(boolean pEsta){
		
	//TO DO	
	}
}
