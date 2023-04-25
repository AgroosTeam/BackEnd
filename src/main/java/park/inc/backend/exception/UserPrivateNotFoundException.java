package park.inc.backend.exception;

public class UserPrivateNotFoundException extends RuntimeException {
    public UserPrivateNotFoundException(Long user_id) {
        super("Cannot find 'UserPrivate' with user_id=" + user_id);
    }
}