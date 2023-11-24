package com.cpi.formtests;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Les tests dynamiques sont des tests qui sont générés à l'exécution par une méthode de type fabrique qui
 * est annotée avec @TestFactory. Les méthodes annotées avec @TestFactory ne sont donc pas des cas de tests
 * mais des fabriques pour fournir un ensemble de cas de tests.<br>
 * Le moteur d'exécution de JUnit va invoquer les méthodes annotées avec @TestFactory, ajouter le DynamicTest
 * obtenu dans les tests et l'exécuter.<br>
 * Les méthodes annotées avec @TestFactory peuvent avoir si besoin des paramètres dont les valeurs devront être
 * injectées grâce à des ParameterResolvers.<br>
 * L'exécution des DynamicTest est différente de celle des tests standards : les cas de tests dynamiques ne peuvent
 * pas avoir de méthodes du cycle de vie invoquées. Les méthodes annotées avec @BeforeEach et @AfterEach sont
 * invoquées pour la méthode annotée avec @TestFactory mais elles ne sont pas invoquées lors de l'exécution des cas
 * de tests créés dynamiquement.
 */
public class TestDynamiques {

    /**
     * Le code du test doit être encapsulé dans une instance de type DynamicTest qui est créé dynamiquement à
     * l'exécution.
     * Une méthode annotée avec @TestFactory ne peut pas être static ou private et peut retourner un objet de type :
     * - Stream<DynamicTest>
     * - Collection<DynamicTest>
     * - Iterable<DynamicTest>
     * - Iterator<DynamicTest>
     * Si la méthode renvoie un objet d'un autre type alors une exception de type JUnitException est levée.
     * Une instance de DynamicTest peut être créée en utilisant la méthode statique dynamicTest(String, Executable) de
     * la classe DynamicTest. Cette méthode est une fabrique qui attend en paramètre le nom du test et le code
     * à exécuter. Le test est fourni sous la forme d'une interface fonctionnelle Executable ce qui permet de fournir
     * l'implémentation sous la forme d'une expression Lambda.
     * La fabrique peut renvoyer une Collection de DynamicTest.
     *
     * @return
     */
    @TestFactory
    Collection<DynamicTest> dynamicTestsAvecCollection() {
        Collection<DynamicTest> resultat = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            int val = i;
            resultat.add(DynamicTest.dynamicTest("Ajout " + val + "+" + val,
                    () -> assertEquals(val * 2, val + val)));
        }
        return resultat;
    }

    /**
     * La fabrique peut aussi renvoyer un Iterator de DynamicTest
     *
     * @return
     */
    @TestFactory
    Iterator<DynamicTest> dynamicTestsAvecIterator() {
        List<DynamicTest> resultat = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            int val = i;
            resultat.add(DynamicTest.dynamicTest("Ajout " + val + "+" + val,
                    () -> assertEquals(val * 2, val + val)));
        }
        return resultat.iterator();
    }

    /**
     * La fabrique peut enfin renvoyer un Stream de DynamicTest.
     * Si la fabrique renvoie un Stream, sa méthode close() sera invoquée à la fin de l'exécution des tests dynamiques
     * qu'il contient, ce qui est important si la source du Stream requiert sa fermeture.
     *
     * @return
     */
    @TestFactory
    Stream<DynamicTest> dynamicTestsAvecStream() {
        return IntStream.rangeClosed(1, 5)
                .mapToObj(val -> DynamicTest.dynamicTest("Ajout " + val + "+" + val,
                        () -> assertEquals(val * 2, val + val)));
    }

}