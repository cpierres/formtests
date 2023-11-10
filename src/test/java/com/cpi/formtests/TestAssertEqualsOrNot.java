package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class TestAssertEqualsOrNot {

    @Test
    void verifierEgaliteKo() {
        Dimension dim = new Dimension(801, 601);
        Assertions.assertEquals(new Dimension(800, 600), dim, "Dimensions non egales");
    }

    @Test
    void verifierEgaliteOk() {
        Dimension dim = new Dimension(800, 600);
        Assertions.assertEquals(new Dimension(800, 600), dim, "Dimensions non egales");
    }

    @Test
    void verifierInegalite() {
        Dimension dim = new Dimension(800, 600);
        Assertions.assertNotEquals(new Dimension(800, 600), dim, "Dimensions egales");
    }

}
