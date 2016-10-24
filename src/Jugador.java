public class Jugador {
	
	//Declaracion de variables a usar en esta clase
	
	private String nombre;
	private String posicion;
	private float clausula, costeAnual;
	private static int numprox_jugador = 1;
	private int num_jugador;
	
	//static Scanner nuevo = new Scanner(System.in);
	
	// Constructor que crea un jugador con su nombre, posicion y su clausula.
	
	public Jugador(String nombre, String posicion, float clausula, float costeAnual) {
		
		this.nombre = nombre;
		this.posicion = posicion;
		this.clausula = clausula;
		this.num_jugador = numprox_jugador++;
		this.costeAnual = costeAnual;
	}
	
	/*  Metodo para mostrar todos los valores de un objeto, en este caso, el nombre, la posicion y 
		la clausula del jugador que hayamos buscado. */
		
	public String toString(){

		return "NOMBRE: " + nombre + " POSICION: " + posicion + " CLAUSULA: " + clausula + " COSTE ANUAL: "+ costeAnual;
	}

	// Metodo que devuelve el nombre del jugador
	
	public String getNombre() {
		return nombre;
	}

	// Metodo que devuelve el nombre de la clausula
	
	public float getClausula() {
		return clausula;
	}

	// Metodo que modifica la clausula segun el valor introducido por parametro
	
	public void setClausula(float clausula) {
		this.clausula = clausula;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public float getCosteAnual() {
		return costeAnual;
	}

	public void setCosteAnual(float costeAnual) {
		this.costeAnual = costeAnual;
	}
	
	
	
	
	
}
