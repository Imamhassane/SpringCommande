package com.commandespringboot.repository;

import com.commandespringboot.models.Taille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TailleRepository extends JpaRepository<Taille , Long> {
}
