package Exception;

public class ParkingFloorNotFoundException extends RuntimeException {
    public ParkingFloorNotFoundException() {
    }

    public ParkingFloorNotFoundException(String message) {
        super(message);
    }
}
