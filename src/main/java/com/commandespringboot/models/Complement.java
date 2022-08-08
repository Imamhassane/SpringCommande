package com.commandespringboot.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="complement_type")
@DiscriminatorValue("Frittes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Complement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String nom;

    @OneToMany
    @JoinColumn(name = "complement")
    private List<Image> images = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "complement")
    private List<QuantityEntity> quantite = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "taille" , referencedColumnName = "id")
    private Taille taille;
}
