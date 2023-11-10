package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAssertTrue {
    @Test
    void verifierTrue() {
        boolean bool = true;
        Assertions.assertTrue(bool);
        Assertions.assertTrue(TestAssertTrue::getBooleen, "Booleen different de true");
    }

    @Test
    void verifierFalse() {
        boolean bool = false;
        Assertions.assertFalse(bool);
        Assertions.assertFalse(TestAssertTrue::getBooleen, "Booleen different de false");
    }

    static boolean getBooleen() {
        return true;//false
    }
}
