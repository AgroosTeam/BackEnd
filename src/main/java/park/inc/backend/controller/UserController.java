package park.inc.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import park.inc.backend.dto.assembler.UserDtoAssembler;
import park.inc.backend.service.UserService;
import park.inc.backend.dto.UserDto;
import park.inc.backend.domain.User;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDtoAssembler userDtoAssembler;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        User user = userService.findById(userId);
        UserDto userDto = userDtoAssembler.toModel(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<UserDto>> getAllUsers() {
        List<User> user = userService.findAll();
        CollectionModel<UserDto> userDtos = userDtoAssembler.toCollectionModel(user);
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<UserDto> addUser(@RequestBody User user) {
        User newUser = userService.create(user);
        UserDto userDto = userDtoAssembler.toModel(newUser);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<?> updateCourse(@RequestBody User uUser, @PathVariable Long userId) {
        userService.update(userId, uUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}