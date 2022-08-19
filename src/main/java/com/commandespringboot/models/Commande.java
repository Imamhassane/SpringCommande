package com.commandespringboot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "client" , referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "commande")
    private List<QuantityEntity> quantite = new ArrayList<>();

    @Embedded
    private Adresse adresse;

}
