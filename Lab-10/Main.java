public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        Vehicle motorcycle = new Motorcycle("MOTO123");
        Vehicle car = new Car("CAR456");
        Vehicle bus = new Bus("BUS789");

        System.out.println("Parking Motorcycle: " + parkingLot.parkVehicle(motorcycle));
        System.out.println("Parking Car: " + parkingLot.parkVehicle(car));
        System.out.println("Parking Bus: " + parkingLot.parkVehicle(bus));
    }
}