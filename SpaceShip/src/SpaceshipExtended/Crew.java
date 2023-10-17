package SpaceshipExtended;

import spaceship.*;

public class Crew extends Traveler{
	
	private String position;
	private double pay;
    private int flightHours;
    
    public Crew(String name, Location location, String position) {
        super(position, location); 
        this.position = "";
        this.pay = 0.0;
        this.flightHours = 0;
    }

    public Crew(String name, Location current, String position,int flightHours) {
        super(name, current); 
        this.position = position;
        this.flightHours = flightHours;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(int flightHours) {
        this.flightHours = flightHours;
    }

    @Override
    public void move(SpaceShip s) {
        this.flightHours += s.getFlightHours();
    }

    @Override
    public String toString() {
        return "Crew [name=" + getName() + ", id=" + getID() + ", current=" + getCurrent() +
               ", position=" + position + ", pay = $" + pay + ", flight hours = " + flightHours + "]";
    }
}

