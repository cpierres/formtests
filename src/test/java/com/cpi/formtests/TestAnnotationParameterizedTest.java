package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestAnnotationParameterizedTest {
    static Stream<String> fournirDonnees() {
        return Stream.of("elem1", "elem2");
    }

    static List<Object[]> fournirDonneesForTestAvecParams() {
        return Arrays.asList(new Object[][]{{1, "elem1"}, {2, "elem2"}});
    }

    static Stream<Arguments> fournirDonneesTypeArguments() {
        return Stream.of(Arguments.of(1, "elem1"), Arguments.of(2, "elem2"));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    void testParametreAvecValueSource(int valeur) {
        assertEquals(valeur + valeur, valeur * 2);
    }

    @ParameterizedTest
    @EnumSource(Month.class)
    void testParametreAvecEnumSource(Month mois) {
        System.out.println(mois);
        Assertions.assertNotNull(mois);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, mode = EnumSource.Mode.MATCH_ALL, names = {"^J.+$"})
    void testParametreAvecEnumSourceMoisStartJ(Month mois) {
        System.out.println(mois);
        Assertions.assertNotNull(mois);
    }

    @ParameterizedTest
    @MethodSource("fournirDonnees")
    void testParametreAvecMethodSource(String element) {
        assertTrue(element.startsWith("elem"));
    }

    @ParameterizedTest
    @MethodSource("fournirDonneesForTestAvecParams")
    void testMethodAvecParamsEtMethodSource(int index, String element) {
        assertTrue(index > 0);
        assertTrue(element.startsWith("elem"));
    }

    @ParameterizedTest
    @MethodSource("fournirDonneesTypeArguments")
    void testMethodAvecParamsEtMethodSourceReturnArguments(int index, String element) {
        assertTrue(index > 0);
        assertTrue(element.startsWith("elem"));
    }

    @DisplayName("Addition")
    @ParameterizedTest()
    @CsvSource({"1, 1", "1, 2", "2, 3"})
    void testAdditioner(int a, int b) {
        int attendu = a + b;
        assertEquals(attendu, a + b);
    }

    /**
     * le fichier csv doit être dans test/resources (inclus dans classpath par maven)
     */
    @DisplayName("Addition")
    @ParameterizedTest()
    @CsvFileSource(resources = "/additionner_source.csv")
    void testAdditionner(int a, int b) {
        int attendu = a + b;
        assertEquals(attendu, a + b);
    }

    @ParameterizedTest
    @ArgumentsSource(MonArgumentsProvider.class)
    void testAvecArgumentsSource(String valeur) {
        assertTrue(valeur.startsWith("elem"));
    }

    /**
     * Conversion automatique des arguments chaine selon ce qui est attendu
     * en argument de la méthode à tester (ex : "JANUARY" devient Month.JANUARY)
     *
     * @param mois
     */
    @ParameterizedTest
    @ValueSource(strings = {"JANUARY", "FEBRUARY", "MARCH"})
    void testWithImplicitArgumentConversion(Month mois) {
        assertNotNull(mois.name());
    }

    @ParameterizedTest
    @ValueSource(strings = "25/12/2017")
    void testWithExplicitJavaTimeConverter(@JavaTimeConversionPattern("dd/MM/yyyy")
                                           LocalDate date) {
        assertEquals(2017, date.getYear());
    }

    static class MonArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of("elem1", "elem2", "elem3").map(Arguments::of);
        }
    }

    @DisplayName("Addition")
    @ParameterizedTest(name = "{index} ==> l''addition de {0} et {1}")
    @CsvSource({ "1, 1", "1, 2", "2, 3" })
    void testAdditioner2(int a, int b) {
        int attendu = a + b;
        assertEquals(attendu, a + b);
    }

}
