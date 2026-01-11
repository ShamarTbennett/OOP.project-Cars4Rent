import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
               , int ratesPerday, int numberOfHelmets, String resntalStatus) {
        super(licenseNum,type, brand, model, year, color, engineSize, fueltype,
              transmissiontype, mileage, seatCapacity, resntalStatus, ratesPerday);
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
                                seatCapacity + "\t\t " + ratesPerday + "\t\t\t\t\t\t\t\t\t\t" + numberOfHelmets + "\t\t\t\t\t\t  " + resntalStatus + "\n";

                instream.write(vehicle);
                instream.close();

                System.out.println("Vehicle saved to file");

            } catch (IOException e) {
                System.out.println("Could not save vehicle to file");
            }
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
                ", resntalStatus='" + resntalStatus + '\'' +
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
