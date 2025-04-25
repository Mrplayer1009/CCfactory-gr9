package com.cupcakefactory.fr.java;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Commande {
    private List<Cupcake> lignes = new ArrayList<>();

    /** Ajoute un cupcake à la commande (vérifie max 2 toppings) */
    public boolean ajouter(Cupcake c) {
        if (c == null) return false;
        if (c.estDispo()) {
            if (c.toppings.size() > 2) return false;
            // consomme le stock
            c.consommer();
            lignes.add(c);
            return true;
        }
        return false;
    }

    /** Calcule le prix total en appliquant promotion 5+1 gratuit HORS cupcakes du jour */
    public float calculerPrixTotal() {
        float total = 0f;
        List<Float> prixHorsJour = new ArrayList<>();
        for (Cupcake c : lignes) {
            float p = c.getPrixUnitaire();
            total += p;
            if (!c.isJour()) {
                prixHorsJour.add(p);
            }
        }
        // si 6 cupcakes hors jour, on retire le plus petit prix
        if (prixHorsJour.size() >= 6) {
            Collections.sort(prixHorsJour);
            total -= prixHorsJour.get(0);
        }
        return total;
    }
}
