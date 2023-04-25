package park.inc.backend.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import park.inc.backend.controller.ParkingSlotDocumentController;
import park.inc.backend.domain.ParkingSlotDocument;
import park.inc.backend.dto.ParkingSlotDocumentDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ParkingSlotDocumentDtoAssembler implements RepresentationModelAssembler<ParkingSlotDocument,
        ParkingSlotDocumentDto> {
    @Override
    public ParkingSlotDocumentDto toModel(ParkingSlotDocument entity) {
        ParkingSlotDocumentDto parkingSlotDocumentDto = ParkingSlotDocumentDto.builder()
                .parkingSlotId(entity.getParkingSlotId())
                .document(entity.getDocument())
                .build();
        Link selfLink = linkTo(methodOn(ParkingSlotDocumentController.class)
                .getParkingSlotDocument(parkingSlotDocumentDto.getParkingSlotId())).withSelfRel();
        parkingSlotDocumentDto.add(selfLink);
        return parkingSlotDocumentDto;
    }

    @Override
    public CollectionModel<ParkingSlotDocumentDto> toCollectionModel(Iterable<? extends ParkingSlotDocument> entities) {
        CollectionModel<ParkingSlotDocumentDto> parkingSlotDocumentDtos = RepresentationModelAssembler
                .super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ParkingSlotDocumentController.class).getAllParkingSlotDocuments())
                .withSelfRel();
        parkingSlotDocumentDtos.add(selfLink);
        return parkingSlotDocumentDtos;
    }
}