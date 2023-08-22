package backendjavarelations.exercise_ex02;

public class Seat {
    
    private final int number;
    private final char letter;
    private boolean occupied;

    public Seat(int number, char letter) {
        this.number = number;
        this.letter = letter;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getNumber() {
        return number;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return String.valueOf(number) + letter + " " + (occupied ? "X" : " ");
    }
    
}
