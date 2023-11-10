package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * La correspondance est vérifiée en utilisant plusieurs règles pour chaque élément des listes :
 * <ul>
 * <li>vérifier que les deux éléments sont égaux (avec la méthode equals()) : si c'est le cas, passage à l'élément suivant</li>
 * <li>sinon l'élément expected va être utilisé comme une expression régulière pour vérifier s'il y a correspondance avec l'élément actual : si c'est le cas, passage à l'élément suivant</li>
 * <li>sinon vérifie si l'élément expected est un marqueur de type avance rapide : Si c'est la cas, passage à l'élément suivant</li>
 * </ul>
 */
public class TestAssertLinesMatch {

    /**
     * Dans sa forme la plus simple, elle compare simplement les éléments des deux listes
     */
    @Test
    void verifierLinesMatch() {
        List<String> expectedLines = Arrays.asList("A1", "A2", "A3", "A4");
        List<String> emails = Arrays.asList("A1", "A2", "A3", "A4");
        Assertions.assertLinesMatch(expectedLines, emails);
    }

    /**
     * possible d'utiliser des expressions régulières pour vérifier la valeur d'un élément
     */
    @Test
    void verifierLinesMatchAvecRegExp() {
        List<String> expectedLines = Arrays.asList("(.*)@(.*)", "(.*)@(.*)");
        List<String> emails = Arrays.asList("test@gmail.com", "jm@test.fr");
        Assertions.assertLinesMatch(expectedLines, emails);
    }

    /**
     * possible d'ignorer un ou plusieurs éléments durant la comparaison grâce à un marqueur d'avance rapide :
     * ils peuvent par exemple permettre d'ignorer des éléments dont la valeur change à chaque exécution.
     * Un marqueur d'avance rapide commence et termine par >> et doit posséder au moins quatre caractères
     */
    @Test
    void verifierLinesMatchAvanceRapide() {
        // 4 chevrons (>>>>) permet de sauter à la fin
        List<String> expectedLines = Arrays.asList("(.*)@(.*)", ">>>>", "(.*)@(.*)");
        List<String> emails = Arrays.asList("test@gmail.com", "test", "email", "toto", "toto2", "cpi@gmail.com");
        Assertions.assertLinesMatch(expectedLines, emails);
    }

    @Test
    void verifierLinesMatchAvanceRapideAvecDecription() {
        List<String> expectedLines =
                Arrays.asList("(.*)@(.*)", "(.*)@(.*)", ">> aller au dernier >>", "(.*)@(.*)");
        List<String> emails = Arrays.asList("test@gmail.com", "test@gmail.com", "test", "email", "jm@test.fr");
        Assertions.assertLinesMatch(expectedLines, emails);
    }

    /**
     * possible de préciser un nombre exact d'éléments à ignorer
     */
    @Test
    void verifierLinesMatchAvance2elts() {
        List<String> expectedLines = Arrays.asList("A1", ">> 2 >>", "A4");
        List<String> emails = Arrays.asList("A1", "A2", "A3", "A4");//ok
//        List<String> emails = Arrays.asList("A1", "A2", "A3", "A3b", "A4");//AssertionFailedError: expected line #3:`A4` doesn't match
        Assertions.assertLinesMatch(expectedLines, emails);
    }

    @Test
    void verifierLinesMatchAvance1elt() {
        List<String> expectedLines = Arrays.asList("A1", ">> 1 >>", "A4");
        List<String> emails = Arrays.asList("A1", "A2", "A3", "A4");//AssertionFailedError: expected line #3:`A4` doesn't match
        Assertions.assertLinesMatch(expectedLines, emails);
    }

}
