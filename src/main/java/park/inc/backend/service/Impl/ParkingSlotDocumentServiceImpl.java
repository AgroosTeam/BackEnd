package park.inc.backend.service.Impl;



import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import park.inc.backend.domain.ParkingSlotDocument;
import park.inc.backend.exception.ParkingSlotDocumentNotFoundException;
import park.inc.backend.repository.ParkingSlotDocumentRepository;
import park.inc.backend.service.ParkingSlotDocumentService;

import java.util.List;

@Service
@Transactional
public class ParkingSlotDocumentServiceImpl implements ParkingSlotDocumentService {

    @Autowired
    ParkingSlotDocumentRepository parkingSlotDocumentRepository;

    public List<ParkingSlotDocument> findAll() {
        return parkingSlotDocumentRepository.findAll();
    }

    public ParkingSlotDocument findById(Long id) {
        return parkingSlotDocumentRepository.findById(id)
                .orElseThrow(() -> new ParkingSlotDocumentNotFoundException(id));
    }

    public ParkingSlotDocument create(ParkingSlotDocument parkingSlotDocument) {
        parkingSlotDocumentRepository.save(parkingSlotDocument);
        return parkingSlotDocument;
    }

    public void update(Long id, ParkingSlotDocument uParkingSlotDocument) {
        ParkingSlotDocument parkingSlotDocument = parkingSlotDocumentRepository.findById(id)
                .orElseThrow(() -> new ParkingSlotDocumentNotFoundException(id));
        parkingSlotDocument.setDocument(uParkingSlotDocument.getDocument());
        parkingSlotDocumentRepository.save(parkingSlotDocument);
    }

    public void delete(Long id) {
        ParkingSlotDocument parkingSlotDocument = parkingSlotDocumentRepository.findById(id)
                .orElseThrow(() -> new ParkingSlotDocumentNotFoundException(id));
        parkingSlotDocumentRepository.delete(parkingSlotDocument);
    }
}