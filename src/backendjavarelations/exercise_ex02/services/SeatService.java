package backendjavarelations.exercise_ex02.services;

import backendjavarelations.exercise_ex02.Moviegoer;
import backendjavarelations.exercise_ex02.Seat;
import java.util.LinkedList;
import java.util.List;

public class SeatService {
    
    private final Seat[][] seats;
    private final List<Seat> freeSeats;
    private static final int ROWS = 8;
    private static final int COLUMNS = 6;

    public SeatService() {
        seats = new Seat[ROWS][COLUMNS];
        freeSeats = new LinkedList<>();
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seats[i][j] = new Seat(i+1, (char) (65+j));
                freeSeats.add(seats[i][j]);
            }
        }
    }
    
    public boolean areFreeSeats() {
        return !freeSeats.isEmpty();
    }
    
    public void placePerson(Moviegoer moviegoer) {
        Seat seat = giveFreeSeat();
        if (seat != null) {
            seat.setMoviegoer(moviegoer);
            freeSeats.remove(seat);
        }
    }
    
    private Seat giveFreeSeat() {
        if (!areFreeSeats())
            return null;
        
        return freeSeats.get((int) (Math.random() * freeSeats.size()));
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
    
    public double occupationRate() {
        return 1 - (double) freeSeats.size()/(ROWS * COLUMNS);
    }
    
}
