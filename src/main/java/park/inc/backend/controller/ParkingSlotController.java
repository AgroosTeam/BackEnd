package park.inc.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import park.inc.backend.dto.assembler.ParkingSlotDtoAssembler;
import park.inc.backend.service.ParkingSlotService;
import park.inc.backend.dto.ParkingSlotDto;
import park.inc.backend.domain.ParkingSlot;

import java.util.List;

@RestController
@RequestMapping(value = "/api/parkingSlot")
public class ParkingSlotController {
    @Autowired
    private ParkingSlotService parkingSlotService;
    @Autowired
    private ParkingSlotDtoAssembler parkingSlotDtoAssembler;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParkingSlotDto> getParkingSlot(@PathVariable Long id) {
        ParkingSlot parkingSlot = parkingSlotService.findById(id);
        ParkingSlotDto parkingSlotDto = parkingSlotDtoAssembler.toModel(parkingSlot);
        return new ResponseEntity<>(parkingSlotDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ParkingSlotDto>> getAllParkingSlots() {
        List<ParkingSlot> parkingSlot = parkingSlotService.findAll();
        CollectionModel<ParkingSlotDto> parkingSlotDtos = parkingSlotDtoAssembler.toCollectionModel(parkingSlot);
        return new ResponseEntity<>(parkingSlotDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ParkingSlotDto> addParkingSlot(@RequestBody ParkingSlot parkingSlot) {
        ParkingSlot newParkingSlot = parkingSlotService.create(parkingSlot);
        ParkingSlotDto parkingSlotDto = parkingSlotDtoAssembler.toModel(newParkingSlot);
        return new ResponseEntity<>(parkingSlotDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateParkingSlot(@RequestBody ParkingSlot uParkingSlot, @PathVariable Long id) {
        parkingSlotService.update(id, uParkingSlot);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteParkingSlot(@PathVariable Long id) {
        parkingSlotService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}