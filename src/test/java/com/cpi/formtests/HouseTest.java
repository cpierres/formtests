package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Ce test ne passe pas car
 * - MouseHole est une dépendance externe de la classe House dont le comportement n'est pas prédictible<br>
 * => dans une 2ème étape, on utilisera un mock pour "remplacer" MouseHole et lui définir
 * un comportement prédictible afin de tester le fonctionnement de House
 */
public class HouseTest {

    @Test
    public void shouldCleanHouse() {
        //given
        var house = new House(new MouseHole());

        //when
        int mouseEeaten = house.cleanHouse();

        //then
        Assertions.assertEquals(6, mouseEeaten);
    }

}
