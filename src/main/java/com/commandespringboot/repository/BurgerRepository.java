package com.commandespringboot.repository;

import com.commandespringboot.models.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerRepository extends JpaRepository<Burger , Long> {
}
