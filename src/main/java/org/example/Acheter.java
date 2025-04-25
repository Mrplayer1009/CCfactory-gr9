package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Acheter {

    public static void executer(List<Main> bases, List<Main> cremes, List<Main> toppings) {
        Random rand = new Random();

        if (bases.isEmpty() || cremes.isEmpty()) {
            System.out.println(" Impossible de commander");
            return;
        }


        Main base = bases.get(rand.nextInt(bases.size()));
        Main creme = cremes.get(rand.nextInt(cremes.size()));

        System.out.println("Le Cupcake :");
        System.out.println("Base: " + base.nom);
        System.out.println("Crème: " + creme.nom);


        List<Main> choisis = new ArrayList<>();
        if (!toppings.isEmpty()) {
            choisis.add(toppings.get(rand.nextInt(toppings.size())));
        }
        if (toppings.size() > 1 && rand.nextBoolean()) {
            Main t2 = toppings.get(rand.nextInt(toppings.size()));
            if (!choisis.contains(t2)) {
                choisis.add(t2);
            }
        }

        System.out.println("Toppings: ");
        for (Main t : choisis) {
            System.out.println("  • " + t.nom);
        }


        float prix = base.prix + creme.prix;

        if (choisis.size() == 1) {
            prix += choisis.get(0).prix;
        } else if (choisis.size() == 2) {
            float p1 = choisis.get(0).prix;
            float p2 = choisis.get(1).prix;
            prix += Math.max(p1, p2);
        }

        System.out.println(" Prix total : " + prix + " €");
    }
}

