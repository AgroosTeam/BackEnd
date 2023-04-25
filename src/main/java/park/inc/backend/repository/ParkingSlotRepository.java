package park.inc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import park.inc.backend.domain.ParkingSlot;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {
}
