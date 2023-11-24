package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Pour exécuter les tests, il est nécessaire d'écrire une classe qui implémente l'interface
 * pour permettre au moteur d'exécution la création d'une instance.
 */
public class TestInterfaceClassImplement implements TestInterfaceDefaultMethods {

    @Test
    void monSecondTest() {
        Assertions.assertTrue(true);
    }
}