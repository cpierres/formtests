package com.cpi.formtests;

import org.junit.jupiter.api.*;

/**
 * Cycle de vie d'un test.
 * 2 méthodes à tester avec les méthodes associées permettant de gérer le cycle de vie
 */
public class MonTest01 {

    @BeforeAll
    static void initAll() {
        System.out.println("beforeAll");
    }

    @BeforeEach
    void init() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("afterEach");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("afterAll");
    }

    @Test
    void method1() {
        System.out.println("method1");
        Assertions.assertTrue(true);
    }

    @Test
    void method2() {
        System.out.println("method2");
        Assertions.assertTrue(true);
    }
}
