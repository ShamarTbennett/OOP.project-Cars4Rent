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

            this.licenseNum = infileStream.nextLine();
            this.type = infileStream.nextLine();
            this.brand = infileStream.nextLine();
            this.model = infileStream.nextLine();

            this.year = Integer.parseInt(infileStream.nextLine());
            this.color = infileStream.nextLine();
            this.engineSize = Double.parseDouble(infileStream.nextLine());

            this.fueltype = infileStream.nextLine();
            this.transmissiontype = infileStream.nextLine();

            this.mileage = Integer.parseInt(infileStream.nextLine());
            this.seatCapacity = Integer.parseInt(infileStream.nextLine());
            this.ratesPerday = Integer.parseInt(infileStream.nextLine());

            this.towingCapacity = Double.parseDouble(infileStream.nextLine());
            this.numberOfHelmets = Integer.parseInt(infileStream.nextLine());

            this.interiortype = infileStream.nextLine();
            this.rentalStatus = infileStream.nextLine();

            System.out.println(this);
        }

    } catch (FileNotFoundException e) {
        System.out.println("Vehicle.txt not found.");
    } catch (NumberFormatException e) {
        System.out.println("Invalid number format in Vehicle.txt.");
        e.printStackTrace();
    }
}

   /* public void viewvehicles(){

        Scanner infileStream = null;

        try {
            infileStream = new Scanner(new File("Vehicle.txt"));

            while(infileStream.hasNext()){
                this.licenseNum = infileStream.next();
                this.type = infileStream.next();
                this.brand = infileStream.next();
                this.model = infileStream.next();
                this.year = infileStream.nextInt();
                this.color = infileStream.next();
                this.engineSize = infileStream.nextDouble();
                this.fueltype = infileStream.next();
                this.transmissiontype = infileStream.next();
                this.mileage = infileStream.nextInt();
                this.seatCapacity = infileStream.nextInt();
                this.ratesPerday = infileStream.nextInt();
                this.towingCapacity = infileStream.nextDouble();
                this.numberOfHelmets = infileStream.nextInt();
                this.interiortype = infileStream.next();
                this.rentalStatus = infileStream.next();

                System.out.println(this.toString());
            }
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch ( Exception e) {
            //System.out.println("File could not be found: " + e.getMessage());
            e.printStackTrace();
        }
        infileStream.close();
    }*/
    @Override
    public String toString() {
        return "Rental{" +
                "interiortype='" + interiortype + '\'' +
                ", numberOfHelmets=" + numberOfHelmets +
                ", towingCapacity=" + towingCapacity +
                "} " + super.toString();
    }
}