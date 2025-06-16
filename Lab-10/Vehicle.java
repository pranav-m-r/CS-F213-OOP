import java.util.*;

// Abstract class representing a Vehicle
public abstract class Vehicle {
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    // Park vehicle in a spot
    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    // Remove vehicle from spots
    public void clearSpots() {
        for (ParkingSpot spot : parkingSpots) {
            spot.removeVehicle();
        }
        parkingSpots.clear();
    }

    // Check if vehicle can fit in a spot
    public abstract boolean canFitInSpot(ParkingSpot spot);
}