package com.cpi.formtests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * l'annotation @Disabled ne fonctionne pas ?
 */
@Disabled("A écrire plus tard")
@DisplayName("Ma classe de test JUnit5")
public class TestDisabled {

    @Disabled("test 1 à faire")
    @Test
    public void test1() {
        assertTrue(true);
    }

    @Disabled("testAfinir à faire")
    @DisplayName("Cas de test")
    @Test
    public void testAfinir() {
        fail("Non implémenté");
    }
}
