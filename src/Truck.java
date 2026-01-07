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
                 String transmissiontype, int mileage, int seatCapacity,
                 String resntalStatus, int ratesPerday, double towingcapacity) {
        super(licenseNum, type, brand, model, year, color, engineSize, fueltype,
              transmissiontype, mileage, seatCapacity, resntalStatus, ratesPerday);
        this.towingcapacity = towingcapacity;
    }

    // Copy Constructor
    public Truck(Truck other) {
        super(other);
        this.towingcapacity = other.towingcapacity;
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
