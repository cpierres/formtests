package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * - Chaque exécution de test est indépendante des autres, avec une instance
 * différente de la classe. Chacun des tests est donc isolé des autres<br>
 * -- pas de partage des attributs de classes, hormis les “static”<br>
 *
 * - Les méthodes annotées par @BeforeEach ou @AfterEach sont des
 * méthodes qui seront exécutées avant ou après chaque test de la classe<br>
 * -- pour initialiser des inputs ou des mocks récurrents à tous les tests<br>
 *
 *  - Les méthodes annotées par @BeforeAll ou @AfterAll sont des méthodes
 * qui seront exécutées, une fois, avant ou après tous les tests de la classe<br>
 * -- pour initialiser des ressources transverse au tests, comme une base de donnée<br>
 */
public class CatTest {
    private Cat cat;

    @BeforeEach
    public void beforeEcach() {
        cat = new Cat("Minnie");
    }

    @Test
    public void shouldEatOneMouseWhenCatchOneMouse() {
        //given

        //when
        cat.catchMouse(1);

        //then
        Assertions.assertEquals(1, cat.getEatenMouseTotal());
    }

    @Test
    public void shouldEatMousesWhenCatchSecondTimes() {
        // given
        cat.catchMouse(1);

        //when
        cat.catchMouse(1);

        //then
        Assertions.assertEquals(2, cat.getEatenMouseTotal());
    }

}
