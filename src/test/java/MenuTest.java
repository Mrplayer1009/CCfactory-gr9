package java;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void menuNeContientPasLesIngrédientsÉpuisés() {
        // Un ingrédient crème épuisé, une base dispo
        Ingredient cremeÉpuisée = new Ingredient("Crème A", 1f, 0);
        Ingredient baseDispo    = new Ingredient("Base B", 1f, 1);
        Menu menu = new Menu(
                Arrays.asList(baseDispo),
                Arrays.asList(cremeÉpuisée),
                Arrays.asList()  // pas de toppings
        );

        // La liste des crèmes dispo doit être vide
        assertTrue(menu.getCremesDisponibles().isEmpty(), "La crème épuisée ne doit pas apparaître");
        // La liste des bases dispo doit contenir notre base
        assertEquals(1, menu.getBasesDisponibles().size());
        assertEquals("Base B", menu.getBasesDisponibles().get(0).getNom());
    }

    @Test
    void cupcakesDuJourAbsentsSiIngrédientsIndisponibles() {
        // Crée un menu où toutes les bases et crèmes sont à 0 stock
        Ingredient base0  = new Ingredient("B", 1f, 0);
        Ingredient creme0 = new Ingredient("C", 1f, 0);
        Menu menu = new Menu(
                Arrays.asList(base0),
                Arrays.asList(creme0),
                Arrays.asList()  // pas de toppings
        );

        // Comme ni base ni crème ne sont dispo, aucun cupcake du jour ne peut être composé
        List<Cupcake> dispo = menu.getCupcakesDuJourDisponibles();
        assertTrue(dispo.isEmpty(), "Aucun cupcake du jour ne doit être disponible");
    }
}
