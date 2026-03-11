# Cars4Rent - Vehicle Rental Management System

A comprehensive Java-based object-oriented vehicle rental management system that allows users to view, search, rent, and manage vehicle rentals across different vehicle types including cars, trucks, and bikes.

## Project Overview

Cars4Rent is a full-featured rental management application built using object-oriented programming principles such as inheritance and polymorphism. The system supports three main vehicle types: **Cars**, **Trucks**, and **Bikes**, each with specialized properties and functionalities. Users can browse available vehicles, search for specific models, rent vehicles, view their rental history, and manage rental operations.

## Features

### ✅ Vehicle Management
- **View Vehicles by Type**: Display all available cars, trucks, bikes, or all vehicles in the system
- **Detailed Vehicle Information**: Each vehicle displays comprehensive details including license plate, brand, model, year, color, engine specifications, mileage, seating capacity, rental rate, and type-specific attributes
- **Availability Tracking**: Real-time status updates for vehicle availability (Available/Rented)

### ✅ Search Functionality
- **Advanced Search**: Search for available vehicles by brand, model, license plate, year, or interior type
- **Real-time Results**: Instant search results filtered by availability status

### ✅ Rental Operations
- **Rent a Vehicle**: Interactive rental process with customer information collection (name, address, phone number)
- **Rental Validation**: Checks for vehicle availability and customer rental limits
- **Rental Records**: Automatic generation of rental records with rental date, expected return date, and cost calculation
- **View My Rentals**: Customers can view their active and past rental history

### ✅ Data Management
- **Persistent Storage**: Vehicle data stored in `Vehicle.txt` and rental records in `RentalRecords.txt`
- **File-based Operations**: All data operations use text file storage for simplicity and portability

## Architecture

### Class Hierarchy
```
Vehicle (Base Class)
├── Car
├── Truck
├── Bike
└── Rental
```

### Core Classes

#### Vehicle.java
The abstract base class for all vehicles containing common properties and methods:
- **Properties**: License Number, Type, Brand, Model, Year, Color, Engine Size, Fuel Type, Transmission, Mileage, Seat Capacity, Rental Status, Rate Per Day
- **Methods**:
  - Getters and setters for all properties
  - `toString()` for string representation
  - Abstract `Display()` method implemented by subclasses

#### Car.java
Extends Vehicle with car-specific features:
- **Additional Property**: Interior Type (e.g., Silk, Leather)
- **Key Methods**:
  - `getCarFromUser()` - Collects car information from user input with validation
  - `saveToFile()` - Persists car data to Vehicle.txt
  - `DisplayAllAvailableCars()` - Displays all available cars from the database
  - `Display()` - Custom display format for cars

#### Truck.java
Extends Vehicle with truck-specific features:
- **Additional Properties**:
  - Towing Capacity (kg)
  - Interior Type
- **Key Methods**:
  - `saveToFile()` - Persists truck data to Vehicle.txt
  - `DisplayAllAvailableTrucks()` - Displays all available trucks from the database
  - `Display()` - Custom display format for trucks

#### Bike.java
Extends Vehicle with bike-specific features:
- **Additional Property**: Number of Helmets
- **Key Methods**:
  - `saveToFile()` - Persists bike data to Vehicle.txt
  - `DisplayAllAvailableBikes()` - Displays all available bikes from the database
  - `Display()` - Custom display format for bikes

#### Rental.java
Handles all rental operations and extends Vehicle:
- **Properties**: Inherits all vehicle properties plus type-specific attributes (Interior Type, Number of Helmets, Towing Capacity)
- **Key Methods**:
  - `viewvehicles()` - Displays all vehicles in the system
  - `searchAvailableVehicles(String)` - Searches for available vehicles by various criteria
  - `updateVehicleStatus(String licenseNumber, String newStatus)` - Updates rental status
  - `getRentalInformation()` - Interactive rental process with customer data collection
  - `saveRentalRecord()` - Saves rental details to RentalRecords.txt
  - `viewMyRentals(String customerName)` - Displays customer's rental history
  - `canRentMoreVehicles(String customerName)` - Validates rental limits
  - `validatePlateAvailable(String plateNumber)` - Checks vehicle availability
  - `Display()` - Unified display format for all vehicle types

#### Driver.java
Main entry point for the application:
- Contains the `main()` method with interactive menu system
- **Main Menu Options**:
  1. View Vehicles (sub-menu for Cars, Trucks, Bikes, All Vehicles, Rent a Vehicle)
  2. My Rentals (view personal rental history)
  3. Search for Vehicle
  4. Return Vehicle (coming soon)
  5. Exit

## Data Storage

### Vehicle.txt
Contains vehicle inventory with tab-separated format:
```
License Plate | Type | Brand | Model | Year | Color | EngineSize | FuelType | Transmission | Mileage | Seats | RatePerDay | Type-Specific Field | Status
```

### RentalRecords.txt
Contains rental transaction records with tab-separated format:
```
License Plate | Customer Name | Address | Phone | Rental Date | Expected Return | Cost | Status
```

### Current Vehicle Database
The system includes:
- **5 Cars**: Honda Fit, Subaru Impreza, Toyota Probox, BMW M5, Mercedes AMG C63
- **5 Trucks**: Toyota Hilux, Ford Ranger Raptor, Nissan Navara, Volkswagen Amarok, Honda Ridgeline
- **5 Bikes**: Yamaha YZF-R1, Kawasaki Ninja 300, Ducati Monster 821, Suzuki SV650X, Honda Activa 5G

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line interface (Terminal/Command Prompt)

### Compilation
1. Navigate to the project root directory
2. Compile all Java files:
   ```bash
   javac -d bin src/*.java
   ```

### Running the Application
1. Ensure you're in the project root directory
2. Run the main class:
   ```bash
   java -cp bin Driver
   ```

### Usage
1. **View Vehicles**: Choose option 1 from the main menu, then select vehicle type or view all
2. **Rent a Vehicle**: From the view menu, select option 5 to start the rental process
3. **Search Vehicles**: Use option 3 to search for available vehicles by any detail
4. **View My Rentals**: Enter your name with option 2 to see your rental history

## Future Enhancements
- Vehicle return functionality
- Advanced search filters
- Customer account management
- Payment processing integration
- GUI interface
- Database integration (instead of text files)

## Contributing
This is an educational OOP project. Feel free to fork and enhance with additional features.

## License
This project is for educational purposes only.

## Usage Example

```java
Rental r = new Rental();

// View all vehicles
r.viewvehicles();

// Search for available vehicles
r.searchAvailableVehicles("Toyota");

// Update vehicle rental status
r.updateVehicleStatus("6708CP", "Rented");
```

## Future Enhancements

- Implement interactive menu system (currently commented in Driver.java)
- Add customer/driver management
- Implement rental history tracking
- Add rental cost calculations
- Enhance search with advanced filtering
- Database integration to replace file-based storage

## Technical Details

- **Language**: Java
- **Storage**: File-based (Vehicle.txt)
- **Design Patterns**: Inheritance, Polymorphism
- **Compilation**: `bin/` folder (configured in .vscode/settings.json)

## Project Structure

```
src/
├── Vehicle.java      (Base class)
├── Car.java          (Car-specific implementation)
├── Truck.java        (Truck-specific implementation)
├── Bike.java         (Bike-specific implementation)
├── Rental.java       (Rental operations)
└── Driver.java       (Main entry point)
```
