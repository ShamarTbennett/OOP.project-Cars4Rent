import java.io.FileWriter;
import java.util.Scanner;

public class Car extends Vehicle{

    private String  interiortype;

    // Default Constructor
    public Car(){
        super();
        this.interiortype = "Standard";
    }
    // Primary (Parameterized) Constructor
    public Car(String licenseNum, String brand, String model, int year,
               String color, double engineSize, String fueltype,
               String transmissiontype, int mileage, int seatCapacity,
               String resntalStatus, int ratesPerday, String interiortype) {
        super(licenseNum, brand, model, year, color, engineSize, fueltype,
              transmissiontype, mileage, seatCapacity, resntalStatus, ratesPerday);
        this.interiortype = interiortype;
    }
    // Copy Constructor
    public Car(Car other) {
        super(other);
        this.interiortype = other.interiortype;
    }

    public void getcarformUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter license plate number: ");
        licenseNum = input.nextLine();

        System.out.println("Enter Car type: ");


    }



    public void saveToFile(){
        // Implementation for saving Car details to a file
        try{ 
            FileWriter instreamfile = new FileWriter("Vehicle.txt",true);
        } catch (Exception e) {
            System.out.println("Error saving to file");
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