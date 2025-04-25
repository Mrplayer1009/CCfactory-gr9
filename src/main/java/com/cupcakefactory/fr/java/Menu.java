package com.cupcakefactory.fr.java;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Menu {
    private List<Ingredient> bases;
    private List<Ingredient> cremes;
    private List<Ingredient> toppings;
    private List<Cupcake> cupcakesJour;

    public Menu(List<Ingredient> bases, List<Ingredient> cremes, List<Ingredient> toppings) {
        this.bases    = bases;
        this.cremes   = cremes;
        this.toppings = toppings;
        genererCupcakesDuJour();
    }

    /** Tire au hasard 3 cupcakes du jour, stock illimité en tant qu’offre */
    private void genererCupcakesDuJour() {
        cupcakesJour = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            // base + crème aléatoires, sans toppings
            Ingredient b = bases.get(rand.nextInt(bases.size()));
            Ingredient c = cremes.get(rand.nextInt(cremes.size()));
            cupcakesJour.add(new Cupcake(b, c, new ArrayList<>() , true));
        }
    }

    /** Affiche le menu actuel */
    public void afficher() {
        System.out.println("=== Cupcakes du jour ===");
        for (Cupcake c : cupcakesJour) {
            System.out.println("- " + c);
        }
        System.out.println("\n=== Ingrédients disponibles ===");
        System.out.println("Bases:");
        for (Ingredient b : bases) {
            if (b.estDispo()) System.out.println("  • " + b.getNom());
        }
        System.out.println("Crèmes:");
        for (Ingredient c : cremes) {
            if (c.estDispo()) System.out.println("  • " + c.getNom());
        }
        System.out.println("Toppings:");
        for (Ingredient t : toppings) {
            if (t.estDispo()) System.out.println("  • " + t.getNom());
        }
    }

    /** Retourne la liste des cupcakes du jour encore disponibles (ceux dont ingrédients sont en stock) */
    public List<Cupcake> getCupcakesDuJourDisponibles() {
        List<Cupcake> dispo = new ArrayList<>();
        for (Cupcake c : cupcakesJour) {
            if (c.estDispo()) dispo.add(c);
        }
        return dispo;
    }

    /** Filtre la liste des toppings/dispo pour qu’on ne propose pas d’ingrédients épuisés */
    public List<Ingredient> getBasesDisponibles() { return filterDispo(bases); }
    public List<Ingredient> getCremesDisponibles(){ return filterDispo(cremes); }
    public List<Ingredient> getToppingsDisponibles(){ return filterDispo(toppings); }

    private List<Ingredient> filterDispo(List<Ingredient> list) {
        List<Ingredient> res = new ArrayList<>();
        for (Ingredient i : list) {
            if (i.estDispo()) res.add(i);
        }
        return res;
    }
}
