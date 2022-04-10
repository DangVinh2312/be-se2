package com.backend.ecom.controllers;

import com.backend.ecom.payload.request.LoginRequest;
import com.backend.ecom.payload.request.SignupRequest;
import com.backend.ecom.payload.response.JwtResponse;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.security.auth.UserDetailsImpl;
import com.backend.ecom.security.jwt.JwtUtils;
import com.backend.ecom.services.AuthService;
import com.backend.ecom.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseObject> registerAccount(@Valid @RequestBody SignupRequest signupRequest) {
        return authService.registerAccount(signupRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseObject> authenticateAccount(HttpServletRequest request,
                                                              @Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticateAccount(request, loginRequest);
    }

}
