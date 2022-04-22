//package com.backend.ecom.config;
//import com.backend.ecom.entities.Role;
//import com.backend.ecom.entities.User;
//import com.backend.ecom.repositories.RoleRepository;
//import com.backend.ecom.repositories.UserRepository;
//import com.backend.ecom.supporters.RoleType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//import java.sql.Timestamp;
//import java.time.Instant;
//import java.util.List;
//
//@Configuration
//public class ConfigDatabase {
//    @Autowired
//    PasswordEncoder encoder;
//    @Bean
//    CommandLineRunner commandLineRunner(RoleRepository roleRepository, UserRepository userRepository) {
//        return args -> {
//            Role adminRole = new Role (RoleType.ROLE_ADMIN);
//            Role userRole = new Role(RoleType.ROLE_USER);
//
//            roleRepository.saveAll(List.of(adminRole, userRole));
//
//            User admin = new User();
//            admin.setFullName("admin");
//            admin.setUsername("admin");
//            admin.setPassword(encoder.encode("123456"));
//            admin.setCreatedDate(Timestamp.from(Instant.now()));
//            admin.setUpdatedDate(Timestamp.from(Instant.now()));
//            admin.setRole(roleRepository.findByName(RoleType.ROLE_ADMIN).get());
//
//            User user = new User();
//            user.setFullName("Nguyen Van A");
//            user.setUsername("user");
//            user.setPassword(encoder.encode("123456"));
//            user.setAddress("Hà Nội");
//            user.setCreatedDate(Timestamp.from(Instant.now()));
//            user.setUpdatedDate(Timestamp.from(Instant.now()));
//            user.setRole(roleRepository.findByName(RoleType.ROLE_USER).get());
//
//            userRepository.saveAll(List.of(admin, user));
//        };
//    }
//}
