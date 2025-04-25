package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Menu {
    public List<Cupcake> cupcakesDuJour = new ArrayList<>();
    public List<Main> bases = new ArrayList<>();
    public List<Main> cremes = new ArrayList<>();
    public List<Main> toppings = new ArrayList<>();

    public Menu(List<Cupcake> tousLesCupcakes, List<Main> bases, List<Main> cremes, List<Main> toppings) {
        // On ne garde que les ingrédients disponibles
        for (Main b : bases) {
            if (b.Dispo()) {
                this.bases.add(b);
            }
        }
        for (Main c : cremes) {
            if (c.Dispo()) {
                this.cremes.add(c);
            }
        }
        for (Main t : toppings) {
            if (t.Dispo()) {
                this.toppings.add(t);
            }
        }

        Random rand = new Random();
        int essais = 0;
        while (cupcakesDuJour.size() < 3 && essais < tousLesCupcakes.size()) {
            Cupcake c = tousLesCupcakes.get(rand.nextInt(tousLesCupcakes.size()));
            if (c.stock > 0 && !cupcakesDuJour.contains(c)) {
                cupcakesDuJour.add(c);
            }
            essais++;
        }
    }

    public void afficheMenu() {
        System.out.println("=== MENU DU JOUR ===");

        System.out.println("\nCupcakes du jour :");
        for (Cupcake c : cupcakesDuJour) {
            System.out.println("- " + c);
        }

        System.out.println("\nIngrédients disponibles :");
        System.out.println("Bases :");
        for (Main b : bases) {
            System.out.println("- " + b.nom);
        }

        System.out.println("Crèmes :");
        for (Main c : cremes) {
            System.out.println("- " + c.nom);
        }

        System.out.println("Toppings :");
        for (Main t : toppings) {
            System.out.println("- " + t.nom);
        }
    }
}
