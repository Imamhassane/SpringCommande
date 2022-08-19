package com.commandespringboot.repository;

import com.commandespringboot.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClientRepository  extends JpaRepository<Client, Long> {
    /*Optional<Client> findByUserName(String email);*/
}
