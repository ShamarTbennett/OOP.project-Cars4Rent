import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Truck extends Vehicle{
    
    private double towingcapacity;

    // Default Constructor
    public Truck(){
        super();
        this.towingcapacity = 1000.0;
    }

    // Primary (Parameterized) Constructor
    public Truck(String licenseNum, String type, String brand, String model, int year,
                 String color, double engineSize, String fueltype,
                 String transmissiontype, int mileage, int seatCapacity, int ratesPerday, double towingcapacity,
                 String rentalStatus) {
        super(licenseNum, type, brand, model, year, color, engineSize, fueltype,
              transmissiontype, mileage, seatCapacity, rentalStatus, ratesPerday);
        this.towingcapacity = towingcapacity;
    }

    // Copy Constructor
    public Truck(Truck other) {
        super(other);
        this.towingcapacity = other.towingcapacity;
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


                String vehicle = licenseNum + "\t\t\t" + type + "\t  " + brand + "\t" +
                                model + "\t " + year + "\t " + color + "\t " + engineSize + "\t   \t\t  " +
                                fueltype + "\t " + transmissiontype + "\t\t\t\t  " + mileage + "\t\t\t  " +
                                seatCapacity + "\t\t " + ratesPerday + "\t\t\t " + towingcapacity + "\t\t\t\t\t\t\t\t\t\t\t\t  " + rentalStatus + "\n";

                instream.write(vehicle);
                instream.close();

                System.out.println("Vehicle saved to file");

            } catch (IOException e) {
                System.out.println("Could not save vehicle to file");
            }
    }

    public void DisplayAllAvailableTrucks() {

    System.out.println("\t\t\t\t\t\t     |----------------------------------------------------------|");
    System.out.println("\t\t\t\t\t\t     |------------------ AVAILABLE TRUCKS ----------------------|");
    System.out.println("\t\t\t\t\t\t     |----------------------------------------------------------|");
    System.out.println();

    System.out.println(
        "License Plate\tType\tBrand\tModel\tYear\tColor\tEngineSize(L)\tFuelType\tTransmission\tMileage(km)\tSeats\tRatePerDay($)\tTowingCapacity(kg)\tStatus"
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

            // ONLY TRUCKS
            if (!type.equalsIgnoreCase("Truck")) continue;

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
            this.towingcapacity = Double.parseDouble(p[i++]);

            //this.interiortype = p[i++];
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
            licenseNum + "\t\t" + type + "\t" + brand + "\t" + model + "\t\t" +
            year + "\t" + color + "\t" + engineSize + "\t" +
            fueltype + "\t" + transmissiontype + "\t" +
            mileage + "\t" + seatCapacity + "\t" +
            ratesPerday + "\t" + towingcapacity + "\t\t" + rentalStatus
        );
    }

    public String toString() {
        return "Truck{" +
                "towingcapacity=" + towingcapacity +
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
    public double getTowingcapacity() {
        return towingcapacity;
    }   
    public void setTowingcapacity(double towingcapacity) {
        this.towingcapacity = towingcapacity;
    }

    
    
}
