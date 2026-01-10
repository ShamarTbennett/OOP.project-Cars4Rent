import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
                 String resntalStatus) {
        super(licenseNum, type, brand, model, year, color, engineSize, fueltype,
              transmissiontype, mileage, seatCapacity, resntalStatus, ratesPerday);
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
                                fueltype + "\t " + transmissiontype + "\t\t\t\t\t  " + mileage + "\t\t\t  " +
                                seatCapacity + "\t\t " + ratesPerday + "\t\t\t\t\t\t " + towingcapacity + "\t\t\t  " + resntalStatus + "\n";

                instream.write(vehicle);
                instream.close();

                System.out.println("Vehicle saved to file");

            } catch (IOException e) {
                System.out.println("Could not save vehicle to file");
            }
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
                ", resntalStatus='" + resntalStatus + '\'' +
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
