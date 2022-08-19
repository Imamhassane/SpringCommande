package com.commandespringboot.repository;

import com.commandespringboot.models.Marque;
import com.commandespringboot.models.Taille;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TailleRepository extends JpaRepository<Taille , Long> {
    public List<Taille> findByType(String type);

}
