package SpaceshipExtended;

import spaceship.*;
import java.util.Scanner;



public class SciFiTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AvailableTravelers availableTravelers = new AvailableTravelers();

        for (int i = 1; i <= 10; i++) {
            Traveler traveler;
            if (i <= 4) {
                traveler = new Passenger("Passenger" + i, Location.EARTH, SeatCategory.COACH, i);
            } else {
                String position = i % 2 == 0 ? "Captain" : "Co-Captain";
                traveler = new Crew("Crew" + i, Location.MARS, position);
            }
            availableTravelers.addTraveler(traveler);
        }

        SpaceShip spaceship1 = new SpaceShip("Spaceship1", Location.EARTH, Location.MARS, 10, 100);
        SpaceShip spaceship2 = new SpaceShip("Spaceship2", Location.BELT, Location.RING, 10,100);

        boolean quit = false;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add traveler to a Spaceship");
            System.out.println("2. Search for traveler on a Spaceship");
            System.out.println("3. Move a spaceship to a new location");
            System.out.println("4. Display a list of Available Travelers");
            System.out.println("5. Display a list of Travelers on a specific Spaceship");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addTravelerToSpaceship(scanner, availableTravelers, spaceship1, spaceship2);
                    break;
                case 2:
                    searchTravelerOnSpaceship(scanner, availableTravelers, spaceship1, spaceship2);
                    break;
                case 3:
                    moveSpaceship(scanner, spaceship1, spaceship2);
                    break;
                case 4:
                    System.out.println(availableTravelers);
                    break;
                case 5:
                    displayTravelersOnSpaceship(scanner, spaceship1, spaceship2);
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!quit);

        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void addTravelerToSpaceship(Scanner scanner, AvailableTravelers availableTravelers,
                                               SpaceShip spaceship1, SpaceShip spaceship2) {
        System.out.println("Enter traveler's name:");
        String travelerName = scanner.nextLine();

        Traveler traveler = availableTravelers.findTravelerByName(travelerName);

        if (traveler != null) {
            System.out.println("Enter spaceship name:");
            String spaceshipName = scanner.nextLine();

            SpaceShip spaceship = spaceshipName.equals("Spaceship1") ? spaceship1 : spaceship2;

            if (spaceship.addTraveler(traveler)) {
                System.out.println("Traveler added to " + spaceshipName + " successfully.");
            } else {
                System.out.println("Failed to add traveler to " + spaceshipName + ".");
            }
        } else {
            System.out.println("Traveler not found.");
        }
    }

    private static void searchTravelerOnSpaceship(Scanner scanner, AvailableTravelers availableTravelers,
                                                 SpaceShip spaceship1, SpaceShip spaceship2) {
        System.out.println("Enter traveler's name:");
        String travelerName = scanner.nextLine();

        Traveler traveler = availableTravelers.findTravelerByName(travelerName);

        if (traveler != null) {
            System.out.println("Enter spaceship name:");
            String spaceshipName = scanner.nextLine();

            SpaceShip spaceship = spaceshipName.equals("Spaceship1") ? spaceship1 : spaceship2;

            if (spaceship.isOnBoard(traveler)) {
                System.out.println(travelerName + " is on board " + spaceshipName + ".");
            } else {
                System.out.println(travelerName + " is not on board " + spaceshipName + ".");
            }
        } else {
            System.out.println("Traveler not found.");
        }
    }

    private static void moveSpaceship(Scanner scanner, SpaceShip spaceship1, SpaceShip spaceship2) {
        System.out.println("Enter spaceship name:");
        String spaceshipName = scanner.nextLine();

        SpaceShip spaceship = spaceshipName.equals("Spaceship1") ? spaceship1 : spaceship2;

        System.out.println("Enter new destination (EARTH, BELT, MARS, RING):");
        Location newDestination = Location.valueOf(scanner.nextLine());

        spaceship.setDestination(newDestination);
        if (spaceship.move()) {
            System.out.println(spaceshipName + " has moved to " + newDestination + ".");
        } else {
            System.out.println("Failed to move " + spaceshipName + ".");
        }
    }

    private static void displayTravelersOnSpaceship(Scanner scanner, SpaceShip spaceship1, SpaceShip spaceship2) {
        System.out.println("Enter spaceship name:");
        String spaceshipName = scanner.nextLine();

        SpaceShip spaceship = spaceshipName.equals("Spaceship1") ? spaceship1 : spaceship2;

        System.out.println("Travelers on " + spaceshipName + ":");
        System.out.println(spaceship.getTravelers());
    }
}