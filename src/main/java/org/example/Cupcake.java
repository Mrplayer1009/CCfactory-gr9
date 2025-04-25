package org.example;

import java.util.List;

public class Cupcake {
    Main base;
    Main creme;
    List<Main> topping;
    int stock;

    public Cupcake(Main base, Main creme, List<Main> toppings, int stock) {
        this.base = base;
        this.creme = creme;
        this.topping = toppings;
        this.stock = stock;
    }
}
