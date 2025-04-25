package com.cupcakefactory.fr.java;


import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        // 1) Création des ingrédients
        Ingredient baseNature    = new Ingredient("Nature", 2.0f, 10);
        Ingredient baseChoco     = new Ingredient("Chocolat", 2.5f, 10);
        Ingredient cremeVanille  = new Ingredient("Vanille", 1.5f, 10);
        Ingredient cremeFraise   = new Ingredient("Fraise", 1.8f, 0); // épuisée
        Ingredient topChoco      = new Ingredient("Pépites", 0.5f, 5);
        Ingredient topMarshmallow= new Ingredient("Marshmallow", 0.7f, 5);

        // 2) Construction du menu
        Menu menu = new Menu(
                Arrays.asList(baseNature, baseChoco),
                Arrays.asList(cremeVanille, cremeFraise),
                Arrays.asList(topChoco, topMarshmallow)
        );

        // 3) Affichage menu
        menu.afficher();

        // 4) Création d’une commande
        Commande commande = new Commande();
        // on commande un cupcake simple « Nature + Vanille + Pépites »
        Cupcake c1 = new Cupcake(baseNature, cremeVanille, Arrays.asList(topChoco), false);
        commande.ajouter(c1);

        // 5) On affiche le prix
        System.out.printf("Total à payer : %.2f €\n", commande.calculerPrixTotal());
    }
}

