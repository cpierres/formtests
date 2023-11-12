package com.cpi.formtests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Ma classe de test JUnit5")
public class TestInfoParameter {
    @Test
    @Tag("monTag")
    @DisplayName("mon test")
    void monTest(TestInfo testInfo) {
        System.out.println("Display name : " + testInfo.getDisplayName());
        System.out.println("Classe de test : " + testInfo.getTestClass().get().getName());
        System.out.println("Methode de test : " + testInfo.getTestMethod().get().getName());
        System.out.println("Tag : " + testInfo.getTags().toArray()[0]);
        System.out.println();
        assertTrue(true);
    }
}
