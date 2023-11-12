package com.cpi.formtests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TestAssumptionsAssumeTrue {

    @Test
    public void testOsLinux() {
        System.out.println(System.getenv("OS"));
        //assumeTrue(System.getenv("OS").startsWith("Windows"));
        assumeTrue(System.getenv("OS").startsWith("linux"));//org.opentest4j.TestAbortedException: Assumption failed: assumption is not true
        assertTrue(false);//ceci ne sera pas exécuté car assumeTrue ligne précédente a interrompu
    }
}
