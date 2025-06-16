// Class representing a Level in the parking lot
public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0; // Number of free spots
    private static final int SPOTS_PER_ROW = 10;

    public Level(int floor, int numberSpots) {
        this.floor = floor;
        spots = new ParkingSpot[numberSpots];
        int largeSpots = numberSpots / 4;
        int compactSpots = numberSpots / 4;
        int motorcycleSpots = numberSpots - largeSpots - compactSpots;

        for (int i = 0; i < numberSpots; i++) {
            VehicleSize sz;
            if (i < largeSpots) {
                sz = VehicleSize.LARGE;
            } else if (i < largeSpots + compactSpots) {
                sz = VehicleSize.COMPACT;
            } else {
                sz = VehicleSize.MOTORCYCLE;
            }
            spots[i] = new ParkingSpot(this, i, sz);
        }
        availableSpots = numberSpots;
    }

    public int availableSpots() {
        return availableSpots;
    }

    // Try to park a vehicle in this level
    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots() < vehicle.getSpotsNeeded()) {
            return false;
        }
        int spotNumber = findAvailableSpots(vehicle);
        if (spotNumber < 0) {
            return false;
        }
        return parkStartingAtSpot(spotNumber, vehicle);
    }

    // Find available spots for the vehicle
    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;

        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (spot.getSpotNumber() / SPOTS_PER_ROW != lastRow) {
                spotsFound = 0;
                lastRow = spot.getSpotNumber() / SPOTS_PER_ROW;
            }
            if (spot.canFitVehicle(vehicle)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }
            if (spotsFound == spotsNeeded) {
                return i - (spotsNeeded - 1);
            }
        }
        return -1;
    }

    // Park vehicle starting at the given spot
    private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
        vehicle.clearSpots();
        boolean success = true;

        for (int i = spotNumber; i < spotNumber + vehicle.getSpotsNeeded(); i++) {
            success &= spots[i].park(vehicle);
        }
        availableSpots -= vehicle.getSpotsNeeded();
        return success;
    }

    // Update available spots when a spot is freed
    public void spotFreed() {
        availableSpots++;
    }
}