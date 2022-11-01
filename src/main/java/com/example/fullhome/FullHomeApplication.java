package com.example.fullhome;

import com.example.fullhome.entity.Role;
import com.example.fullhome.entity.User;
import com.example.fullhome.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
@EnableAsync
@RequiredArgsConstructor
public class FullHomeApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(FullHomeApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<User> byEmail = userRepository.findByEmail("admin@mail.com");

        if (byEmail.isEmpty()) {
            userRepository.save(User.builder()
                    .name("admin")
                    .surname("admin")
                    .email("admin@mail.com")
                    .phone("+37477344604")
                    .picUrl("/static/img/images/avatars/avatar-1.png")
                    .password(passwordEncoder().encode("admin"))
                    .role(Role.ADMIN)
                    .build());
        }
    }

}
