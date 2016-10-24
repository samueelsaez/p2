import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Gestion {

	static Scanner entrada = new Scanner(System.in);
	static Scanner entrada1 = new Scanner(System.in);
	static Equipos equipos = new Equipos();
	
	public static void main(String[] args) {
		
		int opcion = -1;
		String equipo;
		
		/* Nota: Hemos realizado lo pedido en el enunciado de la practica a excepcion de 
				gestionar los ERRORES en la entrada de las opciones 1, 2, 3 
		 		hemos tenido problemas con los scanner intentado que de nuevo pidieran la 
				informacion que no se ha introducido correctamente. */
				
		while(true){
		
				System.out.println("------------MENU GESTION EQUIPOS------------\n");
			
				System.out.println("1 - REGISTRAR NUEVO EQUIPO");
				System.out.println("2 - REGISTRAR UN NUEVO JUGADOR");
				System.out.println("3 - REGISTRAR NUEVO TRANSPASO DE JUGADOR");
				System.out.println("4 - LISTAR DATOS BASICOS DE LOS EQUIPOS");
				System.out.println("5 - LISTAR LOS JUGADORES DE CADA EQUIPO");
				System.out.println("6 - MOSTRAR TRANSPASOS");
				System.out.println("7 - GUARDAR Y CERRAR APLICACION");
				System.out.println("8 - CAMBIAR DEMARCACIÓN JUGADOR");
				System.out.println("9 - EVALUAR EL FAIR PLAY FINANCIERO\n");
				System.out.print("-- Introduzca opcion: ");
				
				try{
					opcion = entrada.nextInt();
				}catch(Exception e){
					entrada = new Scanner(System.in);
					System.out.println("Error, opcion no valida");
				}
				
				switch(opcion){// Switch mediante el cual segun la opcion introducida del menu, hara uno de los 7 casos.
					// Caso 1: introduccion de un nuevo equipo
					case 1:
						equipos.addEquipo();
						break;
					// Caso 2: comprobacion de la existencia de un equipo y insercion de un nuevo jugador en dicho equipo.
					case 2:
						System.out.println("Introducir equipo al que registrar nuevo jugador: ");
						equipo=entrada1.nextLine();
						
						if (equipos.buscarEquipo(equipo))
						{
							equipos.anyadirJugadorEquipo(equipo);
						}else{
							System.out.println("Equipo no encontrado. \n");
						}
						break;
					/*  Caso 3: introduccion por pantalla del jugador a traspasar, asi como su equipo de origen, de destino
						y su nueva clausula. Posteriormente, se procede a realizar el traspaso con dichos datos. */
					case 3:
						String nombre, ciudadOrigen, ciudadDestino;
						float clausula;
						System.out.println("Introducir jugador a traspasar:");
						nombre = entrada1.nextLine();
						System.out.println("Introducir Equipo Origen:");
						ciudadOrigen = entrada1.nextLine();
						System.out.println("Introducir Equipo Destino:");
						ciudadDestino = entrada1.nextLine();
						System.out.println("Introducir nueva clausula rescision:");
						clausula = entrada.nextFloat();
						
						equipos.traspaso(nombre,ciudadOrigen,ciudadDestino, clausula); //caso de prueba
						break;
					// Caso 4: mostrar mediante toString() la lista de equipos que se han creado.
					case 4:
							String x = equipos.toString();
							System.out.println(x);
						break;
					// Caso 5: mostrar todos los jugadores que hay registrados en cada uno de los equipos.
					case 5:
							String y = equipos.listarJugadores();
							System.out.println(y);
						break;
					// Caso 6: listar por orden de mayor a menor segun la clausula de traspaso, cada uno de los traspasos realizados.
					case 6:	
						String yd=equipos.listarTraspasos();
						System.out.println(yd);
						break;
						// Caso 7: escribimos los datos en un fichero y cerramos la aplicacion.
					case 7:
						File f;
						System.out.println("Introduzca nombre fichero: ");
						String nombrefichero = entrada1.nextLine();
						f= new File(nombrefichero);
						try{
							FileWriter w = new FileWriter(f);
							BufferedWriter bw = new BufferedWriter(w);
							PrintWriter wr = new PrintWriter(bw);
							String teams = equipos.toString();
							String players = equipos.listarJugadores();
							String traspasos = equipos.listarTraspasos();
							wr.write("-----EQUIPOS-----\n"+teams);      //escribimos en el archivo
							wr.append("-----JUGADORES-----\n"+players); //concatenamos en el archivo sin borrar lo existente
							wr.append("-----TRASPASOS-----\n"+traspasos);
							wr.close();
							bw.close();
							System.out.println("Guardado en "+nombrefichero+".txt");
							
						}catch(IOException e){};

						System.out.println("Cerrando...");
						System.exit(0);
						break;
					case 8:	
						
						String posicionNew="";
						String nameJugador="";
						
						System.out.println("Introduce nombre jugador");
						nameJugador=entrada1.nextLine();
						System.out.println("Introduce nueva demarcación");
						posicionNew = entrada1.nextLine();
							 
						equipos.setPosicion(nameJugador, posicionNew);
						
						break;
					case 9:
						equipos.fairPlay();
						break;
					default:
						// Se dara en caso de que no se de ninguna de los Case anteriores.
						System.out.println("\n\n\n\nError - Opción no valida\n");
				}
		}
	}
}