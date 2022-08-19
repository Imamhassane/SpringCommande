package com.commandespringboot.repository;

import com.commandespringboot.models.Complement;
import com.commandespringboot.models.Taille;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplementRepository extends JpaRepository<Complement , Long> {
    List<Complement> findComplementByTaille(Taille taille);

}
