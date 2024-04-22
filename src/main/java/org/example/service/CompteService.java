package org.example.service;

import org.example.Exception.NotEnoughMoneyException;
import org.example.model.Compte;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CompteService {
    private List<Compte> liste = new ArrayList<>();

    public Compte createCompte(String nom, double solde){

        if(nom==null || nom.isEmpty()){
            throw new IllegalArgumentException("Vous devez renseigner un nom valide");
        }
        // On considère qu'on peut avoir un solde négatif
        Compte compte = new Compte(nom, solde);
        liste.add(compte);
        return compte;
    }

    public Compte findCompteById(Long id){

        return liste.stream()
                .filter(compte -> compte.getId() == id)
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("Le compte Id: " + id + " n'existe pas"));
    }

    public boolean transaction(Long idEmetteur, Long idReceveur, double somme){
        if (idEmetteur == null || idReceveur == null) {
            throw new IllegalArgumentException("Les identifiants des comptes de la transaction ne peuvent pas être null.");
        }
        if (somme <= 0) {
            throw new IllegalArgumentException("La somme de la transaction doit être strictement positive.");
        }

        Compte emetteur = findCompteById(idEmetteur);
        Compte receveur = findCompteById(idReceveur);


        double soldeEmetteurAfterTransaction = emetteur.getSolde() - somme;

        if (soldeEmetteurAfterTransaction < 0) {
            throw new NotEnoughMoneyException("Le solde du compte émetteur est insuffisant pour effectuer cette transaction.");
        }


        double newBalanceEmetteur = emetteur.getSolde()-somme;
        double newBalanceReceveur = receveur.getSolde()+somme;

        emetteur.setSolde(newBalanceEmetteur);
        receveur.setSolde(newBalanceReceveur);
        return true;
    }

    public void deleteCompteById(Long id){
        liste.removeIf(compte -> Objects.equals(compte.getId(), id));
    }

    public List<Compte> getAllCompte(){
        return liste;
    }
}
