package spaceship;

public abstract class Traveler {
    private static int nextIDNum = 1;
    private int id;
    private String name;
    private Location current;

    public Traveler(String name, Location current) {
        this.name = name;
        this.current = current;
        this.id = nextIDNum++;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getCurrent() {
        return current;
    }

    public void setCurrent(Location current) {
        this.current = current;
    }

    public abstract void move(SpaceShip s);

    public abstract String toString();
}

