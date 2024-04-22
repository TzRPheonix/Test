package org.example.assertAll;

import org.example.model.Utilisateur;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilisateurTest {

    @Test
    @DisplayName("Test sur multiple")
    void testMultiple(){
        Utilisateur utilisateur = new Utilisateur("Jean", 45);
        assertAll("plusieurs test",
                () -> assertNotNull(utilisateur.getNom(), "Object not null"),
                () -> assertEquals(45,utilisateur.getAge(), "Bien 45 ans"),
                () -> assertNotEquals("",utilisateur.getNom(), "Nom vide")
        );
    }
}
