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

    @Embedded
    private ProduitAttributes produitAttributes;

    @Column(nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "image" , referencedColumnName = "id")
    private Image image ;

    @OneToMany(mappedBy = "menu")
    private List<QuantityEntity> quantite = new ArrayList<>();

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", produitAttributes=" + produitAttributes +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", quantite=" + quantite +
                '}';
    }
}
