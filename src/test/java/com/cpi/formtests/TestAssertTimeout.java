package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

/**
 * Les assertions assertTimeout et assertTimeoutPreemptively vérifient que les traitements fournis en paramètre
 * s'exécutent avant le délai précisé.
 * La différence entre les deux est que assertTimeoutPreemptively interrompt l'exécution des traitements
 * si le délai est dépassé.
 */
public class TestAssertTimeout {


    private static String traiter() throws InterruptedException {
        Thread.sleep(2000);
        return "";
    }
    @Test
    void verifierTimeout() {
        // surcharges qui permettent de préciser la durée maximale d'exécution (timeout),
        // les traitements à exécuter sous la forme d'un Executable ou d'un ThrowingSupplier
        // et éventuellement un message sous la forme d'une chaîne de caractères ou d'un Supplier<String>
        Assertions.assertTimeout(Duration.ofMillis(200), () -> {
            return "";
        });
        Assertions.assertTimeout(Duration.ofSeconds(1), TestAssertTimeout::traiter);
    }

    @Test
    void verifierTimeoutPreemptively() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            return "";
        });

        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), TestAssertTimeout::traiter);
    }

}
