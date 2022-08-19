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
    protected   Long id;

    @Column(nullable = false)
    protected String nom;

    @OneToOne
    @JoinColumn(name = "image" , referencedColumnName = "id")
        private Image image ;

    @OneToMany(mappedBy = "complement")
    protected List<QuantityEntity> quantite = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "taille" , referencedColumnName = "id")
    protected Taille taille;
}
