package packDisco;

public class Cancion {

	private String titulo;
	private float duracion;
	private String letra;
	private int esFavorita;

	public Cancion(String pTitulo, float pDuracion) {
		this.titulo = pTitulo;
		this.duracion = pDuracion;
		esFavorita = 0;
		
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

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public int getEsFavorita() {
		return esFavorita;
	}

	public void setEsFavorita(int esFavorita) {
		this.esFavorita = esFavorita;
	}

	/*
	 * Fin de Getters y Setters
	 */
}
