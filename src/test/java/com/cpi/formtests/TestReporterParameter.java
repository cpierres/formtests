package com.cpi.formtests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestReporterParameter {
    @Test
    void monTest(TestReporter testReporter) {
        testReporter.publishEntry("maCle", "maValeur");
        assertTrue(true);
    }
}
