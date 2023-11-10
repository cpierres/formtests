package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.awt.*;

/**
 * La méthode assertAll() vérifie que l'exécution de tous les Executable fournis ne lève aucune exception.<br>
 * Si la vérification d'au moins une des assertions définies dans le groupe échoue alors la méthode assertAll()
 * lève une exception de type org.opentest4j.MultipleFailuresError
 */
public class TestAssertAll {

    @Test
    void verifierAttributs1() {
        Dimension dim = new Dimension(800, 600);
        Assertions.assertAll("Dimensions non confirmes",
                () -> Assertions.assertTrue(dim.getWidth() == 801, "Valeur de width erronee"),
                () -> Assertions.assertTrue(dim.getHeight() == 601, "Valeur de height erronee"));
    }

    /**
     * Un Executable est une Function
     */
    @Test
    void verifierAttributs2() {
        Dimension dim = new Dimension(800, 600);
        Executable exec1 = () -> {
            Assertions.assertTrue(dim.getWidth() == 801, "Valeur de width erronee");
        };

        Executable exec2 = () -> {
            Assertions.assertTrue(dim.getHeight() == 600, "Valeur de width erronee");
        };

        Assertions.assertAll("Dimensions non confirmes", exec1, exec2);
    }

    @Test
    void verifierAttributs3() {
        Dimension dim = new Dimension(800, 600);
        Executable exec1 = () -> {
            Assertions.assertTrue(dim.getWidth() == 800, "Valeur de width erronee");
        };

        Executable exec2 = () -> {
            Assertions.assertTrue(dim.getHeight() == 600, "Valeur de width erronee");
        };

        Assertions.assertAll("Dimensions non confirmes", exec1, exec2);
    }
}
