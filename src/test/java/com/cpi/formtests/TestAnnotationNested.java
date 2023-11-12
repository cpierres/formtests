package com.cpi.formtests;

import org.junit.jupiter.api.*;

public class TestAnnotationNested {
    private int valeur = 0;

    @BeforeAll
    static void initAll() {
        System.out.println("BeforeAll (static)");
    }

    @BeforeEach
    void init() {
        System.out.println("BeforeEach");
        valeur = 1;
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
        valeur = 0;
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll (static)");
    }

    @Test
    void simpleTest() {
        System.out.println("SimpleTest valeur=" + valeur);
        Assertions.assertEquals(1, valeur);
    }

    @Nested
    class MonTestImbrique {
        @BeforeEach
        void init() {
            System.out.println("BeforeEach imbrique");
            valeur = 2;
        }

        @Test
        void simpleTestImbrique() {
            System.out.println("SimpleTest imbrique valeur=" + valeur);
            Assertions.assertEquals(2, valeur);
        }
    }
}
