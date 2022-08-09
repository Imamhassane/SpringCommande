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

public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private int prix;

    @OneToOne(mappedBy = "burger")
    private Image image ;

    @OneToMany
    @JoinColumn(name = "burger")
    private List<QuantityEntity> quantite = new ArrayList<>();

}
