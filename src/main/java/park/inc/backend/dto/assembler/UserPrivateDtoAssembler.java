package park.inc.backend.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import park.inc.backend.controller.UserController;
import park.inc.backend.controller.UserPrivateController;
import park.inc.backend.domain.UserPrivate;
import park.inc.backend.dto.UserPrivateDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UserPrivateDtoAssembler implements RepresentationModelAssembler<UserPrivate, UserPrivateDto> {
    @Override
    public UserPrivateDto toModel(UserPrivate entity) {
        UserPrivateDto userPrivateDto = UserPrivateDto.builder()
                .userId(entity.getUserId())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .password(entity.getPassword())
                .build();
        Link selfLink = linkTo(methodOn(UserPrivateController.class).getUserPrivate(userPrivateDto.getUserId()))
                .withSelfRel();
        userPrivateDto.add(selfLink);
        Link userLink = linkTo(methodOn(UserController.class).getUser(userPrivateDto.getUserId())).withRel("user");
        userPrivateDto.add(userLink);
        return userPrivateDto;
    }

    @Override
    public CollectionModel<UserPrivateDto> toCollectionModel(Iterable<? extends UserPrivate> entities) {
        CollectionModel<UserPrivateDto> userPrivateDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(UserPrivateController.class).getAllUserPrivates()).withSelfRel();
        userPrivateDtos.add(selfLink);
        return userPrivateDtos;
    }
}