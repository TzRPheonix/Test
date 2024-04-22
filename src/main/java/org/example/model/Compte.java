package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Compte {
    private Long id;

    private static Long count = 1L;

    private String name;

    private Double solde;

    public Compte(String name, Double solde){
        this.id = count++;
        this.name = name;
        this.solde = solde;
    }

}
