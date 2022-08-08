package com.commandespringboot.models;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private int prix;

    @OneToMany
    @JoinColumn(name = "menu")
    private List<Image> images = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "menu")
    private List<QuantityEntity> quantite = new ArrayList<>();
}
