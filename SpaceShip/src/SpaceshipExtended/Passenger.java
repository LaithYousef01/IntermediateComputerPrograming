package SpaceshipExtended;

import spaceship.*;

public class Passenger extends Traveler {
    private double cost;
    private SeatCategory seat;
    private int rewardsPoints;

    public Passenger(String name, Location current, SeatCategory seatCategory, int rewardsPoints) {
        super(name, current);
        this.cost = 0.0;
        this.seat = SeatCategory.NOSEAT; 
        this.rewardsPoints = 0; 
    }

    public Passenger(String name, int id, Location current, double cost, SeatCategory seat, int rewardsPoints) {
    	super(name, current);
        this.cost = cost;
        this.rewardsPoints = rewardsPoints;
        this.seat = seat;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public SeatCategory getSeat() {
        return seat;
    }

    public void setSeat(SeatCategory seat) {
        this.seat = seat;
        updateCostBasedOnSeat();
    }

    public int getRewardsPoints() {
        return rewardsPoints;
    }

    public void setRewardsPoints(int rewardsPoints) {
        this.rewardsPoints = rewardsPoints;
    }

    @Override
    public void move(SpaceShip s) {
        if (rewardsPoints >= 10000) {
            if (seat != SeatCategory.FIRST) {
                seat = SeatCategory.FIRST;
                updateCostBasedOnSeat();
            } else {
                cost *= 0.8;
            }
            rewardsPoints = 0;
            rewardsPoints += (s.getFlightHours() * 100);
        }
    }

    private void updateCostBasedOnSeat() {
        switch (seat) {
            case FIRST:
                cost = 1499.00;
                break;
            case BUSINESS:
                cost = 998.00;
                break;
            case COACH:
                cost = 449.00;
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Passenger [name=" + getName() + ", id=" + getID() + ", current=" + getCurrent() +
               ", seat=" + seat + ", cost = $" + String.format("%.2f", cost) +
               ", rewardsPoints = " + rewardsPoints + "]";
    }
}