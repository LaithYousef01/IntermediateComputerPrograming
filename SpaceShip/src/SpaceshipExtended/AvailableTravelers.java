package SpaceshipExtended;
import spaceship.*;

public class AvailableTravelers {
	
	  private Traveler[] travelers;
	  private int numOfTravelers;

	    public AvailableTravelers() {
	        travelers = new Traveler[20];
	        numOfTravelers = 0;
	    }

	    public AvailableTravelers(int capacity) {
	        travelers = new Traveler[capacity];
	        numOfTravelers = 0;
	    }

	    public boolean addTraveler(Traveler t) {
	        if (numOfTravelers >= travelers.length || containsTraveler(t)) {
	            return false; 
	        }

	        travelers[numOfTravelers] = t;
	        numOfTravelers++;
	        return true;
	    }

	    public Traveler findTravelerByName(String name) {
	        for (int i = 0; i < numOfTravelers; i++) {
	            if (travelers[i] != null && travelers[i].getName() != null && travelers[i].getName().equals(name)) {
	                return travelers[i];
	            }
	        }
	        return null;
	    }
	   
	    private boolean containsTraveler(Traveler t) {
	        for (int i = 0; i < numOfTravelers; i++) {
	            if (travelers[i] != null && travelers[i].getID() == t.getID()) {
	                return true;
	            }
	        }
	        return false;
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Available Travelers:\n");
	        for (int i = 0; i < numOfTravelers; i++) {
	            sb.append(travelers[i].toString()).append("\n");
	        }
	        return sb.toString();
	    }
	}
