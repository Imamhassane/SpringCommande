package com.commandespringboot.services;


import com.commandespringboot.models.Burger;
import com.commandespringboot.models.Menu;
import com.commandespringboot.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    public Menu saveMenu (Menu menu){
        return menuRepository.save(menu);
    }
    public List<Menu> listAll(){
        return menuRepository.findAll();
    }
    public Optional<Menu> getById(Long id){
        return menuRepository.findById(id);
    }

    public Object listTopTen() {
        Pageable limit = PageRequest.of(0,10);
        return menuRepository.findAll(limit);
    }
}
