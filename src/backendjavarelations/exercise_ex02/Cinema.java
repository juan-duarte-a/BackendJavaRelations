package backendjavarelations.exercise_ex02;


public class Cinema {

    private Seat[][] seats;
    private static final int ROWS = 8;
    private static final int COLUMNS = 6;
    
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.initializeCinema();
        cinema.showSeats();
    }
    
    private void initializeCinema() {
        seats = new Seat[ROWS][COLUMNS];
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seats[i][j] = new Seat(i+1, (char) (65+j));
            }
        }
    }
    
    public void showSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.println(seats[i][j]);
            }
        }
    }
    
}
