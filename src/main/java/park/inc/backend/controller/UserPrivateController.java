package park.inc.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import park.inc.backend.dto.assembler.UserPrivateDtoAssembler;
import park.inc.backend.service.UserPrivateService;
import park.inc.backend.dto.UserPrivateDto;
import park.inc.backend.domain.UserPrivate;

import java.util.List;

@RestController
@RequestMapping(value = "/api/userPrivate")
public class UserPrivateController {
    @Autowired
    private UserPrivateService userPrivateService;
    @Autowired
    private UserPrivateDtoAssembler userPrivateDtoAssembler;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserPrivateDto> getUserPrivate(@PathVariable Long userId) {
        UserPrivate userPrivate = userPrivateService.findById(userId);
        UserPrivateDto userPrivateDto = userPrivateDtoAssembler.toModel(userPrivate);
        return new ResponseEntity<>(userPrivateDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<UserPrivateDto>> getAllUserPrivates() {
        List<UserPrivate> userPrivate = userPrivateService.findAll();
        CollectionModel<UserPrivateDto> userPrivateDtos = userPrivateDtoAssembler.toCollectionModel(userPrivate);
        return new ResponseEntity<>(userPrivateDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<UserPrivateDto> addUserPrivate(@RequestBody UserPrivate userPrivate) {
        UserPrivate newUserPrivate = userPrivateService.create(userPrivate);
        UserPrivateDto userPrivateDto = userPrivateDtoAssembler.toModel(newUserPrivate);
        return new ResponseEntity<>(userPrivateDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<?> updateUserPrivate(@RequestBody UserPrivate uUserPrivate, @PathVariable Long userId) {
        userPrivateService.update(userId, uUserPrivate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<?> deleteUserPrivate(@PathVariable Long userId) {
        userPrivateService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}