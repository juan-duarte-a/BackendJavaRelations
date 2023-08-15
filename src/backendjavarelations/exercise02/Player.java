package backendjavarelations.exercise02;

public class Player {
    
    private static int idCount = 1;
    private int id;
    private String name;

    public Player(String name) {
        this.id = idCount++;
        this.name = name;
    }
    
    public boolean shot(Revolver r) {
        return r.shot();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
