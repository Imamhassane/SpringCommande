package com.commandespringboot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "menu" , referencedColumnName = "id")
    private Menu menu ;

    @ManyToOne
    @JoinColumn(name = "burger" , referencedColumnName = "id")
    private Menu burger ;

    @ManyToOne
    @JoinColumn(name = "complement" , referencedColumnName = "id")
    private Menu complement ;
}
