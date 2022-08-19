package com.commandespringboot.repository;

import com.commandespringboot.models.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarqueRepository extends JpaRepository<Marque , Long> {
}
