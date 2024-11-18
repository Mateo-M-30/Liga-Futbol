package src;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.Scanner;

	public class LigaFutbol {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String etapa;
	        
	        // Definimos las etapas y el número de equipos necesarios
	        int numEquipos;
	        while (true) {
	            System.out.print("Ingrese la etapa del torneo (octavos, cuartos, semifinales, final): ");
	            etapa = scanner.nextLine().trim().toLowerCase();
	            switch (etapa) {
	                case "octavos":
	                    numEquipos = 16;
	                    break;
	                case "cuartos":
	                    numEquipos = 8;
	                    break;
	                case "semifinales":
	                    numEquipos = 4;
	                    break;
	                case "final":
	                    numEquipos = 2;
	                    break;
	                default:
	                    System.out.println("Etapa inválida. Intente nuevamente.");
	                    continue;
	            }
	            break;
	        }
	        
	        // Ingreso de nombres de los equipos
	        List<String> equipos = new ArrayList<>();
	        System.out.println("Ingrese los nombres de los " + numEquipos + " equipos:");
	        for (int i = 0; i < numEquipos; i++) {
	            System.out.print("Nombre del equipo " + (i + 1) + ": ");
	            equipos.add(scanner.nextLine().trim());
	        }
	        
	        // Simulamos el torneo desde la etapa seleccionada hasta la final
	        while (numEquipos > 1) {
	            equipos = simularEtapa(equipos, etapa);
	            numEquipos /= 2;
	            switch (numEquipos) {
	                case 8:
	                    etapa = "cuartos";
	                    break;
	                case 4:
	                    etapa = "semifinales";
	                    break;
	                case 2:
	                    etapa = "final";
	                    break;
	            }
	        }

	        System.out.println("\nEl ganador del torneo es: " + equipos.get(0));
	        scanner.close();
	    }

	    // Método para simular una etapa del torneo
	    public static List<String> simularEtapa(List<String> equipos, String etapa) {
	        Collections.shuffle(equipos);
	        List<String> ganadores = new ArrayList<>();
	        System.out.println("\nPartidos para la etapa de " + etapa + ":");
	        for (int i = 0; i < equipos.size(); i += 2) {
	            String equipo1 = equipos.get(i);
	            String equipo2 = equipos.get(i + 1);
	            String ganador = simularPartido(equipo1, equipo2);
	            System.out.println("Partido: " + equipo1 + " vs " + equipo2 + " - Ganador: " + ganador);
	            ganadores.add(ganador);
	        }
	        return ganadores;
	    }

	    // Método para simular un partido y determinar un ganador aleatoriamente
	    public static String simularPartido(String equipo1, String equipo2) {
	        return Math.random() < 0.5 ? equipo1 : equipo2;
	    }
	}