package com.backend.ecom.config;
import com.backend.ecom.entities.Role;
import com.backend.ecom.repositories.RoleRepository;
import com.backend.ecom.supporters.RoleType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class ConfigDatabase {

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
        return args -> {
            Role admin = new Role (RoleType.ROLE_ADMIN);
            Role user = new Role(RoleType.ROLE_USER);
            roleRepository.saveAll(List.of(admin, user));
        };
    }
}
