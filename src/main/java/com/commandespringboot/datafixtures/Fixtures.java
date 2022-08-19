package com.commandespringboot.datafixtures;

import com.commandespringboot.models.Burger;
import com.commandespringboot.models.Image;
import com.commandespringboot.repository.BurgerRepository;
import com.commandespringboot.repository.ImageRepository;
import com.commandespringboot.services.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class Fixtures implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Fixtures.class);

    @Autowired
    private final BurgerRepository burgerRepository;
    @Autowired
    private final ImageRepository imageRepository;


    public Fixtures(BurgerRepository burgerRepository,
                    ImageRepository imageRepository) {
        this.burgerRepository = burgerRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
