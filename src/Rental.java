import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public class Rental extends Vehicle {
    private String  interiortype;
    private int numberOfHelmets;
    private int towingCapacity;


    public Rental() {
        super();
        this.interiortype = "Standard";
        this.numberOfHelmets = 1;
        this.towingCapacity = 1000;
    }

    // Primary (Parameterized) Constructor
    public Rental(String licenseNum, String type, String brand, String model, int year,
                  String color, double engineSize, String fueltype,
                  String transmissiontype, int mileage, int seatCapacity,
                  int ratesPerday, String interiortype, int numberOfHelmets, int towingcapacity,
                  String rentalStatus) {
        super(licenseNum, type, brand, model, year, color, engineSize, fueltype,
              transmissiontype, mileage, seatCapacity, rentalStatus, ratesPerday);
        this.interiortype = interiortype;
        this.numberOfHelmets = numberOfHelmets;
        this.towingCapacity = towingcapacity;
    }

    
    public void viewvehicles() {

        try (Scanner infileStream = new Scanner(new File("Vehicle.txt"))) {

            while (infileStream.hasNextLine()) {
                String line = infileStream.nextLine().trim();

                if (line.isEmpty()) continue;

                String[] p = line.split("\\s+");
                int i = 0;

                this.licenseNum = p[i++];
                this.type = p[i++];
                this.brand = p[i++];
                this.model = p[i++];

                this.year = Integer.parseInt(p[i++]);
                this.color = p[i++];
                this.engineSize = Double.parseDouble(p[i++]);

                this.fueltype = p[i++];
                this.transmissiontype = p[i++];

                this.mileage = Integer.parseInt(p[i++]);
                this.seatCapacity = Integer.parseInt(p[i++]);
                this.ratesPerday = Integer.parseInt(p[i++]);

                // RESET OPTIONAL FIELDS
                this.towingCapacity = 0;
                this.numberOfHelmets = 0;
                this.interiortype = "None";

                // VEHICLE-SPECIFIC FIELDS
                if (type.equalsIgnoreCase("Car")) {
                    this.interiortype = p[i++];
                }
                else if (type.equalsIgnoreCase("Truck")) {
                    this.towingCapacity = (int) Double.parseDouble(p[i++]);
                }
                else if (type.equalsIgnoreCase("Bike")) {
                    this.numberOfHelmets = Integer.parseInt(p[i++]);
                }

                this.rentalStatus = p[i];

                Display();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Vehicle.txt not found.");
        }catch (NumberFormatException e) {
            System.out.println("Invalid number format in Vehicle.txt.");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Rental{" +
                "interiortype='" + interiortype + '\'' +
                ", numberOfHelmets=" + numberOfHelmets +
                ", towingCapacity=" + towingCapacity +
                "} " + super.toString() + "\n\n";

    }


    public void searchAvailableVehicles(String userInput) {

        String search = userInput.trim().toLowerCase();

        try (Scanner infileStream = new Scanner(new File("Vehicle.txt"))) {

            while (infileStream.hasNextLine()) {
                String line = infileStream.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] p = line.split("\\s+");
                int i = 0;

                Rental v = new Rental(); // 🔥 NEW OBJECT PER LINE

                v.licenseNum = p[i++];
                v.type = p[i++];
                v.brand = p[i++];
                v.model = p[i++];
                v.year = Integer.parseInt(p[i++]);
                v.color = p[i++];
                v.engineSize = Double.parseDouble(p[i++]);
                v.fueltype = p[i++];
                v.transmissiontype = p[i++];
                v.mileage = Integer.parseInt(p[i++]);
                v.seatCapacity = Integer.parseInt(p[i++]);
                v.ratesPerday = Integer.parseInt(p[i++]);

                // reset optional fields
                v.towingCapacity = 0;
                v.numberOfHelmets = 0;
                v.interiortype = "None";

                // read type-specific field
                if (v.type.equalsIgnoreCase("Car")) {
                    v.interiortype = p[i++];
                }
                else if (v.type.equalsIgnoreCase("Truck")) {
                    v.towingCapacity = Integer.parseInt(p[i++]);
                    v.interiortype = p[i++];
                }
                else if (v.type.equalsIgnoreCase("Bike")) {
                    v.numberOfHelmets = Integer.parseInt(p[i++]);
                    v.interiortype = p[i++];
                }

                // rental status
                v.rentalStatus = p[i];

                if (!v.rentalStatus.equalsIgnoreCase("Available")) continue;

                boolean match =
                        v.licenseNum.toLowerCase().contains(search) ||
                        v.brand.toLowerCase().contains(search) ||
                        v.model.toLowerCase().contains(search) ||
                        v.interiortype.toLowerCase().contains(search) ||
                        String.valueOf(v.year).equals(search);

                if (match) {
                    //System.out.println(v);
                    v.Display(); // prints EACH matching vehicl             
                    
                    
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Vehicle.txt was not found.");
        }
    }

    @Override
    public void Display() {

        //System.out.println("License Plate \tType\t Brand\t Model\t\tYear\tColor\tEngineSize(L)\tFuelType\tTransmission\tMileage(km)\tSeats\tRatePerDay($)\tStatus\tInterior\tHelmets\tTowingCap");
        //System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println(
                licenseNum + "\t" +
                type + "\t" +
                brand + "\t" +
                model + "\t\t" +
                year + "\t" +
                color + "\t" +
                engineSize + "\t\t" +
                fueltype + "\t\t" +
                transmissiontype + "\t\t" +
                mileage + "\t\t" +
                seatCapacity + "\t" +
                ratesPerday + "\t\t" +
                rentalStatus + "\t" +
                interiortype + "\t" +
                numberOfHelmets + "\t" +
                towingCapacity
        );
    }

    // This method can be implemented to update the rental status of a vehicle
    // For example, it could read the Vehicle.txt file, find the matching license number,
    // and update the rentalStatus field to "Rented" or "Available" as needed.
    public void updateVehicleStatus(String licenseNumber, String newStatus) {
        File inputFile = new File("Vehicle.txt");
        File tempFile = new File("TempVehicle.txt");

        try (
            Scanner reader = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(tempFile)
        ) {

            while (reader.hasNextLine()) {

                String line = reader.nextLine();
                if (line.trim().isEmpty()) continue;

                String[] p = line.split("\\s+");

                // License number is first field
                if (p[0].equalsIgnoreCase(licenseNumber)) {

                    // Rental status is LAST field
                    p[p.length - 1] = newStatus;

                    System.out.println("Vehicle status updated successfully.");
                }

                // Rebuild the line
                String updatedLine = String.join(" ", p);
                writer.println(updatedLine);
            }

        } catch (Exception e) {
            System.out.println("Error updating vehicle status.");
            e.printStackTrace();
            return;
        }

        // Replace old file with updated file
        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
        }
    }

        
    public void saveRentalRecord(String licensePlate, String customerName,
                                String address, String phone,
                                String dateRented, String expectedReturn,
                                double depositPaid) {

        try {

            FileWriter instream = new FileWriter("RentalRecords.txt", true);

            String rental = licensePlate + "\t\t" +
                            customerName + "\t\t" +
                            address + "\t\t" +
                            phone + "\t\t" +
                            dateRented + "\t\t" +
                            expectedReturn + "\t\t" +
                            depositPaid + "\n";

            instream.write(rental);
            instream.close();

            System.out.println("Rental record saved to file");

        } catch (IOException e) {
            System.out.println("Could not save rental record");
        }
    }


    public void getRentalInformation() {

        Scanner scan = new Scanner(System.in);

        String plate;
        String name;
        String address;
        String phoneNumber;
        LocalDate dateRented = LocalDate.now();
        LocalDate returnDate = null;
        double depositPaid = 0;


        // Plate
        while (true) {

            System.out.print("Enter the plate number: ");
            plate = scan.nextLine().trim();

            // Check empty
            if (plate.isEmpty()) {
                System.out.println("Plate number cannot be empty.");
                continue;
            }
            // Check if plate exists and is available
            if (validatePlateAvailable(plate)) {
                break;   //Validates plate → move on
            }

            System.out.println("Please enter a valid and available plate number.\n");
        }

        // Full Name (with spaces)
        while (true) {
            System.out.print("Enter your full name: ");
            name = scan.nextLine().trim();
            if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("Name must contain only letters.");
            } else {
                break;
            }
        }

        // Address (with spaces)
        while (true) {
            System.out.print("Enter your address: ");
            address = scan.nextLine().trim();
            if (!address.isEmpty()) break;
            System.out.println("Address cannot be empty.");
        }

        // Phone number validation
        while (true) {
            System.out.print("Enter your phone number: ");
            phoneNumber = scan.nextLine().trim();
            if (!phoneNumber.matches("\\d{7,12}")) {
                System.out.println("Phone number must contain 7–12 digits.");
            } else {
                break;
            }
        }

        System.out.println("Date Rented: " + dateRented);

        // Return date validation
        while (true) {
            try {
                System.out.print("Enter return date (YYYY-MM-DD): ");
                returnDate = LocalDate.parse(scan.nextLine());

                if (!returnDate.isAfter(dateRented)) {
                    System.out.println("Return date must be after today.");
                } else {
                    break;
                }

            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Use YYYY-MM-DD.");
            }
        }


        // Deposit validation
        while (true) {
            try {
                System.out.print("Deposit amount: ");
                depositPaid = scan.nextInt();

                if (depositPaid <= 0) {
                    System.out.println("Deposit must be greater than 0.");
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Deposit must be a number.");
                scan.next(); // clear invalid input
            }
        }
        scan.close();
        System.out.println("\nRental Information Captured Successfully.");

        // Save rental record
        saveRentalRecord(
                plate,
                name,
                address,
                phoneNumber,
                dateRented.toString(),
                returnDate.toString(),
                depositPaid
        );

        // Update vehicle status
        updateVehicleStatus(plate, "Rented");

        System.out.println("\nVehicle successfully rented.");
    }
      

    public boolean validatePlateAvailable(String plateNumber) {

        try (Scanner reader = new Scanner(new File("Vehicle.txt"))) {

            while (reader.hasNextLine()) {

                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");

                if (parts[0].equalsIgnoreCase(plateNumber)) {

                    String status = parts[parts.length - 1];

                    if (status.equalsIgnoreCase("Available")) {
                        return true;   // Plate exists and is available
                    } else {
                        System.out.println("Vehicle is already rented.");
                        return false;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Vehicle.txt not found.");
        }

        System.out.println("Plate number does not exist.");
        return false;
    }

    
}