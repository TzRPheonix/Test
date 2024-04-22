package org.example.Bissextile;

import org.example.model.Annee;
import org.example.model.Calculatrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BissextileTest {
    private static Annee annee;

    @BeforeAll
    static void init(){
        annee = new Annee();
    }

    @Test
    @DisplayName("Annee Bissextile Vrai")
    void testBissextileA(){
        annee.setNombre(2024);
        Assertions.assertTrue(annee.isBissextile());
    }

    @Test
    @DisplayName("Annee Bissextile Faux")
    void testBissextileB(){
        annee.setNombre(2023);
        Assertions.assertFalse(annee.isBissextile());
    }

}
