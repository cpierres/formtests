package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * vérifie que l'exécution de la méthode passée en paramètre lève l'exception précisée :
 * si ce n'est pas le cas, elle lève une exception pour faire échouer le test
 */
public class TestAssertThrows {
    @Test
    void verifierException1() {
        String valeur = null;
        assertThrows(NumberFormatException.class, () -> {
            Integer.valueOf(valeur);
        });
        //le test réussi car l'exception attendue se déclenche bien
    }

    /**
     * aussi possible de préciser une super-classe de l'exception attendue.
     * test ci-dessous réussi car l'exception NumberFormatException hérite de l'exception IllegalArgumentException.
     */
    @Test
    void verifierException2() {
        String valeur = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(valeur);
        });
        //le test réussi car l'exception attendue se déclenche bien (du moins le parent de l'exception déclenchée)
    }

    /**
     * L'exception attendue ne se produit pas, donc le test échoue
     */
    @Test
    void verifierException() {
        String valeur = "1";
        assertThrows(NumberFormatException.class, () -> {
            Integer.valueOf(valeur);
        });
        //AssertionFailedError: Expected java.lang.NumberFormatException to be thrown, but nothing was thrown.
    }

    @Test
    void verifierExceptionSpecifique() {
        ClassPourTestException maClasse = new ClassPourTestException();
        RuntimeException excep = Assertions.assertThrows(RuntimeException.class, maClasse::maMethode);
        Assertions.assertAll(
                () -> Assertions.assertEquals("message erreur", excep.getMessage()),
                () -> Assertions.assertNull(excep.getCause()));
        //ce test échoue car le message de l'exception n'est pas celui attendu
        //org.opentest4j.AssertionFailedError:
        //Expected :message erreur
        //Actual   :mon message d'erreur
    }

}
