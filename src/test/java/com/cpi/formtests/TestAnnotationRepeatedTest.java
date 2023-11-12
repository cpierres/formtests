package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class TestAnnotationRepeatedTest {

    @DisplayName("test addition repété")
    @RepeatedTest(5)
    void testRepeteAddition() {
        Assertions.assertEquals(2, 1 + 1, "Valeur obtenue erronée");
    }

    @DisplayName("test multiplication repété")
    @RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
    void testRepeteMultiplication() {
        Assertions.assertEquals(4, 2 * 2, "Valeur obtenue erronée");
    }

    @DisplayName("test testRepeteAvecParamRepetitionInfo avec param RepetitionInfo")
    @RepeatedTest(value = 3)
    void testRepeteAvecParamRepetitionInfo(RepetitionInfo repInfo) {
        System.out.println("iteration courante : " + repInfo.getCurrentRepetition());
        System.out.println("nombre de repetition :" + repInfo.getTotalRepetitions());
        Assertions.assertEquals(2, 1 + 1, "Valeur obtenue erronée");
    }
}
