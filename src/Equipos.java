import java.util.ArrayList;
import java.util.Scanner;

public class Equipos {

	//Declaracion de variables a usar en esta clase

	private static ArrayList<Equipo> equipos = new ArrayList<Equipo>();
	private static ArrayList<Traspaso> traspasos = new ArrayList<Traspaso>();
	private Equipo equipo;
	private String nombreEquipo; 
	private float cajaActual, gastos_generales;
	private int numAbonados;
	static Scanner entrada1 = new Scanner(System.in);
	static Scanner entrada2 = new Scanner(System.in);
			
	public Equipos() {
	}
	
	// Metodo que anyade un equipo nuevo al vector de equipos
	
	public void addEquipo(){
		
		System.out.println("Nombre del nuevo equipo: ");
		nombreEquipo=entrada1.nextLine();
		
		System.out.println("Introduce su caja actual: ");
		cajaActual=entrada2.nextInt();

		System.out.println("Introduce el numero de abonados: ");
		numAbonados=entrada2.nextInt();
		
		System.out.println("Introduce los gastos fijos: ");
		gastos_generales=entrada2.nextInt();
		
		equipo = new Equipo(nombreEquipo, cajaActual, numAbonados, gastos_generales);
		// Le pasamos los datos al constructor de Equipo para que guarde el nuevo equipo.
		
		equipos.add(equipo);
		// Añadimos el nuevo equipo al vector de equipos.
	}
	
	// Metodo que anyade un jugador a un equipo si y solo si el equipo existe
	
	public void anyadirJugadorEquipo(String team){

		for( int i = 0; i < equipos.size(); i++ ){
			
			if(equipos.get(i).getNombreEquipo().equals(team)){
					
				equipos.get(i).addJugador();
				System.out.println("\nJugador anyadido en el: "+equipos.get(i).getNombreEquipo() + "\n");
				
			}
		}
	}
	
	// Metodo que busca un equipo en el vector de equipos. True si lo ha encontrado, falso si no lo encuentra.
	
	public boolean buscarEquipo(String team){
		
		for( int i = 0; i < equipos.size(); i++ ){
		
			if(team.equals(equipos.get(i).getNombreEquipo())){
				
				return true;
			}
		}
		return false;
	}
	
	/* Metodo que compara el equipo pasado por referencia con cada uno de los equipos del vector. 
		Si esta en el vector, lo devuelve. */
		
	public Equipo getEquipo(String team) {
		
		Equipo team1 = new Equipo("",0,0,0);
		
		for( int i = 0; i < equipos.size(); i++ ){
			
			if(team.equals(equipos.get(i).getNombreEquipo())){
				
				team1 = equipos.get(i);
			}
		}
		return team1;
	}
	
	// Metodo que busca un jugador en el vector de equipos 
	
	public boolean buscarJugador(String jugador){
		
		for( int i = 0; i < equipos.size(); i++ ){
			
			if(equipos.get(i).buscarJugador(jugador)){
				
				return true;
			}
		}
		return false;
	}
	

	// Metodo que devuelve una lista con todos los jugadores de todos los equipos.
	
	public String listarJugadores(){

		String listaJugadores="";
		
		for( int i = 0; i < equipos.size(); i++ ){
			
			listaJugadores+="\n EQUIPO=> "+equipos.get(i).getNombreEquipo() + "\n" + equipos.get(i).retornaJugadoresEquipo();
		}
		
		return listaJugadores;
	}
	
	// Metodo que devuelve todos los traspasos realizados
	
	public String listarTraspasos(){
		
		String listarTraspasos="";
		
		for( int i = 0; i < traspasos.size(); i++ ){
			
			listarTraspasos+=traspasos.get(i).toString();
			
			//System.out.println(traspasos.get(i).toString());
		}	
		
		return listarTraspasos;
	}
	
	/*  Metodo para mostrar todos los valores de un objeto, en este caso, el nombre, la caja, 
		el numero de abonados y el id del equipo que hayamos buscado. */
		
	@Override //lista 
	public String toString() {
		
		String listaEquipos = "";
	
		for( int i = 0; i < equipos.size(); i++ ){
			
			listaEquipos += "\n" + equipos.get(i).toString();
		}
		
		return listaEquipos + "\n";
	}
	
	public void verificarDemarc(){
		
		String ver="";
		
		for( int i = 0; i < equipos.size(); i++ ){
					
					ver += "\n" + equipos.get(i).getNombreEquipo() + "  " + equipos.get(i).verificarDemarc() + "\n";
				}
		System.out.println(ver);
		
	}
	
	
	public void fairPlay(){
		
		float x=0;
		String listaEquipos1 = "";
		
		for( int i = 0; i < equipos.size(); i++ ){
			
			 x=equipos.get(i).getCajaActual()-((equipos.get(i).sueldoPlantilla())*2+equipos.get(i).getGastoGeneral());
			 
			 if(x>0){
				 listaEquipos1 += "\n" + equipos.get(i).toString() + "  => CUMPLE FAIR PLAY";
			 }else{
				 listaEquipos1 += "\n" + equipos.get(i).toString() + "  => NO CUMPLE FAIR PLAY";
			 }
		}
		
		System.out.println(listaEquipos1);
		
	}

	// Metodo que realiza el traspaso de dos jugadores.
	
	public void traspaso(String nombreJugador, String equipoOrigen, String equipoDestino, float clausula){
		
		Jugador jugador1, jugador2;
		int k = 0;
		
		for( int i = 0; i < equipos.size(); i++ ){
			if(equipos.get(i).buscarJugador(nombreJugador)){
				for(int j = 0; j < equipos.size(); j++ ){
					if(equipos.get(j).getNombreEquipo().equals(equipoOrigen)){
						for(int x = 0; x < equipos.size(); x++){
							if(equipos.get(x).getNombreEquipo().equals(equipoDestino)){
								while (k==0){
								
								jugador1=(Jugador)equipos.get(i).getJugador(nombreJugador);
								float clausulaPagada = jugador1.getClausula();
								equipos.get(j).setClausula(nombreJugador, clausula);
								jugador2=(Jugador)equipos.get(i).getJugador(nombreJugador);
								equipos.get(j).setCajaActual(equipos.get(j).getCajaActual()+clausulaPagada);
								equipos.get(x).setCajaActual(equipos.get(x).getCajaActual()-clausulaPagada);
								equipos.get(x).addJugador(jugador2);
								equipos.get(j).removeJugador(nombreJugador);
								traspasos.add(new Traspaso(jugador1.getNombre(), equipos.get(j).getNombreEquipo(), equipos.get(x).getNombreEquipo(), jugador1.getClausula()));
								k++;						
							}	}
						}				
					}
				}
			}else{System.out.println("\nError al realizar traspaso. \n");}	
		}
	}
	
	
	public void setPosicion(String nombreJugador, String posicion){
		
		boolean flag=false;
		
		for( int i = 0; i < equipos.size(); i++ ){
			if(equipos.get(i).buscarJugador(nombreJugador)){
				
				equipos.get(i).setPosicion(nombreJugador, posicion);
				System.out.println("Demarcación "+nombreJugador+" modificada");
				flag=true;
			}
		}
		if(flag==false){
				System.out.println("Jugador no encontrado - no se ha modificado clausula");
		}
	}
}
	
	
