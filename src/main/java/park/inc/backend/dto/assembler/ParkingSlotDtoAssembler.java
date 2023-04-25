package park.inc.backend.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import park.inc.backend.controller.ParkingSlotController;
import park.inc.backend.controller.UserController;
import park.inc.backend.domain.ParkingSlot;
import park.inc.backend.dto.ParkingSlotDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ParkingSlotDtoAssembler implements RepresentationModelAssembler<ParkingSlot, ParkingSlotDto> {
    @Override
    public ParkingSlotDto toModel(ParkingSlot entity) {
        ParkingSlotDto parkingSlotDto = ParkingSlotDto.builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .owner(linkTo(methodOn(UserController.class).getUser(entity.getOwner().getId())).withRel("owner"))
                .build();
        Link selfLink = linkTo(methodOn(ParkingSlotController.class).getParkingSlot(parkingSlotDto.getId())).withSelfRel();
        parkingSlotDto.add(selfLink);
        return parkingSlotDto;
    }

    @Override
    public CollectionModel<ParkingSlotDto> toCollectionModel(Iterable<? extends ParkingSlot> entities) {
        CollectionModel<ParkingSlotDto> parkingSlotDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ParkingSlotController.class).getClass()).withSelfRel();
        parkingSlotDtos.add(selfLink);
        return parkingSlotDtos;
    }
}