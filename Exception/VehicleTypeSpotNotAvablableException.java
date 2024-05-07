package Exception;

public class VehicleTypeSpotNotAvablableException extends RuntimeException {
    public VehicleTypeSpotNotAvablableException() {
    }

    public VehicleTypeSpotNotAvablableException(String message) {
        super(message);
    }
}
