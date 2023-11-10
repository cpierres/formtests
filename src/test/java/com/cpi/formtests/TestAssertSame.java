package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class TestAssertSame {
    @Test
    void verifierSame1() {
        Object actuel = new Dimension(800, 600);
        Object attendu = new Dimension(800, 600);
        Assertions.assertSame(actuel, attendu);
        // org.opentest4j.AssertionFailedError:
        // expected: java.awt.Dimension@31a5c39e<java.awt.Dimension[width=800,height=600]>
        // but was: java.awt.Dimension@3f49dace<java.awt.Dimension[width=800,height=600]>
        // Expected :java.awt.Dimension[width=800,height=600]
        // Actual   :java.awt.Dimension[width=800,height=600]
    }

    @Test
    void verifierSame2() {
        Object actuel = new Dimension(800, 600);
        Object attendu = actuel;
        Assertions.assertSame(actuel, attendu);
    }

    @Test
    void verifierNotSame() {
        Object actuel = new Dimension(800, 600);
        Object attendu = actuel;
        Assertions.assertNotSame(actuel, attendu);
        //org.opentest4j.AssertionFailedError: expected: not same but was: <java.awt.Dimension[width=800,height=600]>
    }
}