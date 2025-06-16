// Class representing a ParkingSpot
public class ParkingSpot implements IParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level level, int spotNumber, VehicleSize spotSize) {
        this.level = level;
        this.spotNumber = spotNumber;
        this.spotSize = spotSize;
    }

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    @Override
    public boolean park(Vehicle vehicle) {
        if (!canFitVehicle(vehicle)) {
            return false;
        }
        this.vehicle = vehicle;
        vehicle.parkInSpot(this);
        return true;
    }

    @Override
    public void removeVehicle() {
        level.spotFreed();
        vehicle = null;
    }

    @Override
    public VehicleSize getSize() {
        return spotSize;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
