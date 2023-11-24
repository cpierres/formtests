package com.cpi.formtests;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * On peut utiliser les annotations @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, @TestTemplate, @BeforeEach
 * et @AfterEach sur des méthodes par défaut d'une interface.<br>
 * Il est aussi possible d'utiliser les annotations @BeforeAll et @AfterAll sur des méthodes static ou default d'une
 * interface qui doit être annotée dans ce cas avec @TestInstance(Lifecycle.PER_CLASS).<br>
 * Par contre, on ne peut pas bien entendu exécuter des tests directement sur cette interface puisque JUNIT doit
 * instancier un objet via une classe qui héritera de cette interface.<br>
 * Il est aussi possible d'utiliser les annotations @ExtendWith et @Tag sur une interface, ce qui permettra aux
 * classes qui l'implémente d'hériter de ces annotations.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
interface TestInterfaceDefaultMethods {
    @BeforeAll
    default void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    default void afterAll() {
        System.out.println("After all");
    }

    @BeforeEach
    default void beforeEach(TestInfo testInfo) {
        System.out.println("Before test " + testInfo.getDisplayName());
    }

    @AfterEach
    default void afterEach(TestInfo testInfo) {
        System.out.println("After test " + testInfo.getDisplayName());
    }

    @TestFactory
    default Collection<DynamicTest> dynamicTests() {
        return Arrays.asList(DynamicTest.dynamicTest("true", () -> assertTrue(true)),
                DynamicTest.dynamicTest("false", () -> assertFalse(false)));
    }

    @Test
    default void monPremierTest() {
        assertTrue(true);
    }
}
