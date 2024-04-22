package org.example.model;

public class Annee {
    private int nombre;

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public boolean isBissextile(){
        return (this.nombre % 400 == 0) || (this.nombre % 4 == 0) && (this.nombre % 100 != 0);
    }

}
