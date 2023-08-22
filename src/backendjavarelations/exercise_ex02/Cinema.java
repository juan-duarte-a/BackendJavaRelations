package backendjavarelations.exercise_ex02;

import backendjavarelations.exercise_ex02.services.MovieService;
import backendjavarelations.exercise_ex02.services.MoviegoerService;


public class Cinema {

    private Seat[][] seats;
    private static final int ROWS = 8;
    private static final int COLUMNS = 6;
    private final MoviegoerService moviegoerService;
    private final MovieService movieService;
    private Movie movieInBillboard;
    
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.initializeCinema();
        cinema.showCinemaStatus();
        
    }

    public Cinema() {
        moviegoerService = new MoviegoerService();
        movieService = new MovieService();
        movieService.loadMovies();
    }
    
    private void initializeCinema() {
        movieInBillboard = movieService.getRandomMovie();
        
        seats = new Seat[ROWS][COLUMNS];
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seats[i][j] = new Seat(i+1, (char) (65+j));
            }
        }
    }
    
    public void showSeats() {
        for (int i = ROWS-1; i >= 0; i--) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seats[i][j]);
                if (j < COLUMNS-1)
                    System.out.print("|");
            }
            System.out.println();
        }
    }
    
    public void openCinema() {
        
    }
    
    public void showCinemaStatus() {
        System.out.println("Presentando: " + movieInBillboard + "\n");
        showSeats();
    }
    
}
