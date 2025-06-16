// Concrete class for Motorcycle
public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        this.licensePlate = licensePlate;
        spotsNeeded = 1;
        size = VehicleSize.MOTORCYCLE;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true; // Motorcycles can fit anywhere
    }
}