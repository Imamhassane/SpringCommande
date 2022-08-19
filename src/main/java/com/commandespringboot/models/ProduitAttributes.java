package com.commandespringboot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProduitAttributes {

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private int prix;

    @Override
    public String toString() {
        return "ProduitAttributes{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
