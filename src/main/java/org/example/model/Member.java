package org.example.model;

public class Member {

    private String nom;

    private boolean cotisationPayee;

    private int nbLivresLusCeMois;

    public Member(String nom){
        this.nom = nom;
        this.cotisationPayee = false;
        this.nbLivresLusCeMois = 0;
    }

    public void payerCotisation(){
        this.cotisationPayee = true;
    }

    public void ajouterLivreLu(){
        this.nbLivresLusCeMois += 1;
    }

    public boolean aPayeCotisation(){
        return this.cotisationPayee;
    }

    public boolean aAtteintLeQuotaLivres(int quota){
        return this.nbLivresLusCeMois >= quota;
    }
}
