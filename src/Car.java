import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Car extends Vehicle{

    private String  interiortype;

    // Default Constructor
    public Car(){
        super();
        this.interiortype = "Standard";
    }
    // Primary (Parameterized) Constructor
    public Car(String licenseNum, String type, String brand, String model, int year,
               String color, double engineSize, String fueltype,
               String transmissiontype, int mileage, int seatCapacity,
               int ratesPerday, String interiortype, String rentalStatus) {
        super(licenseNum, type, brand, model, year, color, engineSize, fueltype,
              transmissiontype, mileage, seatCapacity, rentalStatus, ratesPerday);
        this.interiortype = interiortype;
    }
    // Copy Constructor
    public Car(Car other) {
        super(other);
        this.interiortype = other.interiortype;
    }

    public void getCarFromUser() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter license plate number: ");
        licenseNum = input.nextLine();

        System.out.println("Enter vehicle type: ");
        type = input.nextLine();

        System.out.println("Enter brand: ");
        brand = input.nextLine();

        System.out.println("Enter model: ");
        model = input.nextLine();

        // Year
        while (true) {
            try {
                System.out.println("Enter year: ");
                year = input.nextInt();
                input.nextLine(); // clear buffer
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Year must be an integer.");
                input.nextLine();
            }
        }

        System.out.println("Enter color: ");
        color = input.nextLine();

        // Engine Size
        while (true) {
            try {
                System.out.println("Enter engine size: ");
                engineSize = input.nextDouble();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Engine size must be a number.");
                input.nextLine();
            }
        }

        System.out.println("Enter fuel type: ");
        fueltype = input.nextLine();

        System.out.println("Enter transmission: ");
        transmissiontype = input.nextLine();

        // Mileage
        while (true) {
            try {
                System.out.println("Enter mileage (km): ");
                mileage = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Mileage must be an integer.");
                input.nextLine();
            }
        }

        // Seating Capacity
        while (true) {
            try {
                System.out.println("Enter seating capacity: ");
                seatCapacity = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Seating capacity must be an integer.");
                input.nextLine();
            }
        }

        // Rate Per Day
        while (true) {
            try {
                System.out.println("Enter rate per day: ");
                ratesPerday = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Rate must be an integer.");
                input.nextLine();
            }
        }
        input.close();
    }

   public void saveToFile() {
    try {
            File file = new File("Vehicle.txt");
            boolean writeHeader = !file.exists() || file.length() == 0;

            FileWriter instream = new FileWriter(file, true);

            if (writeHeader) {
                instream.write("\t\t\t\t\t\t\t\t\t\t\t\t------------------- VEHICLE RECORDS -----------------\n");
                instream.write(
                    "License Plate\tType\t  Brand\t  Model\t Year\t Color\t EngineSize(L)\t FuelType\t Transmission\t Mileage(km)\t Seats\t RatePerDay($)\t Towing Capacity(kg)\t # Helmets\t InteriorType \t Status\n"
                );
            }


            String vehicle = licenseNum + "\t\t\t" + type + "\t  \t  " + brand + "\t" +
                            model + "\t " + year + "\t " + color + "\t " + engineSize + "\t   \t\t  " +
                            fueltype + "\t\t " + transmissiontype + "\t\t\t  " + mileage + "\t\t\t  " +
                            seatCapacity + "\t\t " + ratesPerday + "\t\t\t\t\t\t\t\t\t\t\t\t  " + interiortype + "\t\t\t" + rentalStatus + "\n";

            instream.write(vehicle);
            instream.close();

            System.out.println("Vehicle saved to file");

        } catch (IOException e) {
            System.out.println("Could not save vehicle to file");
        }
    }
 
    @Override
    public void DisplayAllAvailableCars() {

        System.out.println("\t\t\t\t     |----------------------------------------------------------|");
        System.out.println("\t\t\t\t     |------------------- AVAILABLE CARS -----------------------|");
        System.out.println("\t\t\t\t     |----------------------------------------------------------|");
        System.out.println();
        System.out.println(
            "License Plate\tType\tBrand\tModel\t\tYear\tColor\tEngineSize(L)\tFuelType\tTransmission\tMileage(km)\tSeats\tRatePerDay($)\tInteriorType\tStatus"
        );
        System.out.println("====================================================================================="
                            + "===============================================================================================");

        try (Scanner infileStream = new Scanner(new File("Vehicle.txt"))) {

            while (infileStream.hasNextLine()) {
                String line = infileStream.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] p = line.split("\\s+");
                int i = 0;

                this.licenseNum = p[i++];
                this.type = p[i++];

                // ONLY CARS
                if (!type.equalsIgnoreCase("Car")) continue;

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

                // CAR-SPECIFIC FIELD
                this.interiortype = p[i++];

                this.rentalStatus = p[i];

                // ONLY AVAILABLE CARS
                if (rentalStatus.equalsIgnoreCase("Available")) {
                    Display(); // ✅ USE DISPLAY METHOD
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Vehicle.txt not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in Vehicle.txt.");
            e.printStackTrace();
        }
    }



    @Override
    public void Display(){
            //System.out.println("License Plate \tType\t Brand\t  \tModel \t\tYear\t Color\t EngineSize(L)\t FuelType\tTransmission\tMileage(km)\t Seats\t RatePerDay($) \t InteriorType \t Status");
            //System.out.println("----------------------------------------------------------------------"+"--------------------------------------------------------------------------------------------------------------");
            System.out.println(licenseNum + "      \t" + type + "\t " + brand + "\t" + model + "\t\t" + year + "\t " + color + "\t " + 
                                engineSize + "\t\t " + fueltype + "\t\t " + transmissiontype + "\t\t" + mileage + "\t\t " +
                                seatCapacity + "\t " + ratesPerday + "\t\t  " + interiortype + "\t \t"  + rentalStatus );
        }
     public String toString() {
        return "Car{" +
                "interiortype='" + interiortype + '\'' +
                ", licenseNum='" + licenseNum + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", engineSize=" + engineSize +
                ", fueltype='" + fueltype + '\'' +
                ", transmissiontype='" + transmissiontype + '\'' +
                ", mileage=" + mileage +
                ", seatCapacity=" + seatCapacity +
                ", rentalStatus='" + rentalStatus + '\'' +
                ", ratesPerday=" + ratesPerday +
                '}';
    }
    // Getter and Setter
    public String getInteriortype() {
        return interiortype;
    }
    public void setInteriortype(String interiortype) {
        this.interiortype = interiortype;
    }

   
}