package park.inc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import park.inc.backend.domain.UserPrivate;

public interface UserPrivateRepository extends JpaRepository<UserPrivate, Long> {

}
