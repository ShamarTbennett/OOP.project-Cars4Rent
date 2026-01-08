import java.io.File;
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
               String resntalStatus, int ratesPerday, String interiortype) {
        super(licenseNum, type, brand, model, year, color, engineSize, fueltype,
              transmissiontype, mileage, seatCapacity, resntalStatus, ratesPerday);
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
                "License Plate\t  Type\t  Brand\t  Model\t Year\t Color\t EngineSize(L)\t FuelType\t Transmission\t Mileage(km)\t Seats\t RatePerDay($)\t Towing Capacity(kg)\t # Helmets\n"
            );
        }


        String vehicle = licenseNum + "\t  " + type + "\t" + brand + "\t" +
                         model + "\t" + year + "\t" + color + "\t" + engineSize + "\t" +
                         fueltype + "\t" + transmissiontype + "\t" + mileage + "\t" +
                         seatCapacity + "\t" + ratesPerday + "\n";

        instream.write(vehicle);
        instream.close();

        System.out.println("Vehicle saved to file");

    } catch (IOException e) {
        System.out.println("Could not save vehicle to file");
    }
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
                ", resntalStatus='" + resntalStatus + '\'' +
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