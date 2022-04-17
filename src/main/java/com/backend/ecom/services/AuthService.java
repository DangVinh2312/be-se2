package com.backend.ecom.services;

import com.backend.ecom.entities.Cart;
import com.backend.ecom.entities.Role;
import com.backend.ecom.entities.User;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.request.LoginRequest;
import com.backend.ecom.payload.request.SignupRequest;
import com.backend.ecom.payload.response.JwtResponse;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.CartRepository;
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
import java.util.List;
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
    CartRepository cartRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    public ResponseEntity<ResponseObject> authenticateAccount(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        userRepository.findByUsernameAndDeleted(loginRequest.getUsername(), false)
                .orElseThrow(() -> new ResourceNotFoundException("Not found user"));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        if (roles.contains("ROLE_USER")) {
            User findCart = userRepository.findCartByUsername(authentication.getName());
            if (findCart == null) {
                Cart cart = new Cart();
                cart.addUser(userRepository.getByUsername(authentication.getName()));
                cartRepository.save(cart);
            }
        }
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

        Role userRole = roleRepository.findByName(RoleType.ROLE_USER)
                .orElseThrow(() -> new ResourceNotFoundException("Role is not found."));
        user.setRole(userRole);
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "User registered successfully!", ""));
    }
}
