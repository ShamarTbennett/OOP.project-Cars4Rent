import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rental extends Vehicle {
    private String  interiortype;
    private int numberOfHelmets;
    private double towingCapacity;


    public Rental() {
        super();
        this.interiortype = "Standard";
        this.numberOfHelmets = 1;
        this.towingCapacity = 1000.0;
    }

    // Primary (Parameterized) Constructor
    public Rental(String licenseNum, String type, String brand, String model, int year,
                  String color, double engineSize, String fueltype,
                  String transmissiontype, int mileage, int seatCapacity,
                  int ratesPerday, String interiortype, int numberOfHelmets, double towingcapacity,
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

                System.out.println(toString());
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


    public void searchavailablevehicles() {
        // Implementation for searching available vehicles

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

                if (this.rentalStatus.equalsIgnoreCase("Available")) {
                    System.out.println(toString());
                }

                if(this.licenseNum.equals("yh"){

                }
                if (this.brand.equalsIgnoreCase"mozda"){}
                    

                    
            }

        } catch (FileNotFoundException e) {
            System.out.println("Vehicle.txt not found.");
    }

    }

}