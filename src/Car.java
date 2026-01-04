
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

    // Getter and Setter
    public String getInteriortype() {
        return interiortype;
    }
    public void setInteriortype(String interiortype) {
        this.interiortype = interiortype;
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
}