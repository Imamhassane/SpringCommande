package com.commandespringboot.repository;

import com.commandespringboot.models.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreurRepository extends JpaRepository<Livreur , Long> {
}
