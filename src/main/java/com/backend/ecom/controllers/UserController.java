package com.backend.ecom.controllers;

import com.backend.ecom.dto.user.UserRequestDTO;
import com.backend.ecom.dto.user.UserShortInfoDTO;
import com.backend.ecom.entities.Role;
import com.backend.ecom.entities.User;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.request.ArrayRequest;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.UserService;
import com.backend.ecom.supporters.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserShortInfoDTO> getAllUsers(@RequestParam(value = "deleted", defaultValue = "false") Boolean deleted) {
        return userService.getAllUsers(deleted);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getUserDetail(@PathVariable("id") Long id) {
        return userService.getUserDetail(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<ResponseObject> updateUser (@PathVariable("id") Long id, ){
//        return
//    }

    @PatchMapping("/delete")
    public ResponseEntity<ResponseObject> softDeleteManyUsers(@RequestBody ArrayRequest ids) {
        return userService.softDeleteOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @DeleteMapping("/delete/force")
    public ResponseEntity<ResponseObject> forceDeleteManyUsers(@RequestBody ArrayRequest ids) {
        return userService.forceDeleteOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @PatchMapping("/restore")
    public ResponseEntity<ResponseObject> restoreOneOrManyUsers(@RequestBody ArrayRequest ids) {
        return userService.restoreOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

}
