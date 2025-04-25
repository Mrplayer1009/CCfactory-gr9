package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class Menu {
    List<Cupcake> cupcake;
    List<Main> base;
    List<Main> creme;
    List<Main> topping;

    public void affiche() {
        System.out.println("Le Cupcake du jour est");
            Random rand = new Random();
            Cupcake jour = cupcake.get(rand.nextInt(cupcake.size()));
            System.out.println(jour);
    }
}
