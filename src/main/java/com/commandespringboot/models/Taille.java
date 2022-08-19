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

    @Embedded
    private ProduitAttributes produitAttributes;

    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "taille")
    private List<Complement> complements =new ArrayList<>();

    @OneToMany(mappedBy = "taille")
    private List<QuantityEntity> quantite = new ArrayList<>();

    public Taille(ProduitAttributes produitAttributes , String type){
        this.produitAttributes = produitAttributes;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Taille{" +
                "id=" + id +
                ", produitAttributes=" + produitAttributes +
                ", type='" + type + '\'' +
                '}';
    }
}
