package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Menu {
    List<Cupcake> cupcakesDuJour = new ArrayList<>();
    List<Main> bases = new ArrayList<>();
    List<Main> cremes = new ArrayList<>();
    List<Main> toppings = new ArrayList<>();

    public Menu(List<Cupcake> tousLesCupcakes, List<Main> bases, List<Main> cremes, List<Main> toppings) {
        this.bases = bases;
        this.cremes = cremes;
        this.toppings = toppings;

        Random rand = new Random();
        for (int i = 0; i < 3 && i < tousLesCupcakes.size(); i++) {
            int index = rand.nextInt(tousLesCupcakes.size());
            Cupcake c = tousLesCupcakes.get(index);
            if (c.stock > 0 && !cupcakesDuJour.contains(c)) {
                cupcakesDuJour.add(c);
            }
        }
    }

    public void afficheMenu() {
        System.out.println(" MENU DU JOUR ");

        System.out.println("\nCupcakes du jour :");
        for (Cupcake c : cupcakesDuJour) {
            if (c.stock > 0) {
                System.out.println("- " + c);
            }
        }

        boolean baseDispo = false;
        boolean cremeDispo = false;

        System.out.println("\nIngrédients disponibles :");

        System.out.println("Bases :");
        for (Main b : bases) {
            if (b.Dispo()) {
                System.out.println("- " + b.nom);
                baseDispo = true;
            }
        }

        System.out.println("Crèmes :");
        for (Main c : cremes) {
            if (c.Dispo()) {
                System.out.println("- " + c.nom);
                cremeDispo = true;
            }
        }

        System.out.println("Toppings :");
        for (Main t : toppings) {
            if (t.Dispo()) {
                System.out.println("- " + t.nom);
            }
        }

        if (!baseDispo || !cremeDispo) {
            System.out.println("\n Il n'y a plus assez d'ingrédients pour créer de nouveaux cupcakes.");
            System.out.println(" Seuls les cupcakes du jour sont disponibles.");
        }
    }
}
