package com.cpi.formtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Ne fonctionne pas
 */
@ExtendWith(MockitoExtension.class)
public class HouseAnnotationMockitoTest {

    @Mock
    MouseHole mouseHoleMock = Mockito.mock(MouseHole.class);

    @InjectMocks
    House house;

    @Test
    public void shouldCleanHousePredictable() {
        //GIVEN
        Mockito.when(mouseHoleMock.getMouses(Mockito.anyInt())).thenReturn(IntStream.of(1, 2, 3));

        //WHEN
        var mouseEeaten = house.cleanHouse();

        //THEN
        assertEquals(6, mouseEeaten);
    }

    /**
     * - On peut capturer un argument passé à un mock afin de tester sa valeur lors d’une assertion,
     * avec la classe “ArgumentCaptor”
     * - La méthode “.capture()” peut être passée comme un "Matcher" lors de l'appel à la méthode “when”
     * - On peut ensuite récupérer la valeur avec ".getValue()" pour réaliser une assertion
     */
    @Captor
    ArgumentCaptor<Integer> argumentCaptor;
    @Test
    public void shouldCleanHousePredictableV2() {
        //GIVEN
        Mockito.when(mouseHoleMock.getMouses(Mockito.anyInt())).thenReturn(IntStream.of(1, 2, 3));
        Mockito.when(mouseHoleMock.refill(argumentCaptor.capture())).thenReturn(42);//pourquoi 42 ?

        //WHEN
        var mouseEeaten = house.cleanHouse();

        //THEN
        assertEquals(6, mouseEeaten);
        assertEquals(3 , argumentCaptor.getValue());
        //assertEquals(Integer.valueOf("3"), argumentCaptor.getValue());
    }

    @Test
    public void shouldCleanHousePredictableV3() {
        //GIVEN
        Mockito.when(mouseHoleMock.getMouses(Mockito.anyInt())).thenReturn(IntStream.of(1, 2, 3));

        //WHEN
        var mouseEeaten = house.cleanHouse();

        //THEN
        assertEquals(6, mouseEeaten);
        Mockito.verify(mouseHoleMock).refill(3);
    }

}