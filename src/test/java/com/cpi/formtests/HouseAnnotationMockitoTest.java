package com.cpi.formtests;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HouseAnnotationMockitoTest {

    @Mock
    MouseHole mouseHoleMock = Mockito.mock(MouseHole.class);

    @InjectMocks
    House house;

    public void shouldCleanHousePredictable() {
        //GIVEN
        Mockito.when(mouseHoleMock.getMouses(Mockito.anyInt())).thenReturn(IntStream.of(1, 2, 3));

        //WHEN
        var mouseEeaten = house.cleanHouse();

        //THEN
        assertEquals(6, mouseEeaten);
    }

}
