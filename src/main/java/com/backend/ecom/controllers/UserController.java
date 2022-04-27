package com.backend.ecom.controllers;

import com.backend.ecom.dto.user.UserCreateRequestDTO;
import com.backend.ecom.dto.user.UserShortInfoDTO;
import com.backend.ecom.dto.user.UserUpdateInfoRequestDTO;
import com.backend.ecom.payload.request.ArrayRequest;
import com.backend.ecom.payload.request.ChangePasswordRequest;
import com.backend.ecom.payload.request.ResetPasswordRequest;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserShortInfoDTO> getAllUsers(@Valid @RequestParam(value = "deleted", defaultValue = "false") Boolean deleted) {
        return userService.getAllUsers(deleted);
    }

    @GetMapping("/search")
    public List<UserShortInfoDTO> searchUser(@RequestParam(value = "q", defaultValue = "") String query,
                                             @RequestParam(value = "deleted", defaultValue = "false") Boolean deleted) {
        return userService.searchUser(query, deleted);
    }

    @GetMapping("/all/{roleId}")
    public List<UserShortInfoDTO> getAllUsersByRole(@Valid @PathVariable("roleId") Long id,
                                                    @Valid @RequestParam(value = "deleted", defaultValue = "false") Boolean deleted) {
        return userService.getAllUsersByRole(deleted, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getUserDetail(@Valid @PathVariable("id") Long id,
                                                        @RequestParam(value = "deleted", defaultValue = "false") Boolean deleted) {
        return userService.getUserDetail(id, deleted);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createUser(@Valid @RequestBody UserCreateRequestDTO userCreateRequestDTO) {
        return userService.createUser(userCreateRequestDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateUser(@Valid @PathVariable("id") Long id,
                                                     @Valid @RequestBody UserUpdateInfoRequestDTO userUpdateInfoRequestDTO) {
        return userService.updateUser(id, userUpdateInfoRequestDTO);
    }

    @PatchMapping("/delete")
    public ResponseEntity<ResponseObject> softDeleteManyUsers(@Valid @RequestBody ArrayRequest ids) {
        return userService.softDeleteOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @DeleteMapping("/delete/force")
    public ResponseEntity<ResponseObject> forceDeleteManyUsers(@Valid @RequestBody ArrayRequest ids) {
        return userService.forceDeleteOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @PatchMapping("/restore")
    public ResponseEntity<ResponseObject> restoreOneOrManyUsers(@Valid @RequestBody ArrayRequest ids) {
        return userService.restoreOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @DeleteMapping("/feedbacks/delete/{id}")
    public ResponseEntity<ResponseObject> deleteFeedback(@PathVariable("id") Long id) {
        return userService.deleteFeedback(id);
    }

}
