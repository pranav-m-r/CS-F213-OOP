// Interface for ParkingSpot behavior
public interface IParkingSpot {
    boolean isAvailable();
    boolean canFitVehicle(Vehicle vehicle);
    boolean park(Vehicle vehicle);
    void removeVehicle();
    VehicleSize getSize();
}