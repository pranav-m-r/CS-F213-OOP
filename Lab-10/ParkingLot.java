// Class representing the ParkingLot
public class ParkingLot {
    private Level[] levels;
    private static final int NUM_LEVELS = 5;

    public ParkingLot() {
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            levels[i] = new Level(i, 30); // Each level has 30 spots
        }
    }

    // Park a vehicle in the parking lot
    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }
}
