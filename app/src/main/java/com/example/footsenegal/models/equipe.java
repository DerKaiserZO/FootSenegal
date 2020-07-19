package com.example.footsenegal.models;

public class equipe {
    private String Nom;
    private int type_categorie;

    public equipe(String nom, int type_categorie) {
        Nom = nom;
        this.type_categorie = type_categorie;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getType_categorie() {
        return type_categorie;
    }

    public void setType_categorie(int type_categorie) {
        this.type_categorie = type_categorie;
    }

    @Override
    public String toString() {
        return "equipe{" +
                "Nom='" + Nom + '\'' +
                ", type_categorie=" + type_categorie +
                '}';
    }
}
