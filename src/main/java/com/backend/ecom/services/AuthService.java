package com.backend.ecom.services;

import com.backend.ecom.entities.Role;
import com.backend.ecom.entities.User;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.request.LoginRequest;
import com.backend.ecom.payload.request.SignupRequest;
import com.backend.ecom.payload.response.JwtResponse;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.RoleRepository;
import com.backend.ecom.repositories.UserRepository;
import com.backend.ecom.security.auth.UserDetailsImpl;
import com.backend.ecom.security.jwt.JwtUtils;
import com.backend.ecom.supporters.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {
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

    public ResponseEntity<ResponseObject> authenticateAccount(HttpServletRequest request,
                                                              @Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseObject("ok",
                "Authenticate successfully",
                new JwtResponse(jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles)));
    }

    public ResponseEntity<ResponseObject> registerAccount(SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseObject("error", "Username is already taken!", ""));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseObject("error", "Email is already in use!", ""));
        }

        User user = new User(signUpRequest);
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setCreationDate(Timestamp.from(Instant.now()));
        user.setModifiedDate(Timestamp.from(Instant.now()));

        List<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(RoleType.ROLE_USER)
                    .orElseThrow(() -> new ResourceNotFoundException("Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if (role.equals("admin")) {
                    Role adminRole = roleRepository.findByName(RoleType.ROLE_ADMIN)
                            .orElseThrow(() -> new ResourceNotFoundException("Role is not found."));
                    roles.add(adminRole);
                } else {
                    Role userRole = roleRepository.findByName(RoleType.ROLE_USER)
                            .orElseThrow(() -> new ResourceNotFoundException("Role is not found."));
                    roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "User registered successfully!", ""));
    }
}
