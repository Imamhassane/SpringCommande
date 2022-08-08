package com.commandespringboot.repository;

import com.commandespringboot.models.Complement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplementRepository extends JpaRepository<Complement , Long> {
}
