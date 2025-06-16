// Concrete class for Car
public class Car extends Vehicle {
    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
        spotsNeeded = 1;
        size = VehicleSize.COMPACT;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.COMPACT || spot.getSize() == VehicleSize.LARGE;
    }
}