import java.util.ArrayList;
import java.util.Scanner;

public class Equipo {
	
	//Declaracion de variables a usar en esta clase
	
	private String nombreEquipo, nombre, posicion;
	private float cajaActual, clausula, gasto_general, costeAnual;
	private int numAbonados, num_equipo;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private static int numprox_equipo=1;
	static Scanner nuevo = new Scanner(System.in);
	static Scanner nuevo1 = new Scanner(System.in);
	private Jugador jugador;
	
	/* Constructor por parametros, al cual le asignamos un nuevo equipo formado por el nombre, 
		la caja actual y los abonados que tiene. */
		
	public Equipo(String nombreEquipo, float cajaActual, int numAbonados, float gastoGeneral){
		
		this.nombreEquipo = nombreEquipo;
		this.cajaActual = cajaActual;
		this.numAbonados = numAbonados;
		this.num_equipo = numprox_equipo++;
		this.gasto_general = gastoGeneral;
	}
	
	// Devuelve el nombre del equipo 
	
	public String getNombreEquipo() {
		
		return nombreEquipo;
	}
	
	public float getGastoGeneral () {
		return gasto_general;
	}
	
	
	// Anyade un nuevo jugador al array de jugadores (previamente se habra comprobado que el equipo existe para introducirlo)
	
	public void addJugador(){
		
		//Introducimos un nuevo jugador (nombre, posicion en la que juega y su clausula)
		
		try{
			
		System.out.println("Introduce el nombre del nuevo jugador: ");
		nombre = nuevo.nextLine();
		
		System.out.println("Introduce su posicion (portero, defensa, medio, delantero): ");
		posicion = nuevo.nextLine();
		
		System.out.println("Introduce su clausula: ");
		clausula = nuevo1.nextFloat();
		
		System.out.println("Introduce su coste Anual (M): ");
		costeAnual = nuevo1.nextFloat();
		
		jugador = new Jugador(nombre, posicion, clausula, costeAnual); // Creamos el nuevo jugador mediante el constructor
		jugadores.add(jugador);							   // anyadimos el jugador al vector de jugadores
		
		
		}catch(Exception e){
			
			System.out.println("Error, intentalo de nuevo");
			nuevo1 = new Scanner(System.in);
		}
	}
	
	// Anyade un objeto de la clase Jugador (el propio jugador) al vector
	
	public void addJugador(Jugador jugador){
		
		Jugador jugador1=jugador;
		
		jugadores.add(jugador1);
		
	}
	
	// Metodo que obtiene un jugador
	
	public Object getJugador(String nombreJugador){
		
		Jugador jugador2 = new Jugador("","",0,0);
		
		for( int i = 0; i < jugadores.size(); i++ ){
			
			/*  Mediante un bucle for vamos recorriendo el vector de jugadores y comprobamos el nombre pasado 
				como parametro con los que hay en el vector.
			    En caso de que este, devolvera el jugador que estamos buscando. */
			
			if(jugadores.get(i).getNombre().equals(nombreJugador)){
				
				jugador2=jugadores.get(i);
			}
		}
		
		return jugador2;
	}
	
	// Metodo que elimina a un jugador de un equipo para realizar un traspaso posteriormente.
	
	public boolean removeJugador(String jugador){
		
		for( int i = 0; i < jugadores.size(); i++ ){
			
			/*  Recorre el vector de jugadores hasta que lo encuentra. Si es asi, lo elimina del vector, 
				sino, devuelve falso, ya que no lo ha encontrado. */
				
			if(jugadores.get(i).getNombre().equals(jugador)){
				
				jugadores.remove(i);
				
				return true;
			}
		}
		
		return false;
	}
	
	// Metodo que busca un jugador en el vector de jugadores. Si lo encuentra, devuelve true, sino, false.
	
	public boolean buscarJugador(String jugador){
		
		for( int i = 0; i < jugadores.size(); i++ ){
			
			if(jugadores.get(i).getNombre().equals(jugador)){
				
				return true;	
			}
		}
		return false;
	}

	/*  Metodo para mostrar todos los valores de un objeto, en este caso, el nombre, la caja, 
		el numero de abonados y el id del equipo que hayamos buscado. */
		
	@Override
	public String toString() {
		return "\n EQUIPO=>" + nombreEquipo + ", CAJA_ACTUAL=>" + cajaActual +", NºABONADOS=>" + numAbonados + 
				", ID_EQUIPO=>" + num_equipo  + ", GASTOS_GENERAL=>" + gasto_general +  "]\n" ;
	}
	
	/*  Metodo que va recorriendo el vector de jugadores y uno a uno los va anyadiendo a una 
		lista que sera mostrada posteriormente. */
		
	public String retornaJugadoresEquipo(){
		String listaJugadores = "";
		
			for( int i = 0; i < jugadores.size(); i++ ){
								
				listaJugadores+=jugadores.get(i).toString()+"\n";
				// Los jugadores (toda la informacion mediante toString()) es anyadida a la lista que se mostrara por pantalla.
				
			}
			return listaJugadores;
	}
	
	public float sueldoPlantilla(){
		
		float sueldo=0;
		
		for( int i = 0; i < jugadores.size(); i++ ){
			
			sueldo=sueldo+jugadores.get(i).getCosteAnual();

		}
		
		return sueldo;
	}

	// Metodo que busca un jugador en el vector y le cambia la clausula actual. 
	
	public void setClausula(String nombreJugador, float clausula){
		
		for( int i = 0; i < jugadores.size(); i++ ){
			//System.out.println("1");
			if(jugadores.get(i).getNombre().equals(nombreJugador)){
				
				jugadores.get(i).setClausula(clausula);
				
			}
		}
	}
	
	public void setPosicion(String nombreJugador, String posicion){
		
		for( int i = 0; i < jugadores.size(); i++ ){
			//System.out.println("1");
			if(jugadores.get(i).getNombre().equals(nombreJugador)){
				
				jugadores.get(i).setPosicion(posicion);
				
			}
		}
	}
	

	// Devuelve el valor de la caja actual. 
	
	public float getCajaActual() {
		return cajaActual;
	}

	// Modifica el valor de la caja actual segun el valor introducido como parametro
	
	public void setCajaActual(float cajaActual) {
		this.cajaActual = cajaActual;
	}
}