package org.example.CompteTest;

import org.example.Exception.NotEnoughMoneyException;
import org.example.model.Compte;
import org.example.service.CompteService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test de la classe ProduitService")
public class CompteTest {
    private CompteService compteService;

    @BeforeEach
    void init(){
        compteService = new CompteService();
    }

    @Test
    @DisplayName("Création de compte avec des soldes différents")
    void testCreateCompte(){
        Compte compteA = compteService.createCompte("Paul",100);
        Compte compteB = compteService.createCompte("Pauline", 0);
        Compte compteC = compteService.createCompte("Paulo", -100);
        List<Compte> listeComptes = compteService.getAllCompte();

        Assertions.assertAll("Vérification des soldes des comptes créés",
                () -> assertEquals(100, compteA.getSolde(), "Solde égal à 100"),
                () -> assertEquals(0, compteB.getSolde(), "Solde égal à 0"),
                () -> assertEquals(-100, compteC.getSolde(), "Solde égal à -100"),
                () -> assertEquals(3, listeComptes.size(), "On a 3 comptes")
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {100, 200, 50, -10})
    void testTransactionSuccess(double montant) {
        Compte compteA = compteService.createCompte("Paul", 1000);
        Compte compteB = compteService.createCompte("Pauline", 0);

        if (montant < 0) {
            assertThrows(IllegalArgumentException.class, () -> compteService.transaction(compteA.getId(), compteB.getId(), montant),
                    "La transaction avec montant négatif doit lancer une IllegalArgumentException");
        } else {
            assertTimeout(Duration.ofSeconds(1), () -> {
                assertTrue(compteService.transaction(compteA.getId(), compteB.getId(), montant), "La transaction renvoie un boolean true");

                assertAll("Vérification des soldes après transaction",
                        () -> assertEquals(1000 - montant, compteA.getSolde(), "Solde du compte A après la transaction"),
                        () -> assertEquals(montant, compteB.getSolde(), "Solde du compte B après la transaction")
                );
            }, "La transaction ne doit pas dépasser 1 seconde");
        }
    }

    @Test
    @DisplayName("Test de transaction avec solde insuffisant")
    void testTransactionNotEnoughMoney() {
        Compte compteA = compteService.createCompte("Paul", 100);
        Compte compteB = compteService.createCompte("Pauline", 0);

        assertThrows(NotEnoughMoneyException.class, () -> compteService.transaction(compteA.getId(), compteB.getId(), 200),
                "La transaction avec montant négatif doit lancer une IllegalArgumentException");
    }

    @Test
    @DisplayName("Test de transaction avec des comptes null")
    void testTransactionInvalideCompte() {
        assertThrows(IllegalArgumentException.class, () -> compteService.transaction(null, null, 50),
                "La transaction avec des comptes null doit lancer une IllegalArgumentException");
    }

}
