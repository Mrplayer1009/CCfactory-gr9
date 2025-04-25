package org.example;
import java.util.List;

public class Main {
    String nom;
    float prix;
    int stock;

    public Main(String nom, float prix, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    public boolean Dispo() {
        return stock > 0;
    }

    public class Cupcake {
        Main base;
        Main creme;
        List<Main> toppings;
        int stock;
    }
}

