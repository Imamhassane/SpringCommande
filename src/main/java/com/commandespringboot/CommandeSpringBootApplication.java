package com.commandespringboot;

import com.commandespringboot.repository.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = ClientRepository.class)
public class    CommandeSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommandeSpringBootApplication.class, args);
    }
}
