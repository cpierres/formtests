package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * permet de vérifier que deux Iterables sont égaux de manière profonde, ce qui implique plusieurs vérifications :
 * <ul>
 * <li>	le nombre des éléments</li>
 * <li>l'ordre des éléments</li>
 * <li>lors de l'itération sur les éléments, chacun des éléments doit être égal à celui correspondant dans l'autre liste</li>
 * </ul>
 */
public class TestAssertIterableEquals {
    @Test
    void verifierIterableEquals1() {
        Iterable<Integer> attendu = new ArrayList<>(Arrays.asList(1, 2, 3));
        Iterable<Integer> actuel = new ArrayList<>(Arrays.asList(1, 2, 3));
        Assertions.assertIterableEquals(attendu, actuel);
    }

    /**
     * échoue car le nombre d'éléments des deux collections est différent
     */
    @Test
    void verifierIterableEquals2() {
        Iterable<Integer> attendu = new ArrayList<>(Arrays.asList(1, 2, 3));
        Iterable<Integer> actuel = new ArrayList<>(Arrays.asList(1, 2));
        Assertions.assertIterableEquals(attendu, actuel);
    }

    /**
     * échoue car l'ordre des éléments des deux collections est différent
     */
    @Test
    void verifierIterableEquals3() {
        Iterable<Integer> attendu = new ArrayList<>(Arrays.asList(1, 2, 3));
        Iterable<Integer> actuel = new ArrayList<>(Arrays.asList(3, 2, 1));
        Assertions.assertIterableEquals(attendu, actuel);
    }

}
