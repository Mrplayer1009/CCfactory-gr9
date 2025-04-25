package com.cupcakefactory.fr.java;


import java.util.List;

public class Cupcake {
    private Ingredient base;
    private Ingredient creme;
    List<Ingredient> toppings;
    private boolean jour;       // true si « cupcake du jour »

    public Cupcake(Ingredient base, Ingredient creme, List<Ingredient> toppings, boolean jour) {
        this.base     = base;
        this.creme    = creme;
        this.toppings = toppings;
        this.jour     = jour;
    }

    public boolean estDispo() {
        // disponible si tous les ingrédients sont en stock
        if (!base.estDispo() || !creme.estDispo()) return false;
        for (Ingredient t : toppings) {
            if (!t.estDispo()) return false;
        }
        return true;
    }

    /** Consomme une dose de chaque ingrédient */
    public boolean consommer() {
        if (!estDispo()) return false;
        base.consommer();
        creme.consommer();
        for (Ingredient t : toppings) {
            t.consommer();
        }
        return true;
    }

    /** Calcule le prix unitaire avant réduction volume */
    public float getPrixUnitaire() {
        float prixTotal = base.getPrix() + creme.getPrix();
        // sommation des toppings
        float minTop = Float.MAX_VALUE;
        for (Ingredient t : toppings) {
            prixTotal += t.getPrix();
            minTop = Math.min(minTop, t.getPrix());
        }
        // 1er topping offert (le moins cher)
        if (toppings.size() >= 1) {
            prixTotal -= minTop;
        }
        // réduction jour à 60%
        if (jour) {
            prixTotal *= 0.6f;
        }
        return prixTotal;
    }

    public boolean isJour() {
        return jour;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(base.getNom()).append(" + ").append(creme.getNom());
        if (!toppings.isEmpty()) {
            sb.append(" + ");
            for (int i = 0; i < toppings.size(); i++) {
                sb.append(toppings.get(i).getNom());
                if (i < toppings.size()-1) sb.append(", ");
            }
        }
        if (jour) sb.append(" (Jour)");
        return sb.toString();
    }
}

