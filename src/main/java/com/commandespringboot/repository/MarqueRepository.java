package com.commandespringboot.repository;

import com.commandespringboot.models.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque , Long> {
}
