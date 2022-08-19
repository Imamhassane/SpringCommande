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

    @OneToOne(mappedBy = "image")
    private Burger burger;

    @OneToOne(mappedBy = "image")
    private Menu menu ;

    @OneToOne(mappedBy = "image")
    protected Complement complement;

    public Image(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }

}
