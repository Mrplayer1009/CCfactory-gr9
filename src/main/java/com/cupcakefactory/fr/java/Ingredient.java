package com.cupcakefactory.fr.java;


public class Ingredient {
    private String nom;
    private float prix;
    private int stock;

    public Ingredient(String nom, float prix, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public boolean estDispo() {
        return stock > 0;
    }

    /** Consomme une dose, renvoie true si possible */
    public boolean consommer() {
        if (stock > 0) {
            stock--;
            return true;
        }
        return false;
    }
}

