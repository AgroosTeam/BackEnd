package park.inc.backend.exception;

public class ParkingSlotDocumentNotFoundException extends RuntimeException {
    public ParkingSlotDocumentNotFoundException(Long id) {
        super("Cannot find 'ParkingSlotDocument' with id=" + id);
    }
}