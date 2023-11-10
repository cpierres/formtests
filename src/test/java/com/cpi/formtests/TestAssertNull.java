package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class TestAssertNull {
    @Test
    void verifierNull() {
        Object dim = new Dimension(800, 600);
        Assertions.assertNull(dim);
        // org.opentest4j.AssertionFailedError:
        // Expected :null
        // Actual   :java.awt.Dimension[width=800,height=600]
    }

    @Test
    void verifierNotNull() {
        Object obj = null;
        Assertions.assertNotNull(obj);
        // org.opentest4j.AssertionFailedError: expected: not <null>
    }
}
