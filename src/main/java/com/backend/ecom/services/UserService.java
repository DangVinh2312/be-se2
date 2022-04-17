package com.backend.ecom.services;

import com.backend.ecom.dto.user.UserDetailDTO;
import com.backend.ecom.dto.user.UserCreateRequestDTO;
import com.backend.ecom.dto.user.UserShortInfoDTO;
import com.backend.ecom.dto.user.UserUpdateInfoRequestDTO;
import com.backend.ecom.entities.Role;
import com.backend.ecom.entities.User;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.RoleRepository;
import com.backend.ecom.repositories.UserRepository;
import com.backend.ecom.security.jwt.JwtUtils;
import com.backend.ecom.supporters.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

//    public ResponseEntity<?> saveUserRoles(SaveUserRolesRequest req) {
//        logger.info("Save user roles {}", req);
//        User user = userRepository.findById(req.getId()).orElse(null);
//
//        if(user == null) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: User not found"));
//        }
//
//        if(user.getId() == AppConstants.ROOT_USER_ID) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: cannot modify root user roles"));
//        }
//
//        Set<Role> roles = new HashSet<>();
//
//        req.getRoles().forEach((roleID) -> {
//            try {
//                Role role = roleRepository.getById(roleID);
//                roles.add(role);
//            } catch(Exception ex) {
//                logger.error("Loi role:{} ex:{}", roleID, ex.getMessage());
//            }
//        });
//
//        user.setRoles(roles);
//        user.setModifiedDate(Timestamp.from(Instant.now()));
//        userRepository.save(user);
//
//        return ResponseEntity.ok(new MessageResponse("Update roles successfully"));
//    }
//
//    public ResponseEntity<?> saveNewUserPassword(SavePasswordRequest req) {
//        User user = userRepository.findById(req.getUserId()).orElse(null);
//
//        if(user == null) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: User not found"));
//        }
//
//        if(user.getId() == AppConstants.ROOT_USER_ID) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: cannot reset root password"));
//        }
//
//        user.setPassword(encoder.encode(req.getPassword()));
//        user.setModifiedDate(Timestamp.from(Instant.now()));
//
//        userRepository.save(user);
//
//        return ResponseEntity.ok(new MessageResponse("Update password successfully"));
//    }
//
//    public ResponseEntity<?> saveMyUserPassword(String authenticatedUsername, SaveMyPasswordRequest req) {
//        logger.info("Save my password. Username:{}", authenticatedUsername);
//        User user = userRepository.findByUsername(authenticatedUsername).orElse(null);
//
//        if(user == null) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: User not found"));
//        }
//
//        if(!encoder.matches(req.getOldPassword(), user.getPassword())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Current password incorrect"));
//        }
//
//        user.setPassword(encoder.encode(req.getNewPassword()));
//        user.setModifiedDate(Timestamp.from(Instant.now()));
//
//        userRepository.save(user);
//
//        return ResponseEntity.ok(new MessageResponse("Update password successfully"));
//    }
//
//    public List<UserShortInfo> listUsers() {
//        List<UserShortInfo> listUserInfo = new ArrayList<>();
//        List<User> listUser = userRepository.findAll();
//
//        listUser.forEach((user) -> {
//            listUserInfo.add(new UserShortInfo(user.getId(), user.getUsername(), user.getEmail(),
//                    user.getCreationDate().toString(), user.getModifiedDate().toString()));
//        });
//
//        return listUserInfo;
//    }
//
//    public UserListPagingResponse listUsersPaging(int page, int pageSize) {
//        UserListPagingResponse resp = new UserListPagingResponse();
//        Pageable sortedById = PageRequest.of(page, pageSize, Sort.by("username").ascending());
//
//        List<UserShortInfoDTO> listUserInfo = new ArrayList<>();
//        Page<User> listUser = userRepository.findAll(sortedById);
//
//        listUser.forEach((user) -> {
//            listUserInfo.add(new UserShortInfoDTO(user.getId(), user.getUsername(), user.getEmail(),
//                    user.getCreationDate().toString(), user.getModifiedDate().toString()));
//        });
//
//        resp.setListUsers(listUserInfo);
//        resp.setTotalPages(listUser.getTotalPages());
//        resp.setTotalRows(listUser.getTotalElements())
//        ;
//        return resp;
//    }
//
//    public UserDetail get(Long id) {
//        User user = userRepository.getById(id);
//        return new UserDetail(user.getId(), user.getUsername(), user.getEmail(),
//                user.getCreationDate().toString(), user.getModifiedDate().toString(), user.getRoles());
//    }
//

    public List<UserShortInfoDTO> getAllUsers(Boolean deleted) {
        List<UserShortInfoDTO> userShortInfo = new ArrayList<>();
        List<User> users = userRepository.findAllByDeleted(deleted);

        users.forEach(user -> userShortInfo.add(new UserShortInfoDTO(user)));

        return userShortInfo;
    }

    public List<UserShortInfoDTO> getAllUsersByRole(Boolean deleted, Long roleId) {
        List<UserShortInfoDTO> userShortInfo = new ArrayList<>();
        List<User> users = userRepository.findAllByDeletedAndRoleId(deleted, roleId);

        users.forEach(user -> userShortInfo.add(new UserShortInfoDTO(user)));

        return userShortInfo;
    }

    public ResponseEntity<ResponseObject> getUserDetail(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with id: " + id));
        UserDetailDTO userDetail = new UserDetailDTO(user);
        return ResponseEntity.ok(new ResponseObject("ok", "Query user successfully", userDetail));
    }

    public ResponseEntity<ResponseObject> createUser(UserCreateRequestDTO userCreateRequestDTO) {
        if (userRepository.existsByUsername(userCreateRequestDTO.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseObject("error", "Username is already taken!", ""));
        }

        if (userRepository.existsByEmail(userCreateRequestDTO.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseObject("error", "Email is already in use!", ""));
        }

        User user = new User(userCreateRequestDTO);
        user.setPassword(encoder.encode(userCreateRequestDTO.getPassword()));
        user.setCreationDate(Timestamp.from(Instant.now()));
        user.setModifiedDate(Timestamp.from(Instant.now()));

        String role = userCreateRequestDTO.getRole();

        if (role.equals("admin")) {
            Role adminRole = roleRepository.findByName(RoleType.ROLE_ADMIN)
                    .orElseThrow(() -> new ResourceNotFoundException("Role is not found."));
            user.setRole(adminRole);
        } else if (role.equals("user")) {
            Role userRole = roleRepository.findByName(RoleType.ROLE_USER)
                    .orElseThrow(() -> new ResourceNotFoundException("Role is not found."));
            user.setRole(userRole);
        }

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Create user successfully!", user));
    }

    public ResponseEntity<ResponseObject> setUserAva(MultipartFile ava) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName())
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with name: " + auth.getName()));
        user.setAva(ava.getBytes());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Save ava successfully!", userRepository.save(user)));
    }

    public ResponseEntity<ResponseObject> updateUser(Long id, UserUpdateInfoRequestDTO userUpdateInfoRequestDTO) {
        if (userRepository.existsByUsername(userUpdateInfoRequestDTO.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseObject("error", "Username is already taken!", ""));
        }

        if (userRepository.existsByEmail(userUpdateInfoRequestDTO.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseObject("error", "Email is already in use!", ""));
        }

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found user"));
        user.setFullName(userUpdateInfoRequestDTO.getFullName());
        user.setUsername(userUpdateInfoRequestDTO.getUsername());
        user.setEmail(userUpdateInfoRequestDTO.getEmail());
        user.setModifiedDate(Timestamp.from(Instant.now()));

        String role = userUpdateInfoRequestDTO.getRole();

        if (role.equals("admin")) {
            Role adminRole = roleRepository.findByName(RoleType.ROLE_ADMIN)
                    .orElseThrow(() -> new ResourceNotFoundException("Role is not found."));
            user.setRole(adminRole);
        } else if (role.equals("user")) {
            Role userRole = roleRepository.findByName(RoleType.ROLE_USER)
                    .orElseThrow(() -> new ResourceNotFoundException("Role is not found."));
            user.setRole(userRole);
            user.setAddress(userUpdateInfoRequestDTO.getAddress());
        }

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Create user successfully!", user));
    }


    @Transactional
    public ResponseEntity<ResponseObject> softDeleteOneOrManyUsers(List<Long> ids) {
        try {
            userRepository.softDeleteAllByIds(ids);
            return ResponseEntity.ok(new ResponseObject("ok", "Delete users successfully", ""));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found user with id: " + e);
        }
    }

    @Transactional
    public ResponseEntity<ResponseObject> forceDeleteOneOrManyUsers(List<Long> ids) {
        try {
            userRepository.deleteAllById(ids);
            return ResponseEntity.ok(new ResponseObject("ok", "Delete users permanently", ""));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found user with id: " + e);
        }
    }

    @Transactional
    public ResponseEntity<ResponseObject> restoreOneOrManyUsers(List<Long> ids) {
        try {
            userRepository.restoreAllByIds(ids);
            return ResponseEntity.ok(new ResponseObject("ok", "Restore users successfully", ""));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found user with id: " + e);
        }
    }

}
