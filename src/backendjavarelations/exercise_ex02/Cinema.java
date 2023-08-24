package backendjavarelations.exercise_ex02;

import backendjavarelations.exercise_ex02.services.MovieService;
import backendjavarelations.exercise_ex02.services.MoviegoerService;
import backendjavarelations.exercise_ex02.services.SeatService;
import java.text.DecimalFormat;

public class Cinema {

    private final MoviegoerService moviegoerService;
    private final MovieService movieService;
    private final SeatService seatService;
    private Movie movieInBillboard;
    private int ticketPrice;
    
    private final static int MIN_TICKET_PRICE = 5;
    private final static int MAX_TICKET_PRICE = 10;
    
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.initializeCinema();
        cinema.openCinema();
        cinema.showCinemaStatus();
    }

    public Cinema() {
        moviegoerService = new MoviegoerService();
        seatService = new SeatService();
        movieService = new MovieService();
    }
    
    private void initializeCinema() {
        movieService.loadMovies();
        movieInBillboard = movieService.getRandomMovie();
        ticketPrice = (int) (Math.random() 
                * (MAX_TICKET_PRICE - MIN_TICKET_PRICE)) + MIN_TICKET_PRICE;
    }
    
    public void openCinema() {
        moviegoerService.generateMoviegoers();
        while (moviegoerService.isPeopleInQueue() && seatService.areFreeSeats()) {
            Moviegoer moviegoer = moviegoerService.giveNextMoviegoer();
            if (isPersonAllowed(moviegoer)) {
                seatService.placePerson(moviegoer);
            }
        }
    }
    
    private boolean isPersonAllowed(Moviegoer moviegoer) {
        return moviegoer.getMoney() >= ticketPrice
                && moviegoer.getAge() >= movieInBillboard.getMinAge();
    }
    
    public void showCinemaStatus() {
        System.out.println("Presentando: " + movieInBillboard);
        System.out.printf("Valor de entrada: $%d%n%n", ticketPrice);
        seatService.showSeats();
        System.out.println();
        System.out.println("Tasa de ocupación de asientos: " 
                + (new DecimalFormat("0.0%")).format(seatService.occupationRate()));
    }
    
}
