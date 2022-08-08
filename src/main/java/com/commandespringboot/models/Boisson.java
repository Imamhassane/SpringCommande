package com.commandespringboot.models;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Boisson")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Boisson  extends Complement{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "marque" , referencedColumnName = "id")
    private Marque marque ;
}
