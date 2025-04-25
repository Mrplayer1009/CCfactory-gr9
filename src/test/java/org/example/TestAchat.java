package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestAchat {

    private Main ingr(String nom, float prix, int stock) {
        return new Main(nom, prix, stock);
    }

    @Test
    public void testAchatSimpleNePlantePas() {
        List<Main> bases = List.of(ingr("Nature", 1f, 5));
        List<Main> cremes = List.of(ingr("Vanille", 0.8f, 5));
        List<Main> toppings = List.of(ingr("Choco", 0.5f, 5));

        assertDoesNotThrow(() -> Acheter.executer(bases, cremes, toppings));
    }

    @Test
    public void testAchatAvecDeuxToppingsMoinsCherOffert() {
        Main base = ingr("Choco", 1f, 5);
        Main creme = ingr("Framboise", 1f, 5);
        Main t1 = ingr("Topping1", 0.3f, 5); // moins cher
        Main t2 = ingr("Topping2", 0.7f, 5); // plus cher

        List<Main> bases = List.of(base);
        List<Main> cremes = List.of(creme);
        List<Main> toppings = List.of(t1, t2);
    }

    @Test
    public void testPasDeBaseOuCremeAfficheErreur() {
        List<Main> bases = new ArrayList<>();
        List<Main> cremes = new ArrayList<>();
        List<Main> toppings = List.of(ingr("Vermicelles", 0.4f, 5));

        assertDoesNotThrow(() -> Acheter.executer(bases, cremes, toppings));
    }
}

