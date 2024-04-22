package org.example.productTest;

import lombok.Data;
import org.example.model.Produit;
import org.example.service.ProduitService;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.NoSuchElementException;

@DisplayName("Test de la classe ProduitService")
public class ProduitTest {
    private ProduitService produitService;

    @BeforeEach
    void init(){
        produitService = new ProduitService();
    }

    @Test
    @DisplayName("Création de produit et incrémentation")
    void testCreateProduitAndIncr(){
        Produit produitA = produitService.ajouterProduit("Chaise",23);
        Produit produitB = produitService.ajouterProduit("Table", 89);
        produitService.supprimeUnProduitParId(produitB.getId());
        Produit produitC = produitService.ajouterProduit("Tabouret", 15);
        System.out.println(produitB.getId());

        Assertions.assertAll("Vérification des propriétés des produits",
                () -> Assertions.assertEquals("Chaise", produitA.getName(), "Le nomde la chaise doit être Chaise"),
                () -> Assertions.assertEquals(23, produitA.getPrice(), "Le prix doit être 23"),
                () -> Assertions.assertEquals(1, produitA.getId(), "Id est egal 1"),
                () -> Assertions.assertEquals(2, produitB.getId(), "Id est egal 2"),
                () -> Assertions.assertEquals(3, produitC.getId(), "Id est egal 3"),
                () -> Assertions.assertTrue(produitB.getId()>0, "Le produit doit avoir un Id"),
                () -> Assertions.assertTrue(produitA.getId()<produitB.getId(),"L'Id du produit A doit être inférieur à celui de produit B")
        );
    }

    @Test
    @DisplayName("Trouver un produit par son id")
    void testTrouverProduitParId(){
        Produit produit = produitService.ajouterProduit("Iphone",1458);
        Produit produit1 = produitService.ajouterProduit("IPad",1700);

        Assertions.assertAll("Vérification de la recupération par Id",
                () -> Assertions.assertEquals(produit, produitService.trouverUnProduitParId(produit.getId()),"Je dois avoir un produit"),
                () -> Assertions.assertEquals(produit1, produitService.trouverUnProduitParId(produit1.getId()),"Je dois avoir un produit1"),
                () -> Assertions.assertThrows(NoSuchElementException.class, ()-> produitService.trouverUnProduitParId(5L),""));
    }

    @Test
    @DisplayName("Modifier un produit")
    void testModifierProduitParId(){
        Produit produit = produitService.ajouterProduit("Iphone",1458);
        Assertions.assertAll("Vérification avant la modification",
                () -> Assertions.assertEquals(produit.getName(), "Iphone","Le nom du produit doit être 'Iphone'"),
                () -> Assertions.assertEquals(produit.getPrice(), 1458,"Le prix du produit doit être 1458"));

        produitService.mettreAJourProduit(produit.getId(),"Samsung",200);

        Assertions.assertAll("Vérification après la modification",
                () -> Assertions.assertEquals(produit.getName(), "Samsung","Le nom du produit doit être 'Samsung' après la modification"),
                () -> Assertions.assertEquals(produit.getPrice(), 200,"Le prix du produit doit être 200 après la modification"));
    }

    @Test
    @DisplayName("Test retourner tout")
    void testRetournerTout(){
        Produit produitA = produitService.ajouterProduit("Iphone", 1458);
        Produit produitB = produitService.ajouterProduit("Samsung", 1200);
        Produit produitC = produitService.ajouterProduit("Wiko", 1100);

        List<Produit> listeProduits = produitService.listeProduits();

        Assertions.assertAll("Vérification des membres de la liste",
                () -> Assertions.assertEquals(3, listeProduits.size(), "La taille de la liste doit être de 3"),
                () -> Assertions.assertTrue(listeProduits.contains(produitA), "La liste doit contenir le produitA"),
                () -> Assertions.assertTrue(listeProduits.contains(produitB), "La liste doit contenir le produitB"),
                () -> Assertions.assertTrue(listeProduits.contains(produitC), "La liste doit contenir le produitC")
        );
    }

}
