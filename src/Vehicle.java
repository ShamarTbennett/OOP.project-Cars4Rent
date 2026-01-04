public class Vehicle {
    protected String licenseNum;
    protected String brand;
    protected String model;
    protected int year;
    protected String color;
    protected double engineSize;
    protected String fueltype;
    protected String transmissiontype;
    protected int mileage;
    protected int seatCapacity;
    protected String resntalStatus;
    protected int ratesPerday;

    //default constructor
    public Vehicle(){
        this.licenseNum = "ABCDEF";
        this.brand = "New";
        this.model = "Box";
        this.year = 1818;
        this.color = "Bergandy";
        this.engineSize = 0.1;
        this.fueltype = "Gas";
        this.transmissiontype = "A";
        this.mileage = 1000;
        this.seatCapacity = 1;
        this.resntalStatus = "Available";
        this.ratesPerday = 1000;
    }

    // Primary (Parameterized) Constructor
    public Vehicle(String licenseNum, String brand, String model, int year,
                   String color, double engineSize, String fueltype,
                   String transmissiontype, int mileage, int seatCapacity,
                   String resntalStatus, int ratesPerday) {

        this.licenseNum = licenseNum;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engineSize = engineSize;
        this.fueltype = fueltype;
        this.transmissiontype = transmissiontype;
        this.mileage = mileage;
        this.seatCapacity = seatCapacity;
        this.resntalStatus = resntalStatus;
        this.ratesPerday = ratesPerday;
    }

    // Copy Constructor
    public Vehicle(Vehicle other) {
        this.licenseNum = other.licenseNum;
        this.brand = other.brand;
        this.model = other.model;
        this.year = other.year;
        this.color = other.color;
        this.engineSize = other.engineSize;
        this.fueltype = other.fueltype;
        this.transmissiontype = other.transmissiontype;
        this.mileage = other.mileage;
        this.seatCapacity = other.seatCapacity;
        this.resntalStatus = other.resntalStatus;
        this.ratesPerday = other.ratesPerday;
    }

    // toString Method
    @Override
    public String toString() {
        return "Vehicle {" +
                "License Number='" + licenseNum + '\'' +
                ", Brand='" + brand + '\'' +
                ", Model='" + model + '\'' +
                ", Year=" + year +
                ", Color='" + color + '\'' +
                ", Engine Size=" + engineSize +
                ", Fuel Type='" + fueltype + '\'' +
                ", Transmission Type='" + transmissiontype + '\'' +
                ", Mileage=" + mileage +
                ", Seat Capacity=" + seatCapacity +
                ", Rental Status='" + resntalStatus + '\'' +
                ", Rates Per Day=" + ratesPerday +
                '}';
    }

    // Getters and Setters
    public String getLicenseNum() {
        return licenseNum;
    }
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
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

    public String getResntalStatus() {
        return resntalStatus;
    }
    public void setResntalStatus(String resntalStatus) {
        this.resntalStatus = resntalStatus;
    }

    public int getRatesPerday() {
        return ratesPerday;
    }
    public void setRatesPerday(int ratesPerday) {
        this.ratesPerday = ratesPerday;
    }

}
