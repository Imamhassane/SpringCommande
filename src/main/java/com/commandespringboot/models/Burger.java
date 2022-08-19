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

    @Embedded
    private ProduitAttributes produitAttributes;

    @Column(nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "image" , referencedColumnName = "id")
    private Image image ;

    @OneToMany(mappedBy = "burger")
    private List<QuantityEntity> quantite = new ArrayList<>();


    public Burger(ProduitAttributes produitAttributes, String desc) {
        this.produitAttributes= produitAttributes;
        this.description = desc;
    }
}
