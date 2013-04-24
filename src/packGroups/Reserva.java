package packGroups;

import java.util.Date;

public class Reserva {

	private SuperGrupo grupo;
	private Date fecha;
	private boolean reserva;

	public Reserva(Grupo pGrupo, Date pFecha, boolean pReserva) {

		this.grupo = pGrupo;
		this.fecha = pFecha;
		this.reserva = pReserva;

	}

	// Getters y setters
	public SuperGrupo getGrupo() {
		return grupo;
	}

	public void setGrupo(SuperGrupo pGrupo) {
		this.grupo = pGrupo;
	}

	public Date getFecha() {

		return fecha;

	}

	public void setFecha(Date pFecha) {
		this.fecha = pFecha;
	}

	public boolean getReserva() {
		return reserva;
	}

	public void setReserva(boolean pReserva) {
		this.reserva = pReserva;

	}
	
	//Fin de getters y setters
}
