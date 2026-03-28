# Cars4Rent

Cars4Rent is a Java console application for managing vehicle rentals. It uses object-oriented programming with inheritance and polymorphism to handle cars, trucks, and bikes, and it stores inventory and rental activity in text files.

## Current Functionality

- View available cars, trucks, bikes, or all available vehicles
- Search available vehicles by license plate, brand, model, year, or interior type
- Rent a vehicle with input validation and automatic file updates
- View a customer's rental history with active and returned counts
- Return a vehicle, generate a receipt, update mileage, and mark the rental as returned

## Known Issues

- **My Rentals Feature**: The "My Rentals" feature may encounter crashes in certain scenarios. This is under investigation and pending fixes.

## Main Menu

When `Driver.java` runs, the application shows this menu:

1. View Vehicles
2. My Rentals
3. Search for Vehicle
4. Return Vehicle
5. Exit

The `View Vehicles` submenu provides:

1. Cars
2. Trucks
3. Bikes
4. All Vehicles
5. Rent a Vehicle
6. Return to Main Menu

## Rental Workflow

The rental flow is handled in `Rental.java` and currently includes:

- Plate validation against `Vehicle.txt`
- Availability check before renting
- Customer rental limit of 3 active rentals
- Name validation using letters and spaces only
- Phone validation for 7 to 12 digits
- Return date validation using `YYYY-MM-DD`
- Deposit validation for positive numeric input
- Rental record creation in `RentalRecords.txt`
- Vehicle status update from `Available` to `Rented`

## Return Workflow

The return feature is now implemented. When a vehicle is returned, the system:

- Confirms the plate exists in the rental records
- Captures the current mileage
- Generates a receipt using the rental dates and vehicle daily rate
- Applies a late fee of `2500` per late day
- Updates the rental record status to `Returned`
- Updates the vehicle status to `Available`
- Updates the stored vehicle mileage

## Project Structure

```text
src/
|-- Vehicle.java
|-- Car.java
|-- Truck.java
|-- Bike.java
|-- Rental.java
`-- Driver.java
```

### Class Summary

#### `Vehicle`
Base class for shared vehicle data:

- License number
- Type
- Brand
- Model
- Year
- Color
- Engine size
- Fuel type
- Transmission type
- Mileage
- Seat capacity
- Rental status
- Rate per day

#### `Car`
Extends `Vehicle` and adds:

- `interiortype`
- Display logic for available cars
- File save support for car records

#### `Truck`
Extends `Vehicle` and adds:

- `towingcapacity`
- `interiortype`
- Display logic for available trucks
- File save support for truck records

#### `Bike`
Extends `Vehicle` and adds:

- `numberOfHelmets`
- Display logic for available bikes
- File save support for bike records

#### `Rental`
Extends `Vehicle` and handles rental operations:

- View all available vehicles
- Search available vehicles
- Validate rentals and returns
- Save rental records
- Update vehicle status and mileage
- View customer rental history
- Generate return receipts

#### `Driver`
Application entry point. It manages the console menus and routes user actions to the rental and vehicle classes.

## Data Files

### `Vehicle.txt`

Stores the vehicle inventory in a whitespace-delimited format. Each row contains common vehicle fields plus type-specific data:

- Car: `license type brand model year color engine fuel transmission mileage seats rate interior status`
- Truck: `license type brand model year color engine fuel transmission mileage seats rate towingCapacity interior status`
- Bike: `license type brand model year color engine fuel transmission mileage seats rate helmets status`

The current sample inventory contains 15 vehicles:

- 5 cars
- 5 trucks
- 5 bikes

### `RentalRecords.txt`

Stores rental activity, including:

- License plate
- Customer name
- Address
- Phone number
- Date rented
- Expected return date
- Deposit paid
- Rental status

Current statuses in the file include `Active` and `Returned`.

## Build and Run

### Prerequisites

- JDK 8 or higher

### Compile

```powershell
javac -d bin src\*.java
```

### Run

```powershell
java -cp bin Driver
```

## Notes

- Data is stored in plain text files in the project root.
- Search results only show vehicles whose status is `Available`.
- The "All Vehicles" option currently displays all available vehicles from every category.
- The project is console-based and does not use a database or GUI.

## Technical Summary

- Language: Java
- Style: Object-oriented programming
- Storage: `Vehicle.txt` and `RentalRecords.txt`
- Output folder: `bin/`

## Future Improvements

- Normalize file formats more consistently
- Add stronger validation for multi-word names and addresses
- Improve search filters
- Add customer accounts
- Replace text files with a database
- Add a GUI
