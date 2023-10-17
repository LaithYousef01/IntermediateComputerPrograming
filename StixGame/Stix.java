import java.util.Scanner;
import java.util.Random;

public class Stix {
	
	 private static void printStix(int count) {
	        System.out.print("Stix on the table: ");
	        for (int i = 0; i < count; i++) {
	            System.out.print("|");
	        }
	        System.out.println();
	    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        
        int numStix;
        int computerStix;
        int playerStix;
        boolean computerTurn;
        char choice;

       
        do {
            System.out.print("How many stix to begin with? [5 - 30] > ");
            numStix = scnr.nextInt();
        } 
        while (numStix < 5 || numStix > 30);
       
        System.out.print("Computer goes first? [y/n] > ");
         choice = scnr.next().charAt(0);
        computerTurn = (choice == 'y' || choice == 'Y');

        
        while (numStix > 0) {
            if (computerTurn) {
                
                computerStix = Math.min(rand.nextInt(3) + 1, numStix);
                numStix -= computerStix;
                System.out.println("Computer takes " + computerStix);
                printStix(numStix);
               
                if (numStix == 0) {
                    System.out.println("User Wins!");
                    break;
                }
            } 
            else {
                
                do {
                    System.out.print("How many stix to take? [1 - 3] > ");
                    playerStix = scnr.nextInt();
                }
                while (playerStix < 1 || playerStix > 3 || playerStix > numStix);
                numStix -= playerStix;
                printStix(numStix);
                if (numStix == 0) {
                    System.out.println("Computer Wins!");
                    break;
                }
            }

           
            computerTurn = !computerTurn;
        }

        scnr.close();
    }
}