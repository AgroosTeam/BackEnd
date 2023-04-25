package park.inc.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import park.inc.backend.dto.assembler.ParkingSlotDocumentDtoAssembler;
import park.inc.backend.service.ParkingSlotDocumentService;
import park.inc.backend.dto.ParkingSlotDocumentDto;
import park.inc.backend.domain.ParkingSlotDocument;

import java.util.List;

@RestController
@RequestMapping(value = "/api/parkingSlotDocument")
public class ParkingSlotDocumentController {
    @Autowired
    private ParkingSlotDocumentService parkingSlotDocumentService;
    @Autowired
    private ParkingSlotDocumentDtoAssembler parkingSlotDocumentDtoAssembler;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParkingSlotDocumentDto> getParkingSlotDocument(@PathVariable Long id) {
        ParkingSlotDocument parkingSlotDocument = parkingSlotDocumentService.findById(id);
        ParkingSlotDocumentDto parkingSlotDocumentDto = parkingSlotDocumentDtoAssembler.toModel(parkingSlotDocument);
        return new ResponseEntity<>(parkingSlotDocumentDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ParkingSlotDocumentDto>> getAllParkingSlotDocuments() {
        List<ParkingSlotDocument> parkingSlotDocument = parkingSlotDocumentService.findAll();
        CollectionModel<ParkingSlotDocumentDto> parkingSlotDocumentDtos = parkingSlotDocumentDtoAssembler
                .toCollectionModel(parkingSlotDocument);
        return new ResponseEntity<>(parkingSlotDocumentDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ParkingSlotDocumentDto> addParkingSlotDocument(@RequestBody
                                                                             ParkingSlotDocument parkingSlotDocument) {
        ParkingSlotDocument newParkingSlotDocument = parkingSlotDocumentService.create(parkingSlotDocument);
        ParkingSlotDocumentDto parkingSlotDocumentDto = parkingSlotDocumentDtoAssembler.toModel(newParkingSlotDocument);
        return new ResponseEntity<>(parkingSlotDocumentDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateParkingSlot(@RequestBody ParkingSlotDocument uParkingSlotDocument
            , @PathVariable Long id) {
        parkingSlotDocumentService.update(id, uParkingSlotDocument);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteParkingSlotDocument(@PathVariable Long id) {
        parkingSlotDocumentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}