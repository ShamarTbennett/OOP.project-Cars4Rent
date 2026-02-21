//import java.util.Scanner;
public class Driver {
    
    public static void main(String[] args) {


        Rental r = new Rental();
        //r.searchAvailableVehicles("Toyota");
        r.viewvehicles();

        /*Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Main Menu
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. View Vehicles");
            System.out.println("2. My Rentals ");
            System.out.println("3. Return Vehicle"); 
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showViewMenu(scanner);
                    break;
                case 2:
                    showViewMenu(scanner);
                    break;
                 case 3:
                    showViewMenu(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

            scanner.close();
    }

    // Sub-menu with return option
    public static void showViewMenu(Scanner scanner) {
        
        Vehicle v = new Vehicle();
        int viewChoice;

        do {
            System.out.println("\n--- VIEW VEHICLES ---");
            System.out.println("1. Cars");
            System.out.println("2. Trucks");
            System.out.println("3. Bikes");
            System.out.println("4. All Vehicles");
            System.out.println("5. Return to Main Menu");
            System.out.print("Select an option: ");
            viewChoice = scanner.nextInt();

            switch (viewChoice) {
                case 1:
                    System.out.println("\nDisplaying Cars...");
                    v = new Car();
                    v.DisplayAllAvailableCars();
                    break;
                case 2:
                    System.out.println("\nDisplaying Trucks...");
                    v = new Truck();
                    v.DisplayAllAvailableTrucks();
                    break;
                case 3:
                    System.out.println("\nDisplaying Bikes...");
                    v = new Bike();
                    v.DisplayAllAvailableBikes();
                    break;
                case 4:
                    System.out.println("\nDisplaying All Vehicles...");
                    v =new Rental();
                    v.viewvehicles();
                    break;
                case 5:
                    System.out.println("\nReturning to Main Menu...");
                    break;
                default:
                    System.out.println("\nInvalid selection.");
            }

        } while (viewChoice != 5);
    }*/

 
    }
}
