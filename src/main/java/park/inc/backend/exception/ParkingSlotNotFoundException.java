package park.inc.backend.exception;

public class ParkingSlotNotFoundException extends RuntimeException {
    public ParkingSlotNotFoundException(Long id) {
        super("Cannot find 'ParkingSlot' with id=" + id);
    }
}