package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Les classes et les méthodes de tests peuvent être tagguées pour permettre d'utiliser ces tags
 * ultérieurement pour déterminer les tests à exécuter. Ils peuvent par exemple être utilisés
 * pour créer différents scénarios de tests ou pour exécuter les tests
 * uniquement sur des environnements dédiés.<br>
 * Possible d'utiliser plusieurs annotations @Tag sur un même élément.
 */
@Tag("principal")
public class TestTag {
    @Test
    @Tag("general")
    void testCas1() {
        Assertions.assertTrue(true);
    }

    @Test
    @Tag("specifique")
    @Tag("devOnly")
    void testCas2() {
        Assertions.assertTrue(true);
    }

}
