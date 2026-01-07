public class Truck extends Vehicle{
    
    private double towingcapacity;

    // Default Constructor
    public Truck(){
        super();
        this.towingcapacity = 1000.0;
    }

    // Primary (Parameterized) Constructor
    public Truck(String licenseNum, String brand, String model, int year,
                 String color, double engineSize, String fueltype,
                 String transmissiontype, int mileage, int seatCapacity,
                 String resntalStatus, int ratesPerday, double towingcapacity) {
        super(licenseNum, brand, model, year, color, engineSize, fueltype,
              transmissiontype, mileage, seatCapacity, resntalStatus, ratesPerday);
        this.towingcapacity = towingcapacity;
    }

    
}
