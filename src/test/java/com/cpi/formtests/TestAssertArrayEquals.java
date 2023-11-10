package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAssertArrayEquals {

    @Test
    void verifierEgaliteTableaux() {
        Assertions.assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 },
                "Egalite des tableaux");
    }

    @Test
    void verifierEgaliteTableauxOrdreDifferent() {
        Assertions.assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 },
                "Egalite des tableaux (ordre différent)");
    }

    @Test
    void verifierEgaliteTableauxOneEltMore() {
        Assertions.assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3, 4 },
                "Egalite des tableaux");
    }


}
