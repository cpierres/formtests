package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Les surcharges de la méthode fail() permettent de faire échouer le test en levant une exception
 * de type AssertionFailedError
 */
public class TestFail {

    @Test
    void test1() {
        Assertions.fail("ceci est la raison de l'échec");
    }
}
