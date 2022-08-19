package com.commandespringboot.repository;

import com.commandespringboot.models.Boisson;
import com.commandespringboot.models.Taille;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoissonRepository extends JpaRepository<Boisson , Long> {
    List<Boisson> findBoissonByTaille(Taille taille);
}
