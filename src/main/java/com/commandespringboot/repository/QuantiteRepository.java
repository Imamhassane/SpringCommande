package com.commandespringboot.repository;

import com.commandespringboot.models.Burger;
import com.commandespringboot.models.Menu;
import com.commandespringboot.models.QuantityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuantiteRepository extends JpaRepository<QuantityEntity, Long> {
    List<QuantityEntity> findAllByMenu(Menu menu);
    QuantityEntity findQuantityEntityByBurger(Burger burger);
}
