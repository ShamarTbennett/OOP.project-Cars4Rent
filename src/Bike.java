public class Bike extends Vehicle{
    
    private int numberOfHelmets;


    // Default Constructor    
    public Bike(){
        super();    
        this.numberOfHelmets = 1;
    }

    // Primary (Parameterized) Constructor
    public Bike(String licenseNum, String brand, String model, int year,
                String color, double engineSize, String fueltype,
                String transmissiontype, int mileage, int seatCapacity,
                String resntalStatus, int ratesPerday, int numberOfHelmets) {
        super(licenseNum, brand, model, year, color, engineSize, fueltype,
              transmissiontype, mileage, seatCapacity, resntalStatus, ratesPerday);
        this.numberOfHelmets = numberOfHelmets;
    }

    // Copy Constructor
    public Bike(Bike other) {
        super(other);
        this.numberOfHelmets = other.numberOfHelmets;
    }

    // Getter and Setter
    public int getNumberOfHelmets() {
        return numberOfHelmets;
    }
    public void setNumberOfHelmets(int numberOfHelmets) {
        this.numberOfHelmets = numberOfHelmets;
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
}
