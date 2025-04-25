package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestMenu {

    private Main ingr(String nom, float prix, int stock) {
        return new Main(nom, prix, stock);
    }

    private Cupcake cupcake(Main base, Main creme, List<Main> toppings, int stock) {
        return new Cupcake(base, creme, toppings, stock);
    }

    @Test
    public void testMenuContientCupcakesDuJour() {
        List<Cupcake> cupcakes = new ArrayList<>();
        cupcakes.add(cupcake(ingr("Nature", 1f, 10), ingr("Vanille", 0.8f, 10), new ArrayList<>(), 5));

        Menu menu = new Menu(cupcakes, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        assertFalse(menu.cupcakesDuJour.isEmpty(), "Le menu devrait contenir des cupcakes du jour");
    }

    @Test
    public void testMenuContientIngrédientsDisponibles() {
        Main base = ingr("Choco", 1f, 5);
        Main creme = ingr("Framboise", 0.9f, 2);
        Main topping = ingr("Sprinkles", 0.4f, 1);

        Menu menu = new Menu(new ArrayList<>(), List.of(base), List.of(creme), List.of(topping));

        assertTrue(menu.bases.contains(base), "Base disponible non listée");
        assertTrue(menu.cremes.contains(creme), "Crème disponible non listée");
        assertTrue(menu.toppings.contains(topping), "Topping disponible non listé");
    }

    @Test
    public void testIngrédientÉpuiséNonListé() {
        Main base = ingr("Nature", 1f, 0);
        Main creme = ingr("Vanille", 0.9f, 3);

        Menu menu = new Menu(new ArrayList<>(), List.of(base), List.of(creme), new ArrayList<>());

        assertFalse(menu.bases.stream().anyMatch(b -> b.stock == 0), "Les ingrédients épuisés ne doivent pas apparaître");
    }

    @Test
    public void testCupcakeDuJourÉpuiséNonListé() {
        Cupcake c1 = cupcake(ingr("Base", 1f, 1), ingr("Crème", 1f, 1), new ArrayList<>(), 0);

        Menu menu = new Menu(List.of(c1), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        assertTrue(menu.cupcakesDuJour.stream().noneMatch(c -> c.stock == 0), "Un cupcake du jour épuisé ne doit pas apparaître");
    }

    @Test
    public void testPlusDeBaseOuCreme_AfficheQueCupcakeDuJour() {
        Main base = ingr("Base", 1f, 0); // plus de base
        Main creme = ingr("Crème", 1f, 0); // plus de crème
        Cupcake c1 = cupcake(ingr("Base", 1f, 2), ingr("Crème", 1f, 2), new ArrayList<>(), 3);

        Menu menu = new Menu(List.of(c1), List.of(base), List.of(creme), new ArrayList<>());

        boolean baseDispo = menu.bases.stream().anyMatch(Main::Dispo);
        boolean cremeDispo = menu.cremes.stream().anyMatch(Main::Dispo);

        assertFalse(baseDispo || cremeDispo, "Il ne doit plus rester de base ou crème");
        assertFalse(menu.cupcakesDuJour.isEmpty(), "Le menu doit toujours contenir les cupcakes du jour");
    }
}
