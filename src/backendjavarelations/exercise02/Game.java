package backendjavarelations.exercise02;

import colors.ConsoleColors;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Player> players = new ArrayList<>();
    Revolver revolver = new Revolver();
    
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.initialize();
        game.start();
    }
    
    public void initialize() {
        int numberOfPlayers;

        while (true) {            
            System.out.print("Cantidad de jugadores (2-6) -> ");
            numberOfPlayers = sc.nextInt();
            if (numberOfPlayers > 1 && numberOfPlayers < 7)
                break;
        }
        
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("Jugador " + (i+1)));
        }
    }
    
    public void start() throws InterruptedException {
        game:
        while (true) {
            revolver.loadGun();
            revolver.resetPosition();
            System.out.println("¡Comenzando juego!");
            
            start:
            while (true) {                
                for (Player player : players) {
                    System.out.println(ConsoleColors.CYAN + player + ConsoleColors.RESET + " disparando...");

                    Thread.sleep(1000);
                    for (int i = 0; i < 3; i++) {
                        System.out.print(".");
                        Thread.sleep(1000);
                    }
                    System.out.println();

                    if (player.shot(revolver)) {
                        System.out.println(ConsoleColors.RED_BOLD + "¡Pum!" + ConsoleColors.RESET);
                        Thread.sleep(500);
                        System.out.println(ConsoleColors.RED_BOLD + "¡Mojado!\n" + ConsoleColors.RESET);
                        System.out.println(player + " ha perdido.\n");
                        System.out.println("¿Comenzar nuevamente (S/N)?");
                        if (sc.next().equalsIgnoreCase("n"))
                            break game;
                        else
                            break start;
                    } else {
                        System.out.println("...");
                        Thread.sleep(500);
                        System.out.println(ConsoleColors.YELLOW + "Nada sucede.\n" + ConsoleColors.RESET);
                        Thread.sleep(500);
                        System.out.println("Siguiente jugador.");
                        revolver.nextPosition();
                    }
                }
            }
        }
        System.out.println("Fin del juego");
    }
    
}
