// Concrete class for Bus
public class Bus extends Vehicle {
    public Bus(String licensePlate) {
        this.licensePlate = licensePlate;
        spotsNeeded = 5;
        size = VehicleSize.LARGE;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.LARGE;
    }
}