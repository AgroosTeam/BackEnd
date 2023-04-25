package park.inc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import park.inc.backend.domain.ParkingSlotDocument;

@Repository
public interface ParkingSlotDocumentRepository extends JpaRepository<ParkingSlotDocument, Long> {
}
