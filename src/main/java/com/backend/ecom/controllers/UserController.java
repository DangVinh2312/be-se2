package com.backend.ecom.controllers;

import com.backend.ecom.dto.user.UserShortInfoDTO;
import com.backend.ecom.payload.request.ArrayRequest;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserShortInfoDTO> getAllUsers (@RequestParam(value = "deleted", defaultValue = "false") Boolean deleted){
        return userService.getAllUsers(deleted);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getUserDetail (@PathVariable("id") Long id){
        return userService.getUserDetail(id);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<ResponseObject> updateUser (@PathVariable("id") Long id, ){
//        return
//    }

    @PatchMapping("/delete")
    public ResponseEntity<ResponseObject> softDeleteManyUsers (@RequestBody ArrayRequest ids){
        return userService.softDeleteOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @DeleteMapping("/delete/force")
    public ResponseEntity<ResponseObject> forceDeleteManyUsers (@RequestBody ArrayRequest ids){
        return userService.forceDeleteOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

    @PatchMapping("/restore")
    public ResponseEntity<ResponseObject> restoreOneOrManyUsers (@RequestBody ArrayRequest ids){
        return userService.restoreOneOrManyUsers(Arrays.asList(ids.getIds()));
    }

}
