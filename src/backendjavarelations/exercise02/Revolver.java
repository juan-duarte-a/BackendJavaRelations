package backendjavarelations.exercise02;

public class Revolver {
    
    private int position;
    private int waterPosition;
    private final static int CHAMBERS = 6;

    public final void resetPosition() {
        position = (int) (Math.random() * CHAMBERS);
    }
    
    public final void loadGun() {
        waterPosition = (int) (Math.random() * CHAMBERS);
    }
    
    public boolean shot() {
        return position == waterPosition;
    }
    
    public void nextPosition() {
        if (position == CHAMBERS-1)
            position = 0;
        else
            position++;
    }
}
