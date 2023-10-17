package spaceship;

import java.util.Scanner;

public class SpaceShipTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // arrays for traveler and spaceships //
        Traveler[] travelers = new Traveler[4];
        SpaceShip[] spaceShips = new SpaceShip[2];

       
        for (int i = 0; i < 4; i++) {
            System.out.println("Data for Traveler " + (i + 1));
            travelers[i] = createTraveler(scanner);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("Data for SpaceShip " + (i + 1));
            spaceShips[i] = createSpaceShip(scanner);
        }

        boolean exit = false;

        // text menu //
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1: Add traveler to a Spaceship");
            System.out.println("2: Search for traveler on a Spaceship");
            System.out.println("3: Move a spaceship to a new location");
            System.out.println("4: Exit");
            System.out.println();
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addTravelerToSpaceShip(scanner, travelers, spaceShips);
                    break;
                case 2:
                    searchTravelerOnSpaceShip(scanner, travelers, spaceShips);
                    break;
                case 3:                
                    moveSpaceShip(scanner, spaceShips);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

        scanner.close();
    }
		// method to create traveler info //
    private static Traveler createTraveler(Scanner scanner) {
        System.out.print("Enter traveler's name: ");
        scanner.nextLine();
        System.out.print("Enter current location (EARTH, BELT, MARS, RING): ");
        Location.valueOf(scanner.nextLine());
		return null;
    }

    // method to create spaceship object //
    private static SpaceShip createSpaceShip(Scanner scanner) {
        System.out.print("Enter spaceship name: ");
        scanner.nextLine();
        System.out.print("Enter current location (EARTH, BELT, MARS, RING): ");
        Location.valueOf(scanner.nextLine());
        System.out.print("Enter destination (EARTH, BELT, MARS, RING): ");
        Location.valueOf(scanner.nextLine());
        System.out.print("Enter capacity: ");
        scanner.nextInt();
        scanner.nextLine(); 
        return new SpaceShip();
    }

    // method to add traveler to a spaceship //
    private static void addTravelerToSpaceShip(Scanner scanner, Traveler[] traveler, SpaceShip[] spaceShips) {
        System.out.print("Enter traveler's name: ");
        String travelerName = scanner.nextLine();
        System.out.print("Enter spaceship name: ");
        String spaceshipName = scanner.nextLine();

        Traveler travelerToAdd = findTravelerByName(travelerName, traveler);
        SpaceShip spaceShipToAddTo = findSpaceShipByName(spaceshipName, spaceShips);

        if (travelerToAdd != null && spaceShipToAddTo != null) {
            boolean success = spaceShipToAddTo.isOnBoard(travelerToAdd);
            if (success) {
                System.out.println("Boarding successful!");
            } else {
                System.out.println("Boarding failed.");
            }
        } else {
            System.out.println("Invalid traveler or spaceship name.");
        }
    }

    // method to search for a traveler on a spaceship //
    private static void searchTravelerOnSpaceShip(Scanner scanner, Traveler[] travelers, SpaceShip[] spaceShips) {
        System.out.print("Enter traveler's name: ");
        String travelerName = scanner.nextLine();
        System.out.print("Enter spaceship name: ");
        String spaceshipName = scanner.nextLine();

        Traveler travelerToSearch = findTravelerByName(travelerName, travelers);
        SpaceShip spaceShipToSearch = findSpaceShipByName(spaceshipName, spaceShips);

        if (travelerToSearch != null && spaceShipToSearch != null) {
            boolean isOnBoard = spaceShipToSearch.isOnBoard(travelerToSearch);
            if (isOnBoard) {
                System.out.println(travelerName + " is on board " + spaceshipName);
            } else {
                System.out.println(travelerName + " is not on board " + spaceshipName);
            }
        } else {
            System.out.println("Invalid traveler or spaceship name.");
        }
    }

    // method to move a spaceship to a new location //
    private static void moveSpaceShip(Scanner scanner, SpaceShip[] spaceShips) {
        System.out.print("Enter spaceship name: ");
        String spaceshipName = scanner.nextLine();

        SpaceShip spaceShipToMove = findSpaceShipByName(spaceshipName, spaceShips);

        if (spaceShipToMove != null) {
            System.out.print("Enter new location (EARTH, BELT, MARS, RING): ");
            Location newLocation = Location.valueOf(scanner.nextLine());

            spaceShipToMove.setDestination(newLocation);
            spaceShipToMove.move();

            System.out.println(spaceshipName + " has moved to " + newLocation);
        } else {
            System.out.println("Invalid spaceship name.");
        }
    }


    // method to find a traveler by name //
    private static Traveler findTravelerByName(String name, Traveler[] travelers) {
        for (Traveler traveler : travelers) {
            if (traveler != null && traveler.getName().equals(name)) {
                return traveler;
            }
        }
        return null;
    }

    // method to find a spaceShip by name //
    private static SpaceShip findSpaceShipByName(String name, SpaceShip[] spaceShips) {
        for (SpaceShip spaceShip : spaceShips) {
            if (spaceShip != null && spaceShip.getName().equals(name)) {
                return spaceShip;
            }
        }
        return null;
    }
}                        