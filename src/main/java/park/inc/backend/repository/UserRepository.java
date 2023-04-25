package park.inc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import park.inc.backend.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
