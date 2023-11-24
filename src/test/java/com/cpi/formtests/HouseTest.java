package com.cpi.formtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.eq;


public class HouseTest {

    /**
     * Ce test ne passe pas car
     * - MouseHole est une dépendance externe de la classe House dont le comportement n'est pas prédictible<br>
     * => dans une 2ème étape (test shouldCleanHousePredictible()), on utilisera un mock pour "remplacer" MouseHole
     * et lui définir un comportement prédictible afin de tester le fonctionnement de House
     */
    @Test
    public void shouldCleanHouse() {
        //given
        var house = new House(new MouseHole());

        //when
        int mouseEeaten = house.cleanHouse();

        //then
        Assertions.assertEquals(6, mouseEeaten);
    }

    /**
     * <P>Il est parfois nécessaire de contrôler l'environnement dans lequel le test
     * évolue, on utilise alors des doublures, des objets capables de se substituer
     * à ceux utilisés en production, afin de rendre l'exécution déterministe<br>
     * - des objets dummy : des objets vides, sans implémentation<br>
     * - des stubs : des objets avec des valeurs retournées codées en dur<br>
     * - des mocks : des objets paramétrables depuis le test<br>
     * </P>
     * Un mock est créé avec la méthode statique "Mockito.mock(Class<T>)"<br>
     * - On obtient un objet du type T, mais cet objet est bien une doublure, un “Proxy” Java qui
     * va permettre à Mockito d'intercepter les invocation de méthodes<br>
     * - Si des méthodes sont appelées à ce stade, elles retourneront des valeurs par défaut (0,
     * null…)<br>
     * <br>
     * - On peut définir le comportement d’une méthode à partir du mock, c'est à dire sa
     * ou ses valeurs de retour avec "Mockito.when(appelDeMethode).thenReturn(valeurARetourner, ...)"<br>
     * - On peut définir que la configuration ne s’applique que si l’appel de méthode est effectué avec certaines
     * valeurs de paramètre, en utilisant des “Matcher” :<br>
     * -- eq() pour une égalité (utilisé par défaut si pas de matcher)<br>
     * --- Mockito.when(doIt(eq(“”))).thenReturn(42)<br>
     * -- contains() pour un contient<br>
     * --- Mockito.when(contains(“pouet”)).thenReturn(42)<br>
     * -- any() pour n'importe quelle valeur
     * --- Mockito.when(any()).thenReturn(42)
     * <br> <br>
     *
     */
    @Test
    public void shouldCleanHousePredictible() {
        // GIVEN
        var mouseHoleMock = Mockito.mock(MouseHole.class);
        var house = new House(mouseHoleMock);

        // ce qu'on veut tester, c'est bien le retour de la méthode house.cleanHouse(), en fonction
        // de plusieurs retours précis (déterminés) attendus par mouseHole.getMouses(x).
        // Le Mockito.when permet à Mockito d'intercepter et prendre le contrôle sur l'instance de type
        // mouseHole tout en lui dictant son comportement attendu (argument et retours spécifiques)
        // par rapport au test que l'on veut faire sur la méthode cible house.cleanHouse().
        // A noter que House n'a pas directement la main sur MouseHole. House ne fait que prendre une nouvelle
        // instance de MouseHole en paramètre dans son constructeur.
        // et c'est à l'intérieur de la méthode house.cleanHouse() que la méthode mouseHoleMock.getMouses(xx)
        // est appelée. C'est là que Mockito va intercepter cet appel avec cette valeur de paramètre et retourner
        // des valeurs en dure pour tester le comportement attendu de house.cleanHouse(); d'une manière prédictible
        // et non plus aléatoire.
        Mockito.when(mouseHoleMock.getMouses(ArgumentMatchers.eq(10))).thenReturn(IntStream.of(1, 2, 3));

        // WHEN
        int mouseEaten = house.cleanHouse();

        // THEN
        Assertions.assertEquals(6, mouseEaten);
    }

}
