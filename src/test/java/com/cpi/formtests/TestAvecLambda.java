package com.cpi.formtests;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * On passe un lambda de type Supplier<String> pour définir le message erreur d'une assertion
 */
public class TestAvecLambda {
    @Test
    void monPremierTest() {
        assertTrue(true);

        //avec référence de méthode
        assertTrue(this::isValide1,"Cette assertion isValide ne passe pas !");

        //avec message sous forme de lambda Supplier<String>
        assertTrue(this::isValide2, () -> "Description " + "du cas " + "de test");

        List<String> attendu = Arrays.asList("e1", "e2", "e2");
        List<String> actual = new LinkedList<>(attendu);
//        List<String> actual = Arrays.asList("e1", "e2", "e3");

        //assertEquals(attendu, actual);
        //message direct
        assertEquals(attendu, actual, "Les listes ne sont pas égales");
        assertEquals(attendu, actual, () -> "Les listes " + "ne sont " + "pas égales");
        assertNotSame(attendu, actual, "Les instances sont les memes");
    }

    boolean isValide1() {
        return true;// true;
    }

    boolean isValide2() {
        return true;// true;
    }

}
