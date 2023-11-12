package com.cpi.formtests;

import org.junit.jupiter.api.*;

public class TestAnnotationNestedEtTestInstance {
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
        System.out.println("AfterAll");
    }

    @Test
    void simpleTest() {
        System.out.println("SimpleTest valeur=" + valeur);
        Assertions.assertEquals(1, valeur);
    }

    /**
     * Une classe de test imbriquée ne peut pas par défaut avoir de méthode static annotée :
     * les annotations @BeforeAll et @AfterAll ne peuvent donc pas être utilisées.<br>
     * Pour pouvoir le faire, il faut annoter la classe imbriquée avec @TestInstance(Lifecycle.PER_CLASS)
     */
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class MonTestImbrique {
        @BeforeAll
        void initAllImbrique() {
            System.out.println("BeforAll imbrique ; non static => @TestInstance(TestInstance.Lifecycle.PER_CLASS)");
        }

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
