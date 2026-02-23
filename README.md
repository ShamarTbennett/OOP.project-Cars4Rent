# Cars4Rent - Vehicle Rental Management System

A Java-based object-oriented vehicle rental management system that allows users to view, search, and manage vehicle rentals across different vehicle types.

## Project Overview

Cars4Rent is a rental management application built with inheritance and polymorphism principles. It supports three main vehicle types: **Cars**, **Trucks**, and **Bikes**, each with their own specialized properties and display methods.

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
The base class for all vehicles with common properties:
- **Properties**: License Number, Type, Brand, Model, Year, Color, Engine Size, Fuel Type, Transmission, Mileage, Seat Capacity, Rental Status, Rate Per Day
- **Methods**: 
  - Display methods for different vehicle types
  - Getters and Setters for all properties
  - `toString()` for string representation

#### Car.java
Extends Vehicle with car-specific features:
- **Additional Property**: Interior Type (Silk, Leather, etc.)
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
Extends Vehicle to handle rental operations:
- **Properties**: Interior Type, Number of Helmets, Towing Capacity (supports all vehicle types)
- **Key Methods**:
  - `viewvehicles()` - Displays all vehicles in the system
  - `searchAvailableVehicles(String)` - Searches for available vehicles by brand, model, license plate, year, or interior type
  - `updateVehicleStatus(String licenseNumber, String newStatus)` - Updates rental status (Available/Rented)
  - `Display()` - Unified display format for all vehicle types

#### Driver.java
Main entry point for the application:
- Contains the `main()` method
- Currently demonstrates basic rental operations (updating vehicle status)
- Includes commented-out interactive menu system for future implementation

## Data Storage

Vehicle data is stored in Vehicle.txt with the following tab-separated format:

```
License Plate | Type | Brand | Model | Year | Color | EngineSize | FuelType | Transmission | Mileage | Seats | RatePerDay | Type-Specific Field | Status
```

### Current Vehicle Database

The system includes:
- **5 Cars** (Honda Fit, Subaru Impreza, Toyota Probox, BMW M5, Mercedes AMG C63)
- **5 Trucks** (Toyota Hilux, Ford Ranger Raptor, Nissan Navara, Volkswagen Amarok, Honda Ridgeline)
- **5 Bikes** (Yamaha YZF-R1, Kawasaki Ninja 300, Ducati Monster 821, Suzuki SV650X, Honda Activa 5G)

## Features

✅ **Vehicle Management**
- View all vehicles by type (Cars, Trucks, Bikes)
- Display only available vehicles
- View complete vehicle inventory

✅ **Search Functionality**
- Search available vehicles by brand, model, license plate, year, or interior type

✅ **Rental Operations**
- Update vehicle rental status
- Track vehicle availability

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
