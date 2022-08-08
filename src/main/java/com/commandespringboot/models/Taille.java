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
public class Taille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private int prix;

    @OneToMany
    @JoinColumn(name = "taille")
    private List<Complement> complements =new ArrayList<>();
}
