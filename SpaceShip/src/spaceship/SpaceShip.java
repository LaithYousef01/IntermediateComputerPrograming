package spaceship;

import java.util.ArrayList;
import java.util.List;

public class SpaceShip {
    private String name;
    private Location current;
    private Location destination;
    private int capacity;
    private List<Traveler> travelers;
    private int flightHours;

    public SpaceShip() {
        this.name = "";
        this.current = Location.EARTH;
        this.destination = Location.MARS;
        this.capacity = 0;
        this.travelers = new ArrayList<>();
        this.flightHours = 0;
    }

    public SpaceShip(String name, Location current, Location destination, int capacity, int flighthours) {
        this.name = name;
        this.current = current;
        this.destination = destination;
        this.capacity = capacity;
        this.travelers = new ArrayList<>();
        this.flightHours = 0;
    }

    public String getName() {
        return name;
    }

    public Location getCurrent() {
        return current;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Traveler> getTravelers() {
        return travelers;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public boolean move() {
        if (destination != null && !current.equals(destination) && travelers.size() > 0) {
            current = destination;
            flightHours += 1;
            return true;
        }
        return false;
    }

    public boolean addTraveler(Traveler traveler) {
        if (travelers.size() < capacity) {
            travelers.add(traveler);
            return true;
        }
        return false;
    }

    public boolean isOnBoard(Traveler traveler) {
        return travelers.contains(traveler);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpaceShip [name=").append(name);
        sb.append(", current=").append(current);
        sb.append(", destination=").append(destination);
        sb.append(", capacity=").append(capacity);
        sb.append(", travelers=").append(travelers.size());
        sb.append(", flightHours=").append(flightHours).append("]\n");

        // Append information of travelers on board
        for (Traveler traveler : travelers) {
            sb.append(traveler).append("\n");
        }

        return sb.toString();
    }
}