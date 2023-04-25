package park.inc.backend.service.Impl;



import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import park.inc.backend.domain.ParkingSlot;
import park.inc.backend.exception.ParkingSlotNotFoundException;
import park.inc.backend.repository.ParkingSlotRepository;
import park.inc.backend.service.ParkingSlotService;

import java.util.List;

@Service
@Transactional
public class ParkingSlotServiceImpl implements ParkingSlotService {

    @Autowired
    ParkingSlotRepository parkingSlotRepository;

    public List<ParkingSlot> findAll() {
        return parkingSlotRepository.findAll();
    }

    public ParkingSlot findById(Long id) {
        return parkingSlotRepository.findById(id)
                .orElseThrow(() -> new ParkingSlotNotFoundException(id));
    }

    public ParkingSlot create(ParkingSlot parkingSlot) {
        parkingSlotRepository.save(parkingSlot);
        return parkingSlot;
    }

    public void update(Long id, ParkingSlot uParkingSlot) {
        ParkingSlot parkingSlot = parkingSlotRepository.findById(id)
                .orElseThrow(() -> new ParkingSlotNotFoundException(id));
        parkingSlot.setAddress(uParkingSlot.getAddress());
        parkingSlot.setOwner(uParkingSlot.getOwner());
        parkingSlotRepository.save(uParkingSlot);
    }

    public void delete(Long id) {
        ParkingSlot parkingSlot = parkingSlotRepository.findById(id)
                .orElseThrow(() -> new ParkingSlotNotFoundException(id));
        parkingSlotRepository.delete(parkingSlot);
    }
}