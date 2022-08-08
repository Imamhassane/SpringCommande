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
public class QuantityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "complement" , referencedColumnName = "id")
    private Complement complements ;

    @ManyToOne
    @JoinColumn(name = "burger" , referencedColumnName = "id")
    private Burger burger ;

    @ManyToOne
    @JoinColumn(name = "menu" , referencedColumnName = "id")
    private Menu menu ;

    @ManyToOne
    @JoinColumn(name = "commande" , referencedColumnName = "id")
    private Commande commande ;
}
