
public class Vehicle {
    protected String licenseNum;
    protected String type;
    protected String brand;
    protected String model;
    protected int year;
    protected String color;
    protected double engineSize;
    protected String fueltype;
    protected String transmissiontype;
    protected int mileage;
    protected int seatCapacity;
    protected String rentalStatus;
    protected int ratesPerday;

    //default constructor
    public Vehicle(){
        this.licenseNum = "";
        this.type = "";
        this.brand = " ";
        this.model = "";
        this.year = 1818;
        this.color = "";
        this.engineSize = 0.1;
        this.fueltype = "";
        this.transmissiontype = "";
        this.mileage = 1000;
        this.seatCapacity = 1;
        this.rentalStatus = "";
        this.ratesPerday = 1000;
    }

    // Primary (Parameterized) Constructor
    public Vehicle(String licenseNum, String type,String brand, String model, int year,
                   String color, double engineSize, String fueltype,
                   String transmissiontype, int mileage, int seatCapacity,
                   String rentalStatus, int ratesPerday) {

        this.licenseNum = licenseNum;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engineSize = engineSize;
        this.fueltype = fueltype;
        this.transmissiontype = transmissiontype;
        this.mileage = mileage;
        this.seatCapacity = seatCapacity;
        this.rentalStatus = rentalStatus;
        this.ratesPerday = ratesPerday;
    }

    // Copy Constructor
    public Vehicle(Vehicle other) {
        this.licenseNum = other.licenseNum;
        this.type = other.type;
        this.brand = other.brand;
        this.model = other.model;
        this.year = other.year;
        this.color = other.color;
        this.engineSize = other.engineSize;
        this.fueltype = other.fueltype;
        this.transmissiontype = other.transmissiontype;
        this.mileage = other.mileage;
        this.seatCapacity = other.seatCapacity;
        this.rentalStatus = other.rentalStatus;
        this.ratesPerday = other.ratesPerday;
    }

    // toString Method
    @Override
    public String toString() {
        return "License Number= " + licenseNum + '\n' +
                "Type= " + type + "\n" +
                "Brand= " + brand + "\n" +
                "Model= " + model + "\n" +
                "Year= " + year + "\n" +
                "Color= " + color + "\n" +
                "Engine Size= " + engineSize + "\n"+
                "Fuel Type= " + fueltype + '\n' +
                "Transmission Type= " + transmissiontype + '\n' +
                "Mileage= " + mileage + "\n" +
                "Seat Capacity= " + seatCapacity +"\n" +
                "Rental Status= " + rentalStatus + "\n" +
                "Rates Per Day= " + ratesPerday;
    }

    // Getters and Setters
    public String getLicenseNum() {
        return licenseNum;
    }
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double getEngineSize() {
        return engineSize;
    }
    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public String getFueltype() {
        return fueltype;
    }
    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getTransmissiontype() {
        return transmissiontype;
    }
    public void setTransmissiontype(String transmissiontype) {
        this.transmissiontype = transmissiontype;
    }

    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }
    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public String getrentalStatus() {
        return rentalStatus;
    }
    public void setrentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public int getRatesPerday() {
        return ratesPerday;
    }
    public void setRatesPerday(int ratesPerday) {
        this.ratesPerday = ratesPerday;
    }

}