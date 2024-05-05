package Exception;

public class ParkingSpotNotFoundException extends RuntimeException {
    public ParkingSpotNotFoundException() {
    }

    public ParkingSpotNotFoundException(String message) {
        super(message);
    }
}
