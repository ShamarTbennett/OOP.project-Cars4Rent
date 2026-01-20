import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bike extends Vehicle{
    
    private int numberOfHelmets;


    // Default Constructor    
    public Bike(){
        super();    
        this.numberOfHelmets = 1;
    }

    // Primary (Parameterized) Constructor
    public Bike(String licenseNum, String type, String brand, String model, int year,
                String color, double engineSize, String fueltype,
                String transmissiontype, int mileage, int seatCapacity
               , int ratesPerday, int numberOfHelmets, String rentalStatus) {
        super(licenseNum,type, brand, model, year, color, engineSize, fueltype,
              transmissiontype, mileage, seatCapacity, rentalStatus, ratesPerday);
        this.numberOfHelmets = numberOfHelmets;
    }

    // Copy Constructor
    public Bike(Bike other) {
        super(other);
        this.numberOfHelmets = other.numberOfHelmets;
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


                String vehicle = licenseNum + "\t\t\t" + type + "\t  " + brand + "\t\t" +
                                model + "\t\t\t" + year + "\t " + color + "\t " + engineSize + "\t   \t\t  " +
                                fueltype + "\t\t " + transmissiontype + "\t\t\t\t  " + mileage + "\t\t\t  " +
                                seatCapacity + "\t\t " + ratesPerday + "\t\t\t\t\t\t\t\t\t\t" + numberOfHelmets + "\t\t\t\t\t\t  " + rentalStatus + "\n";

                instream.write(vehicle);
                instream.close();

                System.out.println("Vehicle saved to file");

            } catch (IOException e) {
                System.out.println("Could not save vehicle to file");
            }
    }

    public void DisplayAllAvailableBikes() {

    System.out.println("\t\t\t\t\t\t     |----------------------------------------------------------|");
    System.out.println("\t\t\t\t\t\t     |------------------ AVAILABLE Bikes -----------------------|");
    System.out.println("\t\t\t\t\t\t     |----------------------------------------------------------|");
    System.out.println();

    System.out.println(
        "License Plate\tType\tBrand\tModel\tYear\tColor\tEngineSize(L)\tFuelType\tTransmission\tMileage(km)\tSeats\tRatePerDay($)\t# Helmets\tStatus"
    );
    System.out.println("====================================================================================="
            + "==================================================================================");

    try (Scanner infileStream = new Scanner(new File("Vehicle.txt"))) {

        while (infileStream.hasNextLine()) {
            String line = infileStream.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] p = line.split("\\s+");
            int i = 0;

            this.licenseNum = p[i++];
            this.type = p[i++];

            // ONLY TRUCKS
            if (!type.equalsIgnoreCase("Bike")) continue;

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

            // 🚚 TRUCK-SPECIFIC FIELD
            this.numberOfHelmets = Integer.parseInt(p[i++]);

            this.rentalStatus = p[i];
           
            // ONLY AVAILABLE TRUCKS
            if (rentalStatus.equalsIgnoreCase("Available")) {
                Display(); // 👈 separate display method
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
        System.out.println(
            licenseNum + "\t\t" + type + "\t" + brand + "\t" + model + "\t" +
            year + "\t" + color + "\t" + engineSize + "\t\t" +
            fueltype + "\t\t  " + transmissiontype + "\t\t" +
            mileage + "\t\t " + seatCapacity + "\t" +
            ratesPerday + "\t\t  " + numberOfHelmets + "\t\t" + rentalStatus);
    }


    public String toString() {
        return "Bike{" +
                "numberOfHelmets=" + numberOfHelmets +
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
    public int getNumberOfHelmets() {
        return numberOfHelmets;
    }
    public void setNumberOfHelmets(int numberOfHelmets) {
        this.numberOfHelmets = numberOfHelmets;
    }

 
}
