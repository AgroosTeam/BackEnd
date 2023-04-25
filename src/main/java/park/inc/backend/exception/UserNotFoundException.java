package park.inc.backend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Cannot find 'User' with id=" + id);
    }
}