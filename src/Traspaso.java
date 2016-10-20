public class Traspaso {

	//Declaracion de variables a usar en esta clase

	private String nombreJugador, equipoOrigen, equipoDestino;
	java.util.Date utilDate;
	private float clausulaJugador;
	
	/* Constructor de la clase que realiza un nuevo traspaso segun el nombre del jugador, 
		el equipo de origen, el de destino y su nueva clausula */
		
	public Traspaso(String nombreJugador, String equipoOrigen, String equipoDestino, float clausulaJugador) {

		this.nombreJugador = nombreJugador;
		this.equipoOrigen = equipoOrigen;
		this.equipoDestino = equipoDestino;
		this.clausulaJugador = clausulaJugador;
		this.utilDate = new java.util.Date();
	}
	
	// Metodo que devuelve la fecha actual del sistema
	
	public java.util.Date getUtilDate() {
		return utilDate;
	}

	// Metodo que modifica la fecha que hay, por la actual del sistema
	
	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}

	/*  Metodo para mostrar todos los valores de un objeto, en este caso, el nombre del jugador, 
		el equipo de origen, el de estino, la fecha en la que se realizo el traspaso y su clausula. */
		
	@Override
	public String toString() {
		return "Nombre jugador =>" + nombreJugador + ", Equipo origen=>" + equipoOrigen + ", Equipo destino=>"
				+ equipoDestino + ", Fecha traspaso=>" + utilDate + ", Clausula rescision pagada=>" + clausulaJugador;
	}
}
