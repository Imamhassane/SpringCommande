package com.commandespringboot.repository;

import com.commandespringboot.models.QuantityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantiteRepository extends JpaRepository<QuantityEntity, Long> {
}
