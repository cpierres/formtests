package com.cpi.formtests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class TestAssumptionsAssumeThat {

    @Test
    void testWindowsDirectory() {
        assumingThat(System.getenv("OS").startsWith("Windows"), () -> {
            assertTrue(new File("C:/WindowsZZX").exists(), "Repertoire Windows inexistant");
            //org.opentest4j.AssertionFailedError: Repertoire Windows inexistant
        });
        //si le traitement précédent échoue, ce test suivant ne sera pas lancé
        assertTrue(false);
    }
}
